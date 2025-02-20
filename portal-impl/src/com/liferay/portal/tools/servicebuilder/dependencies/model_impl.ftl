<#assign parentPKColumn = "">

<#if entity.isHierarchicalTree()>
	<#assign pkColumn = entity.getPKList()?first>

	<#assign parentPKColumn = entity.getColumn("parent" + pkColumn.methodName)>
</#if>

package ${packagePath}.model.impl;

<#if entity.hasCompoundPK()>
	import ${packagePath}.service.persistence.${entity.name}PK;
</#if>

import ${packagePath}.model.${entity.name};
import ${packagePath}.model.${entity.name}Model;
import ${packagePath}.model.${entity.name}Soap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.impl.BaseModelImpl;
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
import java.util.Locale;
import java.util.Map;

/**
 * The base model implementation for the ${entity.name} service. Represents a row in the &quot;${entity.table}&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ${packagePath}.model.${entity.name}Model} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ${entity.name}Impl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a ${entity.humanName} model instance should use the {@link ${packagePath}.model.${entity.name}} interface instead.
 * </p>
 *
 * @author ${author}
 * @see ${entity.name}Impl
 * @see ${packagePath}.model.${entity.name}
 * @see ${packagePath}.model.${entity.name}Model
 * @generated
 */
public class ${entity.name}ModelImpl extends BaseModelImpl<${entity.name}> implements ${entity.name}Model {

	public static final String TABLE_NAME = "${entity.table}";

	<#compress>
		public static final Object[][] TABLE_COLUMNS = {
			<#list entity.getRegularColList() as column>
				<#assign sqlType = serviceBuilder.getSqlType(packagePath + ".model." + entity.getName(), column.getName(), column.getType())>

				{"${column.DBName}", new Integer(Types.${sqlType})}

				<#if column_has_next>
					,
				</#if>
			</#list>
		};
	</#compress>

	public static final String TABLE_SQL_CREATE = "${serviceBuilder.getCreateTableSQL(entity)}";

	public static final String TABLE_SQL_DROP = "drop table ${entity.table}";

	<#if entity.getOrder()??>
		<#assign orderList = entity.getOrder().getColumns()>

		<#assign orderByJPQL = "">

		<#list orderList as order>
			<#if entity.hasCompoundPK() && order.isPrimary()>
				<#assign orderByJPQL = orderByJPQL + entity.alias + ".id." + order.name>
			<#else>
				<#assign orderByJPQL = orderByJPQL + entity.alias + "." + order.name>
			</#if>

			<#if order.isOrderByAscending()>
				<#assign orderByJPQL = orderByJPQL + " ASC">
			<#else>
				<#assign orderByJPQL = orderByJPQL + " DESC">
			</#if>

			<#if order_has_next>
				<#assign orderByJPQL = orderByJPQL + ", ">
			</#if>
		</#list>

		public static final String ORDER_BY_JPQL = " ORDER BY ${orderByJPQL}";

		<#assign orderBySQL = "">

		<#list orderList as order>
			<#assign orderBySQL = orderBySQL + entity.table + "." + order.DBName>

			<#if order.isOrderByAscending()>
				<#assign orderBySQL = orderBySQL + " ASC">
			<#else>
				<#assign orderBySQL = orderBySQL + " DESC">
			</#if>

			<#if order_has_next>
				<#assign orderBySQL = orderBySQL + ", ">
			</#if>
		</#list>

		public static final String ORDER_BY_SQL = " ORDER BY ${orderBySQL}";
	</#if>

	public static final String DATA_SOURCE = "${entity.dataSource}";

	public static final String SESSION_FACTORY = "${entity.sessionFactory}";

	public static final String TX_MANAGER = "${entity.getTXManager()}";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(${propsUtil}.get("value.object.entity.cache.enabled.${packagePath}.model.${entity.name}"),

	<#if entity.isCacheEnabled()>
		true
	<#else>
		false
	</#if>

	);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(${propsUtil}.get("value.object.finder.cache.enabled.${packagePath}.model.${entity.name}"),

	<#if entity.isCacheEnabled()>
		true
	<#else>
		false
	</#if>

	);

	<#if entity.hasRemoteService()>
		/**
		 * Converts the soap model instance into a normal model instance.
		 *
		 * @param soapModel the soap model instance to convert
		 * @return the normal model instance
		 */
		public static ${entity.name} toModel(${entity.name}Soap soapModel) {
			${entity.name} model = new ${entity.name}Impl();

			<#list entity.regularColList as column>
				model.set${column.methodName}(soapModel.get${column.methodName}());
			</#list>

			return model;
		}

