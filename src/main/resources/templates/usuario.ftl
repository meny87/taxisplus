<#-- @ftlvariable name="user" type="com.menulabs.taxiplus.domain.Usuario" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>User details</h1>

<p>E-mail: ${usuario.email}</p>

<p>Role: ${usuario.role}</p>
</body>
</html>