/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.stbland.testgwtp.client.view.desktop;

import org.stbland.testgwtp.client.presenter.ContactPresenterBase.MyView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Christian Goudreau
 */
public class ContactViewUiBinderImpl extends ViewImpl implements MyView {

	interface ContactViewUiBinder extends
			UiBinder<Widget, ContactViewUiBinderImpl> {
	}

	private static ContactViewUiBinder uiBinder = GWT
			.create(ContactViewUiBinder.class);

	private final Widget widget;

	@UiField
	Label navigationHistory;

	public ContactViewUiBinderImpl() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setNavigationHistory(String navigationHistory) {
		this.navigationHistory.setText(navigationHistory);
	}
}