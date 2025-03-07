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

package com.liferay.portal.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.AccountLocalService;
import com.liferay.portal.service.AccountService;
import com.liferay.portal.service.AddressLocalService;
import com.liferay.portal.service.AddressService;
import com.liferay.portal.service.BrowserTrackerLocalService;
import com.liferay.portal.service.ClassNameLocalService;
import com.liferay.portal.service.ClassNameService;
import com.liferay.portal.service.ClusterGroupLocalService;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.ContactLocalService;
import com.liferay.portal.service.ContactService;
import com.liferay.portal.service.CountryService;
import com.liferay.portal.service.EmailAddressLocalService;
import com.liferay.portal.service.EmailAddressService;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.GroupService;
import com.liferay.portal.service.ImageLocalService;
import com.liferay.portal.service.ImageService;
import com.liferay.portal.service.LayoutLocalService;
import com.liferay.portal.service.LayoutPrototypeLocalService;
import com.liferay.portal.service.LayoutPrototypeService;
import com.liferay.portal.service.LayoutService;
import com.liferay.portal.service.LayoutSetLocalService;
import com.liferay.portal.service.LayoutSetPrototypeLocalService;
import com.liferay.portal.service.LayoutSetPrototypeService;
import com.liferay.portal.service.LayoutSetService;
import com.liferay.portal.service.LayoutTemplateLocalService;
import com.liferay.portal.service.ListTypeService;
import com.liferay.portal.service.LockLocalService;
import com.liferay.portal.service.MembershipRequestLocalService;
import com.liferay.portal.service.MembershipRequestService;
import com.liferay.portal.service.OrgLaborLocalService;
import com.liferay.portal.service.OrgLaborService;
import com.liferay.portal.service.OrganizationLocalService;
import com.liferay.portal.service.OrganizationService;
import com.liferay.portal.service.PasswordPolicyLocalService;
import com.liferay.portal.service.PasswordPolicyRelLocalService;
import com.liferay.portal.service.PasswordPolicyService;
import com.liferay.portal.service.PasswordTrackerLocalService;
import com.liferay.portal.service.PermissionLocalService;
import com.liferay.portal.service.PermissionService;
import com.liferay.portal.service.PhoneLocalService;
import com.liferay.portal.service.PhoneService;
import com.liferay.portal.service.PluginSettingLocalService;
import com.liferay.portal.service.PluginSettingService;
import com.liferay.portal.service.PortalLocalService;
import com.liferay.portal.service.PortalService;
import com.liferay.portal.service.PortletItemLocalService;
import com.liferay.portal.service.PortletLocalService;
import com.liferay.portal.service.PortletPreferencesLocalService;
import com.liferay.portal.service.PortletPreferencesService;
import com.liferay.portal.service.PortletService;
import com.liferay.portal.service.QuartzLocalService;
import com.liferay.portal.service.RegionService;
import com.liferay.portal.service.ReleaseLocalService;
import com.liferay.portal.service.ResourceActionLocalService;
import com.liferay.portal.service.ResourceCodeLocalService;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourcePermissionLocalService;
import com.liferay.portal.service.ResourcePermissionService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.RoleLocalService;
import com.liferay.portal.service.RoleService;
import com.liferay.portal.service.ServiceComponentLocalService;
import com.liferay.portal.service.ShardLocalService;
import com.liferay.portal.service.SubscriptionLocalService;
import com.liferay.portal.service.TeamLocalService;
import com.liferay.portal.service.TeamService;
import com.liferay.portal.service.ThemeLocalService;
import com.liferay.portal.service.ThemeService;
import com.liferay.portal.service.TicketLocalService;
import com.liferay.portal.service.UserGroupGroupRoleLocalService;
import com.liferay.portal.service.UserGroupGroupRoleService;
import com.liferay.portal.service.UserGroupLocalService;
import com.liferay.portal.service.UserGroupRoleLocalService;
import com.liferay.portal.service.UserGroupRoleService;
import com.liferay.portal.service.UserGroupService;
import com.liferay.portal.service.UserIdMapperLocalService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.UserTrackerLocalService;
import com.liferay.portal.service.UserTrackerPathLocalService;
import com.liferay.portal.service.WebDAVPropsLocalService;
import com.liferay.portal.service.WebsiteLocalService;
import com.liferay.portal.service.WebsiteService;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.service.persistence.AccountPersistence;
import com.liferay.portal.service.persistence.AddressPersistence;
import com.liferay.portal.service.persistence.BrowserTrackerPersistence;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.ClusterGroupPersistence;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.ContactPersistence;
import com.liferay.portal.service.persistence.CountryPersistence;
import com.liferay.portal.service.persistence.EmailAddressPersistence;
import com.liferay.portal.service.persistence.GroupFinder;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.ImagePersistence;
import com.liferay.portal.service.persistence.LayoutFinder;
import com.liferay.portal.service.persistence.LayoutPersistence;
import com.liferay.portal.service.persistence.LayoutPrototypePersistence;
import com.liferay.portal.service.persistence.LayoutSetPersistence;
import com.liferay.portal.service.persistence.LayoutSetPrototypePersistence;
import com.liferay.portal.service.persistence.ListTypePersistence;
import com.liferay.portal.service.persistence.LockPersistence;
import com.liferay.portal.service.persistence.MembershipRequestPersistence;
import com.liferay.portal.service.persistence.OrgGroupPermissionFinder;
import com.liferay.portal.service.persistence.OrgGroupPermissionPersistence;
import com.liferay.portal.service.persistence.OrgGroupRolePersistence;
import com.liferay.portal.service.persistence.OrgLaborPersistence;
import com.liferay.portal.service.persistence.OrganizationFinder;
import com.liferay.portal.service.persistence.OrganizationPersistence;
import com.liferay.portal.service.persistence.PasswordPolicyFinder;
import com.liferay.portal.service.persistence.PasswordPolicyPersistence;
import com.liferay.portal.service.persistence.PasswordPolicyRelPersistence;
import com.liferay.portal.service.persistence.PasswordTrackerPersistence;
import com.liferay.portal.service.persistence.PermissionFinder;
import com.liferay.portal.service.persistence.PermissionPersistence;
import com.liferay.portal.service.persistence.PhonePersistence;
import com.liferay.portal.service.persistence.PluginSettingPersistence;
import com.liferay.portal.service.persistence.PortletItemPersistence;
import com.liferay.portal.service.persistence.PortletPersistence;
import com.liferay.portal.service.persistence.PortletPreferencesFinder;
import com.liferay.portal.service.persistence.PortletPreferencesPersistence;
import com.liferay.portal.service.persistence.RegionPersistence;
import com.liferay.portal.service.persistence.ReleasePersistence;
import com.liferay.portal.service.persistence.ResourceActionPersistence;
import com.liferay.portal.service.persistence.ResourceCodePersistence;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePermissionFinder;
import com.liferay.portal.service.persistence.ResourcePermissionPersistence;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.RoleFinder;
import com.liferay.portal.service.persistence.RolePersistence;
import com.liferay.portal.service.persistence.ServiceComponentPersistence;
import com.liferay.portal.service.persistence.ShardPersistence;
import com.liferay.portal.service.persistence.SubscriptionPersistence;
import com.liferay.portal.service.persistence.TeamFinder;
import com.liferay.portal.service.persistence.TeamPersistence;
import com.liferay.portal.service.persistence.TicketPersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserGroupFinder;
import com.liferay.portal.service.persistence.UserGroupGroupRolePersistence;
import com.liferay.portal.service.persistence.UserGroupPersistence;
import com.liferay.portal.service.persistence.UserGroupRoleFinder;
import com.liferay.portal.service.persistence.UserGroupRolePersistence;
import com.liferay.portal.service.persistence.UserIdMapperPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.UserTrackerPathPersistence;
import com.liferay.portal.service.persistence.UserTrackerPersistence;
import com.liferay.portal.service.persistence.WebDAVPropsPersistence;
import com.liferay.portal.service.persistence.WebsitePersistence;
import com.liferay.portal.service.persistence.WorkflowDefinitionLinkPersistence;
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;

import com.liferay.portlet.asset.service.AssetEntryLocalService;
import com.liferay.portlet.asset.service.AssetEntryService;
import com.liferay.portlet.asset.service.persistence.AssetEntryFinder;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.blogs.service.BlogsEntryLocalService;
import com.liferay.portlet.blogs.service.BlogsEntryService;
import com.liferay.portlet.blogs.service.BlogsStatsUserLocalService;
import com.liferay.portlet.blogs.service.persistence.BlogsEntryFinder;
import com.liferay.portlet.blogs.service.persistence.BlogsEntryPersistence;
import com.liferay.portlet.blogs.service.persistence.BlogsStatsUserFinder;
import com.liferay.portlet.blogs.service.persistence.BlogsStatsUserPersistence;
import com.liferay.portlet.bookmarks.service.BookmarksFolderLocalService;
import com.liferay.portlet.bookmarks.service.BookmarksFolderService;
import com.liferay.portlet.bookmarks.service.persistence.BookmarksFolderPersistence;
import com.liferay.portlet.calendar.service.CalEventLocalService;
import com.liferay.portlet.calendar.service.CalEventService;
import com.liferay.portlet.calendar.service.persistence.CalEventFinder;
import com.liferay.portlet.calendar.service.persistence.CalEventPersistence;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalService;
import com.liferay.portlet.documentlibrary.service.DLFolderService;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderFinder;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistence;
import com.liferay.portlet.imagegallery.service.IGFolderLocalService;
import com.liferay.portlet.imagegallery.service.IGFolderService;
import com.liferay.portlet.imagegallery.service.persistence.IGFolderPersistence;
import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleService;
import com.liferay.portlet.journal.service.JournalStructureLocalService;
import com.liferay.portlet.journal.service.JournalStructureService;
import com.liferay.portlet.journal.service.JournalTemplateLocalService;
import com.liferay.portlet.journal.service.JournalTemplateService;
import com.liferay.portlet.journal.service.persistence.JournalArticleFinder;
import com.liferay.portlet.journal.service.persistence.JournalArticlePersistence;
import com.liferay.portlet.journal.service.persistence.JournalStructureFinder;
import com.liferay.portlet.journal.service.persistence.JournalStructurePersistence;
import com.liferay.portlet.journal.service.persistence.JournalTemplateFinder;
import com.liferay.portlet.journal.service.persistence.JournalTemplatePersistence;
import com.liferay.portlet.messageboards.service.MBBanLocalService;
import com.liferay.portlet.messageboards.service.MBBanService;
import com.liferay.portlet.messageboards.service.MBCategoryLocalService;
import com.liferay.portlet.messageboards.service.MBCategoryService;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalService;
import com.liferay.portlet.messageboards.service.persistence.MBBanPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryFinder;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence;
import com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence;
import com.liferay.portlet.polls.service.PollsQuestionLocalService;
import com.liferay.portlet.polls.service.PollsQuestionService;
import com.liferay.portlet.polls.service.persistence.PollsQuestionPersistence;
import com.liferay.portlet.shopping.service.ShoppingCartLocalService;
import com.liferay.portlet.shopping.service.ShoppingCategoryLocalService;
import com.liferay.portlet.shopping.service.ShoppingCategoryService;
import com.liferay.portlet.shopping.service.ShoppingCouponLocalService;
import com.liferay.portlet.shopping.service.ShoppingCouponService;
import com.liferay.portlet.shopping.service.ShoppingOrderLocalService;
import com.liferay.portlet.shopping.service.ShoppingOrderService;
import com.liferay.portlet.shopping.service.persistence.ShoppingCartPersistence;
import com.liferay.portlet.shopping.service.persistence.ShoppingCategoryPersistence;
import com.liferay.portlet.shopping.service.persistence.ShoppingCouponFinder;
import com.liferay.portlet.shopping.service.persistence.ShoppingCouponPersistence;
import com.liferay.portlet.shopping.service.persistence.ShoppingOrderFinder;
import com.liferay.portlet.shopping.service.persistence.ShoppingOrderPersistence;
import com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionLocalService;
import com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionService;
import com.liferay.portlet.softwarecatalog.service.SCProductEntryLocalService;
import com.liferay.portlet.softwarecatalog.service.SCProductEntryService;
import com.liferay.portlet.softwarecatalog.service.persistence.SCFrameworkVersionPersistence;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductEntryPersistence;
import com.liferay.portlet.tasks.service.TasksProposalLocalService;
import com.liferay.portlet.tasks.service.TasksProposalService;
import com.liferay.portlet.tasks.service.persistence.TasksProposalFinder;
import com.liferay.portlet.tasks.service.persistence.TasksProposalPersistence;
import com.liferay.portlet.wiki.service.WikiNodeLocalService;
import com.liferay.portlet.wiki.service.WikiNodeService;
import com.liferay.portlet.wiki.service.persistence.WikiNodePersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the group remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.service.impl.GroupServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.portal.service.GroupServiceUtil} to access the group remote service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.service.impl.GroupServiceImpl
 * @see com.liferay.portal.service.GroupServiceUtil
 * @generated
 */
