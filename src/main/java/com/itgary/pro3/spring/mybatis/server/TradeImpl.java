package com.itgary.pro3.spring.mybatis.server;

import com.itgary.pro3.spring.mybatis.entity.TradeInfo;
import com.itgary.pro3.spring.mybatis.mapping.TradeInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gary.chen on 2016/8/15.
 */
@Service
public class TradeImpl implements ITrade{

    @Resource
    private TradeInfoMapper mapper;

    @Override
    public List<TradeInfo> selectAll() {
        return mapper.selectAll();
    }
}
