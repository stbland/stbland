package org.stbland.test.facebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookJaxbRestClient;
import com.google.code.facebookapi.FacebookXmlRestClient;
import com.google.code.facebookapi.IFacebookRestClient;
import com.google.code.facebookapi.ProfileField;
import com.google.code.facebookapi.schema.User;
import com.google.code.facebookapi.schema.UsersGetInfoResponse;

public class Fetcher {

	private static Logger logger = Logger.getLogger(Fetcher.class);

	private IFacebookRestClient client;
	private FacebookXmlRestClient xmlClient;

	private User loggedUser = null;
	public static EnumSet<ProfileField> fields = EnumSet
			.allOf(ProfileField.class);

	private Configuration propertiesManager;
	private boolean isConnected = false;
	private String session;
	private Configuration configuration;

	public Fetcher() {
		super();
		configuration = Configuration.getInstance();
	}

	public boolean connect(String login, String password) throws HttpException,
			IOException, FacebookException {

		logger.debug("Connexion en cours");
		client = new FacebookJaxbRestClient(
				configuration.getFaceBookApplicationKey(),
				configuration.getFaceBookApplicationSecret());
		String token = client.auth_createToken();
		logger.debug("token=" + token);

		HttpClient http = new HttpClient();
		http.setParams(new HttpClientParams());
		http.setState(new HttpState());

		GetMethod get = new GetMethod(Constants.FACEBOOK_LOGIN_BASE_URL
				+ "?api_key=" + configuration.getFaceBookApplicationKey()
				+ "&v=1.0&auth_token=" + token);

		http.executeMethod(get);

		PostMethod post = new PostMethod(Constants.FACEBOOK_LOGIN_BASE_URL);
		post.addParameter(new NameValuePair("api_key", configuration
				.getFaceBookApplicationKey()));
		post.addParameter(new NameValuePair("v", "1.0"));
		post.addParameter(new NameValuePair("auth_token", token));
		post.addParameter(new NameValuePair("email", login));
		post.addParameter(new NameValuePair("pass", password));

		http.executeMethod(post);

		// fetch session key
		session = client.auth_getSession(token);

		// Client pour le chat
		xmlClient = new FacebookXmlRestClient(
				configuration.getFaceBookApplicationKey(),
				configuration.getFaceBookApplicationSecret(), session);

		logger.debug("Session key is " + session);

		isConnected = true;
		logger.debug("Connexion en cours : " + isConnected);

		return isConnected;
	}

	public boolean connectByBrowser() throws HttpException, IOException,
			FacebookException, InterruptedException {
		String auth;
		logger.debug("Connexion a faceboook");
		if (isConnected == false) {
			logger.debug("Pas encore connecte, connexion en cours");

			logger.debug("initialisation du client");
			client = new FacebookJaxbRestClient(
					configuration.getFaceBookApplicationKey(),
					configuration.getFaceBookApplicationSecret());
			auth = client.auth_createToken();
			logger.debug("Token OK " + auth);
			logger.debug("Lancement du browser");
			Process p = Runtime.getRuntime().exec(
					configuration.getBrowserPath() + " "
							+ Constants.FACEBOOK_LOGIN_BASE_URL + "?api_key="
							+ configuration.getFaceBookApplicationKey()
							+ "&auth_token=" + auth);
			p.waitFor();
			logger.debug("Browser ferme");
			session = client.auth_getSession(auth);

			// initialisation du client pour le chat'
			xmlClient = new FacebookXmlRestClient(
					configuration.getFaceBookApplicationKey(),
					configuration.getFaceBookApplicationSecret(), session);
			logger.debug("Initialisation du client terminé secret="
					+ configuration.getFaceBookApplicationSecret()
					+ " session=" + session);
			isConnected = true;
		}
		return isConnected;

	}

	public IFacebookRestClient getClient() {
		return client;
	}

	public User getLoggedUser() throws FacebookException, IOException {

		if (loggedUser != null)
			return loggedUser;

		long id = client.users_getLoggedInUser();
		logger.info("LoggedInUser=" + id );
		Collection<Long> users = new ArrayList<Long>();
		users.add(id);

		client.users_getInfo(users, fields);
		UsersGetInfoResponse u = (UsersGetInfoResponse) client.users_getInfo(
				users, fields);
		loggedUser = u.getUser().get(0);
		return loggedUser;
	}
}
