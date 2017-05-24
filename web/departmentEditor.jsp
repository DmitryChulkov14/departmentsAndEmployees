<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${clickedButton} департамент</title>
</head>
<body>
<form method="get" action="DepartmentEditServlet">
    <p>Укажите название департамента: <input type="text" name="name" value="${department.name}"/>
        <input type="submit" name="button" value="${clickedButton}">
        <input type="hidden" name="curDepartment_id" value="${department.id}">
    </p>
</form>
<br/>
<a href="/DepartmentsServlet">К списку департаментов</a>
</body>
</html>
