package org.dws.isobarfm.infra.controllers;

import lombok.RequiredArgsConstructor;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsInteractor;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsQuery;
import org.dws.isobarfm.app.usecases.bands.list.all.Order;
import org.dws.isobarfm.app.usecases.bands.list.all.Sort;
import org.dws.isobarfm.app.usecases.bands.list.byId.ListBandByIdInteractor;
import org.dws.isobarfm.domain.entities.Band;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bands")
public class BandController {
	private final ListAllBandsInteractor listAllBandsInteractor;
	private final ListBandByIdInteractor listBandByIdInteractor;

	@GetMapping
	public ResponseEntity<List<Band>> listAll(
			@RequestParam(defaultValue = "") String bandName,
			@RequestParam(defaultValue = "ALPHABETICAL") String sort,
			@RequestParam(defaultValue = "ASC") String order
			) {
		Order sortOrder = Order.valueOf(order.toUpperCase());
		Sort sortType = Sort.valueOf(sort.toUpperCase());

		ListAllBandsQuery query = new ListAllBandsQuery(bandName, sortType, sortOrder);
		return ResponseEntity.ok(listAllBandsInteractor.execute(query));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Band> listById(@PathVariable UUID id) {
		return ResponseEntity.ok(listBandByIdInteractor.execute(id));
	}
}
