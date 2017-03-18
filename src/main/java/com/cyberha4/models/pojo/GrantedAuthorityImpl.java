package com.cyberha4.models.pojo;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by admin on 13.03.2017.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String Autority;

    public GrantedAuthorityImpl(String autority) {
        Autority = autority;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
