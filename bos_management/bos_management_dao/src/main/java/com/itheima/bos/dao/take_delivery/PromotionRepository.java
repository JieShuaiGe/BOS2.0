package com.itheima.bos.dao.take_delivery;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itheima.bos.domain.take_delivery.Promotion;

/**
 * ClassName:PromotionRepository <br/>
 * Function: <br/>
 * Date: 2018年3月31日 上午9:15:49 <br/>
 */
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    
    @Query("from Promotion p where p.endDate<? and p.status=1")
    List<Promotion> findAllOutOfDate(Date date);

}
