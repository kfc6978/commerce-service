package com.gtelant.commerce.service.repositories;

import com.gtelant.commerce.service.models.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SegmentRepository extends JpaRepository<Segment, Integer> {

//    boolean existsByName(String type);  //判斷資料庫中是否已存在該 segment
//    Optional<Segment> findByName(String type);  //根據名稱查詢 segment
}
