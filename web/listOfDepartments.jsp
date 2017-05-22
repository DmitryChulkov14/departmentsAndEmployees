<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список департаментов</title>
</head>
<body>
<h1>Список департаментов:</h1>
<table border="1">
    <c:forEach items="${depList}" var="department">
        <tr>
            <form method="get" action="EmployeesServlet">
                <td>${department.id} ${department.name}</td>
                <td><input type="submit" name="button" value="Добавить" /></td>
                <td><input type="submit" name="button" value="Редактировать" /></td>
                <td><input type="submit" name="button" value="Удалить" /></td>
                <td><input type="submit" name="button" value="Список сотрудников" /></td>
                <input type="hidden" name="curDepartment_id" value="${department.id}">
                <input type="hidden" name="curDepartment_name" value="${department.name}">
            </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>
