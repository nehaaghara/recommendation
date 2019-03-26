<%-- 
    Document   : selleraddbrand
    Created on : Mar 7, 2019, 11:49:34 AM
    Author     : ITMCS-PC
--%>



<%@page import="java.util.Date"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<script>
   var path = '${pageContext.servletContext.contextPath}'; 
   
 
    function myfun(e) {
        
        alert('1');
        var instituteid = $(e).val();   
        $.ajax({
            url: path + '/instituteidwisebranch',
            type: "GET",
            data: {'id': instituteid },
           
            success: function (instituteidwisebranch123) {
             
               var json = JSON.parse(instituteidwisebranch123);
              console.log(instituteidwisebranch123);
             
              $.each(json,function(index,obj){
             
            $('<option value="'+obj.branchFk.branchPK+'">'+obj.branchFk.branchName+'</option>').appendTo('#branchFk');        
             });
               
            },
            error: function (error) {
                console.log(error.responseText);
            }
        });
    
     }
     
                                                                        
</script>.

<div class="content-wrapper">
    <section class="content-header">
        <h1>
            Result
        </h1>
    </section>
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Add Result</h3>
                    </div>
                    <form:form action="${pageContext.servletContext.contextPath}/vikashingu" modelAttribute="tblResult" method="GET">
                        <form:hidden path="resultPk" name="resultPk" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="branchFk">Select Institute</label>
                                <form:select path="instituteBranchFk.instituteFk.institutePk"  onchange="myfun(this)" name="instituteBranchFk.instituteFk.institutePk" id="instituteFk" class="form-control select2" style="width: 100%;">
                                    <option value="-1" disabled="true" selected="true">Please Select</option>
                                    <c:forEach var="allinstituteandbranch" items="${allinstituteandbranch}">
                                    <c:forEach items='${allinstituteandbranch.key}' var='entry'>
                                         <option value="${entry.institutePk}">${entry.instituteName}</option>
                                    </c:forEach>  
                                         </c:forEach>
                                </form:select>
                            </div>
                        </div>
                       
                            <div class="box-body">
                            <div class="form-group">
                            <label for="branchFk">Select Branch</label>
                            <form:select path="instituteBranchFk.branchFk.branchPK" title="branchFk" name="instituteBranchFk.branchFk.branchPK" id="branchFk" class="form-control select2" style="width: 100%;">
                                <option value="-1" disabled="true" selected="true">Please Select</option>
                                
                            </form:select>
                         </div> 
                         </div>
                        
                         <div class="box-body">
                            <div class="form-group">
                                <label for="branchFk">Select Year</label>
                              
                                <form:select path="year"  name="year" class="form-control select2" style="width: 100%;">
                                   <jsp:useBean id="now" class="java.util.Date" />
                                <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
                                <c:forEach var="i" begin="2000" end="${year}">
                                            <option value="${i}">${i}</option>
                                </c:forEach>
                                </form:select> </div>
                        </div> 
                        
                        
                        
                         <div class="form-group" >
                                <label for="exampleInputAdminBrand">Cut Off</label>
                                <form:input path="cutoffmarks" name="cutoffmarks" class="form-control" style="width:98%" />
                                
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


