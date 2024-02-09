package com.fastcampus.ch4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.PageHandler;
import com.fastcampus.ch4.domain.SearchCondition;
import com.fastcampus.ch4.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/modify")
    public String modify(BoardDto boardDto ,Model m ,HttpSession session,RedirectAttributes rattr){

        String writer = (String)session.getAttribute("id");
        //세션에서 로그인한사람의 아이디를 가져온다.
        boardDto.setWriter(writer);
        //boarddto 객체에 작성자를 세팅해준다.

        try {
            int rowCnt = boardService.modify(boardDto); //insert
            // boardDto를 가지고 boardService의 modify를 호출한다 // 결과로 rowcnt를 받는다.
            if(rowCnt!=1)
                throw  new Exception("modify failed");
            //rowCnt 가 1이 아니면 예외가 터진다.

            rattr.addFlashAttribute("msg", "MOD_OK");
            //일회용 메시지를 위해 msg에 성공했을떄의 메시지를 담는다.
            return "redirect:/board/list"; //게시물목록으로 보내준다.
        } catch (Exception e) {
            e.printStackTrace(); //예외정보가 뜨게해준다.
            m.addAttribute(boardDto); //쓰던 게시물이 살아있게 해준다. //write와 비슷하다.
            m.addAttribute("msg","MOD_ERR");
            //실패했을때의 msg를 모델에 넣어준다.
            return "board"; //게시물로 이동한다.
        }
    }

    @PostMapping("/write")
    public String write(BoardDto boardDto ,Model m ,HttpSession session,RedirectAttributes rattr){

        String writer = (String)session.getAttribute("id");
        //작성자에 세션에서 아이디를 가져온다.
        boardDto.setWriter(writer);
        // 보드디티오 객체에 작성자를 가져온거로 바꿔준다.

        try {
            int rowCnt = boardService.write(boardDto); //insert
            // boardDto를 가지고 boardService의 write가 작동한다. 결과로 rowCnt반환

            if(rowCnt!=1)
                throw  new Exception("Write failed");
            //등록된게 없을시 예외 터진다.

            rattr.addFlashAttribute("msg", "WRT_OK");
            //일회용 메시지로 등록 성공이 뜬다.

            return "redirect:/board/list"; // 게시물목록으로 리다이렉트된다.
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDto); //쓰던 게시물이 살아있게 해준다. 첫글자가 소문자로 들어간다.
            //쓰던 게시물이 살아있을수 있도록 모델에 쓰던걸 담아주고 jsp에서 처리해준다.
            m.addAttribute("msg","WRT_ERR");
            // 모델에 메세지를 출력할 내용을 담아 보드로 리턴해준다.
            return "board";
        }
    }
    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("mode","new");
        //모드를 뉴로 해준다 이건 jsp를 봐야한다.
        return "board"; //읽기와 쓰기에 사용, 쓰기에 사용할때는 mode=new로 준다.
    }

    @PostMapping("/remove")
    public String remove(Integer bno, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("id");
        try {
            m.addAttribute("page",page);
            m.addAttribute("pageSize",pageSize); //모델에 담는게 깔끔하다.
            //삭제전에 page, pageSize 모델에 담는다. ?
            int rowCnt = boardService.remove(bno,writer);
            //삭제하고 결과를 rowCnt에 담는다.
            if(rowCnt!=1)
                throw new Exception("board remove error");
                //삭제가 실패했을경우 예외가 터진다.
            rattr.addFlashAttribute("msg","DELETE_OK");
            //일회용 메세지에 delete ok를 출력한다.
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg","DELETE_ERROR");
            //실패했을경우 삭제실패에러가 뜬다.
        }

        return "redirect:/board/list"; // 보드리스트로 리다이렉트한다.
    }

    @GetMapping("/read")
    public String read(Integer bno, Integer page, Integer pageSize, Model m){
        try {
               BoardDto boardDto = boardService.read(bno);
               // m.addAttribute("boardDto",boardDto); //아래 문장과 동일
               //
                m.addAttribute(boardDto);
                //모델에 boardDto 라는 이름으로 게시물 읽어온거 저장

                m.addAttribute("page",page);
                m.addAttribute("pageSize",pageSize);
                //페이지랑 페이지사이즈도 모델에 저장
        } catch (Exception e) {
            e.printStackTrace(); //에러시 정보 표시
        }
        return "board"; //게시물 보여줌 jsp
    }


    @GetMapping("/list")
    public String list(SearchCondition sc, Model m, HttpServletRequest request) {
        //모델애트리뷰트 자동으로 붙는다 서치컨디션에
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();
        // 로그인을 안했으면 로그인 화면으로 이동

        try {
            int totalCnt = boardService.getSearchResultCnt(sc);
            // 검색 결과의 총 개수를 반환
            m.addAttribute("totalCnt", totalCnt);
            //모델에 토탈카운트를 담는다.

            PageHandler pageHandler = new PageHandler(totalCnt, sc);
            //페이지핸들러에 담아서 페이징처리한다.

            List<BoardDto> list = boardService.getSearchResultPage(sc);
            //검색 결과를 페이징 처리해서 가져온다.
            m.addAttribute("list", list);
            //모델에 검색 결과를 페이징 처리해서 가져온거를 담는다.
            m.addAttribute("ph", pageHandler);
            // 모델에 페이지핸들러 객체를 담는다.

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            //현재 날짜의 시작시간을 나타내는 Instant 객체이다. 5/24이면 해당날짜의 자정에 해당하는 Instant객체를 가리킴.
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
            //에포크 밀리초로 변환하여 모델에 저장

        } catch (Exception e) { // 예외가 터지면.
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            //보드리스트에서 게시물 목록 가져오는데 실패했다 뜨고 토탈카운트를 0으로 준다.
            m.addAttribute("totalCnt", 0);
        }

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean loginCheck(HttpServletRequest request) {
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
        return session.getAttribute("id")!=null;
    }
}