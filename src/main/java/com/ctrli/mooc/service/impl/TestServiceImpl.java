package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Create by zekdot on 19-5-26.
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public int add(int a, int b) {
        if(a > 0)
            return a + b;
        else
            return -a + b;
    }

}
