package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.mapper.bi.AskLogMapper;
import com.xingqing.buy.mapper.bi.AskMapper;
import com.xingqing.buy.mapper.bi.BiBuyersMapper;
import com.xingqing.buy.mapper.erp.ErpBuysMapper;
import com.xingqing.buy.model.Ask;
import com.xingqing.buy.model.AskLog;
import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.ErpBuyCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AskService {
    private static final Logger logger = LoggerFactory.getLogger(AskService.class);

    @Resource
    private AskMapper askMapper;

    @Resource
    private AskLogMapper askLogMapper;

    public Integer addAsk(Ask ask) {
        return askMapper.insert(ask);
    }

    /**
     * 更新ask的状态，记录操作日日志
     * @param ask
     * @return
     */
    public void setAsk(Ask ask) {
       askMapper.updateByPrimaryKeySelective(ask);
    }

    private void addAskLog(Ask ask){
        AskLog al = new AskLog();
        al.setAskid(ask.getId());
        al.setOperator(ask.getOwn());
        al.setResult(ask.getState());//1，表示成功 0表示失败
        al.setRemarks(ask.getRemarks());
        askLogMapper.insert(al);
    }
    public List<Ask> selectAsk(Ask ask) {
        return  askMapper.select(ask);
    }

    // 更新有问题，存在数据改变，不能更新的bug
//    public void sysBuys() {
//        List<Ask> asks = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            try {
//                Ask u = new Ask();
//                u.setPcode(String.valueOf(i));
//                asks.add(u);
//            } catch (Exception e) {
//                logger.error("buy insert error!!!!", e);
//            }
//
//        }
//    }

}
