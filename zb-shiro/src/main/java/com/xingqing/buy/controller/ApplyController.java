package com.xingqing.buy.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xingqing.buy.model.Ask;
import com.xingqing.buy.model.LackProduct;
import com.xingqing.buy.service.AskService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/applyFor")
public class ApplyController {
    private static final Logger logger = LoggerFactory.getLogger(ApplyController.class);

    @Autowired
    AskService askService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVo addAsk(Ask ask) {
        try {
            String userId= ((User) SecurityUtils.getSubject().getPrincipal()).getUserId();
            ask.setApplicant(userId);
            ask.setOwn(userId);
            ask.setState(0);
            askService.addAsk(ask);
            return ResultUtil.success();
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

    /**
     * 参数 ask需要把id插入下去
     * @param ask
     * @return
     */
    @RequestMapping(value = "/changeAskStatus", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVo changeAskStatus(Ask ask) {
        try {
            String userId= ((User) SecurityUtils.getSubject().getPrincipal()).getUserId();
            ask.setApplicant(userId);
            ask.setOwn(userId);
            ask.setState(0);
            askService.setAsk(ask);
            return ResultUtil.success();
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

    /**
     * 参数 ask需要把id插入下去
     * @param ask
     * @return
     */
    @RequestMapping(value = "/selectAsk", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseVo selectAsks(Ask ask) {
        try {
            String userId= ((User) SecurityUtils.getSubject().getPrincipal()).getUserId();
            Ask a= ask;
            if (ask == null){
                a= new Ask();
            }
            a.setApplicant(userId);
            askService.setAsk(a);
            return ResultUtil.success();
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

}
