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

package com.liferay.portalweb.plugins.kaleo.myworkflowtasks.workflowtask.assigntomewebcontentassigneduser;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class UserSN_SignInTest extends BaseTestCase {
	public void testUserSN_SignIn() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Sign In")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Sign In", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_58_login",
			RuntimeVariables.replace("useremail@liferay.com"));
		selenium.type("_58_password", RuntimeVariables.replace("test"));
		selenium.clickAt("_58_rememberMeCheckbox", RuntimeVariables.replace(""));
		selenium.clickAt("//input[@value='Sign In']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='I Agree']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("reminderQueryAnswer", RuntimeVariables.replace("test"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
	}
}