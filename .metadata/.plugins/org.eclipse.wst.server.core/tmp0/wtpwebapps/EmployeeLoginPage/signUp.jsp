<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegistration Page</title>

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
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


</style>
</head>
<body>
	<%
	String nameV = (String) request.getAttribute("name");
	String numberV = (String) request.getAttribute("number");
	String emailV = (String) request.getAttribute("email");
	String passV = (String) request.getAttribute("password");
	String con_passV = (String) request.getAttribute("conPass");
	String namevalue = (String) request.getAttribute("user");
	String number_value = (String) request.getAttribute("mob_no");
	String email_value = (String) request.getAttribute("email_id");
	String pass_value = (String) request.getAttribute("pass");
	String cpass_value = (String) request.getAttribute("Cpass");
	%>
	
	<div class="text">
	
		<div class="testbox">
			<form method="post" action="Servlett">
				<div class="banner">
					<h1>User Registration</h1>
				</div>
							 <div class="err">
    <h4>
        <% if (request.getAttribute("error") != null) { %>
              <%= request.getAttribute("error") %>
        <% } %>
    </h4>
</div>
				<div class="item">
				
					<label for="name">Name<span>*</span></label> <input id="name"
						type="text" name="username"
						value="<%=namevalue == null ? "" : namevalue%>"> <span
						class="error"> <%=nameV == null ? "" : nameV%>
					</span>
				</div>
				<div class="item">
					<label for="email">Email Address<span>*</span></label> <input
						id="email" type="email" name="email_"
						value="<%=email_value == null ? "" : email_value%>"> <span
						class="error"> <%=emailV == null ? "" : emailV%>
					</span>
				</div>
				<div class="item">
					<label for="phone">Phone<span>*</span></label> <input id="phone"
						type="number" placeholder="(XXX) XXX-XXXX" name="mob"
						value="<%=number_value == null ? "" : number_value%>">
					<span class="error"> <%=numberV == null ? "" : numberV%>
					</span>
				</div>
				<div class="item">
					<label for="password">Password<span>*</span></label> <input
						id="password" type="password" name="pass"
						placeholder="Enter your password"
						value="<%=pass_value == null ? "" : pass_value%>">
						
						 <span
						class="error"> <%=passV == null ? "" : passV%>
					</span>
				</div>
				<div class="item">
					<label for="conpass">Confirm Password<span>*</span></label> <input
						id="conpass" type="password" name="confirmpass"
						placeholder="Confirm password"
						value="<%=cpass_value == null ? "" : cpass_value%>"> 
						
						<span
						class="error"> <%=con_passV == null ? "" : con_passV%>
					</span>
				</div>
				<div class="btn-block">
					<button type="submit" name="action" value="reg">Register</button>
					<button type="submit" name="action" value="log">Login</button>
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
  
  
</script>

</body>
</html>