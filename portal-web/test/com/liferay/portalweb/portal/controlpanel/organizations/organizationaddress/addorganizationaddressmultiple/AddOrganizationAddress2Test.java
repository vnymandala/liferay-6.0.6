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

package com.liferay.portalweb.portal.controlpanel.organizations.organizationaddress.addorganizationaddressmultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddOrganizationAddress2Test extends BaseTestCase {
	public void testAddOrganizationAddress2() throws Exception {
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
				selenium.clickAt("addressesLink", RuntimeVariables.replace(""));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"//div[2]/div/span/span/button[1]")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.clickAt("//div[2]/div/span/span/button[1]",
					RuntimeVariables.replace("Add Row"));
				Thread.sleep(5000);
				selenium.type("_126_addressStreet1_2",
					RuntimeVariables.replace("12345 Selenium St"));
				selenium.type("_126_addressCity2",
					RuntimeVariables.replace("Diamond Bar"));
				selenium.type("_126_addressZip2",
					RuntimeVariables.replace("41111"));
				selenium.select("_126_addressCountryId2",
					RuntimeVariables.replace("label=United States"));
				Thread.sleep(5000);
				selenium.select("_126_addressRegionId2",
					RuntimeVariables.replace("label=California"));
				selenium.select("_126_addressTypeId2",
					RuntimeVariables.replace("label=Billing"));
				Thread.sleep(5000);
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("_126_addressStreet1_1")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals("12345 Selenium St",
					selenium.getValue("_126_addressStreet1_1"));
				assertEquals("Diamond Bar",
					selenium.getValue("_126_addressCity1"));
				assertEquals("41111", selenium.getValue("_126_addressZip1"));
				assertEquals("United States",
					selenium.getSelectedLabel("_126_addressCountryId1"));
				assertEquals("California",
					selenium.getSelectedLabel("_126_addressRegionId1"));
				assertEquals("Billing",
					selenium.getSelectedLabel("_126_addressTypeId1"));

			case 100:
				label = -1;
			}
		}
	}
}