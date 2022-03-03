package com.softtech.softtech3rdassignment.app.converter;

import com.softtech.softtech3rdassignment.app.dto.responsedto.CommentDto;
import com.softtech.softtech3rdassignment.app.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment convertTo(CommentDto commentDto);
    CommentDto convertToDto(Comment comment);

    List<CommentDto> convertToDtoList(List<Comment> commentList);

}
