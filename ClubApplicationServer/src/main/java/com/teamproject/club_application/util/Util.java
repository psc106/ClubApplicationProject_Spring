package com.teamproject.club_application.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;

public class Util {
	
	public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	
	/**
	 * ������� �����մϴ�.
	 * 250 x 150 ũ���� ������� ����ϴ�.
	 */
	private void makeThumbnail(String filePath, String fileName, String fileExt, HttpServletRequest request) throws Exception {
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		String attachPath = "resources/sumnail/";
		String sumnailPath = rootPath+attachPath;

	    // ����� �������Ϸκ��� BufferedImage ��ü�� �����մϴ�.
	    BufferedImage srcImg = ImageIO.read(new File(filePath));

	    // ������� �ʺ�� ���� �Դϴ�.
	    int dw = 250, dh = 150;
	    
	    // ���� �̹����� �ʺ�� ���� �Դϴ�.
	    int ow = srcImg.getWidth();
	    int oh = srcImg.getHeight();
	    
	    // ���� �ʺ� �������� �Ͽ� ������� ������ ���̸� ����մϴ�.
	    int nw = ow;
	    int nh = (ow * dh) / dw;
	    
	    // ���� ���̰� �������� ���ٸ� crop�� �ȵǹǷ�
	    // ���� ���̸� �������� ������� ������ �ʺ� ����մϴ�.
	    if(nh > oh) {
	        nw = (oh * dw) / dh;
	        nh = oh;
	    }
	  	
	    // ���� ũ��� �����̹����� ������� crop �մϴ�.
	    BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);

	    // crop�� �̹����� ������� �����մϴ�.
	    BufferedImage destImg = Scalr.resize(cropImg, dw, dh);
	    
	    // ������� �����մϴ�. �̹��� �̸� �տ� "THUMB_" �� �ٿ� ǥ���߽��ϴ�.
	    String thumbName = sumnailPath + "THUMB_" + fileName;
	    File thumbFile = new File(thumbName);
	    
	    ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
	}
}
