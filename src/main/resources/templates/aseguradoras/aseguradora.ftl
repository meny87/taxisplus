<#include "../header3.ftl">
    <title>Ver detalles de una Aseguradora</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Ver detalles de una Aseguradora</span>
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
                                    <a href="/aseguradora/${aseguradora.id}/edit" class="btn btn-info"><i class="icon-pencil"></i>Editar</a>
        							<br/>
        							<a href="/aseguradora/${aseguradora.id}/delete" class=" btn btn-danger"><i class="icon-remove"></i>Eliminar</a>
                                    <br/>
                                    <a href="/aseguradora/create" value="Registrar nuevo Aseguradora " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nueva Aseguradora</a>
                                    <br/>
                                	<a href="/aseguradoras" value="Ver todas las Aseguradoras " immediate="true" class='btn btn-info'>Ver todas las Aseguradoras</a>
                               </div>
                            </div>
                            <div class="span8">
                                <!--Body content-->
			<div class="well">
                                    <dl class="dl-horizontal">
                                        <dt>Nombre</dt>
                                        <dd>${aseguradora.nombre}</dd>
                                        <dt>Direccion</dt>
                                        <dd>${aseguradora.direccion}</dd>
                                        <dt>Telefono</dt>
                                        <dd>${aseguradora.telefono}</dd>
                                        <dt>Responsable</dt>
                                        <dd>${aseguradora.nombreResponsable}</dd>
                                        <dt>Número de Emergencia 1</dt>
                                        <dd>${aseguradora.numeroEmergencia1}</dd>
                                        <dt>Número de Emergencia 2</dt>
                                        <dd>${aseguradora.numeroEmergencia2}</dd>
                                        <dt>Comentarios</dt>
                                        <dd>${aseguradora.comentarios}</dd>
                                    </dl>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


</body>
</html>