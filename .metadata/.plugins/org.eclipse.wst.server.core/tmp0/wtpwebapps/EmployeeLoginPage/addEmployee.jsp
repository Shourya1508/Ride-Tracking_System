<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	h1 {
		color: #312433;
	}
}

.head {
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
	String empvalue = (String) request.getAttribute("emp_id");
	String namevalue = (String) request.getAttribute("emp_name");
	String desigvalue = (String) request.getAttribute("designation");
	String depvalue = (String) request.getAttribute("department");
	String joined_date_value = (String) request.getAttribute("joined_date");
	String salaryvalue = (String) request.getAttribute("salary");
	String adr1_value = (String) request.getAttribute("addressline1");
	String adr2_value = (String) request.getAttribute("addressline2");
	String city_value = (String) request.getAttribute("city");
	String state_value = (String) request.getAttribute("state");
	String country_value = (String) request.getAttribute("country");
	String empV = (String) request.getAttribute("emp_idErr");
	String nameV = (String) request.getAttribute("emp_nameErr");
	String desigV = (String) request.getAttribute("desigErr");
	String depV = (String) request.getAttribute("depErr");
	String joinedV = (String) request.getAttribute("joined_dateErr");
	String salaryV = (String) request.getAttribute("salaryErr");
	String adr1V = (String) request.getAttribute("adr1Err");
	String adr2V = (String) request.getAttribute("adr2Err");
	String cityV = (String) request.getAttribute("cityErr");
	String stateV = (String) request.getAttribute("stateErr");
	String countryV = (String) request.getAttribute("countryErr");
	%>


	<div class="text">

		<div class="testbox">
			<form method="post" action="EmployeeDetails">
				<div class="banner">
					<h1>Add Employee</h1>
				</div>
				 <div class="err">
    <h4>
        <% if (request.getAttribute("error") != null) { %>
              <%= request.getAttribute("error") %>
        <% } %>
    </h4>
</div>
				<div class="item">
					<label for="id">Emp_Id<span>*</span></label> <input id="id"
						type="text" name="emp_id"
						value="<%=empvalue == null ? "" : empvalue%>"> <span
						class="error"> <%=empV == null ? "" : empV%>
					</span>
				</div>
				<div class="item">
					<label for="emp_name">Emp_Name<span>*</span></label> <input id="empname"
						type="text" name="emp_name"
						value="<%=namevalue == null ? "" : namevalue%>"> <span
						class="error"> <%=nameV == null ? "" : nameV%>
					</span>
				</div>
				<div class="item">
					<label for="desig">Designation<span>*</span></label> <input
						id="desig" type="text" placeholder="Designation"
						name="designation"
						value="<%=desigvalue == null ? "" : desigvalue%>"> <span
						class="error"> <%=desigV == null ? "" : desigV%>
					</span>
				</div>
				<div class="item">
					<label for="department">Department<span>*</span></label> <input
						id="dep" type="text" name="department"
						placeholder="Department"
						value="<%=depvalue == null ? "" : depvalue%>"> <span
						class="error"> <%=depV == null ? "" : depV%>
					</span>
				</div>
				<div class="item">
					<label for="j_d">Joined_date<span>*</span></label> <input
						id="j_d" type="date" name="joined_date" placeholder=""
						value="<%=joined_date_value == null ? "" : joined_date_value%>">
					<span class="error"> <%=joinedV == null ? "" : joinedV%>
					</span>
				</div>
				<div class="item">
					<label for="salary">Salary<span>*</span></label> <input
						id="sal" type="text" name="salary"
						placeholder="Salary"
						value="<%=salaryvalue == null ? "" : salaryvalue%>"> <span
						class="error"> <%=salaryV == null ? "" : salaryV%>
					</span>
				</div>
				<div class="item">
					<label for="adr1">Addressline1<span>*</span></label> <input
						id="adr1" type="text" name="addressline1"
						placeholder="Address_1"
						value="<%=adr1_value == null ? "" : adr1_value%>"> <span
						class="error"> <%=adr1V == null ? "" : adr1V%>
					</span>
				</div>
				<div class="item">
					<label for="adr2">Addressline2<span>*</span></label> <input
						id="adr2" type="text" name="addressline2"
						placeholder="Address_2"
						value="<%=adr2_value == null ? "" : adr2_value%>"> <span
						class="error"> <%=adr2V == null ? "" : adr2V%>
					</span>
				</div>
				<div class="item">
					<label for="city">City<span>*</span></label> <input
						id="ct" type="text" name="city"
						placeholder="city"
						value="<%=city_value == null ? "" : city_value%>"> <span
						class="error"> <%=cityV == null ? "" : cityV%>
					</span>
				</div>
				<div class="item">
					<label for="state">State<span>*</span></label> <input
						id="st" type="text" name="state"
						placeholder="State"
						value="<%=state_value == null ? "" : state_value%>"> <span
						class="error"> <%=stateV == null ? "" : stateV%>
					</span>
				</div>
				<div class="item">
					<label for="country">Country<span>*</span></label> <input
						id="con" type="text" name="country"
						placeholder="Country"
						value="<%=country_value == null ? "" : country_value%>">
					<span class="error"> <%=countryV == null ? "" : countryV%>
					</span>
				</div>
				<div class="btn-block">
					<button type="submit" name="action" value="add">Add</button>
					<button type="submit" name="action" value="back">Back</button>
				</div>
			</form>
		</div>
	</div>

<script>


const dateField = document.getElementById('j_d');

// Get the current date in YYYY-MM-DD format
const currentDate = new Date().toISOString().split('T')[0];

// Set the max attribute to the current date
dateField.setAttribute('max', currentDate);

  var error = '<%= request.getAttribute("error") %>';

  if (error) {
    var fieldToFocus = '<%= request.getAttribute("setFocus") %>'; // Replace with the actual field ID
    document.getElementById(fieldToFocus).focus();
  }
  
  
</script>

</body>
</html>