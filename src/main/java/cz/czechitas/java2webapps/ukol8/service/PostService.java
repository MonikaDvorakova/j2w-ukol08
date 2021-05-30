package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Service
public class PostService {

    private PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Page<Post> post(Pageable pageable) {
        return repository.findByPublishedBeforeAndPublishedNotNull(LocalDate.now(), pageable);
    }

    public Post singlePost(String slug) {
        return repository.findBySlug(slug);
    }
}
