<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="EmployeesServlet">
    <table>
        <tr>
            <td>Имя сотрудника:</td>
            <td><input type="text" value=""/></td>
        </tr>
        <tr>
            <td>Email сотрудника:</td>
            <td><input type="text" value=""/></td>
        </tr>
        <tr>
            <td>Зарплата сотрудника:</td>
            <td><input type="text" value=""/></td>
        </tr>
        <tr>
            <td>Дата устройства на работу:</td>
            <td><input type="text" value=""/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" value="Добавить/Редактировать"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><a href="javascript:history.back()">К списку сотрудников</a></td>
        </tr>
    </table>
</form>
<br/>

</body>
</html>
