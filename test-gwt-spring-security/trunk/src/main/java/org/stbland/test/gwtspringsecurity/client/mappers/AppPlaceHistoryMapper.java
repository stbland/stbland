package org.stbland.test.gwtspringsecurity.client.mappers;

import org.stbland.test.gwtspringsecurity.client.places.LoginPlace;
import org.stbland.test.gwtspringsecurity.client.places.SecurePlace;
import org.stbland.test.gwtspringsecurity.client.places.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ WelcomePlace.Tokenizer.class, LoginPlace.Tokenizer.class, SecurePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}