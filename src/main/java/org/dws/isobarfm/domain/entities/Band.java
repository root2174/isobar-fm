package org.dws.isobarfm.domain.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Band implements Serializable {
	private UUID id;
	private String name;
	private String image;
	private String genre;
	private String biography;
	private Long numPlays;

	private List<Album> albums;

	public Band(UUID id, String name, String image, String genre, String biography, Long numPlays, List<Album> albums) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.genre = genre;
		this.biography = biography;
		this.numPlays = numPlays;
		this.albums = albums;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public String getGenre() {
		return genre;
	}

	public String getBiography() {
		return biography;
	}

	public Long getNumPlays() {
		return numPlays;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Band band)) return false;
		return Objects.equals(id, band.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
