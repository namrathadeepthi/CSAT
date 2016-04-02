<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
       <%@  page import="csatdisplay.*"%>
          <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine">

<link rel="stylesheet" href="styles.css">
 
<title>Insert title here</title>
<style>

table, th, td {
    border: 1px solid black;
    padding: 2px;
 } 
 th,td
 {
 padding: 3px;
 }
 </style>
</head>
<body>
  <%-- <%@ include file="test2/home1.jsp" %>   --%>

<div id='cssmenu'>
<ul>

  <li>

    <a href="http://localhost:8081/Test/home1.jsp">

<span>Home</span></a>  </li>
   


 




</ul>

</div>

<% 

ArrayList<CsatQuest> displaylist= new ArrayList<CsatQuest>();
displaylist=(ArrayList<CsatQuest>)request.getAttribute("displayList");

/* CsatObjects ob=(CsatObjects)request.getAttribute("RetrievedOb"); */
String role=(String)request.getAttribute("ROLE");
%>
<br>
<center>
<span style=" font-family: 'Tangerine', serif;
        font-size: 48px"
   >
 <%
 CsatQuest ob= new CsatQuest();
 String temp1=" "; String temp2=" ";String temp3=" ";String temp4=" ";
 Iterator<CsatQuest> it= displaylist.iterator();
 if(it.hasNext())
 {
	  ob=it.next();
	 
 }
 
	
	%>		
			 	 
<br><b>Project: </b><%

out.print(ob.getProjectName());


%>
</span>
</center>
<!-- </div> -->


<br>
<span style=" font-family: 'Arial', serif;
        font-size: 20px">
        Sonata Project Manager:&nbsp;<b><%
        out.print(ob.getProjectManager());
        %>
        </b>
        </span>
<br>
<span style=" font-family: 'Arial', serif;
        font-size: 20px">
Customer Manager:&nbsp; <b><%
out.print(ob.getCustomerManager());


if(temp1.equals(ob.getRole())==false){
	 %>
	 <br><br>
	 <b> Role:</b>	 	
	 <%
	 	out.print(ob.getRole());
	 
	   

	}
%>
</b>
</span>
<br>
<br>
<br>
		<!-- </div> -->
		<div class="table-responsive">

<table style="border: 1px solid black">
		<thead>
        <tr  style="background-color: #C6E8FF">
            <th class="col-sm-5"><center>Parameters</center></th>
            <th class="col-sm-3"><center>Rating</center></th>
            <th class="col-sm-4"><center>Comments</center></th>
        
        </tr>
   	 	</thead>
   	 	
			
            <%

			
		 	
		 	char temp=' ';
			char qType;
			while(true){  
				
				/*
				q=rs1.getString("QuestionType");
			    qType=q.charAt(0); */
			    
			    qType=ob.getQuestionType();
				
				if(!(temp==qType))
				{
					%>
					<tr  style="background-color: #F2F2F2">
					<%
					
					switch(qType)
					{
					case 'p' : %>
					
		            <th ><br><center>PerformanceParameters<br><br></center></th>
		            
		            <% break; 
					case 't' : %>
					
		            <th ><br><center>Team<br><br></center></th>
		            
		            <% break; 
					
					
				case 'o' : %>
				
	            <th ><br><center>OverAll<br><br></center></th>
	            
	            <% break; 
				
				}
					%>
					<th><br>5- Excellent 4- Good 3- Satisfactory 4- Somewhat Satisfactory 5-Not Satisfactory<br></th>
		             <th> </th> 
		            </tr>
		            <%
				}
				temp=qType;
				%>
				
		
            
			<tr >

			<td style="border: 1px solid black">
			
			<%
			//out.print(rs1.getString(2)); 
			
			out.print(ob.getQuestions());
			   
			%>
			
			</td>

            
		   <%  
			//if(ratings[i]==5)
			 if(ob.getRating()==5)
			{
				
			%>
		     	<td class="bg-success"> <center>
		     	
		     	<%  out.print(ob.getRating());
		     	%>
		     	</center>
			
			</td>
			
			<%} 
			else if(ob.getRating()<=2)
			{
				
			%>
		     	<td class="bg-danger"> <center>
		     	
		     	<%  out.print(ob.getRating());
		     	%>
		     	</center>
			
			</td>
			<%}
			else
			{
				%>						
				<td style="border: 1px solid black"><center>
				<%  out.print(ob.getRating());
				
				%>
				</center>
			
			</td>
				
			<% } %>
					<td style="border: 1px solid black">
			        <center>
			<% 
			    out.print(ob.getComment()); 
				//i++;			   
			%>
			</center>
			</td>
					
			
			</tr>
			
			
			<%
			
			
			if(it.hasNext())
			{
				//out.print(temp1);
				temp1=ob.getRole();
				
				temp2=ob.getProjectName();
				temp3=ob.getCustomerManager();
				temp4=ob.getProjectManager();
				//out.print(temp1);
				ob=it.next();
				if(temp1.equals(ob.getRole())==false||temp2.equals(ob.getProjectName())==false||temp3.equals(ob.getCustomerManager())==false||temp4.equals(ob.getProjectManager())==false){
					
					if(temp2.equals(ob.getProjectName())==false)
					{
						%>
						 <thead>
	           				<tr  style="background-color:   #F5F5DC ">
	           				<th class="col-sm-5"></th>
	           				 <th class="col-sm-5"><center><h2>Project:
	           				<% out.println(ob.getProjectName()); %>
	           				</h2>
	           				</center></th>
	           				<th class="col-sm-5"></th>
	            			        
	      				  </tr>
	   	 				</thead>
						
				<% }
					
					 
					 %>
					
					 
					 
					 
					 
					  <thead>
           				<tr  style="background-color:   #F0F0F0 ">
           				<th class="col-sm-5"></th>
           				 <th class="col-sm-5"><center><h3>Role:
           				<% out.println(ob.getRole()); %>
           				</h3>
           				</center></th>
           				<th class="col-sm-5"></th>
            			        
      				  </tr>
   	 				</thead>
   	 				<%
   	 				if(temp2.equals(ob.getProjectManager())==false)
					{
						%>
   	 				<thead>
           				<tr  style="background-color:  #F5F5DC ">
           				<th class="col-sm-5"></th>
           				 <th class="col-sm-5"><center><h4>Sonata Project Manager:
           				<% out.println(ob.getProjectManager()); %>
           				</h4>
           				</center></th>
           				<th class="col-sm-5"></th>
            			        
      				  </tr>
   	 				</thead>
   	 				
   	 				
   	 				<%  }
   	 				
   	 				if(temp3.equals(ob.getCustomerManager())==false)
					{
						%>
						 <thead>
	           				<tr  style="background-color:   #F0F0F0 ">
	           				<th class="col-sm-5"></th>
	           				 <th class="col-sm-5"><center><h4>CustomerManager:
	           				<% out.println(ob.getCustomerManager()); %>
	           				</h4>
	           				</center></th>
	           				<th class="col-sm-5"></th>
	            			        
	      				  </tr>
	   	 				</thead>
						
				<% } %>
					 <thead>
           				<tr  style="background-color: #C6E8FF">
           				 <th class="col-sm-5"><center>Parameters</center></th>
           				 <th class="col-sm-3"><center>Rating</center></th>
            			<th class="col-sm-4"><center>Comments</center></th>
        
      				  </tr>
   	 				</thead>
					
					<%
					 
					
					 
				}
			}
			else
			{
				break;
			}
			
			
			
			}
			            
					
			%>
  </table>
  </div>





</body>
</html>