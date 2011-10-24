package org.stbland.test.mavengwtmodular.module4.client.views.impl;

import org.stbland.test.mavengwtmodular.module4.client.css.AppBundle;
import org.stbland.test.mavengwtmodular.module4.client.views.ViewGwt;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;

public abstract class AbstractViewGwtImpl implements ViewGwt {
	protected JQMPage main;
	protected JQMHeader headerPanel;
	protected JQMButton headerBackButton;
	protected JQMButton headerMainButton;
	protected HTML title;

	public AbstractViewGwtImpl(String pageId) {
		StyleInjector.inject(AppBundle.INSTANCE.inputCss().getText());

		main = new JQMPage(pageId);

		headerBackButton = new JQMButton("");
		headerMainButton = new JQMButton("");
		headerPanel = new JQMHeader("", headerBackButton, headerMainButton);

		main.add(headerPanel);
	}

	@Override
	public Widget asWidget() {
		return main;
	}

	@Override
	public HasText getHeader() {
		return title;
	}

	@Override
	public HasText getBackButtonText() {
		return headerBackButton;
	}

	@Override
	public HasClickHandlers getBackButton() {
		return headerBackButton;
	}

	@Override
	public HasText getMainButtonText() {
		return headerMainButton;
	}

	@Override
	public HasClickHandlers getMainButton() {
		return headerMainButton;
	}

}