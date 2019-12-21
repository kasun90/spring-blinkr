package com.blink.shared.admin.portal;

import com.blink.shared.system.WebRequestMessage;
import com.blink.utilities.BlinkJSON;

public class UserMessagesRequestMessage extends WebRequestMessage {
	private long timestamp;
	private boolean less;
	private int limit;

	public UserMessagesRequestMessage() {}

	public UserMessagesRequestMessage(String requestID, long timestamp, boolean less, int limit) {
		super(requestID);
		this.timestamp = timestamp;
		this.less = less;
		this.limit = limit;
	}

	public String getRequestID() {
		return super.getRequestID();
	}

	public UserMessagesRequestMessage setRequestID(String requestID) {
		super.setRequestID(requestID);
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public UserMessagesRequestMessage setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public boolean isLess() {
		return less;
	}

	public UserMessagesRequestMessage setLess(boolean less) {
		this.less = less;
		return this;
	}

	public int getLimit() {
		return limit;
	}

	public UserMessagesRequestMessage setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}