package com.dirsir.util;

import java.io.File;

public class DoDeletFile {
	public static boolean doDeletFile(String path,String fileName) {
		boolean deleteFile=false;
		File file=new File(path+fileName);
		if(file.delete()) {
			deleteFile=true;
		}else {
			deleteFile=false;
		}
		return deleteFile;
	}
}
