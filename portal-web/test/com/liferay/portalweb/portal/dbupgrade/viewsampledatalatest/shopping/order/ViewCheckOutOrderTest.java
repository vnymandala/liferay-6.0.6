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

package com.liferay.portalweb.portal.dbupgrade.viewsampledatalatest.shopping.order;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewCheckOutOrderTest extends BaseTestCase {
	public void testViewCheckOutOrder() throws Exception {
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
		selenium.clickAt("link=Communities", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.type("_134_name",
			RuntimeVariables.replace("Shopping Order Community"));
		selenium.clickAt("//input[@value='Search']",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Open"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Shopping Order Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Orders", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//td[2]/a", RuntimeVariables.replace("Order Number"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("//td[1]/table/tbody/tr[1]/td[2]"));
		assertEquals(RuntimeVariables.replace("Joe"),
			selenium.getText("//td[2]/table/tbody/tr[1]/td[2]"));
		assertEquals(RuntimeVariables.replace("Bloggs"),
			selenium.getText("//td[1]/table/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("Bloggs"),
			selenium.getText("//td[2]/table/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//td[1]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("test@liferay.com"),
			selenium.getText("//td[2]/table/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("1234 Sesame Street"),
			selenium.getText("//tr[5]/td[2]"));
		assertEquals(RuntimeVariables.replace("1234 Sesame Street"),
			selenium.getText("//td[2]/table/tbody/tr[5]/td[2]"));
		assertEquals(RuntimeVariables.replace("Gotham City:"),
			selenium.getText("//tr[6]/td[2]"));
		assertEquals(RuntimeVariables.replace("Gotham City:"),
			selenium.getText("//td[2]/table/tbody/tr[6]/td[2]"));
		assertEquals(RuntimeVariables.replace("CA"),
			selenium.getText("//tr[7]/td[2]"));
		assertEquals(RuntimeVariables.replace("CA"),
			selenium.getText("//td[2]/table/tbody/tr[7]/td[2]"));
		assertEquals(RuntimeVariables.replace("90028"),
			selenium.getText("//tr[8]/td[2]"));
		assertEquals(RuntimeVariables.replace("90028"),
			selenium.getText("//td[2]/table/tbody/tr[8]/td[2]"));
		assertEquals(RuntimeVariables.replace("USA"),
			selenium.getText("//tr[9]/td[2]"));
		assertEquals(RuntimeVariables.replace("USA"),
			selenium.getText("//td[2]/table/tbody/tr[9]/td[2]"));
		assertEquals(RuntimeVariables.replace("626-589-1453"),
			selenium.getText("//tr[10]/td[2]"));
		assertEquals(RuntimeVariables.replace("626-589-1453"),
			selenium.getText("//td[2]/table/tbody/tr[10]/td[2]"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//table[3]/tbody/tr[1]/td[2]"));
		assertEquals(RuntimeVariables.replace("Visa"),
			selenium.getText("//table[3]/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("exact:************1111"),
			selenium.getText("//table[3]/tbody/tr[3]/td[2]"));
		assertTrue(selenium.isPartialText("//form",
				"Please take care of my order."));
		assertEquals(RuntimeVariables.replace("$9.99"),
			selenium.getText("//table[4]/tbody/tr[1]/td[2]"));
		assertEquals(RuntimeVariables.replace("$0.00"),
			selenium.getText("//table[4]/tbody/tr[2]/td[2]"));
		assertEquals(RuntimeVariables.replace("$0.00"),
			selenium.getText("//table[4]/tbody/tr[3]/td[2]"));
		assertEquals(RuntimeVariables.replace("$9.99"),
			selenium.getText("//table[4]/tbody/tr[4]/td[2]"));
	}
}