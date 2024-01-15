package org.dws.isobarfm.app.gateways;

import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsQuery;
import org.dws.isobarfm.domain.entities.Band;

import java.util.List;

public interface BandsGateway {
	List<Band> listAll(ListAllBandsQuery query);
}
