<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Usuario>" -->
<#include "../header2.ftl">
    <title>Sistema de Administración Taxis Plus</title>
</head>    

 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Usuarios</span>
                </div>
            </div>
        </h1>

<div class="container">
<form class="jsfcrud_list_form" > 
<table class="table table-striped">
    <thead>
    <tr>
        <th>Usuario</th>
        <th>Rol</th>
        <th>Ver</th>
        <th>Editar</th>
        <th>Borrar</th>
        
    </tr>
    </thead>
    <tbody>
    <#list usuarios as usuario>
    <tr>
        <td>${usuario.username}</td>
        <td>${usuario.role}</td>
        <td><a href="/usuario/${usuario.id}"><i class="icon-eye-open"></i></a></td>
        <td><a href="/usuario/${usuario.id}/edit"><i class="icon-pencil"></i></a></td>
        <td><a href="/usuario/${usuario.id}/delete"><i class="icon-remove"></i></a></td>
    </tr>
    </#list>
    </tbody>
</table>
    <#if currentUser?? && currentUser.role == "ADMINCAPTURER">


 <a href="/usuario/create" value="Registrar nuevo Usuario " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nuevo Usuario</a>
    </#if>

</form>
</div>
</body>
</html>
        