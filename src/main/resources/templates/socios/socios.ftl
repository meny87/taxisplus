<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Socio>" -->
<#include "../header2.ftl">
    <title>Sistema de Administración Taxis Plus</title>
</head>    

 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Socios</span>
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
    <#list socios as socio>
    <tr>
        <td>${socio.username}</td>
        <td>${socio.role}</td>
        <td><a href="/socio/${socio.id}"><i class="icon-eye-open"></a></td>
        <td><a href="/socio/${socio.id}/edit"><i class="icon-pencil"></i></a></td>
        <td><a href="/socio/${socio.id}/delete"><i class="icon-remove"></i></a></td>
    </tr>
    </#list>
    </tbody>
</table>

 <a href="/socio/create" value="Registrar nuevo Socio " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nuevo Socio</a>

</form>
</div>
</body>
</html>
        