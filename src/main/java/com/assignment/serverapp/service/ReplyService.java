package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.repository.ReplyRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final LikeService likeService;

    /***
     * store response to database
     * @param replyDto object containing values
     * @return true if success else false
     */
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

    /***
     * find replies for given question id
     * @param id question id
     * @return list of replies matching question id
     */
    public List<Reply> getReplyByQuestion(Integer id) {
        return replyRepository.findByQuestion(Question.builder().questionId(id).build());
    }

    /***
     * find reply by reply id
     * @param id reply id to find
     * @return reply object
     */
    public Optional<Reply> getReplyById(Integer id) {
        return replyRepository.findById(id);
    }

    /***
     * add like to the given reply
     * @param likeReplyDto object containing details like user id reply id etc
     * @return true if success else false
     */
    public boolean likeReply(LikeReplyDto likeReplyDto) {
        return likeService.save(likeReplyDto);
    }

    /***
     * for getting no of likes for given reply
     * @param id reply to get like count
     * @return count if reply exist else bad request resonse
     */
    public ResponseEntity<String> getLikeByReplyId(Integer id) {
        return replyRepository.existsById(id) ?
                ResponseEntity.status(HttpStatus.OK)
                        .body(likeService.findByReply(id)) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("REPLY_NOT_EXIST");
    }

    /***
     * simple service for giving reply count for stats api
     * @return integer value of count
     */
    public long getCount() {
        return replyRepository.count();
    }
}
