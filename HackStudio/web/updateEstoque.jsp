<%-- 
    Document   : updateEstoque
    Created on : 21/05/2019, 12:18:56
    Author     : witalo.sena
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.hackstudio.model.Estoque"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>HackStudio</title>

        <!-- Custom fonts for this template-->
        <link href="template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="template/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="template/scss/_login.scss" type="text/css"/>


    </head>

    <%@include file="template/header.jsp" %>
    <%@include file="template/main.jsp" %>

    <body class="bg-dark">
        <div class="container pb-5">
            <div class="card card-register mx-auto mt-2 ">
                <div class="card-header">Alterar Estoque</div>
                <div class="card-body">  
                    <form action="estoque" method="post">
                        <%

                            List<Estoque> listEstoque = (List) request.getAttribute("listEstoque");

                            for (Estoque estoque : listEstoque) {

                        %>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="form-label-group">
                                        <input type="text" id="firstName" value="<%=estoque.getNome()%>" name="nome" class="form-control" placeholder="First name" required="required" autofocus="autofocus">
                                        <label for="nome">Nome</label>
                                    </div>
                                </div>                        
                            </div>
                        </div>                
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9 pb-3">
                                    <div class="form-label-group">
                                        <input type="text" name="quantidade" id="endereço"value="<%=estoque.getQuantidade()%>" class="form-control" placeholder="quantidade" required="required">
                                        <label for="quantidade">Quantidade</label>
                                    </div>
                                </div>                   
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9">
                                    <div class="form-label-group">
                                        <input type="text" id="valor" value="<%=estoque.getValor_unitario()%>" name="valor" class="form-control" placeholder="valor" required="required">
                                        <label for="valor">Valor unitário</label>
                                    </div>
                                </div>
                            </div>
                        </div>               
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-primary btn-block" name="acao" value="alterar">alterar</button> 
                                </div>                              
                            </div>
                        </div>
                        <input type="hidden" name="id" value="<%=estoque.getId()%>"> 

                        <%
                            } // Fim do laço de repetição
                        %>   
                    </form>  

                </div>
            </div>
        </div>

        <%@include file="template/footer.jsp" %>

        <!-- Bootstrap core JavaScript-->
        <script src="template/vendor/jquery/jquery.min.js"></script>
        <script src="template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="template/vendor/jquery-easing/jquery.easing.min.js"></script>

    </body>

</html>
