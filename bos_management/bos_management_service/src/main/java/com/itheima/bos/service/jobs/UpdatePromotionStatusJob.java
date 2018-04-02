package com.itheima.bos.service.jobs;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itheima.bos.dao.take_delivery.PromotionRepository;
import com.itheima.bos.domain.take_delivery.Promotion;

@Component
public class UpdatePromotionStatusJob {
	@Autowired
	private PromotionRepository promotionRepository;
    
    public void updateStatus(){
        Date date = new Date();
        List<Promotion> list = promotionRepository.findAllOutOfDate(date);
        for (Promotion promotion : list) {
                Long id = promotion.getId();
                Promotion p1 = promotionRepository.findOne(id);
                p1.setStatus("2");
                promotionRepository.save(p1);
        }
    }

}
