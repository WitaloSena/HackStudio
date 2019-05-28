<%-- 
    Document   : EstoqueTable
    Created on : 27/05/2019, 17:01:41
    Author     : witalo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.com.hackstudio.model.Estoque"%>
<%@page import="java.util.List"%>
<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Estoque</li>
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
                            <!-- <th>id</th> -->
                            <th>id</th>
                            <th>nome</th>     
                            <th>qtd</th>
                            <th>valor uni</th>

                        </tr>
                    </thead>            
                    <tbody>  
                        <%
                            List<Estoque> listEstoque = (List) request.getAttribute("listEstoque");

                            // Percorre a lista dos registros e apresenta no navegador
                            for (Estoque estoque : listEstoque) {
                        %>

                        <tr>

                            <td><%=estoque.getId()%></td>
                            <td><%=estoque.getNome()%></td>
                            <td><%=estoque.getQuantidade()%></td>
                            <td><%=estoque.getValor_unitario()%></td>


                           <td><a class="btn btn-info" href="estoque?acao=editar&id=<%=estoque.getId()%>" role="button">Editar</a>
                            <td><a class="btn btn-danger" href="estoque?acao=excluir&id=<%=estoque.getId()%>" role="button">Excluir</a>
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
