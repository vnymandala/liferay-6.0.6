create table Account_ (
	accountId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentAccountId LONG,
	name VARCHAR(75) null,
	legalName VARCHAR(75) null,
	legalId VARCHAR(75) null,
	legalType VARCHAR(75) null,
	sicCode VARCHAR(75) null,
	tickerSymbol VARCHAR(75) null,
	industry VARCHAR(75) null,
	type_ VARCHAR(75) null,
	size_ VARCHAR(75) null
);

create table Address (
	addressId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	street1 VARCHAR(75) null,
	street2 VARCHAR(75) null,
	street3 VARCHAR(75) null,
	city VARCHAR(75) null,
	zip VARCHAR(75) null,
	regionId LONG,
	countryId LONG,
	typeId INTEGER,
	mailing BOOLEAN,
	primary_ BOOLEAN
);

create table AnnouncementsDelivery (
	deliveryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	type_ VARCHAR(75) null,
	email BOOLEAN,
	sms BOOLEAN,
	website BOOLEAN
);

create table AnnouncementsEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	title VARCHAR(75) null,
	content STRING null,
	url STRING null,
	type_ VARCHAR(75) null,
	displayDate DATE null,
	expirationDate DATE null,
	priority INTEGER,
	alert BOOLEAN
);

create table AnnouncementsFlag (
	flagId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	entryId LONG,
	value INTEGER
);

create table AssetCategory (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	leftCategoryId LONG,
	rightCategoryId LONG,
	name VARCHAR(75) null,
	title STRING null,
	vocabularyId LONG
);

create table AssetCategoryProperty (
	categoryPropertyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	key_ VARCHAR(75) null,
	value VARCHAR(75) null
);

create table AssetEntries_AssetCategories (
	entryId LONG not null,
	categoryId LONG not null,
	primary key (entryId, categoryId)
);

create table AssetEntries_AssetTags (
	entryId LONG not null,
	tagId LONG not null,
	primary key (entryId, tagId)
);

create table AssetEntry (
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	classUuid VARCHAR(75) null,
	visible BOOLEAN,
	startDate DATE null,
	endDate DATE null,
	publishDate DATE null,
	expirationDate DATE null,
	mimeType VARCHAR(75) null,
	title VARCHAR(255) null,
	description STRING null,
	summary STRING null,
	url STRING null,
	height INTEGER,
	width INTEGER,
	priority DOUBLE,
	viewCount INTEGER
);

create table AssetLink (
	linkId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	entryId1 LONG,
	entryId2 LONG,
	type_ INTEGER,
	weight INTEGER
);

create table AssetTag (
	tagId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	assetCount INTEGER
);

create table AssetTagProperty (
	tagPropertyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	tagId LONG,
	key_ VARCHAR(75) null,
	value VARCHAR(255) null
);

create table AssetTagStats (
	tagStatsId LONG not null primary key,
	tagId LONG,
	classNameId LONG,
	assetCount INTEGER
);

create table AssetVocabulary (
	uuid_ VARCHAR(75) null,
	vocabularyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	title STRING null,
	description STRING null,
	settings_ STRING null
);

create table BlogsEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(150) null,
	urlTitle VARCHAR(150) null,
	content TEXT null,
	displayDate DATE null,
	allowPingbacks BOOLEAN,
	allowTrackbacks BOOLEAN,
	trackbacks TEXT null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table BlogsStatsUser (
	statsUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	entryCount INTEGER,
	lastPostDate DATE null,
	ratingsTotalEntries INTEGER,
	ratingsTotalScore DOUBLE,
	ratingsAverageScore DOUBLE
);

create table BookmarksEntry (
	uuid_ VARCHAR(75) null,
	entryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(255) null,
	url STRING null,
	comments STRING null,
	visits INTEGER,
	priority INTEGER
);

create table BookmarksFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table BrowserTracker (
	browserTrackerId LONG not null primary key,
	userId LONG,
	browserKey LONG
);

create table CalEvent (
	uuid_ VARCHAR(75) null,
	eventId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	durationHour INTEGER,
	durationMinute INTEGER,
	allDay BOOLEAN,
	timeZoneSensitive BOOLEAN,
	type_ VARCHAR(75) null,
	repeating BOOLEAN,
	recurrence TEXT null,
	remindBy INTEGER,
	firstReminder INTEGER,
	secondReminder INTEGER
);

