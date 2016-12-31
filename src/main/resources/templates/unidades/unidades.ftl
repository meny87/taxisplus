<#-- @ftlvariable name="users" type="java.util.List<com.menulabs.taxiplus.domain.Unidad>" -->
<#include "../header2.ftl">
    <title>Sistema de Administración Taxis Plus</title>
</head>    

 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Unidades</span>
                </div>
            </div>
        </h1>

<div class="container">
<form class="jsfcrud_list_form" > 
<table class="table table-striped">
    <thead>
    <tr>
        <th>Placas</th>
        <th>Marca</th>
        <th>Ver</th>
        <th>Editar</th>
        <th>Borrar</th>
        
    </tr>
    </thead>
    <tbody>
    <#list unidades as unidad>
    <tr>
        <td>${unidad.numPlacas}</td>
        <td>${unidad.marca}</td>
        <td><a href="/unidad/${unidad.id}"><i class="icon-eye-open"></a></td>
        <td><a href="/unidad/${unidad.id}/edit"><i class="icon-pencil"></i></a></td>
        <td><a href="/unidad/${unidad.id}/delete"><i class="icon-remove"></i></a></td>
    </tr>
    </#list>
    </tbody>
</table>

 <a href="/unidad/create" value="Registrar nueva Unidad " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nueva Unidad</a>

</form>
</div>
</body>
</html>
        