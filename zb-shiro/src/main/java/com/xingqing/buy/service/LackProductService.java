package com.xingqing.buy.service;

import com.xingqing.buy.controller.LackProductController;
import com.xingqing.buy.mapper.bi.BiLackProudctMapper;
import com.xingqing.buy.mapper.erp.ErpLackProdutMapper;
import com.xingqing.buy.model.ErpLackProduct;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.model.SupplyCompany;
import com.xingqing.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class LackProductService {
    private static final Logger logger = LoggerFactory.getLogger(LackProductService.class);

    @Autowired
    private ErpLackProdutMapper erpLackProdutMapper;

    @Autowired
    private BiLackProudctMapper biLackProudctMapper;

    public List<LackProduct> listLackProductsByuserCode(String code) {
        List<LackProduct> lps =  biLackProudctMapper.getLackProductByUserName(code);
        return lps;
    }


    public List<LackProduct> searchProductExample(LackProduct product) {
        if (product.getYwy() == null){
            logger.warn("searchProductExzample ywy is null ,can't find" );
            return null;
        }
        List<LackProduct> lps =  null;
        Example example = new Example(LackProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orLike("ywy",product.getYwy());
        if(product.getName() != null){
            criteria.orLike("name",product.getName());
        }
        if (product.getFactory() != null){
            criteria.orLike("factory",product.getFactory());
        }
        if (product.getInsidecode() != null){
            criteria.orLike("insidecode",product.getInsidecode());
        }

        if (product.getLastbuycompany() != null){
            criteria.orLike("lastbuycompany",product.getLastbuycompany());
        }

        biLackProudctMapper.selectByExample(example);
        return lps;
    }

    @Scheduled(cron = "0 30 3 * * ? ")
    public void syncLackProduct() {
        List<LackProduct> lps = new ArrayList<>();
        //批量插入，语句不能太长，2000批插入一次。
        List<ErpLackProduct> elps = erpLackProdutMapper.getAllLackProduct();
        biLackProudctMapper.truncateTable();
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
            if (erpProduct.getYwy() != null){
                p.setYwy(erpProduct.getYwy());//业务员名字，此出可以换成编码
            }
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
        if (lps.size()>0 && lps.size()<2000){
            biLackProudctMapper.intserList(lps);
        }
        logger.info("sys lack product success!");
    }

    public List<SupplyCompany> listCompanyBy(String code, Integer time) {
        List<HashMap<String,Object>> lps =  erpLackProdutMapper.getBuyCompany(code,time);

        List<SupplyCompany> results = new ArrayList<>();

        for (HashMap<String,Object> l:lps) {
            SupplyCompany s= new SupplyCompany();
            s.setProductcode(l.get("spid").toString());
            s.setBuycode(l.get("dwbh").toString());
            s.setBuyname(l.get("dwmch").toString());
            s.setNum(((BigDecimal)l.get("shl")).intValue());
            s.setTime(l.get("rq").toString());
            s.setTotal(((BigDecimal)l.get("je")).setScale(2).toString());
            s.setPrice(((BigDecimal)l.get("dj")).setScale(2).toString());
            results.add(s);
        }
        return results;
    }
}
