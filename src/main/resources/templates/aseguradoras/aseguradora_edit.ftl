<#import "/spring.ftl" as spring>
<#include "../header3.ftl">
    <title>Editar una Aseguradora</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Editar una Aseguradora</span>
                </div>
            </div>
        </h1>
 <form role="form" name="form" action="" method="post">
                              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

      <div class="container">
                    <div class="container-fluid">
                        <div class="row-fluid">
                            <div class="span4">
                                <!--Sidebar content-->
                               <div class="btn-group btn-group-vertical">
                               
                               <button type="submit" class="btn btn-success"><i class="icon-ok"></i>Guardar</button>
                                
                                
                                	<br />
                                    <a href="/" class="btn btn-inverse"><i class="icon-remove icon-white"></i>Cancelar</a>
                                    <br/>
                                   <a href="/aseguradora/${form.id}" class="btn btn-info"><i class="icon-eye-open"></i>Ver</a>
                                   <br/>                               
                                <a href="/aseguradoras" value="Ver todas las Aseguradoras " immediate="true" class="btn"><i class="icon-th-list"></i>Ver todas las Aseguradoras</a>
                               
                               
                               </div>
                            </div>
                            <div class="span2">
                                <!--Body content-->

    
    <label for="nombre">Nombre</label>
    <input type="nombre" name="nombre" id="nombre" value="${form.nombre}" required/>
    <label for="direccion">Dirección</label>
    <input type="direccion" name="direccion" id="direccion" value="${form.direccion}" required/>
    <label for="telefono">Teléfono</label>
    <input type="telefono" name="telefono" id="telefono" value="${form.telefono}" required/>
    <label for="nombreResponsable">Responsable</label>
    <input type="nombreResponsable" name="nombreResponsable" id="nombreResponsable" value="${form.nombreResponsable}" required/>
    <label for="numeroEmergencia1">Número de Emergencia 1</label>
    <input type="numeroEmergencia1" name="numeroEmergencia1" id="numeroEmergencia1" value="${form.numeroEmergencia1}" required/>
    <label for="numeroEmergencia2">Número de Emergencia 2</label>
    <input type="numeroEmergencia2" name="numeroEmergencia2" id="numeroEmergencia2" value="${form.numeroEmergencia2}" />
    <label for="comentarios">Comentarios</label>
    <textarea rows="5" name="comentarios" id="comentarios">${form.comentarios}</textarea>

                            </div>
                        </div>
                    </div>
                </div>
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