<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Method</title>
<link rel="stylesheet" type="text/css" href="css/addPayment.css">

<link rel="stylesheet" type="text/css" href="css/profile.css">

</head>
<body>
	<div class="info">
	<form action="insert" method="post">
	
		Enter Card Number:<input type="text" name="cardNo"> <br>
		Enter Card Type: <lable>visa </lable><input type="radio" id="visa" name="ctype" value="visa" >
						 <label>mastercard</label><input type="radio" id="mastercard" name="ctype" value="mastercard"><br>
		Enter PIN: <input type="text" name="pin"><br>
		
		<input type="submit" name="submit" value="Add new card">
		
		<a href="payMethodDetails.jsp">Details</a>
		
		
	</form>
	</div>
</body>
</html>