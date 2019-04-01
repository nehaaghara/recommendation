<%-- 
    Document   : selleraddbrand
    Created on : Mar 7, 2019, 11:49:34 AM
    Author     : ITMCS-PC
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Institute
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
                        <h3 class="box-title">Add Institute</h3>
                    </div>
                    <form:form action="${pageContext.servletContext.contextPath}/saveinstitute" modelAttribute="tblInstitutes" method="post">
                        <form:hidden path="tblInstitute.institutePk" name="tblInstitute.institutePk" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Institute Name</label>
                                <form:input path="tblInstitute.instituteName" name="tblInstitute.instituteName" class="form-control" id="instituteName" title="Institute Name"  placeholder="Enter Institute Name" autofocus="on"/>
                                <span for="tblInstitute.instituteName" class="help-block"><form:errors path="tblInstitute.instituteName"/></span>
                            </div>
                            <div class="panel-body" id="dvbranchIds"> 
                                <c:if test="${not empty lstBranchById}">
                                    <div id="branches" value="${fn:length(lstBranchById)}"></div> 
                                    <c:forEach items="${lstBranchById}" var='idEntry' varStatus='loop'>
                                        <div class="row" id="dvbranchIds${loop.index+1}" style="margin: -12px -30px;">
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <label for="branchFK">Select Branch</label>
                                                    <form:select path="branches[${loop.index}]" title="Branch" name="branches[${loop.index}]" id="branchFk${loop.index+1}" onchange="DrpBrannchChange(this);" class="form-control select2" style="width: 100%;">
                                                        <option value="-1" disabled="true" selected="true">Please Select</option>
                                                        <c:forEach items='${lstBranch}' var='entry'>
                                                            <c:if test="${entry.branchPK eq idEntry.branchFk.branchPK}">
                                                                <option value="${entry.branchPK}" selected="true">${entry.branchName}</option> 
                                                            </c:if>
                                                            <c:if test="${entry.branchPK ne idEntry.branchFk.branchPK}">
                                                                <option value="${entry.branchPK}">${entry.branchName}</option> 
                                                            </c:if>
                                                        </c:forEach>  
                                                    </form:select>
                                                    <span for="branches[${loop.index}]" class="help-block"><form:errors path="branches[${loop.index}]"/></span>
                                                </div>
                                            </div>
                                            <div class="col-md-1">
                                                <div class="form-group">
                                                    <br>
                                                    <c:choose>
                                                        <c:when test="${loop.index == 0 }">
                                                            <button type="button" class="btn btn-primary" onclick="fnAddBranchRow();">Add</button>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button type="button" class="btn btn-primary" onclick="fnDeleteBranch(${loop.index+1})"><i class="fa fa-close"></i></button>
                                                            </c:otherwise>
                                                        </c:choose>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty lstBranchById}">
                                    <div class="row" id="dvbranchIds1" style="margin: -12px -30px;">    
                                        <div class="col-md-10">
                                            <div class="form-group">
                                                <label for="branchFK">Select Branch</label>
                                                <form:select path="branches[0]" title="Branch" name="branches[0]" id="branchFk1" class="form-control select2" onchange="DrpBrannchChange(this);" style="width: 100%;">
                                                    <option value="-1" disabled="true" selected="true">Please Select</option>
                                                    <c:forEach items='${lstBranch}' var='entry'>
                                                        <option value="${entry.branchPK}">${entry.branchName}</option> 
                                                    </c:forEach>  
                                                </form:select>
                                                <span for="branches[0]" class="help-block"><form:errors path="branches[0]"/></span>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <div class="form-group">
                                                <br>
                                                <button type="button" class="btn btn-primary" onclick="fnAddBranchRow();">Add</button>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Contact Number</label>
                                <form:input type="number" path="tblInstitute.contactNo" name="contactNo" class="form-control" id="contactNo" title="Contact No"  placeholder="Enter Contact Number"/>
                                <span for="tblInstitute.contactNo" class="help-block"><form:errors path="tblInstitute.contactNo"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Contact Person</label>
                                <form:input path="tblInstitute.contactPerson" name="tblInstitute.contactPerson" class="form-control" id="contactPerson" title="Contact Person"  placeholder="Enter Contact Person"/>
                                <span for="tblInstitute.contactPerson" class="help-block"><form:errors path="tblInstitute.contactPerson"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Email Id</label>
                                <form:input path="tblInstitute.emailId" name="tblInstitute.emailId" class="form-control" id="emailId" title="Email Id"  placeholder="Enter Email Id"/>
                                <span for="tblInstitute.emailId" class="help-block"><form:errors path="tblInstitute.emailId"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Address</label>
                                <form:textarea path="tblInstitute.address" name="tblInstitute.address" class="form-control" id="address" title="Address" rows="4" clos="4" placeholder="Enter Address"></form:textarea>
                                <span for="tblInstitute.address" class="help-block"><form:errors path="tblInstitute.address"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Zip File</label>
                                <form:input path="tblInstitute.zipCode" name="tblInstitute.zipCode" class="form-control" id="zipCode" title="Zip Code"  placeholder="Enter Zip Code"/>
                                <span for="tblInstitute.zipCode" class="help-block"><form:errors path="tblInstitute.zipCode"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Web Site</label>
                                <form:input path="tblInstitute.website" name="tblInstitute.website" class="form-control" id="website" title="Web Site"  placeholder="Enter Web Site"/>
                                <span for="tblInstitute.website" class="help-block"><form:errors path="tblInstitute.website"/></span>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputAdminBrand">Description</label>
                                <form:textarea path="tblInstitute.description" name="tblInstitute.description" class="form-control" id="description" title="Description"  rows="4" cols="4" placeholder="Enter Description"></form:textarea>
                                <span for="tblInstitute.description" class="help-block"><form:errors path="tblInstitute.description"/></span>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" name="save" value="Save & Exit" class="btn btn-primary"/>
                            <input type="submit" name="saveAndNew" value="Save & New" class="btn btn-primary"/>
                            <input type="button" name="action" value="Cancel" class="btn btn-primary" onclick="window.location.href = '${pageContext.servletContext.contextPath}/viewinstitute'"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section>
</div>
<!-- /.content-wrapper -->
<script src="${pageContext.servletContext.contextPath}/webresource/admin/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/webresource/instituteJs.js"></script>


