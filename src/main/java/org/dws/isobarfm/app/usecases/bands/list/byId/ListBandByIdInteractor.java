package org.dws.isobarfm.app.usecases.bands.list.byId;

import org.dws.isobarfm.app.gateways.BandsGateway;
import org.dws.isobarfm.domain.entities.Band;

import java.util.UUID;

public class ListBandByIdInteractor {

	private final BandsGateway bandsGateway;

	public ListBandByIdInteractor(BandsGateway bandsGateway) {
		this.bandsGateway = bandsGateway;
	}

	public Band execute(UUID id) {
		return bandsGateway.listById(id);
	}
}
