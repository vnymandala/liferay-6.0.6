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

package com.liferay.portal.service.persistence;

import com.liferay.counter.service.persistence.CounterPersistenceTest;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsDeliveryPersistenceTest;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsEntryPersistenceTest;
import com.liferay.portlet.announcements.service.persistence.AnnouncementsFlagPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetCategoryPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetCategoryPropertyPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetEntryPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetTagPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetTagPropertyPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetTagStatsPersistenceTest;
import com.liferay.portlet.asset.service.persistence.AssetVocabularyPersistenceTest;
import com.liferay.portlet.blogs.service.persistence.BlogsEntryPersistenceTest;
import com.liferay.portlet.blogs.service.persistence.BlogsStatsUserPersistenceTest;
import com.liferay.portlet.bookmarks.service.persistence.BookmarksEntryPersistenceTest;
import com.liferay.portlet.bookmarks.service.persistence.BookmarksFolderPersistenceTest;
import com.liferay.portlet.calendar.service.persistence.CalEventPersistenceTest;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryPersistenceTest;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileRankPersistenceTest;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileShortcutPersistenceTest;
import com.liferay.portlet.documentlibrary.service.persistence.DLFileVersionPersistenceTest;
import com.liferay.portlet.documentlibrary.service.persistence.DLFolderPersistenceTest;
import com.liferay.portlet.expando.service.persistence.ExpandoColumnPersistenceTest;
import com.liferay.portlet.expando.service.persistence.ExpandoRowPersistenceTest;
import com.liferay.portlet.expando.service.persistence.ExpandoTablePersistenceTest;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistenceTest;
import com.liferay.portlet.imagegallery.service.persistence.IGFolderPersistenceTest;
import com.liferay.portlet.imagegallery.service.persistence.IGImagePersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalArticleImagePersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalArticlePersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalArticleResourcePersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalContentSearchPersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalFeedPersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalStructurePersistenceTest;
import com.liferay.portlet.journal.service.persistence.JournalTemplatePersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBBanPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBMessagePersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistenceTest;
import com.liferay.portlet.messageboards.service.persistence.MBThreadPersistenceTest;
import com.liferay.portlet.polls.service.persistence.PollsChoicePersistenceTest;
import com.liferay.portlet.polls.service.persistence.PollsQuestionPersistenceTest;
import com.liferay.portlet.polls.service.persistence.PollsVotePersistenceTest;
import com.liferay.portlet.ratings.service.persistence.RatingsEntryPersistenceTest;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingCartPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingCategoryPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingCouponPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingItemFieldPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingItemPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingItemPricePersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingOrderItemPersistenceTest;
import com.liferay.portlet.shopping.service.persistence.ShoppingOrderPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialActivityPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquityAssetEntryPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquityGroupSettingPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquityHistoryPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquityLogPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquitySettingPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialEquityUserPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialRelationPersistenceTest;
import com.liferay.portlet.social.service.persistence.SocialRequestPersistenceTest;
import com.liferay.portlet.softwarecatalog.service.persistence.SCFrameworkVersionPersistenceTest;
import com.liferay.portlet.softwarecatalog.service.persistence.SCLicensePersistenceTest;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductEntryPersistenceTest;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductScreenshotPersistenceTest;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductVersionPersistenceTest;
import com.liferay.portlet.tasks.service.persistence.TasksProposalPersistenceTest;
import com.liferay.portlet.tasks.service.persistence.TasksReviewPersistenceTest;
import com.liferay.portlet.wiki.service.persistence.WikiNodePersistenceTest;
import com.liferay.portlet.wiki.service.persistence.WikiPagePersistenceTest;
import com.liferay.portlet.wiki.service.persistence.WikiPageResourcePersistenceTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class PersistenceTestSuite extends TestSuite {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(CounterPersistenceTest.class);

		testSuite.addTestSuite(AccountPersistenceTest.class);
		testSuite.addTestSuite(AddressPersistenceTest.class);
		testSuite.addTestSuite(BrowserTrackerPersistenceTest.class);
		testSuite.addTestSuite(ClassNamePersistenceTest.class);
		testSuite.addTestSuite(ClusterGroupPersistenceTest.class);
		testSuite.addTestSuite(CompanyPersistenceTest.class);
		testSuite.addTestSuite(ContactPersistenceTest.class);
		testSuite.addTestSuite(CountryPersistenceTest.class);
		testSuite.addTestSuite(EmailAddressPersistenceTest.class);
		testSuite.addTestSuite(GroupPersistenceTest.class);
		testSuite.addTestSuite(ImagePersistenceTest.class);
		testSuite.addTestSuite(LayoutPersistenceTest.class);
		testSuite.addTestSuite(LayoutPrototypePersistenceTest.class);
		testSuite.addTestSuite(LayoutSetPersistenceTest.class);
		testSuite.addTestSuite(LayoutSetPrototypePersistenceTest.class);
		testSuite.addTestSuite(ListTypePersistenceTest.class);
		testSuite.addTestSuite(LockPersistenceTest.class);
		testSuite.addTestSuite(MembershipRequestPersistenceTest.class);
		testSuite.addTestSuite(OrganizationPersistenceTest.class);
		testSuite.addTestSuite(OrgGroupPermissionPersistenceTest.class);
		testSuite.addTestSuite(OrgGroupRolePersistenceTest.class);
		testSuite.addTestSuite(OrgLaborPersistenceTest.class);
		testSuite.addTestSuite(PasswordPolicyPersistenceTest.class);
		testSuite.addTestSuite(PasswordPolicyRelPersistenceTest.class);
		testSuite.addTestSuite(PasswordTrackerPersistenceTest.class);
		testSuite.addTestSuite(PermissionPersistenceTest.class);
		testSuite.addTestSuite(PhonePersistenceTest.class);
		testSuite.addTestSuite(PluginSettingPersistenceTest.class);
		testSuite.addTestSuite(PortletItemPersistenceTest.class);
		testSuite.addTestSuite(PortletPersistenceTest.class);
		testSuite.addTestSuite(PortletPreferencesPersistenceTest.class);
		testSuite.addTestSuite(RegionPersistenceTest.class);
		testSuite.addTestSuite(ReleasePersistenceTest.class);
		testSuite.addTestSuite(ResourceActionPersistenceTest.class);
		testSuite.addTestSuite(ResourceCodePersistenceTest.class);
		testSuite.addTestSuite(ResourcePermissionPersistenceTest.class);
		testSuite.addTestSuite(ResourcePersistenceTest.class);
		testSuite.addTestSuite(RolePersistenceTest.class);
		testSuite.addTestSuite(ServiceComponentPersistenceTest.class);
		testSuite.addTestSuite(ShardPersistenceTest.class);
		testSuite.addTestSuite(SubscriptionPersistenceTest.class);
		testSuite.addTestSuite(TeamPersistenceTest.class);
		testSuite.addTestSuite(TicketPersistenceTest.class);
		testSuite.addTestSuite(UserGroupGroupRolePersistenceTest.class);
		testSuite.addTestSuite(UserGroupPersistenceTest.class);
		testSuite.addTestSuite(UserGroupRolePersistenceTest.class);
		testSuite.addTestSuite(UserIdMapperPersistenceTest.class);
		testSuite.addTestSuite(UserPersistenceTest.class);
		testSuite.addTestSuite(UserTrackerPathPersistenceTest.class);
		testSuite.addTestSuite(UserTrackerPersistenceTest.class);
		testSuite.addTestSuite(WebDAVPropsPersistenceTest.class);
		testSuite.addTestSuite(WebsitePersistenceTest.class);
		testSuite.addTestSuite(WorkflowDefinitionLinkPersistenceTest.class);
		testSuite.addTestSuite(WorkflowInstanceLinkPersistenceTest.class);

		testSuite.addTestSuite(AnnouncementsDeliveryPersistenceTest.class);
		testSuite.addTestSuite(AnnouncementsEntryPersistenceTest.class);
		testSuite.addTestSuite(AnnouncementsFlagPersistenceTest.class);

		testSuite.addTestSuite(AssetCategoryPersistenceTest.class);
		testSuite.addTestSuite(AssetCategoryPropertyPersistenceTest.class);
		testSuite.addTestSuite(AssetEntryPersistenceTest.class);
		testSuite.addTestSuite(AssetLinkPersistenceTest.class);
		testSuite.addTestSuite(AssetTagPersistenceTest.class);
		testSuite.addTestSuite(AssetTagPropertyPersistenceTest.class);
		testSuite.addTestSuite(AssetTagStatsPersistenceTest.class);
		testSuite.addTestSuite(AssetVocabularyPersistenceTest.class);

		testSuite.addTestSuite(BlogsEntryPersistenceTest.class);
		testSuite.addTestSuite(BlogsStatsUserPersistenceTest.class);

		testSuite.addTestSuite(BookmarksEntryPersistenceTest.class);
		testSuite.addTestSuite(BookmarksFolderPersistenceTest.class);

		testSuite.addTestSuite(CalEventPersistenceTest.class);

		testSuite.addTestSuite(DLFileEntryPersistenceTest.class);
		testSuite.addTestSuite(DLFileRankPersistenceTest.class);
		testSuite.addTestSuite(DLFileShortcutPersistenceTest.class);
		testSuite.addTestSuite(DLFileVersionPersistenceTest.class);
		testSuite.addTestSuite(DLFolderPersistenceTest.class);

		testSuite.addTestSuite(ExpandoColumnPersistenceTest.class);
		testSuite.addTestSuite(ExpandoRowPersistenceTest.class);
		testSuite.addTestSuite(ExpandoTablePersistenceTest.class);
		testSuite.addTestSuite(ExpandoValuePersistenceTest.class);

		testSuite.addTestSuite(IGFolderPersistenceTest.class);
		testSuite.addTestSuite(IGImagePersistenceTest.class);

		testSuite.addTestSuite(JournalArticleImagePersistenceTest.class);
		testSuite.addTestSuite(JournalArticlePersistenceTest.class);
		testSuite.addTestSuite(JournalArticleResourcePersistenceTest.class);
		testSuite.addTestSuite(JournalContentSearchPersistenceTest.class);
		testSuite.addTestSuite(JournalFeedPersistenceTest.class);
		testSuite.addTestSuite(JournalStructurePersistenceTest.class);
		testSuite.addTestSuite(JournalTemplatePersistenceTest.class);

		testSuite.addTestSuite(MBBanPersistenceTest.class);
		testSuite.addTestSuite(MBCategoryPersistenceTest.class);
		testSuite.addTestSuite(MBDiscussionPersistenceTest.class);
		testSuite.addTestSuite(MBMailingListPersistenceTest.class);
		testSuite.addTestSuite(MBMessageFlagPersistenceTest.class);
		testSuite.addTestSuite(MBMessagePersistenceTest.class);
		testSuite.addTestSuite(MBStatsUserPersistenceTest.class);
		testSuite.addTestSuite(MBThreadPersistenceTest.class);

		testSuite.addTestSuite(PollsChoicePersistenceTest.class);
		testSuite.addTestSuite(PollsQuestionPersistenceTest.class);
		testSuite.addTestSuite(PollsVotePersistenceTest.class);

		testSuite.addTestSuite(RatingsEntryPersistenceTest.class);
		testSuite.addTestSuite(RatingsStatsPersistenceTest.class);

		testSuite.addTestSuite(ShoppingCartPersistenceTest.class);
		testSuite.addTestSuite(ShoppingCategoryPersistenceTest.class);
		testSuite.addTestSuite(ShoppingCouponPersistenceTest.class);
		testSuite.addTestSuite(ShoppingItemFieldPersistenceTest.class);
		testSuite.addTestSuite(ShoppingItemPersistenceTest.class);
		testSuite.addTestSuite(ShoppingItemPricePersistenceTest.class);
		testSuite.addTestSuite(ShoppingOrderItemPersistenceTest.class);
		testSuite.addTestSuite(ShoppingOrderPersistenceTest.class);

		testSuite.addTestSuite(SocialActivityPersistenceTest.class);
		testSuite.addTestSuite(SocialEquityAssetEntryPersistenceTest.class);
		testSuite.addTestSuite(SocialEquityGroupSettingPersistenceTest.class);
		testSuite.addTestSuite(SocialEquityHistoryPersistenceTest.class);
		testSuite.addTestSuite(SocialEquityLogPersistenceTest.class);
		testSuite.addTestSuite(SocialEquitySettingPersistenceTest.class);
		testSuite.addTestSuite(SocialEquityUserPersistenceTest.class);
		testSuite.addTestSuite(SocialRelationPersistenceTest.class);
		testSuite.addTestSuite(SocialRequestPersistenceTest.class);

		testSuite.addTestSuite(SCFrameworkVersionPersistenceTest.class);
		testSuite.addTestSuite(SCLicensePersistenceTest.class);
		testSuite.addTestSuite(SCProductEntryPersistenceTest.class);
		testSuite.addTestSuite(SCProductScreenshotPersistenceTest.class);
		testSuite.addTestSuite(SCProductVersionPersistenceTest.class);

		testSuite.addTestSuite(TasksProposalPersistenceTest.class);
		testSuite.addTestSuite(TasksReviewPersistenceTest.class);

		testSuite.addTestSuite(WikiNodePersistenceTest.class);
		testSuite.addTestSuite(WikiPagePersistenceTest.class);
		testSuite.addTestSuite(WikiPageResourcePersistenceTest.class);

		return testSuite;
	}

}