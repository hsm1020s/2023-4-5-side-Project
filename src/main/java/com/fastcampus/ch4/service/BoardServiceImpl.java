package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.*;
import com.fastcampus.ch4.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    @Override
    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception{
        return boardDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception{
        return boardDao.searchResultCnt(sc);
    } // 검색 결과의 총 개수를 반환하는 메서드.

    @Override
    public int getCount() throws Exception { // 게시물의 총 개수 반환
        return boardDao.count();
    }

    @Override
    public int remove(Integer bno, String writer) throws Exception { //게시물 삭제
        return boardDao.delete(bno, writer);
    }

    @Override
    public int write(BoardDto boardDto) throws Exception { //게시물 작성
       // throw new Exception("test");
        return boardDao.insert(boardDto);
    }

    @Override
    public List<BoardDto> getList() throws Exception { //모든 게시물 불러오기
        return boardDao.selectAll();
    }

    @Override
    public BoardDto read(Integer bno) throws Exception { // 게시물 읽기
        BoardDto boardDto = boardDao.select(bno);
        boardDao.increaseViewCnt(bno);

        return boardDto;
    }

    @Override
    public List<BoardDto> getPage(Map map) throws Exception { //특정 페이지의 게시물 목록 조회
        return boardDao.selectPage(map);
    }

    @Override
    public int modify(BoardDto boardDto) throws Exception { //게시글 수정
        return boardDao.update(boardDto);
    }

//    @Override
//    public int getSearchResultCnt(SearchCondition sc) throws Exception {
//        return boardDao.searchResultCnt(sc);
//    }
//
//    @Override
//    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception {
//        return boardDao.searchSelectPage(sc);
//    }
}