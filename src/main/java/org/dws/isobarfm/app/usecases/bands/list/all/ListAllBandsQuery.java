package org.dws.isobarfm.app.usecases.bands.list.all;

public class ListAllBandsQuery {
	private final String name;
	private final Sort sort;

	private final Order order;

	public ListAllBandsQuery(String name, Sort sort, Order order) {
		this.name = name;
		this.sort = sort;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public Sort getSort() {
		return sort;
	}

	public Order getOrder() {
		return order;
	}
}
