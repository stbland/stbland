package org.stbland.testgwtp.client.gin;

import org.stbland.testgwtp.client.presenter.ContactPresenter;
import org.stbland.testgwtp.client.presenter.HomePresenter;
import org.stbland.testgwtp.client.presenter.MainPagePresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	Provider<MainPagePresenter> getMainPagePresenter();

	AsyncProvider<HomePresenter> getHomePresenter();

	AsyncProvider<ContactPresenter> getContactPresenter();

}
