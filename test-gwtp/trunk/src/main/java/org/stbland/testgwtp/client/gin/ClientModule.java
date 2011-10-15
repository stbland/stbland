package org.stbland.testgwtp.client.gin;

import org.stbland.testgwtp.client.place.ClientPlaceManager;
import org.stbland.testgwtp.client.place.DefaultPlace;
import org.stbland.testgwtp.client.place.NameTokens;
import org.stbland.testgwtp.client.presenter.ContactPresenter;
import org.stbland.testgwtp.client.presenter.HomePresenter;
import org.stbland.testgwtp.client.presenter.MainPagePresenter;
import org.stbland.testgwtp.client.view.ContactViewGwtMobileUiImpl;
import org.stbland.testgwtp.client.view.ContactViewUiBinderImpl;
import org.stbland.testgwtp.client.view.HomeView;
import org.stbland.testgwtp.client.view.MainPageView;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		// Constants
		bindConstant().annotatedWith(DefaultPlace.class)
				.to(NameTokens.homePage);

		// Presenters
		bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
				MainPageView.class, MainPagePresenter.MyProxy.class);
		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);
		if (false) {
			bindPresenter(ContactPresenter.class,
					ContactPresenter.MyView.class,
					ContactViewUiBinderImpl.class,
					ContactPresenter.MyProxy.class);
		} else {
			bindPresenter(ContactPresenter.class,
					ContactPresenter.MyView.class,
					ContactViewGwtMobileUiImpl.class,
					ContactPresenter.MyProxy.class);
		}
	}

}
