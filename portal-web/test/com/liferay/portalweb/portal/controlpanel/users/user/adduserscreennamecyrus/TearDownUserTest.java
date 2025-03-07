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

package com.liferay.portalweb.portal.controlpanel.users.user.adduserscreennamecyrus;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownUserTest extends BaseTestCase {
	public void testTearDownUser() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/web/guest/home/");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Control Panel")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Users", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				boolean basic1Visible = selenium.isVisible("link=\u00ab Basic");

				if (!basic1Visible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 2:
				selenium.type("_125_keywords",
					RuntimeVariables.replace("selenium"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				boolean user1Deactivated = selenium.isElementPresent(
						"_125_rowIds");

				if (!user1Deactivated) {
					label = 3;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 3:

				boolean user2Deactivated = selenium.isElementPresent(
						"_125_rowIds");

				if (!user2Deactivated) {
					label = 4;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 4:

				boolean user3Deactivated = selenium.isElementPresent(
						"_125_rowIds");

				if (!user3Deactivated) {
					label = 5;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 5:

				boolean user4Deactivated = selenium.isElementPresent(
						"_125_rowIds");

				if (!user4Deactivated) {
					label = 6;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 6:

				boolean user5Deactivated = selenium.isElementPresent(
						"_125_rowIds");

				if (!user5Deactivated) {
					label = 7;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Deactivate']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to deactivate the selected users[\\s\\S]$"));

			case 7:
				selenium.clickAt("link=Advanced \u00bb",
					RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("_125_active")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.select("_125_active",
					RuntimeVariables.replace("label=No"));
				selenium.clickAt("//div[2]/span[2]/span/input",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				boolean user1Deleted = selenium.isElementPresent("_125_rowIds");

				if (!user1Deleted) {
					label = 8;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 8:

				boolean user2Deleted = selenium.isElementPresent("_125_rowIds");

				if (!user2Deleted) {
					label = 9;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 9:

				boolean user3Deleted = selenium.isElementPresent("_125_rowIds");

				if (!user3Deleted) {
					label = 10;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 10:

				boolean user4Deleted = selenium.isElementPresent("_125_rowIds");

				if (!user4Deleted) {
					label = 11;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 11:

				boolean user5Deleted = selenium.isElementPresent("_125_rowIds");

				if (!user5Deleted) {
					label = 12;

					continue;
				}

				selenium.clickAt("_125_rowIds", RuntimeVariables.replace(""));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Delete']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.getConfirmation()
								   .matches("^Are you sure you want to permanently delete the selected users[\\s\\S]$"));

			case 12:
				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 100:
				label = -1;
			}
		}
	}
}