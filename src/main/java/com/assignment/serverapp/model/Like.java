package com.assignment.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Likes")
public class Like {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int likeId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;
}
