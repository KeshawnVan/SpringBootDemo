<html>
<body>
<table>
<#list users as user>
<tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>${user.status}</td>
</tr>
</#list>
</table>
</body>
</html>