		/**
		 * Converts the soap model instances into normal model instances.
		 *
		 * @param soapModels the soap model instances to convert
		 * @return the normal model instances
		 */
		public static List<${entity.name}> toModels(${entity.name}Soap[] soapModels) {
			List<${entity.name}> models = new ArrayList<${entity.name}>(soapModels.length);

			for (${entity.name}Soap soapModel : soapModels) {
				models.add(toModel(soapModel));
			}

			return models;
		}
	</#if>

	<#list entity.columnList as column>
		<#if column.mappingTable??>
			<#assign entityShortName = stringUtil.shorten(entity.name, 9, "")>

			<#if stringUtil.startsWith(column.mappingTable, entityShortName) || stringUtil.startsWith(column.mappingTable, portletShortName + "_" + entityShortName)>
				public static final String MAPPING_TABLE_${stringUtil.upperCase(column.mappingTable)}_NAME = "${column.mappingTable}";

				<#compress>
					public static final Object[][] MAPPING_TABLE_${stringUtil.upperCase(column.mappingTable)}_COLUMNS = {
						<#list serviceBuilder.getMappingEntities(column.mappingTable) as mapColumn>
							<#assign sqlType = serviceBuilder.getSqlType(mapColumn.getType())>

							{"${mapColumn.DBName}", new Integer(Types.${sqlType})}

							<#if mapColumn_has_next>
								,
							</#if>
						</#list>
					};
				</#compress>

				public static final String MAPPING_TABLE_${stringUtil.upperCase(column.mappingTable)}_SQL_CREATE = "${serviceBuilder.getCreateMappingTableSQL(serviceBuilder.getEntityMapping(column.mappingTable))}";

				public static final boolean FINDER_CACHE_ENABLED_${stringUtil.upperCase(column.mappingTable)} = GetterUtil.getBoolean(${propsUtil}.get("value.object.finder.cache.enabled.${column.mappingTable}"), true);
			<#else>
				<#assign tempEntity = serviceBuilder.getEntity(column.getEJBName())>

				public static final String MAPPING_TABLE_${stringUtil.upperCase(column.mappingTable)}_NAME = ${tempEntity.packagePath}.model.impl.${tempEntity.name}ModelImpl.MAPPING_TABLE_${stringUtil.upperCase(column.mappingTable)}_NAME;

				public static final boolean FINDER_CACHE_ENABLED_${stringUtil.upperCase(column.mappingTable)} = ${tempEntity.packagePath}.model.impl.${tempEntity.name}ModelImpl.FINDER_CACHE_ENABLED_${stringUtil.upperCase(column.mappingTable)};
			</#if>
		</#if>
	</#list>

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(${propsUtil}.get("lock.expiration.time.${packagePath}.model.${entity.name}"));

	public ${entity.name}ModelImpl() {
	}

	public ${entity.PKClassName} getPrimaryKey() {
		<#if entity.hasCompoundPK()>
			return new ${entity.PKClassName}(

			<#list entity.PKList as column>
				_${column.name}

				<#if column_has_next>
					,
				</#if>
			</#list>

			);
		<#else>
			return _${entity.PKList[0].name};
		</#if>
	}

	public void setPrimaryKey(${entity.PKClassName} pk) {
		<#if entity.hasCompoundPK()>
			<#list entity.PKList as column>
				set${column.methodName}(pk.${column.name});
			</#list>
		<#else>
			set${entity.PKList[0].methodName}(pk);
		</#if>
	}

	public Serializable getPrimaryKeyObj() {
		<#if entity.hasCompoundPK()>
			return new ${entity.PKClassName}(

			<#list entity.PKList as column>
				_${column.name}

				<#if column_has_next>
					,
				</#if>
			</#list>

			);
		<#else>
			return

			<#if entity.hasPrimitivePK()>
				new ${serviceBuilder.getPrimitiveObj("${entity.PKClassName}")} (
			</#if>

			_${entity.PKList[0].name}

			<#if entity.hasPrimitivePK()>
				)
			</#if>

			;
		</#if>
	}

	<#list entity.regularColList as column>
		<#if column.name == "classNameId">
			public String getClassName() {
				if (getClassNameId() <= 0) {
					return StringPool.BLANK;
				}

				return PortalUtil.getClassName(getClassNameId());
			}
		</#if>

		public ${column.type} get${column.methodName}() {
			<#if column.type == "String" && column.isConvertNull()>
				if (_${column.name} == null) {
					return StringPool.BLANK;
				}
				else {
					return _${column.name};
				}
			<#else>
				return _${column.name};
			</#if>
		}

		<#if column.localized>
			public String get${column.methodName}(Locale locale) {
				String languageId = LocaleUtil.toLanguageId(locale);

				return get${column.methodName}(languageId);
			}

			public String get${column.methodName}(Locale locale, boolean useDefault) {
				String languageId = LocaleUtil.toLanguageId(locale);

				return get${column.methodName}(languageId, useDefault);
			}

