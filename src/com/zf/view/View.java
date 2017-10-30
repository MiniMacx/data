package com.zf.view;

import java.util.List;
import java.util.Scanner;

import com.zf.action.StudentAction;
import com.zf.dao.studentdao;
import com.zf.model.student;

public class View {
    private static final String CONTEXT="��ӭ����ѧ������ϵͳ:\n"+
          "������ѧ������ϵͳ�Ĺ����б�\n"+
    	  "[MAIN/M]:���˵�\n"+
          "[QUERY/Q]:�鿴ȫ��ѧ������Ϣ\n"+
    	  "[GET/G]:�鿴ĳλѧ������Ϣ\n"+
          "[ADD/A]:���ѧ����Ϣ\n"+
    	  "[UPDATE/U]:����ѧ����Ϣ\n"+
          "[DELETE/D]:ɾ��ѧ����Ϣ\n"+//"[SEARCH/S]:��ѯѧ����Ϣ������id �ֻ��Ų�ѯ��\n"+
          "[EXIT/E]:�˳�ѧ������ϵͳ\n"+
    	  "[BREAK/B]:�˳���ǰ���ܣ��������˵�\n";
	
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
    	while(scan.hasNext()){            //������ֵ��ѭ��
    		String in=scan.next().toString();
    		if(OPERATION_EXIT.equals(in.toUpperCase())||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
    			System.out.println("���ѳɹ��˳�");
    		break;}
    		else if(OPERATION_ADD.equals(in.toUpperCase())||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())||OPERATION_ADD.equals(prenious)){
    			prenious=OPERATION_ADD;
    			if(1==step){System.out.println("������ѧ����id��");
    			}
    			else if(2==step){
    				student.setUser_id(Integer.valueOf(in));//ǿ������ת�� ���루�ַ��������� �ַ���ͬ   ǿ��ת��������
    				System.out.println("������ѧ���ĵ绰��");
    			}
    			else if(3==step){
    				student.setTelephone(in);
    				System.out.println("������ѧ�������룺");
    			}
    			else if(4==step){
    				student.setPassword(in);
    				System.out.println("������ѧ����������");
    			}else if(5==step){
    				student.setUsername(in);
    				System.out.println("������ѧ�������䣺");
    			}else if(6==step){
    				student.setAge(Integer.valueOf(in));
    				try{
    					action.add(student);
    					System.out.println("����ѧ���ɹ�");
    					prenious =null;
 	                   step=1;}
    				catch(Exception e){
    					e.printStackTrace();
    					System.out.println("����ѧ��ʧ��");
    					}
    			}
    			if(OPERATION_ADD.equals(prenious)){
    			step++;}
    		}else if(OPERATION_DELETE.equals(in.toUpperCase())||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())||OPERATION_DELETE.equals(prenious)){
    			prenious=OPERATION_DELETE;
    			if(1==step){System.out.println("������Ҫɾ��ѧ����id��");
    			
    			}	
    			else if(2==step){
    				try{
    					student.setUser_id(Integer.valueOf(in));
    					action.del(Integer.valueOf(in));
    				System.out.println("ɾ��ѧ���ɹ�");
    				prenious =null;
	                step=1;
    				}
    				catch(Exception e){
    					e.printStackTrace();
    					System.out.println("ɾ��ѧ��ʧ��");
    					
    				}
    				
    			}
    			if(OPERATION_DELETE.equals(prenious)){
    	    			step++;}
    		}
    		else if(OPERATION_UPDATE.equals(in.toUpperCase())||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())||OPERATION_UPDATE.equals(prenious)){
    			prenious=OPERATION_UPDATE;
                  if(1==step){System.out.println("������Ҫ�޸�ѧ����id��");
    			
    			}
                  if(2==step){
                	  student.setUser_id(Integer.valueOf(in));
                	  System.out.println("��������ѧ���ĵ绰��");
                  }
                 
                  if(3==step){
                	  student.setTelephone(in);
                	  System.out.println("��������ѧ�������룺");
                  }
                  if(4==step){
                	  student.setPassword(in);
                	  System.out.println("��������ѧ�����û�����");
                  }
                  if(5==step){
                	  student.setUsername(in);
                	  System.out.println("��������ѧ�������䣺");
                  }
                  if(6==step){
                	  student.setAge(Integer.valueOf(in));
                	  
                	  try{
      					action.edit(student);
      					System.out.println("�޸�ѧ���ɹ�");
      					prenious =null;
 	                   step=1;}
      				catch(Exception e){
      					e.printStackTrace();
      					System.out.println("�޸�ѧ��ʧ��");
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
    				 System.out.println("������Ҫ��ѯѧ����id��");
     			
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
       					System.out.println("��ѯѧ��ʧ��");
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
    			   System.out.println("�˳���ǰ���ܣ��������˵�");
    			   System.out.println(CONTEXT);
    			} 
    		else if(OPERATION_QUERY.equals(in.toUpperCase())||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				try {
					List<student> list=action.query();
					for (student go : list) {
						System.out.println("user_id��"+go.getUser_id()+",������"+go.getUsername()+",���䣺"+go.getAge()+",�绰��"+go.getTelephone());
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}}
    		else{
				System.out.println("�������ֵΪ:"+in);				
			}
    		
    	}
    }
}
	

