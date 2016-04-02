

import java.io.*;
import javax.servlet.http.*;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import csatdisplay
.*;/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession s;
	    
		try
		{

			out.print("<script>");
		    out.print("alert(\"Please click on refresh\")");
		    out.print("</script>");
			
	
		String uname =request.getParameter("uname");
	    String role =request.getParameter("roleId");
	    Login loginOb = new Login();
	    
	    
	    
	    boolean accessstatus = loginOb .getUserAuthenticationDetails(uname,role);
	    
	   //boolean status=true;
  	    
	    if(accessstatus){
	    	/*
	    	 request.setAttribute("username",uname);
		  	  
	   	     request.setAttribute("roleId",role);*/
	    	
	   	     
	   	     s=  request.getSession();   
	    	 // response.sendRedirect("http://localhost:8081/Test/home1.jsp");
	   	     s.removeAttribute("roleId");
	   	     s.removeAttribute("uname");
	    	
	   	     s.setAttribute("username",uname);
	  	  
	   	     s.setAttribute("roleId",role);
	   	     
	    	 String yourJSP = "/home1.jsp";
	  	  
		     RequestDispatcher rd = getServletContext().getRequestDispatcher(yourJSP);
		        rd.forward(request, response);
	    }
	    else
	    {
			
	    	response.sendRedirect("http://localhost:8081/Test/login.jsp");
	    }
	    
		}
		catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
