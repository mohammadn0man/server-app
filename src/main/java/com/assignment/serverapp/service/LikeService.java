package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.model.Like;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.repository.LikeRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    /***
     * for count the no of time the given reply is liked
     * @param id reply id
     * @return Count value
     */
    public String findByReply(int id) {
        return likeRepository.findByReply(
                Reply.builder().replyId(id).build()
        ).toString();
    }

    /***
     * store like response to database
     * @param likeReplyDto object with data
     * @return true if success else false
     */
    public boolean save(LikeReplyDto likeReplyDto) {
        var like = MapperUtil.getModelMapper().map(likeReplyDto, Like.class);
        try {
            likeRepository.save(like);
        } catch (Exception e) {
            log.error("error in saving reply " + e);
            return false;
        }
        return true;
    }
}
