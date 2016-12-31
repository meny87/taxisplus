<#-- @ftlvariable name="usuario" type="com.menulabs.taxiplus.domain.Usuario" -->
<#include "../header3.ftl">
    <title>Ver detalles de un Usuario</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Ver detalles de un Usuario</span>
                </div>
            </div>
        </h1>


      <div class="container">
                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="span4">
                                <!--Sidebar content-->
                               <div class="btn-group btn-group-vertical">
                                
                                	<a href="/"class="btn"><i class="icon-home"></i>Ir al Inicio</a>
                                    <br/>
                                    <a href="/usuario/${usuario.id}/edit" class="btn btn-info"><i class="icon-pencil"></i>Editar</a>
        							<br/>
        							<a href="/usuario/${usuario.id}/delete" class=" btn btn-danger"><i class="icon-remove"></i>Eliminar</a>
                                    <br/>
                                    <a href="/usuario/create" value="Registrar nuevo Usuario " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nuevo Usuario</a>
                                    <br/>
                                	<a href="/usuarios" value="Ver todos los Usuarios " immediate="true" class='btn btn-info'>Ver todos los Usuarios</a>
                               </div>
                            </div>
                            <div class="span8">
                                <!--Body content-->
			<div class="well">
                                    <dl class="dl-horizontal">
                                        <dt>Usuario</dt>
                                        <dd>${usuario.username}</dd>
                                        <dt>Rol</dt>
                                        <dd>${usuario.role}</dd>
                                    </dl>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


</body>
</html>