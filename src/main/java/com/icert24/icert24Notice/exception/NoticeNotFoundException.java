package com.icert24.icert24Notice.exception;

public class NoticeNotFoundException extends RuntimeException{
    public NoticeNotFoundException(Long notice_seq){
        super("errroMessage: Could not found the user with id"+notice_seq);
    }
}
