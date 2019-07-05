package com.emake.passport.common.cookie;

import com.emake.passport.common.auth.PassportAuthentication;
import org.springframework.security.core.AuthenticationException;

public interface PassportCookieServices {

    PassportAuthentication loadAuthentication(String cookieValue) throws AuthenticationException;

    boolean removeAuthentication (String cookieValue) throws AuthenticationException;
}
