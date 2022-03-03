package com.softtech.softtech3rdassignment.app.service.entityservice;

import com.softtech.softtech3rdassignment.app.converter.CommentMapper;
import com.softtech.softtech3rdassignment.app.dao.CommentDao;
import com.softtech.softtech3rdassignment.app.dto.responsedto.CommentDto;
import com.softtech.softtech3rdassignment.app.entity.Account;
import com.softtech.softtech3rdassignment.app.entity.Comment;
import com.softtech.softtech3rdassignment.app.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentEntityService {

    private final CommentDao commentDao;

    private final AccountEntityService accountEntityService;

    private final ProductEntityService productEntityService;

    public CommentDto postComment(CommentDto commentDto){

        Comment comment = CommentMapper.INSTANCE.convertTo(commentDto);

        commentDao.save(comment);

        return commentDto;
    }

    public List<CommentDto> getByProductId(Long id){

        List<Comment> commentList = commentDao.findAllByProductId(id);

        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToDtoList(commentList);

        return commentDtoList;
    }
    public List<CommentDto> getByAccountId(Long id){

        List<Comment> commentList = commentDao.findAllByAccountId(id);

        List<CommentDto> commentDtoList = CommentMapper.INSTANCE.convertToDtoList(commentList);

        return commentDtoList;
    }

    public void delete(Long id){

        Optional<Comment> commentOptional = commentDao.findById(id);

        if(commentOptional.isPresent()){
            commentDao.delete(commentOptional.get());
        }else{
            throw new RuntimeException("Comment not found!");
        }

    }
}
