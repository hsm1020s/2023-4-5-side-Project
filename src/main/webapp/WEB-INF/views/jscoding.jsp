<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<%--
  Created by IntelliJ IDEA.
  User: huis9
  Date: 2023-05-27
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>정석코딩</title>
    <style>
        *{
            margin:0;
            padding:0;
            box-sizing:border-box;
        }
        a, a:link, a:visited{
            color:inherit;
            text-decoration:none;
        }
        li{
            list-style:none;
        }
        .container{
            width:1140px;
            margin:0 auto;
        }
        header{
            position:fixed;
            color:white;
            top:0;
            z-index:1;
            width:100%;
            padding:1rem;
        }
        header .container{
            display:flex;
            justify-content:space-between;
            align-items:center;
            width:100%;
        }
        header nav ul{
            display:flex;
        }
        header nav ul li{
            padding:10px;
        }
        header button{
            background: transparent;
            border:0;
            cursor: pointer;
            color:white;
        }
        header h1 button{
            font-size: 2rem;
            font-weight: bold;
        }
        header nav ul li button{
            font-size: 1.2rem;
        }
        /* End header.css */
        /* main.css */
        main{
            width:100%;
            height:100vh;
            color:white;
            background:linear-gradient(rgba(0,0,0,0.8), rgba(0,0,0,0.8)), url('images/me.jpg') center center;
            background-size:cover;
            display:flex;
            justify-content:center;
            align-items:center;
            text-align:center;
        }
        main h4{
            font-size:2rem;
        }
        main h2{
            font-size:3.5rem;
            margin:2rem 0;
            letter-spacing:3px;
            font-family:'Varela Round', sans-serif; /* 웹 폰트 추가 */
        }
        main p{
            max-width:500px;
            margin:0 auto;
            font-size:1.25rem;
        }


        @keyframes upDown{
            0%{
                bottom:1rem;
            }
            50%{
                bottom:1.5rem;
            }
            100%{
                bottom:1rem;
            }
        }

        @keyframes blink {
            0%{
                opacity: 1;
            }
            100%{
                opacity: 0;
            }
        }
        /* about_me.css */
        section{
            font-family:'Poppins', sans-serif;
            padding:5rem 0;
        }
        section:nth-child(2n){
            background-color:#f8f8f8;
        }
        section .title{
            margin-bottom:3rem;
        }
        section .title h4{
            font-size:1.35rem;
            color:#ed4848;
            position:relative;
        }
        section .title h2{
            font-size:3.5rem;
        }
        section .title p{
            font-size:1.15rem;
        }
        /* float 속성 해제 */
        section .about-self::after{
            content:"";
            clear:both;
            display:block;
        }
        /* 본문 너비 절반 지정 & 왼쪽 배치 */
        section .about-self .left{
            width:50%;
            float:left;
        }
        /* 이미지 크기가 부모 영역을 넘지 않도록 부모 영역의 최대 크기로 지정 */
        section .about-self .left img{
            max-width:100%;
        }
        /* 본문 너비 절반 지정 & 오른쪽 배치 */
        section .about-self .right{
            width:50%;
            float:left;
            padding:0 2rem;
        }
        /* 본문 오른쪽 h3 태그의 글자 크기와 여백 지정 */
        section .about-self .right h3{
            font-size:2.25rem;
            margin-bottom:1rem;
        }

        /* 본문 오른쪽 p 태그의 크기와 여백 지정 */
        section .about-self .right p{
            font-size:1.15rem;
            margin:1rem 0;
        }
        /* 본문 오른쪽의 아이콘 폰트 크기와 여백 지정 */
        section .about-self .right .social a{
            font-size:2.5rem;
            margin-right:0.2rem;
        }
        /* End about_me.css */
        /* what_i_do.css */
        /* float 속성 해제*/
        section .do-me::after{
            content:"";
            display:block;
            clear:both;
        }
        /* 사각형 크기와 간격, 내부 여백 설정 */
        section .do-me .do-inner{
            background-color:#fff;
            width:30%;
            padding:2rem;
            float:left;
            margin-right:5%;
            cursor:pointer;
        }
        /* 마지막 사각형의 외부 여백 설정 */
        section .do-me .do-inner:last-child{
            margin-right:0;
        }
        /* 아이콘 폰트 크기와 색상 */
        section .do-me .do-inner .icon i{
            font-size:2.5rem;
            color:#ff6a6a;
        }
        /* HTML5, CSS3, BootStrap v5.0 텍스트 크기와 간격 */
        section .do-me .do-inner .content h3{
            font-size:2rem;
            margin:1rem 0;
        }
        /* 사각형 텍스트 크기 */
        section .do-me .do-inner .content p{
            font-size:1.15rem;
        }
        /* do-inner 클래스에 마우스를 올리면 배경색과 텍스트 색상 변경 */
        section .do-me .do-inner:hover{
            background-color:lightcoral;
            color:white;
        }
        /* do-inner 클래스에 마우스를 올리면 아이콘 폰트 색상 변경 */
        section .do-me .do-inner:hover i{
            color:white;
        }
        /* End what_i_do.css */

        /* Learn.css */
        /* clear 속성으로 float 속성값 해제*/
        section.Learn::after{
            content:"";
            display:block;
            clear:both;
        }
        /* Learn-inner 사각형 꾸미기 */
        section.Learn .Learn-inner{
            width:30%;
            margin-right:5%;
            padding:1rem 1rem 1.5rem 1rem;
            float:left;
            background-color:#f8f8f8;
            border:1px solid #ccc;
            margin-bottom:3rem;
        }
        /* 3번째마다 margin-right 0 적용 */
        section.Learn .Learn-inner:nth-child(3n){
            margin-right:0;
        }
        /* 이미지의 크기가 부모 요소를 넘지 않도록 100%로 지정 */
        section.Learn .Learn-inner img{
            width:100%;
            display:block;
        }

        /* h3 태그 색상과 간격 */
        section.Learn .Learn-inner h3{
            font-size:1.75rem;
        }
        /* End Learn.css */

        /* Consulting_with_me.css */

        section.Consulting .Consulting-me::after{
            content:"";
            display:block;
            clear:both;
        }
        section.Consulting .Consulting-me .left{
            width:30%;
            float:left;
        }
        section.Consulting .Consulting-me .right{
            float:left;
            width:65%;
            margin-left:5%;
        }
        section.Consulting .Consulting-me .left .card{
            border:1px solid #ccc;
            padding:1rem;
            display:flex;
            align-items:center;
            margin-bottom:1.25rem;
        }
        section.Consulting .Consulting-me .left .card .icon i{
            font-size:2rem;
            margin-right:15px;
        }
        section.Consulting .Consulting-me .right{
            float:left;
            width:65%;
            margin-left:5%;
            margin-bottom:2rem;
            border:1px solid #ccc;
            padding:1rem;
        }
        /* form-group 사이 간격 지정 */
        section.Consulting .Consulting-me .right .form-group{
            margin-bottom:1.25rem;
        }
        /* label 태그가 인라인 성격이어서 외부 여백을 적용하기 위해 block으로 변경 */
        section.Consulting .Consulting-me .right .form-group label{
            display:block;
            margin-bottom:0.85rem;
        }
        /* input 요소 꾸미기 */
        section.Consulting .Consulting-me .right .form-group input{
            padding:0.625rem;
            width:100%;
            outline:none;
            border:1px solid #ccc;
            border-radius:10px;
        }

        /* textarea 요소 꾸미기 */
        section.Consulting .Consulting-me .right .form-group textarea{
            height:300px;
            width:100%;
            resize:none;
            border:1px solid #ccc;
            border-radius:10px;
        }
        /* 버튼 요소 꾸미기 */
        section.Consulting .Consulting-me .right button{
            width:100%;
            padding:1rem;
            background-color:#f78b00;
            border:none;
            color:white;
        }

        /* End Consulting_with_me.css */
        /* End media.css */
        header.active{
            background-color:rgba(0,0,0);
            animation:fadeIn 0.5s ease-in-out;
        }
        @keyframes fadeIn{
            0%{
                opacity:0;
            }
            100%{
                opacity:1;
            }
        }
    </style>

