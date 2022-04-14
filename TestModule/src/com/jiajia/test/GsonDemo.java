package com.jiajia.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiajia.support.http.HttpUtil;
import com.jiajia.support.log.LogUtils;

public class GsonDemo {

    public static void main(String[] args)  {

        String queryStr = HttpUtil.get("https://www.wanandroid.com/article/list/0/json");

        BaseMode<DiscoverMode> mode = new Gson().fromJson(queryStr, new TypeToken<BaseMode<DiscoverMode>>(){}.getType());

        LogUtils.e(mode.toString());
    }
}
