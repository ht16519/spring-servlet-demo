package com.xh.servlet.thread;


import com.xh.servlet.consts.AccessTokenConst;
import com.xh.servlet.domain.AccessToken;
import com.xh.servlet.utils.JsonUtil;
import com.xh.servlet.utils.NetWorkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
* @Name TokenThread
* @Description 执行获取AccessToken的线程
* @Author wen
* @Date 2019/4/11
* @return
*/
@Slf4j
public class TokenThread implements Runnable {

    private String appId;

    private String appSecret;

    public void run() {
        while (true) {
            try {
                AccessToken accessToken = this.getAccessToken();
                if (null != accessToken) {
                    log.info("取得微信AccessToken值:{}", accessToken.getAccessToken());
                    Thread.sleep(7000 * 1000); //获取到access_token 休眠7000秒
                } else {
                    Thread.sleep(1000 * 3); //获取的access_token为空 休眠3秒
                }
            } catch (Exception e) {
                log.error("获取微信AccessToken发生异常:{}" , e);
                try {
                    Thread.sleep(1000 * 10); //发生异常休眠10秒
                } catch (Exception e1) {
                    log.error("获取微信失败，执行休眠操作时异常:{}", e1);
                }
            }
        }
    }

    /**
    * @Name getAccessToken
    * @Description 获取access_token
    * @Author wen
    * @Date 2019/4/11
    * @param
    * @return com.xh.servlet.domain.AccessToken
    */
    private AccessToken getAccessToken() throws Exception{
        NetWorkUtil netWorkUtil = new NetWorkUtil();
        String httpsUrl = String.format(AccessTokenConst.WECHAT_GET_ACCESS_TOKEN_URL, this.appId, this.appSecret);
        String result = netWorkUtil.getHttpsResponse(httpsUrl, "");
        log.info("取得返回结果：", result);
        System.err.println(result);
        return JsonUtil.parse(result, AccessToken.class);
    }

    public TokenThread(){

    }

    public TokenThread(String appId, String appSecret){
        this.appId = appId;
        this.appSecret = appSecret;
    }

}