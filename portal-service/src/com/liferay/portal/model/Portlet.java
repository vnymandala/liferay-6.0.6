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

package com.liferay.portal.model;

/**
 * The model interface for the Portlet service. Represents a row in the &quot;Portlet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portal.model.impl.PortletImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a portlet model instance should use the {@link Portlet} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletModel
 * @see com.liferay.portal.model.impl.PortletImpl
 * @see com.liferay.portal.model.impl.PortletModelImpl
 * @generated
 */
public interface Portlet extends PortletModel {
	/**
	* Gets the root portlet id of the portlet.
	*
	* @return the root portlet id of the portlet
	*/
	public java.lang.String getRootPortletId();

	/**
	* Gets the instance id of the portlet.
	*
	* @return the instance id of the portlet
	*/
	public java.lang.String getInstanceId();

	/**
	* Gets the plugin id of the portlet.
	*
	* @return the plugin id of the portlet
	*/
	public java.lang.String getPluginId();

	/**
	* Gets the plugin type of the portlet.
	*
	* @return the plugin type of the portlet
	*/
	public java.lang.String getPluginType();

	/**
	* Get the package to which the portlet belongs to.
	*
	* @return the plugin package of the portlet
	*/
	public com.liferay.portal.kernel.plugin.PluginPackage getPluginPackage();

	/**
	* Sets the plugin package this portlet belongs to.
	*
	* @param pluginPackage the plugin package
	*/
	public void setPluginPackage(
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage);

	/**
	* Get the default plugin settings of the portlet.
	*
	* @return the plugin settings
	*/
	public com.liferay.portal.model.PluginSetting getDefaultPluginSetting();

	/**
	* Sets the default plugin settings of the portlet.
	*
	* @param pluginSetting the plugin setting
	*/
	public void setDefaultPluginSetting(
		com.liferay.portal.model.PluginSetting pluginSetting);

	/**
	* Gets the timestamp of the portlet.
	*
	* @return the timestamp of the portlet
	*/
	public long getTimestamp();

	/**
	* Sets the timestamp of the portlet.
	*
	* @param timestamp the timestamp of the portlet
	*/
	public void setTimestamp(long timestamp);

	/**
	* Gets the icon of the portlet.
	*
	* @return the icon of the portlet
	*/
	public java.lang.String getIcon();

	/**
	* Sets the icon of the portlet.
	*
	* @param icon the icon of the portlet
	*/
	public void setIcon(java.lang.String icon);

	/**
	* Gets the virtual path of the portlet.
	*
	* @return the virtual path of the portlet
	*/
	public java.lang.String getVirtualPath();

	/**
	* Sets the virtual path of the portlet.
	*
	* @param virtualPath the virtual path of the portlet
	*/
	public void setVirtualPath(java.lang.String virtualPath);

	/**
	* Gets the struts path of the portlet.
	*
	* @return the struts path of the portlet
	*/
	public java.lang.String getStrutsPath();

	/**
	* Sets the struts path of the portlet.
	*
	* @param strutsPath the struts path of the portlet
	*/
	public void setStrutsPath(java.lang.String strutsPath);

	/**
	* Gets the name of the portlet.
	*
	* @return the display name of the portlet
	*/
	public java.lang.String getPortletName();

	/**
	* Sets the name of the portlet.
	*
	* @param portletName the name of the portlet
	*/
	public void setPortletName(java.lang.String portletName);

	/**
	* Gets the display name of the portlet.
	*
	* @return the display name of the portlet
	*/
	public java.lang.String getDisplayName();

	/**
	* Sets the display name of the portlet.
	*
	* @param displayName the display name of the portlet
	*/
	public void setDisplayName(java.lang.String displayName);

	/**
	* Gets the name of the portlet class of the portlet.
	*
	* @return the name of the portlet class of the portlet
	*/
	public java.lang.String getPortletClass();

	/**
	* Sets the name of the portlet class of the portlet.
	*
	* @param portletClass the name of the portlet class of the portlet
	*/
	public void setPortletClass(java.lang.String portletClass);

	/**
	* Gets the configuration action class of the portlet.
	*
	* @return the configuration action class of the portlet
	*/
	public java.lang.String getConfigurationActionClass();

	/**
	* Sets the configuration action class of the portlet.
	*
	* @param configurationActionClass the configuration action class of the
	portlet
	*/
	public void setConfigurationActionClass(
		java.lang.String configurationActionClass);

	/**
	* Gets the configuration action instance of the portlet.
	*
	* @return the configuration action instance of the portlet
	*/
	public com.liferay.portal.kernel.portlet.ConfigurationAction getConfigurationActionInstance();

	/**
	* Gets the name of the indexer class of the portlet.
	*
	* @return the name of the indexer class of the portlet
	*/
	public java.lang.String getIndexerClass();

	/**
	* Sets the name of the indexer class of the portlet.
	*
	* @param indexerClass the name of the indexer class of the portlet
	*/
	public void setIndexerClass(java.lang.String indexerClass);

	/**
	* Gets the indexer instance of the portlet.
	*
	* @return the indexer instance of the portlet
	*/
	public com.liferay.portal.kernel.search.Indexer getIndexerInstance();

	/**
	* Gets the name of the open search class of the portlet.
	*
	* @return the name of the open search class of the portlet
	*/
	public java.lang.String getOpenSearchClass();

	/**
	* Sets the name of the open search class of the portlet.
	*
	* @param openSearchClass the name of the open search class of the portlet
	*/
	public void setOpenSearchClass(java.lang.String openSearchClass);

	/**
	* Gets the indexer instance of the portlet.
	*
	* @return the indexer instance of the portlet
	*/
	public com.liferay.portal.kernel.search.OpenSearch getOpenSearchInstance();

	/**
	* Adds a scheduler entry.
	*/
	public void addSchedulerEntry(
		com.liferay.portal.kernel.scheduler.SchedulerEntry schedulerEntry);

	/**
	* Gets the scheduler entries of the portlet.
	*
	* @return the scheduler entries of the portlet
	*/
	public java.util.List<com.liferay.portal.kernel.scheduler.SchedulerEntry> getSchedulerEntries();

	/**
	* Sets the scheduler entries of the portlet.
	*
	* @param schedulerEntries the scheduler entries of the portlet
	*/
	public void setSchedulerEntries(
		java.util.List<com.liferay.portal.kernel.scheduler.SchedulerEntry> schedulerEntries);

	/**
	* Gets the name of the portlet URL class of the portlet.
	*
	* @return the name of the portlet URL class of the portlet
	*/
	public java.lang.String getPortletURLClass();

	/**
	* Sets the name of the portlet URL class of the portlet.
	*
	* @param portletURLClass the name of the portlet URL class of the portlet
	*/
	public void setPortletURLClass(java.lang.String portletURLClass);

