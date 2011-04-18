package org.stbland.test_gwt_mvp.client.mvp;

import org.stbland.test_gwt_mvp.client.places.HomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HomePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
