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

import org.plivo.ee.inject.notification.AnswerTime;
import org.plivo.ee.inject.notification.BillDuration;
import org.plivo.ee.inject.notification.BillRate;
import org.plivo.ee.inject.notification.CallStatus;
import org.plivo.ee.inject.notification.CallUUID;
import org.plivo.ee.inject.notification.CallerName;
import org.plivo.ee.inject.notification.Direction;
import org.plivo.ee.inject.notification.Duration;
import org.plivo.ee.inject.notification.EndTime;
import org.plivo.ee.inject.notification.Event;
import org.plivo.ee.inject.notification.From;
import org.plivo.ee.inject.notification.HangupCause;
import org.plivo.ee.inject.notification.StartTime;
import org.plivo.ee.inject.notification.To;
import org.plivo.ee.inject.notification.TotalCost;

@Named
@RequestScoped
public class HangupController {

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
	@TotalCost
	private String totalCost;

	@Inject
	@AnswerTime
	private String answerTime;

	@Inject
	@HangupCause
	private String hangupCause;

	@Inject
	@Duration
	private String duration;

	@Inject
	@BillDuration
	private String billDuration;

	@Inject
	@EndTime
	private String endTime;

	@Inject
	@StartTime
	private String startTime;

	public HangupController() {
	}

	public void log() {
		logger.info(toString());

	}

	@Override
	public String toString() {
		return "HangupController ["
				+ (callStatus != null ? "callStatus=" + callStatus + ", " : "")
				+ (callerName != null ? "callerName=" + callerName + ", " : "")
				+ (event != null ? "event=" + event + ", " : "")
				+ (callUUID != null ? "callUUID=" + callUUID + ", " : "")
				+ (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "")
				+ (direction != null ? "direction=" + direction + ", " : "")
				+ (billRate != null ? "billRate=" + billRate + ", " : "")
				+ (totalCost != null ? "totalCost=" + totalCost + ", " : "")
				+ (answerTime != null ? "answerTime=" + answerTime + ", " : "")
				+ (hangupCause != null ? "hangupCause=" + hangupCause + ", "
						: "")
				+ (duration != null ? "duration=" + duration + ", " : "")
				+ (billDuration != null ? "billDuration=" + billDuration + ", "
						: "")
				+ (endTime != null ? "endTime=" + endTime + ", " : "")
				+ (startTime != null ? "startTime=" + startTime : "") + "]";
	}

}
