package org.dws.isobarfm.infra.gateways;

import lombok.RequiredArgsConstructor;
import org.dws.isobarfm.app.exceptions.BandNotFoundException;
import org.dws.isobarfm.app.gateways.BandsGateway;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsQuery;
import org.dws.isobarfm.app.usecases.bands.list.all.Order;
import org.dws.isobarfm.app.usecases.bands.list.all.Sort;
import org.dws.isobarfm.domain.entities.Band;
import org.dws.isobarfm.infra.clients.bands.BandsClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BandsGatewayImpl implements BandsGateway {
	private final BandsClient bandsClient;

	@Override
	public List<Band> listAll(ListAllBandsQuery query) {
		List<Band> bands = new ArrayList<>(
				bandsClient.getBands()
				.stream()
				.filter(band -> band.getName().toLowerCase().contains(query.getName().toLowerCase())).toList()
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

	@Override
	public Band listById(UUID id) {
		List<Band> bands = bandsClient.getBands();

		return bands.stream()
				.filter(band -> band.getId().equals(id))
				.findFirst()
				.orElseThrow(BandNotFoundException::new);
	}
}
