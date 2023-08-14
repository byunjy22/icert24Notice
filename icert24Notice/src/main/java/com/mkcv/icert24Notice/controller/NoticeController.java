package com.mkcv.icert24Notice.controller;

import com.mkcv.icert24Notice.exception.NoticeNotFoundException;
import com.mkcv.icert24Notice.model.Notice;
import com.mkcv.icert24Notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3001")
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;

    @PostMapping("/saveNotice")
    Notice newNotice(@RequestBody Notice newNotice) {
        return noticeRepository.save(newNotice);
    }

    @GetMapping("/getNoticeCount")
    public long getNoticeCount(){
        return noticeRepository.count();
    }
    /*
    @GetMapping("/getLimit/{loc,number}")

    List<Notice> findByNoticeSeqBetween(long, long){
        return noticeRepository.findById
    } */

    @GetMapping("/getNotices")
    List<Notice> getAllNotice() {
        return noticeRepository.findAll();
    }

    @GetMapping("/getNotice/{notice_seq}")
    Notice getNoticeById(@PathVariable Long notice_seq) {
        return noticeRepository.findById(notice_seq)
                .orElseThrow(() -> new NoticeNotFoundException(notice_seq));
    }

    @PutMapping("/updateNotice/{notice_seq}")
    Notice updateNotice(@RequestBody Notice newNotice, @PathVariable Long notice_seq) {
        return noticeRepository.findById(notice_seq)
                .map(notice -> {
                    notice.setNotice_seq(newNotice.getNotice_seq());
                    notice.setNotice_scope_cd(newNotice.getNotice_scope_cd());
                    notice.setCategory_cd(newNotice.getCategory_cd());
                    notice.setTitle(newNotice.getTitle());
                    notice.setContents(newNotice.getContents());
                    notice.setHit_cnt(newNotice.getHit_cnt());
                    notice.setTopfix_yn(newNotice.getTopfix_yn());
                    notice.setFile_yn(newNotice.getFile_yn());
                    notice.setReg_dt(newNotice.getReg_dt());
                    notice.setReg_usr_seq(newNotice.getReg_usr_seq());
                    notice.setMod_dt(newNotice.getMod_dt());
                    notice.setMod_usr_seq(newNotice.getMod_usr_seq());
                    return noticeRepository.save(notice);
                }).orElseThrow(() -> new NoticeNotFoundException(notice_seq));
    }

    @DeleteMapping("/deleteNotice/{notice_seq}")
    String deleteNotice(@PathVariable Long notice_seq) {
        if (!noticeRepository.existsById(notice_seq)) {
            throw new NoticeNotFoundException(notice_seq);
        } else {
            noticeRepository.deleteById(notice_seq);
            return "Notice with notice_seq has been deleted successfully.";
        }
    }
}