	/**
	* Gets the name of the friendly URL mapper class of the portlet.
	*
	* @return the name of the friendly URL mapper class of the portlet
	*/
	public java.lang.String getFriendlyURLMapperClass();

	/**
	* Sets the name of the friendly URL mapper class of the portlet.
	*
	* @param friendlyURLMapperClass the name of the friendly URL mapper class
	of the portlet
	*/
	public void setFriendlyURLMapperClass(
		java.lang.String friendlyURLMapperClass);

	/**
	* Gets the friendly URL mapper instance of the portlet.
	*
	* @return the friendly URL mapper instance of the portlet
	*/
	public com.liferay.portal.kernel.portlet.FriendlyURLMapper getFriendlyURLMapperInstance();

	/**
	* Gets the name of the friendly URL mapping of the portlet.
	*
	* @return the name of the friendly URL mapping of the portlet
	*/
	public java.lang.String getFriendlyURLMapping();

	/**
	* Sets the name of the friendly URL mapping of the portlet.
	*
	* @param friendlyURLMapping the name of the friendly URL mapping of the
	portlet
	*/
	public void setFriendlyURLMapping(java.lang.String friendlyURLMapping);

	/**
	* Gets the class loader resource path to the friendly URL routes of the
	* portlet.
	*
	* @return the class loader resource path to the friendly URL routes of the
	portlet
	*/
	public java.lang.String getFriendlyURLRoutes();

	/**
	* Sets the class loader resource path to the friendly URL routes of the
	* portlet.
	*
	* @param friendlyURLRoutes the class loader resource path to the friendly
	URL routes of the portlet
	*/
	public void setFriendlyURLRoutes(java.lang.String friendlyURLRoutes);

	/**
	* Gets the name of the URL encoder class of the portlet.
	*
	* @return the name of the URL encoder class of the portlet
	*/
	public java.lang.String getURLEncoderClass();

	/**
	* Sets the name of the URL encoder class of the portlet.
	*
	* @param urlEncoderClass the name of the URL encoder class of the portlet
	*/
	public void setURLEncoderClass(java.lang.String urlEncoderClass);

	/**
	* Gets the URL encoder instance of the portlet.
	*
	* @return the URL encoder instance of the portlet
	*/
	public com.liferay.portal.kernel.servlet.URLEncoder getURLEncoderInstance();

	/**
	* Gets the name of the portlet data handler class of the portlet.
	*
	* @return the name of the portlet data handler class of the portlet
	*/
	public java.lang.String getPortletDataHandlerClass();

	/**
	* Sets the name of the portlet data handler class of the portlet.
	*
	* @param portletDataHandlerClass the name of portlet data handler class of
	the portlet
	*/
	public void setPortletDataHandlerClass(
		java.lang.String portletDataHandlerClass);

	/**
	* Gets the portlet data handler instance of the portlet.
	*
	* @return the portlet data handler instance of the portlet
	*/
	public com.liferay.portal.kernel.lar.PortletDataHandler getPortletDataHandlerInstance();

	/**
	* Gets the name of the portlet layout listener class of the portlet.
	*
	* @return the name of the portlet layout listener class of the portlet
	*/
	public java.lang.String getPortletLayoutListenerClass();

	/**
	* Sets the name of the portlet layout listener class of the portlet.
	*
	* @param portletLayoutListenerClass the name of the portlet layout listener
	class of the portlet
	*/
	public void setPortletLayoutListenerClass(
		java.lang.String portletLayoutListenerClass);

	/**
	* Gets the portlet layout listener instance of the portlet.
	*
	* @return the portlet layout listener instance of the portlet
	*/
	public com.liferay.portal.kernel.portlet.PortletLayoutListener getPortletLayoutListenerInstance();

	/**
	* Gets the name of the poller processor class of the portlet.
	*
	* @return the name of the poller processor class of the portlet
	*/
	public java.lang.String getPollerProcessorClass();

	/**
	* Sets the name of the poller processor class of the portlet.
	*
	* @param pollerProcessorClass the name of the poller processor class of the
	portlet
	*/
	public void setPollerProcessorClass(java.lang.String pollerProcessorClass);

	/**
	* Gets the poller processor instance of the portlet.
	*
	* @return the poller processor instance of the portlet
	*/
	public com.liferay.portal.kernel.poller.PollerProcessor getPollerProcessorInstance();

	/**
	* Gets the name of the POP message listener class of the portlet.
	*
	* @return the name of the POP message listener class of the portlet
	*/
	public java.lang.String getPopMessageListenerClass();

	/**
	* Sets the name of the POP message listener class of the portlet.
	*
	* @param popMessageListenerClass the name of the POP message listener class
	of the portlet
	*/
	public void setPopMessageListenerClass(
		java.lang.String popMessageListenerClass);

	/**
	* Gets the POP message listener instance of the portlet.
	*
	* @return the POP message listener instance of the portlet
	*/
	public com.liferay.portal.kernel.pop.MessageListener getPopMessageListenerInstance();

	/**
	* Gets the name of the social activity interpreter class of the portlet.
	*
	* @return the name of the social activity interpreter class of the portlet
	*/
	public java.lang.String getSocialActivityInterpreterClass();

	/**
	* Sets the name of the social activity interpreter class of the portlet.
	*
	* @param socialActivityInterpreterClass the name of the activity
	interpreter class of the portlet
	*/
	public void setSocialActivityInterpreterClass(
		java.lang.String socialActivityInterpreterClass);

	/**
	* Gets the name of the social activity interpreter instance of the portlet.
	*
	* @return the name of the social activity interpreter instance of the
	portlet
	*/
	public com.liferay.portlet.social.model.SocialActivityInterpreter getSocialActivityInterpreterInstance();

	/**
	* Gets the name of the social request interpreter class of the portlet.
	*
	* @return the name of the social request interpreter class of the portlet
	*/
	public java.lang.String getSocialRequestInterpreterClass();

	/**
	* Sets the name of the social request interpreter class of the portlet.
	*
	* @param socialRequestInterpreterClass the name of the request interpreter
	class of the portlet
	*/
	public void setSocialRequestInterpreterClass(
		java.lang.String socialRequestInterpreterClass);

	/**
	* Gets the name of the social request interpreter instance of the portlet.
	*
	* @return the name of the social request interpreter instance of the
	portlet
	*/
	public com.liferay.portlet.social.model.SocialRequestInterpreter getSocialRequestInterpreterInstance();

	/**
	* Gets the name of the WebDAV storage token of the portlet.
	*
	* @return the name of the WebDAV storage token of the portlet
	*/
	public java.lang.String getWebDAVStorageToken();

	/**
	* Sets the name of the WebDAV storage token of the portlet.
	*
	* @param webDAVStorageToken the name of the WebDAV storage token of the
	portlet
	*/
	public void setWebDAVStorageToken(java.lang.String webDAVStorageToken);

	/**
	* Gets the name of the WebDAV storage class of the portlet.
	*
	* @return the name of the WebDAV storage class of the portlet
	*/
	public java.lang.String getWebDAVStorageClass();

