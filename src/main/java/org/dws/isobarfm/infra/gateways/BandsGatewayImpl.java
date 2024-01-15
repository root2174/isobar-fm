package org.dws.isobarfm.infra.gateways;

import lombok.RequiredArgsConstructor;
import org.dws.isobarfm.app.gateways.BandsGateway;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsQuery;
import org.dws.isobarfm.app.usecases.bands.list.all.Order;
import org.dws.isobarfm.app.usecases.bands.list.all.Sort;
import org.dws.isobarfm.domain.entities.Band;
import org.dws.isobarfm.infra.clients.BandsClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BandsGatewayImpl implements BandsGateway {
	private final BandsClient bandsClient;

	@Override
	public List<Band> listAll(ListAllBandsQuery query) {
		List<Band> bands = new ArrayList<>(
				bandsClient.getBands()
				.stream()
				.filter(band -> band.getName().contains(query.getName())).toList()
		);

		Comparator<Band> bandComparator;

		if (query.getSort() == Sort.ALPHABETICAL) {
			bandComparator = Comparator.comparing(Band::getName);
		} else {
			bandComparator = Comparator.comparing(Band::getNumPlays);
		}

		if (query.getOrder() == Order.DESC) {
			bandComparator = bandComparator.reversed();
		}

		bands.sort(bandComparator);

		return bands;
	}
}
