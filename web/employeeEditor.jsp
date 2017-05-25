<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:out value="${employeeClickedButton}" /> сотрудника</title>
</head>
<body>
<form method="get" action="EmployeeEditServlet">
    <table>
        <tr>
            <td>Имя сотрудника:</td>
            <td><input type="text" pattern="[A-Za-zА-Яа-яЁё\s]+$" name="name" value="${employee.name}" placeholder="Имя" required /></td>
        </tr>
        <tr>
            <td>Email сотрудника:</td>
            <td><input type="email" name="email" value="${employee.email}" placeholder="Email" required /></td>
        </tr>
        <tr>
            <td>Зарплата сотрудника:</td>
            <c:set var="employee_salary" value="${employee.salary}" />
            <td><input type="text" pattern="^[0-9]+$" name="salary"
                       value="<c:if test="${employee_salary != 0}"><c:out value="${employee_salary}"/></c:if>"
                       placeholder="Зарплата(только число)" required />
            </td>
        </tr>
        <tr>
            <td>Дата устройства на работу:</td>
            <td><input type="text" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" name="date" value="${employee.date}" placeholder="ГГГГ-ММ-ДД" required /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" value="${employeeClickedButton}"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><a href="javascript:history.back()">К списку сотрудников</a></td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${employee.id}" />
    <input type="hidden" name="department_id" value="${employee.department_id}" />
</form>
<br/>

</body>
</html>
