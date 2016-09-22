package com.itgary.pro8.netty.protobuf.bean;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by garychen on 2016/9/20.
 */
public class UserInfoReqTest {

    //1.UserInfoReqProto生成的.java文件
    //2.UserInfoReq对戏

    private static byte[] encode(UserInfoReqProto.UserInfoReq req){
        return req.toByteArray();
    }

    private static UserInfoReqProto.UserInfoReq decode(byte[] body) throws InvalidProtocolBufferException {
        return UserInfoReqProto.UserInfoReq.parseFrom(body);
    }


    private static UserInfoReqProto.UserInfoReq createUserInfoReq(){
        UserInfoReqProto.UserInfoReq.Builder builder = UserInfoReqProto.UserInfoReq.newBuilder();
        builder.setUid(1);
        builder.setName("gary.chen");
        builder.setAge(27);

        List<String> address = new ArrayList<String>();
        address.add("SHA 陆家嘴");
        address.add("SHA 东昌路");
        address.add("SHA 宝杨路");

        //builder.addRepeatedField("all",address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        UserInfoReqProto.UserInfoReq req = createUserInfoReq();
        System.out.println("Before encode:" + req.toString());
        UserInfoReqProto.UserInfoReq req2 = decode(encode(req));
        System.out.println("After decode: " + req.toString());
        System.out.println("Assert equal: " + req2.equals(req));

    }

}