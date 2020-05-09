<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person home page</title>
<style>
	.error 
	{
		color: #ff0000;
		font-weight: bold;
	}
	</style>
</head>
<h2>Hello Nagesh</h2>
<body>

<h2><spring:message code="lbl.page" text="Add New Employee" /></h2>


<form:form action="/MVCWebapp/persondetails"  modelAttribute="person3" method="post">

<table>
    <tr>
         <td><spring:message code="lbl.firstName" /> </td>           
         <td> <form:input path="FirstName"/>   </td> 
         <td> <form:errors path="FirstName" cssClass="error" /> <br> </td>    
    </tr>
    <tr>
        <td><spring:message code="lbl.lastName" /> </td> 
        <td> <form:input path="LastName" />  </td>
        <td> <form:errors path="LastName" cssClass="error"/> <br> </td>
    </tr>
    <tr>
        <td><spring:message code="lbl.email" /> </td> 
        <td> <form:input type="?email?" path="Email" /> </td>
        <td> <form:errors path="Email" cssClass="error"/> <br> </td>
    </tr>
    <tr>
        <td><spring:message code="lbl.dob" /> </td>  
        <%-- <td> <form:input type="text" path="DOB" value="<fmt:formatDate value="${cForm.dueDate}" pattern="MM-dd-yyyy" />" />   </td> --%>
        
        <td> <form:input path="DOB" placeholder="MM/dd/yyyy" />   </td>
        
        <%-- <td> <input type="text" class="date" name = "DOB" value = "<fmt:formatDate value="${cForm.dueDate}" pattern="MM-dd-yyyy"  type="date"/>"/>  </td> --%>
        
        <td> <form:errors path="DOB" cssClass="error"  /> <br> </td>
    </tr>
    <tr>
        <td> <spring:message code="lbl.zipcode" /> </td> 
        <td> <form:input  path="zipcode" /> </td>
        <td> <form:errors path="zipcode" cssClass="error"/> <br> </td>
    </tr>
    <tr> 
     
       <td><spring:message code="lbl.skills" /> </td> 
        <td>  <form:select path="pesonskills" items="${skills}" /> </td>
        <td> <form:errors path="pesonskills" cssClass="error"/> <br> </td>
		
    
    
    </tr>
    <tr>
    <td> <input type="submit" value="submit" /> <td>
    </tr>
</table>
</form:form>

</body>
</html>