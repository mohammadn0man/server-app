package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.dto.ReplyDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.service.ReplyService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    /***
     * store response to database
     * @param replyDto object containing values
     * @return true if success else false
     */
    @PostMapping("/add")
    public ResponseEntity<String> addReply(@RequestBody ReplyDto replyDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(replyService.save(replyDto));
    }

    /***
     * find replies for given question id
     * @param id question id
     * @return list of replies matching question id
     */
    @GetMapping("/question/{id}")
    public List<Reply> getReplyByQuestionId(@PathVariable Integer id) {
        return replyService.getReplyByQuestion(id);
    }

    /***
     * find reply by reply id
     * @param id reply id to find
     * @return reply object
     */
    @GetMapping("/{id}")
    public Optional<Reply> getById(@PathVariable Integer id) {
        return replyService.getReplyById(id);
    }

    /***
     * add like to the given reply
     * @param likeReplyDto object containing details like user id reply id etc
     * @return true if success else false
     */
    @PostMapping("/like")
    public ResponseEntity<String> likeReply(@RequestBody LikeReplyDto likeReplyDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(replyService.likeReply(likeReplyDto));
    }

    /***
     * for getting no of likes for given reply
     * @param id reply to get like count
     * @return count if reply exist else bad request resonse
     */
    @GetMapping("/get/like/{id}")
    public ResponseEntity<String> getLikes(@PathVariable Integer id) {
        return replyService.getLikeByReplyId(id);
    }

    @ExceptionHandler({RequestParameterException.class})
    public ResponseEntity<String> handleAuthenticationException(RequestParameterException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }
}
