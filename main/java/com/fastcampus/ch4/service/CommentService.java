package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    int getCount(Integer bno) throws Exception; //댓글의 수를 반환

    @Transactional(rollbackFor = Exception.class)
    int remove(Integer cno, Integer bno, String commenter) throws Exception; // 댓글 삭제

    @Transactional(rollbackFor = Exception.class)
    int write(CommentDto commentDto) throws Exception; //댓글 쓰기

    List<CommentDto> getList(Integer bno) throws Exception; //댓글 조회 (모든?)

    CommentDto read(Integer cno) throws Exception; // cno에 해당하는 댓글 조회하는 메서드?

    int modify(CommentDto commentDto) throws Exception; //댓글 수정하는 메서드.
}
