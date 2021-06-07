package com.assignment.serverapp.controller;

import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.service.SearchService;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/question")
public class SearchController {
    private final SearchService searchService;

    /***
     * simple search functionality using specification
     * @return list of questions in desired order
     */
    @GetMapping("/get")
    public ResponseEntity<List<Question>> getSearchResult(@Or({
                    @Spec(path = "user.userName", params = "query", spec = Like.class),
                    @Spec(path = "user.fullName", params = "query", spec = Like.class),
                    @Spec(path = "product.name", params = "query", spec = Like.class),
                    @Spec(path = "title", params = "query", spec = Like.class),
                    @Spec(path = "subject", params = "query", spec = Like.class),
                    @Spec(path = "text", params = "query", spec = Like.class),
                    @Spec(path = "creationDate", params = {"after", "before"}, spec = Between.class, config="yyyy-MM-dd")
            }) Specification<Question> spec,
            Sort sort) {
        return new ResponseEntity<>(searchService.get(spec, sort), HttpStatus.OK);
    }
}
