package com.blink.shared.admin.setting;

import com.blink.utilities.BlinkJSON;

import java.util.List;

public class SettingResponseMessage {
	private List<SettingExp> settings;

	public SettingResponseMessage() {}

	public SettingResponseMessage(List<SettingExp> settings) {
		this.settings = settings;
	}

	public List<SettingExp> getSettings() {
		return settings;
	}

	public SettingResponseMessage setSettings(List<SettingExp> settings) {
		this.settings = settings;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}