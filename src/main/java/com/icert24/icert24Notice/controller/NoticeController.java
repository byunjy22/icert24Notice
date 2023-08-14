package com.icert24.icert24Notice.controller;

import com.icert24.icert24Notice.exception.NoticeNotFoundException;
import com.icert24.icert24Notice.model.Notice;
import com.icert24.icert24Notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NoticeController{
    @Autowired
    NoticeRepository noticeRepository;
    @GetMapping("/noticePages")
    public ResponseEntity retrieveNotices(final Pageable pageable){
        Page<Notice> noticePages = noticeRepository.findAll(pageable);
        return new ResponseEntity<>(noticePages, HttpStatus.OK);
    }
    @PostMapping("/saveNotice")
    Notice newNotice(@RequestBody Notice newNotice){
        return noticeRepository.save(newNotice);
    }

    @GetMapping("/findNotices")
    List<Notice> getAllNotices(){
        return noticeRepository.findAll();
    }

    @GetMapping("/findNotice/{notice_seq}")
    Notice getNoticeByNotice_seq(@PathVariable Long notice_seq){
        return noticeRepository.findById(notice_seq)
                .orElseThrow(()->new NoticeNotFoundException(notice_seq));
    }

    @PutMapping("/updateNotice/{notice_seq}")
    Notice updateNotice(@RequestBody Notice newNotice,@PathVariable Long notice_seq){
        return noticeRepository.findById(notice_seq)
                .map(notice->{
                    notice.setNotice_scope_cd(newNotice.getNotice_scope_cd()); // '공개범위'
                    notice.setCategory_cd(newNotice.getCategory_cd());//'공지카테고리',
                    notice.setTitle(newNotice.getTitle());// '제목',
                    notice.setContents(newNotice.getContents()); // '내용',
                    notice.setHit_cnt(newNotice.getHit_cnt()); // '조회수',
                    notice.setTopfix_yn(newNotice.getTopfix_yn()); // '상단고정여부',
                    notice.setFile_yn(newNotice.getFile_yn()); // '첨부파일여부',
                    notice.setReg_dt(newNotice.getReg_dt()); // '등록일시',
                    notice.setReg_usr_seq(newNotice.getReg_usr_seq()); // '등록자SEQ',
                    notice.setMod_dt(newNotice.getMod_dt()); // '수정일시',
                    notice.setMod_usr_seq(newNotice.getMod_usr_seq()); // '수정자SEQ',

                    return noticeRepository.save(notice);
                }).orElseThrow(()->new NoticeNotFoundException(notice_seq));
    }
    @DeleteMapping("/deleteNotice/{notice_seq}")
    String deleteNotice(@PathVariable Long notice_seq){
        if(!noticeRepository.existsById(notice_seq)){
            throw new NoticeNotFoundException(notice_seq);
        }
        noticeRepository.deleteById(notice_seq);
        return "Notice with notice_seq "+ notice_seq + "has been deleted successfully.";
    }
}
