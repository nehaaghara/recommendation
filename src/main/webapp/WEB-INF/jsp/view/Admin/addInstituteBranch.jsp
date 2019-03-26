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
            Institute Branch
        </h1>
    </section>
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Add Institute Branch</h3>
                    </div>
                    <form:form action="${pageContext.servletContext.contextPath}/saveinstitutebranch" modelAttribute="tblInstituteBranch" method="post">
                        <form:hidden path="institutebranchPK" name="institutebranchPK" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="branchFk">Select Institute</label>
                                <form:select path="instituteFk.institutePk"  name="instituteFk.institutePk" id="instituteFk" class="form-control select2" style="width: 100%;">
                                    <option value="-1" disabled="true" selected="true">Please Select</option>
                                    <c:forEach items='${lstInstitute}' var='entry'>
                                        <option value="${entry.institutePk}">${entry.instituteName}</option> 
                                    </c:forEach>  
                                </form:select>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="branchFk">Select Branch</label>
                                <form:select path="branchFk.branchPK" title="branchFk" name="branchFk.branchPK" id="branchFk" class="form-control select2" style="width: 100%;">
                                    <option value="-1" disabled="true" selected="true">Please Select</option>
                                    <c:forEach items='${lstBranches}' var='entry'>
                                        <option value="${entry.branchPK}">${entry.branchName}</option> 
                                    </c:forEach>  
                                </form:select> </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="submit" name="saveAndNew" value="Save & New" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/viewinstitutebranch'"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
</div>
</div>
<!-- /.content-wrapper -->


