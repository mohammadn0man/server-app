package com.assignment.serverapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int questionId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",  timezone = "IST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss",  timezone = "IST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedDate;

    private String title;

    @Column(name = "question_subject")
    private String subject;

    @Column(name = "content", length = 6380)
    private String text;

    private int acceptedAnswerId;
}
