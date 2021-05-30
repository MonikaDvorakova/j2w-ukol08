package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.awt.print.Pageable;

@Controller
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }
    @GetMapping("/post")
    public ModelAndView postList() {
        return new ModelAndView("index")
                .addObject("posts", service.post(PageRequest.of(0, 20)));
    }

    @GetMapping(path = "/post/{slug}")
    public ModelAndView singlePost(@PathVariable String slug) {
        return new ModelAndView("post_detail")
                .addObject("post", service.singlePost(slug));
    }
}