	/**
	* Sets the name of the WebDAV storage class of the portlet.
	*
	* @param webDAVStorageClass the name of the WebDAV storage class of the
	portlet
	*/
	public void setWebDAVStorageClass(java.lang.String webDAVStorageClass);

	/**
	* Gets the name of the WebDAV storage instance of the portlet.
	*
	* @return the name of the WebDAV storage instance of the portlet
	*/
	public com.liferay.portal.kernel.webdav.WebDAVStorage getWebDAVStorageInstance();

	/**
	* Gets the name of the XML-RPC method class of the portlet.
	*
	* @return the name of the XML-RPC method class of the portlet
	*/
	public java.lang.String getXmlRpcMethodClass();

	/**
	* Sets the name of the XML-RPC method class of the portlet.
	*
	* @param xmlRpcMethodClass the name of the XML-RPC method class of the
	portlet
	*/
	public void setXmlRpcMethodClass(java.lang.String xmlRpcMethodClass);

	/**
	* Gets the name of the XML-RPC method instance of the portlet.
	*
	* @return the name of the XML-RPC method instance of the portlet
	*/
	public com.liferay.portal.kernel.xmlrpc.Method getXmlRpcMethodInstance();

	/**
	* Gets the name of the category of the Control Panel where the portlet will
	* be shown.
	*
	* @return the name of of the category of the Control Panel where the
	portlet will be shown
	*/
	public java.lang.String getControlPanelEntryCategory();

	/**
	* Set the name of the category of the Control Panel where the portlet will
	* be shown.
	*
	* @param controlPanelEntryCategory the name of the category of the Control
	Panel where the portlet will be shown
	*/
	public void setControlPanelEntryCategory(
		java.lang.String controlPanelEntryCategory);

	/**
	* Gets the relative weight of the portlet with respect to the other
	* portlets in the same category of the Control Panel.
	*
	* @return the relative weight of the portlet with respect to the other
	portlets in the same category of the Control Panel
	*/
	public double getControlPanelEntryWeight();

	/**
	* Sets the relative weight of the portlet with respect to the other
	* portlets in the same category of the Control Panel.
	*
	* @param controlPanelEntryWeight the relative weight of the portlet with
	respect to the other portlets in the same category of the Control
	Panel
	*/
	public void setControlPanelEntryWeight(double controlPanelEntryWeight);

	/**
	* Gets the name of the class that will control when the portlet will be
	* shown in the Control Panel.
	*
	* @return the name of the class that will control when the portlet will be
	shown in the Control Panel
	*/
	public java.lang.String getControlPanelEntryClass();

	/**
	* Sets the name of the class that will control when the portlet will be
	* shown in the Control Panel.
	*
	* @param controlPanelEntryClass the name of the class that will control
	when the portlet will be shown in the Control Panel
	*/
	public void setControlPanelEntryClass(
		java.lang.String controlPanelEntryClass);

	/**
	* Gets an instance of the class that will control when the portlet will be
	* shown in the Control Panel.
	*
	* @return the instance of the class that will control when the portlet will
	be shown in the Control Panel
	*/
	public com.liferay.portlet.ControlPanelEntry getControlPanelEntryInstance();

	/**
	* Gets the names of the classes that represent asset types associated to
	* the portlet.
	*
	* @return the names of the classes that represent asset types associated to
	the portlet
	*/
	public java.util.List<java.lang.String> getAssetRendererFactoryClasses();

	/**
	* Sets the name of the classes that represent asset types associated to the
	* portlet.
	*
	* @param assetRendererFactoryClasses the names of the classes that
	represent asset types associated to the portlet
	*/
	public void setAssetRendererFactoryClasses(
		java.util.List<java.lang.String> assetRendererFactoryClasses);

	/**
	* Gets the asset type instances of the portlet.
	*
	* @return the asset type instances of the portlet
	*/
	public java.util.List<com.liferay.portlet.asset.model.AssetRendererFactory> getAssetRendererFactoryInstances();

	/**
	* Gets the names of the classes that represent custom attribute displays
	* associated to the portlet.
	*
	* @return the names of the classes that represent asset types associated to
	the portlet
	*/
	public java.util.List<java.lang.String> getCustomAttributesDisplayClasses();

	/**
	* Sets the name of the classes that represent custom attribute displays
	* associated to the portlet.
	*
	* @param customAttributesDisplayClasses the names of the classes that
	represent custom attribute displays associated to the portlet
	*/
	public void setCustomAttributesDisplayClasses(
		java.util.List<java.lang.String> customAttributesDisplayClasses);

	/**
	* Gets the custom attribute display instances of the portlet.
	*
	* @return the custom attribute display instances of the portlet
	*/
	public java.util.List<com.liferay.portlet.expando.model.CustomAttributesDisplay> getCustomAttributesDisplayInstances();

	/**
	* Gets the names of the classes that represent workflow handlers associated
	* to the portlet.
	*
	* @return the names of the classes that represent workflow handlers
	associated to the portlet
	*/
	public java.util.List<java.lang.String> getWorkflowHandlerClasses();

	/**
	* Sets the name of the classes that represent workflow handlers associated
	* to the portlet.
	*
	* @param workflowHandlerClasses the names of the classes that represent
	workflow handlers associated to the portlet
	*/
	public void setWorkflowHandlerClasses(
		java.util.List<java.lang.String> workflowHandlerClasses);

	/**
	* Gets the workflow handler instances of the portlet.
	*
	* @return the workflow handler instances of the portlet
	*/
	public java.util.List<com.liferay.portal.kernel.workflow.WorkflowHandler> getWorkflowHandlerInstances();

	/**
	* Gets the default preferences of the portlet.
	*
	* @return the default preferences of the portlet
	*/
	public java.lang.String getDefaultPreferences();

	/**
	* Sets the default preferences of the portlet.
	*
	* @param defaultPreferences the default preferences of the portlet
	*/
	public void setDefaultPreferences(java.lang.String defaultPreferences);

	/**
	* Gets the name of the preferences validator class of the portlet.
	*
	* @return the name of the preferences validator class of the portlet
	*/
	public java.lang.String getPreferencesValidator();

	/**
	* Sets the name of the preferences validator class of the portlet.
	*
	* @param preferencesValidator the name of the preferences validator class
	of the portlet
	*/
	public void setPreferencesValidator(java.lang.String preferencesValidator);

	/**
	* Returns <code>true</code> if preferences are shared across the entire
	* company.
	*
	* @return <code>true</code> if preferences are shared across the entire
	company
	*/
	public boolean getPreferencesCompanyWide();

	/**
	* Returns <code>true</code> if preferences are shared across the entire
	* company.
	*
	* @return <code>true</code> if preferences are shared across the entire
	company
	*/
	public boolean isPreferencesCompanyWide();

