<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Aseguradora>" -->
<#include "../header2.ftl">
    <title>Sistema de Administración Taxis Plus</title>
</head>    

 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Aseguradoras</span>
                </div>
            </div>
        </h1>

<div class="container">
<form class="jsfcrud_list_form" > 
<table class="table table-striped">
    <thead>
    <tr>
        <th>Nombre</th>
        <th>Telefono</th>
        <th>Ver</th>
       
        <th>Editar</th>
        <th>Borrar</th>
        
    </tr>
    </thead>
    <tbody>
    <#list aseguradoras as aseguradora>
    <tr>
        <td>${aseguradora.nombre}</td>
        <td>${aseguradora.telefono}</td>
        <td><a href="/aseguradora/${aseguradora.id}"><i class="icon-eye-open"></a></td>
        <td><a href="/aseguradora/${aseguradora.id}/edit"><i class="icon-pencil"></i></a></td>
        <td><a href="/aseguradora/${aseguradora.id}/delete"><i class="icon-remove"></i></a></td>
    </tr>
    </#list>
    </tbody>
</table>

 <a href="/aseguradora/create" value="Registrar nueva Aseguradora " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nueva Aseguradora</a>

</form>
</div>
</body>
</html>