package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.LikeReplyDto;
import com.assignment.serverapp.model.Like;
import com.assignment.serverapp.model.Reply;
import com.assignment.serverapp.repository.LikeRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LikeService {
    @Autowired
    LikeRepository likeRepository;

    public String findByReply(int id) {
        return likeRepository.findByReply(
                Reply.builder().replyId(id).build()
        ).toString();
    }

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
