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

package com.liferay.portalweb.portlet.bookmarks.entry.editfolderentry;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditFolderEntryTest extends BaseTestCase {
	public void testEditFolderEntry() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Bookmarks Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Bookmarks Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Test Folder Entry"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
		selenium.clickAt("//td[5]/ul/li/strong/a", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[1]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.type("_28_name",
			RuntimeVariables.replace("Test Folder Entry Edited"));
		selenium.type("_28_url",
			RuntimeVariables.replace("http://www.alloyui.com"));
		selenium.type("_28_comments",
			RuntimeVariables.replace("This is a test folder entry. Edited."));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div[1]"));
		assertEquals(RuntimeVariables.replace("Test Folder Entry Edited"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("http://www.alloyui.com"),
			selenium.getText("//td[2]/a"));
		assertNotEquals(RuntimeVariables.replace("Test Folder Entry"),
			selenium.getText("//td[1]/a"));
		assertNotEquals(RuntimeVariables.replace("http://www.liferay.com"),
			selenium.getText("//td[2]/a"));
	}
}