public abstract class GroupServiceBaseImpl extends PrincipalBean
	implements GroupService {
	/**
	 * Gets the account local service.
	 *
	 * @return the account local service
	 */
	public AccountLocalService getAccountLocalService() {
		return accountLocalService;
	}

	/**
	 * Sets the account local service.
	 *
	 * @param accountLocalService the account local service
	 */
	public void setAccountLocalService(AccountLocalService accountLocalService) {
		this.accountLocalService = accountLocalService;
	}

	/**
	 * Gets the account remote service.
	 *
	 * @return the account remote service
	 */
	public AccountService getAccountService() {
		return accountService;
	}

	/**
	 * Sets the account remote service.
	 *
	 * @param accountService the account remote service
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Gets the account persistence.
	 *
	 * @return the account persistence
	 */
	public AccountPersistence getAccountPersistence() {
		return accountPersistence;
	}

	/**
	 * Sets the account persistence.
	 *
	 * @param accountPersistence the account persistence
	 */
	public void setAccountPersistence(AccountPersistence accountPersistence) {
		this.accountPersistence = accountPersistence;
	}

	/**
	 * Gets the address local service.
	 *
	 * @return the address local service
	 */
	public AddressLocalService getAddressLocalService() {
		return addressLocalService;
	}

	/**
	 * Sets the address local service.
	 *
	 * @param addressLocalService the address local service
	 */
	public void setAddressLocalService(AddressLocalService addressLocalService) {
		this.addressLocalService = addressLocalService;
	}

	/**
	 * Gets the address remote service.
	 *
	 * @return the address remote service
	 */
	public AddressService getAddressService() {
		return addressService;
	}

	/**
	 * Sets the address remote service.
	 *
	 * @param addressService the address remote service
	 */
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Gets the address persistence.
	 *
	 * @return the address persistence
	 */
	public AddressPersistence getAddressPersistence() {
		return addressPersistence;
	}

	/**
	 * Sets the address persistence.
	 *
	 * @param addressPersistence the address persistence
	 */
	public void setAddressPersistence(AddressPersistence addressPersistence) {
		this.addressPersistence = addressPersistence;
	}

	/**
	 * Gets the browser tracker local service.
	 *
	 * @return the browser tracker local service
	 */
	public BrowserTrackerLocalService getBrowserTrackerLocalService() {
		return browserTrackerLocalService;
	}

	/**
	 * Sets the browser tracker local service.
	 *
	 * @param browserTrackerLocalService the browser tracker local service
	 */
	public void setBrowserTrackerLocalService(
		BrowserTrackerLocalService browserTrackerLocalService) {
		this.browserTrackerLocalService = browserTrackerLocalService;
	}

	/**
	 * Gets the browser tracker persistence.
	 *
	 * @return the browser tracker persistence
	 */
	public BrowserTrackerPersistence getBrowserTrackerPersistence() {
		return browserTrackerPersistence;
	}

	/**
	 * Sets the browser tracker persistence.
	 *
	 * @param browserTrackerPersistence the browser tracker persistence
	 */
	public void setBrowserTrackerPersistence(
		BrowserTrackerPersistence browserTrackerPersistence) {
		this.browserTrackerPersistence = browserTrackerPersistence;
	}

	/**
	 * Gets the class name local service.
	 *
	 * @return the class name local service
	 */
	public ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Gets the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Gets the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Gets the cluster group local service.
	 *
	 * @return the cluster group local service
	 */
	public ClusterGroupLocalService getClusterGroupLocalService() {
		return clusterGroupLocalService;
	}

	/**
	 * Sets the cluster group local service.
	 *
	 * @param clusterGroupLocalService the cluster group local service
	 */
	public void setClusterGroupLocalService(
		ClusterGroupLocalService clusterGroupLocalService) {
		this.clusterGroupLocalService = clusterGroupLocalService;
	}

	/**
	 * Gets the cluster group persistence.
	 *
	 * @return the cluster group persistence
	 */
	public ClusterGroupPersistence getClusterGroupPersistence() {
		return clusterGroupPersistence;
	}

	/**
	 * Sets the cluster group persistence.
	 *
	 * @param clusterGroupPersistence the cluster group persistence
	 */
	public void setClusterGroupPersistence(
		ClusterGroupPersistence clusterGroupPersistence) {
		this.clusterGroupPersistence = clusterGroupPersistence;
	}

	/**
	 * Gets the company local service.
	 *
	 * @return the company local service
	 */
	public CompanyLocalService getCompanyLocalService() {
		return companyLocalService;
	}

	/**
	 * Sets the company local service.
	 *
	 * @param companyLocalService the company local service
	 */
	public void setCompanyLocalService(CompanyLocalService companyLocalService) {
		this.companyLocalService = companyLocalService;
	}

	/**
	 * Gets the company remote service.
	 *
	 * @return the company remote service
	 */
	public CompanyService getCompanyService() {
		return companyService;
	}

	/**
	 * Sets the company remote service.
	 *
	 * @param companyService the company remote service
	 */
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * Gets the company persistence.
	 *
	 * @return the company persistence
	 */
	public CompanyPersistence getCompanyPersistence() {
		return companyPersistence;
	}

	/**
	 * Sets the company persistence.
	 *
	 * @param companyPersistence the company persistence
	 */
	public void setCompanyPersistence(CompanyPersistence companyPersistence) {
		this.companyPersistence = companyPersistence;
	}

	/**
	 * Gets the contact local service.
	 *
	 * @return the contact local service
	 */
	public ContactLocalService getContactLocalService() {
		return contactLocalService;
	}

	/**
	 * Sets the contact local service.
	 *
	 * @param contactLocalService the contact local service
	 */
	public void setContactLocalService(ContactLocalService contactLocalService) {
		this.contactLocalService = contactLocalService;
	}

	/**
	 * Gets the contact remote service.
	 *
	 * @return the contact remote service
	 */
	public ContactService getContactService() {
		return contactService;
	}

	/**
	 * Sets the contact remote service.
	 *
	 * @param contactService the contact remote service
	 */
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	/**
	 * Gets the contact persistence.
	 *
	 * @return the contact persistence
	 */
	public ContactPersistence getContactPersistence() {
		return contactPersistence;
	}

	/**
	 * Sets the contact persistence.
	 *
	 * @param contactPersistence the contact persistence
	 */
	public void setContactPersistence(ContactPersistence contactPersistence) {
		this.contactPersistence = contactPersistence;
	}

	/**
	 * Gets the country remote service.
	 *
	 * @return the country remote service
	 */
	public CountryService getCountryService() {
		return countryService;
	}

	/**
	 * Sets the country remote service.
	 *
	 * @param countryService the country remote service
	 */
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	/**
	 * Gets the country persistence.
	 *
	 * @return the country persistence
	 */
	public CountryPersistence getCountryPersistence() {
		return countryPersistence;
	}

	/**
	 * Sets the country persistence.
	 *
	 * @param countryPersistence the country persistence
	 */
	public void setCountryPersistence(CountryPersistence countryPersistence) {
		this.countryPersistence = countryPersistence;
	}

	/**
	 * Gets the email address local service.
	 *
	 * @return the email address local service
	 */
	public EmailAddressLocalService getEmailAddressLocalService() {
		return emailAddressLocalService;
	}

	/**
	 * Sets the email address local service.
	 *
	 * @param emailAddressLocalService the email address local service
	 */
	public void setEmailAddressLocalService(
		EmailAddressLocalService emailAddressLocalService) {
		this.emailAddressLocalService = emailAddressLocalService;
	}

	/**
	 * Gets the email address remote service.
	 *
	 * @return the email address remote service
	 */
	public EmailAddressService getEmailAddressService() {
		return emailAddressService;
	}

	/**
	 * Sets the email address remote service.
	 *
	 * @param emailAddressService the email address remote service
	 */
	public void setEmailAddressService(EmailAddressService emailAddressService) {
		this.emailAddressService = emailAddressService;
	}

	/**
	 * Gets the email address persistence.
	 *
	 * @return the email address persistence
	 */
	public EmailAddressPersistence getEmailAddressPersistence() {
		return emailAddressPersistence;
	}

	/**
	 * Sets the email address persistence.
	 *
	 * @param emailAddressPersistence the email address persistence
	 */
	public void setEmailAddressPersistence(
		EmailAddressPersistence emailAddressPersistence) {
		this.emailAddressPersistence = emailAddressPersistence;
	}

	/**
	 * Gets the group local service.
	 *
	 * @return the group local service
	 */
	public GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Gets the group remote service.
	 *
	 * @return the group remote service
	 */
	public GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Gets the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Gets the group finder.
	 *
	 * @return the group finder
	 */
	public GroupFinder getGroupFinder() {
		return groupFinder;
	}

	/**
	 * Sets the group finder.
	 *
	 * @param groupFinder the group finder
	 */
	public void setGroupFinder(GroupFinder groupFinder) {
		this.groupFinder = groupFinder;
	}

	/**
	 * Gets the image local service.
	 *
	 * @return the image local service
	 */
	public ImageLocalService getImageLocalService() {
		return imageLocalService;
	}

	/**
	 * Sets the image local service.
	 *
	 * @param imageLocalService the image local service
	 */
	public void setImageLocalService(ImageLocalService imageLocalService) {
		this.imageLocalService = imageLocalService;
	}

	/**
	 * Gets the image remote service.
	 *
	 * @return the image remote service
	 */
	public ImageService getImageService() {
		return imageService;
	}

	/**
	 * Sets the image remote service.
	 *
	 * @param imageService the image remote service
	 */
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	/**
	 * Gets the image persistence.
	 *
	 * @return the image persistence
	 */
	public ImagePersistence getImagePersistence() {
		return imagePersistence;
	}

	/**
	 * Sets the image persistence.
	 *
	 * @param imagePersistence the image persistence
	 */
	public void setImagePersistence(ImagePersistence imagePersistence) {
		this.imagePersistence = imagePersistence;
	}

	/**
	 * Gets the layout local service.
	 *
	 * @return the layout local service
	 */
	public LayoutLocalService getLayoutLocalService() {
		return layoutLocalService;
	}

	/**
	 * Sets the layout local service.
	 *
	 * @param layoutLocalService the layout local service
	 */
	public void setLayoutLocalService(LayoutLocalService layoutLocalService) {
		this.layoutLocalService = layoutLocalService;
	}

	/**
	 * Gets the layout remote service.
	 *
	 * @return the layout remote service
	 */
	public LayoutService getLayoutService() {
		return layoutService;
	}

	/**
	 * Sets the layout remote service.
	 *
	 * @param layoutService the layout remote service
	 */
	public void setLayoutService(LayoutService layoutService) {
		this.layoutService = layoutService;
	}

	/**
	 * Gets the layout persistence.
	 *
	 * @return the layout persistence
	 */
	public LayoutPersistence getLayoutPersistence() {
		return layoutPersistence;
	}

	/**
	 * Sets the layout persistence.
	 *
	 * @param layoutPersistence the layout persistence
	 */
	public void setLayoutPersistence(LayoutPersistence layoutPersistence) {
		this.layoutPersistence = layoutPersistence;
	}

	/**
	 * Gets the layout finder.
	 *
	 * @return the layout finder
	 */
	public LayoutFinder getLayoutFinder() {
		return layoutFinder;
	}

	/**
	 * Sets the layout finder.
	 *
	 * @param layoutFinder the layout finder
	 */
	public void setLayoutFinder(LayoutFinder layoutFinder) {
		this.layoutFinder = layoutFinder;
	}

	/**
	 * Gets the layout prototype local service.
	 *
	 * @return the layout prototype local service
	 */
	public LayoutPrototypeLocalService getLayoutPrototypeLocalService() {
		return layoutPrototypeLocalService;
	}

	/**
	 * Sets the layout prototype local service.
	 *
	 * @param layoutPrototypeLocalService the layout prototype local service
	 */
	public void setLayoutPrototypeLocalService(
		LayoutPrototypeLocalService layoutPrototypeLocalService) {
		this.layoutPrototypeLocalService = layoutPrototypeLocalService;
	}

	/**
	 * Gets the layout prototype remote service.
	 *
	 * @return the layout prototype remote service
	 */
	public LayoutPrototypeService getLayoutPrototypeService() {
		return layoutPrototypeService;
	}

	/**
	 * Sets the layout prototype remote service.
	 *
	 * @param layoutPrototypeService the layout prototype remote service
	 */
	public void setLayoutPrototypeService(
		LayoutPrototypeService layoutPrototypeService) {
		this.layoutPrototypeService = layoutPrototypeService;
	}

	/**
	 * Gets the layout prototype persistence.
	 *
	 * @return the layout prototype persistence
	 */
	public LayoutPrototypePersistence getLayoutPrototypePersistence() {
		return layoutPrototypePersistence;
	}

	/**
	 * Sets the layout prototype persistence.
	 *
	 * @param layoutPrototypePersistence the layout prototype persistence
	 */
	public void setLayoutPrototypePersistence(
		LayoutPrototypePersistence layoutPrototypePersistence) {
		this.layoutPrototypePersistence = layoutPrototypePersistence;
	}

	/**
	 * Gets the layout set local service.
	 *
	 * @return the layout set local service
	 */
	public LayoutSetLocalService getLayoutSetLocalService() {
		return layoutSetLocalService;
	}

	/**
	 * Sets the layout set local service.
	 *
	 * @param layoutSetLocalService the layout set local service
	 */
	public void setLayoutSetLocalService(
		LayoutSetLocalService layoutSetLocalService) {
		this.layoutSetLocalService = layoutSetLocalService;
	}

	/**
	 * Gets the layout set remote service.
	 *
	 * @return the layout set remote service
	 */
	public LayoutSetService getLayoutSetService() {
		return layoutSetService;
	}

	/**
	 * Sets the layout set remote service.
	 *
	 * @param layoutSetService the layout set remote service
	 */
	public void setLayoutSetService(LayoutSetService layoutSetService) {
		this.layoutSetService = layoutSetService;
	}

	/**
	 * Gets the layout set persistence.
	 *
	 * @return the layout set persistence
	 */
	public LayoutSetPersistence getLayoutSetPersistence() {
		return layoutSetPersistence;
	}

	/**
	 * Sets the layout set persistence.
	 *
	 * @param layoutSetPersistence the layout set persistence
	 */
	public void setLayoutSetPersistence(
		LayoutSetPersistence layoutSetPersistence) {
		this.layoutSetPersistence = layoutSetPersistence;
	}

	/**
	 * Gets the layout set prototype local service.
	 *
	 * @return the layout set prototype local service
	 */
	public LayoutSetPrototypeLocalService getLayoutSetPrototypeLocalService() {
		return layoutSetPrototypeLocalService;
	}

	/**
	 * Sets the layout set prototype local service.
	 *
	 * @param layoutSetPrototypeLocalService the layout set prototype local service
	 */
	public void setLayoutSetPrototypeLocalService(
		LayoutSetPrototypeLocalService layoutSetPrototypeLocalService) {
		this.layoutSetPrototypeLocalService = layoutSetPrototypeLocalService;
	}

	/**
	 * Gets the layout set prototype remote service.
	 *
	 * @return the layout set prototype remote service
	 */
	public LayoutSetPrototypeService getLayoutSetPrototypeService() {
		return layoutSetPrototypeService;
	}

	/**
	 * Sets the layout set prototype remote service.
	 *
	 * @param layoutSetPrototypeService the layout set prototype remote service
	 */
	public void setLayoutSetPrototypeService(
		LayoutSetPrototypeService layoutSetPrototypeService) {
		this.layoutSetPrototypeService = layoutSetPrototypeService;
	}

	/**
	 * Gets the layout set prototype persistence.
	 *
	 * @return the layout set prototype persistence
	 */
	public LayoutSetPrototypePersistence getLayoutSetPrototypePersistence() {
		return layoutSetPrototypePersistence;
	}

	/**
	 * Sets the layout set prototype persistence.
	 *
	 * @param layoutSetPrototypePersistence the layout set prototype persistence
	 */
	public void setLayoutSetPrototypePersistence(
		LayoutSetPrototypePersistence layoutSetPrototypePersistence) {
		this.layoutSetPrototypePersistence = layoutSetPrototypePersistence;
	}

	/**
	 * Gets the layout template local service.
	 *
	 * @return the layout template local service
	 */
	public LayoutTemplateLocalService getLayoutTemplateLocalService() {
		return layoutTemplateLocalService;
	}

	/**
	 * Sets the layout template local service.
	 *
	 * @param layoutTemplateLocalService the layout template local service
	 */
	public void setLayoutTemplateLocalService(
		LayoutTemplateLocalService layoutTemplateLocalService) {
		this.layoutTemplateLocalService = layoutTemplateLocalService;
	}

	/**
	 * Gets the list type remote service.
	 *
	 * @return the list type remote service
	 */
	public ListTypeService getListTypeService() {
		return listTypeService;
	}

	/**
	 * Sets the list type remote service.
	 *
	 * @param listTypeService the list type remote service
	 */
	public void setListTypeService(ListTypeService listTypeService) {
		this.listTypeService = listTypeService;
	}

	/**
	 * Gets the list type persistence.
	 *
	 * @return the list type persistence
	 */
	public ListTypePersistence getListTypePersistence() {
		return listTypePersistence;
	}

	/**
	 * Sets the list type persistence.
	 *
	 * @param listTypePersistence the list type persistence
	 */
	public void setListTypePersistence(ListTypePersistence listTypePersistence) {
		this.listTypePersistence = listTypePersistence;
	}

	/**
	 * Gets the lock local service.
	 *
	 * @return the lock local service
	 */
	public LockLocalService getLockLocalService() {
		return lockLocalService;
	}

	/**
	 * Sets the lock local service.
	 *
	 * @param lockLocalService the lock local service
	 */
	public void setLockLocalService(LockLocalService lockLocalService) {
		this.lockLocalService = lockLocalService;
	}

	/**
	 * Gets the lock persistence.
	 *
	 * @return the lock persistence
	 */
	public LockPersistence getLockPersistence() {
		return lockPersistence;
	}

	/**
	 * Sets the lock persistence.
	 *
	 * @param lockPersistence the lock persistence
	 */
	public void setLockPersistence(LockPersistence lockPersistence) {
		this.lockPersistence = lockPersistence;
	}

	/**
	 * Gets the membership request local service.
	 *
	 * @return the membership request local service
	 */
	public MembershipRequestLocalService getMembershipRequestLocalService() {
		return membershipRequestLocalService;
	}

	/**
	 * Sets the membership request local service.
	 *
	 * @param membershipRequestLocalService the membership request local service
	 */
	public void setMembershipRequestLocalService(
		MembershipRequestLocalService membershipRequestLocalService) {
		this.membershipRequestLocalService = membershipRequestLocalService;
	}

	/**
	 * Gets the membership request remote service.
	 *
	 * @return the membership request remote service
	 */
	public MembershipRequestService getMembershipRequestService() {
		return membershipRequestService;
	}

	/**
	 * Sets the membership request remote service.
	 *
	 * @param membershipRequestService the membership request remote service
	 */
	public void setMembershipRequestService(
		MembershipRequestService membershipRequestService) {
		this.membershipRequestService = membershipRequestService;
	}

	/**
	 * Gets the membership request persistence.
	 *
	 * @return the membership request persistence
	 */
	public MembershipRequestPersistence getMembershipRequestPersistence() {
		return membershipRequestPersistence;
	}

	/**
	 * Sets the membership request persistence.
	 *
	 * @param membershipRequestPersistence the membership request persistence
	 */
	public void setMembershipRequestPersistence(
		MembershipRequestPersistence membershipRequestPersistence) {
		this.membershipRequestPersistence = membershipRequestPersistence;
	}

	/**
	 * Gets the organization local service.
	 *
	 * @return the organization local service
	 */
	public OrganizationLocalService getOrganizationLocalService() {
		return organizationLocalService;
	}

	/**
	 * Sets the organization local service.
	 *
	 * @param organizationLocalService the organization local service
	 */
	public void setOrganizationLocalService(
		OrganizationLocalService organizationLocalService) {
		this.organizationLocalService = organizationLocalService;
	}

	/**
	 * Gets the organization remote service.
	 *
	 * @return the organization remote service
	 */
	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	/**
	 * Sets the organization remote service.
	 *
	 * @param organizationService the organization remote service
	 */
	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	/**
	 * Gets the organization persistence.
	 *
	 * @return the organization persistence
	 */
	public OrganizationPersistence getOrganizationPersistence() {
		return organizationPersistence;
	}

	/**
	 * Sets the organization persistence.
	 *
	 * @param organizationPersistence the organization persistence
	 */
	public void setOrganizationPersistence(
		OrganizationPersistence organizationPersistence) {
		this.organizationPersistence = organizationPersistence;
	}

	/**
	 * Gets the organization finder.
	 *
	 * @return the organization finder
	 */
	public OrganizationFinder getOrganizationFinder() {
		return organizationFinder;
	}

	/**
	 * Sets the organization finder.
	 *
	 * @param organizationFinder the organization finder
	 */
	public void setOrganizationFinder(OrganizationFinder organizationFinder) {
		this.organizationFinder = organizationFinder;
	}

	/**
	 * Gets the org group permission persistence.
	 *
	 * @return the org group permission persistence
	 */
	public OrgGroupPermissionPersistence getOrgGroupPermissionPersistence() {
		return orgGroupPermissionPersistence;
	}

	/**
	 * Sets the org group permission persistence.
	 *
	 * @param orgGroupPermissionPersistence the org group permission persistence
	 */
	public void setOrgGroupPermissionPersistence(
		OrgGroupPermissionPersistence orgGroupPermissionPersistence) {
		this.orgGroupPermissionPersistence = orgGroupPermissionPersistence;
	}

	/**
	 * Gets the org group permission finder.
	 *
	 * @return the org group permission finder
	 */
	public OrgGroupPermissionFinder getOrgGroupPermissionFinder() {
		return orgGroupPermissionFinder;
	}

	/**
	 * Sets the org group permission finder.
	 *
	 * @param orgGroupPermissionFinder the org group permission finder
	 */
	public void setOrgGroupPermissionFinder(
		OrgGroupPermissionFinder orgGroupPermissionFinder) {
		this.orgGroupPermissionFinder = orgGroupPermissionFinder;
	}

	/**
	 * Gets the org group role persistence.
	 *
	 * @return the org group role persistence
	 */
	public OrgGroupRolePersistence getOrgGroupRolePersistence() {
		return orgGroupRolePersistence;
	}

	/**
	 * Sets the org group role persistence.
	 *
	 * @param orgGroupRolePersistence the org group role persistence
	 */
	public void setOrgGroupRolePersistence(
		OrgGroupRolePersistence orgGroupRolePersistence) {
		this.orgGroupRolePersistence = orgGroupRolePersistence;
	}

	/**
	 * Gets the org labor local service.
	 *
	 * @return the org labor local service
	 */
	public OrgLaborLocalService getOrgLaborLocalService() {
		return orgLaborLocalService;
	}

	/**
	 * Sets the org labor local service.
	 *
	 * @param orgLaborLocalService the org labor local service
	 */
	public void setOrgLaborLocalService(
		OrgLaborLocalService orgLaborLocalService) {
		this.orgLaborLocalService = orgLaborLocalService;
	}

	/**
	 * Gets the org labor remote service.
	 *
	 * @return the org labor remote service
	 */
	public OrgLaborService getOrgLaborService() {
		return orgLaborService;
	}

	/**
	 * Sets the org labor remote service.
	 *
	 * @param orgLaborService the org labor remote service
	 */
	public void setOrgLaborService(OrgLaborService orgLaborService) {
		this.orgLaborService = orgLaborService;
	}

	/**
	 * Gets the org labor persistence.
	 *
	 * @return the org labor persistence
	 */
	public OrgLaborPersistence getOrgLaborPersistence() {
		return orgLaborPersistence;
	}

	/**
	 * Sets the org labor persistence.
	 *
	 * @param orgLaborPersistence the org labor persistence
	 */
	public void setOrgLaborPersistence(OrgLaborPersistence orgLaborPersistence) {
		this.orgLaborPersistence = orgLaborPersistence;
	}

	/**
	 * Gets the password policy local service.
	 *
	 * @return the password policy local service
	 */
	public PasswordPolicyLocalService getPasswordPolicyLocalService() {
		return passwordPolicyLocalService;
	}

	/**
	 * Sets the password policy local service.
	 *
	 * @param passwordPolicyLocalService the password policy local service
	 */
	public void setPasswordPolicyLocalService(
		PasswordPolicyLocalService passwordPolicyLocalService) {
		this.passwordPolicyLocalService = passwordPolicyLocalService;
	}

	/**
	 * Gets the password policy remote service.
	 *
	 * @return the password policy remote service
	 */
	public PasswordPolicyService getPasswordPolicyService() {
		return passwordPolicyService;
	}

	/**
	 * Sets the password policy remote service.
	 *
	 * @param passwordPolicyService the password policy remote service
	 */
	public void setPasswordPolicyService(
		PasswordPolicyService passwordPolicyService) {
		this.passwordPolicyService = passwordPolicyService;
	}

	/**
	 * Gets the password policy persistence.
	 *
	 * @return the password policy persistence
	 */
	public PasswordPolicyPersistence getPasswordPolicyPersistence() {
		return passwordPolicyPersistence;
	}

	/**
	 * Sets the password policy persistence.
	 *
	 * @param passwordPolicyPersistence the password policy persistence
	 */
	public void setPasswordPolicyPersistence(
		PasswordPolicyPersistence passwordPolicyPersistence) {
		this.passwordPolicyPersistence = passwordPolicyPersistence;
	}

	/**
	 * Gets the password policy finder.
	 *
	 * @return the password policy finder
	 */
	public PasswordPolicyFinder getPasswordPolicyFinder() {
		return passwordPolicyFinder;
	}

	/**
	 * Sets the password policy finder.
	 *
	 * @param passwordPolicyFinder the password policy finder
	 */
	public void setPasswordPolicyFinder(
		PasswordPolicyFinder passwordPolicyFinder) {
		this.passwordPolicyFinder = passwordPolicyFinder;
	}

	/**
	 * Gets the password policy rel local service.
	 *
	 * @return the password policy rel local service
	 */
	public PasswordPolicyRelLocalService getPasswordPolicyRelLocalService() {
		return passwordPolicyRelLocalService;
	}

	/**
	 * Sets the password policy rel local service.
	 *
	 * @param passwordPolicyRelLocalService the password policy rel local service
	 */
	public void setPasswordPolicyRelLocalService(
		PasswordPolicyRelLocalService passwordPolicyRelLocalService) {
		this.passwordPolicyRelLocalService = passwordPolicyRelLocalService;
	}

	/**
	 * Gets the password policy rel persistence.
	 *
	 * @return the password policy rel persistence
	 */
	public PasswordPolicyRelPersistence getPasswordPolicyRelPersistence() {
		return passwordPolicyRelPersistence;
	}

	/**
	 * Sets the password policy rel persistence.
	 *
	 * @param passwordPolicyRelPersistence the password policy rel persistence
	 */
	public void setPasswordPolicyRelPersistence(
		PasswordPolicyRelPersistence passwordPolicyRelPersistence) {
		this.passwordPolicyRelPersistence = passwordPolicyRelPersistence;
	}

	/**
	 * Gets the password tracker local service.
	 *
	 * @return the password tracker local service
	 */
	public PasswordTrackerLocalService getPasswordTrackerLocalService() {
		return passwordTrackerLocalService;
	}

	/**
	 * Sets the password tracker local service.
	 *
	 * @param passwordTrackerLocalService the password tracker local service
	 */
	public void setPasswordTrackerLocalService(
		PasswordTrackerLocalService passwordTrackerLocalService) {
		this.passwordTrackerLocalService = passwordTrackerLocalService;
	}

	/**
	 * Gets the password tracker persistence.
	 *
	 * @return the password tracker persistence
	 */
	public PasswordTrackerPersistence getPasswordTrackerPersistence() {
		return passwordTrackerPersistence;
	}

	/**
	 * Sets the password tracker persistence.
	 *
	 * @param passwordTrackerPersistence the password tracker persistence
	 */
	public void setPasswordTrackerPersistence(
		PasswordTrackerPersistence passwordTrackerPersistence) {
		this.passwordTrackerPersistence = passwordTrackerPersistence;
	}

	/**
	 * Gets the permission local service.
	 *
	 * @return the permission local service
	 */
	public PermissionLocalService getPermissionLocalService() {
		return permissionLocalService;
	}

	/**
	 * Sets the permission local service.
	 *
	 * @param permissionLocalService the permission local service
	 */
	public void setPermissionLocalService(
		PermissionLocalService permissionLocalService) {
		this.permissionLocalService = permissionLocalService;
	}

	/**
	 * Gets the permission remote service.
	 *
	 * @return the permission remote service
	 */
	public PermissionService getPermissionService() {
		return permissionService;
	}

	/**
	 * Sets the permission remote service.
	 *
	 * @param permissionService the permission remote service
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	/**
	 * Gets the permission persistence.
	 *
	 * @return the permission persistence
	 */
	public PermissionPersistence getPermissionPersistence() {
		return permissionPersistence;
	}

	/**
	 * Sets the permission persistence.
	 *
	 * @param permissionPersistence the permission persistence
	 */
	public void setPermissionPersistence(
		PermissionPersistence permissionPersistence) {
		this.permissionPersistence = permissionPersistence;
	}

	/**
	 * Gets the permission finder.
	 *
	 * @return the permission finder
	 */
	public PermissionFinder getPermissionFinder() {
		return permissionFinder;
	}

	/**
	 * Sets the permission finder.
	 *
	 * @param permissionFinder the permission finder
	 */
	public void setPermissionFinder(PermissionFinder permissionFinder) {
		this.permissionFinder = permissionFinder;
	}

	/**
	 * Gets the phone local service.
	 *
	 * @return the phone local service
	 */
	public PhoneLocalService getPhoneLocalService() {
		return phoneLocalService;
	}

	/**
	 * Sets the phone local service.
	 *
	 * @param phoneLocalService the phone local service
	 */
	public void setPhoneLocalService(PhoneLocalService phoneLocalService) {
		this.phoneLocalService = phoneLocalService;
	}

	/**
	 * Gets the phone remote service.
	 *
	 * @return the phone remote service
	 */
	public PhoneService getPhoneService() {
		return phoneService;
	}

	/**
	 * Sets the phone remote service.
	 *
	 * @param phoneService the phone remote service
	 */
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	/**
	 * Gets the phone persistence.
	 *
	 * @return the phone persistence
	 */
	public PhonePersistence getPhonePersistence() {
		return phonePersistence;
	}

	/**
	 * Sets the phone persistence.
	 *
	 * @param phonePersistence the phone persistence
	 */
	public void setPhonePersistence(PhonePersistence phonePersistence) {
		this.phonePersistence = phonePersistence;
	}

	/**
	 * Gets the plugin setting local service.
	 *
	 * @return the plugin setting local service
	 */
	public PluginSettingLocalService getPluginSettingLocalService() {
		return pluginSettingLocalService;
	}

	/**
	 * Sets the plugin setting local service.
	 *
	 * @param pluginSettingLocalService the plugin setting local service
	 */
	public void setPluginSettingLocalService(
		PluginSettingLocalService pluginSettingLocalService) {
		this.pluginSettingLocalService = pluginSettingLocalService;
	}

	/**
	 * Gets the plugin setting remote service.
	 *
	 * @return the plugin setting remote service
	 */
	public PluginSettingService getPluginSettingService() {
		return pluginSettingService;
	}

	/**
	 * Sets the plugin setting remote service.
	 *
	 * @param pluginSettingService the plugin setting remote service
	 */
	public void setPluginSettingService(
		PluginSettingService pluginSettingService) {
		this.pluginSettingService = pluginSettingService;
	}

	/**
	 * Gets the plugin setting persistence.
	 *
	 * @return the plugin setting persistence
	 */
	public PluginSettingPersistence getPluginSettingPersistence() {
		return pluginSettingPersistence;
	}

	/**
	 * Sets the plugin setting persistence.
	 *
	 * @param pluginSettingPersistence the plugin setting persistence
	 */
	public void setPluginSettingPersistence(
		PluginSettingPersistence pluginSettingPersistence) {
		this.pluginSettingPersistence = pluginSettingPersistence;
	}

	/**
	 * Gets the portal local service.
	 *
	 * @return the portal local service
	 */
	public PortalLocalService getPortalLocalService() {
		return portalLocalService;
	}

	/**
	 * Sets the portal local service.
	 *
	 * @param portalLocalService the portal local service
	 */
	public void setPortalLocalService(PortalLocalService portalLocalService) {
		this.portalLocalService = portalLocalService;
	}

	/**
	 * Gets the portal remote service.
	 *
	 * @return the portal remote service
	 */
	public PortalService getPortalService() {
		return portalService;
	}

	/**
	 * Sets the portal remote service.
	 *
	 * @param portalService the portal remote service
	 */
	public void setPortalService(PortalService portalService) {
		this.portalService = portalService;
	}

	/**
	 * Gets the portlet local service.
	 *
	 * @return the portlet local service
	 */
	public PortletLocalService getPortletLocalService() {
		return portletLocalService;
	}

	/**
	 * Sets the portlet local service.
	 *
	 * @param portletLocalService the portlet local service
	 */
	public void setPortletLocalService(PortletLocalService portletLocalService) {
		this.portletLocalService = portletLocalService;
	}

	/**
	 * Gets the portlet remote service.
	 *
	 * @return the portlet remote service
	 */
	public PortletService getPortletService() {
		return portletService;
	}

	/**
	 * Sets the portlet remote service.
	 *
	 * @param portletService the portlet remote service
	 */
	public void setPortletService(PortletService portletService) {
		this.portletService = portletService;
	}

	/**
	 * Gets the portlet persistence.
	 *
	 * @return the portlet persistence
	 */
	public PortletPersistence getPortletPersistence() {
		return portletPersistence;
	}

	/**
	 * Sets the portlet persistence.
	 *
	 * @param portletPersistence the portlet persistence
	 */
	public void setPortletPersistence(PortletPersistence portletPersistence) {
		this.portletPersistence = portletPersistence;
	}

	/**
	 * Gets the portlet item local service.
	 *
	 * @return the portlet item local service
	 */
	public PortletItemLocalService getPortletItemLocalService() {
		return portletItemLocalService;
	}

	/**
	 * Sets the portlet item local service.
	 *
	 * @param portletItemLocalService the portlet item local service
	 */
	public void setPortletItemLocalService(
		PortletItemLocalService portletItemLocalService) {
		this.portletItemLocalService = portletItemLocalService;
	}

	/**
	 * Gets the portlet item persistence.
	 *
	 * @return the portlet item persistence
	 */
	public PortletItemPersistence getPortletItemPersistence() {
		return portletItemPersistence;
	}

	/**
	 * Sets the portlet item persistence.
	 *
	 * @param portletItemPersistence the portlet item persistence
	 */
	public void setPortletItemPersistence(
		PortletItemPersistence portletItemPersistence) {
		this.portletItemPersistence = portletItemPersistence;
	}

	/**
	 * Gets the portlet preferences local service.
	 *
	 * @return the portlet preferences local service
	 */
	public PortletPreferencesLocalService getPortletPreferencesLocalService() {
		return portletPreferencesLocalService;
	}

	/**
	 * Sets the portlet preferences local service.
	 *
	 * @param portletPreferencesLocalService the portlet preferences local service
	 */
	public void setPortletPreferencesLocalService(
		PortletPreferencesLocalService portletPreferencesLocalService) {
		this.portletPreferencesLocalService = portletPreferencesLocalService;
	}

	/**
	 * Gets the portlet preferences remote service.
	 *
	 * @return the portlet preferences remote service
	 */
	public PortletPreferencesService getPortletPreferencesService() {
		return portletPreferencesService;
	}

	/**
	 * Sets the portlet preferences remote service.
	 *
	 * @param portletPreferencesService the portlet preferences remote service
	 */
	public void setPortletPreferencesService(
		PortletPreferencesService portletPreferencesService) {
		this.portletPreferencesService = portletPreferencesService;
	}

	/**
	 * Gets the portlet preferences persistence.
	 *
	 * @return the portlet preferences persistence
	 */
	public PortletPreferencesPersistence getPortletPreferencesPersistence() {
		return portletPreferencesPersistence;
	}

	/**
	 * Sets the portlet preferences persistence.
	 *
	 * @param portletPreferencesPersistence the portlet preferences persistence
	 */
	public void setPortletPreferencesPersistence(
		PortletPreferencesPersistence portletPreferencesPersistence) {
		this.portletPreferencesPersistence = portletPreferencesPersistence;
	}

	/**
	 * Gets the portlet preferences finder.
	 *
	 * @return the portlet preferences finder
	 */
	public PortletPreferencesFinder getPortletPreferencesFinder() {
		return portletPreferencesFinder;
	}

	/**
	 * Sets the portlet preferences finder.
	 *
	 * @param portletPreferencesFinder the portlet preferences finder
	 */
	public void setPortletPreferencesFinder(
		PortletPreferencesFinder portletPreferencesFinder) {
		this.portletPreferencesFinder = portletPreferencesFinder;
	}

	/**
	 * Gets the quartz local service.
	 *
	 * @return the quartz local service
	 */
	public QuartzLocalService getQuartzLocalService() {
		return quartzLocalService;
	}

	/**
	 * Sets the quartz local service.
	 *
	 * @param quartzLocalService the quartz local service
	 */
	public void setQuartzLocalService(QuartzLocalService quartzLocalService) {
		this.quartzLocalService = quartzLocalService;
	}

	/**
	 * Gets the region remote service.
	 *
	 * @return the region remote service
	 */
	public RegionService getRegionService() {
		return regionService;
	}

	/**
	 * Sets the region remote service.
	 *
	 * @param regionService the region remote service
	 */
	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	/**
	 * Gets the region persistence.
	 *
	 * @return the region persistence
	 */
	public RegionPersistence getRegionPersistence() {
		return regionPersistence;
	}

	/**
	 * Sets the region persistence.
	 *
	 * @param regionPersistence the region persistence
	 */
	public void setRegionPersistence(RegionPersistence regionPersistence) {
		this.regionPersistence = regionPersistence;
	}

	/**
	 * Gets the release local service.
	 *
	 * @return the release local service
	 */
	public ReleaseLocalService getReleaseLocalService() {
		return releaseLocalService;
	}

	/**
	 * Sets the release local service.
	 *
	 * @param releaseLocalService the release local service
	 */
	public void setReleaseLocalService(ReleaseLocalService releaseLocalService) {
		this.releaseLocalService = releaseLocalService;
	}

	/**
	 * Gets the release persistence.
	 *
	 * @return the release persistence
	 */
	public ReleasePersistence getReleasePersistence() {
		return releasePersistence;
	}

	/**
	 * Sets the release persistence.
	 *
	 * @param releasePersistence the release persistence
	 */
	public void setReleasePersistence(ReleasePersistence releasePersistence) {
		this.releasePersistence = releasePersistence;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the resource action local service.
	 *
	 * @return the resource action local service
	 */
	public ResourceActionLocalService getResourceActionLocalService() {
		return resourceActionLocalService;
	}

	/**
	 * Sets the resource action local service.
	 *
	 * @param resourceActionLocalService the resource action local service
	 */
	public void setResourceActionLocalService(
		ResourceActionLocalService resourceActionLocalService) {
		this.resourceActionLocalService = resourceActionLocalService;
	}

	/**
	 * Gets the resource action persistence.
	 *
	 * @return the resource action persistence
	 */
	public ResourceActionPersistence getResourceActionPersistence() {
		return resourceActionPersistence;
	}

	/**
	 * Sets the resource action persistence.
	 *
	 * @param resourceActionPersistence the resource action persistence
	 */
	public void setResourceActionPersistence(
		ResourceActionPersistence resourceActionPersistence) {
		this.resourceActionPersistence = resourceActionPersistence;
	}

	/**
	 * Gets the resource code local service.
	 *
	 * @return the resource code local service
	 */
	public ResourceCodeLocalService getResourceCodeLocalService() {
		return resourceCodeLocalService;
	}

	/**
	 * Sets the resource code local service.
	 *
	 * @param resourceCodeLocalService the resource code local service
	 */
	public void setResourceCodeLocalService(
		ResourceCodeLocalService resourceCodeLocalService) {
		this.resourceCodeLocalService = resourceCodeLocalService;
	}

	/**
	 * Gets the resource code persistence.
	 *
	 * @return the resource code persistence
	 */
	public ResourceCodePersistence getResourceCodePersistence() {
		return resourceCodePersistence;
	}

	/**
	 * Sets the resource code persistence.
	 *
	 * @param resourceCodePersistence the resource code persistence
	 */
	public void setResourceCodePersistence(
		ResourceCodePersistence resourceCodePersistence) {
		this.resourceCodePersistence = resourceCodePersistence;
	}

	/**
	 * Gets the resource permission local service.
	 *
	 * @return the resource permission local service
	 */
	public ResourcePermissionLocalService getResourcePermissionLocalService() {
		return resourcePermissionLocalService;
	}

	/**
	 * Sets the resource permission local service.
	 *
	 * @param resourcePermissionLocalService the resource permission local service
	 */
	public void setResourcePermissionLocalService(
		ResourcePermissionLocalService resourcePermissionLocalService) {
		this.resourcePermissionLocalService = resourcePermissionLocalService;
	}

	/**
	 * Gets the resource permission remote service.
	 *
	 * @return the resource permission remote service
	 */
	public ResourcePermissionService getResourcePermissionService() {
		return resourcePermissionService;
	}

	/**
	 * Sets the resource permission remote service.
	 *
	 * @param resourcePermissionService the resource permission remote service
	 */
	public void setResourcePermissionService(
		ResourcePermissionService resourcePermissionService) {
		this.resourcePermissionService = resourcePermissionService;
	}

	/**
	 * Gets the resource permission persistence.
	 *
	 * @return the resource permission persistence
	 */
	public ResourcePermissionPersistence getResourcePermissionPersistence() {
		return resourcePermissionPersistence;
	}

	/**
	 * Sets the resource permission persistence.
	 *
	 * @param resourcePermissionPersistence the resource permission persistence
	 */
	public void setResourcePermissionPersistence(
		ResourcePermissionPersistence resourcePermissionPersistence) {
		this.resourcePermissionPersistence = resourcePermissionPersistence;
	}

	/**
	 * Gets the resource permission finder.
	 *
	 * @return the resource permission finder
	 */
	public ResourcePermissionFinder getResourcePermissionFinder() {
		return resourcePermissionFinder;
	}

	/**
	 * Sets the resource permission finder.
	 *
	 * @param resourcePermissionFinder the resource permission finder
	 */
	public void setResourcePermissionFinder(
		ResourcePermissionFinder resourcePermissionFinder) {
		this.resourcePermissionFinder = resourcePermissionFinder;
	}

	/**
	 * Gets the role local service.
	 *
	 * @return the role local service
	 */
	public RoleLocalService getRoleLocalService() {
		return roleLocalService;
	}

	/**
	 * Sets the role local service.
	 *
	 * @param roleLocalService the role local service
	 */
	public void setRoleLocalService(RoleLocalService roleLocalService) {
		this.roleLocalService = roleLocalService;
	}

	/**
	 * Gets the role remote service.
	 *
	 * @return the role remote service
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * Sets the role remote service.
	 *
	 * @param roleService the role remote service
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * Gets the role persistence.
	 *
	 * @return the role persistence
	 */
	public RolePersistence getRolePersistence() {
		return rolePersistence;
	}

	/**
	 * Sets the role persistence.
	 *
	 * @param rolePersistence the role persistence
	 */
	public void setRolePersistence(RolePersistence rolePersistence) {
		this.rolePersistence = rolePersistence;
	}

	/**
	 * Gets the role finder.
	 *
	 * @return the role finder
	 */
	public RoleFinder getRoleFinder() {
		return roleFinder;
	}

	/**
	 * Sets the role finder.
	 *
	 * @param roleFinder the role finder
	 */
	public void setRoleFinder(RoleFinder roleFinder) {
		this.roleFinder = roleFinder;
	}

	/**
	 * Gets the service component local service.
	 *
	 * @return the service component local service
	 */
	public ServiceComponentLocalService getServiceComponentLocalService() {
		return serviceComponentLocalService;
	}

	/**
	 * Sets the service component local service.
	 *
	 * @param serviceComponentLocalService the service component local service
	 */
	public void setServiceComponentLocalService(
		ServiceComponentLocalService serviceComponentLocalService) {
		this.serviceComponentLocalService = serviceComponentLocalService;
	}

	/**
	 * Gets the service component persistence.
	 *
	 * @return the service component persistence
	 */
	public ServiceComponentPersistence getServiceComponentPersistence() {
		return serviceComponentPersistence;
	}

	/**
	 * Sets the service component persistence.
	 *
	 * @param serviceComponentPersistence the service component persistence
	 */
	public void setServiceComponentPersistence(
		ServiceComponentPersistence serviceComponentPersistence) {
		this.serviceComponentPersistence = serviceComponentPersistence;
	}

	/**
	 * Gets the shard local service.
	 *
	 * @return the shard local service
	 */
	public ShardLocalService getShardLocalService() {
		return shardLocalService;
	}

	/**
	 * Sets the shard local service.
	 *
	 * @param shardLocalService the shard local service
	 */
	public void setShardLocalService(ShardLocalService shardLocalService) {
		this.shardLocalService = shardLocalService;
	}

	/**
	 * Gets the shard persistence.
	 *
	 * @return the shard persistence
	 */
	public ShardPersistence getShardPersistence() {
		return shardPersistence;
	}

	/**
	 * Sets the shard persistence.
	 *
	 * @param shardPersistence the shard persistence
	 */
	public void setShardPersistence(ShardPersistence shardPersistence) {
		this.shardPersistence = shardPersistence;
	}

	/**
	 * Gets the subscription local service.
	 *
	 * @return the subscription local service
	 */
	public SubscriptionLocalService getSubscriptionLocalService() {
		return subscriptionLocalService;
	}

	/**
	 * Sets the subscription local service.
	 *
	 * @param subscriptionLocalService the subscription local service
	 */
	public void setSubscriptionLocalService(
		SubscriptionLocalService subscriptionLocalService) {
		this.subscriptionLocalService = subscriptionLocalService;
	}

	/**
	 * Gets the subscription persistence.
	 *
	 * @return the subscription persistence
	 */
	public SubscriptionPersistence getSubscriptionPersistence() {
		return subscriptionPersistence;
	}

	/**
	 * Sets the subscription persistence.
	 *
	 * @param subscriptionPersistence the subscription persistence
	 */
	public void setSubscriptionPersistence(
		SubscriptionPersistence subscriptionPersistence) {
		this.subscriptionPersistence = subscriptionPersistence;
	}

	/**
	 * Gets the ticket local service.
	 *
	 * @return the ticket local service
	 */
	public TicketLocalService getTicketLocalService() {
		return ticketLocalService;
	}

	/**
	 * Sets the ticket local service.
	 *
	 * @param ticketLocalService the ticket local service
	 */
	public void setTicketLocalService(TicketLocalService ticketLocalService) {
		this.ticketLocalService = ticketLocalService;
	}

	/**
	 * Gets the ticket persistence.
	 *
	 * @return the ticket persistence
	 */
	public TicketPersistence getTicketPersistence() {
		return ticketPersistence;
	}

	/**
	 * Sets the ticket persistence.
	 *
	 * @param ticketPersistence the ticket persistence
	 */
	public void setTicketPersistence(TicketPersistence ticketPersistence) {
		this.ticketPersistence = ticketPersistence;
	}

	/**
	 * Gets the team local service.
	 *
	 * @return the team local service
	 */
	public TeamLocalService getTeamLocalService() {
		return teamLocalService;
	}

	/**
	 * Sets the team local service.
	 *
	 * @param teamLocalService the team local service
	 */
	public void setTeamLocalService(TeamLocalService teamLocalService) {
		this.teamLocalService = teamLocalService;
	}

	/**
	 * Gets the team remote service.
	 *
	 * @return the team remote service
	 */
	public TeamService getTeamService() {
		return teamService;
	}

	/**
	 * Sets the team remote service.
	 *
	 * @param teamService the team remote service
	 */
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	/**
	 * Gets the team persistence.
	 *
	 * @return the team persistence
	 */
	public TeamPersistence getTeamPersistence() {
		return teamPersistence;
	}

	/**
	 * Sets the team persistence.
	 *
	 * @param teamPersistence the team persistence
	 */
	public void setTeamPersistence(TeamPersistence teamPersistence) {
		this.teamPersistence = teamPersistence;
	}

	/**
	 * Gets the team finder.
	 *
	 * @return the team finder
	 */
	public TeamFinder getTeamFinder() {
		return teamFinder;
	}

	/**
	 * Sets the team finder.
	 *
	 * @param teamFinder the team finder
	 */
	public void setTeamFinder(TeamFinder teamFinder) {
		this.teamFinder = teamFinder;
	}

	/**
	 * Gets the theme local service.
	 *
	 * @return the theme local service
	 */
	public ThemeLocalService getThemeLocalService() {
		return themeLocalService;
	}

	/**
	 * Sets the theme local service.
	 *
	 * @param themeLocalService the theme local service
	 */
	public void setThemeLocalService(ThemeLocalService themeLocalService) {
		this.themeLocalService = themeLocalService;
	}

	/**
	 * Gets the theme remote service.
	 *
	 * @return the theme remote service
	 */
	public ThemeService getThemeService() {
		return themeService;
	}

	/**
	 * Sets the theme remote service.
	 *
	 * @param themeService the theme remote service
	 */
	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Gets the user group local service.
	 *
	 * @return the user group local service
	 */
	public UserGroupLocalService getUserGroupLocalService() {
		return userGroupLocalService;
	}

	/**
	 * Sets the user group local service.
	 *
	 * @param userGroupLocalService the user group local service
	 */
	public void setUserGroupLocalService(
		UserGroupLocalService userGroupLocalService) {
		this.userGroupLocalService = userGroupLocalService;
	}

	/**
	 * Gets the user group remote service.
	 *
	 * @return the user group remote service
	 */
	public UserGroupService getUserGroupService() {
		return userGroupService;
	}

	/**
	 * Sets the user group remote service.
	 *
	 * @param userGroupService the user group remote service
	 */
	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	/**
	 * Gets the user group persistence.
	 *
	 * @return the user group persistence
	 */
	public UserGroupPersistence getUserGroupPersistence() {
		return userGroupPersistence;
	}

	/**
	 * Sets the user group persistence.
	 *
	 * @param userGroupPersistence the user group persistence
	 */
	public void setUserGroupPersistence(
		UserGroupPersistence userGroupPersistence) {
		this.userGroupPersistence = userGroupPersistence;
	}

	/**
	 * Gets the user group finder.
	 *
	 * @return the user group finder
	 */
	public UserGroupFinder getUserGroupFinder() {
		return userGroupFinder;
	}

	/**
	 * Sets the user group finder.
	 *
	 * @param userGroupFinder the user group finder
	 */
	public void setUserGroupFinder(UserGroupFinder userGroupFinder) {
		this.userGroupFinder = userGroupFinder;
	}

	/**
	 * Gets the user group group role local service.
	 *
	 * @return the user group group role local service
	 */
	public UserGroupGroupRoleLocalService getUserGroupGroupRoleLocalService() {
		return userGroupGroupRoleLocalService;
	}

	/**
	 * Sets the user group group role local service.
	 *
	 * @param userGroupGroupRoleLocalService the user group group role local service
	 */
	public void setUserGroupGroupRoleLocalService(
		UserGroupGroupRoleLocalService userGroupGroupRoleLocalService) {
		this.userGroupGroupRoleLocalService = userGroupGroupRoleLocalService;
	}

	/**
	 * Gets the user group group role remote service.
	 *
	 * @return the user group group role remote service
	 */
	public UserGroupGroupRoleService getUserGroupGroupRoleService() {
		return userGroupGroupRoleService;
	}

	/**
	 * Sets the user group group role remote service.
	 *
	 * @param userGroupGroupRoleService the user group group role remote service
	 */
	public void setUserGroupGroupRoleService(
		UserGroupGroupRoleService userGroupGroupRoleService) {
		this.userGroupGroupRoleService = userGroupGroupRoleService;
	}

	/**
	 * Gets the user group group role persistence.
	 *
	 * @return the user group group role persistence
	 */
	public UserGroupGroupRolePersistence getUserGroupGroupRolePersistence() {
		return userGroupGroupRolePersistence;
	}

	/**
	 * Sets the user group group role persistence.
	 *
	 * @param userGroupGroupRolePersistence the user group group role persistence
	 */
	public void setUserGroupGroupRolePersistence(
		UserGroupGroupRolePersistence userGroupGroupRolePersistence) {
		this.userGroupGroupRolePersistence = userGroupGroupRolePersistence;
	}

	/**
	 * Gets the user group role local service.
	 *
	 * @return the user group role local service
	 */
	public UserGroupRoleLocalService getUserGroupRoleLocalService() {
		return userGroupRoleLocalService;
	}

	/**
	 * Sets the user group role local service.
	 *
	 * @param userGroupRoleLocalService the user group role local service
	 */
	public void setUserGroupRoleLocalService(
		UserGroupRoleLocalService userGroupRoleLocalService) {
		this.userGroupRoleLocalService = userGroupRoleLocalService;
	}

	/**
	 * Gets the user group role remote service.
	 *
	 * @return the user group role remote service
	 */
	public UserGroupRoleService getUserGroupRoleService() {
		return userGroupRoleService;
	}

	/**
	 * Sets the user group role remote service.
	 *
	 * @param userGroupRoleService the user group role remote service
	 */
	public void setUserGroupRoleService(
		UserGroupRoleService userGroupRoleService) {
		this.userGroupRoleService = userGroupRoleService;
	}

	/**
	 * Gets the user group role persistence.
	 *
	 * @return the user group role persistence
	 */
	public UserGroupRolePersistence getUserGroupRolePersistence() {
		return userGroupRolePersistence;
	}

	/**
	 * Sets the user group role persistence.
	 *
	 * @param userGroupRolePersistence the user group role persistence
	 */
	public void setUserGroupRolePersistence(
		UserGroupRolePersistence userGroupRolePersistence) {
		this.userGroupRolePersistence = userGroupRolePersistence;
	}

	/**
	 * Gets the user group role finder.
	 *
	 * @return the user group role finder
	 */
	public UserGroupRoleFinder getUserGroupRoleFinder() {
		return userGroupRoleFinder;
	}

	/**
	 * Sets the user group role finder.
	 *
	 * @param userGroupRoleFinder the user group role finder
	 */
	public void setUserGroupRoleFinder(UserGroupRoleFinder userGroupRoleFinder) {
		this.userGroupRoleFinder = userGroupRoleFinder;
	}

	/**
	 * Gets the user id mapper local service.
	 *
	 * @return the user id mapper local service
	 */
	public UserIdMapperLocalService getUserIdMapperLocalService() {
		return userIdMapperLocalService;
	}

	/**
	 * Sets the user id mapper local service.
	 *
	 * @param userIdMapperLocalService the user id mapper local service
	 */
	public void setUserIdMapperLocalService(
		UserIdMapperLocalService userIdMapperLocalService) {
		this.userIdMapperLocalService = userIdMapperLocalService;
	}

	/**
	 * Gets the user id mapper persistence.
	 *
	 * @return the user id mapper persistence
	 */
	public UserIdMapperPersistence getUserIdMapperPersistence() {
		return userIdMapperPersistence;
	}

	/**
	 * Sets the user id mapper persistence.
	 *
	 * @param userIdMapperPersistence the user id mapper persistence
	 */
	public void setUserIdMapperPersistence(
		UserIdMapperPersistence userIdMapperPersistence) {
		this.userIdMapperPersistence = userIdMapperPersistence;
	}

	/**
	 * Gets the user tracker local service.
	 *
	 * @return the user tracker local service
	 */
	public UserTrackerLocalService getUserTrackerLocalService() {
		return userTrackerLocalService;
	}

	/**
	 * Sets the user tracker local service.
	 *
	 * @param userTrackerLocalService the user tracker local service
	 */
	public void setUserTrackerLocalService(
		UserTrackerLocalService userTrackerLocalService) {
		this.userTrackerLocalService = userTrackerLocalService;
	}

	/**
	 * Gets the user tracker persistence.
	 *
	 * @return the user tracker persistence
	 */
	public UserTrackerPersistence getUserTrackerPersistence() {
		return userTrackerPersistence;
	}

	/**
	 * Sets the user tracker persistence.
	 *
	 * @param userTrackerPersistence the user tracker persistence
	 */
	public void setUserTrackerPersistence(
		UserTrackerPersistence userTrackerPersistence) {
		this.userTrackerPersistence = userTrackerPersistence;
	}

	/**
	 * Gets the user tracker path local service.
	 *
	 * @return the user tracker path local service
	 */
	public UserTrackerPathLocalService getUserTrackerPathLocalService() {
		return userTrackerPathLocalService;
	}

	/**
	 * Sets the user tracker path local service.
	 *
	 * @param userTrackerPathLocalService the user tracker path local service
	 */
	public void setUserTrackerPathLocalService(
		UserTrackerPathLocalService userTrackerPathLocalService) {
		this.userTrackerPathLocalService = userTrackerPathLocalService;
	}

	/**
	 * Gets the user tracker path persistence.
	 *
	 * @return the user tracker path persistence
	 */
	public UserTrackerPathPersistence getUserTrackerPathPersistence() {
		return userTrackerPathPersistence;
	}

	/**
	 * Sets the user tracker path persistence.
	 *
	 * @param userTrackerPathPersistence the user tracker path persistence
	 */
	public void setUserTrackerPathPersistence(
		UserTrackerPathPersistence userTrackerPathPersistence) {
		this.userTrackerPathPersistence = userTrackerPathPersistence;
	}

	/**
	 * Gets the web d a v props local service.
	 *
	 * @return the web d a v props local service
	 */
	public WebDAVPropsLocalService getWebDAVPropsLocalService() {
		return webDAVPropsLocalService;
	}

	/**
	 * Sets the web d a v props local service.
	 *
	 * @param webDAVPropsLocalService the web d a v props local service
	 */
	public void setWebDAVPropsLocalService(
		WebDAVPropsLocalService webDAVPropsLocalService) {
		this.webDAVPropsLocalService = webDAVPropsLocalService;
	}

	/**
	 * Gets the web d a v props persistence.
	 *
	 * @return the web d a v props persistence
	 */
	public WebDAVPropsPersistence getWebDAVPropsPersistence() {
		return webDAVPropsPersistence;
	}

	/**
	 * Sets the web d a v props persistence.
	 *
	 * @param webDAVPropsPersistence the web d a v props persistence
	 */
	public void setWebDAVPropsPersistence(
		WebDAVPropsPersistence webDAVPropsPersistence) {
		this.webDAVPropsPersistence = webDAVPropsPersistence;
	}

	/**
	 * Gets the website local service.
	 *
	 * @return the website local service
	 */
	public WebsiteLocalService getWebsiteLocalService() {
		return websiteLocalService;
	}

	/**
	 * Sets the website local service.
	 *
	 * @param websiteLocalService the website local service
	 */
	public void setWebsiteLocalService(WebsiteLocalService websiteLocalService) {
		this.websiteLocalService = websiteLocalService;
	}

	/**
	 * Gets the website remote service.
	 *
	 * @return the website remote service
	 */
	public WebsiteService getWebsiteService() {
		return websiteService;
	}

	/**
	 * Sets the website remote service.
	 *
	 * @param websiteService the website remote service
	 */
	public void setWebsiteService(WebsiteService websiteService) {
		this.websiteService = websiteService;
	}

	/**
	 * Gets the website persistence.
	 *
	 * @return the website persistence
	 */
	public WebsitePersistence getWebsitePersistence() {
		return websitePersistence;
	}

	/**
	 * Sets the website persistence.
	 *
	 * @param websitePersistence the website persistence
	 */
	public void setWebsitePersistence(WebsitePersistence websitePersistence) {
		this.websitePersistence = websitePersistence;
	}

	/**
	 * Gets the workflow definition link local service.
	 *
	 * @return the workflow definition link local service
	 */
	public WorkflowDefinitionLinkLocalService getWorkflowDefinitionLinkLocalService() {
		return workflowDefinitionLinkLocalService;
	}

	/**
	 * Sets the workflow definition link local service.
	 *
	 * @param workflowDefinitionLinkLocalService the workflow definition link local service
	 */
	public void setWorkflowDefinitionLinkLocalService(
		WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService) {
		this.workflowDefinitionLinkLocalService = workflowDefinitionLinkLocalService;
	}

	/**
	 * Gets the workflow definition link persistence.
	 *
	 * @return the workflow definition link persistence
	 */
	public WorkflowDefinitionLinkPersistence getWorkflowDefinitionLinkPersistence() {
		return workflowDefinitionLinkPersistence;
	}

	/**
	 * Sets the workflow definition link persistence.
	 *
	 * @param workflowDefinitionLinkPersistence the workflow definition link persistence
	 */
	public void setWorkflowDefinitionLinkPersistence(
		WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence) {
		this.workflowDefinitionLinkPersistence = workflowDefinitionLinkPersistence;
	}

	/**
	 * Gets the workflow instance link local service.
	 *
	 * @return the workflow instance link local service
	 */
	public WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
		return workflowInstanceLinkLocalService;
	}

	/**
	 * Sets the workflow instance link local service.
	 *
	 * @param workflowInstanceLinkLocalService the workflow instance link local service
	 */
	public void setWorkflowInstanceLinkLocalService(
		WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
		this.workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
	}

	/**
	 * Gets the workflow instance link persistence.
	 *
	 * @return the workflow instance link persistence
	 */
	public WorkflowInstanceLinkPersistence getWorkflowInstanceLinkPersistence() {
		return workflowInstanceLinkPersistence;
	}

	/**
	 * Sets the workflow instance link persistence.
	 *
	 * @param workflowInstanceLinkPersistence the workflow instance link persistence
	 */
	public void setWorkflowInstanceLinkPersistence(
		WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {
		this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Gets the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Gets the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Gets the asset entry finder.
	 *
	 * @return the asset entry finder
	 */
	public AssetEntryFinder getAssetEntryFinder() {
		return assetEntryFinder;
	}

	/**
	 * Sets the asset entry finder.
	 *
	 * @param assetEntryFinder the asset entry finder
	 */
	public void setAssetEntryFinder(AssetEntryFinder assetEntryFinder) {
		this.assetEntryFinder = assetEntryFinder;
	}

	/**
	 * Gets the blogs entry local service.
	 *
	 * @return the blogs entry local service
	 */
	public BlogsEntryLocalService getBlogsEntryLocalService() {
		return blogsEntryLocalService;
	}

	/**
	 * Sets the blogs entry local service.
	 *
	 * @param blogsEntryLocalService the blogs entry local service
	 */
	public void setBlogsEntryLocalService(
		BlogsEntryLocalService blogsEntryLocalService) {
		this.blogsEntryLocalService = blogsEntryLocalService;
	}

	/**
	 * Gets the blogs entry remote service.
	 *
	 * @return the blogs entry remote service
	 */
	public BlogsEntryService getBlogsEntryService() {
		return blogsEntryService;
	}

	/**
	 * Sets the blogs entry remote service.
	 *
	 * @param blogsEntryService the blogs entry remote service
	 */
	public void setBlogsEntryService(BlogsEntryService blogsEntryService) {
		this.blogsEntryService = blogsEntryService;
	}

	/**
	 * Gets the blogs entry persistence.
	 *
	 * @return the blogs entry persistence
	 */
	public BlogsEntryPersistence getBlogsEntryPersistence() {
		return blogsEntryPersistence;
	}

	/**
	 * Sets the blogs entry persistence.
	 *
	 * @param blogsEntryPersistence the blogs entry persistence
	 */
	public void setBlogsEntryPersistence(
		BlogsEntryPersistence blogsEntryPersistence) {
		this.blogsEntryPersistence = blogsEntryPersistence;
	}

	/**
	 * Gets the blogs entry finder.
	 *
	 * @return the blogs entry finder
	 */
	public BlogsEntryFinder getBlogsEntryFinder() {
		return blogsEntryFinder;
	}

	/**
	 * Sets the blogs entry finder.
	 *
	 * @param blogsEntryFinder the blogs entry finder
	 */
	public void setBlogsEntryFinder(BlogsEntryFinder blogsEntryFinder) {
		this.blogsEntryFinder = blogsEntryFinder;
	}

	/**
	 * Gets the blogs stats user local service.
	 *
	 * @return the blogs stats user local service
	 */
	public BlogsStatsUserLocalService getBlogsStatsUserLocalService() {
		return blogsStatsUserLocalService;
	}

	/**
	 * Sets the blogs stats user local service.
	 *
	 * @param blogsStatsUserLocalService the blogs stats user local service
	 */
	public void setBlogsStatsUserLocalService(
		BlogsStatsUserLocalService blogsStatsUserLocalService) {
		this.blogsStatsUserLocalService = blogsStatsUserLocalService;
	}

	/**
	 * Gets the blogs stats user persistence.
	 *
	 * @return the blogs stats user persistence
	 */
	public BlogsStatsUserPersistence getBlogsStatsUserPersistence() {
		return blogsStatsUserPersistence;
	}

	/**
	 * Sets the blogs stats user persistence.
	 *
	 * @param blogsStatsUserPersistence the blogs stats user persistence
	 */
	public void setBlogsStatsUserPersistence(
		BlogsStatsUserPersistence blogsStatsUserPersistence) {
		this.blogsStatsUserPersistence = blogsStatsUserPersistence;
	}

	/**
	 * Gets the blogs stats user finder.
	 *
	 * @return the blogs stats user finder
	 */
	public BlogsStatsUserFinder getBlogsStatsUserFinder() {
		return blogsStatsUserFinder;
	}

	/**
	 * Sets the blogs stats user finder.
	 *
	 * @param blogsStatsUserFinder the blogs stats user finder
	 */
	public void setBlogsStatsUserFinder(
		BlogsStatsUserFinder blogsStatsUserFinder) {
		this.blogsStatsUserFinder = blogsStatsUserFinder;
	}

	/**
	 * Gets the bookmarks folder local service.
	 *
	 * @return the bookmarks folder local service
	 */
	public BookmarksFolderLocalService getBookmarksFolderLocalService() {
		return bookmarksFolderLocalService;
	}

	/**
	 * Sets the bookmarks folder local service.
	 *
	 * @param bookmarksFolderLocalService the bookmarks folder local service
	 */
	public void setBookmarksFolderLocalService(
		BookmarksFolderLocalService bookmarksFolderLocalService) {
		this.bookmarksFolderLocalService = bookmarksFolderLocalService;
	}

	/**
	 * Gets the bookmarks folder remote service.
	 *
	 * @return the bookmarks folder remote service
	 */
	public BookmarksFolderService getBookmarksFolderService() {
		return bookmarksFolderService;
	}

	/**
	 * Sets the bookmarks folder remote service.
	 *
	 * @param bookmarksFolderService the bookmarks folder remote service
	 */
	public void setBookmarksFolderService(
		BookmarksFolderService bookmarksFolderService) {
		this.bookmarksFolderService = bookmarksFolderService;
	}

	/**
	 * Gets the bookmarks folder persistence.
	 *
	 * @return the bookmarks folder persistence
	 */
	public BookmarksFolderPersistence getBookmarksFolderPersistence() {
		return bookmarksFolderPersistence;
	}

	/**
	 * Sets the bookmarks folder persistence.
	 *
	 * @param bookmarksFolderPersistence the bookmarks folder persistence
	 */
	public void setBookmarksFolderPersistence(
		BookmarksFolderPersistence bookmarksFolderPersistence) {
		this.bookmarksFolderPersistence = bookmarksFolderPersistence;
	}

	/**
	 * Gets the cal event local service.
	 *
	 * @return the cal event local service
	 */
	public CalEventLocalService getCalEventLocalService() {
		return calEventLocalService;
	}

	/**
	 * Sets the cal event local service.
	 *
	 * @param calEventLocalService the cal event local service
	 */
	public void setCalEventLocalService(
		CalEventLocalService calEventLocalService) {
		this.calEventLocalService = calEventLocalService;
	}

	/**
	 * Gets the cal event remote service.
	 *
	 * @return the cal event remote service
	 */
	public CalEventService getCalEventService() {
		return calEventService;
	}

	/**
	 * Sets the cal event remote service.
	 *
	 * @param calEventService the cal event remote service
	 */
	public void setCalEventService(CalEventService calEventService) {
		this.calEventService = calEventService;
	}

	/**
	 * Gets the cal event persistence.
	 *
	 * @return the cal event persistence
	 */
	public CalEventPersistence getCalEventPersistence() {
		return calEventPersistence;
	}

	/**
	 * Sets the cal event persistence.
	 *
	 * @param calEventPersistence the cal event persistence
	 */
	public void setCalEventPersistence(CalEventPersistence calEventPersistence) {
		this.calEventPersistence = calEventPersistence;
	}

	/**
	 * Gets the cal event finder.
	 *
	 * @return the cal event finder
	 */
	public CalEventFinder getCalEventFinder() {
		return calEventFinder;
	}

	/**
	 * Sets the cal event finder.
	 *
	 * @param calEventFinder the cal event finder
	 */
	public void setCalEventFinder(CalEventFinder calEventFinder) {
		this.calEventFinder = calEventFinder;
	}

	/**
	 * Gets the d l folder local service.
	 *
	 * @return the d l folder local service
	 */
	public DLFolderLocalService getDLFolderLocalService() {
		return dlFolderLocalService;
	}

	/**
	 * Sets the d l folder local service.
	 *
	 * @param dlFolderLocalService the d l folder local service
	 */
	public void setDLFolderLocalService(
		DLFolderLocalService dlFolderLocalService) {
		this.dlFolderLocalService = dlFolderLocalService;
	}

	/**
	 * Gets the d l folder remote service.
	 *
	 * @return the d l folder remote service
	 */
	public DLFolderService getDLFolderService() {
		return dlFolderService;
	}

	/**
	 * Sets the d l folder remote service.
	 *
	 * @param dlFolderService the d l folder remote service
	 */
	public void setDLFolderService(DLFolderService dlFolderService) {
		this.dlFolderService = dlFolderService;
	}

	/**
	 * Gets the d l folder persistence.
	 *
	 * @return the d l folder persistence
	 */
	public DLFolderPersistence getDLFolderPersistence() {
		return dlFolderPersistence;
	}

	/**
	 * Sets the d l folder persistence.
	 *
	 * @param dlFolderPersistence the d l folder persistence
	 */
	public void setDLFolderPersistence(DLFolderPersistence dlFolderPersistence) {
		this.dlFolderPersistence = dlFolderPersistence;
	}

	/**
	 * Gets the d l folder finder.
	 *
	 * @return the d l folder finder
	 */
	public DLFolderFinder getDLFolderFinder() {
		return dlFolderFinder;
	}

	/**
	 * Sets the d l folder finder.
	 *
	 * @param dlFolderFinder the d l folder finder
	 */
	public void setDLFolderFinder(DLFolderFinder dlFolderFinder) {
		this.dlFolderFinder = dlFolderFinder;
	}

	/**
	 * Gets the i g folder local service.
	 *
	 * @return the i g folder local service
	 */
	public IGFolderLocalService getIGFolderLocalService() {
		return igFolderLocalService;
	}

	/**
	 * Sets the i g folder local service.
	 *
	 * @param igFolderLocalService the i g folder local service
	 */
	public void setIGFolderLocalService(
		IGFolderLocalService igFolderLocalService) {
		this.igFolderLocalService = igFolderLocalService;
	}

	/**
	 * Gets the i g folder remote service.
	 *
	 * @return the i g folder remote service
	 */
	public IGFolderService getIGFolderService() {
		return igFolderService;
	}

	/**
	 * Sets the i g folder remote service.
	 *
	 * @param igFolderService the i g folder remote service
	 */
	public void setIGFolderService(IGFolderService igFolderService) {
		this.igFolderService = igFolderService;
	}

	/**
	 * Gets the i g folder persistence.
	 *
	 * @return the i g folder persistence
	 */
	public IGFolderPersistence getIGFolderPersistence() {
		return igFolderPersistence;
	}

	/**
	 * Sets the i g folder persistence.
	 *
	 * @param igFolderPersistence the i g folder persistence
	 */
	public void setIGFolderPersistence(IGFolderPersistence igFolderPersistence) {
		this.igFolderPersistence = igFolderPersistence;
	}

	/**
	 * Gets the journal article local service.
	 *
	 * @return the journal article local service
	 */
	public JournalArticleLocalService getJournalArticleLocalService() {
		return journalArticleLocalService;
	}

	/**
	 * Sets the journal article local service.
	 *
	 * @param journalArticleLocalService the journal article local service
	 */
	public void setJournalArticleLocalService(
		JournalArticleLocalService journalArticleLocalService) {
		this.journalArticleLocalService = journalArticleLocalService;
	}

	/**
	 * Gets the journal article remote service.
	 *
	 * @return the journal article remote service
	 */
	public JournalArticleService getJournalArticleService() {
		return journalArticleService;
	}

	/**
	 * Sets the journal article remote service.
	 *
	 * @param journalArticleService the journal article remote service
	 */
	public void setJournalArticleService(
		JournalArticleService journalArticleService) {
		this.journalArticleService = journalArticleService;
	}

	/**
	 * Gets the journal article persistence.
	 *
	 * @return the journal article persistence
	 */
	public JournalArticlePersistence getJournalArticlePersistence() {
		return journalArticlePersistence;
	}

	/**
	 * Sets the journal article persistence.
	 *
	 * @param journalArticlePersistence the journal article persistence
	 */
	public void setJournalArticlePersistence(
		JournalArticlePersistence journalArticlePersistence) {
		this.journalArticlePersistence = journalArticlePersistence;
	}

	/**
	 * Gets the journal article finder.
	 *
	 * @return the journal article finder
	 */
	public JournalArticleFinder getJournalArticleFinder() {
		return journalArticleFinder;
	}

	/**
	 * Sets the journal article finder.
	 *
	 * @param journalArticleFinder the journal article finder
	 */
	public void setJournalArticleFinder(
		JournalArticleFinder journalArticleFinder) {
		this.journalArticleFinder = journalArticleFinder;
	}

	/**
	 * Gets the journal structure local service.
	 *
	 * @return the journal structure local service
	 */
	public JournalStructureLocalService getJournalStructureLocalService() {
		return journalStructureLocalService;
	}

	/**
	 * Sets the journal structure local service.
	 *
	 * @param journalStructureLocalService the journal structure local service
	 */
	public void setJournalStructureLocalService(
		JournalStructureLocalService journalStructureLocalService) {
		this.journalStructureLocalService = journalStructureLocalService;
	}

	/**
	 * Gets the journal structure remote service.
	 *
	 * @return the journal structure remote service
	 */
	public JournalStructureService getJournalStructureService() {
		return journalStructureService;
	}

	/**
	 * Sets the journal structure remote service.
	 *
	 * @param journalStructureService the journal structure remote service
	 */
	public void setJournalStructureService(
		JournalStructureService journalStructureService) {
		this.journalStructureService = journalStructureService;
	}

	/**
	 * Gets the journal structure persistence.
	 *
	 * @return the journal structure persistence
	 */
	public JournalStructurePersistence getJournalStructurePersistence() {
		return journalStructurePersistence;
	}

	/**
	 * Sets the journal structure persistence.
	 *
	 * @param journalStructurePersistence the journal structure persistence
	 */
	public void setJournalStructurePersistence(
		JournalStructurePersistence journalStructurePersistence) {
		this.journalStructurePersistence = journalStructurePersistence;
	}

	/**
	 * Gets the journal structure finder.
	 *
	 * @return the journal structure finder
	 */
	public JournalStructureFinder getJournalStructureFinder() {
		return journalStructureFinder;
	}

	/**
	 * Sets the journal structure finder.
	 *
	 * @param journalStructureFinder the journal structure finder
	 */
	public void setJournalStructureFinder(
		JournalStructureFinder journalStructureFinder) {
		this.journalStructureFinder = journalStructureFinder;
	}

	/**
	 * Gets the journal template local service.
	 *
	 * @return the journal template local service
	 */
	public JournalTemplateLocalService getJournalTemplateLocalService() {
		return journalTemplateLocalService;
	}

	/**
	 * Sets the journal template local service.
	 *
	 * @param journalTemplateLocalService the journal template local service
	 */
	public void setJournalTemplateLocalService(
		JournalTemplateLocalService journalTemplateLocalService) {
		this.journalTemplateLocalService = journalTemplateLocalService;
	}

	/**
	 * Gets the journal template remote service.
	 *
	 * @return the journal template remote service
	 */
	public JournalTemplateService getJournalTemplateService() {
		return journalTemplateService;
	}

	/**
	 * Sets the journal template remote service.
	 *
	 * @param journalTemplateService the journal template remote service
	 */
	public void setJournalTemplateService(
		JournalTemplateService journalTemplateService) {
		this.journalTemplateService = journalTemplateService;
	}

	/**
	 * Gets the journal template persistence.
	 *
	 * @return the journal template persistence
	 */
	public JournalTemplatePersistence getJournalTemplatePersistence() {
		return journalTemplatePersistence;
	}

	/**
	 * Sets the journal template persistence.
	 *
	 * @param journalTemplatePersistence the journal template persistence
	 */
	public void setJournalTemplatePersistence(
		JournalTemplatePersistence journalTemplatePersistence) {
		this.journalTemplatePersistence = journalTemplatePersistence;
	}

	/**
	 * Gets the journal template finder.
	 *
	 * @return the journal template finder
	 */
	public JournalTemplateFinder getJournalTemplateFinder() {
		return journalTemplateFinder;
	}

	/**
	 * Sets the journal template finder.
	 *
	 * @param journalTemplateFinder the journal template finder
	 */
	public void setJournalTemplateFinder(
		JournalTemplateFinder journalTemplateFinder) {
		this.journalTemplateFinder = journalTemplateFinder;
	}

	/**
	 * Gets the message boards ban local service.
	 *
	 * @return the message boards ban local service
	 */
	public MBBanLocalService getMBBanLocalService() {
		return mbBanLocalService;
	}

	/**
	 * Sets the message boards ban local service.
	 *
	 * @param mbBanLocalService the message boards ban local service
	 */
	public void setMBBanLocalService(MBBanLocalService mbBanLocalService) {
		this.mbBanLocalService = mbBanLocalService;
	}

	/**
	 * Gets the message boards ban remote service.
	 *
	 * @return the message boards ban remote service
	 */
	public MBBanService getMBBanService() {
		return mbBanService;
	}

	/**
	 * Sets the message boards ban remote service.
	 *
	 * @param mbBanService the message boards ban remote service
	 */
	public void setMBBanService(MBBanService mbBanService) {
		this.mbBanService = mbBanService;
	}

	/**
	 * Gets the message boards ban persistence.
	 *
	 * @return the message boards ban persistence
	 */
	public MBBanPersistence getMBBanPersistence() {
		return mbBanPersistence;
	}

	/**
	 * Sets the message boards ban persistence.
	 *
	 * @param mbBanPersistence the message boards ban persistence
	 */
	public void setMBBanPersistence(MBBanPersistence mbBanPersistence) {
		this.mbBanPersistence = mbBanPersistence;
	}

	/**
	 * Gets the message boards category local service.
	 *
	 * @return the message boards category local service
	 */
	public MBCategoryLocalService getMBCategoryLocalService() {
		return mbCategoryLocalService;
	}

	/**
	 * Sets the message boards category local service.
	 *
	 * @param mbCategoryLocalService the message boards category local service
	 */
	public void setMBCategoryLocalService(
		MBCategoryLocalService mbCategoryLocalService) {
		this.mbCategoryLocalService = mbCategoryLocalService;
	}

	/**
	 * Gets the message boards category remote service.
	 *
	 * @return the message boards category remote service
	 */
	public MBCategoryService getMBCategoryService() {
		return mbCategoryService;
	}

	/**
	 * Sets the message boards category remote service.
	 *
	 * @param mbCategoryService the message boards category remote service
	 */
	public void setMBCategoryService(MBCategoryService mbCategoryService) {
		this.mbCategoryService = mbCategoryService;
	}

	/**
	 * Gets the message boards category persistence.
	 *
	 * @return the message boards category persistence
	 */
	public MBCategoryPersistence getMBCategoryPersistence() {
		return mbCategoryPersistence;
	}

	/**
	 * Sets the message boards category persistence.
	 *
	 * @param mbCategoryPersistence the message boards category persistence
	 */
	public void setMBCategoryPersistence(
		MBCategoryPersistence mbCategoryPersistence) {
		this.mbCategoryPersistence = mbCategoryPersistence;
	}

	/**
	 * Gets the message boards category finder.
	 *
	 * @return the message boards category finder
	 */
	public MBCategoryFinder getMBCategoryFinder() {
		return mbCategoryFinder;
	}

	/**
	 * Sets the message boards category finder.
	 *
	 * @param mbCategoryFinder the message boards category finder
	 */
	public void setMBCategoryFinder(MBCategoryFinder mbCategoryFinder) {
		this.mbCategoryFinder = mbCategoryFinder;
	}

	/**
	 * Gets the message boards stats user local service.
	 *
	 * @return the message boards stats user local service
	 */
	public MBStatsUserLocalService getMBStatsUserLocalService() {
		return mbStatsUserLocalService;
	}

	/**
	 * Sets the message boards stats user local service.
	 *
	 * @param mbStatsUserLocalService the message boards stats user local service
	 */
	public void setMBStatsUserLocalService(
		MBStatsUserLocalService mbStatsUserLocalService) {
		this.mbStatsUserLocalService = mbStatsUserLocalService;
	}

	/**
	 * Gets the message boards stats user persistence.
	 *
	 * @return the message boards stats user persistence
	 */
	public MBStatsUserPersistence getMBStatsUserPersistence() {
		return mbStatsUserPersistence;
	}

	/**
	 * Sets the message boards stats user persistence.
	 *
	 * @param mbStatsUserPersistence the message boards stats user persistence
	 */
	public void setMBStatsUserPersistence(
		MBStatsUserPersistence mbStatsUserPersistence) {
		this.mbStatsUserPersistence = mbStatsUserPersistence;
	}

	/**
	 * Gets the polls question local service.
	 *
	 * @return the polls question local service
	 */
	public PollsQuestionLocalService getPollsQuestionLocalService() {
		return pollsQuestionLocalService;
	}

	/**
	 * Sets the polls question local service.
	 *
	 * @param pollsQuestionLocalService the polls question local service
	 */
	public void setPollsQuestionLocalService(
		PollsQuestionLocalService pollsQuestionLocalService) {
		this.pollsQuestionLocalService = pollsQuestionLocalService;
	}

	/**
	 * Gets the polls question remote service.
	 *
	 * @return the polls question remote service
	 */
	public PollsQuestionService getPollsQuestionService() {
		return pollsQuestionService;
	}

	/**
	 * Sets the polls question remote service.
	 *
	 * @param pollsQuestionService the polls question remote service
	 */
	public void setPollsQuestionService(
		PollsQuestionService pollsQuestionService) {
		this.pollsQuestionService = pollsQuestionService;
	}

	/**
	 * Gets the polls question persistence.
	 *
	 * @return the polls question persistence
	 */
	public PollsQuestionPersistence getPollsQuestionPersistence() {
		return pollsQuestionPersistence;
	}

	/**
	 * Sets the polls question persistence.
	 *
	 * @param pollsQuestionPersistence the polls question persistence
	 */
	public void setPollsQuestionPersistence(
		PollsQuestionPersistence pollsQuestionPersistence) {
		this.pollsQuestionPersistence = pollsQuestionPersistence;
	}

	/**
	 * Gets the shopping cart local service.
	 *
	 * @return the shopping cart local service
	 */
	public ShoppingCartLocalService getShoppingCartLocalService() {
		return shoppingCartLocalService;
	}

	/**
	 * Sets the shopping cart local service.
	 *
	 * @param shoppingCartLocalService the shopping cart local service
	 */
	public void setShoppingCartLocalService(
		ShoppingCartLocalService shoppingCartLocalService) {
		this.shoppingCartLocalService = shoppingCartLocalService;
	}

	/**
	 * Gets the shopping cart persistence.
	 *
	 * @return the shopping cart persistence
	 */
	public ShoppingCartPersistence getShoppingCartPersistence() {
		return shoppingCartPersistence;
	}

	/**
	 * Sets the shopping cart persistence.
	 *
	 * @param shoppingCartPersistence the shopping cart persistence
	 */
	public void setShoppingCartPersistence(
		ShoppingCartPersistence shoppingCartPersistence) {
		this.shoppingCartPersistence = shoppingCartPersistence;
	}

	/**
	 * Gets the shopping category local service.
	 *
	 * @return the shopping category local service
	 */
	public ShoppingCategoryLocalService getShoppingCategoryLocalService() {
		return shoppingCategoryLocalService;
	}

	/**
	 * Sets the shopping category local service.
	 *
	 * @param shoppingCategoryLocalService the shopping category local service
	 */
	public void setShoppingCategoryLocalService(
		ShoppingCategoryLocalService shoppingCategoryLocalService) {
		this.shoppingCategoryLocalService = shoppingCategoryLocalService;
	}

	/**
	 * Gets the shopping category remote service.
	 *
	 * @return the shopping category remote service
	 */
	public ShoppingCategoryService getShoppingCategoryService() {
		return shoppingCategoryService;
	}

	/**
	 * Sets the shopping category remote service.
	 *
	 * @param shoppingCategoryService the shopping category remote service
	 */
	public void setShoppingCategoryService(
		ShoppingCategoryService shoppingCategoryService) {
		this.shoppingCategoryService = shoppingCategoryService;
	}

	/**
	 * Gets the shopping category persistence.
	 *
	 * @return the shopping category persistence
	 */
	public ShoppingCategoryPersistence getShoppingCategoryPersistence() {
		return shoppingCategoryPersistence;
	}

	/**
	 * Sets the shopping category persistence.
	 *
	 * @param shoppingCategoryPersistence the shopping category persistence
	 */
	public void setShoppingCategoryPersistence(
		ShoppingCategoryPersistence shoppingCategoryPersistence) {
		this.shoppingCategoryPersistence = shoppingCategoryPersistence;
	}

	/**
	 * Gets the shopping coupon local service.
	 *
	 * @return the shopping coupon local service
	 */
	public ShoppingCouponLocalService getShoppingCouponLocalService() {
		return shoppingCouponLocalService;
	}

	/**
	 * Sets the shopping coupon local service.
	 *
	 * @param shoppingCouponLocalService the shopping coupon local service
	 */
	public void setShoppingCouponLocalService(
		ShoppingCouponLocalService shoppingCouponLocalService) {
		this.shoppingCouponLocalService = shoppingCouponLocalService;
	}

	/**
	 * Gets the shopping coupon remote service.
	 *
	 * @return the shopping coupon remote service
	 */
	public ShoppingCouponService getShoppingCouponService() {
		return shoppingCouponService;
	}

	/**
	 * Sets the shopping coupon remote service.
	 *
	 * @param shoppingCouponService the shopping coupon remote service
	 */
	public void setShoppingCouponService(
		ShoppingCouponService shoppingCouponService) {
		this.shoppingCouponService = shoppingCouponService;
	}

	/**
	 * Gets the shopping coupon persistence.
	 *
	 * @return the shopping coupon persistence
	 */
	public ShoppingCouponPersistence getShoppingCouponPersistence() {
		return shoppingCouponPersistence;
	}

	/**
	 * Sets the shopping coupon persistence.
	 *
	 * @param shoppingCouponPersistence the shopping coupon persistence
	 */
	public void setShoppingCouponPersistence(
		ShoppingCouponPersistence shoppingCouponPersistence) {
		this.shoppingCouponPersistence = shoppingCouponPersistence;
	}

	/**
	 * Gets the shopping coupon finder.
	 *
	 * @return the shopping coupon finder
	 */
	public ShoppingCouponFinder getShoppingCouponFinder() {
		return shoppingCouponFinder;
	}

	/**
	 * Sets the shopping coupon finder.
	 *
	 * @param shoppingCouponFinder the shopping coupon finder
	 */
	public void setShoppingCouponFinder(
		ShoppingCouponFinder shoppingCouponFinder) {
		this.shoppingCouponFinder = shoppingCouponFinder;
	}

	/**
	 * Gets the shopping order local service.
	 *
	 * @return the shopping order local service
	 */
	public ShoppingOrderLocalService getShoppingOrderLocalService() {
		return shoppingOrderLocalService;
	}

	/**
	 * Sets the shopping order local service.
	 *
	 * @param shoppingOrderLocalService the shopping order local service
	 */
	public void setShoppingOrderLocalService(
		ShoppingOrderLocalService shoppingOrderLocalService) {
		this.shoppingOrderLocalService = shoppingOrderLocalService;
	}

	/**
	 * Gets the shopping order remote service.
	 *
	 * @return the shopping order remote service
	 */
	public ShoppingOrderService getShoppingOrderService() {
		return shoppingOrderService;
	}

	/**
	 * Sets the shopping order remote service.
	 *
	 * @param shoppingOrderService the shopping order remote service
	 */
	public void setShoppingOrderService(
		ShoppingOrderService shoppingOrderService) {
		this.shoppingOrderService = shoppingOrderService;
	}

	/**
	 * Gets the shopping order persistence.
	 *
	 * @return the shopping order persistence
	 */
	public ShoppingOrderPersistence getShoppingOrderPersistence() {
		return shoppingOrderPersistence;
	}

	/**
	 * Sets the shopping order persistence.
	 *
	 * @param shoppingOrderPersistence the shopping order persistence
	 */
	public void setShoppingOrderPersistence(
		ShoppingOrderPersistence shoppingOrderPersistence) {
		this.shoppingOrderPersistence = shoppingOrderPersistence;
	}

	/**
	 * Gets the shopping order finder.
	 *
	 * @return the shopping order finder
	 */
	public ShoppingOrderFinder getShoppingOrderFinder() {
		return shoppingOrderFinder;
	}

	/**
	 * Sets the shopping order finder.
	 *
	 * @param shoppingOrderFinder the shopping order finder
	 */
	public void setShoppingOrderFinder(ShoppingOrderFinder shoppingOrderFinder) {
		this.shoppingOrderFinder = shoppingOrderFinder;
	}

	/**
	 * Gets the s c framework version local service.
	 *
	 * @return the s c framework version local service
	 */
	public SCFrameworkVersionLocalService getSCFrameworkVersionLocalService() {
		return scFrameworkVersionLocalService;
	}

	/**
	 * Sets the s c framework version local service.
	 *
	 * @param scFrameworkVersionLocalService the s c framework version local service
	 */
	public void setSCFrameworkVersionLocalService(
		SCFrameworkVersionLocalService scFrameworkVersionLocalService) {
		this.scFrameworkVersionLocalService = scFrameworkVersionLocalService;
	}

	/**
	 * Gets the s c framework version remote service.
	 *
	 * @return the s c framework version remote service
	 */
	public SCFrameworkVersionService getSCFrameworkVersionService() {
		return scFrameworkVersionService;
	}

	/**
	 * Sets the s c framework version remote service.
	 *
	 * @param scFrameworkVersionService the s c framework version remote service
	 */
	public void setSCFrameworkVersionService(
		SCFrameworkVersionService scFrameworkVersionService) {
		this.scFrameworkVersionService = scFrameworkVersionService;
	}

	/**
	 * Gets the s c framework version persistence.
	 *
	 * @return the s c framework version persistence
	 */
	public SCFrameworkVersionPersistence getSCFrameworkVersionPersistence() {
		return scFrameworkVersionPersistence;
	}

	/**
	 * Sets the s c framework version persistence.
	 *
	 * @param scFrameworkVersionPersistence the s c framework version persistence
	 */
	public void setSCFrameworkVersionPersistence(
		SCFrameworkVersionPersistence scFrameworkVersionPersistence) {
		this.scFrameworkVersionPersistence = scFrameworkVersionPersistence;
	}

	/**
	 * Gets the s c product entry local service.
	 *
	 * @return the s c product entry local service
	 */
	public SCProductEntryLocalService getSCProductEntryLocalService() {
		return scProductEntryLocalService;
	}

	/**
	 * Sets the s c product entry local service.
	 *
	 * @param scProductEntryLocalService the s c product entry local service
	 */
	public void setSCProductEntryLocalService(
		SCProductEntryLocalService scProductEntryLocalService) {
		this.scProductEntryLocalService = scProductEntryLocalService;
	}

	/**
	 * Gets the s c product entry remote service.
	 *
	 * @return the s c product entry remote service
	 */
	public SCProductEntryService getSCProductEntryService() {
		return scProductEntryService;
	}

	/**
	 * Sets the s c product entry remote service.
	 *
	 * @param scProductEntryService the s c product entry remote service
	 */
	public void setSCProductEntryService(
		SCProductEntryService scProductEntryService) {
		this.scProductEntryService = scProductEntryService;
	}

	/**
	 * Gets the s c product entry persistence.
	 *
	 * @return the s c product entry persistence
	 */
	public SCProductEntryPersistence getSCProductEntryPersistence() {
		return scProductEntryPersistence;
	}

	/**
	 * Sets the s c product entry persistence.
	 *
	 * @param scProductEntryPersistence the s c product entry persistence
	 */
	public void setSCProductEntryPersistence(
		SCProductEntryPersistence scProductEntryPersistence) {
		this.scProductEntryPersistence = scProductEntryPersistence;
	}

	/**
	 * Gets the tasks proposal local service.
	 *
	 * @return the tasks proposal local service
	 */
	public TasksProposalLocalService getTasksProposalLocalService() {
		return tasksProposalLocalService;
	}

	/**
	 * Sets the tasks proposal local service.
	 *
	 * @param tasksProposalLocalService the tasks proposal local service
	 */
	public void setTasksProposalLocalService(
		TasksProposalLocalService tasksProposalLocalService) {
		this.tasksProposalLocalService = tasksProposalLocalService;
	}

	/**
	 * Gets the tasks proposal remote service.
	 *
	 * @return the tasks proposal remote service
	 */
	public TasksProposalService getTasksProposalService() {
		return tasksProposalService;
	}

	/**
	 * Sets the tasks proposal remote service.
	 *
	 * @param tasksProposalService the tasks proposal remote service
	 */
	public void setTasksProposalService(
		TasksProposalService tasksProposalService) {
		this.tasksProposalService = tasksProposalService;
	}

	/**
	 * Gets the tasks proposal persistence.
	 *
	 * @return the tasks proposal persistence
	 */
	public TasksProposalPersistence getTasksProposalPersistence() {
		return tasksProposalPersistence;
	}

	/**
	 * Sets the tasks proposal persistence.
	 *
	 * @param tasksProposalPersistence the tasks proposal persistence
	 */
	public void setTasksProposalPersistence(
		TasksProposalPersistence tasksProposalPersistence) {
		this.tasksProposalPersistence = tasksProposalPersistence;
	}

	/**
	 * Gets the tasks proposal finder.
	 *
	 * @return the tasks proposal finder
	 */
	public TasksProposalFinder getTasksProposalFinder() {
		return tasksProposalFinder;
	}

	/**
	 * Sets the tasks proposal finder.
	 *
	 * @param tasksProposalFinder the tasks proposal finder
	 */
	public void setTasksProposalFinder(TasksProposalFinder tasksProposalFinder) {
		this.tasksProposalFinder = tasksProposalFinder;
	}

	/**
	 * Gets the wiki node local service.
	 *
	 * @return the wiki node local service
	 */
	public WikiNodeLocalService getWikiNodeLocalService() {
		return wikiNodeLocalService;
	}

	/**
	 * Sets the wiki node local service.
	 *
	 * @param wikiNodeLocalService the wiki node local service
	 */
	public void setWikiNodeLocalService(
		WikiNodeLocalService wikiNodeLocalService) {
		this.wikiNodeLocalService = wikiNodeLocalService;
	}

	/**
	 * Gets the wiki node remote service.
	 *
	 * @return the wiki node remote service
	 */
	public WikiNodeService getWikiNodeService() {
		return wikiNodeService;
	}

	/**
	 * Sets the wiki node remote service.
	 *
	 * @param wikiNodeService the wiki node remote service
	 */
	public void setWikiNodeService(WikiNodeService wikiNodeService) {
		this.wikiNodeService = wikiNodeService;
	}

	/**
	 * Gets the wiki node persistence.
	 *
	 * @return the wiki node persistence
	 */
	public WikiNodePersistence getWikiNodePersistence() {
		return wikiNodePersistence;
	}

	/**
	 * Sets the wiki node persistence.
	 *
	 * @param wikiNodePersistence the wiki node persistence
	 */
	public void setWikiNodePersistence(WikiNodePersistence wikiNodePersistence) {
		this.wikiNodePersistence = wikiNodePersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = groupPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AccountLocalService.class)
	protected AccountLocalService accountLocalService;
	@BeanReference(type = AccountService.class)
	protected AccountService accountService;
	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;
	@BeanReference(type = AddressLocalService.class)
	protected AddressLocalService addressLocalService;
	@BeanReference(type = AddressService.class)
	protected AddressService addressService;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = BrowserTrackerLocalService.class)
	protected BrowserTrackerLocalService browserTrackerLocalService;
	@BeanReference(type = BrowserTrackerPersistence.class)
	protected BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(type = ClassNameLocalService.class)
	protected ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNameService.class)
	protected ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ClusterGroupLocalService.class)
	protected ClusterGroupLocalService clusterGroupLocalService;
	@BeanReference(type = ClusterGroupPersistence.class)
	protected ClusterGroupPersistence clusterGroupPersistence;
	@BeanReference(type = CompanyLocalService.class)
	protected CompanyLocalService companyLocalService;
	@BeanReference(type = CompanyService.class)
	protected CompanyService companyService;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = ContactLocalService.class)
	protected ContactLocalService contactLocalService;
	@BeanReference(type = ContactService.class)
	protected ContactService contactService;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = CountryService.class)
	protected CountryService countryService;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = EmailAddressLocalService.class)
	protected EmailAddressLocalService emailAddressLocalService;
	@BeanReference(type = EmailAddressService.class)
	protected EmailAddressService emailAddressService;
	@BeanReference(type = EmailAddressPersistence.class)
	protected EmailAddressPersistence emailAddressPersistence;
	@BeanReference(type = GroupLocalService.class)
	protected GroupLocalService groupLocalService;
	@BeanReference(type = GroupService.class)
	protected GroupService groupService;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = GroupFinder.class)
	protected GroupFinder groupFinder;
	@BeanReference(type = ImageLocalService.class)
	protected ImageLocalService imageLocalService;
	@BeanReference(type = ImageService.class)
	protected ImageService imageService;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = LayoutLocalService.class)
	protected LayoutLocalService layoutLocalService;
	@BeanReference(type = LayoutService.class)
	protected LayoutService layoutService;
	@BeanReference(type = LayoutPersistence.class)
	protected LayoutPersistence layoutPersistence;
	@BeanReference(type = LayoutFinder.class)
	protected LayoutFinder layoutFinder;
	@BeanReference(type = LayoutPrototypeLocalService.class)
	protected LayoutPrototypeLocalService layoutPrototypeLocalService;
	@BeanReference(type = LayoutPrototypeService.class)
	protected LayoutPrototypeService layoutPrototypeService;
	@BeanReference(type = LayoutPrototypePersistence.class)
	protected LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(type = LayoutSetLocalService.class)
	protected LayoutSetLocalService layoutSetLocalService;
	@BeanReference(type = LayoutSetService.class)
	protected LayoutSetService layoutSetService;
	@BeanReference(type = LayoutSetPersistence.class)
	protected LayoutSetPersistence layoutSetPersistence;
	@BeanReference(type = LayoutSetPrototypeLocalService.class)
	protected LayoutSetPrototypeLocalService layoutSetPrototypeLocalService;
	@BeanReference(type = LayoutSetPrototypeService.class)
	protected LayoutSetPrototypeService layoutSetPrototypeService;
	@BeanReference(type = LayoutSetPrototypePersistence.class)
	protected LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(type = LayoutTemplateLocalService.class)
	protected LayoutTemplateLocalService layoutTemplateLocalService;
	@BeanReference(type = ListTypeService.class)
	protected ListTypeService listTypeService;
	@BeanReference(type = ListTypePersistence.class)
	protected ListTypePersistence listTypePersistence;
	@BeanReference(type = LockLocalService.class)
	protected LockLocalService lockLocalService;
	@BeanReference(type = LockPersistence.class)
	protected LockPersistence lockPersistence;
	@BeanReference(type = MembershipRequestLocalService.class)
	protected MembershipRequestLocalService membershipRequestLocalService;
	@BeanReference(type = MembershipRequestService.class)
	protected MembershipRequestService membershipRequestService;
	@BeanReference(type = MembershipRequestPersistence.class)
	protected MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(type = OrganizationLocalService.class)
	protected OrganizationLocalService organizationLocalService;
	@BeanReference(type = OrganizationService.class)
	protected OrganizationService organizationService;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrganizationFinder.class)
	protected OrganizationFinder organizationFinder;
	@BeanReference(type = OrgGroupPermissionPersistence.class)
	protected OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(type = OrgGroupPermissionFinder.class)
	protected OrgGroupPermissionFinder orgGroupPermissionFinder;
	@BeanReference(type = OrgGroupRolePersistence.class)
	protected OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(type = OrgLaborLocalService.class)
	protected OrgLaborLocalService orgLaborLocalService;
	@BeanReference(type = OrgLaborService.class)
	protected OrgLaborService orgLaborService;
	@BeanReference(type = OrgLaborPersistence.class)
	protected OrgLaborPersistence orgLaborPersistence;
	@BeanReference(type = PasswordPolicyLocalService.class)
	protected PasswordPolicyLocalService passwordPolicyLocalService;
	@BeanReference(type = PasswordPolicyService.class)
	protected PasswordPolicyService passwordPolicyService;
	@BeanReference(type = PasswordPolicyPersistence.class)
	protected PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(type = PasswordPolicyFinder.class)
	protected PasswordPolicyFinder passwordPolicyFinder;
	@BeanReference(type = PasswordPolicyRelLocalService.class)
	protected PasswordPolicyRelLocalService passwordPolicyRelLocalService;
	@BeanReference(type = PasswordPolicyRelPersistence.class)
	protected PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(type = PasswordTrackerLocalService.class)
	protected PasswordTrackerLocalService passwordTrackerLocalService;
	@BeanReference(type = PasswordTrackerPersistence.class)
	protected PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(type = PermissionLocalService.class)
	protected PermissionLocalService permissionLocalService;
	@BeanReference(type = PermissionService.class)
	protected PermissionService permissionService;
	@BeanReference(type = PermissionPersistence.class)
	protected PermissionPersistence permissionPersistence;
	@BeanReference(type = PermissionFinder.class)
	protected PermissionFinder permissionFinder;
	@BeanReference(type = PhoneLocalService.class)
	protected PhoneLocalService phoneLocalService;
	@BeanReference(type = PhoneService.class)
	protected PhoneService phoneService;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = PluginSettingLocalService.class)
	protected PluginSettingLocalService pluginSettingLocalService;
	@BeanReference(type = PluginSettingService.class)
	protected PluginSettingService pluginSettingService;
	@BeanReference(type = PluginSettingPersistence.class)
	protected PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(type = PortalLocalService.class)
	protected PortalLocalService portalLocalService;
	@BeanReference(type = PortalService.class)
	protected PortalService portalService;
	@BeanReference(type = PortletLocalService.class)
	protected PortletLocalService portletLocalService;
	@BeanReference(type = PortletService.class)
	protected PortletService portletService;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = PortletItemLocalService.class)
	protected PortletItemLocalService portletItemLocalService;
	@BeanReference(type = PortletItemPersistence.class)
	protected PortletItemPersistence portletItemPersistence;
	@BeanReference(type = PortletPreferencesLocalService.class)
	protected PortletPreferencesLocalService portletPreferencesLocalService;
	@BeanReference(type = PortletPreferencesService.class)
	protected PortletPreferencesService portletPreferencesService;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = PortletPreferencesFinder.class)
	protected PortletPreferencesFinder portletPreferencesFinder;
	@BeanReference(type = QuartzLocalService.class)
	protected QuartzLocalService quartzLocalService;
	@BeanReference(type = RegionService.class)
	protected RegionService regionService;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
	@BeanReference(type = ReleaseLocalService.class)
	protected ReleaseLocalService releaseLocalService;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = ResourceActionLocalService.class)
	protected ResourceActionLocalService resourceActionLocalService;
	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;
	@BeanReference(type = ResourceCodeLocalService.class)
	protected ResourceCodeLocalService resourceCodeLocalService;
	@BeanReference(type = ResourceCodePersistence.class)
	protected ResourceCodePersistence resourceCodePersistence;
	@BeanReference(type = ResourcePermissionLocalService.class)
	protected ResourcePermissionLocalService resourcePermissionLocalService;
	@BeanReference(type = ResourcePermissionService.class)
	protected ResourcePermissionService resourcePermissionService;
	@BeanReference(type = ResourcePermissionPersistence.class)
	protected ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(type = ResourcePermissionFinder.class)
	protected ResourcePermissionFinder resourcePermissionFinder;
	@BeanReference(type = RoleLocalService.class)
	protected RoleLocalService roleLocalService;
	@BeanReference(type = RoleService.class)
	protected RoleService roleService;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = RoleFinder.class)
	protected RoleFinder roleFinder;
	@BeanReference(type = ServiceComponentLocalService.class)
	protected ServiceComponentLocalService serviceComponentLocalService;
	@BeanReference(type = ServiceComponentPersistence.class)
	protected ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(type = ShardLocalService.class)
	protected ShardLocalService shardLocalService;
	@BeanReference(type = ShardPersistence.class)
	protected ShardPersistence shardPersistence;
	@BeanReference(type = SubscriptionLocalService.class)
	protected SubscriptionLocalService subscriptionLocalService;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = TicketLocalService.class)
	protected TicketLocalService ticketLocalService;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = TeamLocalService.class)
	protected TeamLocalService teamLocalService;
	@BeanReference(type = TeamService.class)
	protected TeamService teamService;
	@BeanReference(type = TeamPersistence.class)
	protected TeamPersistence teamPersistence;
	@BeanReference(type = TeamFinder.class)
	protected TeamFinder teamFinder;
	@BeanReference(type = ThemeLocalService.class)
	protected ThemeLocalService themeLocalService;
	@BeanReference(type = ThemeService.class)
	protected ThemeService themeService;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	@BeanReference(type = UserGroupLocalService.class)
	protected UserGroupLocalService userGroupLocalService;
	@BeanReference(type = UserGroupService.class)
	protected UserGroupService userGroupService;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupFinder.class)
	protected UserGroupFinder userGroupFinder;
	@BeanReference(type = UserGroupGroupRoleLocalService.class)
	protected UserGroupGroupRoleLocalService userGroupGroupRoleLocalService;
	@BeanReference(type = UserGroupGroupRoleService.class)
	protected UserGroupGroupRoleService userGroupGroupRoleService;
	@BeanReference(type = UserGroupGroupRolePersistence.class)
	protected UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(type = UserGroupRoleLocalService.class)
	protected UserGroupRoleLocalService userGroupRoleLocalService;
	@BeanReference(type = UserGroupRoleService.class)
	protected UserGroupRoleService userGroupRoleService;
	@BeanReference(type = UserGroupRolePersistence.class)
	protected UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(type = UserGroupRoleFinder.class)
	protected UserGroupRoleFinder userGroupRoleFinder;
	@BeanReference(type = UserIdMapperLocalService.class)
	protected UserIdMapperLocalService userIdMapperLocalService;
	@BeanReference(type = UserIdMapperPersistence.class)
	protected UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(type = UserTrackerLocalService.class)
	protected UserTrackerLocalService userTrackerLocalService;
	@BeanReference(type = UserTrackerPersistence.class)
	protected UserTrackerPersistence userTrackerPersistence;
	@BeanReference(type = UserTrackerPathLocalService.class)
	protected UserTrackerPathLocalService userTrackerPathLocalService;
	@BeanReference(type = UserTrackerPathPersistence.class)
	protected UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(type = WebDAVPropsLocalService.class)
	protected WebDAVPropsLocalService webDAVPropsLocalService;
	@BeanReference(type = WebDAVPropsPersistence.class)
	protected WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(type = WebsiteLocalService.class)
	protected WebsiteLocalService websiteLocalService;
	@BeanReference(type = WebsiteService.class)
	protected WebsiteService websiteService;
	@BeanReference(type = WebsitePersistence.class)
	protected WebsitePersistence websitePersistence;
	@BeanReference(type = WorkflowDefinitionLinkLocalService.class)
	protected WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService;
	@BeanReference(type = WorkflowDefinitionLinkPersistence.class)
	protected WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(type = WorkflowInstanceLinkLocalService.class)
	protected WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = AssetEntryLocalService.class)
	protected AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = AssetEntryService.class)
	protected AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = AssetEntryFinder.class)
	protected AssetEntryFinder assetEntryFinder;
	@BeanReference(type = BlogsEntryLocalService.class)
	protected BlogsEntryLocalService blogsEntryLocalService;
	@BeanReference(type = BlogsEntryService.class)
	protected BlogsEntryService blogsEntryService;
	@BeanReference(type = BlogsEntryPersistence.class)
	protected BlogsEntryPersistence blogsEntryPersistence;
	@BeanReference(type = BlogsEntryFinder.class)
	protected BlogsEntryFinder blogsEntryFinder;
	@BeanReference(type = BlogsStatsUserLocalService.class)
	protected BlogsStatsUserLocalService blogsStatsUserLocalService;
	@BeanReference(type = BlogsStatsUserPersistence.class)
	protected BlogsStatsUserPersistence blogsStatsUserPersistence;
	@BeanReference(type = BlogsStatsUserFinder.class)
	protected BlogsStatsUserFinder blogsStatsUserFinder;
	@BeanReference(type = BookmarksFolderLocalService.class)
	protected BookmarksFolderLocalService bookmarksFolderLocalService;
	@BeanReference(type = BookmarksFolderService.class)
	protected BookmarksFolderService bookmarksFolderService;
	@BeanReference(type = BookmarksFolderPersistence.class)
	protected BookmarksFolderPersistence bookmarksFolderPersistence;
	@BeanReference(type = CalEventLocalService.class)
	protected CalEventLocalService calEventLocalService;
	@BeanReference(type = CalEventService.class)
	protected CalEventService calEventService;
	@BeanReference(type = CalEventPersistence.class)
	protected CalEventPersistence calEventPersistence;
	@BeanReference(type = CalEventFinder.class)
	protected CalEventFinder calEventFinder;
	@BeanReference(type = DLFolderLocalService.class)
	protected DLFolderLocalService dlFolderLocalService;
	@BeanReference(type = DLFolderService.class)
	protected DLFolderService dlFolderService;
	@BeanReference(type = DLFolderPersistence.class)
	protected DLFolderPersistence dlFolderPersistence;
	@BeanReference(type = DLFolderFinder.class)
	protected DLFolderFinder dlFolderFinder;
	@BeanReference(type = IGFolderLocalService.class)
	protected IGFolderLocalService igFolderLocalService;
	@BeanReference(type = IGFolderService.class)
	protected IGFolderService igFolderService;
	@BeanReference(type = IGFolderPersistence.class)
	protected IGFolderPersistence igFolderPersistence;
	@BeanReference(type = JournalArticleLocalService.class)
	protected JournalArticleLocalService journalArticleLocalService;
	@BeanReference(type = JournalArticleService.class)
	protected JournalArticleService journalArticleService;
	@BeanReference(type = JournalArticlePersistence.class)
	protected JournalArticlePersistence journalArticlePersistence;
	@BeanReference(type = JournalArticleFinder.class)
	protected JournalArticleFinder journalArticleFinder;
	@BeanReference(type = JournalStructureLocalService.class)
	protected JournalStructureLocalService journalStructureLocalService;
	@BeanReference(type = JournalStructureService.class)
	protected JournalStructureService journalStructureService;
	@BeanReference(type = JournalStructurePersistence.class)
	protected JournalStructurePersistence journalStructurePersistence;
	@BeanReference(type = JournalStructureFinder.class)
	protected JournalStructureFinder journalStructureFinder;
	@BeanReference(type = JournalTemplateLocalService.class)
	protected JournalTemplateLocalService journalTemplateLocalService;
	@BeanReference(type = JournalTemplateService.class)
	protected JournalTemplateService journalTemplateService;
	@BeanReference(type = JournalTemplatePersistence.class)
	protected JournalTemplatePersistence journalTemplatePersistence;
	@BeanReference(type = JournalTemplateFinder.class)
	protected JournalTemplateFinder journalTemplateFinder;
	@BeanReference(type = MBBanLocalService.class)
	protected MBBanLocalService mbBanLocalService;
	@BeanReference(type = MBBanService.class)
	protected MBBanService mbBanService;
	@BeanReference(type = MBBanPersistence.class)
	protected MBBanPersistence mbBanPersistence;
	@BeanReference(type = MBCategoryLocalService.class)
	protected MBCategoryLocalService mbCategoryLocalService;
	@BeanReference(type = MBCategoryService.class)
	protected MBCategoryService mbCategoryService;
	@BeanReference(type = MBCategoryPersistence.class)
	protected MBCategoryPersistence mbCategoryPersistence;
	@BeanReference(type = MBCategoryFinder.class)
	protected MBCategoryFinder mbCategoryFinder;
	@BeanReference(type = MBStatsUserLocalService.class)
	protected MBStatsUserLocalService mbStatsUserLocalService;
	@BeanReference(type = MBStatsUserPersistence.class)
	protected MBStatsUserPersistence mbStatsUserPersistence;
	@BeanReference(type = PollsQuestionLocalService.class)
	protected PollsQuestionLocalService pollsQuestionLocalService;
	@BeanReference(type = PollsQuestionService.class)
	protected PollsQuestionService pollsQuestionService;
	@BeanReference(type = PollsQuestionPersistence.class)
	protected PollsQuestionPersistence pollsQuestionPersistence;
	@BeanReference(type = ShoppingCartLocalService.class)
	protected ShoppingCartLocalService shoppingCartLocalService;
	@BeanReference(type = ShoppingCartPersistence.class)
	protected ShoppingCartPersistence shoppingCartPersistence;
	@BeanReference(type = ShoppingCategoryLocalService.class)
	protected ShoppingCategoryLocalService shoppingCategoryLocalService;
	@BeanReference(type = ShoppingCategoryService.class)
	protected ShoppingCategoryService shoppingCategoryService;
	@BeanReference(type = ShoppingCategoryPersistence.class)
	protected ShoppingCategoryPersistence shoppingCategoryPersistence;
	@BeanReference(type = ShoppingCouponLocalService.class)
	protected ShoppingCouponLocalService shoppingCouponLocalService;
	@BeanReference(type = ShoppingCouponService.class)
	protected ShoppingCouponService shoppingCouponService;
	@BeanReference(type = ShoppingCouponPersistence.class)
	protected ShoppingCouponPersistence shoppingCouponPersistence;
	@BeanReference(type = ShoppingCouponFinder.class)
	protected ShoppingCouponFinder shoppingCouponFinder;
	@BeanReference(type = ShoppingOrderLocalService.class)
	protected ShoppingOrderLocalService shoppingOrderLocalService;
	@BeanReference(type = ShoppingOrderService.class)
	protected ShoppingOrderService shoppingOrderService;
	@BeanReference(type = ShoppingOrderPersistence.class)
	protected ShoppingOrderPersistence shoppingOrderPersistence;
	@BeanReference(type = ShoppingOrderFinder.class)
	protected ShoppingOrderFinder shoppingOrderFinder;
	@BeanReference(type = SCFrameworkVersionLocalService.class)
	protected SCFrameworkVersionLocalService scFrameworkVersionLocalService;
	@BeanReference(type = SCFrameworkVersionService.class)
	protected SCFrameworkVersionService scFrameworkVersionService;
	@BeanReference(type = SCFrameworkVersionPersistence.class)
	protected SCFrameworkVersionPersistence scFrameworkVersionPersistence;
	@BeanReference(type = SCProductEntryLocalService.class)
	protected SCProductEntryLocalService scProductEntryLocalService;
	@BeanReference(type = SCProductEntryService.class)
	protected SCProductEntryService scProductEntryService;
	@BeanReference(type = SCProductEntryPersistence.class)
	protected SCProductEntryPersistence scProductEntryPersistence;
	@BeanReference(type = TasksProposalLocalService.class)
	protected TasksProposalLocalService tasksProposalLocalService;
	@BeanReference(type = TasksProposalService.class)
	protected TasksProposalService tasksProposalService;
	@BeanReference(type = TasksProposalPersistence.class)
	protected TasksProposalPersistence tasksProposalPersistence;
	@BeanReference(type = TasksProposalFinder.class)
	protected TasksProposalFinder tasksProposalFinder;
	@BeanReference(type = WikiNodeLocalService.class)
	protected WikiNodeLocalService wikiNodeLocalService;
	@BeanReference(type = WikiNodeService.class)
	protected WikiNodeService wikiNodeService;
	@BeanReference(type = WikiNodePersistence.class)
	protected WikiNodePersistence wikiNodePersistence;
}