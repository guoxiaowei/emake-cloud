package com.emake.passport.common.tokenstore;

import com.emake.passport.common.token.PassportToken;

public interface TokenKeyGenerator {

    String extractKey(PassportToken token);
}
