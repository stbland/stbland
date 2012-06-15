package org.stbland.musicgwt.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class CustomRequestTransport extends DefaultRequestTransport {

	@Override
	public void send(String payload, TransportReceiver receiver) {
		doBeforeSend();
		super.send(payload, wrap(receiver));
	}

	private TransportReceiver wrap(final TransportReceiver delegate) {
		return new TransportReceiver() {

			public void onTransportSuccess(String payload) {
				doOnSuccess();
				delegate.onTransportSuccess(payload);
			}

			public void onTransportFailure(ServerFailure failure) {
				doOnFailure(failure);
				delegate.onTransportFailure(failure);
			}
		};
	}

	protected void doBeforeSend() {
		// Some processing before the request is send
		GWT.log("CustomRequestTransport.doBeforeSend");
		Document.get().getBody().getStyle().setCursor(Cursor.WAIT);
	}

	protected void doOnSuccess() {
		// Some processing on success
		GWT.log("CustomRequestTransport.doOnSuccess");
		Document.get().getBody().getStyle().setCursor(Cursor.DEFAULT);
	}

	protected void doOnFailure(ServerFailure failure) {
		// Some processing on failure
		GWT.log("CustomRequestTransport.doOnFailure");
		GWT.log(failure.getMessage());
		Document.get().getBody().getStyle().setCursor(Cursor.DEFAULT);
	}
}