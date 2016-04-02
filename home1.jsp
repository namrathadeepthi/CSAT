<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>
    
        <%@ page import="javax.servlet.http.*"%>
        <%@ page import="javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="styles.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   
<title>Insert title here</title>
<style>

body { font-size: 80%; font-family: 'Lucida Grande', Verdana, Arial, Sans-Serif; }
ul#tabs { list-style-type: none; margin: 30px 0 0 0; padding: 2 2 2.3em 2; }
ul#tabs li { display: inline; float: right; padding: 0 10px; }
ul#tabs li a { color: #42454a; background-color: #dedbde; border: 1px solid #c9c3ba; border-bottom: none; padding: 0.3em; text-decoration: none; }
ul#tabs li a:hover { background-color: #f1f0ee; }
ul#tabs li a.selected { color: #000; background-color: #f1f0ee; font-weight: bold; padding: 0.7em 0.3em 0.38em 0.3em; }
div.tabContent { border: 1px solid #c9c3ba; padding: 1.5em; background-color: #f1f0ee; }
div.tabContent.hide { display: none; }

</style>


</head>
<body>

<%

 HttpSession session=request.getSession(false);  
  String uName=session.getAttribute("username").toString();

   // String n=(String)session.getAttribute("roleId");  
    
//request.getAttribute("roleId") 

%>
<div id='cssmenu'>
<ul>
<%
if((session.getAttribute("roleId").toString().equalsIgnoreCase("a")))

{

%>
  <li class='active'>

      <a href="#">

<span>Home</span></a>  </li>
<%  } %>
   


 <%
		   if(!(session.getAttribute("roleId").toString().equalsIgnoreCase("a")))

			 {

			%>

<li>
<a href="http://localhost:8081/Test/displayQuestions">

<span>Fill CsatForm</span></a></li>
 
<% } %>

<%
		   if(session.getAttribute("roleId").toString().equalsIgnoreCase("a"))

			 {

			%>
   <li class='has-sub'><a href="#"><span>Retrieve Form info</span></a>
   <ul>
   
   <li><a href="Retrieval.jsp"><span>Specific project and Role</span></a></li>
   <li><a href="Retrieval.jsp"><span>Specific Project</span></a></li>
   <li><a href="retreiveByManager.jsp"><span>Specific To Manager</span></a></li>

    
   
   </ul>
   
   </li>
     
   <li><a href="AddQuestions.jsp"><span>Add Questions</span></a>
   <%  }   %>

</ul>


</div>






</body>
</html>