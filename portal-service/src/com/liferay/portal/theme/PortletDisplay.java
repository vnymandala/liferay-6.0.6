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

package com.liferay.portal.theme;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

import javax.portlet.PortletPreferences;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
public class PortletDisplay implements Serializable {

	public PortletDisplay() {
		if (_log.isDebugEnabled()) {
			_log.debug("Creating new instance " + hashCode());
		}
	}

	public ThemeDisplay getThemeDisplay() {
		return _themeDisplay;
	}

	public void setThemeDisplay(ThemeDisplay themeDisplay) {
		_themeDisplay = themeDisplay;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getRootPortletId() {
		return _rootPortletId;
	}

	public void setRootPortletId(String rootPortletId) {
		_rootPortletId = rootPortletId;
	}

	public String getInstanceId() {
		return _instanceId;
	}

	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;
	}

	public String getResourcePK() {
		return _resourcePK;
	}

	public void setResourcePK(String resourcePK) {
		_resourcePK = resourcePK;
	}

	public String getPortletName() {
		return _portletName;
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
	}

	public String getNamespace() {
		return _namespace;
	}

	public void setNamespace(String namespace) {
		_namespace = namespace;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		title = HtmlUtil.escape(title);

		_title = title;

		// LEP-5317

		if (Validator.isNull(_id)) {
			setId(_themeDisplay.getTilesTitle());
		}
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		description = HtmlUtil.escape(description);

		_description = description;
	}

	public String getCustomCSSClassName() {
		return _customCSSClassName;
	}

	public void setCustomCSSClassName(String customCSSClassName) {
		_customCSSClassName = customCSSClassName;
	}

	public boolean isAccess() {
		return _access;
	}

