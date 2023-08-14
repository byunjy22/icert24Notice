package com.mkcv.icert24Notice.repository;

import com.mkcv.icert24Notice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
