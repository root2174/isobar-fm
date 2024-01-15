package org.dws.isobarfm.app.usecases.bands.list.all;

import org.dws.isobarfm.app.gateways.BandsGateway;
import org.dws.isobarfm.domain.entities.Band;

import java.util.List;

public class ListAllBandsInteractor {
	private final BandsGateway bandsGateway;

	public ListAllBandsInteractor(BandsGateway bandsGateway) {
		this.bandsGateway = bandsGateway;
	}

	public List<Band> execute(ListAllBandsQuery request) {
		return bandsGateway.listAll(request);
	}
}
