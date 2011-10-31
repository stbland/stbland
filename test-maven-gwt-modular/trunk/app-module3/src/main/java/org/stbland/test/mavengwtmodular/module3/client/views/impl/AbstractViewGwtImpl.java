package org.stbland.test.mavengwtmodular.module3.client.views.impl;

import org.stbland.test.mavengwtmodular.module3.client.css.AppBundle;
import org.stbland.test.mavengwtmodular.module3.client.views.ViewGwt;

import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.MGWTUtil;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public abstract class AbstractViewGwtImpl implements ViewGwt {

	protected LayoutPanel main;
	protected ScrollPanel scrollPanel;
	protected HeaderPanel headerPanel;
	protected HeaderButton headerBackButton;
	protected HeaderButton headerMainButton;
	protected HTML title;

	public AbstractViewGwtImpl() {

		if (false) {
			StyleInjector.inject(AppBundle.INSTANCE.inputCss().getText());
		}

		main = new LayoutPanel();

		scrollPanel = new ScrollPanel();

		headerPanel = new HeaderPanel();
		title = new HTML();
		headerPanel.setCenterWidget(title);
		headerBackButton = new HeaderButton();
		headerBackButton.setBackButton(true);

		headerMainButton = new HeaderButton();
		headerMainButton.setRoundButton(true);

		if (MGWTUtil.getFeatureDetection().isPhone()) {
			headerPanel.setLeftWidget(headerBackButton);
		} else {
			headerPanel.setLeftWidget(headerMainButton);
			headerMainButton.addStyleName(MGWTStyle.getDefaultClientBundle()
					.getUtilCss().portraitonly());
		}

		main.add(headerPanel);
		main.add(scrollPanel);
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
	public HasSimpleTouchHandler getBackButton() {
		return headerBackButton;
	}

	@Override
	public HasText getMainButtonText() {
		return headerMainButton;
	}

	@Override
	public HasSimpleTouchHandler getMainButton() {
		return headerMainButton;
	}

	@Override
	public void setTitle(String title) {
		headerPanel.setCenter(title);
	}

	@Override
	public void setBackButtonText(String text) {
		headerBackButton.setText(text);

	}

}