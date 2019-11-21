
<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/18/2019
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Result</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>

<h3>Uploaded Files:</h3>

Description: ${description}

<br/>

<jsp:useBean id="uploadedFiles" scope="request" type="java.util.List"/>
<c:forEach items="${uploadedFiles}" var="file">
    - ${file} <br>
</c:forEach>

</body>
</html>
