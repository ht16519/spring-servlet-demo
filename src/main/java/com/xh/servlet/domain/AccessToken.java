package com.xh.servlet.domain;

/**
* @Name AccessToken
* @Description 微信accessToken实体
* @Author wen
* @Date 2019/4/11
* @return
*/
public class AccessToken {

	private String access_token;

	private int expires_in;

	/** 获取accessToken*/
	public String getAccessToken() {
		return access_token;
	}

	/** 获取expiresin*/
	public int getExpiresin() {
		return expires_in;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
}
