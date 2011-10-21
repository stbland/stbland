package org.stbland.test.mavengwtmodular.module3.client;

import org.stbland.test.mavengwtmodular.module3.client.css.PortailMgwtClientBundle;
import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.factory.impl.PortailClientFactoryGwtImpl;
import org.stbland.test.mavengwtmodular.module3.client.mappers.activity.PhoneActivityMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.animation.phone.PortailPhoneAnimationMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.history.PortailPlaceHistoryMapper;
import org.stbland.test.mavengwtmodular.module3.client.places.LoginPlace;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTUtil;

public class Module3EntryPoint implements EntryPoint {

	private void start() {
		MGWTSettings settings = new MGWTSettings();
		settings.setAddGlosToIcon(true);
		settings.setFixViewPort(true);
		settings.setFullscreen(true);
		settings.setPreventScrolling(true);

		MGWT mgwt = new MGWT();
		mgwt.applySettings(settings);

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

		if ((MGWTUtil.getFeatureDetection().isIPad() || MGWTUtil
				.getFeatureDetection().isDesktop())) {
			// workaround
			StyleInjector.inject(PortailMgwtClientBundle.INSTANCE.css()
					.getText());
			// TODO createTabletDisplay(clientFactory);

			createPhoneDisplay(clientFactory);
		} else {
			createPhoneDisplay(clientFactory);

		}
		historyHandler.handleCurrentHistory();

	}

	private void createPhoneDisplay(PortailClientFactory clientFactory) {
		AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

		ActivityMapper activityMapper = new PhoneActivityMapper(clientFactory);

		AnimationMapper animationMapper = new PortailPhoneAnimationMapper();

		AnimatingActivityManager activityManager = new AnimatingActivityManager(
				activityMapper, animationMapper, clientFactory.getEventBus());

		activityManager.setDisplay(display);

		RootPanel.get().add(display);

	}

	/*
	 * private void createTabletDisplay(PortailClientFactory clientFactory) {
	 * SimplePanel navContainer = new SimplePanel();
	 * navContainer.getElement().setId("nav");
	 * navContainer.getElement().addClassName("landscapeonly");
	 * AnimatableDisplayBaseImpl navDisplay = GWT
	 * .create(AnimatableDisplay.class);
	 * 
	 * ActivityMapper activityMapper = new TabletActivityMapper(clientFactory);
	 * 
	 * AnimationMapper animationMapper = new PortailTabletAnimationMapper();
	 * 
	 * AnimatingActivityManager activityManager = new AnimatingActivityManager(
	 * activityMapper, animationMapper, clientFactory.getEventBus());
	 * 
	 * activityManager.setDisplay(navDisplay);
	 * navContainer.setWidget(navDisplay);
	 * 
	 * RootPanel.get().add(navContainer);
	 * 
	 * SimplePanel mainContainer = new SimplePanel();
	 * mainContainer.getElement().setId("main"); AnimatableDisplayBaseImpl
	 * mainDisplay = GWT .create(AnimatableDisplay.class);
	 * 
	 * TabletMainActivityMapper tabletMainActivityMapper = new
	 * TabletMainActivityMapper( clientFactory);
	 * 
	 * AnimationMapper tabletMainAnimationMapper = new
	 * TabletMainAnimationMapper();
	 * 
	 * AnimatingActivityManager mainActivityManager = new
	 * AnimatingActivityManager( tabletMainActivityMapper,
	 * tabletMainAnimationMapper, clientFactory.getEventBus());
	 * 
	 * mainActivityManager.setDisplay(mainDisplay);
	 * mainContainer.setWidget(mainDisplay);
	 * 
	 * RootPanel.get().add(mainContainer);
	 * 
	 * }
	 */

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
