package com.blink.shared.client.preset;

import com.blink.shared.common.Preset;
import com.blink.utilities.BlinkJSON;

import java.util.List;

public class PresetsResponseMessage {
	private List<Preset> presets;

	public PresetsResponseMessage() {}

	public PresetsResponseMessage(List<Preset> presets) {
		this.presets = presets;
	}

	public List<Preset> getPresets() {
		return presets;
	}

	public PresetsResponseMessage setPresets(List<Preset> presets) {
		this.presets = presets;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}