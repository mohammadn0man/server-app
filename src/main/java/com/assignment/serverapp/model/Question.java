package com.assignment.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue
    private int questionId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String title;
    private String subject;
    private int replyCount;
    private Date creationDate;
    private Date closedDate;
    private int acceptedAnswerId;
}
