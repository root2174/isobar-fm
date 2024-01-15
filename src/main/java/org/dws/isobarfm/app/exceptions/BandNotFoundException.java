package org.dws.isobarfm.app.exceptions;

public class BandNotFoundException extends RuntimeException {
	public BandNotFoundException() {
		super("Band not found");
	}
}
