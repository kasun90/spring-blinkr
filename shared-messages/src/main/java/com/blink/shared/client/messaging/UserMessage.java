package com.blink.shared.client.messaging;

import com.blink.utilities.BlinkJSON;

public class UserMessage {
	private String name;
	private String message;
	private String email;
	private String phone;
	private long timestamp;
	private String recaptchaToken;

	public UserMessage() {}

	public UserMessage(String name, String message, String email, String phone, long timestamp, String recaptchaToken) {
		this.name = name;
		this.message = message;
		this.email = email;
		this.phone = phone;
		this.timestamp = timestamp;
		this.recaptchaToken = recaptchaToken;
	}

	public String getName() {
		return name;
	}

	public UserMessage setName(String name) {
		this.name = name;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public UserMessage setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserMessage setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public UserMessage setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public UserMessage setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public String getRecaptchaToken() {
		return recaptchaToken;
	}

	public UserMessage setRecaptchaToken(String recaptchaToken) {
		this.recaptchaToken = recaptchaToken;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}