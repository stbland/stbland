package org.stbland.test.mavengwtmodular.module4.client.activities;

import org.stbland.test.mavengwtmodular.module4.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module4.client.mappers.activity.JQMAbstractActivity;

public abstract class AbstractActivity extends JQMAbstractActivity {

	protected PortailClientFactory clientFactory;

	public AbstractActivity(PortailClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
}
