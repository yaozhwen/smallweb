package com.yao.core.persistence;

import com.google.gson.Gson;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class GsonBean {
    public String toGsonString(){
        return new Gson().toJson(this);
    }
}
