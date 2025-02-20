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

package com.liferay.portalweb.properties.mailintegration.messageboards.replymessageemail;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditPortalInstanceMailDomainTest extends BaseTestCase {
	public void testEditPortalInstanceMailDomain() throws Exception {
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

		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Instances", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("localhost"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("191"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[4]/a", RuntimeVariables.replace("liferay.com"));
		selenium.waitForPageToLoad("30000");
		selenium.type("_135_mx", RuntimeVariables.replace("gmail.com"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText("//section/div/div/div/div"));
		assertEquals(RuntimeVariables.replace("1"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("liferay.com"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("localhost"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("gmail.com"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("191"),
			selenium.getText("//td[5]/a"));
	}
}