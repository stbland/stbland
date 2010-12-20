package org.stbland.phonebookgwt.client;

import java.util.AbstractList;

import org.stbland.phonebookgwt.bean.PersonDto;
import org.stbland.phonebookgwt.client.service.PersonService;
import org.stbland.phonebookgwt.client.service.PersonServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class PersonServiceTest extends AbstractPhonebookTestcase {

	private PersonServiceAsync getPersonService() {
		// Create the service that we will test.
		PersonServiceAsync personService = GWT.create(PersonService.class);
		ServiceDefTarget target = (ServiceDefTarget) personService;
		target.setServiceEntryPoint(GWT.getModuleBaseURL() + "telephone/person");

		// Since RPC calls are asynchronous, we will need to wait for a response
		// after this test method returns. This line tells the test runner to
		// wait
		// up to 10 seconds before timing out.
		delayTestFinish(10000);

		return personService;
	}

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testFind() {

		PersonServiceAsync personService = getPersonService();

		AsyncCallback<PersonDto> personCallback = new AsyncCallback<PersonDto>() {

			public void onSuccess(PersonDto person) {
				assertEquals("ANTOINE", person.getLastName());
				finishTest();

			}

			public void onFailure(Throwable caught) {
				fail("Request failure: " + caught.getMessage());
			}
		};

		personService.find("Christophe", "ANTOINE", personCallback);
	}

	/**
	 * This test will send a request to the server using the greetServer method
	 * in GreetingService and verify the response.
	 */
	public void testFindAll() {

		PersonServiceAsync personService = getPersonService();

		AsyncCallback<AbstractList<PersonDto>> callback = new AsyncCallback<AbstractList<PersonDto>>() {

			public void onSuccess(AbstractList<PersonDto> results) {
				assertTrue(results.size() > 0);
				finishTest();
			}

			public void onFailure(Throwable caught) {
				fail("Request failure: " + caught.getMessage());

			}
		};

		personService.findAll(callback);
	}

}
