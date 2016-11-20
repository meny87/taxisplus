<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Usuario>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/usuario/create">Create a new user</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>E-mail</th>
        <th>Role</th>
        <th>Delete</th>
        <th>Edit</th>
        
    </tr>
    </thead>
    <tbody>
    <#list usuarios as usuario>
    <tr>
        <td><a href="/usuario/${usuario.id}">${usuario.email}</a></td>
        <td>${usuario.role}</td>
        
        <td><a href="/usuario/${usuario.id}/delete">Delete</a></td>
        <td><a href="/usuario/${usuario.id}/edit">Edit</a></td>
        
        
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>