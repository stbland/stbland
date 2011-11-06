package org.stbland.test.facebook;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJaxbRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
import com.google.code.facebookapi.schema.StreamGetCommentsResponse;
import com.google.code.facebookapi.schema.User;

public class FetcherTestCase extends TestCase {

	protected static Log log = LogFactory.getLog(FetcherTestCase.class);
	private Configuration configuration;
	private Fetcher fetcher;

	protected void setUp() throws Exception {
		super.setUp();
		configuration = Configuration.getInstance();
		fetcher = new Fetcher();

	}

	protected void tearDown() throws Exception {
		super.tearDown();

	}

	public void _testConnect() throws HttpException, IOException,
			FacebookException {
		boolean isConnected = fetcher.connect(
				configuration.getFacebookUserLogin(),
				configuration.getFacebookUserPassword());
		assertTrue(isConnected);
	}

	protected void doConnecWithoutBrowsert() throws HttpException, IOException,
			FacebookException {
		boolean isConnected = fetcher.connect(
				configuration.getFacebookUserLogin(),
				configuration.getFacebookUserPassword());
		assertTrue(isConnected);
	}

	protected void doConnecWithBrowsert() throws HttpException, IOException,
			FacebookException, InterruptedException {
		boolean isConnected = fetcher.connectByBrowser();
		assertTrue(isConnected);
	}

	public void _testGetLoggerUser() throws HttpException, IOException,
			FacebookException, InterruptedException {
		doConnecWithoutBrowsert();
		// doConnecWithBrowsert();
		User user = fetcher.getLoggedUser();
		log.info("user.name=" + user.getName());
		log.info("user.uid=" + user.getUid());
		assertTrue("users_isAppUser()", fetcher.getClient().users_isAppUser());
		assertTrue("users_isAppUser(uid)",
				fetcher.getClient().users_isAppUser(user.getUid()));

	}

	public void testGetClient_stream_getComments() throws HttpException,
			IOException, FacebookException, InterruptedException {
		// doConnecWithoutBrowsert();
		doConnecWithBrowsert();

		String postId;

		postId = fetcher.getLoggedUser().getUid() + "_"
				+ configuration.getFaceBookPostId();
		postId = configuration.getFaceBookPostId();

		IFacebookRestClient client = fetcher.getClient();
		if (false) {
			List<String> apiList = (List<String>) client
					.permissions_checkGrantedApiAccess(configuration
							.getFaceBookApplicationKey());
			log.info("apiList.size: " + apiList.size());
		}
		// client.beginPermissionsMode(configuration.getFaceBookApplicationKey());
		// client.permissions_grantApiAccess(configuration.getFaceBookApplicationKey(),
		// methods);
		try {
			StreamGetCommentsResponse streamGetCommentsResponse = (StreamGetCommentsResponse) client
					.stream_getComments(postId);
			assertNotNull("streamGetCommentsResponse",
					streamGetCommentsResponse);
			log.info("streamGetCommentsResponse.comment.size: "
					+ streamGetCommentsResponse.getComment().size());
			assertTrue("streamGetCommentsResponse.comment.size > 0 ",
					streamGetCommentsResponse.getComment().size() > 0);
		} finally {
			// client.endPermissionsMode();
		}
	}

	protected FacebookJaxbRestClient getFacebookClient() {
		final String apiKey = configuration.getFaceBookApplicationKey();
		assertNotNull("apiKey", apiKey);
		final String secret = configuration.getFaceBookApplicationKey();
		assertNotNull("secret", secret);
		return new FacebookJaxbRestClient(apiKey, secret);
	}

	public void _test_stream_getComments() throws FacebookException {
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

			log.debug("facebookClient.stream_getComments(postId: " + postId
					+ ")");
			StreamGetCommentsResponse streamGetCommentsResponse = facebookClient
					.stream_getComments(postId);
			assertNotNull("streamGetCommentsResponse",
					streamGetCommentsResponse);
		} finally {
			facebookClient.auth_expireSession();
		}
	}
}
