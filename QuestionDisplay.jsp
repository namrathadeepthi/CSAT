<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
        <%@ page import="java.sql.*" %>
        <%@  page import="csatdisplay.*"%>
         <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="java.util.Iterator"%>
<%@ page import="java.io.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<script>
	function validateForm() {


		var iPN = document.forms["questions"]["inputProject"].value;
		var iPMN = document.forms["questions"]["inputProjectManager"].value;
        var iCM= document.forms["questions"]["inputCustomerManager"].value;
        var x=document.getElementsByTagName("input");
        var f=1;
       
        for( var i=3; i<x.length; i=i+5)
        {    
        	var quest= x[i].name; 
        	
        	
        	
         	 var radios = document.getElementsByName(quest);
        	
        	
        	var ischecked_method = false;
        	
        	for ( var j = 0; j < radios.length; j++) {
        		
        	
        	    if(radios[j].checked) {
        	    	
        	    
        	        ischecked_method = true;
        	        break;
        	    } 
        	}
        	
        	if(!ischecked_method)   { //radio button is not checked
        		
        	    alert("Please choose a rating for "+quest);
        	   
        	    f=0;   
        	}
 
            
      
            
        }
       
		if ((iPN == null || iPN == "") || (iPMN == null || iPMN == "")|| (iCM == null || iCM == "")) {
			alert("Please check if ProjectName Sonata ProjectManager name and CustomerName are filled");
		   
			return false;
		}
		
		if(f==0)
	   {
			alert("all fields are mandatory fill");
			
			return false;
	   }
 			
	}
	function ClearForm(){
	    document.logingForm.reset();
	    document.logingForm.uname.value="";
	}

</script>
<style>

table, th, td {
    border: 1px solid black;
    padding: 3px;
 } 
 th,td
 {
 padding: 4px;
 }
</style>
<title>Insert title here</title>
</head> 
<body onload="ClearForm();">
<% 

    ArrayList<CsatQuest> qList=new ArrayList<CsatQuest>();

      qList=(ArrayList<CsatQuest>)request.getAttribute("QuestionsList");

      HttpSession session=request.getSession(false);  
      
      String uname=(String)session.getAttribute("username");
      
      %>

<div id='cssmenu'>
<ul>     

<li class="active"><a href="http://localhost:8081/Test/displayQuestions" ><span>CsatForm</span></a></li>

</ul>

</div>

<br>
<br>
<br>
<br>
     
 <!-- <div class="container"> -->

  
 <form name="questions" class="form-horizontal" action="insert" onsubmit="return validateForm()">
         <div class="container">
         <div class="row">
         
       <br>
       <br>
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <br>
				<br>
				<br>
                <div class="form-group">
                    <label for="InputName">Project/Application/Customer</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="inputProject" id="InputName" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputManager">Sonata Project Manager</label>
                    <div class="input-group">
                       <input type="text" class="form-control" name="inputProjectManager" id="InputName" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputCustomerManager">Customer Manager</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="inputCustomerManager" id="InputName" value=<%= uname %>>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
         
               
 
 
    		</div>
		</div>
		</div>	


<br>

 
   


<div class="table-responsive">

<table style="border: 1px solid black">
<thead>
        <tr  style="background-color: #C6E8FF">
            <th class="col-sm-5"><center>Parameters</center></th>
            <th class="col-sm-3"><center>Rating</center></th>
            <th class="col-sm-4"><center>Comments</center></th>
        
        </tr>
    </thead>
    
<!-- <tr  style="background-color: #F2F2F2">
            <th ><br><center>PerformanceParameters<br><br></center></th>
            <th>5- Excellent 4- Good 3- Satisfactory 4- Somewhat Satisfactory 5-Not Satisfactory</th>
            <th></th>
        
        </tr> -->
        <%
        Iterator<CsatQuest> it= qList.iterator();
/*         String[] qnos= ob.getQuestionNos(); 
        String[] questions=ob.getQuestions(); */
        char temp=' ';
		char qType;
        
        int i=0; int cmt=1;
        while(it.hasNext())
        {
         CsatQuest ob = it.next();
        	

			
		 	
		 	
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
        	<label class="col-md-8 control-label" for="radios1">
        	<% out.print(ob.getQuestions());  
        	   String q=ob.getQuestionNos();
        	           			
        		/* 	i++; */
        	%>
        	</label>
        	</td>


        	<td>
        	<div class="radio-inline">
        	  
        	  
        	  <label><input type="radio" name=<%= q %> value=1>1</label>
        	</div>
        	<div class="radio-inline">
        	  <label><input type="radio" name=<%= q %> value=2>2</label>
        	</div>
        	<div class="radio-inline">
        	  <label><input type="radio" name=<%= q %> value=3>3</label>
        	</div>
        	<div class="radio-inline">
        	  <label><input type="radio" name=<%= q %> value=4>4</label>
        	</div>
        	<div class="radio-inline">
        	  <label><input type="radio" name=<%= q %> value=5>5</label>
        	</div>
        	</td> 
        	<td>

        	  <textarea class="form-control"  name=<%= q+""+q %>></textarea>
        	  </td>

        	</tr>

        	<%

        	}
          %>
          
          
          </table>
</div> 
<br>
<br>
<br>
<div class="form-group">

        <div class="col-xs-offset-2 col-xs-10">
          <center><br><br><br><button type="submit" class="btn btn-primary">Submit</button>
          </center>
        </div>
   </div> 
   
    
</form>
</body>
</html>
