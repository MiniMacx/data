package com.zf.action;

import java.sql.SQLException;
import java.util.List;

import java.util.Map;

import com.zf.dao.studentdao;
import com.zf.model.student;

public class StudentAction {
	public student get(Integer user_id) throws SQLException{
   	 studentdao dao = new studentdao();
     return dao.get(user_id);
	}
	
     public void add(student student) throws Exception{
    	 studentdao dao = new studentdao();
    	 dao.addstudent(student);
     }
     
     public void edit(student student) throws Exception{
    	 studentdao dao = new studentdao();
    	 dao.updatestudent(student);
     }
     public void del(Integer user_id) throws Exception{
    	 studentdao dao = new studentdao();
    	 dao.delstudent(user_id);
     }
     
   public List<student> query() throws Exception {
    	 studentdao dao = new studentdao();
    	return  dao.query();
    }
     
     public List<student>  query(List<Map<String,Object>>params) throws Exception{
    	 studentdao dao = new studentdao();
       return dao.query(params);
     }


	
	
	
	
	
	
	

     
}
