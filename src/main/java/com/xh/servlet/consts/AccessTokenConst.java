package com.xh.servlet.consts;

/**
 * @Name AccessTokenConst
 * @Description
 * @Author wen
 * @Date 2019-04-11
 */
public interface AccessTokenConst {

    /** 调用微信的获取accessToken的接口的地址*/
    String WECHAT_GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

}
