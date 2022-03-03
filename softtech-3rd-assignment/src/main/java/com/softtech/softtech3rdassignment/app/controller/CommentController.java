package com.softtech.softtech3rdassignment.app.controller;

import com.softtech.softtech3rdassignment.app.dto.RestResponse;
import com.softtech.softtech3rdassignment.app.dto.responsedto.CommentDto;
import com.softtech.softtech3rdassignment.app.service.entityservice.CommentEntityService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

   private final CommentEntityService commentEntityService;

   @PostMapping()
   public ResponseEntity comment(@RequestBody CommentDto commentDto){

      CommentDto responseDto = commentEntityService.postComment(commentDto);

      return ResponseEntity.ok(RestResponse.of(responseDto));
   }

   @GetMapping("/by/productId/{id}")
   public ResponseEntity getAllByProductId(@PathVariable Long id){

      List<CommentDto> commentDtoList = commentEntityService.getByProductId(id);

      return ResponseEntity.ok(RestResponse.of(commentDtoList));
   }

   @GetMapping("/by/accountId/{id}")
   public ResponseEntity getAllByAccountId(@PathVariable Long id){

      List<CommentDto> commentDtoList = commentEntityService.getByAccountId(id);

      return ResponseEntity.ok(RestResponse.of(commentDtoList));

   }

   @DeleteMapping("/{id}")
   public ResponseEntity deleteComment(@PathVariable Long id){

      commentEntityService.delete(id);

      return ResponseEntity.ok(RestResponse.empty());
   }
}
