<%@page import="java.util.ArrayList" %>
<%@page import="kr.or.connect.TodoDto" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Todo</title>
    <link rel="stylesheet" type="text/css" href="main.css">

</head>
<body>
<header>
    <div id=header-full>
        <div id="header-column-left">
            <span class="title">나의 해야할 일들</span>
        </div>

        <div id="header-column-right">
            <a href="todoForm.jsp" class="button-todo">새로운 TO DO 등록</a>
        </div>
    </div>
</header>


<section>
    <div id="section_body">
        <div id="section-float">
            <div class="section-column">
                <span class="list">TO DO</span>
                <div id="TODO" class="section-content">
                    <c:forEach var="item" items="${todo }">
                        <c:if test="${item.getType() == 'TODO'}">
                            <p>
                                <span class="item-title">${item.getTitle() }</span> <br>
                                <fmt:parseDate value="${item.getRegdate()}" var="parsedDate"
                                               pattern="yyyy-MM-dd HH:mm:ss.S"/>
                                등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
                                    ${item.getName() },
                                우선순위 ${item.getSequence()}
                                <span class='button' id='${item.getType() }#${item.getId()}'>-></span>
                            </p>
                        </c:if>
                    </c:forEach>

                </div>

                <div class="section-column">
                    <span class="list">DOING</span>
                    <div id="DOING">
                        <c:forEach var="item" items="${todo }">
                            <c:if test="${item.getType() == 'DOING'}">
                                <p>
                                    <span class="item-title">${item.getTitle() }</span> <br>
                                    <fmt:parseDate value="${item.getRegdate()}" var="parsedDate"
                                                   pattern="yyyy-MM-dd HH:mm:ss.S"/>
                                    등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
                                        ${item.getName() },
                                    우선순위 ${item.getSequence()}
                                    <span class='button' id="${item.getType()}#${item.getId()}">-></span>
                                </p>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>

                <div class="section-column">
                    <span class="list">DONE</span>
                    <div id="DONE">
                        <c:forEach var="item" items="${todo }">
                            <c:if test="${item.getType() == 'DONE'}">
                                <p>
                                    <span class="item-title">${item.getTitle() }</span> <br>
                                    <fmt:parseDate value="${item.getRegdate()}" var="parsedDate"
                                                   pattern="yyyy-MM-dd HH:mm:ss.S"/>
                                    등록날짜: <fmt:formatDate value="${parsedDate}" pattern="yyyy. MM. dd"/>,
                                        ${item.getName() },
                                    우선순위 ${item.getSequence()}
                                </p>
                            </c:if>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script type="text/javascript" src="main.js"></script>
</body>
</html>

