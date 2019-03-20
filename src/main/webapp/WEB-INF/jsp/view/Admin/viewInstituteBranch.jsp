<%-- 
    Document   : viewCustomer
    Created on : Nov 15, 2018, 6:28:43 PM
    Author     : ITMCS
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
            Institute Branch
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addinstitutebranch" value="Add Institute Branch" onclick="window.location.href = '${pageContext.servletContext.contextPath}/addinstitutebranch'">
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div id="divAltMsg"></div>
                        <c:if test="${not empty SuccessMessage}">
                            <div class="row" style="margin-left: 0px;" id="SuccessMessage">
                                <div class="col-md-6  alert alert-success">
                                    ${SuccessMessage}.
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty DeleteMessage}">
                            <div class="row" style="margin-left: 0px;" id="DeleteMessage">
                                <div class="col-md-6  alert alert-success">
                                    ${DeleteMessage}.
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${not empty UpdateMessage}">
                            <div class="row" style="margin-left: 0px;" id="UpdateMessage">
                                <div class="col-md-6  alert alert-success">
                                    ${UpdateMessage}.
                                </div>
                            </div>
                        </c:if>
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Institute Name</th>
                                    <th>Branch Name</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstInstituteBranch}" var="entry">
                                    <tr>
                                        <td>${count}</td>
                                        <td>${entry.instituteFk.instituteName}</td>
                                        <td>${entry.branchFk.branchName}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/editinstitutebranch/${entry.institutebranchPK}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/deleteinstitutebranch/${entry.institutebranchPK}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>

                                    </tr>
                                    <c:set var="count" value="${count+1}"/>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->

        <!-- /.row -->
    </section>

</div>
<script src="${pageContext.servletContext.contextPath}/webresource/admin/dist/js/commonJs.js"></script>

<script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
</script>