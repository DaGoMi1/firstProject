package com.DSYJ.project.controller;

import com.DSYJ.project.domain.Posting;
import com.DSYJ.project.service.PostingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class NoticeController {

    private final PostingService postingService;

    public NoticeController(PostingService postingService) {
        this.postingService = postingService;
    }

    @GetMapping("/notice")
    public String notice(Model model) {
        List<Posting> notice = postingService.findAll();

        model.addAttribute("notice", notice);
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
        posting.setCreated_At(LocalDateTime.now());

        if (form.getImage() != null) {
            // 이미지를 저장하고 그에 대한 URL을 데이터베이스에 저장
            String image = postingService.saveImage(form.getImage());
            posting.setImage(image);
        }
        if (form.getVideo() != null) {
            // 이미지를 저장하고 그에 대한 URL을 데이터베이스에 저장
            String video = postingService.saveVideo(form.getVideo());
            posting.setVideo(video);
        }

        if (form.getFile() != null) {
            // 파일을 저장하고 그에 대한 URL을 데이터베이스에 저장
            String file = postingService.saveFile(form.getFile());
            posting.setFile(file);
        }

        posting.setLink(form.getLink());

        postingService.postSave(posting);
        return "redirect:/notice";
    }

    @GetMapping("/notice/{id}")
    public String viewNotice(@PathVariable Long id,Model model){

        // 글의 세부 내용을 가져오는 메서드 호출
        Optional<Posting> posting = postingService.postId(id);

        // Model에 해당 글의 정보를 추가
        model.addAttribute("posting", posting);

        // 상세 보기 페이지로 이동
        return "noticeDetail";
    }

}
