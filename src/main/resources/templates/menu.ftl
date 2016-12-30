  <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="/" value="Taxis Plus"><i class="fa fa-cab" ></i>Taxis Plus</a>
              
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                           
                            <li><a href="/operadores">Operadores</a></li>
                            <li><a href="/socios">Socios</a></li>  
                            <li><a href="/unidades">Unidades</a></li>  
                            <li><a href="/usuarios">Usuarios</a></li>                            
                             <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
    
        <li>
                        <form action="/logout" method="post" style="margin:0px">
        
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-link" type="submit">Log out</button>
            </form>
        </li>
                  </#if>
                            
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