create table ClassName_ (
	classNameId LONG not null primary key,
	value VARCHAR(200) null
);

create table ClusterGroup (
	clusterGroupId LONG not null primary key,
	name VARCHAR(75) null,
	clusterNodeIds VARCHAR(75) null,
	wholeCluster BOOLEAN
);

create table Company (
	companyId LONG not null primary key,
	accountId LONG,
	webId VARCHAR(75) null,
	key_ TEXT null,
	virtualHost VARCHAR(75) null,
	mx VARCHAR(75) null,
	homeURL STRING null,
	logoId LONG,
	system BOOLEAN,
	maxUsers INTEGER
);

create table Contact_ (
	contactId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	accountId LONG,
	parentContactId LONG,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	prefixId INTEGER,
	suffixId INTEGER,
	male BOOLEAN,
	birthday DATE null,
	smsSn VARCHAR(75) null,
	aimSn VARCHAR(75) null,
	facebookSn VARCHAR(75) null,
	icqSn VARCHAR(75) null,
	jabberSn VARCHAR(75) null,
	msnSn VARCHAR(75) null,
	mySpaceSn VARCHAR(75) null,
	skypeSn VARCHAR(75) null,
	twitterSn VARCHAR(75) null,
	ymSn VARCHAR(75) null,
	employeeStatusId VARCHAR(75) null,
	employeeNumber VARCHAR(75) null,
	jobTitle VARCHAR(100) null,
	jobClass VARCHAR(75) null,
	hoursOfOperation VARCHAR(75) null
);

create table Counter (
	name VARCHAR(75) not null primary key,
	currentId LONG
);

create table Country (
	countryId LONG not null primary key,
	name VARCHAR(75) null,
	a2 VARCHAR(75) null,
	a3 VARCHAR(75) null,
	number_ VARCHAR(75) null,
	idd_ VARCHAR(75) null,
	active_ BOOLEAN
);

create table CyrusUser (
	userId VARCHAR(75) not null primary key,
	password_ VARCHAR(75) not null
);

create table CyrusVirtual (
	emailAddress VARCHAR(75) not null primary key,
	userId VARCHAR(75) not null
);

create table DLFileEntry (
	uuid_ VARCHAR(75) null,
	fileEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	versionUserId LONG,
	versionUserName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(255) null,
	extension VARCHAR(75) null,
	title VARCHAR(255) null,
	description STRING null,
	extraSettings TEXT null,
	version VARCHAR(75) null,
	size_ LONG,
	readCount INTEGER
);

create table DLFileRank (
	fileRankId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	folderId LONG,
	name VARCHAR(255) null
);

