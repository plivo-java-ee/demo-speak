package org.plivo.ee.demo.speak.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.demo.speak.service.MessageService;
import org.plivo.ee.helper.api.client.simple.CallRestAPI;
import org.plivo.ee.helper.api.response.call.Call;
import org.plivo.ee.helper.exception.PlivoException;

@SessionScoped
@Named
public class CallmeController implements Serializable {

	private static final long serialVersionUID = 1L;

	static String RESULT = "/callme/result.xhtml?faces-redirect=true";

	private String message;
	private String number;

	private String authId = "MAOWE0YJUZYMQZNDBLNW";
	private String authToken = "YmUyNTU1YjhmZWQ1NmQxNGVjODkwMzBhNWUzOGYw";
	private String src = "3905221520065";
	private String result;

	@Inject
	MessageService messageService;

	public CallmeController() {
	}

	public String callMe() {
		messageService.addMessage(getNumber(), getMessage());

		CallRestAPI callRestAPI = new CallRestAPI(authId, authToken);
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("from", src);
		parameters.put("to", getNumber());
		parameters
				.put("answer_url",
						"http://plivo-twiliofaces1.rhcloud.com/demo-speak/readMessage.jsf");
		try {
			Call call = callRestAPI.makeCall(parameters);
			if (call != null && call.getRequestUUID() != null)
				setResult(call.getRequestUUID());
			System.out.println(call.getRequestUUID());
		} catch (PlivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return RESULT;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
