package com.xingqing.buy.service;

import com.xingqing.buy.mapper.bi.BiBuyersMapper;
import com.xingqing.buy.mapper.erp.ErpBuysMapper;

import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.ErpBuyCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BuyersService {
    private static final Logger logger = LoggerFactory.getLogger(BuyersService.class);

    @Autowired
    private ErpBuysMapper erpBuysMapper;

    @Autowired
    private BiBuyersMapper biBuyersMapper;


    /**
     * 每天晚上上2点更新一次公司表格
     */
    @Scheduled(cron = "0 0 2 * * ? ")
    public void sysBuys() {
        List<ErpBuyCompany> erpBuys = erpBuysMapper.selectAll();
        biBuyersMapper.truncateTable();
        List<BuyCompany> buyCompanies = new ArrayList<>();
        for (ErpBuyCompany erpBuyCompany : erpBuys) {
            try {
                BuyCompany u = new BuyCompany();
                u.setCode(erpBuyCompany.getDwbh());
                u.setAddress(erpBuyCompany.getDzhdh());
                u.setContact(erpBuyCompany.getWtr());
                if (erpBuyCompany.getDanwbh() != null) {
                    u.setName(erpBuyCompany.getDwmch().trim());
                }
                u.setScope(erpBuyCompany.getJingyfw());
                u.setTel(erpBuyCompany.getTelno());
                if (erpBuyCompany.getYwy() != null) {
                    u.setYwy(erpBuyCompany.getYwy().trim());
                }
                u.setZjm(erpBuyCompany.getZjm());
                u.setCreate_time(new Date());
                u.setIncode(erpBuyCompany.getDanwbh());
                buyCompanies.add(u);
                if (buyCompanies.size() == 2000) {
                    biBuyersMapper.insertBuyCompanys(buyCompanies);
                    buyCompanies.clear();
                }
            } catch (Exception e) {
                logger.error("buy insert error!!!!", e);
            }
        }

        if (buyCompanies.size() < 2000 && buyCompanies.size() > 0) {
            biBuyersMapper.insertBuyCompanys(buyCompanies);
            buyCompanies.clear();
        }
        logger.info("bi buyer sys success end !");
    }
}
