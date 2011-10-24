package org.stbland.test.mavengwtmodular.module4.client.mappers.history;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import org.stbland.test.mavengwtmodular.module4.client.mappers.history.PortailPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class PortailPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements PortailPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace) {
      org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace place = (org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace) newPlace;
      PlaceTokenizer<org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace> t = GWT.create(org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace.Tokenizer.class);
      return new PrefixAndToken("LoginPlace", t.getToken((org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace) place));
    }
    if (newPlace instanceof org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace) {
      org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace place = (org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace) newPlace;
      PlaceTokenizer<org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace> t = GWT.create(org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace.Tokenizer.class);
      return new PrefixAndToken("MenuPlace", t.getToken((org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("MenuPlace".equals(prefix)) {
      return GWT.create(org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace.Tokenizer.class);
    }
    if ("LoginPlace".equals(prefix)) {
      return GWT.create(org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace.Tokenizer.class);
    }
    return null;
  }

}
