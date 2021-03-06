<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.menulabs.taxiplus.domain.dto.OperadorCreateForm" -->
<#import "/spring.ftl" as spring>
<#include "../header3.ftl">
    <title>Editar un Operador</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Editar un Operador</span>
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
                                   <a href="/operador/${form.id}" class="btn btn-info"><i class="icon-eye-open"></i>Ver</a>
                                   <br/>                               
                                <a href="/operadores" value="Ver todos los Operadores " immediate="true" class="btn"><i class="icon-th-list"></i>Ver todos los Operadores</a>
                               </div>
                            </div>
                            
                            <div class="span8">
                                <!--Body content-->
                                <div class="row">
                                    <div class="span6">
                                    <label for="idUnidad">Número de Placas</label>

<select name="idUnidad" id="idUnidad" required>
        <option value="0">Selecciona</option>
        <#list unidades as unidad>
          <option <#if form.idUnidad == unidad.id>selected</#if>  value="${unidad.id}">${unidad.numPlacas}</option>
        </#list>
    </select>
                                    </div>
                                </div>
                                <hr />
                                <div class="row">

                                    <div class="span4">
<label for="nombre">Nombre</label>
<input type="nombre" name="nombre" id="nombre" value="${form.nombre}"  required/>
                                    </div>
                                    <div class="span4">
<label for="apellidopaterno">Apellido Paterno</label>
<input type="apellidopaterno" name="apellidopaterno" id="apellidopaterno" value="${form.apellidopaterno}"  required/>
                                    </div>
                                    <div class="span4">
<label for="apellidomaterno">Apellido Materno</label>
<input type="apellidomaterno" name="apellidomaterno" id="apellidomaterno" value="${form.apellidomaterno}" required/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span4">
<label for="callenumero">Calle y Número</label>
<input type="callenumero" name="callenumero" id="callenumero" value="${form.callenumero}"  required/>
                                    </div>
                                    <div class="span4">
       <label for="colonia">Colonia</label>
<input type="colonia" name="colonia" id="colonia" value="${form.colonia}"  required/>
       								</div>
                                    <div class="span4">
<label for="cp">Código Postal</label>
<input type="cp" name="cp" id="cp" value="${form.cp}"  required/>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="span4">

<label for="telparticular">Teléfono particular</label>
<input type="telparticular" name="telparticular" id="telparticular" value="${form.telparticular}"  required/>


                                    </div>
                                    <div class="span4">
<label for="telmovil">Teléfono móvil</label>
<input type="telmovil" name="telmovil" id="telmovil" value="${form.telmovil}"  required/>
                                    </div>
                                      <div class="span4">
                                    

    
                                        </div>
    
                                    
                                </div>
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