package com.handcoding.websocket.vo;

public class OutChatMessageVO {
	
	private String id;
	private String name;
	private String domain;
	private String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "OutChatMessageVO [id=" + id + ", name=" + name + ", domain=" + domain + ", content=" + content + "]";
	}
}
