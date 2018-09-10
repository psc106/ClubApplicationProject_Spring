package com.teamproject.club_application;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.google.gson.Gson;
import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.DB.service.AppService;
import com.teamproject.club_application.authorized.MailService;
import com.teamproject.club_application.data.Alarm;
import com.teamproject.club_application.data.AlbumView;
import com.teamproject.club_application.data.CalendarSchedule;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.Comment;
import com.teamproject.club_application.data.CommentView;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Member;
import com.teamproject.club_application.data.MemberView;
import com.teamproject.club_application.data.Notice;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.PostView;
import com.teamproject.club_application.data.Schedule;
import com.teamproject.club_application.data.TestData;
import com.teamproject.club_application.util.Util;

@Controller
public class MobileController {
	SqlSession sqlSession;
	JdbcTemplate template;

	@Resource(name = "MailAuthService")
	MailService mailService;
	@Resource(name = "ApplicationService")
	AppService appService;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@RequestMapping(value = "androidTest.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String testJson() {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);

		ArrayList<TestData> items = dao.getTestData();

		Gson gson = new Gson();

		return gson.toJson(items);
	}

	@RequestMapping(value = "test.do", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	@ResponseBody
	public String testImage(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		Gson gson = new Gson();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/upload/";
		String uploadPath = rootPath + attachPath;
		System.out.println(rootPath);
		System.out.println(attachPath);
		System.out.println(uploadPath);

		File dir = new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		String str = request.getParameter("description");
		System.out.println(str);
		Iterator<?> iter = multiRequest.getFileNames();
		MultipartFile file = null;
		while (iter.hasNext()) {
			String fileName = (String) (iter.next());
			file = multiRequest.getFile(fileName);
			String orgFileName;
			orgFileName = file.getOriginalFilename();
			if (orgFileName != null && !orgFileName.equals("")) {
				String ext = orgFileName.substring(orgFileName.lastIndexOf('.'));
				String saveFileName = Util.getRandomString() + ext;
				File serverFile = new File(uploadPath + "/" + saveFileName);
				try {
					file.transferTo(serverFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return gson.toJson("");
	}

	@RequestMapping(value = "test2.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String testImage2(HttpServletRequest request) {
		Gson gson = new Gson();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/upload/";
		String uploadPath = rootPath + attachPath;

		File dir = new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		File[] file = dir.listFiles();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < file.length; ++i) {
			String filePath = attachPath + file[i].getName();
			list.add(filePath);
		}

		return gson.toJson(list);
	}

	@RequestMapping(value = "mobile/getNoticeCount.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getNoticeCount_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}

		int item = dao.getNoticeCount(clubId);

		return gson.toJson(item);
	}

	// 여기서 이미지 저용량으로 처리해야함
	@RequestMapping(value = "mobile/selectClubNotice.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClubNotice_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String pageStr = request.getParameter("page");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (pageStr != null) {
			page = Integer.parseInt(pageStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<Notice> items = dao.selectClubNotice(clubId, page);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectClubProfileImg.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClubProfileImg_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String attachPath = "resources/upload/";
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		System.out.println(clubIdStr);

		if (dao.checkClubProfileImg(clubId) > 0) {
			Image item = dao.selectClubProfileImg(clubId);
			System.out.println(item);
			return gson.toJson(attachPath + item.getImg_db_name());
		} else {
			return gson.toJson(null);
		}
	}
	


	@RequestMapping(value = "mobile/getPostCount.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getPostCount_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}

		int item = dao.getPostCount(clubId);

		return gson.toJson(item);
	}
	
	@RequestMapping(value = "mobile/selectClubPost.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClubPost_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String pageStr = request.getParameter("page");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (pageStr != null) {
			page = Integer.parseInt(pageStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<PostView> items = dao.selectClubPost(clubId, page);

		return gson.toJson(items);
	}


	@RequestMapping(value = "mobile/getAlbumCount.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getAlbumCount_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}

		int item = dao.getAlbumCount(clubId);

		return gson.toJson(item);
	}
	
	@RequestMapping(value = "mobile/selectClubAlbum.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClubAlbum_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String pageStr = request.getParameter("page");
		Long clubId;
		Integer page;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (pageStr != null) {
			page = Integer.parseInt(pageStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<AlbumView> items = dao.selectClubAlbum(clubId, page);

		return gson.toJson(items);
	}
	


	@RequestMapping(value = "mobile/getCommentCount.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getCommentCount_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String postIdStr = request.getParameter("postId");
		Long postId;
		Integer page;
		Gson gson = new Gson();

		if (postIdStr != null) {
			postId = Long.parseLong(postIdStr);
		} else {
			return gson.toJson(null);
		}

		int item = dao.getCommentCount(postId);

		return gson.toJson(item);
	}

	@RequestMapping(value = "mobile/selectPostComment.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectPostComment_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String postIdStr = request.getParameter("postId");
		String pageStr = request.getParameter("page");
		Long postId;
		Integer page;
		Gson gson = new Gson();

		if (postIdStr != null) {
			postId = Long.parseLong(postIdStr);
		} else {
			return gson.toJson(null);
		}
		if (pageStr != null) {
			page = Integer.parseInt(pageStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<CommentView> items = dao.selectPostComment(postId, page);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectCurrPost.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectCurrPost_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String postIdStr = request.getParameter("postId");
		Long postId;
		Gson gson = new Gson();

		if (postIdStr != null) {
			postId = Long.parseLong(postIdStr);
		} else {
			return gson.toJson(null);
		}

		PostView items = dao.selectCurrPost(postId);

		return gson.toJson(items);
	}
	
	@RequestMapping(value = "mobile/selectPostImg.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectPostImg_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String postIdStr = request.getParameter("postId");
		Long postId;
		Gson gson = new Gson();

		if (postIdStr != null) {
			postId = Long.parseLong(postIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<String> items = dao.selectPostImg(postId);

		return gson.toJson(items);
	}
	
	@RequestMapping(value = "mobile/selectLoginUser.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectLoginUser_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("pw");
		Gson gson = new Gson();

		Member item = dao.selectLoginUser(loginId, loginPw);

		return gson.toJson(item);
	}

	@RequestMapping(value = "mobile/joinClub.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String joinClub_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String userIdStr = request.getParameter("userId");
		Long clubId, userId;
		Gson gson = new Gson();
		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
		appService.joinClub(clubId, userId);

		return gson.toJson("");
	}

	@RequestMapping(value = "mobile/selectJoinMember.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectJoinMember_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Gson gson = new Gson();
		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		ArrayList<MemberView> items = dao.selectJoinMember(clubId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectWaitingMember.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectWaitingMember_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		Long clubId;
		Gson gson = new Gson();
		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		ArrayList<MemberView> items = dao.selectWaitingMember(clubId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/refreshMemberInfo.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String refreshMemberInfo_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String idStr = request.getParameter("id");
		Long id = Long.parseLong(idStr);
		Gson gson = new Gson();

		Member item = dao.refreshLoginUser(id);

		return gson.toJson(item);
	}

	@RequestMapping(value = "mobile/checkId.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String checkId_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String id = request.getParameter("id");
		Gson gson = new Gson();

		Integer item = dao.checkId(id);

		return gson.toJson(item);
	}

	@RequestMapping(value = "mobile/selectMyAlarm.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyAlarm_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<Alarm> items = dao.selectMyAlarm(userId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectMyPost.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyPost_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<PostView> items = dao.selectMyPost(userId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectMyComment.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyComment_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<Comment> items = dao.selectMyComment(userId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectMySchedule.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMySchedule_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<Schedule> items = dao.selectMySchedule(userId);
		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/selectMyCalendar.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyCalendar_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		String yearStr = request.getParameter("year");
		String monthStr = request.getParameter("month");
		Long userId;
		Integer year;
		Integer month;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
		if (yearStr != null) {
			year = Integer.parseInt(yearStr);
		} else {
			return gson.toJson(null);
		}
		if (monthStr != null) {
			month = Integer.parseInt(monthStr);
		} else {
			return gson.toJson(null);
		}

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, 1);

		int week = cal.get(Calendar.DAY_OF_WEEK);
		int maxDay = cal.getActualMaximum(Calendar.DATE);

		ArrayList<CalendarSchedule> realItems = new ArrayList<CalendarSchedule>();

		for (int i = 1; i < week; ++i) {
			realItems.add(new CalendarSchedule());
		}
		String dateFormat = null;
		for (int i = 1; i <= maxDay; ++i) {
			cal.set(Calendar.DATE, i);
			dateFormat = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
			ArrayList<Schedule> tmpItems = dao.selectMyDaySchedule(userId, dateFormat);
			CalendarSchedule calendarSchedule = new CalendarSchedule(dateFormat, tmpItems);
			realItems.add(calendarSchedule);
		}

		return gson.toJson(realItems);
	}

	@RequestMapping(value = "mobile/selectMyGroup.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectMyGroup_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String userIdStr = request.getParameter("userId");
		Long userId;
		Gson gson = new Gson();

		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}

		ArrayList<Club> items = dao.selectMyClub(userId);

		return gson.toJson(items);
	}

	@RequestMapping(value = "mobile/insertMember.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String insertMember_toMobile(HttpServletRequest request) {
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String genderStr = request.getParameter("gender");
		String local = request.getParameter("local");
		String phone = request.getParameter("phone");
		int gender;
		Gson gson = new Gson();
		if (genderStr != null) {
			gender = Integer.parseInt(genderStr);
		} else {
			return gson.toJson("fail");
		}
		Member member = new Member(-1, loginId, loginPw, name, birthday, gender, local, phone, "N");
		mailService.authCreate(member);
		return gson.toJson("");
	}

	@RequestMapping(value = "mobile/findId.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String findId_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String id = request.getParameter("id");

		Gson gson = new Gson();
		String check = dao.selectFindId(id);
		return gson.toJson(id);
	}

	@RequestMapping(value = "mobile/findPw.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String findPw_toMobile(HttpServletRequest request) {
		String id = request.getParameter("id");
		mailService.findPw(id);
		Gson gson = new Gson();
		return gson.toJson("");
	}

	@RequestMapping(value = "mobile/getResultCount.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String getResultCount_toMobile(HttpServletRequest request) {
		String conditionStr = request.getParameter("main");
		String conditionLocal = request.getParameter("local");
		String conditionCategoryStr = request.getParameter("category");

		int conditionCategory = -1;
		if (conditionCategoryStr != null && !conditionCategoryStr.equals("")) {
			conditionCategory = Integer.parseInt(conditionCategoryStr);
		}

		ArrayList<Club> clubs = new ArrayList<Club>();
		String preQuery = "SELECT count(*) FROM club C where 1=1 ";
		if (conditionStr != null && !conditionStr.equals("")) {
			preQuery += " and (C.Name like '%" + conditionStr + "%' or C.Intro like '%" + conditionStr + "%') ";
		}
		if (conditionLocal != null && !conditionLocal.equals("") && !conditionLocal.equals("null")) {
			preQuery += " and C.LOCAL like '%" + conditionLocal + "%' ";
		}
		if (conditionCategory != -1) {
			preQuery += " and C.CATEGORY_ID=" + conditionCategory;
		}

		Integer count = this.template.queryForObject(preQuery, Integer.class);

		Gson gson = new Gson();
		System.out.println(gson.toJson(count));
		return gson.toJson(count);
	}

	@RequestMapping(value = "mobile/selectClub.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClub_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String userIdStr = request.getParameter("userId");
		Long clubId;
		Long userId;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
		System.out.println(clubId);
		System.out.println(userId);
		ClubMemberClass item = appService.selectClub(clubId, userId);
		System.out.println(gson.toJson(item));
		return gson.toJson(item);
	}

	
	
	
	@RequestMapping(value = "mobile/refreshMemberClass.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String refreshMemberClass_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String clubIdStr = request.getParameter("clubId");
		String userIdStr = request.getParameter("userId");
		Long clubId;
		Long userId;
		Gson gson = new Gson();

		if (clubIdStr != null) {
			clubId = Long.parseLong(clubIdStr);
		} else {
			return gson.toJson(null);
		}
		if (userIdStr != null) {
			userId = Long.parseLong(userIdStr);
		} else {
			return gson.toJson(null);
		}
		System.out.println(clubId);
		System.out.println(userId);
		String item = dao.selectClubMemberClass(clubId, userId);
		System.out.println(gson.toJson(item));
		return gson.toJson(item);
	}

	@RequestMapping(value = "mobile/selectClubInPage.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String selectClubInPage_toMobile(HttpServletRequest request) {
		String conditionStr = request.getParameter("main");
		String conditionLocal = request.getParameter("local");
		String conditionCategoryStr = request.getParameter("category");
		String conditionPageStr = request.getParameter("page");
		int conditionPage = 1;
		if (conditionPageStr != null && !conditionPageStr.equals("")) {
			conditionPage = Integer.parseInt(conditionPageStr);
		}
		int conditionCategory = -1;
		if (conditionCategoryStr != null && !conditionCategoryStr.equals("")) {
			conditionCategory = Integer.parseInt(conditionCategoryStr);
		}

		ArrayList<Club> clubs = new ArrayList<Club>();
		String preQuery = "SELECT DISTINCT ID,CATEGORY_ID,MEMBER_ID,IMAGE_ID,NAME,LOCAL,MAX_PEOPLE,INTRO,CREATE_DATE FROM (SELECT C.*, ROW_NUMBER() OVER(ORDER BY rownum desc) RN from club C where 1=1 ";
		if (conditionStr != null && !conditionStr.equals("")) {
			preQuery += " and (C.Name like '%" + conditionStr + "%' or C.Intro like '%" + conditionStr + "%') ";
		}
		if (conditionLocal != null && !conditionLocal.equals("") && !conditionLocal.equals("null")) {
			preQuery += " and C.LOCAL like '%" + conditionLocal + "%' ";
		}
		if (conditionCategory != -1) {
			preQuery += " and C.CATEGORY_ID=" + conditionCategory;
		}
		preQuery += ") WHERE RN<=" + 10 * (conditionPage);
		if (conditionPage >= 2) {
			preQuery += " AND RN>" + 10 * (conditionPage - 1);
		}
		clubs.addAll(this.template.query(preQuery, new RowMapper<Club>() {
			public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
				Club club = new Club(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
				return club;
			}
		}));
		Gson gson = new Gson();
		System.out.println(gson.toJson(clubs));
		return gson.toJson(clubs);
	}

	@RequestMapping(value = "mobile/insertClub.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String insertClub_toMobile(HttpServletRequest request) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		Gson gson = new Gson();
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/upload/";
		String uploadPath = rootPath + attachPath;
		String categoryIdStr = request.getParameter("category");
		String userIdStr = request.getParameter("userId");
		String name = request.getParameter("name");
		String local = request.getParameter("local");
		String maxPeopleStr = request.getParameter("maxPeople");
		String intro = request.getParameter("intro");

		Long categoryId = null;
		Long userId = null;
		Integer maxPeople = null;
		System.out.println("?");
		if (categoryIdStr != null && !categoryIdStr.equals("")) {
			System.out.println("1");
			categoryId = Long.parseLong(categoryIdStr);
		}
		if (userIdStr != null && !userIdStr.equals("")) {
			System.out.println("2");
			userId = Long.parseLong(userIdStr);
		}
		if (maxPeopleStr != null && !maxPeopleStr.equals("")) {
			System.out.println("3");
			maxPeople = Integer.parseInt(maxPeopleStr);
		}
		if (categoryId == null || userId == null || maxPeople == null) {
			System.out.println("4");
			System.out.println(categoryId);
			System.out.println(userId);
			System.out.println(maxPeople);
			return gson.toJson(0);
		}

		File dir = new File(uploadPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<?> iter = multiRequest.getFileNames();
		MultipartFile file = null;
		Image image = null;
		System.out.println("start");
		while (iter.hasNext()) {
			String fileName = (String) (iter.next());
			file = multiRequest.getFile(fileName);
			String orgFileName;
			orgFileName = file.getOriginalFilename();

			if (orgFileName != null && !orgFileName.equals("")) {
				System.out.println(orgFileName);
				String ext = orgFileName.substring(orgFileName.lastIndexOf('.'));
				String saveFileName = Util.getRandomString() + ext;
				File serverFile = new File(uploadPath + "/" + saveFileName);
				try {
					file.transferTo(serverFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				image = new Image(0l, saveFileName, orgFileName);
			}
		}
		System.out.println(uploadPath);
		long returnValue = 0;
		returnValue = appService.insertClub(image,
				new Club(0l, categoryId, userId, 0l, name, local, maxPeople, intro, ""));
		return gson.toJson(returnValue);
	}
}