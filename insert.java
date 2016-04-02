

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import javax.servlet.http.*;

import csatdisplay.CsatQuestionsDisplay;
import csatdisplay.DaoUtil;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		 PrintWriter out = response.getWriter(); 	 
		 
		 
		  try
		  {

			  
			  HttpSession session=request.getSession(false);  

			  String role=(String)session.getAttribute("roleId");
			  
ArrayList<String> qList= new ArrayList<String>();
			  
			  CsatQuestionsDisplay ob= new CsatQuestionsDisplay();
			  qList=ob.getQuestions(role);
	         Iterator<String> it= qList.iterator();
	         int i=1;
	         
	         while(it.hasNext()){
	        	 
	        	 String pMName=request.getParameter("inputProject");
	        	 String SMName=request.getParameter("inputProjectManager");
	        	 String CMName=request.getParameter("inputCustomerManager");
	        	 String qno=it.next();
	        	 String rating=request.getParameter(qno);	  
	        	 int rating1=Integer.parseInt(rating);
	        	 String cmt=request.getParameter(qno+""+qno);       	        	 
	        	 i++; 	 
	        	 ob.insertInDB(pMName,SMName, CMName, qno, rating1, cmt,role);
	        	 
	        	 
	         }
	        	  request.getRequestDispatcher("home1.jsp").include(request, response);
	   		   
	   		   out.println("<br>");
	   		   out.println("<br>");
	   		   out.println("<br>");
	   		   out.println("Response Submitted");
	   		  }
	   		 
	   		  catch (Exception ex)
	   		  {
	   		  System.out.println(ex);
	   		  }
	   	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
