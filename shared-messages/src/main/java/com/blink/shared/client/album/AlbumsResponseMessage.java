package com.blink.shared.client.album;

import com.blink.shared.common.Album;
import com.blink.utilities.BlinkJSON;

import java.util.List;

public class AlbumsResponseMessage {
	private List<Album> albums;

	public AlbumsResponseMessage() {}

	public AlbumsResponseMessage(List<Album> albums) {
		this.albums = albums;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public AlbumsResponseMessage setAlbums(List<Album> albums) {
		this.albums = albums;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}