package com.fastcampus.ch4.domain;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // return User.class.equals(clazz); // 검증하려는 객체가 User타입인지 확인
        return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user =(User)target;
        System.out.println("user.getId()1 = " + user.getId());
        System.out.println("user.getPwd()1 = " + user.getPwd());
        String id = user.getId();
        String pwd = user.getPwd();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd","required");

        if(id==null || id.length()<4 || id.length()>12){
            errors.rejectValue("id","required");
            System.out.println("id다시쳐주세요");
        }
//        if(pwd==null|| pwd.length()<5 || pwd.length()>12){
//            errors.rejectValue("pwd","required");
//        }
    }
}