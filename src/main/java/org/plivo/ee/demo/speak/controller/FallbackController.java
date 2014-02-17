/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.demo.speak.controller;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.plivo.ee.inject.notification.BillRate;
import org.plivo.ee.inject.notification.CallStatus;
import org.plivo.ee.inject.notification.CallUUID;
import org.plivo.ee.inject.notification.CallerName;
import org.plivo.ee.inject.notification.Direction;
import org.plivo.ee.inject.notification.Event;
import org.plivo.ee.inject.notification.From;
import org.plivo.ee.inject.notification.To;

@Named
@RequestScoped
public class FallbackController {

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

	public FallbackController() {
	}

	public void log() {
		logger.info(toString());

	}

	@Override
	public String toString() {
		return "FallbackController ["
				+ (callStatus != null ? "callStatus=" + callStatus + ", " : "")
				+ (callerName != null ? "callerName=" + callerName + ", " : "")
				+ (event != null ? "event=" + event + ", " : "")
				+ (callUUID != null ? "callUUID=" + callUUID + ", " : "")
				+ (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "")
				+ (billRate != null ? "billRate=" + billRate : "") + "]";
	}

}