</head>

<body>
<!-- header -->
<header>
    <div class="container">
        <h1>
            <button data-animation-scroll="true" data-target="#main">정석코딩</button>
        </h1>
        <nav>
            <ul>
                <li>
<%--                    <button data-animation-scroll="true" data-target="#about">--%>
                        <a href="<c:url value='/'/>">홈</a>
<%--                    </button>--%>
                </li>
                <li>
<%--                    <button data-animation-scroll="true" data-target="#features">--%>
                        <a href="<c:url value='/board/list'/>">상담 예약</a>
<%--                    </button>--%>
                </li>
                <li>
<%--                    <button data-animation-scroll="true" data-target="#Learn">--%>
                        <a href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
<%--                    </button>--%>
                </li>
                <li>
<%--                    <button data-animation-scroll="true" data-target="#Consulting">--%>
                        <a href="<c:url value='/register/add'/>">회원가입</a>
<%--                    </button>--%>
                </li>
            </ul>
        </nav>
    </div>
</header>
<!-- //end header -->
<!-- main -->
<main id="main">
    <div class="container">
        <h4>Welcome</h4>
        <h2 class="active">안녕하세요 정석코딩입니다 </h2>
        <p>종각역 3번출구 근처 종로YMCA 건물에 있습니다.</p>

    </div>
</main>
<!-- //end Main -->
<!-- About Me -->
<section id="about" class="about">
    <div class="container">
        <div class="title">
            <h4>Who Am I</h4>
            <h2>소개합니다</h2>
        </div>
        <div class="about-self">
            <div class="left">
