package org.stbland.test.mavengwtmodular.module3.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.TextResource;
import com.googlecode.mgwt.ui.client.theme.base.MGWTClientBundle;

public interface PortailMgwtClientBundle extends MGWTClientBundle {
	// nasty workaround
	@Source("media.css")
	public TextResource css();

	@Source({ "com/googlecode/mgwt/ui/client/theme/base/css/list.css",
			"portail.css" })
	public AppCss getAppCss();

	@Source("delete.png")
	public DataResource deleteImage();

	public static final PortailMgwtClientBundle INSTANCE = GWT
			.create(PortailMgwtClientBundle.class);

}
