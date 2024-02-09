package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.*;
import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {
//    @Autowired
    BoardDao boardDao;
//    @Autowired
    CommentDao commentDao;
        // 보드다오와 커멘트다오를 주입받는다?
   // @Autowired
    public CommentServiceImpl(CommentDao commentDao, BoardDao boardDao) { //생성자
        this.commentDao = commentDao;
        this.boardDao = boardDao;
        //오토와이어드 대신 사용
    }

    @Override
    public int getCount(Integer bno) throws Exception {
        return commentDao.count(bno);  // 게시물의 카운트 가져온다.
    }

    @Override
    @Transactional(rollbackFor = Exception.class) //  예외가 터지면 롤백친다.
    public int remove(Integer cno, Integer bno, String commenter) throws Exception {
        // 댓글 지우기 기능
        int rowCnt = boardDao.updateCommentCnt(bno, -1);
        // rowCnt 반환 카운트를 1줄이는거에 성공하면.
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
        // rowCnt 찍어본다.
//        throw new Exception("test");
        rowCnt = commentDao.delete(cno, commenter);
        // 댓글 지우고 성공하면 rowCnt가 반환된다 . 의문점은 row카운트를 왜 초기화를 안하느냐이다.
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int write(CommentDto commentDto) throws Exception {
        boardDao.updateCommentCnt(commentDto.getBno(), 1); //댓글 수를 1 증가시킨다.
//                throw new Exception("test");
        return commentDao.insert(commentDto); // 받아온걸 디비에 넣어준다.
    }

    @Override
    public List<CommentDto> getList(Integer bno) throws Exception {
//        throw new Exception("test");
        return commentDao.selectAll(bno); //모든 댓글의 리스트를 불러온다.
    }

    @Override
    public CommentDto read(Integer cno) throws Exception {
        return commentDao.select(cno); // 댓글의 번호를 가져와서 보여준다?
    }

    @Override
    public int modify(CommentDto commentDto) throws Exception {
        return commentDao.update(commentDto); //댓글을 수정한다.
    }
}