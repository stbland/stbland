package org.stbland.test.facebook;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJaxbRestClient;
import com.google.code.facebookapi.schema.StreamGetCommentsResponse;

public class FetcherTestCase extends TestCase {

	protected static Log log = LogFactory.getLog(FetcherTestCase.class);
	private Configuration configuration;

	protected void setUp() throws Exception {
		super.setUp();
		configuration = Configuration.getInstance();
	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}

	protected FacebookJaxbRestClient getFacebookClient() {
		final String apiKey = configuration.getFaceBookApplicationKey();
		assertNotNull("apiKey", apiKey);
		final String secret = configuration.getFaceBookApplicationKey();
		assertNotNull("secret", secret);
		return new FacebookJaxbRestClient(apiKey, secret);
	}

	public void test_stream_getComments() throws FacebookException {
		String postId = configuration.getFaceBookPostId();
		log.debug("version: " + Constants.VERSION);
		log.debug("postId: " + Constants.FACEBOOK_POST_ID);

		assertNotNull("postId", postId);
		FacebookJaxbRestClient facebookClient = getFacebookClient();

		String authToken = facebookClient.auth_createToken();
		assertNotNull("authToken", authToken);
		String authSession = facebookClient.auth_getSession(authToken);
		assertNotNull("authSession", authSession);
		try {

			log.debug("facebookClient.stream_getComments(postId: " + postId + ")");
			StreamGetCommentsResponse streamGetCommentsResponse = facebookClient
					.stream_getComments(postId);
			assertNotNull("streamGetCommentsResponse",
					streamGetCommentsResponse);
		} finally {
			facebookClient.auth_expireSession();
		}
	}
}
