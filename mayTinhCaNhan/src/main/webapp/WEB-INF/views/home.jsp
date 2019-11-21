<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/19/2019
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CALCULATOR</h1>
<form action="/calculator" method="post">
    <fieldset>
        <table>
            <tr>
                <td>Number1:</td>
                <td><input name="num1" type="text" value="0"/></td>
            </tr>
            <tr>
                <td>Number2:</td>
                <td><input name="num2" type="text" value="0"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="+" value="cong"></td>
                <td><input type="submit" name="-" value="tru"></td>
                <td><input type="submit" name="*" value="nhan"></td>
                <td><input type="submit" name="/" value="chia"></td>
            </tr>
        </table>
    </fieldset>
</form>
<h2>${result}</h2>
</body>
</html>
