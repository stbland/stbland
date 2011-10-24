package org.stbland.test.mavengwtmodular.module4.client;

public final class NavigatorHelper {

	NavigatorHelper() {
	}

	public native static boolean isOrientationSupport()/*-{
		var ua = window.navigator.userAgent.toLowerCase();
		if (ua.indexOf('android') != -1) {
			return false;
		}
		if (ua.indexOf('iphone') != -1) {
			return true;
		}
		if (ua.indexOf('ipad') != -1) {
			return true;
		}

		return false;
	}-*/;

	public native static boolean isMobile()/*-{
		var ua = window.navigator.userAgent.toLowerCase();
		if (ua.indexOf('android') != -1) {
			return true;
		}
		if (ua.indexOf('iphone') != -1) {
			return true;
		}
		if (ua.indexOf('ipad') != -1) {
			return true;
		}

		return false;
	}-*/;

	public native static boolean isTablet()/*-{
		var ua = window.navigator.userAgent.toLowerCase();
		if (ua.indexOf('android') != -1) {
			return false;
		}
		if (ua.indexOf('iphone') != -1) {
			return false;
		}
		if (ua.indexOf('ipad') != -1) {
			return true;
		}

		return false;
	}-*/;

	public native static boolean isDesktop()/*-{
		var ua = window.navigator.userAgent.toLowerCase();
		if (ua.indexOf('android') != -1) {
			return false;
		}
		if (ua.indexOf('iphone') != -1) {
			return false;
		}
		if (ua.indexOf('ipad') != -1) {
			return false;
		}

		return true;
	}-*/;

}
