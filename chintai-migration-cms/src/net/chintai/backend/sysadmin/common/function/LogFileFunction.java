package net.chintai.backend.sysadmin.common.function;

import java.util.List;

import org.springframework.util.CollectionUtils;


public class LogFileFunction {

	public static String sortFiles(List<String> files, String match) {

	    if (CollectionUtils.isEmpty(files)) {
	        return "";
	    }

	    for (String fileName : files) {

	        System.out.println("aaaaa" + fileName);

	        if (fileName.startsWith(match)) {

	            return fileName;
	        }
	    }
	    return "";
	}

}
