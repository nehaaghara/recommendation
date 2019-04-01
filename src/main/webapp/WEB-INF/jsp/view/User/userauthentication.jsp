<%-- 
    Document   : userauthentication
    Created on : Mar 22, 2019, 5:34:38 PM
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .form-style-5{
                max-width: 500px;
                padding: 10px 20px;
                background: #f4f7f8;
                margin: 10px auto;
                padding: 20px;
                background: #f4f7f8;
                border-radius: 8px;
                font-family: Georgia, "Times New Roman", Times, serif;
            }
            .form-style-5 fieldset{
                border: none;
            }
            .form-style-5 legend {
                font-size: 1.4em;
                margin-bottom: 10px;
            }
            .form-style-5 label {
                display: block;
                margin-bottom: 8px;
            }
            .form-style-5 input[type="text"],
            .form-style-5 input[type="date"],
            .form-style-5 input[type="datetime"],
            .form-style-5 input[type="email"],
            .form-style-5 input[type="number"],
            .form-style-5 input[type="search"],
            .form-style-5 input[type="time"],
            .form-style-5 input[type="url"],
            .form-style-5 textarea,
            .form-style-5 select {
                font-family: Georgia, "Times New Roman", Times, serif;
                background: rgba(255,255,255,.1);
                border: none;
                border-radius: 4px;
                font-size: 15px;
                margin: 0;
                outline: 0;
                padding: 10px;
                width: 100%;
                box-sizing: border-box; 
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box; 
                background-color: #e8eeef;
                color:#8a97a0;
                -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
                box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
                margin-bottom: 30px;
            }
            .form-style-5 input[type="text"]:focus,
            .form-style-5 input[type="date"]:focus,
            .form-style-5 input[type="datetime"]:focus,
            .form-style-5 input[type="email"]:focus,
            .form-style-5 input[type="number"]:focus,
            .form-style-5 input[type="search"]:focus,
            .form-style-5 input[type="time"]:focus,
            .form-style-5 input[type="url"]:focus,
            .form-style-5 textarea:focus,
            .form-style-5 select:focus{
                background: #d2d9dd;
            }
            .form-style-5 select{
                -webkit-appearance: menulist-button;
                height:35px;
            }
            .form-style-5 .number {
                background: #1abc9c;
                color: #fff;
                height: 30px;
                width: 30px;
                display: inline-block;
                font-size: 0.8em;
                margin-right: 4px;
                line-height: 30px;
                text-align: center;
                text-shadow: 0 1px 0 rgba(255,255,255,0.2);
                border-radius: 15px 15px 15px 0px;
            }

            .form-style-5 input[type="submit"],
            .form-style-5 input[type="button"]
            {
                position: relative;
                display: block;
                padding: 19px 39px 18px 39px;
                color: #FFF;
                margin: 0 auto;
                background: #1abc9c;
                font-size: 18px;
                text-align: center;
                font-style: normal;
                width: 100%;
                border: 1px solid #16a085;
                border-width: 1px 1px 3px;
                margin-bottom: 10px;
            }
            .form-style-5 input[type="submit"]:hover,
            .form-style-5 input[type="button"]:hover
            {
                background: #109177;
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
        <h1 style="font-family: cursive; color: #00ad9c"><center>Welcome ${sessionScope.UserSession.userName}</center></h1>
        <input type="button" id="logout" class="btn btn-primary" name="logout" value="Logout" onclick="window.location.href = '${pageContext.servletContext.contextPath}/logout'">
        <div class="form-style-5">
            <form action="userdetail123" method="get">
                <fieldset>
                    <legend><span class="number">1</span> Candidate Info</legend>
                    <input type="text" name="name" placeholder="Your Name *">
                    <input type="email" name="email" placeholder="Your Email *">
                    <input type="text" name="phone" placeholder="Your PhoneNumber *">
                    <label for="job">Interests:</label>
                    <select name="field" name="field4">
                        <option value="-1">Please Select</option>
                        <c:forEach var="instituteandbranch" items="${allinstituteandbranch}">
                            <c:forEach var="branch" items="${instituteandbranch.value}">
                                <option value="${branch.branchName}">${branch.branchName}</option>
                            </c:forEach>
                        </c:forEach>
                    </select> 
                    <label for="year">Select Passing Year</label>
                    <select name="year" class="form-control select2" style="width: 100%;">
                        <option value="-1">Please Select</option>
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
                        <c:forEach var="i" begin="2000" end="${year}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                </fieldset>
                <fieldset>
                    <legend><span class="number">2</span> Enter Your Total Score </legend>
                    <textarea name="studentscore"  placeholder="Only Enter Your Score"></textarea>
                </fieldset>
                <input type="submit" value="Apply" />
            </form>
        </div>
    </body>
</html>
