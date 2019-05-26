package com.ctrli.mooc.controller;

import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/** 用户相关的控制层
 * Create by zekdot on 19-5-26.
 */
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录的controller
     * @param username 用户名
     * @param password 密码
     * @param type 类型
     * @param session 保存用户信息
     * @return 包含sessionId
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, String type, HttpSession session){
        try{
            // 登录并获取结果
            Envelope envelope = loginService.login(username,password,type);
            // 如果登录正常
            if(envelope.getCode() == 0){
                // 设置session
                session.setAttribute("user",envelope.getObj());
                // 返回sessionId
                envelope.setObj(session.getId());
            }
            // 返回结果信封
            return envelope.toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }
}
