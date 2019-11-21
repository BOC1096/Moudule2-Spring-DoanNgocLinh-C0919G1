<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 11/18/2019
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload One File</title>
</head>
<body>
<include page="_menu.jsp"></include>

<h3>Upload One File:</h3>

<!-- MyUploadForm -->
<form modelAttribute="myUploadForm" method="POST"
           action="#" enctype="multipart/form-data">

    Description:
    <br>
    <label>
        <input path="description" style="width:300px;"/>
    </label>
    <br/><br/>

    File to upload: <input path="fileDatas" type="file"/><br/>


    <input type="submit" value="Upload">

</form>

</body>

</html>