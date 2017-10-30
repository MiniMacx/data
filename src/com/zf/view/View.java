package com.zf.view;

import java.util.List;
import java.util.Scanner;

import com.zf.action.StudentAction;
import com.zf.dao.studentdao;
import com.zf.model.student;

public class View {
    private static final String CONTEXT="欢迎来到学生管理系统:\n"+
          "下面是学生管理系统的功能列表：\n"+
    	  "[MAIN/M]:主菜单\n"+
          "[QUERY/Q]:查看全部学生的信息\n"+
    	  "[GET/G]:查看某位学生的信息\n"+
          "[ADD/A]:添加学生信息\n"+
    	  "[UPDATE/U]:更新学生信息\n"+
          "[DELETE/D]:删除学生信息\n"+//"[SEARCH/S]:查询学生信息（根据id 手机号查询）\n"+
          "[EXIT/E]:退出学生管理系统\n"+
    	  "[BREAK/B]:退出当前功能，返回主菜单\n";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";				
	private static final String OPERATION_DELETE="DELETE";
	//private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args){
    	System.out.println(CONTEXT);
    	Scanner scan = new Scanner(System.in);
    	student student =new student();
    	StudentAction action = new StudentAction();
    	String prenious=null;
    	Integer  step=1;
    	while(scan.hasNext()){            //有输入值就循环
    		String in=scan.next().toString();
    		if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
    			System.out.println("您已成功退出");
    		break;}
    		else if(OPERATION_ADD.equals(in.toUpperCase())||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())||OPERATION_ADD.equals(prenious)){
    			prenious=OPERATION_ADD;
    			if(1==step){System.out.println("请输入学生的id：");
    			}
    			else if(2==step){
    				student.setUser_id(Integer.valueOf(in));//强制类型转换 输入（字符）到数字 字符不同   强制转换到数字
    				System.out.println("请输入学生的电话：");
    			}
    			else if(3==step){
    				student.setTelephone(in);
    				System.out.println("请输入学生的密码：");
    			}
    			else if(4==step){
    				student.setPassword(in);
    				System.out.println("请输入学生的姓名：");
    			}else if(5==step){
    				student.setUsername(in);
    				System.out.println("请输入学生的年龄：");
    			}else if(6==step){
    				student.setAge(Integer.valueOf(in));
    				try{
    					action.add(student);
    					System.out.println("新增学生成功");
    					prenious =null;
 	                   step=1;}
    				catch(Exception e){
    					e.printStackTrace();
    					System.out.println("新增学生失败");
    					}
    			}
    			if(OPERATION_ADD.equals(prenious)){
    			step++;}
    		}else if(OPERATION_DELETE.equals(in.toUpperCase())||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())||OPERATION_DELETE.equals(prenious)){
    			prenious=OPERATION_DELETE;
    			if(1==step){System.out.println("请输入要删除学生的id：");
    			
    			}	
    			else if(2==step){
    				try{
    					student.setUser_id(Integer.valueOf(in));
    					action.del(Integer.valueOf(in));
    				System.out.println("删除学生成功");
    				prenious =null;
	                step=1;
    				}
    				catch(Exception e){
    					e.printStackTrace();
    					System.out.println("删除学生失败");
    					
    				}
    				
    			}
    			if(OPERATION_DELETE.equals(prenious)){
    	    			step++;}
    		}
    		else if(OPERATION_UPDATE.equals(in.toUpperCase())||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())||OPERATION_UPDATE.equals(prenious)){
    			prenious=OPERATION_UPDATE;
                  if(1==step){System.out.println("请输入要修改学生的id：");
    			
    			}
                  if(2==step){
                	  student.setUser_id(Integer.valueOf(in));
                	  System.out.println("请输入新学生的电话：");
                  }
                 
                  if(3==step){
                	  student.setTelephone(in);
                	  System.out.println("请输入新学生的密码：");
                  }
                  if(4==step){
                	  student.setPassword(in);
                	  System.out.println("请输入新学生的用户名：");
                  }
                  if(5==step){
                	  student.setUsername(in);
                	  System.out.println("请输入新学生的年龄：");
                  }
                  if(6==step){
                	  student.setAge(Integer.valueOf(in));
                	  
                	  try{
      					action.edit(student);
      					System.out.println("修改学生成功");
      					prenious =null;
 	                   step=1;}
      				catch(Exception e){
      					e.printStackTrace();
      					System.out.println("修改学生失败");
      					 prenious =null;
  	                   step=1;
      					}
                  }
                 if(OPERATION_UPDATE.equals(prenious)){
  	    			step++;}
    		}
    		else if(OPERATION_GET.equals(in.toUpperCase())||OPERATION_GET.substring(0, 1).equals(in.toUpperCase())||OPERATION_GET.equals(prenious)){
    			prenious=OPERATION_GET;
    			 if(1==step){
    				 System.out.println("请输入要查询学生的id：");
     			
     			}
    			 if(2==step){
    				try{studentdao g=new studentdao();
    				    student s1=g.get(Integer.valueOf(in));
       					System.out.println(s1.toString());
       				 prenious =null;
	                   step=1;
       					}
       				catch(Exception e){
       					e.printStackTrace();
       					System.out.println("查询学生失败");
       				 prenious =null;
	                   step=1;
       					}
      			}
    			 if(OPERATION_GET.equals(prenious)){
   	    			step++;}
    			
    		}
    		
    		else if((OPERATION_MAIN.equals(in.toUpperCase()))
    			       || OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())){
    			   prenious =null;
    			   step=1;
    			   System.out.println(CONTEXT);
    			} 
    		else if ((OPERATION_BREAK.equals(in.toUpperCase()))
    			       || OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())) {
    			   prenious =null;
    			   step=1;
    			   System.out.println("退出当前功能，返回主菜单");
    			   System.out.println(CONTEXT);
    			} 
    		else if(OPERATION_QUERY.equals(in.toUpperCase())||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<student> list=action.query();
					for (student go : list) {
						System.out.println("user_id："+go.getUser_id()+",姓名："+go.getUsername()+",年龄："+go.getAge()+",电话："+go.getTelephone());
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}}
    		else{
				System.out.println("您输入的值为:"+in);				
			}
    		
    	}
    }
}
	

