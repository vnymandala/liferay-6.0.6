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

package com.liferay.portalweb.plugins.kaleo.webcontent.wcwebcontent.addwebcontentscopecommunity;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class TearDownCommunityWorkflowConfigurationTest extends BaseTestCase {
	public void testTearDownCommunityWorkflowConfiguration()
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
		Thread.sleep(5000);
		selenium.clickAt("//div[1]/div/span/a",
			RuntimeVariables.replace("Scope Selector"));

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//li[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//li[1]/a", RuntimeVariables.replace("Community Name"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("Community Name")
										.equals(selenium.getText(
								"//div[1]/div/span/a"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Community Name"),
			selenium.getText("//div[1]/div/span/a"));
		selenium.clickAt("link=Workflow", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Default Configuration",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry",
			RuntimeVariables.replace("label=No workflow"));
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion",
			RuntimeVariables.replace("label=No workflow"));
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage",
			RuntimeVariables.replace("label=No workflow"));
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle",
			RuntimeVariables.replace("label=No workflow"));
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.documentlibrary.model.DLFileEntry",
			RuntimeVariables.replace("label=No workflow"));
		selenium.select("_151_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage",
			RuntimeVariables.replace("label=No workflow"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Workflow Configuration",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.blogs.model.BlogsEntry",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBDiscussion",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.messageboards.model.MBMessage",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.journal.model.JournalArticle",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.documentlibrary.model.DLFileEntry",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.select("_152_workflowDefinitionName@com.liferay.portlet.wiki.model.WikiPage",
			RuntimeVariables.replace("label=Default: No workflow"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
	}
}