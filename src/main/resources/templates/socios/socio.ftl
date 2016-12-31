<#include "../header3.ftl">
    <title>Ver detalles de un Socio</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Ver detalles de un Socio</span>
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
                                    <a href="/socio/${socio.id}/edit" class="btn btn-info"><i class="icon-pencil"></i>Editar</a>
        							<br/>
        							<a href="/socio/${socio.id}/delete" class=" btn btn-danger"><i class="icon-remove"></i>Eliminar</a>
                                    <br/>
                                    <a href="/socio/create" value="Registrar nuevo Socio " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nuevo Socio</a>
                                    <br/>
                                	<a href="/socios" value="Ver todos los Socios " immediate="true" class='btn btn-info'>Ver todos los Socios</a>
                               </div>
                            </div>
                            <div class="span8">
                                <!--Body content-->
			<div class="well">
                                    <dl class="dl-horizontal">
                                       <dt>Número de Placas</dt>
                                        <dd>${socio.unidad.numPlacas}</dd>
                                        <dt>Nombre</dt>
                                        <dd>${socio.nombre}</dd>
                                        <dt>Apellido Paterno</dt>
                                        <dd>${socio.apellidopaterno}</dd>
                                        <dt>Apellido Materno</dt>
                                        <dd>${socio.apellidomaterno}</dd>
                                        <dt>Dirección</dt>
                                        <dd>${socio.direccion}</dd>  
                                         <dt>Teléfono particular</dt>
                                        <dd>${socio.telparticular}</dd>
                                         <dt>Teléfono móvil</dt>
                                        <dd>${socio.telmovil}</dd>                                                                             
                                    </dl>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


</body>
</html>