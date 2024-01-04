package com.inzent.ecm.confControl.service;

import java.io.File;

public class MakeDir {
	
	public File makeDir() {
		
		String path = "C://TEST/";
		
		File dir = new File(path);
		
		if (!dir.exists()) {
			try{
				dir.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
			    System.out.println("폴더가 생성완료.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("폴더가 이미 존재합니다..");
		}
	 
		return dir;
	}

}
