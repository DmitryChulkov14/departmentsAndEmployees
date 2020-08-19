# Departments And Employees
  Тестовое задание
  
Есть сотрудники и департаменты.
У департамента может быть много сотрудников, а может и не быть.
На странице отображается список департаментов с кнопочками "Добавить/Редактировать/Удалить/Список сотрудников".
При нажатии "Список" показываются сотрудники этого департамента с такими же кнопочками.
Списки департаментов и сотрудников - таблица, страница добавления/редактирования - форма с набором текстфилдов. Ввод даты - текстфиллд.

Технологии:
1. БД - jdbc
2. Controller - servlet
3. View - jsp+el+jstl
4. Должна присутствовать валидация данных.
5. Уникальность имени у департамента и email у пользователя.
6. У сотрудника обязательно одно поле - числовое, одно - дата.
7. Данные после валидации пропадать не должны, даже если они введены неправильно!
