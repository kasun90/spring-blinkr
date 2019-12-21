package com.blink.shared.client.album;

import com.blink.shared.common.Album;
import com.blink.utilities.BlinkJSON;

public class AlbumDetailsResponseMessage {
	private Album album;

	public AlbumDetailsResponseMessage() {}

	public AlbumDetailsResponseMessage(Album album) {
		this.album = album;
	}

	public Album getAlbum() {
		return album;
	}

	public AlbumDetailsResponseMessage setAlbum(Album album) {
		this.album = album;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}