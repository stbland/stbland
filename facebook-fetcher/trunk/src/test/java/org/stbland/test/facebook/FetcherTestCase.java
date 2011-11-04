package org.stbland.test.facebook;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJaxbRestClient;

public class FetcherTestCase extends TestCase {

	protected static Log log = LogFactory.getLog(FetcherTestCase.class);

	protected void setUp() throws Exception {
		super.setUp();

	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}

	protected FacebookJaxbRestClient getFacebookClient() {
		final String apiKey = System.getProperty("facebook.applicationKey");
		assertNotNull("apiKey", apiKey);
		final String secret = System.getProperty("facebook.applicationSecret");
		assertNotNull("secret", secret);
		return new FacebookJaxbRestClient(apiKey, secret);
	}

	public void test_stream_getComments() throws FacebookException {
		String postId = System.getProperty("facebook.postId");

		assertNotNull("postId", postId);
		FacebookJaxbRestClient facebookClient = getFacebookClient();

		log.debug("test_stream_getComments postId: " + postId);
		facebookClient.stream_getComments(postId);
	}
}
