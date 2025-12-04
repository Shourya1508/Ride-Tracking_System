<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="utils.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.management.remote.JMXConnectionNotification"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>

<style>
<
link href ="https: //fonts.googleapis.com /css ?family =Roboto:300, 400,
	500, 700 " rel ="stylesheet "> <link rel ="stylesheet " href ="https:
	//use.fontawesome.com /releases /v5.5.0 /css /all.css " integrity ="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU
	" crossorigin ="anonymous "> <style>html, body {
	min-height: 50%;
}

body, div, form, input, select, textarea, label, p {
	padding: 0;
	margin: 0;
	outline: none;
	font-family: Roboto, Arial, sans-serif;
	font-size: 14px;
	color: #666;
	line-height: 22px;
}

h1 {
	position: absolute;
	margin: 0;
	font-size: 34px;
	color: #fff;
	z-index: 2;
	line-height: 83px;
}

textarea {
	width: calc(100% - 12px);
	padding: 5px;
}

.testbox {
	display: flex;
	justify-content: center;
	height: inherit;
	width: 500px;
	padding: 20px;
}

.text {
	display: flex;
	justify-content: center;
	background-color: black;
	background-image: url("images/we.webp");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}


form {
	width: 100%;
	padding: 20px;
	border-radius: 6px;
	background: #fff;
	box-shadow: 0 0 8px #669999;
}

