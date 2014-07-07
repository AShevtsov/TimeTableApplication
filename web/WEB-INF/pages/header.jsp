<%-- 
    Document   : header
    Created on : 02.05.2014, 15:08:02
    Author     : user
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css"/>

        <title>Time Table Application</title>
    </head>
    <body>
        <h1>Time Table Application</h1>
        <table class ="maintable">
            <tr>
                <td class="menu" valign="top" >
                    <p><a href="?page=Faculty">    Факультеты</a></p>
                    <p><a href="?page=GroupOfStudents">     Группы</a></p>
                    <p><a href="?page=Student">   Студенты</a></p>
                    <p><a href="?page=Course">    Курсы</a></p>
                    <p><a href="?page=Teacher">   Преподаватели</a></p>
                    <p><a href="?page=Classroom"> Аудитории</a></p>
                    <p><a href="?page=TimeTable"> Расписание</a></p>
                    <p><c:out value="${error}"/></p>
                <td valign = "top">

