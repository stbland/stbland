package org.stbland.test.mavengwtmodular.module3.client;

import org.stbland.test.mavengwtmodular.module3.client.css.AppBundle;
import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.factory.impl.PortailClientFactoryGwtImpl;
import org.stbland.test.mavengwtmodular.module3.client.mappers.activity.PhoneActivityMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.activity.TabletMainActivityMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.activity.TabletNavActivityMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.animation.phone.PortailPhoneAnimationMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.animation.phone.TabletMainAnimationMapper;
import org.stbland.test.mavengwtmodular.module3.client.mappers.animation.phone.TabletNavAnimationMapper;
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
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTUtil;
import com.googlecode.mgwt.ui.client.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.OrientationRegionHandler;
import com.googlecode.mgwt.ui.client.panel.TabletPortraitOverlay;

public class Module3EntryPoint implements EntryPoint {

	private PortailClientFactory clientFactory;

	private void start() {
		MGWTSettings settings = new MGWTSettings();
		settings.setAddGlosToIcon(true);
		settings.setFixViewPort(true);
		settings.setFullscreen(true);
		settings.setPreventScrolling(true);

		MGWT mgwt = new MGWT();
		mgwt.applySettings(settings);

		clientFactory = new PortailClientFactoryGwtImpl();

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

			// very nasty workaround because GWT does not corretly support
			// @media
			StyleInjector.inject(AppBundle.INSTANCE.appCss().getText());
			createTabletDisplay(clientFactory);
		} else {
			createPhoneDisplay(clientFactory);

		}

		initPhoneGap();

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

	private void createTabletDisplay(PortailClientFactory clientFactory) {
		SimplePanel navContainer = new SimplePanel();
		navContainer.getElement().setId("nav");
		navContainer.getElement().addClassName("landscapeonly");
		AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);

		final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

		new OrientationRegionHandler(navContainer, tabletPortraitOverlay,
				navDisplay);
		new MasterRegionHandler(clientFactory.getEventBus(), "nav",
				tabletPortraitOverlay);

		ActivityMapper navActivityMapper = new TabletNavActivityMapper(
				clientFactory);

		AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

		AnimatingActivityManager navActivityManager = new AnimatingActivityManager(
				navActivityMapper, navAnimationMapper,
				clientFactory.getEventBus());

		navActivityManager.setDisplay(navDisplay);

		RootPanel.get().add(navContainer);

		SimplePanel mainContainer = new SimplePanel();
		mainContainer.getElement().setId("main");
		AnimatableDisplay mainDisplay = GWT.create(AnimatableDisplay.class);

		ActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(
				clientFactory);

		AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

		AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(
				tabletMainActivityMapper, tabletMainAnimationMapper,
				clientFactory.getEventBus());

		mainActivityManager.setDisplay(mainDisplay);
		mainContainer.setWidget(mainDisplay);

		RootPanel.get().add(mainContainer);

	}

	private void initPhoneGap() {
		final PhoneGap phoneGap = clientFactory.getPhoneGap();

		phoneGap.addHandler(new PhoneGapAvailableHandler() {

			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				showDebug("onPhoneGapAvailable");

				clientFactory.getEventBus().fireEvent(event);

			}
		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {

			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				showError("onPhoneGapTimeout");

				clientFactory.getEventBus().fireEvent(event);
			}
		});

		phoneGap.initializePhoneGap();
	}

	@Override
	public void onModuleLoad() {
		showDebug("onModuleLoad");

		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				showError("uncaught: " + e.getMessage());
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

	private void showInfo(String msg) {
		GWT.log("INFO: " + msg);
		Window.alert(msg);
	}

	private void showDebug(String msg) {
		GWT.log("DEBUG: " + msg);
		if (true) {
			Window.alert("DEBUG: " + msg);
		}
	}

	private void showError(String msg) {
		GWT.log("ERROR: " + msg);
		Window.alert("ERROR: " + msg);
	}

}
