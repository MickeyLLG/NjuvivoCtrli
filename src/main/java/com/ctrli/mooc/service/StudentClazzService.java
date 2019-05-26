package com.ctrli.mooc.service;

import com.ctrli.mooc.dto.Envelope;

public interface StudentClazzService {
    /**
     *
     * @param sid
     * @param cid
     * @return
     */
    public Envelope studentGetIntoClazz(String sid,String cid);

    /**
     *
     * @param sid
     * @param cid
     * @return
     */
    public Envelope clazzOff(String sid,String cid);
}
