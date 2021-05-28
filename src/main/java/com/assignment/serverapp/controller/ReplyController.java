package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.repository.ReplyRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Slf4j
@RestController
public class ReplyController {
    @Autowired
    ReplyRepository replyRepository;

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


    @GetMapping("reply/{id}")
    public Optional<Reply> getReplyForQuestion(@PathVariable Integer id) {
        return replyRepository.findById(id);
    }

}
