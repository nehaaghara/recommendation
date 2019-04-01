
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

 #logout{
                position:fixed;
                right:170px;
                top:15px;
                height: 38px;
                width: 90px;
            }
</style>
</head>
<body>
  <h1 style="font-family: cursive; color: #00ad9c"><center>Congratulations ${sessionScope.UserSession.userName}</center></h1>
   <input type="button" id="logout" class="btn btn-primary" name="logout" value="Logout" onclick="window.location.href = '${pageContext.servletContext.contextPath}/logout'">
  <h3 style="font-family: cursive; color: #00ad9c"><center>You can take Admission in below listed Institutes  !!!....</center></h3>
     
<table id="customers">
  <tr>
    <th>No</th>
    <th>Institute Name</th>
    <th>Branch Name</th>
    <th>Cutoff Marks</th>
  </tr>
    <c:set var="count" value="1"/>
    <c:forEach items="${lstresultofstudent}" var="entry">
  <tr>
    <td>${count}</td>
    <td>${entry.instituteBranchFk.instituteFk.instituteName}</td>
    <td>${entry.instituteBranchFk.branchFk.branchName}</td>
    <td>${entry.cutoffmarks}</td>
  </tr>
  <c:set var="count" value="${count+1}"/>
  </c:forEach>
 
</table>

</body>
</html>
