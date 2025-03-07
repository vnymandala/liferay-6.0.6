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

package com.liferay.util.bridges.mvc;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Michael C. Han
 */
public class ActionCommandCache {

	public static final String ACTION_PACKAGE_NAME = "action.package.prefix";

	public static final ActionCommand EMPTY = new ActionCommand() {

		public boolean processCommand(
			PortletRequest portletRequest, PortletResponse portletResponse) {

			return false;
		}

	};

	public ActionCommandCache(String packagePrefix) {
		if (!packagePrefix.endsWith(StringPool.PERIOD)) {
			packagePrefix = packagePrefix + StringPool.PERIOD;
		}

		_packagePrefix = packagePrefix;
	}

	public ActionCommand getActionCommand(String actionCommandName) {
		String className = null;

		try {
			ActionCommand actionCommand = _actionCommandCache.get(
				actionCommandName);

			if (actionCommand == null) {
				StringBundler sb = new StringBundler(4);

				sb.append(_packagePrefix);
				sb.append(Character.toUpperCase(actionCommandName.charAt(0)));
				sb.append(
					actionCommandName.substring(1, actionCommandName.length()));
				sb.append(_ACTION_COMMAND_POSTFIX);

				className = sb.toString();

				actionCommand =
					(ActionCommand)Class.forName(className).newInstance();

				_actionCommandCache.put(actionCommandName, actionCommand);
			}

			return actionCommand;
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to instantiate ActionCommand " + className);
			}

			_actionCommandCache.put(actionCommandName, EMPTY);

			return EMPTY;
		}
	}

	public List<ActionCommand> getActionCommandChain(
		String actionCommandChain) {

		List<ActionCommand> actionCommands = _actionCommandChainCache.get(
			actionCommandChain);

		if (actionCommands == null) {
			actionCommands = new ArrayList<ActionCommand>();

			int nextSeparator = actionCommandChain.indexOf(CharPool.COMMA);

			int currentIndex = 0;

			while (currentIndex < actionCommandChain.length()) {
				String parsedName = actionCommandChain.substring(
					currentIndex, nextSeparator);

				ActionCommand actionCommand = getActionCommand(
					parsedName);

				if (actionCommand != EMPTY) {
					actionCommands.add(actionCommand);
				}
				else {
					if (_log.isWarnEnabled()) {
						_log.warn(
							"Unable to find ActionCommand " +
								actionCommandChain);
					}
				}

				currentIndex = nextSeparator + 1;

				nextSeparator = actionCommandChain.indexOf(
					CharPool.COMMA, currentIndex);

				if (nextSeparator == -1) {
					break;
				}
			}

			_actionCommandChainCache.put(actionCommandChain, actionCommands);
		}

		return actionCommands;
	}

	public boolean isEmpty() {
		return _actionCommandCache.isEmpty();
	}

	private static final String _ACTION_COMMAND_POSTFIX = "ActionCommand";

	private static Log _log = LogFactoryUtil.getLog(ActionCommandCache.class);

	private Map<String, ActionCommand> _actionCommandCache =
		new ConcurrentHashMap<String, ActionCommand>();
	private Map<String, List<ActionCommand>> _actionCommandChainCache =
		new ConcurrentHashMap<String, List<ActionCommand>>();
	private String _packagePrefix;

}