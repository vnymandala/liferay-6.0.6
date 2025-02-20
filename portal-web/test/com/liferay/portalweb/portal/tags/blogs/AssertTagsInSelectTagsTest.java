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

package com.liferay.portalweb.portal.tags.blogs;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertTagsInSelectTagsTest extends BaseTestCase {
	public void testAssertTagsInSelectTags() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Blogs Tags Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Blogs Tags Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Tags1 Blogs1 Test1 Entry1",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Edit", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("select", RuntimeVariables.replace(""));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("selenium1 liferay1"),
			selenium.getText("//label[1]"));
		assertTrue(selenium.isElementPresent("//label[1]/input"));
		assertEquals(RuntimeVariables.replace("selenium2 liferay2"),
			selenium.getText("//label[2]"));
		assertTrue(selenium.isElementPresent("//label[2]/input"));
		assertEquals(RuntimeVariables.replace("selenium3 liferay3"),
			selenium.getText("//label[3]"));
		assertTrue(selenium.isElementPresent("//label[3]/input"));
		assertEquals(RuntimeVariables.replace("selenium4 liferay4"),
			selenium.getText("//label[4]"));
		assertTrue(selenium.isElementPresent("//label[4]/input"));
		selenium.clickAt("closethick", RuntimeVariables.replace(""));
		selenium.clickAt("_33_cancelButton", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
	}
}