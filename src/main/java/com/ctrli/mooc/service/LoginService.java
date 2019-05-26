package com.ctrli.mooc.service;

import com.ctrli.mooc.dto.Envelope;

public interface LoginService {
    /**
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    public Envelope login(String username,String password,String type);
}
