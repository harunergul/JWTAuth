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
	public Date activateDate;
	public Date meetingStartDate;
	public Date meetingEndDate;

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

	public Date getActivateDate() {
		return activateDate;
	}

	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}

	public Date getMeetingStartDate() {
		return meetingStartDate;
	}

	public void setMeetingStartDate(Date meetingStartDate) {
		this.meetingStartDate = meetingStartDate;
	}

	public Date getMeetingEndDate() {
		return meetingEndDate;
	}

	public void setMeetingEndDate(Date meetingEndDate) {
		this.meetingEndDate = meetingEndDate;
	}

}
