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

package com.liferay.portalweb.plugins.kaleo.myworkflowtasks.workflowtask.viewwebcontenttaskactivitiescompleted;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentTaskActivitiesCompletedTest extends BaseTestCase {
	public void testViewWebContentTaskActivitiesCompleted()
		throws Exception {
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
		selenium.clickAt("link=My Workflow Tasks", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[2]/div[1]/div/span",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Portal Content Reviewer role."),
			selenium.getText("//div[2]/div[2]/div[1]/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[2]/div[2]/div[1]/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[2]/div[2]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[2]/div[3]/div[2]"));
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
		selenium.clickAt("link=My Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[2]/div[1]/div",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Portal Content Reviewer role."),
			selenium.getText("//div[2]/div[2]/div[1]/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[2]/div[2]/div[1]/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[2]/div[2]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[2]/div[3]/div[2]"));
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
		selenium.clickAt("link=Workflow", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/div[3]/div[1]/div",
			RuntimeVariables.replace("Activities"));
		assertEquals(RuntimeVariables.replace(
				"Task initially assigned to the Portal Content Reviewer role."),
			selenium.getText("//div[3]/div[2]/div/div[2]"));
		assertEquals(RuntimeVariables.replace("Assigned initial task."),
			selenium.getText("//div[3]/div[2]/div/div[3]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText("//div[3]/div[2]/div[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs completed the task Review."),
			selenium.getText("//div[3]/div[2]/div[3]/div[2]"));
	}
}