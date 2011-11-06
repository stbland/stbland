package org.stbland.test.facebook;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class Configuration {

	protected static Log log = LogFactory.getLog(Configuration.class);

	private PropertiesConfiguration internalConfiguration;

	private Configuration() {
		try {
			internalConfiguration = new PropertiesConfiguration(
					"facebookfetcher.properties");
		} catch (ConfigurationException e) {
			log.error(e);
		}
	}

	private static Configuration instance;

	public static Configuration getInstance() {
		if (null == instance) {
			instance = new Configuration();
		}
		return instance;
	}

	protected String getString(String key) {
		if (internalConfiguration != null) {
			return internalConfiguration.getString(key);
		} else {
			return System.getProperty(key);
		}
	}

	public String getFaceBookApplicationKey() {
		return getString("facebook.applicationKey");
	}

	public String getFaceBookApplicationSecret() {
		return getString("facebook.applicationSecret");
	}

	public String getFaceBookPostId() {
		return getString("facebook.postId");
	}

	public String getBrowserPath() {
		return getString("browser.path");
	}
	
	public String getFacebookUserLogin() {
		return getString("facebook.userLogin");
	}
	
	public String getFacebookUserPassword() {
		return getString("facebook.userPassword");
	}
	


}
