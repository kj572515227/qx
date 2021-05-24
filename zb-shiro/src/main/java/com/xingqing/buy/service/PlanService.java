package com.xingqing.buy.service;

import com.xingqing.buy.mapper.bi.BiLackProudctMapper;
import com.xingqing.buy.mapper.erp.ErpLackProdutMapper;
import com.xingqing.buy.model.ErpLackProduct;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.model.PlaneCompany;
import com.xingqing.buy.model.SupplyCompany;
import com.xingqing.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PlanService {
    @Autowired
    ErpLackProdutMapper erpLackProdutMapper;

    @Autowired
    BiLackProudctMapper biLackProudctMapper;


    @Autowired
    UserMapper userMapper;

    /**
     * 计划的生成
     * @return
     */
    public List<PlaneCompany> createOrder(List<LackProduct> products) {
        //1、生成表头，总结购进单位这次 汇总,生成单据
        List<PlaneCompany> companys = new ArrayList<>();
        for (LackProduct lp:products) {


        }
        return companys;
    }


    public void syncLackProduct() {
        biLackProudctMapper.truncateTable();
        List<LackProduct> lps = new ArrayList<>();
        //1.根据用户code查询缺货列表
        List<ErpLackProduct> elps = erpLackProdutMapper.getAllLackProduct();
        for (ErpLackProduct erpProduct:elps ) {
            LackProduct p = new LackProduct();
            p.setCode(erpProduct.getSpid());
            p.setName(erpProduct.getSpmch());
            p.setName(erpProduct.getSpmch());
            p.setFactory(erpProduct.getShpchd());
            p.setGyzhunzi(erpProduct.getPizhwh());
            p.setSpec(erpProduct.getShpgg());
            p.setPacknum(erpProduct.getJlgg());
            p.setLastbuycompany(erpProduct.getGjdwmc());
            p.setLastcompanycode(erpProduct.getLast_dwbh());
            p.setLastprice(erpProduct.getZhjj());
            p.setStock(erpProduct.getKcshl());
            p.setYwy(erpProduct.getYwy());//业务员名字，此出可以换成编码
            p.setBzgg(erpProduct.getBzgg());
            p.setCreate_time(new Date());
            p.setDownprice(erpProduct.getZdjj());
            p.setUpprice(erpProduct.getZgjj());
            p.setDw(erpProduct.getDw());
            p.setOnesalenum(erpProduct.getOnesalenum());
            p.setThreesalenum(erpProduct.getThreesalenum());
            p.setDownnum(erpProduct.getKcxx());
            p.setUpnum(erpProduct.getKcsx());

//            User u = userService.selectByUsername(erpProduct.getYwy());
//            if(u != null){
//                p.setYwy(u.getId());
//            }
            lps.add(p);
            biLackProudctMapper.insert(p);
        }
//        biLackProudctMapper.insertList(lps);
    }

}
