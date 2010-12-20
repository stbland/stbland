package org.stbland.phonebookgwt.shared.logger;

import org.stbland.phonebookgwt.shared.logger.impl.SystemLogger;

public class LoggerFactory {

	public static Logger getLogger(Class clazz) {
		return new SystemLogger(clazz);
	}

}
