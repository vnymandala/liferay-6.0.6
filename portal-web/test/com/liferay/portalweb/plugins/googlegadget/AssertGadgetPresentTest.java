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

package com.liferay.portalweb.plugins.googlegadget;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AssertGadgetPresentTest extends BaseTestCase {
	public void testAssertGadgetPresent() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Google Gadget Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.click(RuntimeVariables.replace("link=Google Gadget Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"Euro US Dollar Pound Sterling Argentine Peso Australian Dollar Bahrain Dinar Bangladeshi Taka Botswana Pula Brazilian Real British Pound Brunei Dollar Bulgarian Lev Canadian Dollar Chilean Peso Chinese Yuan Renminbi Colombian Peso Croatian Kuna Cyprus Pound Czech Koruna Danish Krone East Caribbean Dollar Egyptian Pound Estonian Kroon Euro Hong Kong Dollar Hungarian Forint Icelandic Krona Indian Rupee Indonesian Rupiah Iranian Rial Israeli Sheqel Jamaican Dollar Japanese Yen South Korean Won Kuwaiti Dinar Latvian Lats Libyan Dinar Lithuanian Litas Malaysian Ringgit Maldives Rufiyaa Maltese Lira Mauritian Rupee Mexican Peso Nepalese Rupee New Romanian Leu New Taiwan Dollar New Turkish Lira New Zealand Dollar Norwegian Krone Omani Rial Pakistan Rupee Peruvian Nuevo Sol Philippine Peso Polish Zloty Qatar Riyal Romanian Leu (new) Russian Rouble Saudi Arabian Riyal Singapore Dollar Slovak Koruna Slovenian Tolar South African Rand Sri Lanka Rupee Swedish Krona Swiss Franc Taiwan Dollar Taiwan Dollar (new) Thai Baht Trinidad And Tobago Dollar Turkish Lira (New) UAE Dirham Ukrainian Hrivna US Dollar Venezuelan Bolivar Gold (ounce) Platinum (ounce) Silver (ounce) Aluminium (ounce)"),
			selenium.getText("from"));
		assertEquals(RuntimeVariables.replace(
				"Euro US Dollar Pound Sterling Argentine Peso Australian Dollar Bahrain Dinar Bangladeshi Taka Botswana Pula Brazilian Real British Pound Brunei Dollar Bulgarian Lev Canadian Dollar Chilean Peso Chinese Yuan Renminbi Colombian Peso Croatian Kuna Cyprus Pound Czech Koruna Danish Krone East Caribbean Dollar Egyptian Pound Estonian Kroon Euro Hong Kong Dollar Hungarian Forint Icelandic Krona Indian Rupee Indonesian Rupiah Iranian Rial Israeli Sheqel Jamaican Dollar Japanese Yen South Korean Won Kuwaiti Dinar Latvian Lats Libyan Dinar Lithuanian Litas Malaysian Ringgit Maldives Rufiyaa Maltese Lira Mauritian Rupee Mexican Peso Nepalese Rupee New Romanian Leu New Taiwan Dollar New Turkish Lira New Zealand Dollar Norwegian Krone Omani Rial Pakistan Rupee Peruvian Nuevo Sol Philippine Peso Polish Zloty Qatar Riyal Romanian Leu (new) Russian Rouble Saudi Arabian Riyal Singapore Dollar Slovak Koruna Slovenian Tolar South African Rand Sri Lanka Rupee Swedish Krona Swiss Franc Taiwan Dollar Taiwan Dollar (new) Thai Baht Trinidad And Tobago Dollar Turkish Lira (New) UAE Dirham Ukrainian Hrivna US Dollar Venezuelan Bolivar Gold (ounce) Platinum (ounce) Silver (ounce) Aluminium (ounce)"),
			selenium.getText("to"));
		assertTrue(selenium.isElementPresent("value"));
		assertTrue(selenium.isElementPresent("result"));
	}
}