	/**
	* Set to <code>true</code> if preferences are shared across the entire
	* company.
	*
	* @param preferencesCompanyWide boolean value for whether preferences are
	shared across the entire company
	*/
	public void setPreferencesCompanyWide(boolean preferencesCompanyWide);

	/**
	* Returns <code>true</code> if preferences are unique per layout.
	*
	* @return <code>true</code> if preferences are unique per layout
	*/
	public boolean getPreferencesUniquePerLayout();

	/**
	* Returns <code>true</code> if preferences are unique per layout.
	*
	* @return <code>true</code> if preferences are unique per layout
	*/
	public boolean isPreferencesUniquePerLayout();

	/**
	* Set to <code>true</code> if preferences are unique per layout.
	*
	* @param preferencesUniquePerLayout boolean value for whether preferences
	are unique per layout
	*/
	public void setPreferencesUniquePerLayout(
		boolean preferencesUniquePerLayout);

	/**
	* Returns <code>true</code> if preferences are owned by the group when the
	* portlet is shown in a group layout. Returns <code>false</code> if
	* preferences are owned by the user at all times.
	*
	* @return <code>true</code> if preferences are owned by the group when the
	portlet is shown in a group layout; <code>false</code> if
	preferences are owned by the user at all times.
	*/
	public boolean getPreferencesOwnedByGroup();

	/**
	* Returns <code>true</code> if preferences are owned by the group when the
	* portlet is shown in a group layout. Returns <code>false</code> if
	* preferences are owned by the user at all times.
	*
	* @return <code>true</code> if preferences are owned by the group when the
	portlet is shown in a group layout; <code>false</code> if
	preferences are owned by the user at all times.
	*/
	public boolean isPreferencesOwnedByGroup();

	/**
	* Set to <code>true</code> if preferences are owned by the group when the
	* portlet is shown in a group layout. Set to <code>false</code> if
	* preferences are owned by the user at all times.
	*
	* @param preferencesOwnedByGroup boolean value for whether preferences are
	owned by the group when the portlet is shown in a group layout or
	preferences are owned by the user at all times
	*/
	public void setPreferencesOwnedByGroup(boolean preferencesOwnedByGroup);

	/**
	* Returns <code>true</code> if the portlet uses the default template.
	*
	* @return <code>true</code> if the portlet uses the default template
	*/
	public boolean getUseDefaultTemplate();

	/**
	* Returns <code>true</code> if the portlet uses the default template.
	*
	* @return <code>true</code> if the portlet uses the default template
	*/
	public boolean isUseDefaultTemplate();

	/**
	* Set to <code>true</code> if the portlet uses the default template.
	*
	* @param useDefaultTemplate boolean value for whether the portlet uses the
	default template
	*/
	public void setUseDefaultTemplate(boolean useDefaultTemplate);

	/**
	* Returns <code>true</code> if users are shown that they do not have access
	* to the portlet.
	*
	* @return <code>true</code> if users are shown that they do not have access
	to the portlet
	*/
	public boolean getShowPortletAccessDenied();

	/**
	* Returns <code>true</code> if users are shown that they do not have access
	* to the portlet.
	*
	* @return <code>true</code> if users are shown that they do not have access
	to the portlet
	*/
	public boolean isShowPortletAccessDenied();

	/**
	* Set to <code>true</code> if users are shown that they do not have access
	* to the portlet.
	*
	* @param showPortletAccessDenied boolean value for whether users are shown
	that they do not have access to the portlet
	*/
	public void setShowPortletAccessDenied(boolean showPortletAccessDenied);

	/**
	* Returns <code>true</code> if users are shown that the portlet is
	* inactive.
	*
	* @return <code>true</code> if users are shown that the portlet is inactive
	*/
	public boolean getShowPortletInactive();

	/**
	* Returns <code>true</code> if users are shown that the portlet is
	* inactive.
	*
	* @return <code>true</code> if users are shown that the portlet is inactive
	*/
	public boolean isShowPortletInactive();

	/**
	* Set to <code>true</code> if users are shown that the portlet is inactive.
	*
	* @param showPortletInactive boolean value for whether users are shown that
	the portlet is inactive
	*/
	public void setShowPortletInactive(boolean showPortletInactive);

	/**
	* Returns <code>true</code> if an action URL for this portlet should cause
	* an auto redirect.
	*
	* @return <code>true</code> if an action URL for this portlet should cause
	an auto redirect
	*/
	public boolean getActionURLRedirect();

	/**
	* Returns <code>true</code> if an action URL for this portlet should cause
	* an auto redirect.
	*
	* @return <code>true</code> if an action URL for this portlet should cause
	an auto redirect
	*/
	public boolean isActionURLRedirect();

	/**
	* Set to <code>true</code> if an action URL for this portlet should cause
	* an auto redirect.
	*
	* @param actionURLRedirect boolean value for whether an action URL for this
	portlet should cause an auto redirect
	*/
	public void setActionURLRedirect(boolean actionURLRedirect);

	/**
	* Returns <code>true</code> if the portlet restores to the current view
	* from the maximized state.
	*
	* @return <code>true</code> if the portlet restores to the current view
	from the maximized state
	*/
	public boolean getRestoreCurrentView();

	/**
	* Returns <code>true</code> if the portlet restores to the current view
	* from the maximized state.
	*
	* @return <code>true</code> if the portlet restores to the current view
	from the maximized state
	*/
	public boolean isRestoreCurrentView();

	/**
	* Set to <code>true</code> if the portlet restores to the current view from
	* the maximized state.
	*
	* @param restoreCurrentView boolean value for whether the portlet restores
	to the current view from the maximized state
	*/
	public void setRestoreCurrentView(boolean restoreCurrentView);

	/**
	* Returns <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the edit mode.
	*
	* @return <code>true</code> if the portlet goes into the maximized state
	when the user goes into the edit mode
	*/
	public boolean getMaximizeEdit();

	/**
	* Returns <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the edit mode.
	*
	* @return <code>true</code> if the portlet goes into the maximized state
	when the user goes into the edit mode
	*/
	public boolean isMaximizeEdit();

	/**
	* Set to <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the edit mode.
	*
	* @param maximizeEdit boolean value for whether the portlet goes into the
	maximized state when the user goes into the edit mode
	*/
	public void setMaximizeEdit(boolean maximizeEdit);

	/**
	* Returns <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the help mode.
	*
	* @return <code>true</code> if the portlet goes into the maximized state
	when the user goes into the help mode
	*/
	public boolean getMaximizeHelp();

	/**
	* Returns <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the help mode.
	*
	* @return <code>true</code> if the portlet goes into the maximized state
	when the user goes into the help mode
	*/
	public boolean isMaximizeHelp();

	/**
	* Set to <code>true</code> if the portlet goes into the maximized state
	* when the user goes into the help mode.
	*
	* @param maximizeHelp boolean value for whether the portlet goes into the
	maximized state when the user goes into the help mode
	*/
	public void setMaximizeHelp(boolean maximizeHelp);

