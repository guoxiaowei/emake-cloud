package com.emake.passport.common.token;

import java.io.Serializable;

public interface PassportToken<T> extends Serializable {

    public String getKey();
    public T getValue();
    public String getIp();

}
