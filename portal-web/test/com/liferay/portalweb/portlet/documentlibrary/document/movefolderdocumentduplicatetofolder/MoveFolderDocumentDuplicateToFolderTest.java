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

package com.liferay.portalweb.portlet.documentlibrary.document.movefolderdocumentduplicatetofolder;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveFolderDocumentDuplicateToFolderTest extends BaseTestCase {
	public void testMoveFolderDocumentDuplicateToFolder()
		throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Document Library Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Document Library Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[4]/td[1]/a[2]/strong",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Test1 Document1 This is test1 document1."));
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Document Library Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Document Library Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a/strong", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Test1 Document1 This is test1 document1."));
		selenium.clickAt("//td[5]/ul/li/strong/a", RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent(
							"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Move"),
			selenium.getText(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.click(RuntimeVariables.replace(
				"//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a"));
		selenium.waitForPageToLoad("30000");
		selenium.click("//input[@value='Select']");
		selenium.waitForPopUp("folder", RuntimeVariables.replace("30000"));
		selenium.selectWindow("name=folder");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Documents Home")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Documents Home", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.click("//tr[4]/td[4]/input");
		selenium.selectWindow("null");
		assertEquals(RuntimeVariables.replace("Test2 Folder2"),
			selenium.getText("_20_folderName"));
		selenium.clickAt("//input[@value='Move']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent(
							"You have entered invalid data. Please try again.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isTextPresent(
				"You have entered invalid data. Please try again."));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isTextPresent(
							"Please enter a unique document name.")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isTextPresent(
				"Please enter a unique document name."));
	}
}