<%--                out.println("<img src='img/dice"+tmp2+".jpg'>");--%>
<%--                img/dice"+tmp2+".jpg  --%>
                <img src='img/boot1.png' alt="">
            </div>
            <div class="right">
                <h3>안녕하세요, 남궁성입니다.</h3>
                <p>최고의 부트캠프 정석코딩에 오신것을 환영합니다.</p>
                <p>저는 2000년에 강의를 처음 시작했고 2003년에 자바의정석 책 집필을 하였습니다.</p>
                <p>실력있는 개발자 양성을 위해 부트캠프를 오픈하였습니다.</p>
                <p>많은 관심 부탁드립니다.</p>
                <div class="social">
                    <a href="#">
                        <i class="fa-brands fa-facebook"></i>
                    </a>
                    <a href="#">
                        <i class="fa-brands fa-instagram"></i>
                    </a>
                    <a href="#">
                        <i class="fa-brands fa-twitch"></i>
                    </a>
                    <a href="#">
                        <i class="fa-brands fa-youtube"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end About Me -->
<!-- What I Do -->
<section id="features" class="do">
    <div class="container">
        <div class="title">
            <h4>Features</h4>
            <h2>어떤 직업을 가지게 될까?</h2>
        </div>
        <div class="do-me">
            <div class="do-inner">
                <div class="icon">
                    <i class="fa-brands fa-html5"></i>
                </div>
                <div class="content">
                    <h3>백엔드 개발자</h3>
                    <p>자바 스프링을 이용한 웹 개발자</p>
                </div>
            </div>
            <div class="do-inner">
                <div class="icon">
                    <i class="fa-brands fa-css3-alt"></i>
                </div>
                <div class="content">
                    <h3>프론트엔드 개발자</h3>
                    <p>W3를 이용한 웹 개발자</p>
                </div>
            </div>
            <div class="do-inner">
                <div class="icon">
                    <i class="fa-brands fa-bootstrap"></i>
                </div>
                <div class="content">
                    <h3>AI 개발자</h3>
                    <p>코틀린,러스트,AI 개발자</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- //end What I Do -->

<!-- Learn -->
<section id="Learn" class="Learn">
    <div class="container">
        <div class="title">
            <h4>Learn</h4>
            <h2>교육과정</h2>
        </div>
        <div class="Learn-me">
            <div class="Learn-inner">
                <img src="img/c1.png" alt="">
                <h5>JAVA</h5>
                <h3>자바의정석3판 </h3>
            </div>
            <div class="Learn-inner">
                <img src="img/c2.jpg" alt="">
                <h5>SQL</h5>
                <h3>SQL요약집</h3>
            </div>
            <div class="Learn-inner">
                <img src="img/c3.png" alt="">
                <h5>HTML,CSS</h5>
                <h3>모던 웹 바이블</h3>
            </div>
            <div class="Learn-inner">
                <img src="img/c4.jpg" alt="">
                <h5>JS</h5>
                <h3>JS요약집</h3>
            </div>
            <div class="Learn-inner">
                <img src="img/c5.jpg" alt="">
                <h5>DB</h5>
                <h3>데이터 모델링</h3>
            </div>
            <div class="Learn-inner">
                <img src="img/c6.png" alt="">
                <h5>Spring</h5>
                <h3>스프링의정석</h3>
            </div>
        </div>
    </div>
</section>
<!-- //end Learn -->

<!-- Consulting  -->
<section id="Consulting" class="Consulting">
    <div class="container">
        <div class="title">
            <h4>Consulting</h4>
            <h2>상담 하는곳</h2>
        </div>
        <div class="Consulting-me">
            <div class="left">
                <div class="card">
                    <div class="icon">
                        <i class="fa-solid fa-phone-volume"></i>
                    </div>
                    <div class="info-text">
                        <h3>phone</h3>
                        <p>02-737-8945</p>
                    </div>
                </div>
                <div class="card">
                    <div class="icon">
                        <i class="fa-solid fa-envelope-open-text"></i>
                    </div>
                    <div class="info-text">
                        <h3>email</h3>
                        <p>castello@naver.com</p>
                    </div>
                </div>
                <div class="card">
                    <div class="icon">
                        <i class="fa-solid fa-location-crosshairs"></i>
                    </div>
                    <div class="info-text">
                        <h3>address</h3>
                        <p>서울특별시 종로구 종로2가 9 </p>
                        <p>5층 517,518,522호</p>
                        <p>4층 423,424,425호</p>
                        <p> 정석코딩학원 </p>
                    </div>
                </div>
            </div>
            <div class="right">
                <form action="#">
                    <div class="form-group">
                        <label for="name">이름</label>
                        <input type="text" id="name">
                    </div>
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="text" id="email">
                    </div>
                    <div class="form-group">
                        <label for="msg">상담내용</label>
                        <textarea id="msg"></textarea>
                    </div>
                    <button>보내기</button>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- end Consulting With Me -->


<script>

    /* 수직 스크롤이 발생하면 header 태그에 active 클래스 추가 및 삭제 */
    const headerEl = document.querySelector("header");
    window.addEventListener('scroll', function(){
        requestAnimationFrame(scrollCheck);
    });
    function scrollCheck(){
        let browerScrollY = window.scrollY ? window.scrollY : window.pageYOffset;
        if(browerScrollY > 0){
            headerEl.classList.add("active");
        }else{
            headerEl.classList.remove("active");
        }
    }



</script>
</body>
</html>
