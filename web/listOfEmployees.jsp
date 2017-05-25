<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>
<h1><c:out value="${department.name}"/></h1>
<table border="1">
    <tr>
        <td>Имя сотрудника</td>
        <td>Email</td>
        <td>Зарплата</td>
        <td>Дата</td>
        <td colspan="3">Действия</td>
    </tr>
    <c:set var="isEmptyList" value="${employeesList}"/>
    <c:if test="${empty isEmptyList}">
        <form method="get" action="EmployeeActionServlet">
            <tr><td colspan="5"><input style="width: 100%" type="submit" name="button" value="Добавить"/></td></tr>
        </form>
    </c:if>
    <c:forEach items="${employeesList}" var="employee">
        <tr>
            <td><c:out value="${employee.name}"/></td>
            <td><c:out value="${employee.email}"/></td>
            <td><c:out value="${employee.salary}"/></td>
            <td><c:out value="${employee.date}"/></td>
            <form method="get" action="EmployeeActionServlet">
                <td><input type="submit" name="button" value="Добавить"/></td>
                <td><input type="submit" name="button" value="Редактировать"/></td>
                <td><input type="submit" name="button" value="Удалить"/></td>
                <input type="hidden" name="employee_id" value="${employee.id}">
                <input type="hidden" name="employee_department_it" value="${employee.department_id}">
                <input type="hidden" name="employee_name" value="${employee.name}">
                <input type="hidden" name="employee_email" value="${employee.email}">
                <input type="hidden" name="employee_salary" value="${employee.salary}">
                <input type="hidden" name="employee_date" value="${employee.date}">
            </form>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value="/DepartmentsServlet"/>">К списку департаментов</a>
</body>
</html>
