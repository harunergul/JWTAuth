package com.hergul.jwt;

import java.io.Serializable;
import java.util.Date;

public class TokenClaimer implements Serializable {

	private static final long serialVersionUID = 1114718998206676139L;
	public String sessionId;
	public String roomName;
	public String attenderType;
	public String moderatorNo;
	public String moderatorName;
	public String attenderNo;
	public String attenderName;
	public Date meetingStartTime;
	public Date meetingEndTime;
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getAttenderType() {
		return attenderType;
	}

	public void setAttenderType(String attenderType) {
		this.attenderType = attenderType;
	}

	public String getModeratorNo() {
		return moderatorNo;
	}

	public void setModeratorNo(String moderatorNo) {
		this.moderatorNo = moderatorNo;
	}

	public String getModeratorName() {
		return moderatorName;
	}

	public void setModeratorName(String moderatorName) {
		this.moderatorName = moderatorName;
	}

	public String getAttenderNo() {
		return attenderNo;
	}

	public void setAttenderNo(String attenderNo) {
		this.attenderNo = attenderNo;
	}

	public String getAttenderName() {
		return attenderName;
	}

	public void setAttenderName(String attenderName) {
		this.attenderName = attenderName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingStartTime(Date meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public Date getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setMeetingEndTime(Date meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}
	
	
	

}
