package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int getCount() throws Exception;  //게시물의 총 개수 반환
    int remove(Integer bno, String writer) throws Exception; // 게시물 삭제

    int write(BoardDto boardDto) throws Exception; //게시물 작성

    List<BoardDto> getList() throws Exception; // 모든 게시물 불러오기

    BoardDto read(Integer bno) throws Exception; //게시물 읽기

    List<BoardDto> getPage(Map map) throws Exception; // 해당 페이지의 게시물 목록 조회

    int modify(BoardDto boardDto) throws Exception; //게시글 수정

    int getSearchResultCnt(SearchCondition sc) throws Exception; // 검색 결과의 총 개수를 반환하는 메서드.

    List<BoardDto> getSearchResultPage(SearchCondition sc) throws Exception;
    //검색 결과를 페이징 처리하여 가져오는 메서드
}
