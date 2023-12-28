package com.inzent.ecm.confControl.service;

import java.io.File;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class Delete {

	public void DeleteFile(File requestFile) { 
		File file = new File(requestFile.getAbsolutePath());
		
		if(file.exists()) {
			if(file.delete()){
    			System.out.println("파일삭제 성공");
    		}else{
    			System.out.println("파일삭제 실패");
    		}
    	}else{
    		System.out.println("파일이 존재하지 않습니다.");
    	}
        	

		}
		
	}

