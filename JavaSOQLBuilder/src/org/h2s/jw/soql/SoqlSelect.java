package org.h2s.jw.soql;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.h2s.jw.soql.annotation.SfColumn;
import org.h2s.jw.soql.annotation.SfObject;


/**
 * 
 * @author johnwilfred
 *
 */
public class SoqlSelect {
	private static final String MEMEBER_DELIMITTER = "\\.";
	private List<String> columns;
	private String objectName;
	private SoqlCondition condition;
	private SoqlConditions conditions;
	private String orderByCol;
	private String order;
	private Class<SfObject> sfObjectClass;
	private boolean domainObjectAnnotated ;
	
	/**
	 * Is domain object annoted
	 * @return
	 */
	public boolean isDomainObjectAnnotated() {
		return domainObjectAnnotated;
	}

	private static String DEFAULT_COLUMN = "id";
	
	/**
	 * No param Constructor
	 */
	public SoqlSelect() {
		columns = new ArrayList<String>();
		domainObjectAnnotated = false; // No domain object hence flagged as false
	}
	
	/**
	 * Constructor with domain object
	 * @param domainObject
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public SoqlSelect(Object domainObject) throws ClassNotFoundException {
		columns = new ArrayList<String>();
		
		sfObjectClass = (Class<SfObject>) Class.forName( "org.h2s.jw.soql.annotation.SfObject" );
		SfObject sfObjectAnnotation = (SfObject)domainObject.getClass().getAnnotation( sfObjectClass );
		domainObjectAnnotated = null != sfObjectAnnotation;
		
		columns(domainObject);
		from(domainObject);
	}
	
	/**
	 * Set columns from array of strings
	 * @param columns
	 * @return
	 */
	public SoqlSelect columns(String...  columns) {
		for (String column : (String[])columns) {
			this.columns.add(column);
		}
		return this;
	}
	
	/**
	 * Sets columns from domain object by looking at SfColumn annotation.
	 * @param domainObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SoqlSelect columns(Object domainObject) {
		if (isDomainObjectAnnotated()) {
			try {
				SfObject sfObjectAnnotation = (SfObject)domainObject.getClass().getAnnotation( sfObjectClass );
				if ( null!= sfObjectAnnotation)  {
					Class<SfColumn> sfColumnClass = (Class<SfColumn>) Class.forName( "org.h2s.jw.soql.annotation.SfColumn" );
					for (Field domainObjectField : domainObject.getClass().getDeclaredFields()) {
			    		SfColumn sfColumnAnnotation = (SfColumn)domainObjectField.getAnnotation(sfColumnClass);
			    		domainObjectField.setAccessible(true);
			    		// If there is no annotation then move to the next field.
			    		if ( null != sfColumnAnnotation) {
			    			try {
			    				String sfColumnName = sfColumnAnnotation.name();
			    				this.columns.add(sfColumnName);
							} catch (Exception e) {
								e.printStackTrace();
							}
			    		}
			    	}
				}
				
			} catch (ClassNotFoundException e) {
				this.columns.clear();
				this.columns.add(DEFAULT_COLUMN);
			}
		} else {
			this.columns.clear();
			this.columns.add(DEFAULT_COLUMN);
		}
		return this;
	}
	
	/**
	 * Sets from clause
	 * @param domainObject
	 * @return
	 */
	public SoqlSelect from(String objectName) {
		this.objectName = objectName;
		return this;
	}
	
	/**
	 * Sets from clause by taking the SfObject annotation from the domain object
	 * @param domainObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public SoqlSelect from(Object domainObject) {
		if (isDomainObjectAnnotated()) {
			try {
				Class<SfObject> sfObjectClass;
				sfObjectClass = (Class<SfObject>) Class.forName( "org.h2s.jw.soql.annotation.SfObject" );
				SfObject sfObjectAnnotation = (SfObject)domainObject.getClass().getAnnotation( sfObjectClass );
				if (null!= sfObjectAnnotation){
					String[] sfobjectNameArray = sfObjectAnnotation.name().split(MEMEBER_DELIMITTER);
					this.objectName =  sfobjectNameArray[sfobjectNameArray.length-1];
				}
				
			} catch (ClassNotFoundException e) {
				this.objectName = domainObject.getClass().getName();
			}
		} else {
			this.objectName = domainObject.getClass().getName();
		}
		return this;
	}
	
	/**
	 * Sets the where clause along with condition
	 * @param condition
	 * @return
	 */
	public SoqlSelect where(SoqlCondition condition) {
		this.condition = condition;
		return this;
	}
	
	/**
	 * Sets the where clause along with conditions
	 * @param conditions
	 * @return
	 */
	public SoqlSelect where(SoqlConditions conditions) {
		this.conditions = conditions;
		return this;
	}
	
	/**
	 * Sets Order by column and Order (ASC/DESC)
	 * @param orderByCol
	 * @param order
	 * @return
	 */
	public SoqlSelect orderBy(String orderByCol, String order) {
		this.orderByCol = orderByCol;
		this.order = order;
		return this;
	}

	@Override
	public String toString() {
			String soql = "select ";
			int idx = 0;
			for (String column : this.columns) {
					if (idx++ == this.columns.size()-1) {
						soql = soql + column ;
					} else {
						soql = soql + column + ",";	
					}
			}
			soql = soql + " from " + objectName;
			
			if (null != condition || null != conditions) {
				soql = soql + " where ";
			}
			
			if (null != condition) {
				soql = soql + condition;
			} 
			
			if (null != conditions) {
				soql = soql + conditions;
			}
			
			if(null != orderByCol && null != order){
				soql = soql + " order by ";
				soql = soql + orderByCol + " " + order;
			}
			
			return soql;
		
	}

}
