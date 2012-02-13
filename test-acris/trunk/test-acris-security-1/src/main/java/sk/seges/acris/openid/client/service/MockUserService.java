package sk.seges.acris.openid.client.service;

import sk.seges.acris.security.shared.exception.SecurityException;
import sk.seges.acris.security.shared.exception.ServerException;
import sk.seges.acris.security.shared.session.ClientSession;
import sk.seges.acris.security.shared.user_management.domain.OpenIDLoginToken;
import sk.seges.acris.security.shared.user_management.domain.UserPasswordLoginToken;
import sk.seges.acris.security.shared.user_management.domain.api.LoginToken;
import sk.seges.acris.security.shared.user_management.domain.api.UserData;
import sk.seges.acris.security.shared.user_management.service.IUserServiceAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RpcRequestBuilder;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class MockUserService implements IUserServiceAsync, ServiceDefTarget {

	@Override
	public void authenticate(LoginToken token, AsyncCallback<String> callback)
			throws ServerException {
		if (token instanceof OpenIDLoginToken) {
			callback.onSuccess("test");
		} else if (token instanceof UserPasswordLoginToken
				&& ((UserPasswordLoginToken) token).getUsername()
						.equals("test")) {
			callback.onSuccess("test");
		} else {
			callback.onFailure(new SecurityException("Unsupported login token"));
		}
	}

	@Override
	public void login(LoginToken token, AsyncCallback<ClientSession> callback)
			throws ServerException {
		if (token instanceof OpenIDLoginToken) {
			ClientSession session = new ClientSession();
			session.setSessionId("test");
			callback.onSuccess(session);
		} else if (token instanceof UserPasswordLoginToken
				&& ((UserPasswordLoginToken) token).getUsername()
						.equals("test")) {
			ClientSession session = new ClientSession();
			session.setSessionId("test");
			callback.onSuccess(session);
		} else {
			callback.onFailure(new SecurityException("Unsupported login token"));
		}
	}

	@Override
	public String getServiceEntryPoint() {
		return "/user";
	}

	@Override
	public String getSerializationPolicyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRpcRequestBuilder(RpcRequestBuilder builder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServiceEntryPoint(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(AsyncCallback<Void> callback) throws ServerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLoggedUser(String webId, AsyncCallback<UserData<?>> callback)
			throws ServerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLoggedUserName(AsyncCallback<String> callback)
			throws ServerException {
		// TODO Auto-generated method stub
		
	}

}
