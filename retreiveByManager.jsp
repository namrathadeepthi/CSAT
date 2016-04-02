<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
</head>
<body>


<%-- <%@ include file="home.html" %> --%>


<div id='cssmenu'>
<ul>

  <li>

    <a href="http://localhost:8081/Test/home1.jsp">

<span>Home</span></a>  </li>
   


 




</ul>

</div>
<br>
<br>
<br>
<br>
<br>


<form class="form-horizontal" action="/Test/Test/Test/CsatDB1.java">

	<div class="form-group">

        <label  class="control-label col-xs-4">Enter ProjectManager Name:</label>
   
        <div class="col-xs-6">

            <input type="text" class="form-control " name="MName">

        </div>

    </div>
    
        <input type="hidden" id="thisField" name="hidden" value="Manager">
   
    
     <div class="form-group">

        <div class="col-xs-offset-2 col-xs-10">
          <center><br><br><br><button type="submit" class="btn btn-primary">Submit</button>
          </center>
        </div>
        
	 </div>
    
    
    </form>
    
   
    
    
</body>
</html>