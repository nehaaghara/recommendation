<%-- 
    Document   : selleraddbrand
    Created on : Mar 7, 2019, 11:49:34 AM
    Author     : ITMCS-PC
--%>



<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Change Your Profile Inforamtion
            <small>
            </small>
        </h1>
    </section>
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title"></h3>
                    </div>
                    <form:form action="${pageContext.servletContext.contextPath}/updateprofile/${sessionScope.UserSession.userName}" modelAttribute="tblUser" onsubmit="return submitProfile();" method="post">
                        <form:hidden path="userid" value="${sessionScope.sessionuser.userid}" name="userid" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="Title">Full Name</label>
                                <form:input path="fullname" name="fullname" value="${sessionScope.UserSession.fullname}" class="form-control" id="fullname" title="fullname" validator="required,alphabetic" onblur="validate(this)"  placeholder="Enter First Name" autofocus="on" />
                                <span for="fullname" class="help-block"><form:errors path="fullname"/></span>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="Title">User Name</label>
                                <form:input path="userName" name="userName" value="${sessionScope.UserSession.userName}" class="form-control" id="userName" title="userName" validator="required,alphanum" onblur="validate(this)"  placeholder="Enter User Name" autofocus="on"/>
                                <span for="userName" class="help-block"><form:errors path="userName"/></span>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="Title">Email Address</label>
                                <form:input path="emailAddress" name="emailAddress" value="${sessionScope.UserSession.emailAddress}" class="form-control" id="emailAddress" title="emailAddress"  validator="required,email" onblur="validate(this)" placeholder="Enter Mail Id" autofocus="on"/>
                                <span for="emailAddress" class="help-block"><form:errors path="emailAddress"/></span>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/profileInformation'"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
</div>
</div>
<!-- /.content-wrapper -->

<script src="${pageContext.servletContext.contextPath}/webresource/js/profileJs.js"></script>
<script src="${pageContext.servletContext.contextPath}/webresource/js/commonJs.js"></script>
