/*
 * Copyright 2012 Daniel Kurka
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
package com.googlecode.mgwt.examples.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeEndHandler;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeMoveEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeMoveHandler;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeStartEvent;
import com.googlecode.mgwt.dom.client.recognizer.swipe.SwipeStartHandler;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.animation.AnimationHelper;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.touch.TouchDelegate;

public class SwipeRecognizerExample implements EntryPoint {

        @Override
        public void onModuleLoad() {
                //set viewport and other settings for mobile
                MGWT.applySettings(MGWTSettings.getAppSetting());

                //build animation helper and attach it
                AnimationHelper animationHelper = new AnimationHelper();
                RootPanel.get().add(animationHelper);

                //build some UI
                LayoutPanel layoutPanel = new LayoutPanel();

                final RoundPanel roundPanel = new RoundPanel();
                roundPanel.getElement().getStyle().setProperty("minHeight", "200px");
                layoutPanel.add(roundPanel);

                TouchDelegate touchDelegate = new TouchDelegate(roundPanel);
                touchDelegate.addSwipeStartHandler(new SwipeStartHandler() {

                        @Override
                        public void onSwipeStart(SwipeStartEvent event) {
                                roundPanel.clear();
                                roundPanel.add(new HTML("swipe start detected at: " + event.getTouch().getPageX() + " " + event.getTouch().getPageY()));

                        }
                });

                touchDelegate.addSwipeMoveHandler(new SwipeMoveHandler() {

                        @Override
                        public void onSwipeMove(SwipeMoveEvent event) {
                                roundPanel.add(new HTML("swipe move detected at: " + event.getTouch().getPageX() + " " + event.getTouch().getPageY()));

                        }
                });

                touchDelegate.addSwipeEndHandler(new SwipeEndHandler() {

                        @Override
                        public void onSwipeEnd(SwipeEndEvent event) {
                                roundPanel.add(new HTML("swipe end detected"));

                        }
                });

                //animate
                animationHelper.goTo(layoutPanel, Animation.SLIDE);
        }
}