package com.spt.demo.controller;
import com.spt.demo.utils.RedisConstants;
import com.spt.demo.utils.RedisUtil;
import com.spt.demo.utils.StateParameter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 

@Controller
@RequestMapping(value="/redis")
@Slf4j
public class RedisController {
    @Autowired
    RedisUtil redisUtil;

    /**
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 执行redis写/读/生命周期
     */
    @RequestMapping(value = "getRedis", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap getRedis() {
        redisUtil.set("20182018", "这是一条测试数据", RedisConstants.datebase1);
        Long resExpire = redisUtil.expire("20182018", 60, RedisConstants.datebase1);//设置key过期时间
        log.info("resExpire=" + resExpire);
        String res = redisUtil.get("20182018", RedisConstants.datebase1);
        return getModelMap(StateParameter.SUCCESS, res, "执行成功");
    }

    public ModelMap getModelMap(int status,String data,String msg){
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("status",status);
        modelMap.addAttribute("data",data);
        modelMap.addAttribute("msg",msg);
        return modelMap;
    }

}
 
