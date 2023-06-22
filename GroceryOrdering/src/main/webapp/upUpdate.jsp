<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.*,com.profile.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<link rel="stylesheet" type="text/css" href="css/profile.css">
</head>
<body>
	<%  
// retrieve your list from the request, with casting 

	List<customerProfile> list = (List<customerProfile>)session.getAttribute("cusDetails");

%>

	<% 
		
	String fname ="";
	String lname ="";
	String address ="";
	String email="";
	String tel="";
	String gender="";
	String un="";
	
	for( customerProfile cus: list){
		
		fname = cus.getFirstName();
		lname = cus.getLastName();
		address = cus.getAddress();
		email = cus.getEmail();
		tel = cus.getTelNo();
		gender = cus.getGender();
		un = cus.getUserName(); 
		
		
	}
	%>
	<section class="navsection">
 	<header>
        <div class="wrapper"> 
        <div class="logo">
          <a href="#">
          <img src="images/logo.jpg" alt="logo" >
          </a>
            </div>
         <nav>
          <a href="index.php">Home</a>
          <a href="services.php">Category</a>
          <a href="vehicle-index.php"></a>
          <a href="aboutus.php">About</a>
          <a href="contactus.php">Contact</a>
          <a href="inquery.php">Inquiries</a>
          <a href="register.php"  >Profile</a>
         </nav>
        </div>
    </header>
</section>
	<div class="info">
	<table>
	<form action="update" method = "post">
		<tr>
		<td>First Name: </td> <td><input type="text" name="fname" value="<%=fname %>" > </td>
		</tr>
		<tr>
		<td>Last Name: </td>  <td><input type="text" name="lname" value="<%=lname %>" > </td>
		</tr>
		<tr>
		<td>Address: </td>  <td><input type="text" name="address" value="<%=address %>"></td>
		</tr>
		<tr>
		<td>E-mail: </td>  <td><input type="email" name="email" value="<%=email %>"></td>
		</tr>
		<tr>
		<td>Telephone: </td>  <td><input type="text" name="tel" value="<%=tel %>"></td>
		</tr>
		<tr>
		<td>Gender: </td> <td><input type="text" name="gender" value="<%=gender %>"></td>
		</tr>
		</table>
		</div>
		<div class="valid">
		User Name: <input type="text" name="un" >
		Password: <input type="password" name="password" >
		
		
		
		<input type="submit" name="submit"  class = "sub" value = "Update">
		</div>
	
	</form>
	
	
</body>
</html>