.banner {
	position: relative;
	height: 300px;
	background-image: url("images/we.webp");
	background-size: cover;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.banner::after {
	content: "";
	background-color: rgba(0, 0, 0, 0.2);
	position: absolute;
	width: 100%;
	height: 100%;
}

input, select, textarea {
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input {
	width: calc(100% - 10px);
	padding: 5px;
}

input[type="date"] {
	padding: 4px 5px;
}

textarea {
	width: calc(100% - 12px);
	padding: 5px;
}

.item:hover p, .item:hover i, .question:hover p, .question label:hover,
	input:hover::placeholder {
	color: #669999;
}

.item input:hover, .item select:hover, .item textarea:hover {
	border: 1px solid transparent;
	box-shadow: 0 0 3px 0 #669999;
	color: #669999;
}

.item {
	position: relative;
	margin: 10px 0;
}

.item span {
	color: red;
}



.item i, input[type="date"]::-webkit-calendar-picker-indicator {
	position: absolute;
	font-size: 20px;
	color: #a3c2c2;
}

.item i {
	right: 1%;
	top: 30px;
	z-index: 1;
}


label.radio {
	position: relative;
	display: inline-block;
	margin: 5px 20px 15px 0;
	cursor: pointer;
}

.question span {
	margin-left: 30px;
}

.question-answer label {
	display: block;
}

label.radio:before {
	content: "";
	position: absolute;
	left: 0;
	width: 17px;
	height: 17px;
	border-radius: 50%;
	border: 2px solid #ccc;
}

input[type=radio]:checked+label:before, label.radio:hover:before {
	border: 2px solid #669999;
}

label.radio:after {
	content: "";
	position: absolute;
	top: 6px;
	left: 5px;
	width: 8px;
	height: 4px;
	border: 3px solid #669999;
	border-top: none;
	border-right: none;
	transform: rotate(-45deg);
	opacity: 0;
}

input[type=radio]:checked+label:after {
	opacity: 1;
}

.flax {
	display: flex;
	justify-content: space-around;
}

.btn-block {
	margin-top: 10px;
	text-align: center;
}

button {
	width: 150px;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background: #669999;
	font-size: 16px;
	color: #fff;
	cursor: pointer;
}

button:hover {
	background: #a3c2c2;
}

@media ( min-width : 568px) {
	.name-item, .city-item {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
	}
	.name-item input, .name-item div {
		width: calc(50% - 20px);
	}
	.name-item div input {
		width: 97%;
	}
	.name-item div label {
		display: block;
		padding-bottom: 5px;
	}
	
	h1{
	color:#312433;}
}

.head{
display: flex;
justify-content: center;
}

.err{
margin:0;
display:flex;
justify-content: center;
color:red;
font-weight: bold;
}

.toggle-password {
        position: absolute;
        top: 50%;
        right: 5px;
        transform: translateY(-50%);
        cursor: pointer;
    }

</style>


</head>
<body>



<%

response.setHeader("X-XSS-Protection", "1; mode=block");
response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
response.setHeader("X-Content-Type-Options", "nosniff");
response.setHeader("X-Frame-Options", "DENY");

String namevalue=null;
String number_value=null;
String email_value=null;
String pass_value=null;
String cpass_value=null;


HttpSession ses = request.getSession(true);

int id = (int)ses.getAttribute("USER_ID");
try(Connection con = DbConnection.getConnection()){
	PreparedStatement ps = con.prepareStatement("select * from user_details where user_id = ?");
	ps.setInt(1, id);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		
		namevalue = rs.getString("user_name");
		number_value = rs.getString("mobile");
		email_value = rs.getString("email");
		pass_value = rs.getString("password");
		cpass_value = rs.getString("confirm_password");
		
		
	}
	
}


%>


<div class="text">
	
		<div class="testbox">
			<form id="registrationForm" method="post" action="updateUser" onsubmit="return validateForm();">
				<div class="banner">
					<h1>Update User Record</h1>
				</div>
				
				<div class="err">
					<h4 id="error-message">
						<%
						if (request.getAttribute("error") != null) {
						%>
						<%=request.getAttribute("error")%>
						<%
						}
						%>
					</h4>
				</div>
				
				<div class="item">
					<label for="name">Name<span>*</span></label> <input id="name"
						type="text" name="username"
						value="<%=namevalue == null ? "" : namevalue%>"> 
				</div>
				<div class="item">
					<label for="email">Email Address<span>*</span></label> <input
						id="email" type="email" name="email_"
						value="<%=email_value == null ? "" : email_value%>"> 
				</div>
				<div class="item">
					<label for="phone">Phone<span>*</span></label> <input id="phone"
						type="number" placeholder="(XXX) XXX-XXXX" name="mob"
						value="<%=number_value == null ? "" : number_value%>">
					
				</div>
				<div class="item">
					<label for="password">Password<span>*</span></label> <input type="password"
						id="password" type="text" name="pass"
						placeholder="Enter your password"
						value="<%=pass_value == null ? "" : pass_value%>">
						<i class="eye-icon toggle-password" onclick="togglePasswordVisibility()">&#128065;</i> <!-- Eye icon -->
						
				</div>
				<div class="item">
					<label for="conpass">Confirm Password<span>*</span></label> <input type="password"
						id="conpass" type="text" name="confirmpass"
						placeholder="Confirm password"
						value="<%=cpass_value == null ? "" : cpass_value%>">
						<i class="eye-icon toggle-password" onclick="togglePasswordVisibility1()">&#128065;</i> <!-- Eye icon -->
						 
				</div>
				<div class="btn-block">
					<button type="submit" name="action" value="up">Update</button>
					<button type="submit" name="action" value="back" >Back</button>
				</div>
			</form>
		</div>
	</div>

<script>
  var error = '<%= request.getAttribute("error") %>';

  if (error) {
    var fieldToFocus = '<%= request.getAttribute("setFocus") %>'; // Replace with the actual field ID
    document.getElementById(fieldToFocus).focus();
  }
  
  function togglePasswordVisibility() {
      var passwordField = document.getElementById('password');
      var eyeIcon = document.querySelector('.toggle-password');

      if (passwordField.type === 'password') {
          passwordField.type = 'text';
          eyeIcon.classList.remove('fa-eye');
          eyeIcon.classList.add('fa-eye-slash');
      } else {
          passwordField.type = 'password';
          eyeIcon.classList.remove('fa-eye-slash');
          eyeIcon.classList.add('fa-eye');
      }
  }
  
  function togglePasswordVisibility1() {
      var passwordField = document.getElementById('conpass');
      var eyeIcon = document.querySelector('.toggle-password');

      if (passwordField.type === 'password') {
          passwordField.type = 'text';
          eyeIcon.classList.remove('fa-eye');
          eyeIcon.classList.add('fa-eye-slash');
      } else {
          passwordField.type = 'password';
          eyeIcon.classList.remove('fa-eye-slash');
          eyeIcon.classList.add('fa-eye');
      }
  }
  
  function validateForm() {
	    var user = document.getElementById('name').value;
	    var email = document.getElementById('email').value;
	    var mob = document.getElementById('phone').value;
	    var pass = document.getElementById('password').value;
	    var cpass = document.getElementById('conpass').value;

	    var isValid = true;

	    if (!nameValidation(user)) {
	        isValid = false;
	        showError('Enter Valid Username', 'name');
	    }
	    else if (!emailValidation(email)) {
	        isValid = false;
	        showError('Enter Valid Email', 'email');
	    }

	    else if (!numberValidation(mob)) {
	        isValid = false;
	        showError('Enter a valid mobile number', 'phone');
	    }

	    else if (!passValidation(pass)) {
	        isValid = false;
	        showError('Set a Strong Password', 'password');
	    }

	    else if (pass !== cpass) {
	        isValid = false;
	        showError('Password does not match', 'conpass');
	    }


	    if (isValid) {
	        // If all validations pass, submit the form
	        document.getElementById('registrationForm').submit();
	    }
	    
	    return isValid;
	}

	function nameValidation(s) {
	    var regex = /^[a-zA-Z\s]+$/;
	    return regex.test(s);
	}

	function emailValidation(s) {
	    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	    return regex.test(s);
	}

	function numberValidation(s) {
	    var regex = /^[6-9]\d{9}$/;
	    return regex.test(s);
	}

	function passValidation(s) {
	    // Add your password validation logic here
	    // For example, at least 8 characters, at least one uppercase, one lowercase, and one number.
	    var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=])(?!.*\s).{8,32}$/;
	     return regex.test(s);
	     // return true;
	}

	
	function showError(errorMessage, fieldToFocus) {
	    var errorElement = document.getElementById('error-message');
	    var errorField = document.getElementById(fieldToFocus);

	    errorElement.textContent = errorMessage;
	    errorField.focus();
	}

function redirectToLogin() {
	    window.location.href = "userDashboard.jsp";
	}

  
</script>

</body>
</html>