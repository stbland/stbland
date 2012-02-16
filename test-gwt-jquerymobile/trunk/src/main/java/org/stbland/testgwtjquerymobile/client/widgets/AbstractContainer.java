package org.stbland.testgwtjquerymobile.client.widgets;

import com.google.gwt.user.client.ui.FlowPanel;

public abstract class AbstractContainer extends FlowPanel implements
		HasDataRole {

	public void setDataRole(String value) {
		setAttribute("data-role", value);
	}

	public String getDataRole() {
		return getAttribute("data-role");
	}

	protected void setAttribute(String name, String value) {
		getElement().setAttribute(name, value);

	}

	protected String getAttribute(String name) {
		return getElement().getAttribute(name);
	}

}
