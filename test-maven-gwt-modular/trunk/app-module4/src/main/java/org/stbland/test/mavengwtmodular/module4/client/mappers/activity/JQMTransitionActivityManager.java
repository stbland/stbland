package org.stbland.test.mavengwtmodular.module4.client.mappers.activity;

import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.JQMTransitionMapper;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class JQMTransitionActivityManager implements PlaceChangeEvent.Handler,
		PlaceChangeRequestEvent.Handler {

	private JQMTransitionMapper transitionMapper;
	private ActivityMapper mapper;
	private EventBus eventBus;
	private AcceptsOneWidget panel;

	public JQMTransitionActivityManager(ActivityMapper mapper,
			JQMTransitionMapper transitionMapper, EventBus eventBus) {
		super();
		this.mapper = mapper;
		this.eventBus = eventBus;
		this.transitionMapper = transitionMapper;

		// JQMContext.changePage(page)

		this.eventBus.addHandler(PlaceChangeEvent.TYPE, this);
		this.eventBus.addHandler(PlaceChangeRequestEvent.TYPE, this);
	}

	@Override
	public void onPlaceChangeRequest(PlaceChangeRequestEvent event) {
		Place newPlace = event.getNewPlace();
		GWT.log("onPlaceChangeRequest newPlace" + newPlace);

	}

	@Override
	public void onPlaceChange(PlaceChangeEvent event) {
		Place newPlace = event.getNewPlace();
		GWT.log("onPlaceChange newPlace" + newPlace);
		JQMAbstractActivity activity = (JQMAbstractActivity) mapper
				.getActivity(newPlace);
	//	activity.start(panel, eventBus);
	}

	public void setDisplay(AcceptsOneWidget panel) {
		this.panel = panel;
	}

}
