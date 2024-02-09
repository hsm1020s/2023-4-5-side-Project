<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입화면</title>
    <style>
        .all {
            margin: auto;
            border: 3px solid black;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            box-shadow: 0 0 20px rgba(0, 128, 0, 0.8);
            animation: shadowBlinkGreen 1s infinite alternate;
            font-family: 'Arial', sans-serif;
            background-color: #f2f2f2;
        }

        .a {
            margin: 10px;
            padding: 20px;
            display: block;
            border: 3px solid black;
            margin-bottom: 15px;
            box-shadow: 0 0 20px rgba(49, 0, 128, 0.8);
            font-family: 'Verdana', sans-serif;
            background-color: #fff;
            /* animation: combinedAnimation 4s infinite alternate; */
        }

        .b {
            margin-top: 10px;
            display: inline-block;
            transform: rotate(180deg);
            box-shadow: 0 0 20px rgba(18, 216, 234, 0.8);
            animation: shadowBlinkBlue 1s infinite alternate;
            font-family: 'Tahoma', sans-serif;
            background-color: #f2f2f2;
        }

        .c {
            display: block;
            margin-top: 10px;
            box-shadow: 0 0 20px rgba(234, 79, 18, 0.8);
            animation: shadowBlinkOrange 1s infinite alternate;
            font-family: 'Georgia', serif;
            background-color: #fff;
        }
        @keyframes combinedAnimation {
            0% {
                transform: rotate(0deg) translateX(0px) translateY(0px);
            }
            25% {
                transform: rotate(180deg) translateX(100px) translateY(100px);
            }
            50% {
                transform: rotate(360deg) translateX(0px) translateY(0px);
            }
            75% {
                transform: rotate(540deg) translateX(-100px) translateY(-100px);
            }
            100% {
                transform: rotate(720deg) translateX(0px) translateY(0px);
            }
        }
        @keyframes shadowBlinkGreen {
            0% {
                box-shadow: 0 0 20px rgba(0, 128, 0, 0.8);
            }
            50% {
                box-shadow: none;
            }
            100% {
                box-shadow: 0 0 20px rgba(0, 128, 0, 0.8);
            }
        }

        @keyframes shadowBlinkPurple {
            0% {
                box-shadow: 0 0 20px rgba(49, 0, 128, 0.8);
            }
            50% {
                box-shadow: none;
            }
            100% {
                box-shadow: 0 0 20px rgba(49, 0, 128, 0.8);
            }
        }

        @keyframes shadowBlinkOrange {
            0% {
                box-shadow: 0 0 20px rgba(234, 79, 18, 0.8);
            }
            50% {
                box-shadow: none;
            }
            100% {
                box-shadow: 0 0 20px rgba(234, 79, 18, 0.8);
            }
        }
    </style>
</head>
<body>
<div class="all">
    <form id="user" action="/ch4/register/add" method="post" onsubmit="return check(this)">

        <div class="a">
            <h1>회원가입</h1>
            <p>아이디</p>
            <input type="text" class="in" name="id" placeholder="ID"/>
            <p>비밀번호</p>
            <input type="password" class="in" name="pwd" placeholder="password"/>
            <p>이름</p>
            <input type="text" class="in" name="name" placeholder="이름"/>
            <p>이메일</p>
            <input type="email" class="in" name="email" placeholder="이메일"/>
            <p>생일</p>
            <input type="text" class="in" name="birth" placeholder="생일"/>
            <br>
            <div class="b">
                <input type="checkbox" name="sns" value="katok"/>카카오톡
                <input type="checkbox" name="sns" value="insta"/>인스타
                <input type="checkbox" name="sns" value="fb"/>페북
            </div>
            <span class="c">
                    <button>회원 가입</button>
                </span>
        </div>

    </form>
</div>
<script>
    function check(form) {
        var email = form.email.value; //폼의 네임속성이 email인거의 값을 가져온다.
        var regularEx = /^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]{2,}$/;
        //    /^ 정규식의 시작
        // 알파벳+@알파벳+.com
        //  $/ 는 정규식의 끝
        if (!(regularEx.test(email))) {
            alert("이메일 주소를 다시 입력해주세요.");
            return false; // 폼 제출 못함
        }
        return true;
        //레지스터폼에서는 이런방식으로한다.
        <%--function setMessage(msg, element){--%>
        <%--    document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> \${msg}</i>`;--%>
        <%--    document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;--%>

        <%--    if(element) {--%>
        <%--        element.select();--%>
        <%--    }--%>
        <%--}--%>
    }
</script>
</body>

</html>