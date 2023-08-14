package com.icert24.icert24Notice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notice {
  @Id
  @GeneratedValue
  Long notice_seq;
  int notice_scope_cd; // '공개범위'
  int category_cd;//'공지카테고리',
  String title =""; // '제목',
  String contents =""; // '내용',
  int hit_cnt = 0; // '조회수',
  char topfix_yn = 'N'; // '상단고정여부',
  char file_yn = 'N'; // '첨부파일여부',
  Date reg_dt = new Date(); // '등록일시',
  Long reg_usr_seq=0L; // '등록자SEQ',
  Date mod_dt; // '수정일시',
  Long mod_usr_seq = 0L; // '수정자SEQ',

    public Long getNotice_seq() {
        return notice_seq;
    }

    public void setNotice_seq(Long notice_seq) {
        this.notice_seq = notice_seq;
    }

    public int getNotice_scope_cd() {
        return notice_scope_cd;
    }

    public void setNotice_scope_cd(int notice_scope_cd) {
        this.notice_scope_cd = notice_scope_cd;
    }

    public int getCategory_cd() {
        return category_cd;
    }

    public void setCategory_cd(int category_cd) {
        this.category_cd = category_cd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getHit_cnt() {
        return hit_cnt;
    }

    public void setHit_cnt(int hit_cnt) {
        this.hit_cnt = hit_cnt;
    }

    public char getTopfix_yn() {
        return topfix_yn;
    }

    public void setTopfix_yn(char topfix_yn) {
        this.topfix_yn = topfix_yn;
    }

    public char getFile_yn() {
        return file_yn;
    }

    public void setFile_yn(char file_yn) {
        this.file_yn = file_yn;
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    public Long getReg_usr_seq() {
        return reg_usr_seq;
    }

    public void setReg_usr_seq(Long reg_usr_seq) {
        this.reg_usr_seq = reg_usr_seq;
    }

    public Date getMod_dt() {
        return mod_dt;
    }

    public void setMod_dt(Date mod_dt) {
        this.mod_dt = mod_dt;
    }

    public Long getMod_usr_seq() {
        return mod_usr_seq;
    }

    public void setMod_usr_seq(Long mod_usr_seq) {
        this.mod_usr_seq = mod_usr_seq;
    }
}
