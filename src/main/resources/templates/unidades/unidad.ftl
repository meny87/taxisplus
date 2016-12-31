<#include "../header3.ftl">
    <title>Ver detalles de una Unidad</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Ver detalles de una Unidad</span>
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
                                    <a href="/unidad/${unidad.id}/edit" class="btn btn-info"><i class="icon-pencil"></i>Editar</a>
        							<br/>
        							<a href="/unidad/${unidad.id}/delete" class=" btn btn-danger"><i class="icon-remove"></i>Eliminar</a>
                                    <br/>
                                    <a href="/unidad/create" value="Registrar nueva Unidad " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nueva Unidad</a>
                                    <br/>
                                	<a href="/unidades" value="Ver todas las Unidades " immediate="true" class='btn btn-info'>Ver todas las Unidades</a>
                               </div>
                            </div>
                            <div class="span8">
                                <!--Body content-->
			<div class="well">
                                    <dl class="dl-horizontal">
                                        <dt>Número de Placas</dt>
                                        <dd>${unidad.numPlacas}</dd>
                                        <dt>Número Económico</dt>
                                        <dd>${unidad.numeroEconomico}</dd>
                                        <dt>Marca</dt>
                                        <dd>${unidad.marca}</dd>
                                        <dt>Modelo</dt>
                                        <dd>${unidad.modelo}</dd>
                                        <dt>AC</dt>
                                        <dd>${unidad.ac}</dd>
                                        <dt>Radio Telecom</dt>
                                        <dd>${unidad.radioTelecom}</dd>
                                        <dt>Aseguradora</dt>
                                        <dd>${unidad.aseguradora.nombre}</dd>
                                        <dt>Radio AM-FM</dt>
                                        <dd>${unidad.radioAmFm}</dd>
                                        <dt>Conector Aux</dt>
                                        <dd>${unidad.aux}</dd>
                                        <dt>Bluetooth</dt>
                                        <dd>${unidad.bt}</dd>
                   
                                    </dl>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


</body>
