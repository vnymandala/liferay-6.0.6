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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.expando.webform;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SendForm1Test extends BaseTestCase {
	public void testSendForm1() throws Exception {
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
			RuntimeVariables.replace("Expando Web Form Community"));
		selenium.clickAt("//input[@value='Search Communities']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Web Form Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("//input[@type='text']", RuntimeVariables.replace("Hashi"));
		selenium.clickAt("//input[@type='checkbox']",
			RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Male']", RuntimeVariables.replace(""));
		selenium.select("//select", RuntimeVariables.replace("label=Poor"));
		selenium.type("//textarea",
			RuntimeVariables.replace("This is a comment. Hashi."));
		selenium.clickAt("//input[@value='Send']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertTrue(selenium.isTextPresent(
				"The form information was sent successfully."));
	}
}