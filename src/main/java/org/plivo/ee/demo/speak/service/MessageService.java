package org.plivo.ee.demo.speak.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageService {

	private Map<String, String> messagges;

	public Map<String, String> getMessagges() {
		if (messagges == null)
			this.messagges = new HashMap<String, String>();
		return messagges;
	}

	public void addMessage(String number, String message) {
		getMessagges().put(number, message);
	}

	public String getMessage(String number) {
		if (getMessagges().containsKey(number))
			return getMessagges().get(number);
		return "Non ti trovo. Non ho nulla per te...";
	}

	public void setMessagges(Map<String, String> messagges) {
		this.messagges = messagges;
	}
}
