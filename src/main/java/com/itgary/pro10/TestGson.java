package com.itgary.pro10;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by garychen on 2016/12/30.
 */
public class TestGson {
    @Test
    public void test3(){
        String json_data="{\"code\":\"00000\",\"msg\":\"操作成功\",\"data\":[{\"id\":3,\"parentId\":0,\"regionName\":\"苏州\"},{\"id\":121,\"parentId\":0,\"regionName\":\"上海\"}]}";
        System.out.println("json:"+json_data);

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        JsonObject jsonObject = parser.parse(json_data).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("data");
        Type type = new TypeToken<Map<String,String>>() {}.getType();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement el = jsonArray.get(i);
            Map<String,String> tmp = gson.fromJson(el, type);
            list.add(tmp);
            System.out.println("##地名: "+tmp.get("regionName"));
        }

        String code =jsonObject.get("code").getAsString();
        System.out.println("code:"+code);
        String regionName_1=list.get(0).get("regionName");
        String id_1=list.get(0).get("id");
        System.out.println("regionName_1:"+regionName_1);
        System.out.println("id_1:"+id_1);

    }
}
