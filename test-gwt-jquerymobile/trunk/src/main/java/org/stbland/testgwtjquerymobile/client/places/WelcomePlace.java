package org.stbland.testgwtjquerymobile.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class WelcomePlace extends Place {

	@Prefix("welcome")
	public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {
		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}

		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}
	}

	public WelcomePlace() {
		super();
	}

}
