package com.xh.servlet.servlet;

import com.xh.servlet.thread.TokenThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
* @Name AccessTokenServlet
* @Description 获取微信AccessToken的启动servlet
* @Author wen
* @Date 2019/4/11
* @return
*/
@Slf4j
@WebServlet(name = "accessTokenServlet", urlPatterns = "/accessTokenServlet", loadOnStartup = 0)
public class AccessTokenServlet extends HttpServlet {

    @Value("${token.wechat.appid}")
    private String appId;

    @Value("${token.wechat.appsecret}")
    private String appSecret;

    /** */
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        new Thread(new TokenThread(appId, appSecret)).start(); //启动进程
    }

}

