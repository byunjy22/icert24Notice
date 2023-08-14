package com.icert24.icert24Notice.repository;

import com.icert24.icert24Notice.model.Notice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
}
