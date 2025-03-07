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

package com.liferay.portalweb.portal.staging.controlpanel;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class CC_BlogsRolesTest extends BaseTestCase {
	public void testCC_BlogsRoles() throws Exception {
		selenium.clickAt("link=Define Permissions", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_128_add-permissions",
			RuntimeVariables.replace("label=Blogs"));
		selenium.waitForPageToLoad("30000");
		selenium.check(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogsADD_ENTRY']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryADD_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryDELETE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryDELETE_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryPERMISSIONS']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryUPDATE_DISCUSSION']");
		selenium.uncheck(
			"//input[@name='_128_rowIds' and @value='com.liferay.portlet.blogs.model.BlogsEntryVIEW']");
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("The role permissions were updated."));
	}
}