package com.zf.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.zf.model.*;
import com.zf.jdbc.JDBC;

import java.util.*;
public class studentdao {
    public void addstudent(student s) throws SQLException{
    	Connection conn = JDBC.getConnection();
    	String sql ="insert into user"+"(user_id,telephone,password,username,age)"+" values(?,?,?,?,?)";
    	PreparedStatement ptpm =conn.prepareStatement(sql);
    	ptpm.setInt(1,s.getUser_id());
    	ptpm.setString(2, s.getTelephone());
    	ptpm.setString(3,s.getPassword());
    	ptpm.setString(4, s.getUsername());
    	ptpm.setInt(5,s.getAge());
    	ptpm.execute();
    }
    public void updatestudent(student s) throws SQLException{
    	Connection conn = JDBC.getConnection();
    	String sql ="UPDATE user"+" SET telephone=?,password=?,username=?,age=?"+" WHERE user_id=?";
    	PreparedStatement ptpm =conn.prepareStatement(sql);
    	ptpm.setString(1,s.getTelephone());
    	ptpm.setString(2,s.getPassword());
    	ptpm.setString(3, s.getUsername());
    	ptpm.setInt(4,s.getAge());
    	ptpm.setInt(5,s.getUser_id());
    	ptpm.execute();
    }
    public void delstudent(Integer user_id) throws SQLException{
    	Connection conn = JDBC.getConnection();
    	String sql =" delete from user"+" where user_id=?";
    	PreparedStatement ptpm =conn.prepareStatement(sql);
    	ptpm.setInt(1,user_id);
    	ptpm.execute();
    }
    
    public List<student> query() throws Exception{
		List<student> result=new ArrayList<student>();
		Connection conn=JDBC.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select user_id,username,age,telephone from user  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		student s=null;
		while(rs.next()){
			s=new student();
			s.setUser_id(rs.getInt("user_id"));
			s.setTelephone(rs.getString("telephone"));
			s.setUsername(rs.getString("username"));
			s.setAge(rs.getInt("age"));
			result.add(s);
		}
		return result;
	}
    public List<student>query(List <Map<String,Object>>params) throws Exception{
    	List<student> result=new ArrayList<student>();
    	Connection conn = JDBC.getConnection();
    	StringBuilder sb = new StringBuilder();
    	sb.append("select * from user where 1=1");
    	
    	if(params!=null&&params.size()>0){
    		for(int i= 0;i<params.size();i++){
    			Map<String,Object> map=params.get(i);
    			sb.append(" and "  +map.get("name") +" "+map.get("rela")+" "+map.get("value")+" ");
    		}
    	}
    	
    	PreparedStatement ptmt = conn.prepareStatement(sb.toString());
    	
    	System.out.println(sb.toString());
    	
    	ResultSet rs = ptmt.executeQuery();
    	 
    	 student s=null;
    	 while(rs.next()){
    		 s=new student();
    		 s.setUser_id(rs.getInt("user_id"));
    		 s.setUsername(rs.getString("username"));
    		 s.setPassword(rs.getString("password"));
    		 s.setTelephone(rs.getString("telephone"));
    		 s.setAge(rs.getInt("age"));
    		
    		 result.add(s);
    	 }
    	return result;
    }
    public student get(Integer user_id) throws SQLException{
    	student s=null;
    	Connection conn = JDBC.getConnection();
    	String sql ="select *from user"+" where user_id=?";
    	PreparedStatement ptpm =conn.prepareStatement(sql);
    	ptpm.setInt(1,user_id);
    
    	ResultSet rs= ptpm.executeQuery();
    	while(rs.next()){
    		s=new student();
    		s.setUser_id(rs.getInt("user_id"));
    		s.setTelephone(rs.getString("telephone"));
    		s.setPassword(rs.getString("password"));
    		s.setUsername(rs.getString("username"));
    		s.setAge(rs.getInt("age"));
    		
    	}
    return s;
    
}
}
