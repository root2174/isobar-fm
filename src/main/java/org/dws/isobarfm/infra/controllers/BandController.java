package org.dws.isobarfm.infra.controllers;

import lombok.RequiredArgsConstructor;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsInteractor;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsQuery;
import org.dws.isobarfm.app.usecases.bands.list.all.Order;
import org.dws.isobarfm.app.usecases.bands.list.all.Sort;
import org.dws.isobarfm.domain.entities.Band;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/bands")
public class BandController {
	private final ListAllBandsInteractor listAllBandsInteractor;

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
}
