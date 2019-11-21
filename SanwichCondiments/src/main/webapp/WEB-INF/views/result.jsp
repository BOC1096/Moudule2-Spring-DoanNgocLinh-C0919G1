<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/19/2019
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Sandwich is Condiment: </td>
        <td> <% String[] condiments = (String[])request.getAttribute("condiments");
            for(String condiment: condiments) {
                out.println(condiment);
            }
        %></td>
    </tr>
</table>
</body>
</html>
