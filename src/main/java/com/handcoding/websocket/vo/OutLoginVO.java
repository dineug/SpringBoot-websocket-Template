package com.handcoding.websocket.vo;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class OutLoginVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String domain;
	private int timeout;
	private TimeUnit timeUnit;
	
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
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}
	@Override
	public String toString() {
		return "OutLoginVO [id=" + id + ", name=" + name + ", domain=" + domain + ", timeout=" + timeout + ", timeUnit="
				+ timeUnit + "]";
	}
}
