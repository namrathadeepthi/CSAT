

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csatdisplay.*;

/**
 * Servlet implementation class addQuest
 */
@WebServlet("/addQuest")
public class addQuest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 Connection connection = null;
		
		
		
		PrintWriter out = response.getWriter();
		
		try
		{
		
		
		  String sql1;
		  String q=request.getParameter("QNo");
		  String quest=request.getParameter("Question");
		  String qt=request.getParameter("QType");
		  String role=request.getParameter("Role");
		 
		  CsatQuestionsDisplay addOb= new CsatQuestionsDisplay();
		  addOb.addQuestions(q,quest,qt,role);
		  
		  
		  

     	 
		}
		catch(Exception e){ 
			
			System.out.println(e.getStackTrace());}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
