package com.itgary.pro3.spring.mybatis.controller;

import com.google.gson.Gson;
import com.itgary.pro3.spring.mybatis.entity.TradeInfo;
import com.itgary.pro3.spring.mybatis.server.ITrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gary on 2016/8/16.
 */
@Controller
@RequestMapping("/echarts")
public class EchartsController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ITrade iTrade;

    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request){
        logger.info("init,{}",iTrade);
        ModelAndView mv = new ModelAndView();
        List<TradeInfo> list = iTrade.selectAll();

        Gson gson = new Gson();
        String gson_str = gson.toJson(list);
        request.setAttribute("gsonstr",gson_str);
        logger.info("list size:{}",list.size());
        mv.setViewName("/first");
        return mv;
    }
}
