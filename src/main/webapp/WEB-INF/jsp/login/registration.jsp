<%-- 
    Document   : ublOasisRegister
    Created on : Nov 15, 2018, 5:10:37 PM
    Author     : ITMCS
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>DIAN | UBL OASIS</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/plugins/iCheck/square/blue.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/pageCss/CommonCss.css">

        <!-- For passwords check-css -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/pageCss/passwordCheck.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition register-page">
        <div class="register-box">
            <div class="register-logo">
                <b>UBL</b>OSIS
            </div>
            <div class="register-box-body">
                <p id="responseReg" class="login-box-msg" style="display:none"></p>

                <form action="registerpage" role="form" id="form" onsubmit="return submitRegister();" method="post">
                    <div id="otpSentModel">
                        <p class="login-box-msg">Register_new_memberShip</p>
                        <div class="form-group has-feedback">
                            <input type="text" id="fullname" path="fullname" class="form-control" name="fullname" title="Full name" placeholder="Full name"/>
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <span for="fullName" class="help-block"><form:errors path="fullName"/></span>

                        </div>
                        <div class="form-group has-feedback">
                            <input type="text" id="username" path="userName" name="userName" class="form-control"  title="User name" placeholder="User name" cssClass="form-control" />    
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            <span for="userName" class="help-block"><form:errors path="userName"/></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="email" id="email" path="emailAddress" name="emailAddress" class="form-control" title="Email" placeholder="Email" cssClass="form-control" />
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            <span for="emailAddress" class="help-block"><form:errors path="emailAddress"/></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" id="password" path="password" name="password" class="form-control" title="Password" placeholder="Password" cssClass="form-control" />    
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            <span for="password" class="help-block"><form:errors path="password"/></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" id="retypePassword" name="conformpassword" class="form-control" title="Retype password"  placeholder="Retype password">
                            <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                            <span id="retypePasswordCheckResult"></span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-8"><a href="${pageContext.servletContext.contextPath}/loginindex" class="text-center">I_already_have_a_membership</a>
                        </div>
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" id="btnRegOtpsent" class="btn btn-primary btn-block btn-flat">Register</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
            </div>
            <!-- /.form-box -->
        </div>
        <!-- /.register-box -->

        <script>
            var path = '${pageContext.servletContext.contextPath}';
        </script>       

        <!-- jQuery 2.2.3 -->
        <script src="${pageContext.servletContext.contextPath}/webresource/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="${pageContext.servletContext.contextPath}/webresource/admin/bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="${pageContext.servletContext.contextPath}/webresource/admin/plugins/iCheck/icheck.min.js"></script>
       </body>
</html>