	/**
	* Returns <code>true</code> if the portlet goes into the pop up state when
	* the user goes into the print mode.
	*
	* @return <code>true</code> if the portlet goes into the pop up state when
	the user goes into the print mode
	*/
	public boolean getPopUpPrint();

	/**
	* Returns <code>true</code> if the portlet goes into the pop up state when
	* the user goes into the print mode.
	*
	* @return <code>true</code> if the portlet goes into the pop up state when
	the user goes into the print mode
	*/
	public boolean isPopUpPrint();

	/**
	* Set to <code>true</code> if the portlet goes into the pop up state when
	* the user goes into the print mode.
	*
	* @param popUpPrint boolean value for whether the portlet goes into the pop
	up state when the user goes into the print mode
	*/
	public void setPopUpPrint(boolean popUpPrint);

	/**
	* Returns <code>true</code> to allow the portlet to be cached within the
	* layout.
	*
	* @return <code>true</code> if the portlet can be cached within the layout
	*/
	public boolean getLayoutCacheable();

	/**
	* Returns <code>true</code> to allow the portlet to be cached within the
	* layout.
	*
	* @return <code>true</code> if the portlet can be cached within the layout
	*/
	public boolean isLayoutCacheable();

	/**
	* Set to <code>true</code> to allow the portlet to be cached within the
	* layout.
	*
	* @param layoutCacheable boolean value for whether the portlet can be
	cached within the layout
	*/
	public void setLayoutCacheable(boolean layoutCacheable);

	/**
	* Returns <code>true</code> if the portlet can be added multiple times to a
	* layout.
	*
	* @return <code>true</code> if the portlet can be added multiple times to a
	layout
	*/
	public boolean getInstanceable();

	/**
	* Returns <code>true</code> if the portlet can be added multiple times to a
	* layout.
	*
	* @return <code>true</code> if the portlet can be added multiple times to a
	layout
	*/
	public boolean isInstanceable();

	/**
	* Set to <code>true</code> if the portlet can be added multiple times to a
	* layout.
	*
	* @param instanceable boolean value for whether the portlet can be added
	multiple times to a layout
	*/
	public void setInstanceable(boolean instanceable);

	/**
	* Returns <code>true</code> if the portlet supports remoting.
	*
	* @return <code>true</code> if the portlet supports remoting
	*/
	public boolean getRemoteable();

	/**
	* Returns <code>true</code> if the portlet supports remoting.
	*
	* @return <code>true</code> if the portlet supports remoting
	*/
	public boolean isRemoteable();

	/**
	* Set to <code>true</code> if the portlet supports remoting
	*
	* @param remoteable boolean value for whether or not the the portlet
	supports remoting
	*/
	public void setRemoteable(boolean remoteable);

	/**
	* Returns <code>true</code> if the portlet supports scoping of data.
	*
	* @return <code>true</code> if the portlet supports scoping of data
	*/
	public boolean getScopeable();

	/**
	* Returns <code>true</code> if the portlet supports scoping of data.
	*
	* @return <code>true</code> if the portlet supports scoping of data
	*/
	public boolean isScopeable();

	/**
	* Set to <code>true</code> if the portlet supports scoping of data.
	*
	* @param scopeable boolean value for whether or not the the portlet
	supports scoping of data
	*/
	public void setScopeable(boolean scopeable);

	/**
	* Gets the user principal strategy of the portlet.
	*
	* @return the user principal strategy of the portlet
	*/
	public java.lang.String getUserPrincipalStrategy();

	/**
	* Sets the user principal strategy of the portlet.
	*
	* @param userPrincipalStrategy the user principal strategy of the portlet
	*/
	public void setUserPrincipalStrategy(java.lang.String userPrincipalStrategy);

	/**
	* Returns <code>true</code> if the portlet does not share request
	* attributes with the portal or portlets from another WAR.
	*
	* @return <code>true</code> if the portlet does not share request
	attributes with the portal or portlets from another WAR
	*/
	public boolean getPrivateRequestAttributes();

	/**
	* Returns <code>true</code> if the portlet does not share request
	* attributes with the portal or portlets from another WAR.
	*
	* @return <code>true</code> if the portlet does not share request
	attributes with the portal or portlets from another WAR
	*/
	public boolean isPrivateRequestAttributes();

	/**
	* Set to <code>true</code> if the portlet does not share request attributes
	* with the portal or portlets from another WAR.
	*
	* @param privateRequestAttributes boolean value for whether the portlet
	shares request attributes with the portal or portlets from another
	WAR
	*/
	public void setPrivateRequestAttributes(boolean privateRequestAttributes);

	/**
	* Returns <code>true</code> if the portlet does not share session
	* attributes with the portal.
	*
	* @return <code>true</code> if the portlet does not share session
	attributes with the portal
	*/
	public boolean getPrivateSessionAttributes();

	/**
	* Returns <code>true</code> if the portlet does not share session
	* attributes with the portal.
	*
	* @return <code>true</code> if the portlet does not share session
	attributes with the portal
	*/
	public boolean isPrivateSessionAttributes();

	/**
	* Set to <code>true</code> if the portlet does not share session attributes
	* with the portal.
	*
	* @param privateSessionAttributes boolean value for whether the portlet
	shares session attributes with the portal
	*/
	public void setPrivateSessionAttributes(boolean privateSessionAttributes);

	/**
	* Returns the render weight of the portlet.
	*
	* @return the render weight of the portlet
	*/
	public int getRenderWeight();

	/**
	* Sets the render weight of the portlet.
	*
	* @param renderWeight int value for the render weight of the portlet
	*/
	public void setRenderWeight(int renderWeight);

	/**
	* Returns <code>true</code> if the portlet can be displayed via Ajax.
	*
	* @return <code>true</code> if the portlet can be displayed via Ajax
	*/
	public boolean getAjaxable();

	/**
	* Returns <code>true</code> if the portlet can be displayed via Ajax.
	*
	* @return <code>true</code> if the portlet can be displayed via Ajax
	*/
	public boolean isAjaxable();

	/**
	* Set to <code>true</code> if the portlet can be displayed via Ajax.
	*
	* @param ajaxable boolean value for whether the portlet can be displayed
	via Ajax
	*/
	public void setAjaxable(boolean ajaxable);

	/**
	* Gets a list of CSS files that will be referenced from the page's header
	* relative to the portal's context path.
	*
	* @return a list of CSS files that will be referenced from the page's
	header relative to the portal's context path
	*/
	public java.util.List<java.lang.String> getHeaderPortalCss();

	/**
	* Sets a list of CSS files that will be referenced from the page's header
	* relative to the portal's context path.
	*
	* @param headerPortalCss a list of CSS files that will be referenced from
	the page's header relative to the portal's context path
	*/
	public void setHeaderPortalCss(
		java.util.List<java.lang.String> headerPortalCss);

