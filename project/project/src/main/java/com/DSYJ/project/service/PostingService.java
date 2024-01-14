package com.DSYJ.project.service;

import com.DSYJ.project.domain.Posting;
import com.DSYJ.project.repository.PostingRepository;
import jakarta.transaction.Transactional;


@Transactional
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepository = postingRepository;
    }

    public void postSave(Posting posting) {
        postingRepository.save(posting);
    }
}
