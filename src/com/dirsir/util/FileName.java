package com.dirsir.util;

import java.util.Date;

public class FileName {
	public static  String getFileName(String ip) {
		long currentTime = new Date().getTime();
		String newIp = ip.replaceAll("\\.", "");//ipv4ȥִ.
		newIp = newIp.replaceAll(":", "");//ipv6ȥִ:
		String random = "";
		
		for(int i = 0 ;i <= 2 ;i++) {
			int x = (int) Math.round(Math.random()*(9-0+1) - 0);
			random += x;
		}
		return currentTime+random+newIp;
	}
}