create table DLFileShortcut (
	uuid_ VARCHAR(75) null,
	fileShortcutId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	toFolderId LONG,
	toName VARCHAR(255) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DLFileVersion (
	fileVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	folderId LONG,
	name VARCHAR(255) null,
	extension VARCHAR(75) null,
	title VARCHAR(75) null,
	description STRING null,
	changeLog VARCHAR(75) null,
	extraSettings VARCHAR(75) null,
	version VARCHAR(75) null,
	size_ LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table DLFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(100) null,
	description STRING null,
	lastPostDate DATE null
);

create table EmailAddress (
	emailAddressId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	address VARCHAR(75) null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table ExpandoColumn (
	columnId LONG not null primary key,
	companyId LONG,
	tableId LONG,
	name VARCHAR(75) null,
	type_ INTEGER,
	defaultData STRING null,
	typeSettings TEXT null
);

create table ExpandoRow (
	rowId_ LONG not null primary key,
	companyId LONG,
	tableId LONG,
	classPK LONG
);

create table ExpandoTable (
	tableId LONG not null primary key,
	companyId LONG,
	classNameId LONG,
	name VARCHAR(75) null
);

create table ExpandoValue (
	valueId LONG not null primary key,
	companyId LONG,
	tableId LONG,
	columnId LONG,
	rowId_ LONG,
	classNameId LONG,
	classPK LONG,
	data_ STRING null
);

create table Group_ (
	groupId LONG not null primary key,
	companyId LONG,
	creatorUserId LONG,
	classNameId LONG,
	classPK LONG,
	parentGroupId LONG,
	liveGroupId LONG,
	name VARCHAR(75) null,
	description STRING null,
	type_ INTEGER,
	typeSettings STRING null,
	friendlyURL VARCHAR(100) null,
	active_ BOOLEAN
);

create table Groups_Orgs (
	groupId LONG not null,
	organizationId LONG not null,
	primary key (groupId, organizationId)
);

create table Groups_Permissions (
	groupId LONG not null,
	permissionId LONG not null,
	primary key (groupId, permissionId)
);

create table Groups_Roles (
	groupId LONG not null,
	roleId LONG not null,
	primary key (groupId, roleId)
);

create table Groups_UserGroups (
	groupId LONG not null,
	userGroupId LONG not null,
	primary key (groupId, userGroupId)
);

create table IGFolder (
	uuid_ VARCHAR(75) null,
	folderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	parentFolderId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table IGImage (
	uuid_ VARCHAR(75) null,
	imageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	folderId LONG,
	name VARCHAR(75) null,
	description STRING null,
	smallImageId LONG,
	largeImageId LONG,
	custom1ImageId LONG,
	custom2ImageId LONG
);

create table Image (
	imageId LONG not null primary key,
	modifiedDate DATE null,
	text_ TEXT null,
	type_ VARCHAR(75) null,
	height INTEGER,
	width INTEGER,
	size_ INTEGER
);

create table JournalArticle (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	resourcePrimKey LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	articleId VARCHAR(75) null,
	version DOUBLE,
	title VARCHAR(300) null,
	urlTitle VARCHAR(150) null,
	description STRING null,
	content TEXT null,
	type_ VARCHAR(75) null,
	structureId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	displayDate DATE null,
	expirationDate DATE null,
	reviewDate DATE null,
	indexable BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL STRING null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table JournalArticleImage (
	articleImageId LONG not null primary key,
	groupId LONG,
	articleId VARCHAR(75) null,
	version DOUBLE,
	elInstanceId VARCHAR(75) null,
	elName VARCHAR(75) null,
	languageId VARCHAR(75) null,
	tempImage BOOLEAN
);

create table JournalArticleResource (
	uuid_ VARCHAR(75) null,
	resourcePrimKey LONG not null primary key,
	groupId LONG,
	articleId VARCHAR(75) null
);

create table JournalContentSearch (
	contentSearchId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	layoutId LONG,
	portletId VARCHAR(200) null,
	articleId VARCHAR(75) null
);

create table JournalFeed (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	feedId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	type_ VARCHAR(75) null,
	structureId VARCHAR(75) null,
	templateId VARCHAR(75) null,
	rendererTemplateId VARCHAR(75) null,
	delta INTEGER,
	orderByCol VARCHAR(75) null,
	orderByType VARCHAR(75) null,
	targetLayoutFriendlyUrl VARCHAR(255) null,
	targetPortletId VARCHAR(75) null,
	contentField VARCHAR(75) null,
	feedType VARCHAR(75) null,
	feedVersion DOUBLE
);

create table JournalStructure (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	structureId VARCHAR(75) null,
	parentStructureId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	xsd TEXT null
);

create table JournalTemplate (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	templateId VARCHAR(75) null,
	structureId VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	xsl TEXT null,
	langType VARCHAR(75) null,
	cacheable BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL STRING null
);

create table Layout (
	uuid_ VARCHAR(75) null,
	plid LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	layoutId LONG,
	parentLayoutId LONG,
	name STRING null,
	title STRING null,
	description STRING null,
	type_ VARCHAR(75) null,
	typeSettings TEXT null,
	hidden_ BOOLEAN,
	friendlyURL VARCHAR(255) null,
	iconImage BOOLEAN,
	iconImageId LONG,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	wapThemeId VARCHAR(75) null,
	wapColorSchemeId VARCHAR(75) null,
	css STRING null,
	priority INTEGER,
	layoutPrototypeId LONG,
	dlFolderId LONG
);

create table LayoutPrototype (
	layoutPrototypeId LONG not null primary key,
	companyId LONG,
	name STRING null,
	description STRING null,
	settings_ STRING null,
	active_ BOOLEAN
);

create table LayoutSet (
	layoutSetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	privateLayout BOOLEAN,
	logo BOOLEAN,
	logoId LONG,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	wapThemeId VARCHAR(75) null,
	wapColorSchemeId VARCHAR(75) null,
	css STRING null,
	pageCount INTEGER,
	virtualHost VARCHAR(75) null,
	settings_ STRING null,
	layoutSetPrototypeId LONG
);

create table LayoutSetPrototype (
	layoutSetPrototypeId LONG not null primary key,
	companyId LONG,
	name STRING null,
	description STRING null,
	settings_ STRING null,
	active_ BOOLEAN
);

create table ListType (
	listTypeId INTEGER not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null
);

create table Lock_ (
	uuid_ VARCHAR(75) null,
	lockId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	className VARCHAR(75) null,
	key_ VARCHAR(200) null,
	owner VARCHAR(75) null,
	inheritable BOOLEAN,
	expirationDate DATE null
);

create table MBBan (
	banId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	banUserId LONG
);

create table MBCategory (
	uuid_ VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	name VARCHAR(75) null,
	description STRING null,
	threadCount INTEGER,
	messageCount INTEGER,
	lastPostDate DATE null
);

create table MBDiscussion (
	discussionId LONG not null primary key,
	classNameId LONG,
	classPK LONG,
	threadId LONG
);

create table MBMailingList (
	uuid_ VARCHAR(75) null,
	mailingListId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	emailAddress VARCHAR(75) null,
	inProtocol VARCHAR(75) null,
	inServerName VARCHAR(75) null,
	inServerPort INTEGER,
	inUseSSL BOOLEAN,
	inUserName VARCHAR(75) null,
	inPassword VARCHAR(75) null,
	inReadInterval INTEGER,
	outEmailAddress VARCHAR(75) null,
	outCustom BOOLEAN,
	outServerName VARCHAR(75) null,
	outServerPort INTEGER,
	outUseSSL BOOLEAN,
	outUserName VARCHAR(75) null,
	outPassword VARCHAR(75) null,
	active_ BOOLEAN
);

create table MBMessage (
	uuid_ VARCHAR(75) null,
	messageId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	categoryId LONG,
	threadId LONG,
	rootMessageId LONG,
	parentMessageId LONG,
	subject VARCHAR(75) null,
	body TEXT null,
	attachments BOOLEAN,
	anonymous BOOLEAN,
	priority DOUBLE,
	allowPingbacks BOOLEAN,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table MBMessageFlag (
	messageFlagId LONG not null primary key,
	userId LONG,
	modifiedDate DATE null,
	threadId LONG,
	messageId LONG,
	flag INTEGER
);

create table MBStatsUser (
	statsUserId LONG not null primary key,
	groupId LONG,
	userId LONG,
	messageCount INTEGER,
	lastPostDate DATE null
);

create table MBThread (
	threadId LONG not null primary key,
	groupId LONG,
	categoryId LONG,
	rootMessageId LONG,
	messageCount INTEGER,
	viewCount INTEGER,
	lastPostByUserId LONG,
	lastPostDate DATE null,
	priority DOUBLE,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table MembershipRequest (
	membershipRequestId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	groupId LONG,
	comments STRING null,
	replyComments STRING null,
	replyDate DATE null,
	replierUserId LONG,
	statusId INTEGER
);

create table Organization_ (
	organizationId LONG not null primary key,
	companyId LONG,
	parentOrganizationId LONG,
	leftOrganizationId LONG,
	rightOrganizationId LONG,
	name VARCHAR(100) null,
	type_ VARCHAR(75) null,
	recursable BOOLEAN,
	regionId LONG,
	countryId LONG,
	statusId INTEGER,
	comments STRING null
);

create table OrgGroupPermission (
	organizationId LONG not null,
	groupId LONG not null,
	permissionId LONG not null,
	primary key (organizationId, groupId, permissionId)
);

create table OrgGroupRole (
	organizationId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	primary key (organizationId, groupId, roleId)
);

create table OrgLabor (
	orgLaborId LONG not null primary key,
	organizationId LONG,
	typeId INTEGER,
	sunOpen INTEGER,
	sunClose INTEGER,
	monOpen INTEGER,
	monClose INTEGER,
	tueOpen INTEGER,
	tueClose INTEGER,
	wedOpen INTEGER,
	wedClose INTEGER,
	thuOpen INTEGER,
	thuClose INTEGER,
	friOpen INTEGER,
	friClose INTEGER,
	satOpen INTEGER,
	satClose INTEGER
);

create table PasswordPolicy (
	passwordPolicyId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	defaultPolicy BOOLEAN,
	name VARCHAR(75) null,
	description STRING null,
	changeable BOOLEAN,
	changeRequired BOOLEAN,
	minAge LONG,
	checkSyntax BOOLEAN,
	allowDictionaryWords BOOLEAN,
	minAlphanumeric INTEGER,
	minLength INTEGER,
	minLowerCase INTEGER,
	minNumbers INTEGER,
	minSymbols INTEGER,
	minUpperCase INTEGER,
	history BOOLEAN,
	historyCount INTEGER,
	expireable BOOLEAN,
	maxAge LONG,
	warningTime LONG,
	graceLimit INTEGER,
	lockout BOOLEAN,
	maxFailure INTEGER,
	lockoutDuration LONG,
	requireUnlock BOOLEAN,
	resetFailureCount LONG,
	resetTicketMaxAge LONG
);

create table PasswordPolicyRel (
	passwordPolicyRelId LONG not null primary key,
	passwordPolicyId LONG,
	classNameId LONG,
	classPK LONG
);

create table PasswordTracker (
	passwordTrackerId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	password_ VARCHAR(75) null
);

create table Permission_ (
	permissionId LONG not null primary key,
	companyId LONG,
	actionId VARCHAR(75) null,
	resourceId LONG
);

create table Phone (
	phoneId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	number_ VARCHAR(75) null,
	extension VARCHAR(75) null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table PluginSetting (
	pluginSettingId LONG not null primary key,
	companyId LONG,
	pluginId VARCHAR(75) null,
	pluginType VARCHAR(75) null,
	roles STRING null,
	active_ BOOLEAN
);

create table PollsChoice (
	uuid_ VARCHAR(75) null,
	choiceId LONG not null primary key,
	questionId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table PollsQuestion (
	uuid_ VARCHAR(75) null,
	questionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description STRING null,
	expirationDate DATE null,
	lastVoteDate DATE null
);

create table PollsVote (
	voteId LONG not null primary key,
	userId LONG,
	questionId LONG,
	choiceId LONG,
	voteDate DATE null
);

create table Portlet (
	id_ LONG not null primary key,
	companyId LONG,
	portletId VARCHAR(200) null,
	roles STRING null,
	active_ BOOLEAN
);

create table PortletItem (
	portletItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	portletId VARCHAR(75) null,
	classNameId LONG
);

create table PortletPreferences (
	portletPreferencesId LONG not null primary key,
	ownerId LONG,
	ownerType INTEGER,
	plid LONG,
	portletId VARCHAR(200) null,
	preferences TEXT null
);

create table RatingsEntry (
	entryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	score DOUBLE
);

create table RatingsStats (
	statsId LONG not null primary key,
	classNameId LONG,
	classPK LONG,
	totalEntries INTEGER,
	totalScore DOUBLE,
	averageScore DOUBLE
);

create table Region (
	regionId LONG not null primary key,
	countryId LONG,
	regionCode VARCHAR(75) null,
	name VARCHAR(75) null,
	active_ BOOLEAN
);

create table Release_ (
	releaseId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	servletContextName VARCHAR(75) null,
	buildNumber INTEGER,
	buildDate DATE null,
	verified BOOLEAN,
	testString VARCHAR(1024) null
);

create table Resource_ (
	resourceId LONG not null primary key,
	codeId LONG,
	primKey VARCHAR(255) null
);

create table ResourceAction (
	resourceActionId LONG not null primary key,
	name VARCHAR(255) null,
	actionId VARCHAR(75) null,
	bitwiseValue LONG
);

create table ResourceCode (
	codeId LONG not null primary key,
	companyId LONG,
	name VARCHAR(255) null,
	scope INTEGER
);

create table ResourcePermission (
	resourcePermissionId LONG not null primary key,
	companyId LONG,
	name VARCHAR(255) null,
	scope INTEGER,
	primKey VARCHAR(255) null,
	roleId LONG,
	actionIds LONG
);

create table Role_ (
	roleId LONG not null primary key,
	companyId LONG,
	classNameId LONG,
	classPK LONG,
	name VARCHAR(75) null,
	title STRING null,
	description STRING null,
	type_ INTEGER,
	subtype VARCHAR(75) null
);

create table Roles_Permissions (
	roleId LONG not null,
	permissionId LONG not null,
	primary key (roleId, permissionId)
);

create table SCFrameworkVersi_SCProductVers (
	frameworkVersionId LONG not null,
	productVersionId LONG not null,
	primary key (frameworkVersionId, productVersionId)
);

create table SCFrameworkVersion (
	frameworkVersionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	url STRING null,
	active_ BOOLEAN,
	priority INTEGER
);

create table SCLicense (
	licenseId LONG not null primary key,
	name VARCHAR(75) null,
	url STRING null,
	openSource BOOLEAN,
	active_ BOOLEAN,
	recommended BOOLEAN
);

create table SCLicenses_SCProductEntries (
	licenseId LONG not null,
	productEntryId LONG not null,
	primary key (licenseId, productEntryId)
);

create table SCProductEntry (
	productEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	tags VARCHAR(255) null,
	shortDescription STRING null,
	longDescription STRING null,
	pageURL STRING null,
	author VARCHAR(75) null,
	repoGroupId VARCHAR(75) null,
	repoArtifactId VARCHAR(75) null
);

create table SCProductScreenshot (
	productScreenshotId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	productEntryId LONG,
	thumbnailId LONG,
	fullImageId LONG,
	priority INTEGER
);

create table SCProductVersion (
	productVersionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	productEntryId LONG,
	version VARCHAR(75) null,
	changeLog STRING null,
	downloadPageURL STRING null,
	directDownloadURL VARCHAR(2000) null,
	repoStoreArtifact BOOLEAN
);

create table ServiceComponent (
	serviceComponentId LONG not null primary key,
	buildNamespace VARCHAR(75) null,
	buildNumber LONG,
	buildDate LONG,
	data_ TEXT null
);

create table Shard (
	shardId LONG not null primary key,
	classNameId LONG,
	classPK LONG,
	name VARCHAR(75) null
);

create table ShoppingCart (
	cartId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	itemIds STRING null,
	couponCodes VARCHAR(75) null,
	altShipping INTEGER,
	insure BOOLEAN
);

create table ShoppingCategory (
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentCategoryId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table ShoppingCoupon (
	couponId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	startDate DATE null,
	endDate DATE null,
	active_ BOOLEAN,
	limitCategories STRING null,
	limitSkus STRING null,
	minOrder DOUBLE,
	discount DOUBLE,
	discountType VARCHAR(75) null
);

create table ShoppingItem (
	itemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	sku VARCHAR(75) null,
	name VARCHAR(200) null,
	description STRING null,
	properties STRING null,
	fields_ BOOLEAN,
	fieldsQuantities STRING null,
	minQuantity INTEGER,
	maxQuantity INTEGER,
	price DOUBLE,
	discount DOUBLE,
	taxable BOOLEAN,
	shipping DOUBLE,
	useShippingFormula BOOLEAN,
	requiresShipping BOOLEAN,
	stockQuantity INTEGER,
	featured_ BOOLEAN,
	sale_ BOOLEAN,
	smallImage BOOLEAN,
	smallImageId LONG,
	smallImageURL STRING null,
	mediumImage BOOLEAN,
	mediumImageId LONG,
	mediumImageURL STRING null,
	largeImage BOOLEAN,
	largeImageId LONG,
	largeImageURL STRING null
);

create table ShoppingItemField (
	itemFieldId LONG not null primary key,
	itemId LONG,
	name VARCHAR(75) null,
	values_ STRING null,
	description STRING null
);

create table ShoppingItemPrice (
	itemPriceId LONG not null primary key,
	itemId LONG,
	minQuantity INTEGER,
	maxQuantity INTEGER,
	price DOUBLE,
	discount DOUBLE,
	taxable BOOLEAN,
	shipping DOUBLE,
	useShippingFormula BOOLEAN,
	status INTEGER
);

create table ShoppingOrder (
	orderId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	number_ VARCHAR(75) null,
	tax DOUBLE,
	shipping DOUBLE,
	altShipping VARCHAR(75) null,
	requiresShipping BOOLEAN,
	insure BOOLEAN,
	insurance DOUBLE,
	couponCodes VARCHAR(75) null,
	couponDiscount DOUBLE,
	billingFirstName VARCHAR(75) null,
	billingLastName VARCHAR(75) null,
	billingEmailAddress VARCHAR(75) null,
	billingCompany VARCHAR(75) null,
	billingStreet VARCHAR(75) null,
	billingCity VARCHAR(75) null,
	billingState VARCHAR(75) null,
	billingZip VARCHAR(75) null,
	billingCountry VARCHAR(75) null,
	billingPhone VARCHAR(75) null,
	shipToBilling BOOLEAN,
	shippingFirstName VARCHAR(75) null,
	shippingLastName VARCHAR(75) null,
	shippingEmailAddress VARCHAR(75) null,
	shippingCompany VARCHAR(75) null,
	shippingStreet VARCHAR(75) null,
	shippingCity VARCHAR(75) null,
	shippingState VARCHAR(75) null,
	shippingZip VARCHAR(75) null,
	shippingCountry VARCHAR(75) null,
	shippingPhone VARCHAR(75) null,
	ccName VARCHAR(75) null,
	ccType VARCHAR(75) null,
	ccNumber VARCHAR(75) null,
	ccExpMonth INTEGER,
	ccExpYear INTEGER,
	ccVerNumber VARCHAR(75) null,
	comments STRING null,
	ppTxnId VARCHAR(75) null,
	ppPaymentStatus VARCHAR(75) null,
	ppPaymentGross DOUBLE,
	ppReceiverEmail VARCHAR(75) null,
	ppPayerEmail VARCHAR(75) null,
	sendOrderEmail BOOLEAN,
	sendShippingEmail BOOLEAN
);

create table ShoppingOrderItem (
	orderItemId LONG not null primary key,
	orderId LONG,
	itemId VARCHAR(75) null,
	sku VARCHAR(75) null,
	name VARCHAR(200) null,
	description STRING null,
	properties STRING null,
	price DOUBLE,
	quantity INTEGER,
	shippedDate DATE null
);

create table SocialActivity (
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate LONG,
	mirrorActivityId LONG,
	classNameId LONG,
	classPK LONG,
	type_ INTEGER,
	extraData STRING null,
	receiverUserId LONG
);

create table SocialEquityAssetEntry (
	equityAssetEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	assetEntryId LONG,
	informationK DOUBLE,
	informationB DOUBLE
);

create table SocialEquityGroupSetting (
	equityGroupSettingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	classNameId LONG,
	type_ INTEGER,
	enabled BOOLEAN
);

create table SocialEquityHistory (
	equityHistoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	personalEquity INTEGER
);

create table SocialEquityLog (
	equityLogId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	assetEntryId LONG,
	actionId VARCHAR(75) null,
	actionDate INTEGER,
	active_ BOOLEAN,
	expiration INTEGER,
	type_ INTEGER,
	value INTEGER
);

create table SocialEquitySetting (
	equitySettingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	classNameId LONG,
	actionId VARCHAR(75) null,
	dailyLimit INTEGER,
	lifespan INTEGER,
	type_ INTEGER,
	uniqueEntry BOOLEAN,
	value INTEGER
);

create table SocialEquityUser (
	equityUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	contributionK DOUBLE,
	contributionB DOUBLE,
	participationK DOUBLE,
	participationB DOUBLE,
	rank INTEGER
);

create table SocialRelation (
	uuid_ VARCHAR(75) null,
	relationId LONG not null primary key,
	companyId LONG,
	createDate LONG,
	userId1 LONG,
	userId2 LONG,
	type_ INTEGER
);

create table SocialRequest (
	uuid_ VARCHAR(75) null,
	requestId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate LONG,
	modifiedDate LONG,
	classNameId LONG,
	classPK LONG,
	type_ INTEGER,
	extraData STRING null,
	receiverUserId LONG,
	status INTEGER
);

create table Subscription (
	subscriptionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	frequency VARCHAR(75) null
);

create table TasksProposal (
	proposalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK VARCHAR(75) null,
	name VARCHAR(75) null,
	description STRING null,
	publishDate DATE null,
	dueDate DATE null
);

create table TasksReview (
	reviewId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	proposalId LONG,
	assignedByUserId LONG,
	assignedByUserName VARCHAR(75) null,
	stage INTEGER,
	completed BOOLEAN,
	rejected BOOLEAN
);

create table Team (
	teamId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	groupId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table Ticket (
	ticketId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	classNameId LONG,
	classPK LONG,
	key_ VARCHAR(75) null,
	expirationDate DATE null
);

create table User_ (
	uuid_ VARCHAR(75) null,
	userId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	defaultUser BOOLEAN,
	contactId LONG,
	password_ VARCHAR(75) null,
	passwordEncrypted BOOLEAN,
	passwordReset BOOLEAN,
	passwordModifiedDate DATE null,
	digest VARCHAR(255) null,
	reminderQueryQuestion VARCHAR(75) null,
	reminderQueryAnswer VARCHAR(75) null,
	graceLoginCount INTEGER,
	screenName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	facebookId LONG,
	openId VARCHAR(1024) null,
	portraitId LONG,
	languageId VARCHAR(75) null,
	timeZoneId VARCHAR(75) null,
	greeting VARCHAR(255) null,
	comments STRING null,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	jobTitle VARCHAR(100) null,
	loginDate DATE null,
	loginIP VARCHAR(75) null,
	lastLoginDate DATE null,
	lastLoginIP VARCHAR(75) null,
	lastFailedLoginDate DATE null,
	failedLoginAttempts INTEGER,
	lockout BOOLEAN,
	lockoutDate DATE null,
	agreedToTermsOfUse BOOLEAN,
	active_ BOOLEAN
);

create table UserGroup (
	userGroupId LONG not null primary key,
	companyId LONG,
	parentUserGroupId LONG,
	name VARCHAR(75) null,
	description STRING null
);

create table UserGroupGroupRole (
	userGroupId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	primary key (userGroupId, groupId, roleId)
);

create table UserGroupRole (
	userId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	primary key (userId, groupId, roleId)
);

create table UserIdMapper (
	userIdMapperId LONG not null primary key,
	userId LONG,
	type_ VARCHAR(75) null,
	description VARCHAR(75) null,
	externalUserId VARCHAR(75) null
);

create table Users_Groups (
	userId LONG not null,
	groupId LONG not null,
	primary key (userId, groupId)
);

create table Users_Orgs (
	userId LONG not null,
	organizationId LONG not null,
	primary key (userId, organizationId)
);

create table Users_Permissions (
	userId LONG not null,
	permissionId LONG not null,
	primary key (userId, permissionId)
);

create table Users_Roles (
	userId LONG not null,
	roleId LONG not null,
	primary key (userId, roleId)
);

create table Users_Teams (
	userId LONG not null,
	teamId LONG not null,
	primary key (userId, teamId)
);

create table Users_UserGroups (
	userGroupId LONG not null,
	userId LONG not null,
	primary key (userGroupId, userId)
);

create table UserTracker (
	userTrackerId LONG not null primary key,
	companyId LONG,
	userId LONG,
	modifiedDate DATE null,
	sessionId VARCHAR(200) null,
	remoteAddr VARCHAR(75) null,
	remoteHost VARCHAR(75) null,
	userAgent VARCHAR(200) null
);

create table UserTrackerPath (
	userTrackerPathId LONG not null primary key,
	userTrackerId LONG,
	path_ STRING null,
	pathDate DATE null
);

create table Vocabulary (
	vocabularyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	folksonomy BOOLEAN
);

create table WebDAVProps (
	webDavPropsId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	props TEXT null
);

create table Website (
	websiteId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	url STRING null,
	typeId INTEGER,
	primary_ BOOLEAN
);

create table WikiNode (
	uuid_ VARCHAR(75) null,
	nodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description STRING null,
	lastPostDate DATE null
);

create table WikiPage (
	uuid_ VARCHAR(75) null,
	pageId LONG not null primary key,
	resourcePrimKey LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	nodeId LONG,
	title VARCHAR(255) null,
	version DOUBLE,
	minorEdit BOOLEAN,
	content TEXT null,
	summary STRING null,
	format VARCHAR(75) null,
	head BOOLEAN,
	parentTitle VARCHAR(255) null,
	redirectTitle VARCHAR(255) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table WikiPageResource (
	uuid_ VARCHAR(75) null,
	resourcePrimKey LONG not null primary key,
	nodeId LONG,
	title VARCHAR(255) null
);

create table WorkflowDefinitionLink (
	workflowDefinitionLinkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	workflowDefinitionName VARCHAR(75) null,
	workflowDefinitionVersion INTEGER
);

create table WorkflowInstanceLink (
	workflowInstanceLinkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	workflowInstanceId LONG
);