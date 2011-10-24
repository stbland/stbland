package org.stbland.test.mavengwtmodular.module4.client.mappers.animation.phone;

import org.stbland.test.mavengwtmodular.module4.client.mappers.animation.JQMTransitionMapper;

import com.google.gwt.place.shared.Place;
import com.sksamuel.jqm4gwt.Transition;

public class PortailTabletAnimationMapper implements JQMTransitionMapper {

	@Override
	public Transition getTransition(Place oldPlace, Place newPlace) {

		return Transition.FADE;
	}

}
