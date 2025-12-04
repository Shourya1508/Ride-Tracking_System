<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<style>
*{
  margin:0;
  padding:0;
  -webkit-box-sizing:border-box;
  -moz-box-sizing:border-box;
  box-sizing:border-box;
}

body{
  font-family: 'Open Sans', sans-serif;
  background:#e2e2e2;
}

svg{
  position:fixed;
  top:10px;
  left:180px;
}

.container{
  position:relative;
  top:200px;
  left:35%;
  display:block;
  margin-bottom:80px;
  width:500px;
  height:400px;
  background:#fff;
  border-radius:5px;
  overflow:hidden;
  z-index:1;
}

h2{
  padding:40px;
  font-weight:lighter;
  text-transform:uppercase;
  color:#414141;
}

input{
  display:block;
  height:50px;
  width:90%;
  margin:0 auto;
  border:none;
  &::placeholder{
    -webkit-transform:translateY(0px);
      transform:translateY(0px);
    -webkit-transition:.5s;
      transition:.5s;
  }
  &:hover,
  &:focus,
  &:active:focus{
    color:#ff5722;
    outline:none;
    border-bottom:1px solid #ff5722;
    &::placeholder{
      color:#ff5722;
      position:relative;
      -webkit-transform:translateY(-20px);
      transform:translateY(-20px);
      
    }
  }
}



.email,
.pwd{
  position:relative;
  z-index:1;
  border-bottom:1px solid rgba(0,0,0,.1);
  padding-left:20px;
  font-family: 'Open Sans', sans-serif;
  color:#858585;
  font-weight:lighter;
  -webkit-transition:.5s;
  transition:.5s;
}



.link{
  text-decoration:none;
  display:inline-block;
  margin:27px 28%;
  color:#858585;
  font-weight:lighter;
  -webkit-transition:.5s;
  transition:.5s;
}



button{
  cursor:pointer; 
  display:inline-block;
  float:left;
  width:250px;
  height:60px;
  margin-top:-10px;
  border:none;
  font-family: 'Open Sans', sans-serif;
  text-transform:uppercase;
  color:#fff;
  -webkit-transition:.5s;
  transition:.5s;
 
    background:#673ab7;
  
  
  
  
  span{
    position:absolute;
    display:block;
    margin:-10px 20%;
    -webkit-transform:translateX(0);
    transform:translateX(0);
    -webkit-transition:.5s;
    transition:.5s;
  }
  &:hover{
    span{
      -webkit-transform:translateX(30px);
      transform:translateX(30px);
      }
   }
}

.reg{
    position:absolute;
    top:0;
    left:0;
    -webkit-transform:translateY(-100%) scale(1);
    transform:translateY(-100%) scale(1);
    display:block;
    width:20px;
    height:20px;
    border-radius:50px;
    background:#673ab7;
    z-index:5;
    -webkit-transition:.8s ease-in-out;
    transition:.8s ease-in-out;
  }



.sig{
   position:absolute;
   top:0;
   right:0;
   -webkit-transform:translateY(-100%) scale(1);
   transform:translateY(-100%) scale(1);
   display:block;
   width:20px;
   height:20px;
   display:block;
   background:#ff5722;
   z-index:5;
   -webkit-transition:.8s ease-in-out;
    transition:.8s ease-in-out;
}

h3{
  position:absolute;
  top:-100%;
  left:20%; 
  text-transform:uppercase;
  font-weight:bolder;
  color:rgba(255,255,255,.3);
  -webkit-transition:.3s ease-in-out 1.2s;
  transition:.3s ease-in-out 1.2s;
}

.error{
color:red;
font-weight: bold;
font-size: 14px;
}

.register{
background:#ff5722;
}

