package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.model.Like;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.LikeRepository;
import com.assignment.serverapp.repository.ReplyRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ReplyController {
    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    LikeRepository likeRepository;

    @PostMapping("/add_reply")
    public ResponseEntity<String> addReply(@RequestBody ReplyDto replyDto) {
        var reply = MapperUtil.getModelMapper().map(replyDto, Reply.class);
        reply.setCreationDate(new Date());
        try {
            replyRepository.save(reply);
        } catch (Exception e) {
            log.error("error in saving reply " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR : " + e);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("RESPONSE_SUBMITTED");
    }

    @GetMapping("question_reply/{id}")
    public List<Reply> getReplyByQuestionId(@PathVariable Integer id){
        return replyRepository.findByQuestion(Question.builder().questionId(id).build());
    }

    @GetMapping("reply/{id}")
    public Optional<Reply> getReplyForQuestion(@PathVariable Integer id) {
        return replyRepository.findById(id);
    }

    @PostMapping("/like_reply")
    public ResponseEntity<String> likeReply(@RequestBody LikeReplyDto likeReplyDto){
//        var like = MapperUtil.getModelMapper().map(likeReplyDto, Like.class);
        var like = Like.builder()
                .reply(Reply.builder()
                        .replyId(likeReplyDto.getReplyId())
                        .build())
                .user(User
                        .builder()
                        .userId(likeReplyDto.getUserId())
                        .build()).build();
        try {
            likeRepository.save(like);
        } catch (Exception e) {
            log.error("error in saving reply " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR : " + e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("RESPONSE_SAVED");
    }

    @GetMapping("/get_like/{id}")
    public ResponseEntity<String> getLikes(@PathVariable Integer id){
        return replyRepository.existsById(id) ?
                ResponseEntity.status(HttpStatus.OK)
                .body(String.valueOf(
                        likeRepository.findByReply(Reply.builder().replyId(id).build()).size())) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("REPLY_NOT_EXIST");
    }

}
