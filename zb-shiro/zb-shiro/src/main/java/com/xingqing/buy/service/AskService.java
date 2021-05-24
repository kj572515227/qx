package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.mapper.bi.AskMapper;
import com.xingqing.buy.mapper.bi.BiBuyersMapper;
import com.xingqing.buy.mapper.erp.ErpBuysMapper;
import com.xingqing.buy.model.Ask;
import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.ErpBuyCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AskService {
    private static final Logger logger = LoggerFactory.getLogger(AskService.class);

    @Autowired
    private AskMapper askMapper;


    // 更新有问题，存在数据改变，不能更新的bug
    public void sysBuys() {

        List<Ask> asks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                Ask u = new Ask();
                u.setPcode(String.valueOf(i));
                asks.add(u);
            } catch (Exception e) {
                logger.error("buy insert error!!!!", e);
            }

        }
        askMapper.insertList(asks);
    }
}
