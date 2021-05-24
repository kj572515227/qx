package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.mapper.bi.BiBuyersMapper;
import com.xingqing.buy.mapper.erp.ErpBuysMapper;
import com.xingqing.buy.mapper.erp.ErpUserMapper;
import com.xingqing.buy.model.BuyCompany;
import com.xingqing.buy.model.ErpBuyCompany;
import com.xingqing.buy.model.ErpUser;
import com.xingqing.mapper.UserMapper;
import com.xingqing.model.User;
import com.xingqing.service.UserService;
import com.xingqing.util.CoreConst;
import com.xingqing.util.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BuyersService {
    private static final Logger logger  = LoggerFactory.getLogger(BuyersService.class);

    @Autowired
    private ErpBuysMapper erpBuysMapper;

    @Autowired
    private BiBuyersMapper biBuyersMapper;


    // 更新有问题，存在数据改变，不能更新的bug
   public void sysBuys(){
        List<ErpBuyCompany> erpBuys= erpBuysMapper.selectAll();
        for (int i =  erpBuys.size()-1; i >= 0; i--) {
            ErpBuyCompany erpBuyCompany = erpBuys.get(i);
            BuyCompany company= biBuyersMapper.selectByCode(erpBuyCompany.getDwbh());
            //在bi系统中找不到最大code的用户，把用户加到bi用户中。
            if (company == null){
                try{
                    BuyCompany u = new BuyCompany();
                    u.setCode(erpBuyCompany.getDwbh());
                    u.setAddress(erpBuyCompany.getDzhdh());
                    u.setContact(erpBuyCompany.getWtr());
                    u.setName(erpBuyCompany.getDwmch());
                    u.setScope(erpBuyCompany.getJingyfw());
                    u.setTel(erpBuyCompany.getTelno());
                    u.setYwy(erpBuyCompany.getYwy());
                    u.setZjm(erpBuyCompany.getZjm());
                    u.setCreate_time(new Date());
                    biBuyersMapper.insert(u);
                }catch (Exception e ){
                    logger.error("buy insert error!!!!",e);
                }

            }else {
                logger.warn("bi buy update  end:" + JSON.toJSONString(erpBuyCompany));
                break;
            }
        }
    }
}