			public String get${column.methodName}(String languageId) {
				String value = LocalizationUtil.getLocalization(get${column.methodName}(), languageId);

				if (isEscapedModel()) {
					return HtmlUtil.escape(value);
				}
				else {
					return value;
				}
			}

			public String get${column.methodName}(String languageId, boolean useDefault) {
				String value = LocalizationUtil.getLocalization(get${column.methodName}(), languageId, useDefault);

				if (isEscapedModel()) {
					return HtmlUtil.escape(value);
				}
				else {
					return value;
				}
			}

			public Map<Locale, String> get${column.methodName}Map() {
				return LocalizationUtil.getLocalizationMap(get${column.methodName}());
			}
		</#if>

		<#if column.type== "boolean">
			public ${column.type} is${column.methodName}() {
				return _${column.name};
			}
		</#if>

		public void set${column.methodName}(${column.type} ${column.name}) {
			<#if column.name == "uuid">
				<#if column.isFetchFinderPath()>
					if (_originalUuid == null) {
						_originalUuid = _uuid;
					}
				</#if>

				_uuid = uuid;
			<#else>
				<#if column.isFetchFinderPath() || ((parentPKColumn != "") && (parentPKColumn.name == column.name))>
					<#if column.isPrimitiveType()>
						if (!_setOriginal${column.methodName}) {
							_setOriginal${column.methodName} = true;
					<#else>
						if (_original${column.methodName} == null) {
					</#if>

						_original${column.methodName} = _${column.name};
					}
				</#if>

				_${column.name} = ${column.name};
			</#if>
		}

		<#if column.localized>
			public void set${column.methodName}(Locale locale, String ${column.name}) {
				String languageId = LocaleUtil.toLanguageId(locale);

				if (Validator.isNotNull(${column.name})) {
					set${column.methodName}(LocalizationUtil.updateLocalization(get${column.methodName}(), "${column.methodName}", ${column.name}, languageId));
				}
				else {
					set${column.methodName}(LocalizationUtil.removeLocalization(get${column.methodName}(), "${column.methodName}", languageId));
				}
			}

			public void set${column.methodName}Map(Map<Locale, String> ${column.name}Map) {
				if (${column.name}Map == null) {
					return;
				}

				Locale[] locales = LanguageUtil.getAvailableLocales();

				for (Locale locale : locales) {
					String ${column.name} = ${column.name}Map.get(locale);

					set${column.methodName}(locale, ${column.name});
				}
			}
		</#if>

		<#if column.userUuid>
			public String get${column.methodUserUuidName}() throws SystemException {
				return PortalUtil.getUserValue(get${column.methodName}(), "uuid", _${column.userUuidName});
			}

			public void set${column.methodUserUuidName}(String ${column.userUuidName}) {
				_${column.userUuidName} = ${column.userUuidName};
			}
		</#if>

		<#if column.isFetchFinderPath() || ((parentPKColumn != "") && (parentPKColumn.name == column.name))>
			public ${column.type} getOriginal${column.methodName}() {
				<#if column.type == "String" && column.isConvertNull()>
					return GetterUtil.getString(_original${column.methodName});
				<#else>
					return _original${column.methodName};
				</#if>
			}
		</#if>
	</#list>

	<#if entity.isWorkflowEnabled()>
		public boolean isApproved() {
			if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isDraft() {
			if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isExpired() {
			if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isPending() {
			if (getStatus() == WorkflowConstants.STATUS_PENDING) {
				return true;
			}
			else {
				return false;
			}
		}
	</#if>

	public ${entity.name} toEscapedModel() {
		if (isEscapedModel()) {
			return (${entity.name})this;
		}
		else {
			return (${entity.name})Proxy.newProxyInstance(${entity.name}.class.getClassLoader(), new Class[] {${entity.name}.class}, new AutoEscapeBeanHandler(this));
		}
	}

	<#if (entity.PKClassName == "long") && !stringUtil.startsWith(entity.name, "Expando")>
		public ExpandoBridge getExpandoBridge() {
			if (_expandoBridge == null) {
				_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(

				<#if entity.hasColumn("companyId")>
					getCompanyId(),
				<#else>
					0,
				</#if>

				${entity.name}.class.getName(), getPrimaryKey());
			}

			return _expandoBridge;
		}

		public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
			getExpandoBridge().setAttributes(serviceContext);
		}
	</#if>

	public Object clone() {
		${entity.name}Impl ${entity.varName}Impl = new ${entity.name}Impl();

		<#list entity.regularColList as column>
			${entity.varName}Impl.set${column.methodName}(

			<#if column.EJBName??>
				(${column.EJBName})get${column.methodName}().clone()
			<#else>
				get${column.methodName}()
			</#if>

			);

			<#if column.isFetchFinderPath() || ((parentPKColumn != "") && (parentPKColumn.name == column.name))>
				<#if !cloneCastModelImpl??>
					<#assign cloneCastModelImpl = true>

					${entity.name}ModelImpl ${entity.varName}ModelImpl = ${entity.varName}Impl;
				</#if>

				${entity.varName}ModelImpl._original${column.methodName} = ${entity.varName}ModelImpl._${column.name};

				<#if column.isPrimitiveType()>
					${entity.varName}ModelImpl._setOriginal${column.methodName} = false;
				</#if>
			</#if>
		</#list>

		return ${entity.varName}Impl;
	}

	public int compareTo(${entity.name} ${entity.varName}) {
		<#if entity.isOrdered()>
			int value = 0;

			<#list entity.order.columns as column>
				<#if column.isPrimitiveType()>
					<#if column.type == "boolean">
						<#assign ltComparator = "==">
						<#assign gtComparator = "!=">
					<#else>
						<#assign ltComparator = "<">
						<#assign gtComparator = ">">
					</#if>

					if (get${column.methodName}() ${ltComparator} ${entity.varName}.get${column.methodName}()) {
						value = -1;
					}
					else if (get${column.methodName}() ${gtComparator} ${entity.varName}.get${column.methodName}()) {
						value = 1;
					}
					else {
						value = 0;
					}
				<#else>
					<#if column.type == "Date">
						value = DateUtil.compareTo(get${column.methodName}(), ${entity.varName}.get${column.methodName}());
					<#else>
						<#if column.isCaseSensitive()>
							value = get${column.methodName}().compareTo(${entity.varName}.get${column.methodName}());
						<#else>
							value = get${column.methodName}().toLowerCase().compareTo(${entity.varName}.get${column.methodName}().toLowerCase());
						</#if>
					</#if>
				</#if>

				<#if !column.isOrderByAscending()>
					value = value * -1;
				</#if>

				if (value != 0) {
					return value;
				}
			</#list>

			return 0;
		<#else>
			${entity.PKClassName} pk = ${entity.varName}.getPrimaryKey();

			<#if entity.hasPrimitivePK()>
				if (getPrimaryKey() < pk) {
					return -1;
				}
				else if (getPrimaryKey() > pk) {
					return 1;
				}
				else {
					return 0;
				}
			<#else>
				return getPrimaryKey().compareTo(pk);
			</#if>
		</#if>
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		${entity.name} ${entity.varName} = null;

		try {
			${entity.varName} = (${entity.name})obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		${entity.PKClassName} pk = ${entity.varName}.getPrimaryKey();

		<#if entity.hasPrimitivePK()>
			if (getPrimaryKey() == pk) {
		<#else>
			if (getPrimaryKey().equals(pk)) {
		</#if>

			return true;
		}
		else{
			return false;
		}
	}

	public int hashCode() {
		<#if entity.hasPrimitivePK(false)>
			<#if entity.PKClassName == "int">
				return getPrimaryKey();
			<#else>
				return (int)getPrimaryKey();
			</#if>
		<#else>
			return getPrimaryKey().hashCode();
		</#if>
	}

	public String toString() {
		StringBundler sb = new StringBundler(${entity.regularColList?size * 2 + 1});

		<#list entity.regularColList as column>
			<#if column_index == 0>
				sb.append("{${column.name}=");
				sb.append(get${column.methodName}());
			<#elseif column_has_next>
				sb.append(", ${column.name}=");
				sb.append(get${column.methodName}());
			<#else>
				sb.append(", ${column.name}=");
				sb.append(get${column.methodName}());
				sb.append("}");
			</#if>
		</#list>

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(${entity.regularColList?size * 3 + 4});

		sb.append("<model><model-name>");
		sb.append("${packagePath}.model.${entity.name}");
		sb.append("</model-name>");

		<#list entity.regularColList as column>
			sb.append("<column><column-name>${column.name}</column-name><column-value><![CDATA[");
			sb.append(get${column.methodName}());
			sb.append("]]></column-value></column>");
		</#list>

		sb.append("</model>");

		return sb.toString();
	}

	<#list entity.regularColList as column>
		private ${column.type} _${column.name};

		<#if column.userUuid>
			private String _${column.userUuidName};
		</#if>

		<#if column.isFetchFinderPath() || ((parentPKColumn != "") && (parentPKColumn.name == column.name))>
			private ${column.type} _original${column.methodName};

			<#if column.isPrimitiveType()>
				private boolean _setOriginal${column.methodName};
			</#if>
		</#if>
	</#list>

	<#if (entity.PKClassName == "long") && !stringUtil.startsWith(entity.name, "Expando")>
		private transient ExpandoBridge _expandoBridge;
	</#if>

}