	/**
	* Gets a list of CSS files that will be referenced from the page's header
	* relative to the portlet's context path.
	*
	* @return a list of CSS files that will be referenced from the page's
	header relative to the portlet's context path
	*/
	public java.util.List<java.lang.String> getHeaderPortletCss();

	/**
	* Sets a list of CSS files that will be referenced from the page's header
	* relative to the portlet's context path.
	*
	* @param headerPortletCss a list of CSS files that will be referenced from
	the page's header relative to the portlet's context path
	*/
	public void setHeaderPortletCss(
		java.util.List<java.lang.String> headerPortletCss);

	/**
	* Gets a list of JavaScript files that will be referenced from the page's
	* header relative to the portal's context path.
	*
	* @return a list of JavaScript files that will be referenced from the
	page's header relative to the portal's context path
	*/
	public java.util.List<java.lang.String> getHeaderPortalJavaScript();

	/**
	* Sets a list of JavaScript files that will be referenced from the page's
	* header relative to the portal's context path.
	*
	* @param headerPortalJavaScript a list of JavaScript files that will be
	referenced from the page's header relative to the portal's context
	path
	*/
	public void setHeaderPortalJavaScript(
		java.util.List<java.lang.String> headerPortalJavaScript);

	/**
	* Gets a list of JavaScript files that will be referenced from the page's
	* header relative to the portlet's context path.
	*
	* @return a list of JavaScript files that will be referenced from the
	page's header relative to the portlet's context path
	*/
	public java.util.List<java.lang.String> getHeaderPortletJavaScript();

	/**
	* Sets a list of JavaScript files that will be referenced from the page's
	* header relative to the portlet's context path.
	*
	* @param headerPortletJavaScript a list of JavaScript files that will be
	referenced from the page's header relative to the portlet's
	context path
	*/
	public void setHeaderPortletJavaScript(
		java.util.List<java.lang.String> headerPortletJavaScript);

	/**
	* Gets a list of CSS files that will be referenced from the page's footer
	* relative to the portal's context path.
	*
	* @return a list of CSS files that will be referenced from the page's
	footer relative to the portal's context path
	*/
	public java.util.List<java.lang.String> getFooterPortalCss();

	/**
	* Sets a list of CSS files that will be referenced from the page's footer
	* relative to the portal's context path.
	*
	* @param footerPortalCss a list of CSS files that will be referenced from
	the page's footer relative to the portal's context path
	*/
	public void setFooterPortalCss(
		java.util.List<java.lang.String> footerPortalCss);

	/**
	* Gets a list of CSS files that will be referenced from the page's footer
	* relative to the portlet's context path.
	*
	* @return a list of CSS files that will be referenced from the page's
	footer relative to the portlet's context path
	*/
	public java.util.List<java.lang.String> getFooterPortletCss();

	/**
	* Sets a list of CSS files that will be referenced from the page's footer
	* relative to the portlet's context path.
	*
	* @param footerPortletCss a list of CSS files that will be referenced from
	the page's footer relative to the portlet's context path
	*/
	public void setFooterPortletCss(
		java.util.List<java.lang.String> footerPortletCss);

	/**
	* Gets a list of JavaScript files that will be referenced from the page's
	* footer relative to the portal's context path.
	*
	* @return a list of JavaScript files that will be referenced from the
	page's footer relative to the portal's context path
	*/
	public java.util.List<java.lang.String> getFooterPortalJavaScript();

	/**
	* Sets a list of JavaScript files that will be referenced from the page's
	* footer relative to the portal's context path.
	*
	* @param footerPortalJavaScript a list of JavaScript files that will be
	referenced from the page's footer relative to the portal's context
	path
	*/
	public void setFooterPortalJavaScript(
		java.util.List<java.lang.String> footerPortalJavaScript);

	/**
	* Gets a list of JavaScript files that will be referenced from the page's
	* footer relative to the portlet's context path.
	*
	* @return a list of JavaScript files that will be referenced from the
	page's footer relative to the portlet's context path
	*/
	public java.util.List<java.lang.String> getFooterPortletJavaScript();

	/**
	* Sets a list of JavaScript files that will be referenced from the page's
	* footer relative to the portlet's context path.
	*
	* @param footerPortletJavaScript a list of JavaScript files that will be
	referenced from the page's footer relative to the portlet's
	context path
	*/
	public void setFooterPortletJavaScript(
		java.util.List<java.lang.String> footerPortletJavaScript);

	/**
	* Gets the name of the CSS class that will be injected in the DIV that
	* wraps this portlet.
	*
	* @return the name of the CSS class that will be injected in the DIV that
	wraps this portlet
	*/
	public java.lang.String getCssClassWrapper();

	/**
	* Sets the name of the CSS class that will be injected in the DIV that
	* wraps this portlet.
	*
	* @param cssClassWrapper the name of the CSS class that will be injected in
	the DIV that wraps this portlet
	*/
	public void setCssClassWrapper(java.lang.String cssClassWrapper);

	/**
	* Gets the Facebook integration method of the portlet.
	*
	* @return the Facebook integration method of the portlet
	*/
	public java.lang.String getFacebookIntegration();

	/**
	* Sets the Facebook integration method of the portlet.
	*
	* @param facebookIntegration the Facebook integration method of the portlet
	*/
	public void setFacebookIntegration(java.lang.String facebookIntegration);

	/**
	* Returns <code>true</code> if default resources for the portlet are added
	* to a page.
	*
	* @return <code>true</code> if default resources for the portlet are added
	to a page
	*/
	public boolean getAddDefaultResource();

	/**
	* Returns <code>true</code> if default resources for the portlet are added
	* to a page.
	*
	* @return <code>true</code> if default resources for the portlet are added
	to a page
	*/
	public boolean isAddDefaultResource();

	/**
	* Set to <code>true</code> if default resources for the portlet are added
	* to a page.
	*
	* @param addDefaultResource boolean value for whether or not default
	resources for the portlet are added to a page
	*/
	public void setAddDefaultResource(boolean addDefaultResource);

	/**
	* Sets a string of ordered comma delimited portlet ids.
	*
	* @param roles a string of ordered comma delimited portlet ids
	*/
	public void setRoles(java.lang.String roles);

	/**
	* Gets an array of required roles of the portlet.
	*
	* @return an array of required roles of the portlet
	*/
	public java.lang.String[] getRolesArray();

	/**
	* Sets an array of required roles of the portlet.
	*
	* @param rolesArray an array of required roles of the portlet
	*/
	public void setRolesArray(java.lang.String[] rolesArray);

	/**
	* Gets the unlinked roles of the portlet.
	*
	* @return unlinked roles of the portlet
	*/
	public java.util.Set<java.lang.String> getUnlinkedRoles();

	/**
	* Sets the unlinked roles of the portlet.
	*
	* @param unlinkedRoles the unlinked roles of the portlet
	*/
	public void setUnlinkedRoles(java.util.Set<java.lang.String> unlinkedRoles);

