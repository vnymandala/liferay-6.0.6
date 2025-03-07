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

package com.liferay.portalweb.portal.dbupgrade.sampledata512.webcontent.imageassociation;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddStructureImageAssociationTest extends BaseTestCase {
	public void testAddStructureImageAssociation() throws Exception {
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
			RuntimeVariables.replace("Web Content Image Association Community"));
		selenium.clickAt("//input[@value='Search Communities']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//tr[@class='portlet-section-body results-row']/td[1]/a",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Journal Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Structures", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//input[@value='Add Structure']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_15_newStructureId",
			RuntimeVariables.replace("test_image"));
		selenium.type("_15_name",
			RuntimeVariables.replace("Image Structure Test"));
		selenium.type("_15_description",
			RuntimeVariables.replace("This is an image structure test."));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_15_structure_el0_name",
			RuntimeVariables.replace("image-gallery-test"));
		selenium.select("_15_structure_el0_type",
			RuntimeVariables.replace("label=Image Gallery"));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_15_structure_el0_name",
			RuntimeVariables.replace("image-test"));
		selenium.select("_15_structure_el0_type",
			RuntimeVariables.replace("label=Image"));
		selenium.clickAt("//input[@value='Add Row']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.select("_15_structure_el0_type",
			RuntimeVariables.replace("label=Text"));
		selenium.type("_15_structure_el0_name",
			RuntimeVariables.replace("text-test"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(
				"Your request processed successfully."));
		assertEquals(RuntimeVariables.replace("TEST_IMAGE"),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[2]"));
		assertEquals(RuntimeVariables.replace(
				"Image Structure Test\nThis is an image structure test."),
			selenium.getText(
				"//tr[@class='portlet-section-body results-row']/td[3]"));
	}
}