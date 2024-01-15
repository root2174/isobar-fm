package org.dws.isobarfm.infra.clients.bands;

import org.dws.isobarfm.domain.entities.Band;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bands", url = "${bands.url}")
public interface BandsClient {
	@GetMapping( value = "/bands", produces = "application/json")
	@Cacheable("bands")
	List<Band> getBands();
}
