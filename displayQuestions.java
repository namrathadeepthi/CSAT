

import java.io.IOException;
import csatdisplay.*;
import javax.servlet.http.*;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csatdisplay.CsatQuestions;
import java.util.*;
import java.sql.*;
/**
 * Servlet implementation class displayQuestions
 */
@WebServlet("/displayQuestions")
public class displayQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 PrintWriter out = response.getWriter();
		 
		 
			//String enteredPName=request.getParameter("PName");
			 
		  HttpSession session=request.getSession(false);  

		  String role=(String)session.getAttribute("roleId");
		 
		  
		  
		  try
		  {
		    CsatQuestionsDisplay ob1 = new CsatQuestionsDisplay();
		    
		    ArrayList<CsatQuest> qList= ob1.displayQ(role);
		    
		    String yourJSP = "/QuestionDisplay.jsp";

			  
			request.setAttribute("QuestionsList",qList);
		      RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
		        rd.forward(request, response);
		        
		  }
		  catch(Exception e){}
		 
			 /* try
			  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con =
			     (Connection) DriverManager.getConnection(
			        "jdbc:mysql://10.174.0.243:3306/invoice_test", "root", "Inv0ice@123");
		
			  PreparedStatement pstm = null;
			  PreparedStatement pstm1= null;
			  PreparedStatement pstm2,pstm3,pstm4=null;
			  String  sql,sql1;
			  
			  HttpSession session=request.getSession(false);  

			  String role=(String)session.getAttribute("roleId");
			  sql1="select * from CsatQuestions where role='"+role+"'";
			  pstm1 = (PreparedStatement) con.prepareStatement(sql1);
			  ResultSet rs= pstm1.executeQuery();
			  int cmt=1;
			  String []questions=new String[30];
			  String []questionnos=new String[30];
				 int i=0;
				 CsatQuestions ob= new CsatQuestions();
				 
			  while(rs.next()){
				  
			  
				  String quest=rs.getString("Questions");
				  String qno=rs.getString("QNo");
				  questions[i]=quest;
				  questionnos[i]=qno;
				  i++;
				  
			  }
			  
			  
				 con.close();
				 
				 ob.setQuestions(questions);
				 ob.setQuestionNo(questionnos);
				 
			  String yourJSP = "/QuestionDisplay.jsp";

			  
				request.setAttribute("Ob",ob);
			      RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
			        rd.forward(request, response);
			  }
			  catch (ClassNotFoundException e)
			  {
			  System.out.println(e);
			  }
			  catch (SQLException ex)
			  {
			  System.out.println(ex);
			  }*/
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
