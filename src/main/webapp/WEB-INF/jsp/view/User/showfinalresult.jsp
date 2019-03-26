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
</style>
</head>
<body>

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
