package org.stbland.test.mavengwtmodular.module3.client.mappers.history;

import org.stbland.test.mavengwtmodular.module3.client.places.LoginPlace;
import org.stbland.test.mavengwtmodular.module3.client.places.MenuPlace;
import org.stbland.test.mavengwtmodular.module3.client.places.MenuPlace.Tokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;


@WithTokenizers({ MenuPlace.Tokenizer.class, LoginPlace.Tokenizer.class })
public interface PortailPlaceHistoryMapper extends PlaceHistoryMapper {

}
