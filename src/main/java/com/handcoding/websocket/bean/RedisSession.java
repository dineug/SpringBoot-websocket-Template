package com.handcoding.websocket.bean;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.handcoding.websocket.util.TempKey;
import com.handcoding.websocket.vo.OutLoginVO;

@Component
public class RedisSession {
	
	@Resource(name="redisTemplate")
	private ValueOperations<String, String> tokens;
	private Gson gson = new Gson();
	
	public String getToken(OutLoginVO outLoginVO) {
		TempKey tempKey = new TempKey();
		String newToken = tempKey.getKey(300);
		String oldToken = getCheckId(outLoginVO);
		String token = null;
		if(oldToken == null) {
			token = newToken;
		}else {
			token = oldToken;
		}
		setToken(token, outLoginVO);
		return token;
	}
	
	private String getCheckId(OutLoginVO outLoginVO) {
		String oldToken = (String) tokens.get(outLoginVO.getId()+outLoginVO.getDomain());
		return oldToken;
	}
	
	private void setToken(String token, OutLoginVO outLoginVO) {
		if(outLoginVO.getTimeout()==0 || outLoginVO.getTimeUnit()==null) {
			tokens.set(token, gson.toJson(outLoginVO), 30, TimeUnit.MINUTES);
			tokens.set(outLoginVO.getId()+outLoginVO.getDomain(), token, 30, TimeUnit.MINUTES);
		}else {
			tokens.set(token, gson.toJson(outLoginVO), outLoginVO.getTimeout(), outLoginVO.getTimeUnit());
			tokens.set(outLoginVO.getId()+outLoginVO.getDomain(), token, outLoginVO.getTimeout(), outLoginVO.getTimeUnit());
		}
	}
	
	public OutLoginVO getUserVO(String token) {
		OutLoginVO outLoginVO = gson.fromJson(tokens.get(token), OutLoginVO.class);
		if(outLoginVO != null) {
			setToken(token, outLoginVO);
		}
		return outLoginVO;
	}
	
}
