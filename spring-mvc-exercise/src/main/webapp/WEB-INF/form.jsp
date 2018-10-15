<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:errors path="studentDTO.*"/>
<form method="post" action="/Student/submit">
    <label>Student name</label>
    <input name="name" type="text">
    <label>Age</label>
    <input name="age" type="text">
    <label>Id</label>
    <input name="id" type="text">
    <input type="submit">
</form>
</body>
</html>