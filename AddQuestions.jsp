<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<title>Insert title here</title>
</head>
<body>
<br><br>
<form class="form-horizontal" action="/Test/addQuest">

<div class="form-group">

        <label  class="control-label col-xs-4">Enter Question no</label>
   
        <div class="col-xs-6">

            <input type="text" class="form-control " name="QNo">

        </div>

    </div>
    
    <div class="form-group">

        <label  class="control-label col-xs-4">Enter Question </label>
   
        <div class="col-xs-6">

            <input type="text" class="form-control " name="Question">

        </div>

    </div>
    
    <div class="form-group">

        <label  class="control-label col-xs-4">Enter QuestionType </label>
   
        <div class="col-xs-6">

          <select name="QType">
        
        <option value="p">Performance Parameters</option>
        <option value="t">Team</option>
        <option value="o">Overall</option>
        
        </select> 

        </div>

    </div>
    
    <div class="form-group">

        <label  class="control-label col-xs-4">Enter role </label>
   
        <div class="col-xs-6">

          <select name="Role">
        
        <option value="r1">Role 1</option>
        <option value="r2">Role 2</option>
        <option value="r3">Role 3</option>
        
        </select> 

        </div>

    </div>
    
    
<div class="form-group">

        <div class="col-xs-offset-2 col-xs-10">
          <center><br><br><br><button type="submit" class="btn btn-primary">Submit</button>
          </center>
        </div>
 </div>
 </form>
    
</body>
</html>