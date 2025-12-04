<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Records</title>
<style>

body{
margin: 0;
background-color: #d7c288;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

.search{
display: flex;
justify-content: space-between;
margin-top: 20px;
margin-bottom: 20px;
}

a{
text-decoration: none;
color: blue;

}

.Btn{

display: flex;
justify-content: center;

}

button{
    width: 150px;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background: #669999;
    font-size: 16px;
    color: #fff;
    cursor: pointer;

}

.det{

width:300px;
background-color: black;
color: white;
display: flex;
justify-content: center;
border-radius: 70px;
}

.emp{

display: flex;
justify-content: center;
background-color: #9d830b;
}

a:hover{
background-color: grey;


}

 .toaster {
            position: fixed;
            top: 10px;
            right: 20px;
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 5px;
            display: none; /* Initially hide toaster */
        }


</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<%

HttpSession sess = request.getSession();
sess.setAttribute("status1", "1");

%>


<div  class="toaster" id="del">
Employee Deleted
</div>

<div  class="toaster" id="empUp">
Employee Details Updated
</div>

<div class="emp">
<div class="det">
<h3>Employee Details</h3>
</div>
</div>
<div class="search">
<div class="sear">

<label for="searchColumn" style="font-weight: bold;">Search in: </label>
<select id="searchColumn">
  <option value="0">Emp_id</option>
  <option value="1">Emp_name</option>
  <option value="2">Designation</option>
  <option value="3">Department</option>
  <option value="4">Joined_date</option>
  <option value="5">Salary</option>
  <option value="6">Addressline1</option>
  <option value="7">Addressline2</option>
  <option value="8">City</option>
  <option value="9">State</option>
  <option value="10">Country</option>
</select>
<input type="text" id="searchInput" placeholder="Search">
</div>
<div>
 <label for="searchColumn" style="font-weight: bold;">Global Search:</label> <input type="text" id="searchInput1" placeholder="Search...">
</div>
</div>
 <table border="1" id="employeeTable">
        <tr>
            <th>Emp_id</th>
            <th>Emp_name</th>
            <th>Designation</th>
            <th>Department</th>
            <th>Joined_date</th>
            <th>Salary</th>
            <th>Addressline1</th>
            <th>Addressline2</th>
            <th>City</th>
            <th>State</th>
            <th>Country</th>
             <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
        List<List<String>> ans = new ArrayList<>();
        ans = (List) request.getAttribute("displayList");
        
        %>
        
        <% 
        if(ans!=null){
         int j=0;
        for (int i = 0; i < ans.size(); i++) {  
        	   j=0; %>
            <tr>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><%= ans.get(i).get(j++) %></td>
                <td><a style="color: black; font-weight: bold;"  href="updateEmployee?id=<%= ans.get(i).get(0) %>&status=1">Edit</a></td>
                 <td><a style="color: black;font-weight: bold;" href="DeleteEmployee?id=<%=ans.get(i).get(0)%>">Delete</a></td>
            </tr>
        <% } %>
       <%} %>  
    </table>
    <br>
    <div class="Btn">
    
    <form method="post" action="userDashboard.jsp">
     <button type="submit">Back</button>
    
    </form>
     <form method="post" action="addEmployee.jsp">

     <button type="submit">AddEmployee</button>

    </form>
    
    </div>

<script>

var deleteSuccess = <%= request.getAttribute("deleted") %>;
if (deleteSuccess) {
    // Show the toaster for 3 seconds
    var toaster = document.getElementById("del");
    toaster.style.display = "block";
    setTimeout(function() {
        toaster.style.display = "none";
    }, 3000); // 3 seconds
}

var empUpdated = <%= request.getAttribute("empUpdated") %>;
if (empUpdated) {
    // Show the toaster for 3 seconds
    var toaster = document.getElementById("empUp");
    toaster.style.display = "block";
    setTimeout(function() {
        toaster.style.display = "none";
    }, 3000); // 3 seconds
}

  // Function to filter the table rows based on the search input
  
  $(document).ready(function() {
    // Get the table and the input field
    var table = $("#employeeTable");
    var input = $("#searchInput1");

    // Add an event listener to the input field for handling the search
    input.on("keyup", function() {
        var searchValue = this.value.toLowerCase();
        // Loop through all rows in the table body
        table.find("tbody tr").each(function() {
            var row = $(this);
            var matchFound = false;
            // Loop through all columns in the row
            row.find("td").each(function() {
                var cellText = $(this).text().toLowerCase();
                if (cellText.includes(searchValue)) {
                    matchFound = true;
                    return false; // Break the inner loop if match found in any cell
                }
            });
            // Show or hide the row based on matchFound
            row.toggle(matchFound);
        });
    });
});
  
  
  function redirectToAdd(){
	  
	  window.location.href = "addEmployee.jsp";
  }
  
  
 function filterTable() {
    var input, filter, table, tr, td, i, columnIndex, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("employeeTable");
    tr = table.getElementsByTagName("tr");
    columnIndex = parseInt(document.getElementById("searchColumn").value);

    for (i = 1; i < tr.length; i++) { // Start from index 1 to skip the header row
      td = tr[i].getElementsByTagName("td")[columnIndex];

      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = ""; // Show the row if it matches the search query
        } else {
          tr[i].style.display = "none"; // Hide the row if it does not match the search query
        }
      }
    }
  }

  // Attach event listeners to trigger filtering when the search input or select changes
  document.getElementById("searchInput").addEventListener("keyup", filterTable);
  document.getElementById("searchColumn").addEventListener("change", filterTable);
</script>


</body>
</html>