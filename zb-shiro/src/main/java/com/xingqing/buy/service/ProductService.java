package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.ErpfieldUtils;
import com.xingqing.buy.mapper.bi.BiProductMapper;
import com.xingqing.buy.mapper.erp.ErpProductMapper;
import com.xingqing.buy.model.ErpProduct;
import com.xingqing.buy.model.Product;
import com.xingqing.model.User;
import com.xingqing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger  = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ErpProductMapper erpProductMapper;

    @Autowired
    private BiProductMapper biProductMapper;

    @Autowired
    private UserService userService;

    //数据变化的同步需要解决bug，可考虑每个数据的比较。
    public void synProducts(){
        List<ErpProduct> erpProductList= erpProductMapper.selectAll();

        for (int i =  erpProductList.size()-1; i >= 0; i--) {
            ErpProduct erpProduct = erpProductList.get(i);
            Product pd= biProductMapper.selectByCode(erpProduct.getSpid());
            //在bi系统中找不到最大code编码，在bi系统中添加
            if (pd == null){
                Product p = new Product();
                p.setCode(erpProduct.getSpid());
                p.setName(erpProduct.getSpmch());
                p.setFactory(erpProduct.getShpchd());
                p.setGyzhunzi(erpProduct.getPizhwh());
                p.setSpec(erpProduct.getShpgg());
                p.setPacknum(erpProduct.getJlgg());
                p.setPlace(erpProduct.getShengccj());
                p.setType(ErpfieldUtils.sptype2Producttype(erpProduct.getLeibie()));
                User u = userService.selectByUsername(erpProduct.getYwy());
                if(u != null){
                    p.setYwy(u.getId());
                }

                p.setPackunit(ErpfieldUtils.sptBzdw2ProductUnit(erpProduct.getDw()));
                p.setLastbuyercode(erpProduct.getLast_dwbh());
                biProductMapper.insert(p);
            }else {
                logger.warn("bi product update  end:" + JSON.toJSONString(erpProduct));
//                break;
            }
        }
        logger.warn("no erp product update!!!");
    }

}
