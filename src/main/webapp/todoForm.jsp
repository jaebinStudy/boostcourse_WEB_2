<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>나의 해야할 일들</title>
    <link rel="stylesheet" href="todo.css">

    <script>
        function registerTodo() {
            var todoName = document.getElementById("todoName").value;
            var todoTitle = document.getElementById("todoTitle").value;
            var todoName = document.getElementById("todoName").value;

            if(!todoName){
                alert("누가 할지 입력해주세요..");
                return false;
            }
            if(!todoDate){
                alert("날짜를 입력해주세요.");
                return false;
            }
            if (!todoTitle){
                alert("할 일을 입력해주세요.");
            }
            if (todoTitle.length>24){
                alert("글자수는 24자 이하로 해주세요.");
            }

            var form = document.getElementById("todoForm");
            form.submit();
        }

    </script>
</head>


<body>
<header><h1 class="title">할 일 등록</h1></header>

<section>
    <form action="main.jsp" method="post" class="form-example">
        <label for="todo"> 어떤 일 인가요? </label>
        <input type="text" id="todo" size=24 Placeholder="ex)swift공부하기(24자까지)" required>

        <div class="form-example">
            <label for="name">누가 할 일 인가요?</label>
            <input type="text" id="name" Placeholder="ex)정재빈" required>
        </div>

        <div class="form-example">
            <input type="radio" id="1순위" value="1순위">
            <input type="radio" id="2순위" value="2순위">
            <input type="radio" id="3순위" value="3순위">
        </div>

        <div class="form-example">
            <li><input type="submit" name="제출" value="submit"></li>
            <li><input type="submit" name="내용지우기" value="submit"></li>
            <li><a href="main.jsp">이전</a></li>
        </div>
    </form>
</section>
</body>
</html>
