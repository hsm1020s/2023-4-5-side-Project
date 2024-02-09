<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>회원가입화면</title>
  <style>
    /* 기본적으로 dropdown list 숨김 */
    .select-list {
      display: none;
    }

    /* 선택된 경우에만 dropdown list 표시 */
    .ui-select.active .select-list {
      display: block;
    }

    /* 아이디찾기 타이틀 스타일 */
    .search-title {
      font-size: 24px;
      color: #333;
      text-align: center;
      padding: 20px 0;
    }

    /* 폼 스타일 */
    #find-id-form {
      width: 80%;
      margin: 0 auto;
      background-color: #f5f5f5;
      padding: 20px;
      border-radius: 8px;
    }

    /* 인풋 스타일 */
    .input-text {
      width: 100%;
      padding: 10px;
      border-radius: 4px;
      border: 1px solid #ddd;
      margin-bottom: 10px;
    }

    /* 버튼 스타일 */
    .btn-basic-lg2 {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    .btn-basic-lg2:hover {
      background-color: #0056b3;
    }

    /* 비활성화 버튼 스타일 */
    .btn-dim {
      background-color: #ccc;
      cursor: not-allowed;
    }
  </style>
</head>
<body>
<div class="join-area type2">
  <h2 class="search-title">아이디찾기</h2>
  <form id="find-id-form" action="/경로" method="post" onsubmit="return onSubmitFindMemberId();"
        data-gtm-form-interact-id="0"><input type="hidden" name="_csrf"
                                             value="d32bfca1-52bf-458d-952e-2eca33b1c6d6"><input type="hidden" id="find-member-id-phone-no-text"
                                                                                                 name="find-member-id-phone-no-text" value="">
    <input type="hidden" id="find-member-id-email-text" name="find-member-id-email-text" value="">
    <fieldset class="form-group-area">
      <legend>아이디 찾기 방식 선택</legend>
      <ul class="find-id-list">
        <!-- 이메일로 찾기 -->
        <li>
          <div class="custom-radio">
            <input type="radio" id="find-member-id-radio-2" class="radio" value="email"
                   name="find-member-id-radio" data-gtm-form-interact-field-id="0">
            <label for="find-member-id-radio-2">이메일로 찾기</label>
          </div>
          <div id="find-member-id-email-input-group" class="ui-radio-content active">
            <div class="input-group type-lg w-full">
              <label for="find-member-id-name-text2" class="blind">이름 입력</label>
              <input type="text" id="find-member-id-name-text2" name="find-member-id-name-text2"
                     class="input-text" placeholder="이름 2자 이상 입력" maxlength="50"
                     onkeyup="onBlurFindMemberIdInput();" onblur="onBlurFindMemberIdInput();">
            </div><!--// input-group -->
            <div id="find-member-id-name-error2"></div>
            <div class="input-group type-lg w-full">
              <input type="text" id="find-member-id-email-prefix" name="find-member-id-email-prefix"
                     class="input-text" placeholder="이메일 주소" onkeyup="onBlurFindMemberIdInput();"
                     onblur="onBlurFindMemberIdInput();">
              <div class="input-group-form">
                <div class="ui-select select-box w135" id="find-member-id-email-domain"
                     data-value="">
                  <a href="#none" title="선택" class="select-value"><span>직접입력</span></a>
                  <div class="select-list">
                    <ul>
                      <li data-name=""><a href="#none"><span>직접입력</span></a></li>
                      <li data-name="naver.com"><a href="#none"><span>naver.com</span></a>
                      </li>
                      <li data-name="daum.net"><a href="#none"><span>daum.net</span></a></li>
                      <li data-name="hanmail.net"><a href="#none"><span>hanmail.net</span></a>
                      </li>
                      <li data-name="gmail.com"><a href="#none"><span>gmail.com</span></a>
                      </li>
                      <li data-name="hotmail.com"><a href="#none"><span>hotmail.com</span></a>
                      </li>
                      <li data-name="yahoo.co.kr"><a href="#none"><span>yahoo.co.kr</span></a>
                      </li>
                      <li data-name="chollian.net"><a
                              href="#none"><span>chollian.net</span></a></li>
                      <li data-name="empal.com"><a href="#none"><span>empal.com</span></a>
                      </li>
                      <li data-name="freechal.com"><a
                              href="#none"><span>freechal.com</span></a></li>
                      <li data-name="hitel.net"><a href="#none"><span>hitel.net</span></a>
                      </li>
                      <li data-name="hanmir.com"><a href="#none"><span>hanmir.com</span></a>
                      </li>
                      <li data-name="hanafos.com"><a href="#none"><span>hanafos.com</span></a>
                      </li>
                      <li data-name="korea.com"><a href="#none"><span>korea.com</span></a>
                      </li>
                      <li data-name="lycos.co.kr"><a href="#none"><span>lycos.co.kr</span></a>
                      </li>
                      <li data-name="nate.com"><a href="#none"><span>nate.com</span></a></li>
                      <li data-name="netian.com"><a href="#none"><span>netian.com</span></a>
                      </li>
                      <li data-name="paran.com"><a href="#none"><span>paran.com</span></a>
                      </li>
                      <li data-name="unitel.co.kr"><a
                              href="#none"><span>unitel.co.kr</span></a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div><!--// input-group -->
            <div id="find-member-id-email-error"></div>
            <div class="btn-bottom-area" style="margin-top:20px;">
              <button type="submit" id="find-member-id-submit-btn" class="btn-basic-lg2 btn-primary"><span>확인</span></button>
            </div><!--// btn-bottom-area -->
          </div><!--// ui-radio-content -->
        </li><!--// 이메일로 찾기 -->
      </ul>
    </fieldset>
  </form>

</div>
</body>
<script>
  window.onload = function() {
    var selectValue = document.querySelector('.select-value');
    var selectList = document.querySelector('.select-list');
    var uiSelect = document.querySelector('.ui-select');
    selectValue.addEventListener('click', function(e) {
      e.preventDefault();
      // "직접입력"을 클릭하면 dropdown list 표시/숨김
      if (uiSelect.classList.contains('active')) {
        uiSelect.classList.remove('active');
      } else {
        uiSelect.classList.add('active');
      }
    });
  };
</script>

</html>