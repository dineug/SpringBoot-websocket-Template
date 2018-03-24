package com.handcoding.websocket.vo;

public class InChatMessageVO {
	
	private String token;		// 사용자 정보를 가져올 토큰
	private String content;		// 메세지 내용
	private String type;		// 채팅 타입
	private String chatId;		// 채팅 고유 아이디
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	@Override
	public String toString() {
		return "InChatMessageVO [token=" + token + ", content=" + content + ", type=" + type + ", chatId=" + chatId
				+ "]";
	}
}
