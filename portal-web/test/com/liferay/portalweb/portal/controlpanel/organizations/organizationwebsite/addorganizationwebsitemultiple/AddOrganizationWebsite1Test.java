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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationwebsite.addorganizationwebsitemultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationWebsite1Test extends BaseTestCase {
	public void testAddOrganizationWebsite1() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:

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
				selenium.clickAt("link=Organizations",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");

				boolean basicVisible = selenium.isVisible("link=\u00ab Basic");

				if (!basicVisible) {
					label = 2;

					continue;
				}

				selenium.clickAt("link=\u00ab Basic",
					RuntimeVariables.replace(""));

			case 2:
				selenium.type("_126_keywords",
					RuntimeVariables.replace("Selenium"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Selenium"),
					selenium.getText("//td[2]/a"));
				selenium.clickAt("//td[2]/a", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("websitesLink", RuntimeVariables.replace(""));
				selenium.type("_126_websiteUrl0",
					RuntimeVariables.replace("http://www.liferay.com"));
				selenium.select("_126_websiteTypeId0",
					RuntimeVariables.replace("label=Public"));
				selenium.clickAt("_126_websitePrimary0",
					RuntimeVariables.replace(""));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertEquals("http://www.liferay.com",
					selenium.getValue("_126_websiteUrl0"));
				assertEquals("Public",
					selenium.getSelectedLabel("_126_websiteTypeId0"));
				assertTrue(selenium.isChecked("_126_websitePrimary0"));

			case 100:
				label = -1;
			}
		}
	}
}