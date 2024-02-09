//package com.fastcampus.ch4.controller;
//
//import com.fastcampus.ch4.domain.MessageDto;
//import com.fastcampus.ch4.domain.SmsResponseDto;
//import com.fastcampus.ch4.service.SmsService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URISyntaxException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//@RequiredArgsConstructor
//@RestController
//public class SmsController {
//
//    private final SmsService smsService;
//
//    @PostMapping("/sms/send")
//    public SmsResponseDto sendSms(@RequestBody MessageDto messageDto) throws UnsupportedEncodingException, URISyntaxException, NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException, InvalidKeyException {
//        SmsResponseDto responseDto = smsService.sendSms(messageDto);
//        return responseDto;
//    }
//}