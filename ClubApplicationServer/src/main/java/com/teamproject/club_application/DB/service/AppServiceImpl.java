package com.teamproject.club_application.DB.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamproject.club_application.DB.iDaoMobile;
import com.teamproject.club_application.data.Album;
import com.teamproject.club_application.data.Club;
import com.teamproject.club_application.data.ClubMemberClass;
import com.teamproject.club_application.data.ClubView;
import com.teamproject.club_application.data.CommentView;
import com.teamproject.club_application.data.Image;
import com.teamproject.club_application.data.Post;
import com.teamproject.club_application.data.PostFrame;
import com.teamproject.club_application.data.PostView;
import com.teamproject.club_application.data.Tag;

@Service("ApplicationService")
public class AppServiceImpl implements AppService {
	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Transactional
	@Override
	public Long insertClub(Image image, Club club) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		if (image != null) {
			dao.insertImage(image);
			club.setImage_id(image.getId());
		} else {
			club.setImage_id(-1);
		}
		dao.insertClub(club);
		dao.joinClub(club.getId(), club.getMember_id(), "Y");
		dao.makeClubProfile(club.getId(), club.getMember_id());
		return club.getId();
	}

	// 비로그인 비회원 대기 회원 관리자
	// 'O'ut 'N'o 'W'ait 'Y'es 'A'dmin
	@Transactional
	@Override
	public ClubMemberClass selectClub(Long club_id, Long user_id) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		ClubMemberClass clubMemberClass;
		ClubView club = dao.selectClub(club_id);
		String memberClass = dao.selectClubMemberClass(club_id, user_id);
		if (memberClass == null) {
			if (user_id == -1L) {
				memberClass = "O";
			} else {
				memberClass = "N";
			}
		} else if (memberClass.equals("Y")) {
			if (club.getMember_id() == user_id) {
				memberClass = "A";
			}
		} else {
			memberClass = "W";
		}

		clubMemberClass = new ClubMemberClass(club, memberClass);

		return clubMemberClass;
	}

	@Transactional
	@Override
	public void joinClub(Long club_id, Long user_id) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		dao.joinClub(club_id, user_id, "N");
		dao.makeClubProfile(club_id, user_id);
	}

	@Transactional
	@Override
	public ArrayList<PostFrame> selectBoardView(Long club_id, int page) {
		System.out.println("start "+club_id);
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		ArrayList<PostFrame> items = new ArrayList<PostFrame>();
		ArrayList<PostView> post = dao.selectClubPost(club_id, page);
		
		for (int i = 0; i < post.size(); ++i) {
			System.out.println(post.get(i).toString());
			String imgUrl = dao.selectUserProfileImg(club_id, post.get(i).getMember_id());
			if (imgUrl == null) {
				imgUrl = "";
			}
			post.get(i).setImgUrl(imgUrl);

			ArrayList<CommentView> comments = dao.selectPostComment(post.get(i).getId(), 1, 4);
			if (comments != null && comments.size() > 0) {
				for (int j = 0; j < comments.size(); ++j) {
					String imgUrlComment = dao.selectUserProfileImg(club_id, comments.get(j).getMember_id());
					if (imgUrl == null) {
						imgUrlComment = "";
					}
					comments.get(j).setImgUrl(imgUrlComment);
				}
			}
			PostFrame postFrame = new PostFrame(1, post.get(i), comments);

			items.add(postFrame);
		}
		

		return items;
	}

	@Transactional
	@Override
	public void insertPost(ArrayList<Image> images, Post post, String tag, boolean check) {
		iDaoMobile dao = sqlSession.getMapper(iDaoMobile.class);
		String[] tags = null;
		if (tag!=null && !tag.isEmpty()) {
			tags = tag.trim().split(",");
		}
		ArrayList<Tag> tagList = new ArrayList<Tag>();

		dao.insertPost(post);
		if (tags != null) {
			for (String currTag : tags) {
				Tag tagObject = dao.selectTag(currTag);
				if(tagObject==null){
					tagObject = new Tag(0l, post.getClub_id(), currTag);
					dao.insertTag(tagObject);
				}
				dao.relationTag(tagObject.getId(), post.getId(), 0);
				tagList.add(tagObject);
			}
		}

		if (images != null && images.size() > 0) {
			for (int i = 0; i < images.size(); ++i) {
				Image image = images.get(i);
				dao.insertImage(image);

				dao.relationPostImage(post.getId(), image.getId());

				if (check) {
					Album album = new Album(0l, post.getClub_id(), post.getMember_id(), image.getId(), "");
					dao.insertAlbum(album);

					if (tagList.size()>0) {
						for (Tag currTag : tagList) {
							dao.relationTag(currTag.getId(), album.getId(), 1);
						}
					}
				}
			}
		}

	}

}
