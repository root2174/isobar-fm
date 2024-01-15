package org.dws.isobarfm.domain.entities;

import java.util.List;
import java.util.UUID;

public class Album {
	private UUID id;
	private String image;
	private String band;
	private List<Track> tracks;

	public Album(UUID id, String image, String band, List<Track> tracks) {
		this.id = id;
		this.image = image;
		this.band = band;
		this.tracks = tracks;
	}

	public UUID getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public String getBand() {
		return band;
	}

	public List<Track> getTracks() {
		return tracks;
	}
}
