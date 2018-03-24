package com.handcoding.websocket.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.handcoding.websocket.bean.RedisSession;
import com.handcoding.websocket.vo.InChatMessageVO;
import com.handcoding.websocket.vo.LoginVO;
import com.handcoding.websocket.vo.OutChatMessageVO;
import com.handcoding.websocket.vo.OutLoginVO;

@Controller
public class ChatController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	// redis 세션
	@Autowired
	private RedisSession redisSession;
	
	protected static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
    @MessageMapping("/chats")
    public void greeting(InChatMessageVO inMs) throws Exception {
    	OutChatMessageVO outMs = new OutChatMessageVO();
    	
    	// 사용자세션 정보 가져오기
    	OutLoginVO info = redisSession.getUserVO(inMs.getToken());
    	logger.info(info.toString());
    	
    	boolean check = false;
    	if(info != null) {
    		outMs.setId(info.getId());
    		outMs.setContent(inMs.getContent());
    		outMs.setDomain(info.getDomain());
    		outMs.setName(info.getName());
    		/**
    		 * 채팅타입, 채팅고유 아이디에 해당하는 유저 체크 로직
    		 * 메세지 저장처리 로직
    		 */
    		
    		check = true;
    	}

    	if(check) {
    		// 메시지 실시간 응답
    		this.simpMessagingTemplate.convertAndSend("/topic/chats."+inMs.getType()+inMs.getChatId(), outMs);
    	}
    }
	
    
    
    
    // 셋팅
    @GetMapping("/")
    public String view(HttpSession session) {
    	// front 서버 세션정보
    	LoginVO login = new LoginVO();
    	login.setId("test_id");
    	login.setDomain("user");
    	login.setName("이승환");
    	
    	// 채팅서버와 공유할 세션 정보
    	OutLoginVO outLoginVO = new OutLoginVO();
    	outLoginVO.setDomain(login.getDomain());
    	outLoginVO.setName(login.getName());
    	outLoginVO.setId(login.getId());
    	outLoginVO.setName(login.getName());
    	
    	login.setToken(redisSession.getToken(outLoginVO));
    	
    	// front 세션 저장
    	session.setAttribute("user", login);
    	
    	return "chat";
    }
    
    
    
}
