
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import csatdisplay.*;



import java.sql.*;

/**
 * Servlet implementation class CsatDB
 */
@WebServlet("/CsatDB1")
public class CsatDB1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CsatDB1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  PrintWriter out = response.getWriter();
		 
          String hiddenvalue=(String)request.getParameter("hidden");
          
		  
		  if(hiddenvalue.equals("ProjectName")){
			  
		  
		  
		  String enteredPName=request.getParameter("PName");
		  String rolevalue=request.getParameter("ROLE");
		  String role="";
		  
		  if(rolevalue.equals("all"))
		  {
			  
			  try
			  {
			  CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
			  ArrayList<CsatQuest> displayCsat=ob.getAllFromDB(enteredPName,rolevalue);
			  
			  String yourJSP = "/displayFinal.jsp";
			     
			  request.setAttribute("ROLE",role);
	  
			  request.setAttribute("displayList",displayCsat);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
			  rd.forward(request, response);
		 
			  
			  }
			  catch(Exception e){}
			  
			  
			  //***&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			
/*			  String []roles=new String[3];
			  roles[0]="r1";
			  roles[1]="r2";
			  roles[2]="r3";
			  int i=0;
			  while(i<3)
			  {
				  try
				  {
				  CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
				  ArrayList<CsatQuest> displayCsat=ob.getFromDB(enteredPName, roles[i]);
				  
				  Iterator<CsatQuest> itr= displayCsat.iterator();
				  if(itr.hasNext()==false)
				  {
						 
					    out.print("<script>");
					    out.print("alert(\"Dosent exist\")");
					    out.print("</script>");
						
					  
				  }
				  else
				  	{
				 
					  String yourJSP = "/displayFinal.jsp";
		     
					  request.setAttribute("ROLE",roles[i]);
			  
					  request.setAttribute("displayList",displayCsat);
					  RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
					  rd.forward(request, response);
				 
				  	}
				  }
				  catch(Exception e){}
				  i++;
			  }
				  
			  
*/				  
			  //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	  }
		  else
		  {
			  role=rolevalue;
			  
			  //&&&&&&&&&
		  
		/*  try
		  {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con =
		     (Connection) DriverManager.getConnection(
		        "jdbc:mysql://10.174.0.243:3306/invoice_test", "root", "Inv0ice@123");
	
		  PreparedStatement pstm = null;
		  PreparedStatement pstm1= null;
		  PreparedStatement pstm2,pstm3,pstm4=null;
		  String  sql,sql1;*/
		  
		 /* sql1="ALTER TABLE Csat4 ADD role varchar(50)";
		  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			 pstm1.execute();*/
		  /*
		  sql1=" CREATE TABLE UsersAndRoles  ( Role_ID varchar(20), User_Name varchar(30))";
		  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			 pstm1.execute();*/
		/*sql1="INSERT INTO UsersAndRoles VALUES ('a','admin')";
			 
			  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
				 pstm1.execute();
				 */
			 
		 /* sql1="ALTER TABLE CsatQuestions ADD role varchar(50)";
		  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			 pstm1.execute();*/
		  
	/*	 sql1="INSERT INTO CsatQuestions VALUES ('o1',' How satisfied are you with the overall service rendered by Sonata?','o')";
		 
		  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			 pstm1.execute();
			 */
		  /*sql="UPDATE CsatQuestions SET role='r1'";
		  pstm = (PreparedStatement) con.prepareStatement(sql);
			 pstm.execute();*/
		  /*sql1="DELETE FROM CSAT4 where ProjectName='namratha'";
		  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			 pstm1.execute();*/
		  
	//**********************************************************************************************
	/*	sql="select c.ProjectName, c.SonataProjectManager, c.CustomerManager,c.Rating,c.Comment, cq.Questions, cq.QuestionType from CSAT4 c, CsatQuestions cq where c.ProjectName='"+enteredPName+"'and c.role='"+role+"' and c.QNo=cq.QNo and c.role=cq.role";
		 pstm = (PreparedStatement) con.prepareStatement(sql);
		 ResultSet rs=pstm.executeQuery();
		 int []ratings=new int[30];
		 String []comments=new String[30];
		 int i=0;
		// CsatObjects ob= new CsatObjects();
		 ArrayList<CsatQuest> displayList =new ArrayList<CsatQuest>(); 
		 
		 if (!rs.isBeforeFirst() ) 
		 {    
          			 
			 response.sendRedirect("http://localhost:8081/Test/invalid.jsp");
						 
	     } 	 	
		 
		 else
		 {		 
		 
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
			 ratings[i]=r;
			 comments[i]=cmt;
			 displayList.add(ob);
			 
			 i++;
		 }
		 con.close();*/
		 //***************************************************************************************
		/* ob.setRating(ratings);
		 ob.setComment(comments);*/
		  
		  ///&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		  try
		  {
		  CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
		  ArrayList<CsatQuest> displayCsat=ob.getFromDB(enteredPName, role);
		  
		  Iterator<CsatQuest> itr= displayCsat.iterator();
		  if(itr.hasNext()==false)
		  {
				 
				 response.sendRedirect("http://localhost:8081/Test/invalid.jsp");
			  
		  }
		  else
		  	{
		 
			  String yourJSP = "/displayFinal.jsp";
     
			  request.setAttribute("ROLE",role);
	  
			  request.setAttribute("displayList",displayCsat);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
			  rd.forward(request, response);
		 
		  	}
		  }
		  catch(Exception e){}
		   
		  }
		  }
	///&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		 
		  /*}
		  catch (ClassNotFoundException e)
		  {
		  System.out.println(e);
		  }
		  catch (SQLException ex)
		  {
		  System.out.println(ex);
		  }*/
		  
		  else
		  {
			  try
			  {
				  String ManagerName=request.getParameter("MName");
			  CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
			  ArrayList<CsatQuest> displayCsat=ob.getByManager(ManagerName);
			  
			  String yourJSP = "/displayFinal.jsp";
			     
			  request.setAttribute("ROLE","none");
	  
			  request.setAttribute("displayList",displayCsat);
			  RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
			  rd.forward(request, response);
		 
			  
			  }
			  catch(Exception e){}
			  
		  }
		  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	

}
