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

package com.liferay.portal.monitoring.jmx;

import com.liferay.portal.monitoring.MonitoringException;
import com.liferay.portal.monitoring.statistics.portlet.PortletSummaryStatistics;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface PortletManagerMBean extends PortletSummaryStatistics {

	public long[] getCompanyIds() throws MonitoringException;

	public String[] getPortletIds() throws MonitoringException;

	public String[] getWebIds() throws MonitoringException;

	public void reset();

	public void reset(long companyId);

	public void reset(String webId);

}