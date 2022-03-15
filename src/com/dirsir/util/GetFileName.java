package com.dirsir.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class GetFileName {
	public static String getFilName(HttpServletRequest request) {
		String fileName = "";
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		fileName = df.format(date);//取得了时间戳
		for(int i = 0;i<3;i++) {
			int d = (int) Math.round((Math.random()*10));
			fileName += d;
		}
		String addr = request.getRemoteAddr().replaceAll("\\.", "");
		String newIp=addr.replaceAll(":","");
		fileName += newIp;
		return fileName;
	}
}
