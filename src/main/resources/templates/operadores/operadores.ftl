<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Operador>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Operadores</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/operador/create">Create a new operator</a></li>
    </ul>
</nav>

<h1>List of Operatores</h1>

<table>
    <thead>
    <tr>
        <th>Tel movil</th>
        <th>Placas</th>
         <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <#list operadores as operador>
    <tr>
        <td><a href="/operador/${operador.id}">${operador.telmovil}</a></td>
        <td>${operador.placasID}</td>
                <td><a href="/operador/${operador.id}/delete">Delete</a></td>
        <td><a href="/operador/${operador.id}/edit">Edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>