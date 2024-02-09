package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.domain.User;
import com.fastcampus.ch4.domain.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserDao userDao; //유저다오를 주입받는다.
    //  /register/add GET요청이 오면 registerForm.jsp를 보여준다.
    @GetMapping("/add")
    public String add() {
        return "registerForm";
        //register/add 요청이 오면 회원가입화면을 보여준다.
    }

    //  /register/add POST요청이 오면, UserDao를 이용해서 DB에 사용자 정보를 저장(validataion은 생략)
    @PostMapping("/add") //원래 add 였음
    public String addpo(HttpSession session, Model m, @Valid User user, BindingResult result) throws Exception {
        UserValidator userValidator = new UserValidator();   //유저밸리데이터
       userValidator.validate(user,result);

        if(result.hasErrors()){
            System.out.println("들어감");
            System.out.println("result = " + result);
            return "registerForm";
            // return "redirect:/registerForm";
        }
        //검증에서 에러가 생기면 다시 회원가입화면으로 돌아간다. // 근데 나중에는 기존 작성한 내용도 보여줘야할듯.
        System.out.println("\"1번\" = " + "1번");
        //검증하고 저장해야함.
        System.out.println("user.getBirth().getClass() = " + user.getBirth().getClass());
        session.setAttribute("id",user.getId());
        //세션에 유저의 아이디를 저장한다 .
        m.addAttribute("user",user);
        // 모델에 유저를 저장한다.
        userDao.insertUser(user);
        // 유저를 db에 추가한다.
        System.out.println("\"2번\" = " + "2번");
        return "index"; //임시로 index 때려놈 + toURL 붙여줘야한다. 방법찾자.
        //회원가입 성공했을시 이전화면으로 보내줘야할것같다.
    }
    @InitBinder
    public void toDate(WebDataBinder binder){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(df,false));
        binder.setValidator(new UserValidator()); //validator를 WebDataBinder에 등록

        List<Validator> validators = binder.getValidators();
        System.out.println("validators = " + validators);
    }

    //  사용자 정보 페이지(userInfo.jsp)에 사용자가 입력한 내용을 모두 보여준다.
    // RegisterController의 /register/add POST가 연결된 메서드에 UserValidator를 적용
    // 메뉴에서 로그인을 클릭하고 새로 등록한 사용자 정보로 로그인이 가능한지 확인
//    @PostMapping("/usermake") // UserValidator를 적용 어떻게함.
//    public String usermake(HttpSession session, Model m, HttpServletRequest request) throws Exception {
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        LocalDate nal = LocalDate.now();
//
//        String id = request.getParameter("id");
//        String pwd = request.getParameter("password");
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        Date birth = dateFormat.parse(request.getParameter("birth"));
//        String sns = request.getParameter("sns");
//        Date reg_date = dateFormat.parse(String.valueOf(nal));
//
//        User1 user = new User1(id, pwd, name, email, birth, sns, reg_date);
//
//        m.addAttribute("user", user);  //모델에 저장
//        return "forward:/register/add";
//    }
}