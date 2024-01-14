package com.DSYJ.project.controller;

import com.DSYJ.project.domain.Posting;
import com.DSYJ.project.service.PostingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {

    private final PostingService postingService;

    public NoticeController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/submit_notice")
    public String submitNotice(@ModelAttribute PostingForm form) {
        Posting posting = new Posting();
        posting.setAuthor(form.getAuthor());
        posting.setContent(form.getContent());
        posting.setTitle(form.getTitle());
        posting.setPassword(form.getPassword());
        posting.setFile("다검.file");
        posting.setImage("다검.image");
        posting.setLink("다검.link");
        posting.setVideo("다검.video");

        postingService.postSave(posting);
        return "redirect:/notice";
    }

}
