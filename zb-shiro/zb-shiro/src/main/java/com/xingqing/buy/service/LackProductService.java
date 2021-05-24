package com.xingqing.buy.service;

import com.xingqing.buy.ErpfieldUtils;
import com.xingqing.buy.mapper.bi.BiLackProudctMapper;
import com.xingqing.buy.mapper.erp.ErpLackProdutMapper;
import com.xingqing.buy.model.ErpLackProduct;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.model.SupplyCompany;
import com.xingqing.mapper.UserMapper;
import com.xingqing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class LackProductService {
    @Autowired
    ErpLackProdutMapper erpLackProdutMapper;

    @Autowired
    BiLackProudctMapper biLackProudctMapper;


    @Autowired
    UserMapper userMapper;

    public List<LackProduct> listLackProductsByuserCode(String code) {
        List<LackProduct> lps =  biLackProudctMapper.getLackProductByUserName(code);
        return lps;
    }
    public void syncLackProduct() {
//        biLackProudctMapper.truncateTable();
        List<LackProduct> lps = new ArrayList<>();
        //批量插入，语句不能太长，2000批插入一次。
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
            p.setInsidecode(erpProduct.getSpbh());

            lps.add(p);
            if(lps.size()==2000){
                biLackProudctMapper.intserList(lps);
                lps.clear();
            }
        }
        if (lps.size()<2000){
            biLackProudctMapper.intserList(lps);
        }

    }

    public List<SupplyCompany> listCompanyBy(String code, Integer time) {
        List<HashMap<String,String>> lps =  erpLackProdutMapper.getBuyCompany(code,time);

        List<SupplyCompany> results = new ArrayList<>();

        for (HashMap<String,String> l:lps) {
            SupplyCompany s= new SupplyCompany();
            s.setProductcode(l.get("spid"));
            s.setBuycode(l.get("dwbh"));
            s.setBuyname(l.get("dwmch"));
            s.setNum(l.get("shl"));
            s.setTime(l.get("rq"));
            s.setTotal(l.get("je"));
            s.setPrice(l.get("dj"));
            results.add(s);
        }
        return results;
    }
}
