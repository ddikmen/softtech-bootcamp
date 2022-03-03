package com.softtech.softtech3rdassignment.app.dto.responsedto;

import lombok.Data;

@Data
public class CommentDto {

    private String comment;
    private Long accountId;
    private Long productId;

}
