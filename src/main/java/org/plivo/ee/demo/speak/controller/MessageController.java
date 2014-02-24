package org.plivo.ee.demo.speak.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.cdi.extension.util.Account;
import org.plivo.ee.cdi.helper.Sender;
import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.inject.account.PlivoAccount;

@SessionScoped
@Named
public class MessageController implements Serializable {

	private static final long serialVersionUID = 1L;

	static String RESULT = "/messages/result.xhtml";

	private String message;
	private String dst;
	private String result;

	private static String URL = "http://plivo-twiliofaces1.rhcloud.com/demo-speak/message.jsf";

	@Inject
	@PlivoAccount
	Account account;

	@Inject
	@PlivoAccount(accountName = "default")
	Sender sender;

	public MessageController() {
		// TODO Auto-generated constructor stub
	}

	public String sendMessage() {

		// MessageRestAPI messageRestAPI = new MessageRestAPI(authId,
		// authToken);
		// Map<String, String> parameters = new HashMap<String, String>();
		// parameters.put("text", getMessage());
		// parameters.put("src", src);
		// parameters.put("dst", getDst());
		// parameters.put("url", URL);

		try {
			String messageUID = sender.url(URL).dst(getDst())
					.text(getMessage()).send();
			setResult(messageUID);
			System.out.println(messageUID);
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

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
