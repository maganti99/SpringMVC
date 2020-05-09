<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response page</title>
</head>
<body>
   <h2>${msg}</h2>
   <h3>${person3.getFirstName()}</h3>
   <%-- <h3>${person2.getFirstName()}</h3> --%>
   
   <%-- <table border="1">
        <tr>
            <th>Person Skills</th>
            
        </tr>
        <c:forEach items="${person1.getPesonskills()}" var="skill">
            <tr>
                <td>${skill}</td>
                
            </tr>
        </c:forEach>
    </table> --%>
</body>
</html>