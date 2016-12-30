<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.menulabs.taxiplus.domain.dto.OperadorCreateForm" -->
<#import "/spring.ftl" as spring>
<#include "../header2.ftl">
    <title>Registrar un Nuevo Operador</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Registrar un Nuevo Operador</span>
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
                                <a href="/operadores" value="Ver todos los Operadores " immediate="true" class='btn btn-info'>Ver todos los Operadores</a>
                               </div>
                            </div>
                            <div class="span2">
                                <!--Body content-->

    <label for="numPlacas">Placas</label>
    <input type="numPlacas" name="numPlacas" id="numPlacas" required autofocus/>
    <label for="nombre">Nombre</label>
    <input type="nombre" name="nombre" id="nombre" required/>
    <label for="apellidopaterno">Apellido Paterno</label>
    <input type="apellidopaterno" name="apellidopaterno" id="apellidopaterno" required/>
    <label for="apellidomaterno">Apellido Materno</label>
    <input type="apellidomaterno" name="apellidomaterno" id="apellidomaterno" required/>
    <label for="colonia">Colonia</label>
    <input type="colonia" name="colonia" id="colonia" required/>
    <label for="callenumero">Calle y Número</label>
    <input type="callenumero" name="callenumero" id="callenumero" required/>
    <label for="cp">CP</label>
    <input type="cp" name="cp" id="cp" required/>
    <label for="telparticular">Teléfono particular</label>
    <input type="telparticular" name="telparticular" id="telparticular" required/>
    <label for="telmovil">Teléfono móvil</label>
    <input type="telmovil" name="telmovil" id="telmovil" required/>
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