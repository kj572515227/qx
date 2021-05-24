package com.xingqing.buy.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.model.SupplyCompany;
import com.xingqing.buy.service.LackProductService;
import com.xingqing.controller.RoleController;
import com.xingqing.model.Role;
import com.xingqing.model.User;
import com.xingqing.util.PageUtil;
import com.xingqing.util.ResultUtil;
import com.xingqing.vo.base.PageResultVo;
import com.xingqing.vo.base.ResponseVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/lackProduct")
public class LackProductController {
    private static final Logger logger = LoggerFactory.getLogger(LackProductController.class);
    @Autowired
    LackProductService lackProductService;

    /*缺货列表数据*/
//    @PostMapping("/list")
    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public PageResultVo pageLcakProducts(String order, Integer limit, Integer offset) {
        try {
            String userId= ((User) SecurityUtils.getSubject().getPrincipal()).getUserId();
            logger.info("use id: " +userId +" limit :" +limit +" offset : "+offset);
            if (limit == null){
                limit=10;
            }
            if (offset==null){
                offset=1;
            }
            PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
            PageHelper.orderBy(order);
            List<LackProduct> lps = lackProductService.listLackProductsByuserCode(userId);
            PageInfo<LackProduct> pages = new PageInfo<>(lps);
            logger.info("pagelack products size:" +lps.size());
            return ResultUtil.table(lps,pages.getTotal());
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }

    }

//    @PostMapping("/lastthreebuys")
    @RequestMapping(value = "/lastthreebuys", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseVo lastthreebuys(String code, Integer time) {
        try {
            logger.info("lastthreebuys lack product productCode id: " +code +" time :" +time);
            List<SupplyCompany> ls= lackProductService.listCompanyBy(code,time);
            return ResultUtil.success("ok",ls);
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

    @RequestMapping(value = "/find", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public PageResultVo searchPageLcakProducts(LackProduct product, Integer limit, Integer offset) {
        try {
            String userName= ((User) SecurityUtils.getSubject().getPrincipal()).getUsername();
            logger.info("find lack product use id: " +userName +" limit :" +limit +" offset : "+offset
                    + JSON.toJSONString(product));

            PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
            product.setYwy(userName);
            List<LackProduct> lps = lackProductService.searchProductExample(product);
            PageInfo<LackProduct> pages = new PageInfo<>(lps);
            logger.info("pagelack products size:" +lps.size());
            return ResultUtil.table(lps,pages.getTotal());
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }

    }

}
