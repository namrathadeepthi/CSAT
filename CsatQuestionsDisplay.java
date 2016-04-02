package csatdisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;


public class CsatQuestionsDisplay {
	
	public ArrayList<CsatQuest> displayQ( String role) throws Exception{
		
		
		  boolean accessstatus =false;
		  Connection connection = null;
		  ResultSet userdetailsresults=null;
		  
		  String query = "select * from CsatQuestions cq where role='"+role+"'ORDER BY cq.QuestionType DESC";
		  
		  ArrayList<CsatQuest>  questions= new ArrayList<CsatQuest>();	
		  
		  try{


			connection = DaoUtil.getMySqlDBConnection();


		    PreparedStatement pstm1 =connection.prepareStatement(query);
		    ResultSet rs= pstm1.executeQuery();
		    int cmt=1;
		  
			 int i=0;
		     
			
		    while(rs.next()){
			  CsatQuest ob= new CsatQuest();  
		  
			  String quest=rs.getString("Questions");
			  String qno=rs.getString("QNo");
			  String qType=rs.getString("QuestionType");
			  char qT=qType.charAt(0);
			  ob.setQuestions(quest);
			  
			  ob.setQuestionNo(qno);
			  ob.setQuestionType(qT);
			  questions.add(ob);
			  
			 
		  }
		  
		  
			 /*connection.close();*/
			 
		
		 
		  }
		  
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }

		  
		  return questions;
  }
	
	
	public void addQuestions(String q, String quest, String qType, String role)throws Exception
	{
		Connection connection = null;
		
	
		 try{
			 PreparedStatement pstm = null;
				
			  String sql1;


			 connection = DaoUtil.getMySqlDBConnection();

			 sql1 =
	                  "INSERT INTO CsatQuestions VALUES(?,?,?,?)";
			  

		               pstm = (PreparedStatement) connection.prepareStatement(sql1);
		               pstm.setString(1,q);
		               pstm.setString(2,quest);
		               pstm.setString(3,qType);
		               pstm.setString(4,role);
		               int status = pstm.executeUpdate();
		
	       }
		 catch (Exception ex)
		  {
		  System.out.println(ex);
		  }

	

	}
	
	
	
	public ArrayList<String> getQuestions(String role)throws Exception
	{
		
		ArrayList<String> qList= new ArrayList();
		  try
		  {

			Connection con1 = DaoUtil.getMySqlDBConnection();

	
			PreparedStatement pstm = null;
			PreparedStatement pstm1= null;
			PreparedStatement pstm2,pstm3,pstm4=null;
			String  sql,sql1, sql2,sql3,sql4;
	
		  
		  
		     sql="select * from CsatQuestions cq where role='"+role+"'ORDER BY  cq.QNo ASC, cq.QuestionType DESC";
		     
	         pstm = (PreparedStatement) con1.prepareStatement(sql);
	         ResultSet rs= pstm.executeQuery();
	      
	         while(rs.next())
	         {
	        	
	        	 qList.add(rs.getString(1));
	        	 
	        	        			 
	         }
	         
	      }
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }
		  
		  
		  return qList;
}
	
	
	
	public void insertInDB(String p, String s,String c, String qno, int rating ,String cmt,String role)throws Exception
	{
		
		try
		  {

			Connection con1 = DaoUtil.getMySqlDBConnection();

	
			PreparedStatement pstm = null;
			PreparedStatement pstm1= null;
			PreparedStatement pstm2,pstm3,pstm4=null;
			String  sql,sql1, sql2,sql3,sql4;
	
		  
			sql1="INSERT INTO CSAT4 VALUES('"+p+"','"+s+"','"+c+"','"+qno+"','"+rating+"','"+cmt+"','"+role+"')";
       	 	pstm1 = (PreparedStatement) con1.prepareStatement(sql1);
	        pstm1.executeUpdate(sql1);
	         
	         
	      }
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }
		  
		
	}
	
	public ArrayList<CsatQuest> getFromDB(String PName, String role) throws Exception
	{
		
		ArrayList<CsatQuest> displayList =new ArrayList<CsatQuest>(); 
		
		
		try
		  {

			Connection con = DaoUtil.getMySqlDBConnection();

	
			PreparedStatement pstm,pstm1 = null;
					
			String  sql; String sql1;
			
			/*
	        sql1="select * from CsatQuestions ORDER BY role,QuestionType";
	        pstm1 = (PreparedStatement) con.prepareStatement(sql1);
	        pstm1.executeQuery();*/

			
			
			sql="select c.ProjectName, c.SonataProjectManager, c.CustomerManager,c.Rating,c.Comment, cq.Questions, cq.QuestionType,cq.role from CSAT4 c, CsatQuestions cq where c.ProjectName='"+PName+"'and c.role='"+role+"' and c.QNo=cq.QNo and c.role=cq.role ORDER BY c.SonataProjectManager,cq.role ASC,cq.QuestionType DESC ";
			 pstm = (PreparedStatement) con.prepareStatement(sql);
			 ResultSet rs=pstm.executeQuery();
			 
			 
			// CsatObjects ob= new CsatObjects();
			 
			 
			 if (!rs.isBeforeFirst() ) 
			 {    
	          		
				 return displayList;
				// response.sendRedirect("http://localhost:8081/Test/invalid.jsp");
							 
		     } 	 	
			 
			 	 
			 
			 while(rs.next())
			 {
				 CsatQuest ob= new CsatQuest();
				 ob.setProjectName(rs.getString("ProjectName"));
				 ob.setProjectManager(rs.getString("SonataProjectManager"));
				 ob.setCustomerManager(rs.getString("CustomerManager"));
				 
				 String cmt=rs.getString("Comment");
				 
				 int r=rs.getInt("Rating");
				 String quest=rs.getString("Questions");

				 String	q=rs.getString("QuestionType");
				  char  qType=q.charAt(0);
				  
				 ob.setRating(r);
				 ob.setComment(cmt);
				 ob.setQuestions(quest);
				 ob.setQuestionType(qType);
				 ob.setRole(rs.getString("role"));
			/*	 ratings[i]=r;
				 comments[i]=cmt;*/
				 displayList.add(ob);
				 
				
			 }
	         
			   
			 
	      }
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }
		  
		return displayList;
		}
	
	public ArrayList<CsatQuest> getAllFromDB(String PName, String role)throws Exception
	{
		ArrayList<CsatQuest> displayListAll =new ArrayList<CsatQuest>(); 
		
		
		String []roles= new String[3];
		roles[0]="r1"; roles[1]="r2"; //roles[3]="r3";
		int i=0;
		CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
		while(i<2)
		{
			
			displayListAll.addAll(ob.getFromDB(PName,roles[i]));
			i++;
			
		}
		
		return displayListAll;
	}
		
	public ArrayList<CsatQuest> getByManager(String MName) throws Exception
	{
		
		ArrayList<CsatQuest> displayList =new ArrayList<CsatQuest>(); 
		
		
		try
		  {

			Connection con = DaoUtil.getMySqlDBConnection();

	
			PreparedStatement pstm,pstm1 = null;
					
			String  sql; String sql1;
			
			/*
	        sql1="select * from CsatQuestions ORDER BY role,QuestionType";
	        pstm1 = (PreparedStatement) con.prepareStatement(sql1);
	        pstm1.executeQuery();*/

			
			
			sql="select c.ProjectName, c.SonataProjectManager, c.CustomerManager,c.Rating,c.Comment, cq.Questions, cq.QuestionType,cq.role from CSAT4 c, CsatQuestions cq where c.SonataProjectManager='"+MName+"' and c.QNo=cq.QNo and c.role=cq.role ORDER BY c.ProjectName,cq.role ASC,cq.QuestionType DESC";
			 pstm = (PreparedStatement) con.prepareStatement(sql);
			 ResultSet rs=pstm.executeQuery();
			 
			 
			// CsatObjects ob= new CsatObjects();
			 
			 
			 if (!rs.isBeforeFirst() ) 
			 {    
	          		
				 return displayList;
				// response.sendRedirect("http://localhost:8081/Test/invalid.jsp");
							 
		     } 	 	
			 
			 	 
			 
			 while(rs.next())
			 {
				 CsatQuest ob= new CsatQuest();
				 ob.setProjectName(rs.getString("ProjectName"));
				 ob.setProjectManager(rs.getString("SonataProjectManager"));
				 ob.setCustomerManager(rs.getString("CustomerManager"));
				 
				 String cmt=rs.getString("Comment");
				 
				 int r=rs.getInt("Rating");
				 String quest=rs.getString("Questions");

				 String	q=rs.getString("QuestionType");
				  char  qType=q.charAt(0);
				  
				 ob.setRating(r);
				 ob.setComment(cmt);
				 ob.setQuestions(quest);
				 ob.setQuestionType(qType);
				 ob.setRole(rs.getString("role"));
			/*	 ratings[i]=r;
				 comments[i]=cmt;*/
				 displayList.add(ob);
				 
				
			 }
	         
			   
			 
	      }
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }
		  
		return displayList;
		}
	
	
	
}