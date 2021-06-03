package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.repository.ReplyRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReplyService {

    @Autowired
    ReplyRepository replyRepository;

    @Autowired
    LikeService likeService;

    public boolean save(ReplyDto replyDto) {
        var reply = MapperUtil.getModelMapper().map(replyDto, Reply.class);
        reply.setCreationDate(new Date());
        try {
            replyRepository.save(reply);
        } catch (Exception e) {
            log.error("error in saving reply " + e);
            return false;
        }
        return true;
    }

    public List<Reply> getReplyByQuestion(Integer id) {
        return replyRepository.findByQuestion(Question.builder().questionId(id).build());
    }

    public Optional<Reply> getReplyById(Integer id) {
        return replyRepository.findById(id);
    }

    public boolean likeReply(LikeReplyDto likeReplyDto) {
        return likeService.save(likeReplyDto) ;
    }


    public ResponseEntity<String> getLikeByReplyId(Integer id) {
        return replyRepository.existsById(id) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(likeService.findByReply(id)) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("REPLY_NOT_EXIST");
    }
}
