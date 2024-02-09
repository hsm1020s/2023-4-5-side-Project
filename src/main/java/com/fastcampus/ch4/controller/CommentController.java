package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.CommentDto;
import com.fastcampus.ch4.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class CommentController {
    @Autowired
    CommentService service;
//    {
//        "pcno":0,
//            "comment" : "bye",
//            "commenter" : "asdf"
//    }

    //댓글을 수정하는 메서드

    @PatchMapping("/comments/{cno}") // /ch4/comments/cno PATCH
    //PathVariable에서 받아온다 {cno}
    public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentDto dto,HttpSession session){
           String commenter = (String)session.getAttribute("id");
        //String commenter = "asdf"; //  수정하기전 원래 이거였음.
        dto.setCommenter(commenter); //로그인을 안하고있기 때문에 하드코딩 고쳐야한다.

        dto.setCno(cno);
        //dto의 cno를 받아온거로 수정해준다.
        System.out.println("dto = " + dto);

        try {
            if(service.modify(dto)!=1)
                // 수정하지 못하면
                throw new Exception("Write failed.");
                //예외가 터진다.
            return new ResponseEntity<>("MOD_OK",HttpStatus.OK);
            //수정에 성공하면 return으로 응답을 전달한다.
            //http 상태를 200으로 해주고 응답을 전달해준다.
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("MOD_ERR",HttpStatus.BAD_REQUEST);
            //400에러가 터진다.
        }

    }


//    {
//        "pcno":0,
//            "comment" : "hi"
//    }

    //댓글을 등록하는 메서드

    @PostMapping("/comments") // /comments?bno=1085 POST
    public ResponseEntity<String> write(@RequestBody CommentDto dto,Integer bno, HttpSession session){
           String commenter = (String)session.getAttribute("id");
           //세션에서 아이디 받아온다.
        //String commenter = "asdf"; 수정하기전에 이거였음.
        dto.setCommenter(commenter);
        // dto 객체에 아이디를 넣어 세팅해준다.
        dto.setBno(bno);
        // dto객체에 게시물번호를 넣어 세팅해준다.
        System.out.println("dto = " + dto);
        // dto 출력해본다.

        try {
            if(service.write(dto)!=1)  // 작성에 실패하면
                throw new Exception("Write failed.");
            //  실패 예외를 생성한다.

            return new ResponseEntity<>("WRT_OK",HttpStatus.OK);
            //  성공하면 상태코드200과 응답 객체를 반환
        } catch (Exception e) {
            e.printStackTrace(); //실패하면 정보 출력
            return new ResponseEntity<String>("WRT_ERR",HttpStatus.BAD_REQUEST);
            //실패하면 상태코드 400과 응답객체생성.
        }

    }

    //지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{cno}") //  /comments/1?bno=1085 <--삭제할 댓글 번호
    //PathVariable에서 cno를 받아와 경로에 넣어준다.
    public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno, HttpSession session){
        String commenter = (String)session.getAttribute("id");
       // String commenter = "asdf"; // 수정하기전에 이거였음
        try {
            int rowCnt = service.remove(cno,bno,commenter);
            //  댓글을 삭제하고 삭제되면 rowCnt에 1을 반환한다.
            if(rowCnt!=1)
                // 삭제가 실패하면
                throw new Exception("Delete Failed");
                //실패 예외가 뜬다.
            return new ResponseEntity<>("DEL_OK",HttpStatus.OK);
            // 삭제에 성공하면 성공했다는 응답객체를 리턴시킨다.
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR",HttpStatus.BAD_REQUEST);
            //삭제에 실패하면 400에러와 실패응답객체를 반환한다.
        }
    }

    //지정된 게시물의 모든  댓글을 가져오는 메서드
    @GetMapping("/comments") //comments?bno=1080 get
    @ResponseBody ResponseEntity<List<CommentDto>> list(Integer bno){
        //  ResponseBody는 메서드의 반환값을 HTTP 응답의 본문(body)에 직접 작성하도록 지정.
        List<CommentDto> list =null;
        //list를 초기화한다 나중에 getList를 통해 얻은 댓글 목록을 저장할 변수이다.
        try {
            list =  service.getList(bno);
            // 해당하는 댓글 목록을 getList는 db에서 bno에 해당하는 댓글 목록을 조회해서 가져온다.
            System.out.println("list = " + list);
            // list를 한번 출력해본다.
            return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);//200
            //성공하면 list를 포함한 ResponseEntity객체를 생성해서 반환
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentDto>>(HttpStatus.BAD_REQUEST);//400
            //실패하면 실패 응답코드 반환
        }

    }
}
