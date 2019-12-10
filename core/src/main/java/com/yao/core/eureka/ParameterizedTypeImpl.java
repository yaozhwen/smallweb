package com.yao.core.eureka;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class ParameterizedTypeImpl implements ParameterizedType {

    private Class clazz;

    ParameterizedTypeImpl(Class clz){
        clazz = clz;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{clazz};
    }

    @Override
    public Type getRawType() {
        return List.class;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
