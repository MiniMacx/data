package com.zf.test;

import com.zf.action.StudentAction;
import com.zf.dao.studentdao;
import com.zf.model.student;

public class TestAction {
          public static void main(String[] args) throws Exception{
        		StudentAction action = new StudentAction();
        		studentdao g=new studentdao();
        		student s=new student();
        	   student s1=g.get(2);
        	   System.out.println(s1.toString());
          }
}
