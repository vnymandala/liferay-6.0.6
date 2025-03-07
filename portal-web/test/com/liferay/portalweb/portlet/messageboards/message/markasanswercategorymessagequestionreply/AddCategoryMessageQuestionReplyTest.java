/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.messageboards.message.markasanswercategorymessagequestionreply;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCategoryMessageQuestionReplyTest extends BaseTestCase {
	public void testAddCategoryMessageQuestionReply() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=M\u00e9ssag\u00e9 Boards T\u00e9st Pag\u00e9",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[1]/a", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//li[2]/span/a/span", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_19_textArea",
			RuntimeVariables.replace("This is an answer."));
		selenium.clickAt("//input[@value='Publish']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"T\u00e9st M\u00e9ssag\u00e9 Question"),
			selenium.getText("//div[1]/h1/span"));
		assertEquals(RuntimeVariables.replace(
				"RE: T\u00e9st M\u00e9ssag\u00e9 Question"),
			selenium.getText("//a/strong"));
		assertEquals(RuntimeVariables.replace(
				"RE: T\u00e9st M\u00e9ssag\u00e9 Question"),
			selenium.getText(
				"//div[5]/table/tbody/tr[1]/td[2]/div[1]/div/a/strong"));
		assertEquals(RuntimeVariables.replace("Mark as an Answer"),
			selenium.getText(
				"//div[5]/table/tbody/tr[1]/td[2]/div[1]/ul/li[1]/span/a/span"));
		assertEquals(RuntimeVariables.replace("This is an answer."),
			selenium.getText("//div[5]/table/tbody/tr[1]/td[2]/div[2]"));
	}
}