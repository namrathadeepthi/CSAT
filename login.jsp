<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css">
<script>
	function validateForm() {

		var username = document.forms["logingForm"]["uname"].value;
		var role = document.forms["logingForm"]["roleId"].value;

		if ((username == null || username == "") || (role == null || role == "")) {
			alert("All the fields are mandatory");
			return false;
		}

	}
	function ClearForm(){
	    document.logingForm.reset();
	    document.logingForm.uname.value="";
	}

</script>
</head>
<body onload="ClearForm();">

  <div class="container">
    <div class="login">
      <h1>Login to CSAT App</h1>
      <form  name="logingForm" action="validate" onsubmit="return validateForm()">
        Name:
        <p><input type="text" name="uname" ></p>
        Role ID:
        <select name="roleId">
        
        <option value="r1">Role 1</option>
        <option value="r2">Role 2</option>
        <option value="a">admin</option>
        
        </select> 
        
        <!-- 
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p> -->
        <center>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
        </center>
      </form>
    </div>

  
  </div>
</body>
</html>