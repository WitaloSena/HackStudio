<%-- 
    Document   : updateCliente
    Created on : 27/05/2019, 22:20:06
    Author     : witalo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.hackstudio.model.Cliente"%>
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
                <div class="card-header">Alterar cliente</div>
                <div class="card-body">  
                    <form action="clientes" method="post">
                        <%

                            List<Cliente> listacli = (List) request.getAttribute("listacli");

                            for (Cliente cliente : listacli) {

                        %>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <div class="form-label-group">
                                        <input type="text" id="nome" value="<%=cliente.getNome()%>" name="nome" class="form-control" placeholder="nome" required="required" autofocus="autofocus">
                                        <label for="nome">Nome</label>
                                    </div>
                                </div>                        
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="email" id="inputEmail" value="<%=cliente.getEmail()%>" name="email" class="form-control" placeholder="<%=cliente.getEmail()%>" required="required">
                                        <label for="inputEmail">Email</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-label-group">
                                        <input type="text" id="cpf" value="<%=cliente.getCpf()%>" name="cpf" class="form-control" placeholder="cpf" required="required">
                                        <label for="cpf">CPF</label>
                                    </div>

                                </div>
                            </div>
                        </div>              
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9">
                                    <div class="form-label-group">
                                        <input type="phone" id="telefone" value="<%=cliente.getTelefone()%>" name="telefone" class="form-control" placeholder="telefone" required="required">
                                        <label for="telefone">telefone</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-9">
                                    <div class="form-label-group">
                                        <input type="text" id="instagram" value="<%=cliente.getInstagram()%>" name="instagram" class="form-control" placeholder="instagram" required="required">
                                        <label for="instagram">instagram</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-8">
                                    <div class="form-label-group">
                                        <input type="text" id="facebook" value="<%=cliente.getFacebook()%>" name="facebook" class="form-control" placeholder="facebook" required="required">
                                        <label for="facebook">facebook</label>
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
                        <input type="hidden" name="id" value="<%=cliente.getId()%>"> 

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
