package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.dto.QuestionSolutionDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.QuestionRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    /***
     * store question to database
     * @param questionDto question type object
     * @return true if success else false
     */
    public boolean save(QuestionDto questionDto) {
        var question = MapperUtil.getModelMapper().map(questionDto, Question.class);
        question.setCreationDate(new Date());
        try {
            questionRepository.save(question);
        } catch (Exception e) {
            log.error("error in adding request : " + e);
            return false;
        }
        return true;
    }

    /***
     * find all
     * @return list of all questions
     */
    public List<Question> getAll() {
        return (List<Question>) questionRepository.findAll();
    }

    /***
     * get all the questions for given user Id
     * @param id user id
     * @return list all questions match user id
     */
    public List<Question> getByUserId(int id) {
        return questionRepository.findByUser(User.builder().userId(id).build());
    }

    /***
     * get all questions for given product id
     * @param id product id
     * @return list of all questions matches product id
     */
    public List<Question> getByProductId(int id) {
        return questionRepository.findByProduct(Product.builder().productId(id).build());
    }

    /***
     * search all questions for given inputs
     * @param spec query parameter
     * @param sort sorting parameter
     * @return list of all questions matching given parameters
     */
    public List<Question> search(Specification<Question> spec, Sort sort) {
        return questionRepository.findAll(spec, sort);
    }

    /***
     * simple service for giving questions count for stats api
     * @return integer value of count
     */
    public long getCount() {
        return questionRepository.count();
    }

    /***
     * mark answer as solved update the entity in database
     * @param questionSolutionDto object to be updated
     * @return true if success else false
     * @throws RequestParameterException when any parameter is missing
     */
    public boolean markAnswer(QuestionSolutionDto questionSolutionDto) throws RequestParameterException {
        var question = questionRepository.findById(questionSolutionDto.getQuestionId());
        var newQuestion = question.orElseThrow(()->new RequestParameterException("Invalid question Id"));
        newQuestion.setClosedDate(new Date());
        newQuestion.setAcceptedAnswerId(questionSolutionDto.getReplyId());
        try {
            questionRepository.save(newQuestion);
        } catch (Exception e) {
            log.error("error in adding request : " + e);
            return false;
        }
        return true;
    }
}
