package com.cyberha4;

import java.util.Objects;

/**
 * Created by admin on 07.03.2017.
 */
public enum Singleton {
    INSTANCE;
    private Object obj = null;
    public Object createInstance(){
        if (obj == null){
            obj = new Object();
        }
        return obj;
    }
}
