package com.itgary.pro3.spring.mybatis.mapping;

import com.itgary.pro3.spring.mybatis.entity.TradeInfo;

import java.util.List;

public interface TradeInfoMapper {
    int deleteByPrimaryKey(String pid);

    int insert(TradeInfo record);

    int insertSelective(TradeInfo record);

    TradeInfo selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(TradeInfo record);

    int updateByPrimaryKey(TradeInfo record);

    List<TradeInfo> selectAll();
}