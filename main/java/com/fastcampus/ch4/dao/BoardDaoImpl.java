package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;
import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.BoardMapper.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)
    // 게시글개수

    @Override
    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)
    // 모든게시글삭제

    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)
    //게시글삭제

    @Override
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)
    //게시글등록

    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // List<E> selectList(String statement)
    //모든게시글선택

    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    } // T selectOne(String statement, Object parameter)
    //특정게시글선택

    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    } // List<E> selectList(String statement, Object parameter)
    //특정페이지 선택
    @Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)
    //게시글 수정

    @Override
    public int increaseViewCnt(Integer bno) throws Exception {
        return session.update(namespace+"increaseViewCnt", bno);
    } // int update(String statement, Object parameter)
    //조회수 올리기

    @Override
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
        return session.selectList(namespace+"searchSelectPage", sc);
    } // List<E> selectList(String statement, Object parameter)
    //검색결과기반페이지

    @Override
    public int updateCommentCnt(Integer bno, int cnt) {
        Map map = new HashMap();
        map.put("cnt",cnt);
        map.put("bno",bno);
        session.update(namespace+"updateCommentCnt",map);
        return 0;
    }
    //

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
      //  System.out.println("sc in searchResultCnt() = " + sc);
       // System.out.println("session = " + session);
        return session.selectOne(namespace+"searchResultCnt", sc);
    } // T selectOne(String statement, Object parameter)


    //추가 5/20
//    @Override
//    public int count() throws Exception {
//        return session.selectOne(namespace+"count");
//    } // T selectOne(String statement)
//
//    @Override
//    public List<BoardDto> selectPage(Map map) throws Exception {
//        return session.selectList(namespace+"selectPage", map);
//    } // List<E> selectList(String statement, Object parameter)
}