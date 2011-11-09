package org.stbland.test.gwtspringsecurity.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class SecurePlace extends Place {

	@Prefix("secure")
	public static class Tokenizer implements PlaceTokenizer<SecurePlace> {

		@Override
		public SecurePlace getPlace(String token) {
			return new SecurePlace();

		}

		@Override
		public String getToken(SecurePlace place) {
			return "";

		}
	}

}
