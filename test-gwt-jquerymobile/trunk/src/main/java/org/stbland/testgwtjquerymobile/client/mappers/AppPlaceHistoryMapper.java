package org.stbland.testgwtjquerymobile.client.mappers;

import org.stbland.testgwtjquerymobile.client.places.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ WelcomePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