	/**
	* Gets the role mappers of the portlet.
	*
	* @return role mappers of the portlet
	*/
	public java.util.Map<java.lang.String, java.lang.String> getRoleMappers();

	/**
	* Sets the role mappers of the portlet.
	*
	* @param roleMappers the role mappers of the portlet
	*/
	public void setRoleMappers(
		java.util.Map<java.lang.String, java.lang.String> roleMappers);

	/**
	* Link the role names set in portlet.xml with the Liferay roles set in
	* liferay-portlet.xml.
	*/
	public void linkRoles();

	/**
	* Returns <code>true</code> if the portlet has a role with the specified
	* name.
	*
	* @return <code>true</code> if the portlet has a role with the specified
	name
	*/
	public boolean hasRoleWithName(java.lang.String roleName);

	/**
	* Returns <code>true</code> if the user has the permission to add the
	* portlet to a layout.
	*
	* @return <code>true</code> if the user has the permission to add the
	portlet to a layout
	*/
	public boolean hasAddPortletPermission(long userId);

	/**
	* Returns <code>true</code> if the portlet is a system portlet that a user
	* cannot manually add to their page.
	*
	* @return <code>true</code> if the portlet is a system portlet that a user
	cannot manually add to their page
	*/
	public boolean getSystem();

	/**
	* Returns <code>true</code> if the portlet is a system portlet that a user
	* cannot manually add to their page.
	*
	* @return <code>true</code> if the portlet is a system portlet that a user
	cannot manually add to their page
	*/
	public boolean isSystem();

	/**
	* Set to <code>true</code> if the portlet is a system portlet that a user
	* cannot manually add to their page.
	*
	* @param system boolean value for whether the portlet is a system portlet
	that a user cannot manually add to their page
	*/
	public void setSystem(boolean system);

	/**
	* Returns <code>true</code> to include the portlet and make it available to
	* be made active.
	*
	* @return <code>true</code> to include the portlet and make it available to
	be made active
	*/
	public boolean getInclude();

	/**
	* Returns <code>true</code> to include the portlet and make it available to
	* be made active.
	*
	* @return <code>true</code> to include the portlet and make it available to
	be made active
	*/
	public boolean isInclude();

	/**
	* Set to <code>true</code> to include the portlet and make it available to
	* be made active.
	*
	* @param include boolean value for whether to include the portlet and make
	it available to be made active
	*/
	public void setInclude(boolean include);

	/**
	* Gets the init parameters of the portlet.
	*
	* @return init parameters of the portlet
	*/
	public java.util.Map<java.lang.String, java.lang.String> getInitParams();

	/**
	* Sets the init parameters of the portlet.
	*
	* @param initParams the init parameters of the portlet
	*/
	public void setInitParams(
		java.util.Map<java.lang.String, java.lang.String> initParams);

	/**
	* Gets expiration cache of the portlet.
	*
	* @return expiration cache of the portlet
	*/
	public java.lang.Integer getExpCache();

	/**
	* Sets expiration cache of the portlet.
	*
	* @param expCache expiration cache of the portlet
	*/
	public void setExpCache(java.lang.Integer expCache);

	/**
	* Gets the portlet modes of the portlet.
	*
	* @return portlet modes of the portlet
	*/
	public java.util.Map<java.lang.String, java.util.Set<java.lang.String>> getPortletModes();

	/**
	* Sets the portlet modes of the portlet.
	*
	* @param portletModes the portlet modes of the portlet
	*/
	public void setPortletModes(
		java.util.Map<java.lang.String, java.util.Set<java.lang.String>> portletModes);

	/**
	* Returns <code>true</code> if the portlet supports the specified mime type
	* and portlet mode.
	*
	* @return <code>true</code> if the portlet supports the specified mime type
	and portlet mode
	*/
	public boolean hasPortletMode(java.lang.String mimeType,
		javax.portlet.PortletMode portletMode);

	/**
	* Gets a list of all portlet modes supported by the portlet.
	*
	* @return a list of all portlet modes supported by the portlet
	*/
	public java.util.Set<java.lang.String> getAllPortletModes();

	/**
	* Returns <code>true</code> if the portlet supports more than one mime
	* type.
	*
	* @return <code>true</code> if the portlet supports more than one mime type
	*/
	public boolean hasMultipleMimeTypes();

	/**
	* Gets the window states of the portlet.
	*
	* @return window states of the portlet
	*/
	public java.util.Map<java.lang.String, java.util.Set<java.lang.String>> getWindowStates();

	/**
	* Sets the window states of the portlet.
	*
	* @param windowStates the window states of the portlet
	*/
	public void setWindowStates(
		java.util.Map<java.lang.String, java.util.Set<java.lang.String>> windowStates);

	/**
	* Returns <code>true</code> if the portlet supports the specified mime type
	* and window state.
	*
	* @return <code>true</code> if the portlet supports the specified mime type
	and window state
	*/
	public boolean hasWindowState(java.lang.String mimeType,
		javax.portlet.WindowState windowState);

	/**
	* Gets a list of all window states supported by the portlet.
	*
	* @return a list of all window states supported by the portlet
	*/
	public java.util.Set<java.lang.String> getAllWindowStates();

	/**
	* Gets the supported locales of the portlet.
	*
	* @return supported locales of the portlet
	*/
	public java.util.Set<java.lang.String> getSupportedLocales();

	/**
	* Sets the supported locales of the portlet.
	*
	* @param supportedLocales the supported locales of the portlet
	*/
	public void setSupportedLocales(
		java.util.Set<java.lang.String> supportedLocales);

	/**
	* Gets the resource bundle of the portlet.
	*
	* @return resource bundle of the portlet
	*/
	public java.lang.String getResourceBundle();

	/**
	* Sets the resource bundle of the portlet.
	*
	* @param resourceBundle the resource bundle of the portlet
	*/
	public void setResourceBundle(java.lang.String resourceBundle);

	/**
	* Gets the portlet info of the portlet.
	*
	* @return portlet info of the portlet
	*/
	public com.liferay.portal.model.PortletInfo getPortletInfo();

	/**
	* Sets the portlet info of the portlet.
	*
	* @param portletInfo the portlet info of the portlet
	*/
	public void setPortletInfo(com.liferay.portal.model.PortletInfo portletInfo);

	/**
	* Gets the filters of the portlet.
	*
	* @return filters of the portlet
	*/
	public java.util.Map<java.lang.String, com.liferay.portal.model.PortletFilter> getPortletFilters();

	/**
	* Sets the filters of the portlet.
	*
	* @param portletFilters the filters of the portlet
	*/
	public void setPortletFilters(
		java.util.Map<java.lang.String, com.liferay.portal.model.PortletFilter> portletFilters);

	/**
	* Adds a supported processing event.
	*/
	public void addProcessingEvent(
		com.liferay.portal.kernel.xml.QName processingEvent);

