<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/18/2019
  Time: 2:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>home</title>
</head>
<body>
<form:form method="post" action="/save">
    <table>
        <tr>
            <td><form:label path = "condiments">Sandwich condiment:</form:label></td>
            <td><form:checkboxes items = "${CondimentList}" path = "condiments" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
