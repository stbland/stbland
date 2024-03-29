package org.stbland.test.mavengwtmodular.module4.client;

import org.stbland.test.mavengwtmodular.module4.client.css.AppBundle;
import org.stbland.test.mavengwtmodular.module4.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module4.client.factory.impl.PortailClientFactoryGwtImpl;
import org.stbland.test.mavengwtmodular.module4.client.mappers.activity.JQMTransitionActivityManager;
import org.stbland.test.mavengwtmodular.module4.client.mappers.activity.PhoneActivityMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.activity.TabletMainActivityMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.activity.TabletNavActivityMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.JQMTransitionMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.phone.PortailPhoneAnimationMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.phone.TabletMainAnimationMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.phone.TabletNavAnimationMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.history.PortailPlaceHistoryMapper;
import org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class Module4EntryPoint implements EntryPoint {

	private void start() {

		final PortailClientFactory clientFactory = new PortailClientFactoryGwtImpl();

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		PortailPlaceHistoryMapper historyMapper = GWT
				.create(PortailPlaceHistoryMapper.class);
		final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);

		// Place defaultPlace = new MenuPlace();
		Place defaultPlace = new LoginPlace();
		historyHandler.register(clientFactory.getPlaceController(),
				clientFactory.getEventBus(), defaultPlace);

		// if (NavigatorHelper.isTablet() || NavigatorHelper.isDesktop()) {
		if ( false ) {

			// very nasty workaround because GWT does not corretly support
			// @media
			StyleInjector.inject(AppBundle.INSTANCE.appCss().getText());
			createTabletDisplay(clientFactory);
		} else {
			createPhoneDisplay(clientFactory);

		}
		historyHandler.handleCurrentHistory();

	}

	private void createPhoneDisplay(PortailClientFactory clientFactory) {
	//	AnimatableDisplay display = GWT.create(AnimatableDisplay.class);
		
		Panel display = RootPanel.get();
		
		GWT.log("createPhoneDisplay");

		ActivityMapper activityMapper = new PhoneActivityMapper(clientFactory);

		JQMTransitionMapper transitionMapper = new PortailPhoneAnimationMapper();

		JQMTransitionActivityManager transitionActivityManager = new JQMTransitionActivityManager(activityMapper, transitionMapper, clientFactory.getEventBus());
		
	//	transitionActivityManager.setDisplay(display);

		// RootPanel.get().add(display);

	}

	private void createTabletDisplay(PortailClientFactory clientFactory) {
		SimplePanel navContainer = new SimplePanel();
		navContainer.getElement().setId("nav");
		navContainer.getElement().addClassName("landscapeonly");
		// AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);

		// final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

		// new OrientationRegionHandler(navContainer, tabletPortraitOverlay,	navDisplay);
		// new MasterRegionHandler(clientFactory.getEventBus(), "nav",	tabletPortraitOverlay);

		ActivityMapper navActivityMapper = new TabletNavActivityMapper(
				clientFactory);

		JQMTransitionMapper navAnimationMapper = new TabletNavAnimationMapper();

		JQMTransitionActivityManager navActivityManager = new JQMTransitionActivityManager(
				navActivityMapper, navAnimationMapper,
				clientFactory.getEventBus());

		//navActivityManager.setDisplay(navDisplay);

		RootPanel.get().add(navContainer);

		SimplePanel mainContainer = new SimplePanel();
		mainContainer.getElement().setId("main");
		// AnimatableDisplay mainDisplay = GWT.create(AnimatableDisplay.class);

		ActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(
				clientFactory);

		JQMTransitionMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

		JQMTransitionActivityManager mainActivityManager = new JQMTransitionActivityManager(
				tabletMainActivityMapper, tabletMainAnimationMapper,
				clientFactory.getEventBus());

		// mainActivityManager.setDisplay(mainDisplay);
		// mainContainer.setWidget(mainDisplay);

		RootPanel.get().add(mainContainer);

	}

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();

			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);

	}

}
