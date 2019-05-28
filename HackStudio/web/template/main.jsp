<%-- 
    Document   : main
    Created on : 19/05/2019, 21:59:40
    Author     : witalo
--%>
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="index.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span>
            </a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-anchor"></i>
                <span>Tatuadores</span>
                
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <!--<h6 class="dropdown-header">Login Screens:</h6> -->
                <a class="dropdown-item" href="novo-tatuador.jsp">Cadastrar Tatuador</a>
                <a class="dropdown-item" href="tatuadores?acao=todos">Ver Todos</a>
               <!-- <div class="dropdown-divider"></div>     -->      
            </div>
        </li>  
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user"> </i>
                <span> Clientes</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
               <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
                <a class="dropdown-item" href="novo-cliente.jsp">Cadastrar Cliente</a>
                <a class="dropdown-item" href="clientes?acao=todos">Ver todos</a>
          
            </div>
        </li> 
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-fw fa-folder"></i>
                <span>Estoque</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <a class="dropdown-item" href="cadastrar-produto.jsp">Cadastrar Produto</a>
                <a class="dropdown-item" href="estoque?acao=todos">Ver todos</a>
         
            </div>
        </li>
    </ul>
    <div id="content-wrapper">
        <div class="container-fluid">
            <!-- /.container-fluid -->

