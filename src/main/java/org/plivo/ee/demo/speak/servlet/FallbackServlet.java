/*
 * Copyright 2014 plivo-java-ee.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.plivo.ee.demo.speak.servlet;

import javax.servlet.annotation.WebServlet;

import org.plivo.ee.helper.exception.PlivoException;
import org.plivo.ee.helper.xml.elements.PlivoResponse;
import org.plivo.ee.web.servlet.XmlServlet;

@WebServlet(urlPatterns = { "/FallbackServlet", "/fallback" })
public class FallbackServlet extends XmlServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public PlivoResponse getPlivoResponse() throws PlivoException {
		return null;
	}

	@Override
	public boolean isLogParameters() {
		return true;
	}
}
