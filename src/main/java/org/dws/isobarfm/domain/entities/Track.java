package org.dws.isobarfm.domain.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Track implements Serializable {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Track track)) return false;
		return Objects.equals(id, track.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
