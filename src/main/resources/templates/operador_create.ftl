<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.menulabs.taxiplus.domain.dto.OperadorCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new Operador</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new operador</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="telmovil">telmovil</label>
        <input type="telmovil" name="telmovil" id="telmovil" required autofocus/>
    </div>
    <div>
        <label for="placasID">Placas</label>
        <input type="placasID" name="placasID" id="placasID" required/>
    </div>
        <div>
        <label for="nombre">Nombre</label>
        <input type="nombre" name="nombre" id="nombre" required/>
    </div>
            <div>
        <label for="apellidopaterno">Apellido Paterno</label>
        <input type="apellidopaterno" name="apellidopaterno" id="apellidopaterno" required/>
    </div>
        <div>
        <label for="apellidomaterno">Apellido Materno</label>
        <input type="apellidomaterno" name="apellidomaterno" id="apellidomaterno" required/>
    </div>

        <div>
        <label for="colonia">colonia</label>
        <input type="colonia" name="colonia" id="colonia" required/>
    </div>
            <div>
        <label for="callenumero">calle y numero</label>
        <input type="callenumero" name="callenumero" id="callenumero" required/>
    </div>
                <div>
        <label for="cp">CP</label>
        <input type="cp" name="cp" id="cp" required/>
    </div>
    
                <div>
        <label for="telparticular">tel particular</label>
        <input type="telparticular" name="telparticular" id="telparticular" required/>
    </div>
    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>