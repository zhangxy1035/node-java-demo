package com.cn.test;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class PathToTree {
//	public static void main(String[] args) {
//	    String test = "E:";
////	    System.out.println(test);
//	    System.out.println(fileToJSONObject(new File(test)));
//}
	public static String DDD (String str) {
		JSONObject fin = fileToJSONObject(new File(str));
		return fin.toJSONString();
	}

	//
	public static JSONObject fileToJSONObject(File file) {
	    JSONObject jo = new JSONObject();
	    jo.put("fileName", file.getName());
//	    jo.put("path", file.getAbsolutePath());
	    jo.put("path", getFilePath(file.getPath()));
	    jo.put("obj_type", 20);
	    jo.put("children", "[]");
	    if (file.isFile()) {
	        jo.remove("children");
		    String fileName=file.getName();
		    if(fileName.contains(".")) {
		    	String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		    	if(fileTyle.equals(".c")) {
		    		jo.put("obj_type", 1);
		    	}else if(fileTyle.equals(".cpp")){
		    		jo.put("obj_type", 2);
		    	}else if(fileTyle.equals(".log")){
		    		jo.put("obj_type", 3);
		    	}else if(fileTyle.equals(".txt")){
		    		jo.put("obj_type", 4);
		    	}else if(fileTyle.equals(".json")){
		    		jo.put("obj_type", 5);
		    	}else if(fileTyle.equals(".pid")){
		    		jo.put("obj_type", 6);
		    	}else if(fileTyle.equals(".sqlite")){
		    		jo.put("obj_type", 7);
		    	}else if(fileTyle.equals(".md")){
		    		jo.put("obj_type", 8);
		    	}else if(fileTyle.equals(".o")){
		    		jo.put("obj_type", 9);
		    	}else if(fileTyle.equals(".h")){
		    		jo.put("obj_type", 10);
		    	}else {
		    		jo.put("obj_type", 11);
		    	}
		    }else {
		    	jo.put("obj_type", 19);
		    }
	    }
	    if (file.isDirectory()){
	        File[] files = file.listFiles();
	        List<JSONObject> joList = new ArrayList<JSONObject>(files.length);
	        for (File f : files) {
	            joList.add(fileToJSONObject(f));
	        }
	        jo.put("children", joList);
	    }
	    return jo;
	}
	public static String getFilePath(String str) {
		String[] strs=str.split("\\\\");
		String s = "";
		for(int i=3,len=strs.length;i<len;i++){

			if(i==(len-1)) {
				s += strs[i].toString()+"";
			}else {
				s += strs[i].toString()+"/";
			}
		}
		return s;

	}


}
