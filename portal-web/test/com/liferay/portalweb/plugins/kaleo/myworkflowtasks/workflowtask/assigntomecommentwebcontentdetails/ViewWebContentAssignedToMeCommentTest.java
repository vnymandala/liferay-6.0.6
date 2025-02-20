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

package com.liferay.portalweb.plugins.kaleo.myworkflowtasks.workflowtask.assigntomecommentwebcontentdetails;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWebContentAssignedToMeCommentTest extends BaseTestCase {
	public void testViewWebContentAssignedToMeComment()
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
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//td[3]/a"));
		assertTrue(selenium.isElementPresent("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[5]/a"));
		assertEquals(RuntimeVariables.replace(
				"There are no pending tasks assigned to your roles."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"//div[@class='lfr-panel-container task-panel-container']/div[2]/div/div/span"));
		selenium.clickAt("//div[@class='lfr-panel-container task-panel-container']/div[2]/div/div/span",
			RuntimeVariables.replace("Activities"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Comment Assign To Me"),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[3]"));
		selenium.clickAt("_153_TabsBack", RuntimeVariables.replace("Back"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("There are no completed tasks."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.click(RuntimeVariables.replace("link=My Submissions"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[6]/a"));
		assertEquals(RuntimeVariables.replace("Withdraw Submission"),
			selenium.getText("//span/a/span"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"//div[@class='lfr-panel-container task-panel-container']/div[3]/div/div/span"));
		selenium.clickAt("//div[@class='lfr-panel-container task-panel-container']/div[3]/div/div/span",
			RuntimeVariables.replace("Activities"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Comment Assign To Me"),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[3]"));
		selenium.clickAt("_158_TabsBack", RuntimeVariables.replace("Back"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no completed publications requested by me."),
			selenium.getText("//div[@class='portlet-msg-info']"));
		selenium.clickAt("link=Web Content", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("1.0"),
			selenium.getText("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Pending"),
			selenium.getText("//td[5]/a"));
		assertTrue(selenium.isElementPresent("//td[6]/a"));
		assertTrue(selenium.isElementPresent("//td[7]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[8]/a"));
		selenium.clickAt("link=Workflow", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Pending", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Single Approver"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Web Content"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Review"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		assertEquals(RuntimeVariables.replace("Never"),
			selenium.getText("//td[6]/a"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("Web Content Name"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Activities"),
			selenium.getText(
				"//div[@class='lfr-panel-container task-panel-container']/div[3]/div/div/span"));
		selenium.clickAt("//div[@class='lfr-panel-container task-panel-container']/div[3]/div/div/span",
			RuntimeVariables.replace("Activities"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Joe Bloggs assigned the task to himself."),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[2]"));
		assertEquals(RuntimeVariables.replace(
				"Web Content Comment Assign To Me"),
			selenium.getText(
				"xPath=(//div[@class='task-activity task-type-1'])[2]/div[3]"));
		selenium.clickAt("_151_TabsBack", RuntimeVariables.replace("Back"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Submissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Completed", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"There are no completed publication requests."),
			selenium.getText("//div[@class='portlet-msg-info']"));
	}
}