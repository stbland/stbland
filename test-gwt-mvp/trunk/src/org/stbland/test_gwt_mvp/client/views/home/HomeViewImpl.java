package org.stbland.test_gwt_mvp.client.views.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements HomeView {

	private static HomeViewUiBinder uiBinder = GWT
			.create(HomeViewUiBinder.class);

	private Presenter presenter;

	interface HomeViewUiBinder extends UiBinder<Widget, HomeViewImpl> {
	}

	public HomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