	public void setAccess(boolean access) {
		_access = access;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public String getColumnId() {
		return _columnId;
	}

	public void setColumnId(String columnId) {
		_columnId = columnId;
	}

	public int getColumnPos() {
		return _columnPos;
	}

	public void setColumnPos(int columnPos) {
		_columnPos = columnPos;
	}

	public int getColumnCount() {
		return _columnCount;
	}

	public void setColumnCount(int columnCount) {
		_columnCount = columnCount;
	}

	public boolean isStateExclusive() {
		return _stateExclusive;
	}

	public void setStateExclusive(boolean stateExclusive) {
		_stateExclusive = stateExclusive;
	}

	public boolean isStateMax() {
		return _stateMax;
	}

	public void setStateMax(boolean stateMax) {
		_stateMax = stateMax;
	}

	public boolean isStateMin() {
		return _stateMin;
	}

	public void setStateMin(boolean stateMin) {
		_stateMin = stateMin;
	}

	public boolean isStateNormal() {
		return _stateNormal;
	}

	public void setStateNormal(boolean stateNormal) {
		_stateNormal = stateNormal;
	}

	public boolean isStatePopUp() {
		return _statePopUp;
	}

	public void setStatePopUp(boolean statePopUp) {
		_statePopUp = statePopUp;
	}

	public boolean isModeAbout() {
		return _modeAbout;
	}

	public void setModeAbout(boolean modeAbout) {
		_modeAbout = modeAbout;
	}

	public boolean isModeConfig() {
		return _modeConfig;
	}

	public void setModeConfig(boolean modeConfig) {
		_modeConfig = modeConfig;
	}

	public boolean isModeEdit() {
		return _modeEdit;
	}

	public void setModeEdit(boolean modeEdit) {
		_modeEdit = modeEdit;
	}

	public boolean isModeEditDefaults() {
		return _modeEditDefaults;
	}

	public void setModeEditDefaults(boolean modeEditDefaults) {
		_modeEditDefaults = modeEditDefaults;
	}

	public boolean isModeEditGuest() {
		return _modeEditGuest;
	}

	public void setModeEditGuest(boolean modeEditGuest) {
		_modeEditGuest = modeEditGuest;
	}

	public boolean isModeHelp() {
		return _modeHelp;
	}

	public void setModeHelp(boolean modeHelp) {
		_modeHelp = modeHelp;
	}

	public boolean isModePreview() {
		return _modePreview;
	}

	public void setModePreview(boolean modePreview) {
		_modePreview = modePreview;
	}

	public boolean isModePrint() {
		return _modePrint;
	}

	public void setModePrint(boolean modePrint) {
		_modePrint = modePrint;
	}

	public boolean isShowBackIcon() {
		return _showBackIcon;
	}

	public void setShowBackIcon(boolean showBackIcon) {
		_showBackIcon = showBackIcon;
	}

	public boolean isShowCloseIcon() {
		return _showCloseIcon;
	}

	public void setShowCloseIcon(boolean showCloseIcon) {
		_showCloseIcon = showCloseIcon;
	}

	public boolean isShowConfigurationIcon() {
		return _showConfigurationIcon;
	}

	public void setShowConfigurationIcon(boolean showConfigurationIcon) {
		_showConfigurationIcon = showConfigurationIcon;
	}

	public boolean isShowEditIcon() {
		return _showEditIcon;
	}

	public void setShowEditIcon(boolean showEditIcon) {
		_showEditIcon = showEditIcon;
	}

	public boolean isShowEditDefaultsIcon() {
		return _showEditDefaultsIcon;
	}

	public void setShowEditDefaultsIcon(boolean showEditDefaultsIcon) {
		_showEditDefaultsIcon = showEditDefaultsIcon;
	}

	public boolean isShowEditGuestIcon() {
		return _showEditGuestIcon;
	}

	public void setShowEditGuestIcon(boolean showEditGuestIcon) {
		_showEditGuestIcon = showEditGuestIcon;
	}

	public boolean isShowExportImportIcon() {
		return _showExportImportIcon;
	}

	public void setShowExportImportIcon(boolean showExportImportIcon) {
		_showExportImportIcon = showExportImportIcon;
	}

	public boolean isShowHelpIcon() {
		return _showHelpIcon;
	}

	public void setShowHelpIcon(boolean showHelpIcon) {
		_showHelpIcon = showHelpIcon;
	}

	public boolean isShowMaxIcon() {
		return _showMaxIcon;
	}

	public void setShowMaxIcon(boolean showMaxIcon) {
		_showMaxIcon = showMaxIcon;
	}

	public boolean isShowMinIcon() {
		return _showMinIcon;
	}

	public void setShowMinIcon(boolean showMinIcon) {
		_showMinIcon = showMinIcon;
	}

	public boolean isShowMoveIcon() {
		return _showMoveIcon;
	}

	public void setShowMoveIcon(boolean showMoveIcon) {
		_showMoveIcon = showMoveIcon;
	}

	public boolean isShowPortletCssIcon() {
		return _showPortletCssIcon;
	}

	public void setShowPortletCssIcon(boolean showPortletCssIcon) {
		_showPortletCssIcon = showPortletCssIcon;
	}

	public boolean isShowPortletIcon() {
		return _showPortletIcon;
	}

	public void setShowPortletIcon(boolean showPortletIcon) {
		_showPortletIcon = showPortletIcon;
	}

	public boolean isShowPrintIcon() {
		return _showPrintIcon;
	}

	public void setShowPrintIcon(boolean showPrintIcon) {
		_showPrintIcon = showPrintIcon;
	}

	public boolean isShowRefreshIcon() {
		return _showRefreshIcon;
	}

	public void setShowRefreshIcon(boolean showRefreshIcon) {
		_showRefreshIcon = showRefreshIcon;
	}

	public String getURLBack() {
		return _urlBack;
	}

	public void setURLBack(String urlBack) {
		_urlBack = urlBack;
	}

	public String getURLClose() {
		return _urlClose;
	}

	public void setURLClose(String urlClose) {
		_urlClose = urlClose;
	}

	public String getURLConfiguration() {
		return _urlConfiguration;
	}

	public void setURLConfiguration(String urlConfiguration) {
		_urlConfiguration = urlConfiguration;
	}

	public String getURLEdit() {
		return _urlEdit;
	}

	public void setURLEdit(String urlEdit) {
		_urlEdit = urlEdit;
	}

	public String getURLEditDefaults() {
		return _urlEditDefaults;
	}

	public void setURLEditDefaults(String urlEditDefaults) {
		_urlEditDefaults = urlEditDefaults;
	}

	public String getURLEditGuest() {
		return _urlEditGuest;
	}

	public void setURLEditGuest(String urlEditGuest) {
		_urlEditGuest = urlEditGuest;
	}

	public String getURLExportImport() {
		return _urlExportImport;
	}

	public void setURLExportImport(String urlExportImport) {
		_urlExportImport = urlExportImport;
	}

	public String getURLHelp() {
		return _urlHelp;
	}

	public void setURLHelp(String urlHelp) {
		_urlHelp = urlHelp;
	}

	public String getURLMax() {
		return _urlMax;
	}

	public void setURLMax(String urlMax) {
		_urlMax = urlMax;
	}

	public String getURLMin() {
		return _urlMin;
	}

	public void setURLMin(String urlMin) {
		_urlMin = urlMin;
	}

	public String getURLPortlet() {
		return _urlPortlet;
	}

	public void setURLPortlet(String urlPortlet) {
		_urlPortlet = urlPortlet;
	}

	public String getURLPortletCss() {
		return _urlPortletCss;
	}

	public void setURLPortletCss(String urlPortletCss) {
		_urlPortletCss = urlPortletCss;
	}

	public String getURLPrint() {
		return _urlPrint;
	}

	public void setURLPrint(String urlPrint) {
		_urlPrint = urlPrint;
	}

	public String getURLRefresh() {
		return _urlRefresh;
	}

	public void setURLRefresh(String urlRefresh) {
		_urlRefresh = urlRefresh;
	}

	public boolean isWebDAVEnabled() {
		return _webDAVEnabled;
	}

	public void setWebDAVEnabled(boolean webDAVEnabled) {
		_webDAVEnabled = webDAVEnabled;
	}

	public boolean isRestoreCurrentView() {
		return _restoreCurrentView;
	}

	public void setRestoreCurrentView(boolean restoreCurrentView) {
		_restoreCurrentView = restoreCurrentView;
	}

	public StringBundler getContent() {
		return _content;
	}

	public void setContent(StringBundler content) {
		if (content == null) {
			_content = _blankStringBundler;
		}
		else {
			_content = content;
		}
	}

	public void writeContent(Writer writer) throws IOException {
		_content.writeTo(writer);
	}

	public PortletPreferences getPortletSetup() {
		return _portletSetup;
	}

	public void setPortletSetup(PortletPreferences portletSetup) {
		_portletSetup = portletSetup;
	}

	public void recycle() {
		if (_log.isDebugEnabled()) {
			_log.debug("Recycling instance " + hashCode());
		}

		_id = StringPool.BLANK;
		_rootPortletId = StringPool.BLANK;
		_instanceId = StringPool.BLANK;
		_resourcePK = StringPool.BLANK;
		_portletName = StringPool.BLANK;
		_namespace = StringPool.BLANK;
		_title = StringPool.BLANK;
		_description = StringPool.BLANK;
		_customCSSClassName = StringPool.BLANK;
		_access = false;
		_active = false;
		_columnId = StringPool.BLANK;
		_stateExclusive = false;
		_stateMax = false;
		_stateMin = false;
		_stateNormal = false;
		_statePopUp = false;
		_modeAbout = false;
		_modeConfig = false;
		_modeEdit = false;
		_modeEditDefaults = false;
		_modeEditGuest = false;
		_modeHelp = false;
		_modePreview = false;
		_modePrint = false;
		_showBackIcon = false;
		_showCloseIcon = false;
		_showConfigurationIcon = false;
		_showEditIcon = false;
		_showEditDefaultsIcon = false;
		_showEditGuestIcon = false;
		_showHelpIcon = false;
		_showMaxIcon = false;
		_showMinIcon = false;
		_showMoveIcon = false;
		_showPortletCssIcon = false;
		_showPortletIcon = false;
		_showPrintIcon = false;
		_showRefreshIcon = false;
		_urlBack = StringPool.BLANK;
		_urlClose = StringPool.BLANK;
		_urlConfiguration = StringPool.BLANK;
		_urlEdit = StringPool.BLANK;
		_urlEditDefaults = StringPool.BLANK;
		_urlEditGuest = StringPool.BLANK;
		_urlExportImport = StringPool.BLANK;
		_urlHelp = StringPool.BLANK;
		_urlMax = StringPool.BLANK;
		_urlMin = StringPool.BLANK;
		_urlPortlet = StringPool.BLANK;
		_urlPortletCss = StringPool.BLANK;
		_urlPrint = StringPool.BLANK;
		_urlRefresh = StringPool.BLANK;
		_webDAVEnabled = false;
		_restoreCurrentView = false;
		_content.setIndex(0);
		_portletSetup = null;
	}

	public void copyFrom(PortletDisplay master) {
		_themeDisplay = master.getThemeDisplay();
		_id = master.getId();
		_rootPortletId = master.getRootPortletId();
		_instanceId = master.getInstanceId();
		_resourcePK = master.getResourcePK();
		_portletName = master.getPortletName();
		_namespace = master.getNamespace();
		_title = master.getTitle();
		_description = master.getDescription();
		_customCSSClassName = master.getCustomCSSClassName();
		_access = master.isAccess();
		_active = master.isActive();
		_columnId = master.getColumnId();
		_stateExclusive = master.isStateExclusive();
		_stateMax = master.isStateMax();
		_stateMin = master.isStateMin();
		_stateNormal = master.isStateNormal();
		_statePopUp = master.isStatePopUp();
		_modeAbout = master.isModeAbout();
		_modeConfig = master.isModeConfig();
		_modeEdit = master.isModeEdit();
		_modeEditDefaults = master.isModeEditDefaults();
		_modeEditGuest = master.isModeEditGuest();
		_modeHelp = master.isModeHelp();
		_modePreview = master.isModePreview();
		_modePrint = master.isModePrint();
		_showBackIcon = master.isShowBackIcon();
		_showCloseIcon = master.isShowCloseIcon();
		_showConfigurationIcon = master.isShowConfigurationIcon();
		_showEditIcon = master.isShowEditIcon();
		_showEditDefaultsIcon = master.isShowEditDefaultsIcon();
		_showEditGuestIcon = master.isShowEditGuestIcon();
		_showHelpIcon = master.isShowHelpIcon();
		_showMaxIcon = master.isShowMaxIcon();
		_showMinIcon = master.isShowMinIcon();
		_showMoveIcon = master.isShowMoveIcon();
		_showPortletCssIcon = master.isShowPortletCssIcon();
		_showPortletIcon = master.isShowPortletIcon();
		_showPrintIcon = master.isShowPrintIcon();
		_showRefreshIcon = master.isShowRefreshIcon();
		_urlBack = master.getURLBack();
		_urlClose = master.getURLClose();
		_urlConfiguration = master.getURLConfiguration();
		_urlEdit = master.getURLEdit();
		_urlEditDefaults = master.getURLEditDefaults();
		_urlExportImport = master.getURLExportImport();
		_urlHelp = master.getURLHelp();
		_urlMax = master.getURLMax();
		_urlMin = master.getURLMin();
		_urlPortlet = master.getURLPortlet();
		_urlPortletCss = master.getURLPortletCss();
		_urlPrint = master.getURLPrint();
		_urlRefresh = master.getURLRefresh();
		_webDAVEnabled = master.isWebDAVEnabled();
		_restoreCurrentView = master.isRestoreCurrentView();
		_content = master.getContent();
		_portletSetup = master.getPortletSetup();
	}

	public void copyTo(PortletDisplay slave) {
		slave.setThemeDisplay(_themeDisplay);
		slave.setId(_id);
		slave.setRootPortletId(_rootPortletId);
		slave.setInstanceId(_instanceId);
		slave.setResourcePK(_resourcePK);
		slave.setPortletName(_portletName);
		slave.setNamespace(_namespace);
		slave.setTitle(_title);
		slave.setDescription(_description);
		slave.setCustomCSSClassName(_customCSSClassName);
		slave.setAccess(_access);
		slave.setActive(_active);
		slave.setColumnId(_columnId);
		slave.setStateExclusive(_stateExclusive);
		slave.setStateMax(_stateMax);
		slave.setStateMin(_stateMin);
		slave.setStateNormal(_stateNormal);
		slave.setStatePopUp(_statePopUp);
		slave.setModeAbout(_modeAbout);
		slave.setModeConfig(_modeConfig);
		slave.setModeEdit(_modeEdit);
		slave.setModeEditDefaults(_modeEditDefaults);
		slave.setModeEditGuest(_modeEditGuest);
		slave.setModeHelp(_modeHelp);
		slave.setModePreview(_modePreview);
		slave.setModePrint(_modePrint);
		slave.setShowBackIcon(_showBackIcon);
		slave.setShowCloseIcon(_showCloseIcon);
		slave.setShowConfigurationIcon(_showConfigurationIcon);
		slave.setShowEditIcon(_showEditIcon);
		slave.setShowEditDefaultsIcon(_showEditDefaultsIcon);
		slave.setShowEditGuestIcon(_showEditGuestIcon);
		slave.setShowHelpIcon(_showHelpIcon);
		slave.setShowMaxIcon(_showMaxIcon);
		slave.setShowMinIcon(_showMinIcon);
		slave.setShowMoveIcon(_showMoveIcon);
		slave.setShowPortletCssIcon(_showPortletCssIcon);
		slave.setShowPortletIcon(_showPortletIcon);
		slave.setShowPrintIcon(_showPrintIcon);
		slave.setShowRefreshIcon(_showRefreshIcon);
		slave.setURLBack(_urlBack);
		slave.setURLClose(_urlClose);
		slave.setURLConfiguration(_urlConfiguration);
		slave.setURLEdit(_urlEdit);
		slave.setURLEditDefaults(_urlEditDefaults);
		slave.setURLEditGuest(_urlEditGuest);
		slave.setURLExportImport(_urlExportImport);
		slave.setURLHelp(_urlHelp);
		slave.setURLMax(_urlMax);
		slave.setURLMin(_urlMin);
		slave.setURLPortlet(_urlPortlet);
		slave.setURLPortletCss(_urlPortletCss);
		slave.setURLPrint(_urlPrint);
		slave.setURLRefresh(_urlRefresh);
		slave.setWebDAVEnabled(_webDAVEnabled);
		slave.setRestoreCurrentView(_restoreCurrentView);
		slave.setContent(_content);
		slave.setPortletSetup(_portletSetup);
	}

	private static Log _log = LogFactoryUtil.getLog(PortletDisplay.class);

	private static StringBundler _blankStringBundler = new StringBundler(
		StringPool.BLANK);

	private ThemeDisplay _themeDisplay;
	private String _id = StringPool.BLANK;
	private String _rootPortletId = StringPool.BLANK;
	private String _instanceId = StringPool.BLANK;
	private String _resourcePK = StringPool.BLANK;
	private String _portletName = StringPool.BLANK;
	private String _namespace = StringPool.BLANK;
	private String _title = StringPool.BLANK;
	private String _description = StringPool.BLANK;
	private String _customCSSClassName = StringPool.BLANK;
	private boolean _access;
	private boolean _active;
	private String _columnId = StringPool.BLANK;
	private int _columnPos;
	private int _columnCount;
	private boolean _stateExclusive;
	private boolean _stateMax;
	private boolean _stateMin;
	private boolean _stateNormal;
	private boolean _statePopUp;
	private boolean _modeAbout;
	private boolean _modeConfig;
	private boolean _modeEdit;
	private boolean _modeEditDefaults;
	private boolean _modeEditGuest;
	private boolean _modeHelp;
	private boolean _modePreview;
	private boolean _modePrint;
	private boolean _showBackIcon;
	private boolean _showCloseIcon;
	private boolean _showConfigurationIcon;
	private boolean _showEditIcon;
	private boolean _showEditDefaultsIcon;
	private boolean _showEditGuestIcon;
	private boolean _showExportImportIcon;
	private boolean _showHelpIcon;
	private boolean _showMaxIcon;
	private boolean _showMinIcon;
	private boolean _showMoveIcon;
	private boolean _showPortletCssIcon;
	private boolean _showPortletIcon;
	private boolean _showPrintIcon;
	private boolean _showRefreshIcon;
	private String _urlBack = StringPool.BLANK;
	private String _urlClose = StringPool.BLANK;
	private String _urlConfiguration = StringPool.BLANK;
	private String _urlEdit = StringPool.BLANK;
	private String _urlEditDefaults = StringPool.BLANK;
	private String _urlEditGuest = StringPool.BLANK;
	private String _urlExportImport = StringPool.BLANK;
	private String _urlHelp = StringPool.BLANK;
	private String _urlMax = StringPool.BLANK;
	private String _urlMin = StringPool.BLANK;
	private String _urlPortlet = StringPool.BLANK;
	private String _urlPortletCss = StringPool.BLANK;
	private String _urlPrint = StringPool.BLANK;
	private String _urlRefresh = StringPool.BLANK;
	private boolean _webDAVEnabled;
	private boolean _restoreCurrentView;
	private StringBundler _content = _blankStringBundler;
	private PortletPreferences _portletSetup;

}