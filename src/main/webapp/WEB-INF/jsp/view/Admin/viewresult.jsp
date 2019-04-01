<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
${lstresult}
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Result
            <small>view</small>
        </h1>
        <br>
        <input type="button" class="btn btn-primary" name="addBranch" value="Add Result" onclick="window.location.href = '${pageContext.servletContext.contextPath}/resultpage'">
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div id="divAltMsg"></div>
                        
                        <table id="example" class="display" style="width:100%">
                            <thead>
                                <tr>
                                    <th> No </th>
                                    <th>ResultPK</th>
                                    <th>Institute</th>
                                    <th>Branch</th>
                                    <th>Year</th>
                                    <th> CutOff Marks </th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="count" value="1"/>
                                <c:forEach items="${lstresult}" var="entry">
                                    <tr>
                                        <td>${count}</td>
                                        <td>${entry.resultPk}</td>
                                        <td>${entry.instituteBranchFk.instituteFk.instituteName}</td>
                                        <td>${entry.instituteBranchFk.branchFk.branchName}</td>
                                        <td>${entry.year}</td>
                                         <td>${entry.cutoffmarks}</td>
                                        <td><a href="${pageContext.servletContext.contextPath}/editresult/${entry.resultPk}" style="font-size: 22px;"><i class="fa fa-edit"></i></a></td>
                                        <td><a href="${pageContext.servletContext.contextPath}/deleteresult/${entry.resultPk}" style="font-size: 22px;"><i class="fa fa-trash"></i></a></td>

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