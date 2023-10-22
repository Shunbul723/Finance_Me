<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script>

function createPolicy(){
	alert("inside create ");
	var form = document.getElementById("polcyForm");
	
	form.action="createaccounts";
	//alert (document.getElementById("polcyForm").action);
	form.method="POST";
	form.method.type="POST";
	//alert (document.getElementById("polcyForm").method);
	form.submit();
}

function updatePolicy(){
	var form = document.getElementById("polcyForm");
	form.action="updateaccounts";
	form.method="PUT";
	form.method.type="PUT";
	form.submit();
}

function deletePolicy(){
	var form = document.getElementById("polcyForm");
	form.action="deleteaccounts";
	form.method="DELETE";
	form.method.type="DELETE";
	form.submit();
}
</script>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FinanceMe</title>

<style>
  /* Add your CSS rules here */
  body {
    font-family: Arial, sans-serif;
    background-color: #b67fde; /* Background color set to purple */
  }

  form {
    margin: 20px;
    padding: 10px;
    border: 1px solid #ccc;
  }

  input[type="text"] {
    width: 100%;
    padding: 5px;
    margin: 5px 0;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }

  table, th, td {
    border: 1px solid #000;
  }

  th, td {
    padding: 8px;
    text-align: left;
  }

  input[type="submit"],
  input[type="button"] {
    padding: 10px 20px;
    margin: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
  }

  input[type="submit"]:hover,
  input[type="button"]:hover {
    background-color: #0056b3;
  }
</style>

</head>
<body>
    <form action="addpolicy" id="polcyForm" type="POST">
    <h2 align="center">Account Registration Form</h2>
        <br>
        Enter Account number: <input type="text" name="id" size="20">
        <br>
        Enter name: <input type="text" name="name" size="20">
        <br>    
        Enter address: <input type="text" name="address" size="50">
        
        <br>    
        Enter your contact: <input type="text" name "contact" size="50">
        
        <table>
        <thead>
          <tr>
            <th>Account No</th>
            <th>Customer Name</th>
            <th>Customer Address</th>
            <th>Contact Number</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${policyList}" var="policy">
            <tr>
              <td>${policy.accountId}</td>
              <td>${policy.customerName}</td>
              <td>${policy.customerAddress}</td>
              <td>${policy.contactNumber}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
        
        <input type="submit" value="Create Account"  onClick="createPolicy()"/>
        <input type="button" value="Update Account"  onclick="updatePolicy()"/>
        <input type="button" value="Delete Account"  onclick="deletePolicy()"/>
    </form>
</body>
</html>