span{
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
<body>
<%

String emailvalue = (String) request.getAttribute("email");
String passvalue = (String) request.getAttribute("password");
String emailV = (String) request.getAttribute("emailErr");
String passV = (String) request.getAttribute("passErr");
String chan = (String) request.getAttribute("changed1");


%>

<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
	 width="800px" height="600px" viewBox="0 0 800 600" enable-background="new 0 0 800 600" xml:space="preserve">
<linearGradient id="SVGID_1_" gradientUnits="userSpaceOnUse" x1="174.7899" y1="186.34" x2="330.1259" y2="186.34" gradientTransform="matrix(0.8538 0.5206 -0.5206 0.8538 147.9521 -79.1468)">
	<stop  offset="0" style="stop-color:#FFC035"/>
	<stop  offset="0.221" style="stop-color:#F9A639"/>
	<stop  offset="1" style="stop-color:#E64F48"/>
</linearGradient>
<circle fill="url(#SVGID_1_)" cx="266.498" cy="211.378" r="77.668"/>
<linearGradient id="SVGID_2_" gradientUnits="userSpaceOnUse" x1="290.551" y1="282.9592" x2="485.449" y2="282.9592">
	<stop  offset="0" style="stop-color:#FFA33A"/>
	<stop  offset="0.0992" style="stop-color:#E4A544"/>
	<stop  offset="0.9624" style="stop-color:#00B59C"/>
</linearGradient>
<circle fill="url(#SVGID_2_)" cx="388" cy="282.959" r="97.449"/>
<linearGradient id="SVGID_3_" gradientUnits="userSpaceOnUse" x1="180.3469" y1="362.2723" x2="249.7487" y2="362.2723">
	<stop  offset="0" style="stop-color:#12B3D6"/>
	<stop  offset="1" style="stop-color:#7853A8"/>
</linearGradient>
<circle fill="url(#SVGID_3_)" cx="215.048" cy="362.272" r="34.701"/>
<linearGradient id="SVGID_4_" gradientUnits="userSpaceOnUse" x1="367.3469" y1="375.3673" x2="596.9388" y2="375.3673">
	<stop  offset="0" style="stop-color:#12B3D6"/>
	<stop  offset="1" style="stop-color:#7853A8"/>
</linearGradient>
<circle fill="url(#SVGID_4_)" cx="482.143" cy="375.367" r="114.796"/>
<linearGradient id="SVGID_5_" gradientUnits="userSpaceOnUse" x1="365.4405" y1="172.8044" x2="492.4478" y2="172.8044" gradientTransform="matrix(0.8954 0.4453 -0.4453 0.8954 127.9825 -160.7537)">
	<stop  offset="0" style="stop-color:#FFA33A"/>
	<stop  offset="1" style="stop-color:#DF3D8E"/>
</linearGradient>
<circle fill="url(#SVGID_5_)" cx="435.095" cy="184.986" r="63.504"/>
</svg>


<div class="container">
  <h2>login</h2>
 
 	 <div class="err">
    <h5>
    <% 
        if (request.getAttribute("error") != null) { %>
              <%= request.getAttribute("error") %>
        <% }
        if(request.getAttribute("success")!=null){%>
        <%= request.getAttribute("success") %>
        <% request.setAttribute("success",null); %>
        <% }
      
        %>
    </h5>
</div>
 
  <form method="post" action="UserLogin">
    <input id ="email_ID" type="text" class="email" placeholder="Email" name="email_id"
    value="<%= emailvalue == null ? "" : emailvalue %>">
    <div class="span">
<span class="error">
 <%= emailV == null ? "" : emailV %>
</span>
</div>
    <br/>
    <input type="password" class="pwd" placeholder="Password" name="password"
    value="<%= passvalue == null ? "" : passvalue %>">
    
    <div class="span">
<span class="error">
 <%= passV == null ? "" : passV %>
</span>
</div>
  
  <a href="userForgotPass.jsp" class="link">
    Forgot Password ?
  </a>
  <br/>
  <button class="signin">
    <span>Sign in</span>
  </button></form>
  <form method="post" action="signUp.jsp">
  <button class="register">
    <span>Register</span>
  </button>
  </form>
 

 
 
</div>
<script>




    var error = '<%= request.getAttribute("error") %>';

    if (error) {
      var fieldToFocus = '<%=request.getAttribute("setFocus")%> '; 
      // Replace with the actual field ID
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
    
    
    $(document).ready(() => {
  	  /*------- button with class register -------*/
  	  let reg_btn:string = $('.container .register')
  	  
  	  /*------- button with class sign in --------*/
  	  let sig_btn:string = $('.container .signin')
  	  
  	  /*------- back button ----------------------*/
  	  let back_btn:string = $('.container .back')
  	  

  	  

  	  reg_btn.click(function(e){
  	    e.preventDefault()
  	    $(this).siblings('.reg').css({
  	      'transform':'translateY(40%) scale(5)',
  	      'border-radius':'0',
  	      'width':'100%',
  	      'height':'100%'
  	    }).end();
  	    
  	  
  	    reg_btn.siblings('.container h3:nth-of-type(1)').css({
  	      'top':'40%',
  	      'z-index':'8',
  	    }).end().end();   
  	  });
  	  
  	   sig_btn.on('click',function(e){
  	    e.preventDefault();
  	    $(this).siblings('.sig').css({
  	      'transform':'translateY(40%) scale(5)',
  	      'border-radius':'0',
  	      'width':'100%',
  	      'height':'100%'
  	    }).end();
  	     
  	 
  	    sig_btn.siblings('.container h3:nth-of-type(2)').css({
  	      'top':'40%',
  	      'z-index':'8',
  	    }).end().end(); 
  	    
  	  });
  	});







</script>
</body>
</html>