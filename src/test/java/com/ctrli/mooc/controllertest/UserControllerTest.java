package com.ctrli.mooc.controllertest;

import com.ctrli.mooc.MoocApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Create by zekdot on 19-5-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MoocApplication.class)
@WebAppConfiguration
public class UserControllerTest{
    // 登录URL
    public static final String LOGIN_URL = "/user/login";
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        //测试用例数据准备
        //code here
        this.mvc =   MockMvcBuilders.webAppContextSetup(this.context).build();

    }
    @Test
    public void generateOrderIdTest() throws   Exception {

        //JSONObject jsonObject = JSONObject.parseObject(getResource(JSON_AUTH_TOKEN_REQ));

        MockHttpServletRequestBuilder builder   =    post(LOGIN_URL).param("username","s7")
                .param("password","s7").param("type","student");
        //.header("X-Auth-Token",   jsonObject.getString("token"));

        MvcResult result =   mvc.perform(builder).andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        System.out.println(result.getResponse().getContentAsString());
        //assertEquals();
    }

}
