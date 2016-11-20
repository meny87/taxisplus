<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="com.menulabs.taxiplus.domain.dto.CurrentUser" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        

     
     <li><a href="/operador/create">Create a new operador</a></li>
        <li><a href="/operadores">View all operadores</a></li>
        <li><a href="/usuario/${currentUser.id}">View myself</a></li>
    </#if>
    <#if currentUser?? && currentUser.role == "ADMINCAPTURER">
        <li><a href="/usuario/create">Create a new user</a></li>
        <li><a href="/usuarios">View all users</a></li>
    </#if>
    </ul>
    

</nav>
</body>
</html>