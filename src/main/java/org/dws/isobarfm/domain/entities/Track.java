package org.dws.isobarfm.domain.entities;

import java.util.UUID;

public class Track {
	private UUID id;
	private String name;
	private String duration;

	public Track(UUID id, String name, String duration) {
		this.id = id;
		this.name = name;
		this.duration = duration;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDuration() {
		return duration;
	}
}
