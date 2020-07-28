<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset=UTF-8">
    <title>Todo</title>
    <link rel="stylesheet" type="text/css" href="main.css?after">

</head>

<script type="text/javascript" src="main.js"></script>

<body>
<%--    전체적인 부분을 header와 section으로 나눔.--%>
<%--header에는 헤더 타이틀과 todo 등록 하기 위한 버튼--%>
<header>
    <div id="header-full">
        <div id="header-column-left">
            <span class="header-title">나의 해야할 일들</span>
        </div>

        <form method="POST" action="/form" id="header-column-right">
            <input type="submit" class="header-button-todo" value="새로운 TO DO 등록"/>
        </form>
    </div>
</header>

<%--section은 todo,doing,done 세개의 메인컨텐츠로 나눠지고, 메인 컨텐츠는 목록과 추가되는 컨텐츠로 두개로 나뉘어짐--%>
<%--또 추가되는 컨텐츠는 내용(title)과   등록날짜,이름,우선순위, 타입버튼  이 담긴 두개로 나뉘어짐 --%>
<section>
    <div id="section_body">

        <div id="TODO" class="section-main">
            <span class="section-main-title">TO DO</span>

            <c:forEach var="item" items="${todo }">
                <c:if test="${item.type == 'TODO'}"> <%-- 타입이 todo 라면--%>

                    <div id="${item.id }" class="main-contents">
                        <div class="main-up">${item.title}</div>
                        <div class="main-dawn">등록날짜: ${item.regdate},
                            ${item.name},우선순위 ${item.sequence}
                        </div>
                        <input type="button-typechange"
                               onclick="move('${item.id}','${item.type}');" value="->"/>
                    </div>

                </c:if>
            </c:forEach>
        </div>

        <div id="DOING" class="section-main">
            <span class="section-main-title">DOING</span>
            <c:forEach var="item" items="${todo }">
                <c:if test="${item.getType() == 'DOING'}"> <%-- 타입이 doing 라면--%>

                    <div id="${item.id }" class="main-contents">
                        <div class="main-up">${item.title}</div>
                        <div class="main-dawn">등록날짜: ${item.regdate},
                                ${item.name},우선순위 ${item.sequence}
                        </div>
                        <input type="button-typechange"
                               onclick="move('${item.id}','${item.type}');" value="->"/>
                    </div>

                </c:if>
            </c:forEach>
        </div>

        <div id="DONE" class="ssection-main">
            <span class="section-main-title">DONE</span>
            <c:forEach var="item" items="${todo }">
                <c:if test="${item.getType() == 'DONE'}"><%-- 타입이 done 라면--%>

                    <div id="${item.id }" class="main-contents">
                        <div class="main-up">${item.title}</div>
                        <div class="main-dawn">등록날짜: ${item.regdate},
                                ${item.name},우선순위 ${item.sequence}
                        </div>
                        <input type="button-typechange"
                               onclick="move('${item.id}','${item.type}');" value="->"/>
                    </div>

                </c:if>
            </c:forEach>
        </div>
    </div>


</section>


</body>
</html>

