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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.tags.messageboards;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SearchTagsTest extends BaseTestCase {
	public void testSearchTags() throws Exception {
		selenium.open("/user/joebloggs/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Communities I Own")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Communities I Own", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_29_name",
			RuntimeVariables.replace("Tags Message Board Community"));
		selenium.clickAt("//input[@value='Search Communities']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium1"));
		selenium.clickAt("//input[@value='Search Messages']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium2"));
		selenium.clickAt("//input[@value='Search Messages']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium3"));
		selenium.clickAt("//input[@value='Search Messages']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=Message3 Tag3 Test3"));
		assertFalse(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertFalse(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertFalse(selenium.isElementPresent("link=MessageC TagC TestC"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Message Boards Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Message Boards Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_19_keywords1", RuntimeVariables.replace("selenium"));
		selenium.clickAt("//input[@value='Search Messages']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("link=MessageA TagA TestA"));
		assertTrue(selenium.isElementPresent("link=MessageB TagB TestB"));
		assertTrue(selenium.isElementPresent("link=MessageC TagC TestC"));
		assertFalse(selenium.isElementPresent("link=Message1 Tag1 Test1"));
		assertFalse(selenium.isElementPresent("link=Message2 Tag2 Test2"));
		assertFalse(selenium.isElementPresent("link=Message3 Tag3 Test3"));
	}
}