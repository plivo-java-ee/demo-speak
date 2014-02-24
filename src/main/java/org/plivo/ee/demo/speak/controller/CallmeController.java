package org.plivo.ee.demo.speak.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.cdi.extension.util.Account;
import org.plivo.ee.cdi.helper.Caller;
import org.plivo.ee.demo.speak.service.MessageService;
import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.inject.account.PlivoAccount;

@SessionScoped
@Named
public class CallmeController implements Serializable {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(getClass().getName());

	private static String RESULT = "/callme/result.xhtml?faces-redirect=true";
	private static String ANSWER_URL = "http://plivo-twiliofaces1.rhcloud.com/demo-speak/readMessage.jsf";
	private static String HANGUP_URL = "http://plivo-twiliofaces1.rhcloud.com/demo-speak/hangup.jsf";
	private static String FALLBACK_URL = "http://plivo-twiliofaces1.rhcloud.com/demo-speak/fallback.jsf";

	private String message;
	private String to;

	@Inject
	@PlivoAccount
	Account account;

	@Inject
	@PlivoAccount(accountName = "default")
	Caller caller;

	private String result;

	@Inject
	MessageService messageService;

	public CallmeController() {
	}

	public String callMe() {
		messageService.addMessage(getTo(), getMessage());

		// CallRestAPI callRestAPI = new CallRestAPI(account.getAuthId(),
		// account.getAuthToken());
		// Map<String, String> parameters = new HashMap<String, String>();
		// parameters.put("from", account.getNumber());
		// parameters.put("to", getNumber());
		// parameters
		// .put("answer_url",
		// "http://plivo-twiliofaces1.rhcloud.com/demo-speak/readMessage.jsf");
		// parameters.put("hangup_url",
		// "http://plivo-twiliofaces1.rhcloud.com/demo-speak/hangup.jsf");
		// parameters
		// .put("fallback_url",
		// "http://plivo-twiliofaces1.rhcloud.com/demo-speak/fallback.jsf");
		// try {
		// Call call = callRestAPI.makeCall(parameters);
		// if (call != null && call.getRequestUUID() != null)
		// setResult(call.getRequestUUID());
		// logger.info(call.getRequestUUID());
		// } catch (PlivoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		try {
			String requestUUID = caller.answerUrl(ANSWER_URL)
					.hangupUrl(HANGUP_URL).fallbackUrl(FALLBACK_URL)
					.to(getTo()).call();
			logger.info("requestUUID: " + requestUUID);
			setResult(requestUUID);
		} catch (PlivoException e) {
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

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
