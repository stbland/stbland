package org.stbland.musicgwt.client.ioc;

import org.stbland.musicgwt.client.app.GxtUiApp;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(GxtUiModule.class)
public interface GxtUiGinjector extends Ginjector {

	GxtUiApp getApp();
}