	/**
	* Gets the supported processing event from a namespace URI and a local
	* part.
	*
	* @return the supported processing event from a namespace URI and a local
	part
	*/
	public com.liferay.portal.kernel.xml.QName getProcessingEvent(
		java.lang.String uri, java.lang.String localPart);

	/**
	* Gets the supported processing events of the portlet.
	*
	* @return supported processing events of the portlet
	*/
	public java.util.Set<com.liferay.portal.kernel.xml.QName> getProcessingEvents();

	/**
	* Sets the supported processing events of the portlet.
	*
	* @param processingEvents the supported processing events of the portlet
	*/
	public void setProcessingEvents(
		java.util.Set<com.liferay.portal.kernel.xml.QName> processingEvents);

	/**
	* Adds a supported publishing event.
	*/
	public void addPublishingEvent(
		com.liferay.portal.kernel.xml.QName publishingEvent);

	/**
	* Gets the supported publishing events of the portlet.
	*
	* @return supported publishing events of the portlet
	*/
	public java.util.Set<com.liferay.portal.kernel.xml.QName> getPublishingEvents();

	/**
	* Sets the supported publishing events of the portlet.
	*
	* @param publishingEvents the supported publishing events of the portlet
	*/
	public void setPublishingEvents(
		java.util.Set<com.liferay.portal.kernel.xml.QName> publishingEvents);

	/**
	* Adds a supported public render parameter.
	*
	* @param publicRenderParameter a supported public render parameter
	*/
	public void addPublicRenderParameter(
		com.liferay.portal.model.PublicRenderParameter publicRenderParameter);

	/**
	* Gets the supported public render parameter from an identifier.
	*
	* @return the supported public render parameter from an identifier
	*/
	public com.liferay.portal.model.PublicRenderParameter getPublicRenderParameter(
		java.lang.String identifier);

	/**
	* Gets the supported public render parameter from a namespace URI and a
	* local part.
	*
	* @return the supported public render parameter from a namespace URI and a
	local part
	*/
	public com.liferay.portal.model.PublicRenderParameter getPublicRenderParameter(
		java.lang.String uri, java.lang.String localPart);

	/**
	* Gets the supported public render parameters of the portlet.
	*
	* @return the supported public render parameters of the portlet
	*/
	public java.util.Set<com.liferay.portal.model.PublicRenderParameter> getPublicRenderParameters();

	/**
	* Sets the supported public render parameters of the portlet.
	*
	* @param publicRenderParameters the supported public render parameters of
	the portlet
	*/
	public void setPublicRenderParameters(
		java.util.Set<com.liferay.portal.model.PublicRenderParameter> publicRenderParameters);

	/**
	* Gets the servlet context path of the portlet.
	*
	* @return the servlet context path of the portlet
	*/
	public java.lang.String getContextPath();

	/**
	* Get the application this portlet belongs to.
	*
	* @return the application this portlet belongs to
	*/
	public com.liferay.portal.model.PortletApp getPortletApp();

	/**
	* Sets the application this portlet belongs to.
	*
	* @param portletApp the application this portlet belongs to
	*/
	public void setPortletApp(com.liferay.portal.model.PortletApp portletApp);

	/**
	* Returns <code>true</code> if the portlet is found in a WAR file.
	*
	* @param portletId the cloned instance portlet id
	* @return a cloned instance of the portlet
	*/
	public com.liferay.portal.model.Portlet getClonedInstance(
		java.lang.String portletId);

	/**
	* Returns <code>true</code> if the portlet is a static portlet that is
	* cannot be moved.
	*
	* @return <code>true</code> if the portlet is a static portlet that is
	cannot be moved
	*/
	public boolean getStatic();

	/**
	* Returns <code>true</code> if the portlet is a static portlet that is
	* cannot be moved.
	*
	* @return <code>true</code> if the portlet is a static portlet that is
	cannot be moved
	*/
	public boolean isStatic();

	/**
	* Set to <code>true</code> if the portlet is a static portlet that is
	* cannot be moved.
	*
	* @param staticPortlet boolean value for whether the portlet is a static
	portlet that cannot be moved
	*/
	public void setStatic(boolean staticPortlet);

	/**
	* Returns <code>true</code> if the portlet is a static portlet at the start
	* of a list of portlets.
	*
	* @return <code>true</code> if the portlet is a static portlet at the start
	of a list of portlets
	*/
	public boolean getStaticStart();

	/**
	* Returns <code>true</code> if the portlet is a static portlet at the start
	* of a list of portlets.
	*
	* @return <code>true</code> if the portlet is a static portlet at the start
	of a list of portlets
	*/
	public boolean isStaticStart();

	/**
	* Set to <code>true</code> if the portlet is a static portlet at the start
	* of a list of portlets.
	*
	* @param staticPortletStart boolean value for whether the portlet is a
	static portlet at the start of a list of portlets
	*/
	public void setStaticStart(boolean staticPortletStart);

	/**
	* Returns <code>true</code> if the portlet is a static portlet at the end
	* of a list of portlets.
	*
	* @return <code>true</code> if the portlet is a static portlet at the end
	of a list of portlets
	*/
	public boolean getStaticEnd();

	/**
	* Returns <code>true</code> if the portlet is a static portlet at the end
	* of a list of portlets.
	*
	* @return <code>true</code> if the portlet is a static portlet at the end
	of a list of portlets
	*/
	public boolean isStaticEnd();

	/**
	* Returns <code>true</code> if the portlet is an undeployed portlet.
	*
	* @return <code>true</code> if the portlet is a placeholder of an
	undeployed portlet
	*/
	public boolean getUndeployedPortlet();

	/**
	* Returns <code>true</code> if the portlet is an undeployed portlet.
	*
	* @return <code>true</code> if the portlet is a placeholder of an
	undeployed portlet
	*/
	public boolean isUndeployedPortlet();

	/**
	* Set to <code>true</code> if the portlet is an undeployed portlet.
	*
	* @param undeployedPortlet boolean value for whether the portlet is an
	undeployed portlet
	*/
	public void setUndeployedPortlet(boolean undeployedPortlet);

	/**
	* Creates and returns a copy of this object.
	*
	* @return a copy of this object
	*/
	public java.lang.Object clone();

	/**
	* Compares this portlet to the specified object.
	*
	* @param portlet the portlet to compare this portlet against
	* @return the value 0 if the argument portlet is equal to this portlet; a
	value less than -1 if this portlet is less than the portlet
	argument; and 1 if this portlet is greater than the portlet
	argument
	*/
	public int compareTo(com.liferay.portal.model.Portlet portlet);

	/**
	* Checks whether this portlet is equal to the specified object.
	*
	* @param obj the object to compare this portlet against
	* @return <code>true</code> if the portlet is equal to the specified object
	*/
	public boolean equals(java.lang.Object obj);
}