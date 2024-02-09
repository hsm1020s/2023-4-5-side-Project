<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body>
<h2>{name:"abc", age:10}</h2>
<button id="sendBtn" type="button">SEND</button>
<h2>Data From Server :</h2>
<div id="data"></div>

<script>
    $(document).ready(function(){
        //이 부분은 문서가 로드된 후에 실행되어야 하는 자스 코드를 정의
        // 문서가 준비된 상태에서 다음 내용을 실행하도록 한다.
        let person = {name:"abc", age:10};
        let person2 = {}; //빈 객체로 선언
        $("#sendBtn").click(function(){
            //id가 sendBtn인 버튼을 클릭했을때 실행되는 이벤트 핸들러.
            $.ajax({
                //$.ajax({}) 는 제이쿼리 사용해서 ajax 요청을 보내는 함수
                //함수의 인자로 요청 메서드,요청URI,요청 헤더, 전송받을 데이터타입,
                //서버로 전송할 데이터, 성공 및 에러 콜백 함수 등을 설정합니다.

                type:'POST',       // 요청 메서드
                url: '/ch4/send',  // 요청 URI
                headers : { "content-type": "application/json"}, // 요청 헤더
                dataType : 'text', // 전송받을 데이터의 타입
                data : JSON.stringify(person),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                success : function(result){
                    //서버로부터 응답이 도착했을떄 호출되는 함수, 응답 데이터는 result 매개변수로 전달
                    person2 = JSON.parse(result);    // 서버로부터 응답이 도착하면 호출될 함수
                    //
                    alert("received="+result);       // result는 서버가 전송한 데이터
                    //받은 데이터를 알림 창으로 표시한다
                    $("#data").html("name="+person2.name+", age="+person2.age);
                    //서버로부터 전송된 데이터를 사용하여 html 요소인 data의 내용을 변경한다.
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
            alert("the request is sent") // ajax요청이 전송되었음을 알림 창으로 표시한다.
        });
    });
    // 결과적으로 이 코드는 sendBtn 버튼을 클릭하면 서버로 ajax요청을 보내고, 서버에서 응답을 받아와서
    // 결과를 처리하는 동작을 구현하고 있습니다.
</script>
</body>
</html>