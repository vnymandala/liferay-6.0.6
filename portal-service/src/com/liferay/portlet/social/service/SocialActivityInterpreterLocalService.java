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

package com.liferay.portlet.social.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the social activity interpreter local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SocialActivityInterpreterLocalServiceUtil} to access the social activity interpreter local service. Add custom service methods to {@link com.liferay.portlet.social.service.impl.SocialActivityInterpreterLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityInterpreterLocalServiceUtil
 * @see com.liferay.portlet.social.service.base.SocialActivityInterpreterLocalServiceBaseImpl
 * @see com.liferay.portlet.social.service.impl.SocialActivityInterpreterLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SocialActivityInterpreterLocalService {
	public void addActivityInterpreter(
		com.liferay.portlet.social.model.SocialActivityInterpreter activityInterpreter);

	public void deleteActivityInterpreter(
		com.liferay.portlet.social.model.SocialActivityInterpreter activityInterpreter);

	public com.liferay.portlet.social.model.SocialActivityFeedEntry interpret(
		com.liferay.portlet.social.model.SocialActivity activity,
		com.liferay.portal.theme.ThemeDisplay themeDisplay);
}