<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>
<h1>${department_name}</h1>
<table border="1">
    <tr>
        <td>Имя сотрудника</td>
        <td>Email</td>
        <td>Зарплата</td>
        <td>Дата</td>
        <td colspan="3">Действия</td>
    </tr>
    <c:forEach items="${employeesList}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.salary}</td>
            <td>${employee.date}</td>
            <form method="get" action="EmployeeActionServlet">
                <td><input type="submit" name="button" value="Добавить" /></td>
                <td><input type="submit" name="button" value="Редактировать" /></td>
                <td><input type="submit" name="button" value="Удалить" /></td>
            </form>
        </tr>
    </c:forEach>
</table><br />
<a href="/DepartmentsServlet">К списку департаментов</a>
</body>
</html>
