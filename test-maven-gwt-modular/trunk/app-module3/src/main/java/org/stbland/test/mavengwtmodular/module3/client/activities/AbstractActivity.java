package org.stbland.test.mavengwtmodular.module3.client.activities;

import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;

import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;

public abstract class AbstractActivity extends MGWTAbstractActivity {

	protected PortailClientFactory clientFactory;

	public AbstractActivity(PortailClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
}
