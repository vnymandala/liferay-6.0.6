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

package com.liferay.portal.monitoring.statistics;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public class RequestStatistics implements Statistics {

	public RequestStatistics(String name) {
		_name = name;
		_errorStatistics = new CountStatistics(name);
		_successStatistics = new AverageStatistics(name);
		_timeoutStatistics = new CountStatistics(name);
	}

	public long getAverageTime() {
		return _successStatistics.getAverageTime();
	}

	public String getDescription() {
		return _description;
	}

	public long getErrorCount() {
		return _errorStatistics.getCount();
	}

	public long getMaxTime() {
		return _successStatistics.getMaxTime();
	}

	public long getMinTime() {
		return _successStatistics.getMinTime();
	}

	public String getName() {
		return _name;
	}

	public long getRequestCount() {
		return getErrorCount() + getSuccessCount() + getTimeoutCount();
	}

	public long getSuccessCount() {
		return _successStatistics.getCount();
	}

	public long getTimeoutCount() {
		return _timeoutStatistics.getCount();
	}

	public void incrementError() {
		_errorStatistics.incrementCount();
	}

	public void incrementSuccessDuration(long duration) {
		_successStatistics.addDuration(duration);
	}

	public void incrementTimeout() {
		_timeoutStatistics.incrementCount();
	}

	public void reset() {
		_errorStatistics.reset();
		_successStatistics.reset();
		_timeoutStatistics.reset();
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _description;
	private CountStatistics _errorStatistics;
	private String _name;
	private AverageStatistics _successStatistics;
	private CountStatistics _timeoutStatistics;

}