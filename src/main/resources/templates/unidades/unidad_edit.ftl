<#import "/spring.ftl" as spring>
<#include "../header3.ftl">
    <title>Editar una Unidad</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Editar una Unidad</span>
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
                                   <a href="/unidad/${form.id}" class="btn btn-info"><i class="icon-eye-open"></i>Ver</a>
                                   <br/>                               
                                <a href="/unidades" value="Ver todos las Unidades " immediate="true" class="btn"><i class="icon-th-list"></i>Ver todos las Unidades</a>
                               </div>
                            </div>
                           
            <div class="span8">
                                <!--Body content-->
                                <div class="row">
                                    <div class='span12'>

    <label for="numPlacas">Número de Placas </label>
    <input type="numPlacas" name="numPlacas" id="numPlacas" value="${form.numPlacas}"  required/>
                                    </div>
                                </div>
                                <hr /> 
                                <div class="row">
                                    <div class='span4'>
    <label for="numeroEconomico">Número Económico</label>
    <input type="numeroEconomico" name="numeroEconomico" id="numeroEconomico" value="${form.numeroEconomico}"  required/>
                                    </div>
                                    <div class='span4'>
    <label for="marca">Marca</label>
    <input type="marca" name="marca" id="marca" value="${form.marca}"  required/>
                                    </div>
                                    <div class='span4'>
    <label for="modelo">Modelo</label>
    <input type="modelo" name="modelo" id="modelo" value="${form.modelo}" required/>
    
                                    </div>
                                </div>

                                <div class="row">

                                    <div class='span4'>
        <label for="ac">Aire Acondicionado</label>
        <input type="ac" name="ac" id="ac"  value="${form.ac}" required/>  
                                    </div>
                                    <div class='span4'>
        <label for="radioTelecom">Radio Telecom</label>
        <input type="radioTelecom" name="radioTelecom" id="radioTelecom" value="${form.radioTelecom}"  required/>
                                    </div>
                                    
                                                                        <div class='span4'>
     
     <label for="idAseguradora">Aseguradora</label>
    
    <select name="idAseguradora" id="idAseguradora" required>
            <option value="0">Selecciona</option>
            <#list aseguradoras as aseguradora>
           		<option <#if form.idAseguradora == aseguradora.id >selected</#if> value="${aseguradora.id}">${aseguradora.nombre}</option>
            </#list>
        </select>
     
     
                                    </div>
                                    

                                </div>
                                <div class="row">
                                    <div class='span4'>
              <label for="radioAmFm">Radio AM-FM</label>
        <input type="radioAmFm" name="radioAmFm" id="radioAmFm" value="${form.radioAmFm}" required/>
                                    </div>
                                    <div class="span4">
        <label for="aux">Conector Aux</label>
        <input type="aux" name="aux" id="aux" value="${form.aux}"   required/>
                                    </div>
                                    <div class="span4">
      <label for="bt">Bluetooth</label>
        <input type="bt" name="bt" id="bt" value="${form.bt}" required/>
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