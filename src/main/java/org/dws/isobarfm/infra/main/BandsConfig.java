package org.dws.isobarfm.infra.main;

import org.dws.isobarfm.app.gateways.BandsGateway;
import org.dws.isobarfm.app.usecases.bands.list.all.ListAllBandsInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BandsConfig {

	@Bean
	public ListAllBandsInteractor listAllBandsInteractor(BandsGateway bandsGateway) {
		return new ListAllBandsInteractor(bandsGateway);
	}
}
