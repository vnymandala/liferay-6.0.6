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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ContactModel;
import com.liferay.portal.model.ContactSoap;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the Contact service. Represents a row in the &quot;Contact_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.ContactModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a contact model instance should use the {@link com.liferay.portal.model.Contact} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactImpl
 * @see com.liferay.portal.model.Contact
 * @see com.liferay.portal.model.ContactModel
 * @generated
 */
public class ContactModelImpl extends BaseModelImpl<Contact>
	implements ContactModel {
	public static final String TABLE_NAME = "Contact_";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contactId", new Integer(Types.BIGINT) },
			{ "companyId", new Integer(Types.BIGINT) },
			{ "userId", new Integer(Types.BIGINT) },
			{ "userName", new Integer(Types.VARCHAR) },
			{ "createDate", new Integer(Types.TIMESTAMP) },
			{ "modifiedDate", new Integer(Types.TIMESTAMP) },
			{ "accountId", new Integer(Types.BIGINT) },
			{ "parentContactId", new Integer(Types.BIGINT) },
			{ "firstName", new Integer(Types.VARCHAR) },
			{ "middleName", new Integer(Types.VARCHAR) },
			{ "lastName", new Integer(Types.VARCHAR) },
			{ "prefixId", new Integer(Types.INTEGER) },
			{ "suffixId", new Integer(Types.INTEGER) },
			{ "male", new Integer(Types.BOOLEAN) },
			{ "birthday", new Integer(Types.TIMESTAMP) },
			{ "smsSn", new Integer(Types.VARCHAR) },
			{ "aimSn", new Integer(Types.VARCHAR) },
			{ "facebookSn", new Integer(Types.VARCHAR) },
			{ "icqSn", new Integer(Types.VARCHAR) },
			{ "jabberSn", new Integer(Types.VARCHAR) },
			{ "msnSn", new Integer(Types.VARCHAR) },
			{ "mySpaceSn", new Integer(Types.VARCHAR) },
			{ "skypeSn", new Integer(Types.VARCHAR) },
			{ "twitterSn", new Integer(Types.VARCHAR) },
			{ "ymSn", new Integer(Types.VARCHAR) },
			{ "employeeStatusId", new Integer(Types.VARCHAR) },
			{ "employeeNumber", new Integer(Types.VARCHAR) },
			{ "jobTitle", new Integer(Types.VARCHAR) },
			{ "jobClass", new Integer(Types.VARCHAR) },
			{ "hoursOfOperation", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table Contact_ (contactId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,accountId LONG,parentContactId LONG,firstName VARCHAR(75) null,middleName VARCHAR(75) null,lastName VARCHAR(75) null,prefixId INTEGER,suffixId INTEGER,male BOOLEAN,birthday DATE null,smsSn VARCHAR(75) null,aimSn VARCHAR(75) null,facebookSn VARCHAR(75) null,icqSn VARCHAR(75) null,jabberSn VARCHAR(75) null,msnSn VARCHAR(75) null,mySpaceSn VARCHAR(75) null,skypeSn VARCHAR(75) null,twitterSn VARCHAR(75) null,ymSn VARCHAR(75) null,employeeStatusId VARCHAR(75) null,employeeNumber VARCHAR(75) null,jobTitle VARCHAR(100) null,jobClass VARCHAR(75) null,hoursOfOperation VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Contact_";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.Contact"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.Contact"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Contact toModel(ContactSoap soapModel) {
		Contact model = new ContactImpl();

		model.setContactId(soapModel.getContactId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setAccountId(soapModel.getAccountId());
		model.setParentContactId(soapModel.getParentContactId());
		model.setFirstName(soapModel.getFirstName());
		model.setMiddleName(soapModel.getMiddleName());
		model.setLastName(soapModel.getLastName());
		model.setPrefixId(soapModel.getPrefixId());
		model.setSuffixId(soapModel.getSuffixId());
		model.setMale(soapModel.getMale());
		model.setBirthday(soapModel.getBirthday());
		model.setSmsSn(soapModel.getSmsSn());
		model.setAimSn(soapModel.getAimSn());
		model.setFacebookSn(soapModel.getFacebookSn());
		model.setIcqSn(soapModel.getIcqSn());
		model.setJabberSn(soapModel.getJabberSn());
		model.setMsnSn(soapModel.getMsnSn());
		model.setMySpaceSn(soapModel.getMySpaceSn());
		model.setSkypeSn(soapModel.getSkypeSn());
		model.setTwitterSn(soapModel.getTwitterSn());
		model.setYmSn(soapModel.getYmSn());
		model.setEmployeeStatusId(soapModel.getEmployeeStatusId());
		model.setEmployeeNumber(soapModel.getEmployeeNumber());
		model.setJobTitle(soapModel.getJobTitle());
		model.setJobClass(soapModel.getJobClass());
		model.setHoursOfOperation(soapModel.getHoursOfOperation());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Contact> toModels(ContactSoap[] soapModels) {
		List<Contact> models = new ArrayList<Contact>(soapModels.length);

		for (ContactSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.Contact"));

	public ContactModelImpl() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public long getParentContactId() {
		return _parentContactId;
	}

	public void setParentContactId(long parentContactId) {
		_parentContactId = parentContactId;
	}

	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		if (_middleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _middleName;
		}
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public int getPrefixId() {
		return _prefixId;
	}

	public void setPrefixId(int prefixId) {
		_prefixId = prefixId;
	}

	public int getSuffixId() {
		return _suffixId;
	}

	public void setSuffixId(int suffixId) {
		_suffixId = suffixId;
	}

	public boolean getMale() {
		return _male;
	}

	public boolean isMale() {
		return _male;
	}

	public void setMale(boolean male) {
		_male = male;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getSmsSn() {
		if (_smsSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _smsSn;
		}
	}

	public void setSmsSn(String smsSn) {
		_smsSn = smsSn;
	}

	public String getAimSn() {
		if (_aimSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _aimSn;
		}
	}

	public void setAimSn(String aimSn) {
		_aimSn = aimSn;
	}

	public String getFacebookSn() {
		if (_facebookSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _facebookSn;
		}
	}

	public void setFacebookSn(String facebookSn) {
		_facebookSn = facebookSn;
	}

	public String getIcqSn() {
		if (_icqSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _icqSn;
		}
	}

	public void setIcqSn(String icqSn) {
		_icqSn = icqSn;
	}

	public String getJabberSn() {
		if (_jabberSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _jabberSn;
		}
	}

	public void setJabberSn(String jabberSn) {
		_jabberSn = jabberSn;
	}

	public String getMsnSn() {
		if (_msnSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _msnSn;
		}
	}

	public void setMsnSn(String msnSn) {
		_msnSn = msnSn;
	}

	public String getMySpaceSn() {
		if (_mySpaceSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _mySpaceSn;
		}
	}

	public void setMySpaceSn(String mySpaceSn) {
		_mySpaceSn = mySpaceSn;
	}

	public String getSkypeSn() {
		if (_skypeSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _skypeSn;
		}
	}

	public void setSkypeSn(String skypeSn) {
		_skypeSn = skypeSn;
	}

	public String getTwitterSn() {
		if (_twitterSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _twitterSn;
		}
	}

	public void setTwitterSn(String twitterSn) {
		_twitterSn = twitterSn;
	}

	public String getYmSn() {
		if (_ymSn == null) {
			return StringPool.BLANK;
		}
		else {
			return _ymSn;
		}
	}

	public void setYmSn(String ymSn) {
		_ymSn = ymSn;
	}

	public String getEmployeeStatusId() {
		if (_employeeStatusId == null) {
			return StringPool.BLANK;
		}
		else {
			return _employeeStatusId;
		}
	}

	public void setEmployeeStatusId(String employeeStatusId) {
		_employeeStatusId = employeeStatusId;
	}

	public String getEmployeeNumber() {
		if (_employeeNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _employeeNumber;
		}
	}

	public void setEmployeeNumber(String employeeNumber) {
		_employeeNumber = employeeNumber;
	}

	public String getJobTitle() {
		if (_jobTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobTitle;
		}
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getJobClass() {
		if (_jobClass == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobClass;
		}
	}

	public void setJobClass(String jobClass) {
		_jobClass = jobClass;
	}

	public String getHoursOfOperation() {
		if (_hoursOfOperation == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoursOfOperation;
		}
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	public Contact toEscapedModel() {
		if (isEscapedModel()) {
			return (Contact)this;
		}
		else {
			return (Contact)Proxy.newProxyInstance(Contact.class.getClassLoader(),
				new Class[] { Contact.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					Contact.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setContactId(getContactId());

		contactImpl.setCompanyId(getCompanyId());

		contactImpl.setUserId(getUserId());

		contactImpl.setUserName(getUserName());

		contactImpl.setCreateDate(getCreateDate());

		contactImpl.setModifiedDate(getModifiedDate());

		contactImpl.setAccountId(getAccountId());

		contactImpl.setParentContactId(getParentContactId());

		contactImpl.setFirstName(getFirstName());

		contactImpl.setMiddleName(getMiddleName());

		contactImpl.setLastName(getLastName());

		contactImpl.setPrefixId(getPrefixId());

		contactImpl.setSuffixId(getSuffixId());

		contactImpl.setMale(getMale());

		contactImpl.setBirthday(getBirthday());

		contactImpl.setSmsSn(getSmsSn());

		contactImpl.setAimSn(getAimSn());

		contactImpl.setFacebookSn(getFacebookSn());

		contactImpl.setIcqSn(getIcqSn());

		contactImpl.setJabberSn(getJabberSn());

		contactImpl.setMsnSn(getMsnSn());

		contactImpl.setMySpaceSn(getMySpaceSn());

		contactImpl.setSkypeSn(getSkypeSn());

		contactImpl.setTwitterSn(getTwitterSn());

		contactImpl.setYmSn(getYmSn());

		contactImpl.setEmployeeStatusId(getEmployeeStatusId());

		contactImpl.setEmployeeNumber(getEmployeeNumber());

		contactImpl.setJobTitle(getJobTitle());

		contactImpl.setJobClass(getJobClass());

		contactImpl.setHoursOfOperation(getHoursOfOperation());

		return contactImpl;
	}

	public int compareTo(Contact contact) {
		long pk = contact.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Contact contact = null;

		try {
			contact = (Contact)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = contact.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", parentContactId=");
		sb.append(getParentContactId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", prefixId=");
		sb.append(getPrefixId());
		sb.append(", suffixId=");
		sb.append(getSuffixId());
		sb.append(", male=");
		sb.append(getMale());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", smsSn=");
		sb.append(getSmsSn());
		sb.append(", aimSn=");
		sb.append(getAimSn());
		sb.append(", facebookSn=");
		sb.append(getFacebookSn());
		sb.append(", icqSn=");
		sb.append(getIcqSn());
		sb.append(", jabberSn=");
		sb.append(getJabberSn());
		sb.append(", msnSn=");
		sb.append(getMsnSn());
		sb.append(", mySpaceSn=");
		sb.append(getMySpaceSn());
		sb.append(", skypeSn=");
		sb.append(getSkypeSn());
		sb.append(", twitterSn=");
		sb.append(getTwitterSn());
		sb.append(", ymSn=");
		sb.append(getYmSn());
		sb.append(", employeeStatusId=");
		sb.append(getEmployeeStatusId());
		sb.append(", employeeNumber=");
		sb.append(getEmployeeNumber());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", jobClass=");
		sb.append(getJobClass());
		sb.append(", hoursOfOperation=");
		sb.append(getHoursOfOperation());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.Contact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentContactId</column-name><column-value><![CDATA[");
		sb.append(getParentContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prefixId</column-name><column-value><![CDATA[");
		sb.append(getPrefixId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>suffixId</column-name><column-value><![CDATA[");
		sb.append(getSuffixId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>male</column-name><column-value><![CDATA[");
		sb.append(getMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smsSn</column-name><column-value><![CDATA[");
		sb.append(getSmsSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aimSn</column-name><column-value><![CDATA[");
		sb.append(getAimSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebookSn</column-name><column-value><![CDATA[");
		sb.append(getFacebookSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icqSn</column-name><column-value><![CDATA[");
		sb.append(getIcqSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jabberSn</column-name><column-value><![CDATA[");
		sb.append(getJabberSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>msnSn</column-name><column-value><![CDATA[");
		sb.append(getMsnSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mySpaceSn</column-name><column-value><![CDATA[");
		sb.append(getMySpaceSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skypeSn</column-name><column-value><![CDATA[");
		sb.append(getSkypeSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterSn</column-name><column-value><![CDATA[");
		sb.append(getTwitterSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ymSn</column-name><column-value><![CDATA[");
		sb.append(getYmSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeStatusId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNumber</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobClass</column-name><column-value><![CDATA[");
		sb.append(getJobClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getHoursOfOperation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _accountId;
	private long _parentContactId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private int _prefixId;
	private int _suffixId;
	private boolean _male;
	private Date _birthday;
	private String _smsSn;
	private String _aimSn;
	private String _facebookSn;
	private String _icqSn;
	private String _jabberSn;
	private String _msnSn;
	private String _mySpaceSn;
	private String _skypeSn;
	private String _twitterSn;
	private String _ymSn;
	private String _employeeStatusId;
	private String _employeeNumber;
	private String _jobTitle;
	private String _jobClass;
	private String _hoursOfOperation;
	private transient ExpandoBridge _expandoBridge;
}