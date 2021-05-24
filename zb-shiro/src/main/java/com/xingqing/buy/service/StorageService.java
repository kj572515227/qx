package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.ErpfieldUtils;
import com.xingqing.buy.mapper.bi.BiProductMapper;
import com.xingqing.buy.mapper.bi.BiStorageMapper;
import com.xingqing.buy.mapper.erp.ErpProductMapper;
import com.xingqing.buy.mapper.erp.ErpStorageMapper;
import com.xingqing.buy.model.ErpProduct;
import com.xingqing.buy.model.ErpStorage;
import com.xingqing.buy.model.Product;
import com.xingqing.buy.model.StorageInfo;
import com.xingqing.model.User;
import com.xingqing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StorageService {
    private static final Logger logger = LoggerFactory.getLogger(StorageService.class);

    @Autowired
    private ErpStorageMapper storageMapper;

    @Autowired
    private BiStorageMapper biSm;

    //数据变化的同步需要解决bug，可考虑每个数据的比较。
    public void synProducts() {
        List<ErpStorage> erpProductList = storageMapper.selectAll();
        //先清空表
        biSm.truncateTable();
        List<StorageInfo> storageInfos = new ArrayList<>(erpProductList.size());
        for (ErpStorage erpProduct : erpProductList) {
            StorageInfo p = new StorageInfo();
            p.setCode(erpProduct.getSpid());
            //TODO:
//            p.getAvgnum() 3个月的平均销量后面再算
//            p.setDownnum();
//            p.setUpnum();
            p.setLastprice(erpProduct.getZhjj());
            p.setPrice(erpProduct.getChbdj());
            p.setUpprice(erpProduct.getZgjj());
            p.setDownprice(erpProduct.getZdjj());
            p.setStoragenum(erpProduct.getKcshl());
            p.setCreate_time(new Date());
            storageInfos.add(p);
        }
        biSm.insertList(storageInfos);
    }

}

