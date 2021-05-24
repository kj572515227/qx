package com.xingqing.buy.service;

import com.alibaba.fastjson.JSON;
import com.xingqing.buy.mapper.erp.ErpUserMapper;
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
public class ErpUserService {
    private static final Logger logger  = LoggerFactory.getLogger(ErpUserService.class);

    @Autowired
    private ErpUserMapper erpUserMapper ;

    @Autowired
    private UserMapper biUserMapper;

    @Autowired
    private UserService userService;

    // 可能存在离职员工没有更新的情况
   public boolean updateUsers(){
        //1.读取erp用户信息，检查是否要插入用户根据数量进行判断
        //批量插入到bi的users。
        List<ErpUser> erpusers= erpUserMapper.selectAll();
        for (int i =  erpusers.size()-1; i >= 0; i--) {
            ErpUser erpUser = erpusers.get(i);
            User user= biUserMapper.selectByUserId(erpUser.getDzycode());
            //在bi系统中找不到最大code的用户，把用户加到bi用户中。
            if (user == null){
                User u = new User();
                u.setUserId(erpUser.getDzycode());
                u.setUsername(erpUser.getDzyname());
                u.setPassword("123456");
                u.setStatus(CoreConst.STATUS_VALID);
                Date date = new Date();
                u.setCreateTime(date);
                u.setUpdateTime(date);
                u.setLastLoginTime(date);
                PasswordHelper.encryptPassword(u);
                int num = userService.register(u);
            }else {
                logger.warn("bi user update  end:" + JSON.toJSONString(erpUser));
                break;
            }
        }
        logger.warn("no erp user data update!!!");
        return true;
    }
}
