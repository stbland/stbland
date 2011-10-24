package org.stbland.test.mavengwtmodular.module4.client.mappers.activity;

import java.util.LinkedList;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.web.bindery.event.shared.HandlerRegistration;

public abstract class JQMAbstractActivity extends AbstractActivity {

	private LinkedList<HandlerRegistration> handlers;

	public JQMAbstractActivity() {
		handlers = new LinkedList<HandlerRegistration>();
	}

	protected void addHandlerRegistration(
			HandlerRegistration handlerRegistration) {
		handlers.add(handlerRegistration);
	}

	@Override
	public void onStop() {
		super.onStop();

		cancelAllHandlerRegistrations();
	}

	protected void cancelAllHandlerRegistrations() {
		for (HandlerRegistration hr : handlers) {
			hr.removeHandler();
		}
		handlers.clear();
	}

}
