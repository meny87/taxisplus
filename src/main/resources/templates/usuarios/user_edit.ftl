<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.menulabs.taxiplus.domain.dto.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<#include "../header3.ftl">
    <title>Editar un Usuario</title>
     
 </head>   
<body>
<#include "../menu.ftl">
<h1>
            <div class="container">
                <div class="well"><span class="text-info text-center">Editar un Usuario</span>
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
                                   <a href="/usuario/${form.id}" class="btn btn-info"><i class="icon-eye-open"></i>Ver</a>
                                   <br/>                               
                                <a href="/usuarios" value="Ver todos los Usuarios " immediate="true" class="btn"><i class="icon-th-list"></i>Ver todos los Usuarios</a>
                               </div>
                            </div>
                            <div class="span2">
                                <!--Body content-->

        <label for="username">Usuario</label>
        <input type="username" name="username" id="username" value="${form.username}" required autofocus/>
 
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
  
        <label for="passwordRepeated">Repita password</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
 
        <label for="role">Rol</label>
        <select name="role" id="role" required>
            <option <#if form.role == 'CAPTURER'>selected</#if>>CAPTURER</option>
            <option <#if form.role == 'ADMINCAPTURER'>selected</#if>>ADMINCAPTURER</option>
        </select>
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