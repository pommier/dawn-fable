/*
 * Copyright (c) 2012 European Synchrotron Radiation Facility,
 *                    Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.eclipse.ui.examples.rcp.texteditor.editors.xml;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;



public class XMLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String XML_DEFAULT = "__xml_default"; //$NON-NLS-1$
	public final static String XML_COMMENT = "__xml_comment"; //$NON-NLS-1$
	public final static String XML_TAG = "__xml_tag"; //$NON-NLS-1$

	public XMLPartitionScanner() {

		IToken xmlComment = new Token(XML_COMMENT);
		IToken tag = new Token(XML_TAG);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new MultiLineRule("<!--", "-->", xmlComment);  //$NON-NLS-1$//$NON-NLS-2$
		rules[1] = new TagRule(tag);

		setPredicateRules(rules);
	}
}
