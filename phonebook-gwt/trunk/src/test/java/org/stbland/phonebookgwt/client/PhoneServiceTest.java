package org.stbland.phonebookgwt.client;

import org.stbland.phonebookgwt.bean.PhoneDto;
import org.stbland.phonebookgwt.client.service.PhoneService;
import org.stbland.phonebookgwt.client.service.PhoneServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * GWT JUnit tests must extend GWTTestCase.
 */
public class PhoneServiceTest extends AbstractPhonebookTestcase {

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testFindPhone() {
		// Create the service that we will test.
		PhoneServiceAsync phoneService = GWT.create(PhoneService.class);
		ServiceDefTarget target = (ServiceDefTarget) phoneService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL() + "telephone/phone");

		// Since RPC calls are asynchronous, we will need to wait for a response
		// after this test method returns. This line tells the test runner to
		// wait
		// up to 10 seconds before timing out.
		delayTestFinish(10000);

		// Send a request to the server.
		phoneService.findPhone("St�phane BEAUFORT",
				new AsyncCallback<PhoneDto>() {
					public void onFailure(Throwable caught) {
						// The request resulted in an unexpected error.
						fail("Request failure: " + caught.getMessage());
					}

					public void onSuccess(PhoneDto phone) {
						// Verify that the response is correct.
						assertTrue(phone.getPoste().equals("5116"));

						// Now that we have received a response, we need to tell
						// the test runner
						// that the test is complete. You must call finishTest()
						// after an
						// asynchronous test finishes successfully, or the test
						// will time out.
						finishTest();
					}
				});
	}

}
