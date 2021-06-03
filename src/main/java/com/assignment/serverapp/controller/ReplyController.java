package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.service.ReplyService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("/add_reply")
    public ResponseEntity<String> addReply(@RequestBody ReplyDto replyDto) {
        return ResponseUtil.filterResponse(replyService.save(replyDto));
    }

    @GetMapping("question_reply/{id}")
    public List<Reply> getReplyByQuestionId(@PathVariable Integer id) {
        return replyService.getReplyByQuestion(id);
    }

    @GetMapping("reply/{id}")
    public Optional<Reply> getById(@PathVariable Integer id) {
        return replyService.getReplyById(id);
    }

    @PostMapping("/like_reply")
    public ResponseEntity<String> likeReply(@RequestBody LikeReplyDto likeReplyDto) {
        return ResponseUtil.filterResponse(replyService.likeReply(likeReplyDto));
    }

    @GetMapping("/get_like/{id}")
    public ResponseEntity<String> getLikes(@PathVariable Integer id) {
        return replyService.getLikeByReplyId(id);
    }

}
