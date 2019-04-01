
<%-- 
    Document   : ublOasisLogin
    Created on : Nov 15, 2018, 2:06:31 PM
    Author     : ITMCS
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>DIAN | UBL OASIS</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1 , maximum-scale=1 , user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/admin/plugins/iCheck/square/blue.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/webresource/css/custom.css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <b style="color:black">Recommendation</b>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">

                
                <form action="${pageContext.servletContext.contextPath}/forgotproccess" method="get"  onsubmit="return checkForm(this);">
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" id="emailAddress" title="emailAddress" placeholder="Enter Mail Id" name="emailAddress">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        <span for="emailAddress" class="help-block"><form:errors path="emailAddress"/></span>
                        ${result}
                        <c:set var = "msg"  value = "notvelidemailid"/>
                        <c:set var = "returnmsg"  value = "${result}"/>
                          <c:if test = "${msg eq returnmsg}">
                              <p style="color: red"> Please Enter Velid Email ID <p>
                        </c:if>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control"  title="Password" placeholder="Password" name="password">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <span for="password" class="help-block"><form:errors path="password"/></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control"  title="Password" placeholder="Conform Password" name="conformpassword">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <span for="password" class="help-block"><form:errors path="password"/></span>
                    </div>
                    <div class="row">
                       <div class="col-xs-4">
                           <button style="text-align: center; margin-left:84px" type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
                       </div> 
                    </div>
                  </form>
            </div>
            
        </div>
        <!-- /.login-box -->

        <!-- jQuery 2.2.3 -->
        <script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-1.12.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="${pageContext.servletContext.contextPath}/webresource/admin/bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="${pageContext.servletContext.contextPath}/webresource/admin/plugins/iCheck/icheck.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/webresource/js/jquery.magnific-popup.js"></script>
        <script src="${pageContext.servletContext.contextPath}/webresource/js/jquery-ui.min.js"></script>
        <script>
                    $(function () {
                        $('input').iCheck({
                            checkboxClass: 'icheckbox_square-blue',
                            radioClass: 'iradio_square-blue',
                            increaseArea: '20%' // optional
                        });
                    });
        </script>
         <script type="text/javascript">

  function checkForm(form)
  {
   if(form.password.value != "" && form.password.value == form.conformpassword.value) {
      if(form.password.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.password.focus();
        return false;
      }
      if(form.password.value == form.emailAddress.value) {
        alert("Error: Password must be different from Username!");
        form.password.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.password.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.password.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.password.focus();
        return false;
      }
    } else {
      alert("Error: Please check that you've entered and confirmed your password!");
      form.password.focus();
      return false;
    }

    alert("You entered a valid password: " + form.password.value);
    return true;
  }

</script>



    </body>
</html>

