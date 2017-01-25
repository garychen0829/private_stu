package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.TradeInfo;

import java.util.List;

/**
 * Created by gary.chen on 2016/8/15.
 */
public interface ITrade {
    List<TradeInfo> selectAll();
}
