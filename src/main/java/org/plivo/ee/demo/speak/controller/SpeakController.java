/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.demo.speak.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.demo.speak.service.MessageService;
import org.plivo.ee.inject.context.CallScoped;
import org.plivo.ee.inject.notification.BillRate;
import org.plivo.ee.inject.notification.CallStatus;
import org.plivo.ee.inject.notification.CallUUID;
import org.plivo.ee.inject.notification.CallerName;
import org.plivo.ee.inject.notification.Digits;
import org.plivo.ee.inject.notification.Direction;
import org.plivo.ee.inject.notification.Event;
import org.plivo.ee.inject.notification.From;
import org.plivo.ee.inject.notification.RecordUrl;
import org.plivo.ee.inject.notification.RecordingDuration;
import org.plivo.ee.inject.notification.To;

@Named
@CallScoped
public class SpeakController implements Serializable {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(getClass().getName());

	@Inject
	@CallStatus
	private String callStatus;

	@Inject
	@CallerName
	private String callerName;

	@Inject
	@Event
	private String event;

	@Inject
	@CallUUID
	private String callUUID;

	@Inject
	@From
	private String from;

	@Inject
	@To
	private String to;

	@Inject
	@Direction
	private String direction;

	@Inject
	@BillRate
	private String billRate;

	@Inject
	@Digits
	private String digit;

	@Inject
	@RecordUrl
	private Instance<String> recordUrl;

	@Inject
	@RecordingDuration
	private Instance<String> recordingDuration;

	@Inject
	MessageService messageService;

	public SpeakController() {
	}

	public void log() {
		logger.info(toString());
	}

	public String getMessage() {
		return messageService.getMessage(to);
	}

	public boolean isSaved() {
		if (recordUrl != null && recordUrl.get() != null
				&& !recordUrl.get().isEmpty()) {
			logger.info("recording url: " + recordUrl + " - duration: "
					+ recordingDuration);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "SpeakController ["
				+ (callStatus != null ? "callStatus=" + callStatus + ", " : "")
				+ (callerName != null ? "callerName=" + callerName + ", " : "")
				+ (event != null ? "event=" + event + ", " : "")
				+ (callUUID != null ? "callUUID=" + callUUID + ", " : "")
				+ (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "")
				+ (billRate != null ? "billRate=" + billRate + ", " : "")
				+ (digit != null ? "digit=" + digit + ", " : "")
				+ (recordUrl != null ? "recordUrl=" + recordUrl + ", " : "")
				+ (recordingDuration != null ? "recordingDuration="
						+ recordingDuration : "") + "]";
	}

}
