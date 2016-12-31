<#-- @ftlvariable name="user" type="com.menulabs.taxiplus.domain.Operador" -->
<#include "../header3.ftl">
    <title>Ver detalles de un Operador</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Ver detalles de un Operador</span>
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
                                    <a href="/operador/${operador.id}/edit" class="btn btn-info"><i class="icon-pencil"></i>Editar</a>
        							<br/>
        							<a href="/operador/${operador.id}/delete" class=" btn btn-danger"><i class="icon-remove"></i>Eliminar</a>
                                    <br/>
                                    <a href="/operador/create" value="Registrar nuevo Operador " class="btn btn-success"><i class="icon-plus icon-white"></i>Registrar nuevo Operador</a>
                                    <br/>
                                	<a href="/operadores" value="Ver todos los Operadores " immediate="true" class='btn btn-info'>Ver todos los Operadores</a>
                               </div>
                            </div>
                            <div class="span8">
                                <!--Body content-->
			<div class="well">
                                    <dl class="dl-horizontal">
                                       <dt>Número de Placas</dt>
                                        <dd>${operador.unidad.numPlacas}</dd>
                                        <dt>Nombre</dt>
                                        <dd>${operador.nombre}</dd>
                                        <dt>Apellido Paterno</dt>
                                        <dd>${operador.apellidopaterno}</dd>
                                        <dt>Apellido Materno</dt>
                                        <dd>${operador.apellidomaterno}</dd>
                                        <dt>Calle y Número</dt>
                                        <dd>${operador.callenumero}</dd>
                                        <dt>Colonia</dt>
                                        <dd>${operador.colonia}</dd>  
                                         <dt>Códido Postal</dt>
                                        <dd>${operador.cp}</dd>  
                                         <dt>Teléfono particular</dt>
                                        <dd>${operador.telparticular}</dd>
                                         <dt>Teléfono móvil</dt>
                                        <dd>${operador.telmovil}</dd>                                                                             
                                    </dl>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


</body>
</html>