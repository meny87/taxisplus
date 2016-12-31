<#import "/spring.ftl" as spring>
<#include "../header2.ftl">
    <title>Registrar un Nueva Unidad</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Registrar un Nueva Unidad</span>
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
                                <a href="/unidades" value="Ver todas las Unidades " immediate="true" class='btn btn-info'>Ver todas las Unidades</a>
                               </div>
                            </div>
                           
            <div class="span8">
                                <!--Body content-->
                                <div class="row">
                                    <div class='span12'>

    <label for="numPlacas">Número de Placas </label>
    <input type="numPlacas" name="numPlacas" id="numPlacas" required/>
                                    </div>
                                </div>
                                <hr /> 
                                <div class="row">
                                    <div class='span4'>
    <label for="numeroEconomico">Número Económico</label>
    <input type="numeroEconomico" name="numeroEconomico" id="numeroEconomico" required/>
                                    </div>
                                    <div class='span4'>
    <label for="marca">Marca</label>
    <input type="marca" name="marca" id="marca" required/>
                                    </div>
                                    <div class='span4'>
    <label for="modelo">Modelo</label>
    <input type="modelo" name="modelo" id="modelo" required/>
    
                                    </div>
                                </div>

                                <div class="row">

                                    <div class='span4'>
        <label for="ac">Aire Acondicionado</label>
        <input type="ac" name="ac" id="ac" required/>  
                                    </div>
                                    <div class='span4'>
        <label for="radioTelecom">Radio Telecom</label>
        <input type="radioTelecom" name="radioTelecom" id="radioTelecom" required/>
                                    </div>
                                    
                                                                        <div class='span4'>
     
     <label for="idAseguradora">Aseguradora</label>
    
    <select name="idAseguradora" id="idAseguradora" required>
            <option value="0">Selecciona</option>
            <#list aseguradoras as aseguradora>
           		<option value="${aseguradora.id}">${aseguradora.nombre}</option>
            </#list>
        </select>
     
     
                                    </div>
                                    

                                </div>
                                <div class="row">
                                    <div class='span4'>
              <label for="radioAmFm">Radio AM-FM</label>
        <input type="radioAmFm" name="radioAmFm" id="radioAmFm" required/>
                                    </div>
                                    <div class="span4">
        <label for="aux">Conector Aux</label>
        <input type="aux" name="aux" id="aux" required/>
                                    </div>
                                    <div class="span4">
      <label for="bt">Bluetooth</label>
        <input type="bt" name="bt" id="bt" required/>
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