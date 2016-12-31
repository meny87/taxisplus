<#import "/spring.ftl" as spring>
<#include "../header2.ftl">
    <title>Registrar una Nueva Aseguradora</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Registrar una Nueva Aseguradora</span>
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
                                <button type="submit" class='btn btn-success'>Guardar</button>
                                
                                
                                <br />
                                    <a href="/" class='btn'>Cancelar</a>
                                    
                                    <br/>
                                <a href="/aseguradoras" value="Ver todas las Aseguradoras " immediate="true" class='btn btn-info'>Ver todas las Aseguradoras</a>
                               </div>
                            </div>
                            <div class="span2">
                                <!--Body content-->

    
    <label for="nombre">Nombre</label>
    <input type="nombre" name="nombre" id="nombre" required/>
    <label for="direccion">Dirección</label>
    <input type="direccion" name="direccion" id="direccion" required/>
    <label for="telefono">Teléfono</label>
    <input type="telefono" name="telefono" id="telefono" required/>
    <label for="nombreResponsable">Responsable</label>
    <input type="nombreResponsable" name="nombreResponsable" id="nombreResponsable" required/>
    <label for="numeroEmergencia1">Número de Emergencia 1</label>
    <input type="numeroEmergencia1" name="numeroEmergencia1" id="numeroEmergencia1" required/>
    <label for="numeroEmergencia2">Número de Emergencia 2</label>
    <input type="numeroEmergencia2" name="numeroEmergencia2" id="numeroEmergencia2" />
    <label for="comentarios">Comentarios</label>
    <textarea rows="5" name="comentarios" id="comentarios"> </textarea>

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