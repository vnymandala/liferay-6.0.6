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

package com.liferay.portalweb.portlet.wikidisplay.wikipage.compareversioneditwikifrontpageminorchange;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class EditWikiFrontPageMinorChangeTest extends BaseTestCase {
	public void testEditWikiFrontPageMinorChange() throws Exception {
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
						if (selenium.isElementPresent(
									"link=Wiki Display Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace(
						"link=Wiki Display Test Page"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"This is a wiki frontpage article test."),
					selenium.getText("//div[5]/div"));
				selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.type("//textarea",
					RuntimeVariables.replace(
						"This is an edited wiki frontpage article test. Minor edit."));

				boolean minorEditChecked = selenium.isChecked("//span/input[2]");

				if (minorEditChecked) {
					label = 2;

					continue;
				}

				selenium.click("//span/input[2]");

			case 2:
				selenium.clickAt("//input[@value='Publish']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"Your request processed successfully."),
					selenium.getText("//section/div/div/div/div[1]"));
				assertTrue(selenium.isPartialText("//div[@class='wiki-body']",
						"Minor edit."));
				selenium.open("/web/guest/home/");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent(
									"link=Wiki Display Test Page")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace(
						"link=Wiki Display Test Page"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Details", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=History", RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isElementPresent("link=1.2 (Minor Edit)"));
				assertTrue(selenium.isElementPresent("link=1.1"));
				assertTrue(selenium.isElementPresent("link=1.0 (Minor Edit)"));

			case 100:
				label = -1;
			}
		}
	}
}