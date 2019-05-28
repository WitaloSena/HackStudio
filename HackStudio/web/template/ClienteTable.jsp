<%-- 
    Document   : Clientetable
    Created on : 20/05/2019, 21:47:14
    Author     : witalo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.hackstudio.model.Cliente"%>
<%@page import="java.util.List"%>
<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="../index.jsp">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Clientes</li>
    </ol>

    <!-- DataTables Example -->
    <div class="card mb-3">
        <!--
        <div class="card-header">
            <i class="fas fa-table"></i>
            Data Table Example
        </div> -->
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>nome</th>
                            <th>email</th>     
                            <th>telefone</th>
                        </tr>
                    </thead>            
                    <tbody>  
                        <%
                            List<Cliente> listacli = (List) request.getAttribute("listacli");

                            // Percorre a lista dos registros e apresenta no navegador
                            for (Cliente cliente : listacli) {
                        %>

                        <tr>

                            <td><%=cliente.getId()%></td>
                            <td><%=cliente.getNome()%></td>
                            <td><%=cliente.getEmail()%></td>
                            <td><%=cliente.getTelefone()%></td>

                           <td><a class="btn btn-info" href="clientes?acao=editar&id=<%=cliente.getId()%>" role="button">Editar</a>
                            <td><a class="btn btn-danger" href="clientes?acao=excluir&id=<%=cliente.getId()%>" role="button">Excluir</a>
                        </tr>
                        <%
                            } // Fim do laço de repetição
                        %>

                    </tbody>
                </table>
            </div>
        </div>
        <!-- <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div> -->
    </div>


</div>
<!-- /.container-fluid -->

