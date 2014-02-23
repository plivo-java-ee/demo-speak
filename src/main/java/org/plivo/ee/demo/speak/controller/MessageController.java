package org.plivo.ee.demo.speak.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.plivo.ee.helper.api.client.simple.MessageRestAPI;
import org.plivo.ee.helper.api.response.message.MessageResponse;
import org.plivo.ee.helper.exception.PlivoException;

@SessionScoped
@Named
public class MessageController implements Serializable {

	private static final long serialVersionUID = 1L;

	static String RESULT = "/messages/result.xhtml";

	private String message;
	private String number;

	private String authId = "MAOWE0YJUZYMQZNDBLNW";
	private String authToken = "YmUyNTU1YjhmZWQ1NmQxNGVjODkwMzBhNWUzOGYw";
	private String src = "3905221520065";
	private String result;

	public MessageController() {
		// TODO Auto-generated constructor stub
	}

	public String sendMessage() {

		MessageRestAPI messageRestAPI = new MessageRestAPI(authId, authToken);
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("text", getMessage());
		parameters.put("src", src);
		parameters.put("dst", getNumber());
		parameters.put("url",
				"http://plivo-twiliofaces1.rhcloud.com/demo-speak/message.jsf");
		try {
			MessageResponse messagUID = messageRestAPI.sendMessage(parameters);
			if (messagUID != null && messagUID.getMessageUuids() != null
					&& messagUID.getMessageUuids().size() > 0)
				setResult(messagUID.getMessageUuids().get(0));
			System.out.println(messagUID.getMessageUuids());
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
