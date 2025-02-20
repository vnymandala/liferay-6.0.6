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

package com.liferay.portalweb.portlet.documentlibrary.portlet.configureportletdocumentsperpage1;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class ConfigurePortletDocumentsPerPage1Tests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddPageDLTest.class);
		testSuite.addTestSuite(AddPortletDLTest.class);
		testSuite.addTestSuite(AddFolderTest.class);
		testSuite.addTestSuite(AddFolderDocument1Test.class);
		testSuite.addTestSuite(AddFolderDocument2Test.class);
		testSuite.addTestSuite(AddFolderDocument3Test.class);
		testSuite.addTestSuite(ConfigurePortletDocumentsPerPage20Test.class);
		testSuite.addTestSuite(ConfigurePortletDocumentsPerPage1Test.class);
		testSuite.addTestSuite(TearDownDLFolderTest.class);
		testSuite.addTestSuite(TearDownDocumentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);

		return testSuite;
	}

}