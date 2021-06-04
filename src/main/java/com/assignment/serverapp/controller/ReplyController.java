package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.service.ReplyService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/add")
    public ResponseEntity<String> addReply(@RequestBody ReplyDto replyDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(replyService.save(replyDto));
    }

    @GetMapping("/question/{id}")
    public List<Reply> getReplyByQuestionId(@PathVariable Integer id) {
        return replyService.getReplyByQuestion(id);
    }

    @GetMapping("/{id}")
    public Optional<Reply> getById(@PathVariable Integer id) {
        return replyService.getReplyById(id);
    }

    @PostMapping("/like")
    public ResponseEntity<String> likeReply(@RequestBody LikeReplyDto likeReplyDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(replyService.likeReply(likeReplyDto));
    }

    @GetMapping("/get/like/{id}")
    public ResponseEntity<String> getLikes(@PathVariable Integer id) {
        return replyService.getLikeByReplyId(id);
    }

}
