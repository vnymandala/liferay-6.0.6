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

package com.liferay.portalweb.portlet.blogs.entry.editentrytitle;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditEntryTitleTest extends BaseTestCase {
	public void testEditEntryTitle() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Blogs Test Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("Title"),
			selenium.getText("//div[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace("Content."),
			selenium.getText("//div[@class='entry-body']/p"));
		selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_33_title", RuntimeVariables.replace("TitleEdit"));
		Thread.sleep(5000);
		selenium.clickAt("_33_publishButton", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent(
							"Your request processed successfully.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("TitleEdit"),
			selenium.getText("//div[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace("Content."),
			selenium.getText("//div[@class='entry-body']/p"));
	}
}