package org.stbland.phonebookgwt.shared.logger.impl;

import org.stbland.phonebookgwt.shared.logger.Logger;

public class SystemLogger implements Logger {

	private Class clazz;

	public SystemLogger(Class clazz) {
		this.clazz = clazz;
	}

	public void info(String s) {
		if (true) {
			System.out.println(s);
		}
	}

}
