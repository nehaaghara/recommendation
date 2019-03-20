/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.dal;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 *
 * @author BigGoal
 */
public abstract class HibernateAbstractClass<ENTITYTYPE1> extends HibernateDaoSupport implements GenericDao<ENTITYTYPE1> {
    private Class<ENTITYTYPE1> persistentClass;
    @Autowired   
    SessionFactory sessionFactory;
  //  @Autowired
   // ExceptionHandlerService exceptionHandlerService;
    Session session = null;
    LocalSessionManager1 manager = new LocalSessionManager1();
    private static final  org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(HibernateAbstractClass.class);
    private static final String ALIAS = "alias";
    private static final String FIRSTINDEX = "firstIndex";
    private static final String MAXRESULT="maxResult";
    public HibernateAbstractClass() {
        super();
        this.persistentClass = (Class<ENTITYTYPE1>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public Class<ENTITYTYPE1> getPersistentClass() {
        return persistentClass;
    }
    public void setPersistentClass(Class<ENTITYTYPE1> persistentClass) {
        this.persistentClass = persistentClass;
    }
    

    @Override
    public void addEntity(ENTITYTYPE1 entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void deleteEntity(ENTITYTYPE1 entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteAll(Collection entity) {
        getHibernateTemplate().deleteAll(entity);
    }

    @Override
    public void updateEntity(ENTITYTYPE1 entity) {
        getHibernateTemplate().update(entity);
    }
    
    @Override
    public void updateEntityBySession(ENTITYTYPE1 entity) {
        currentSession().update(entity);
    }

    @Override
    public void saveOrUpdateEntity(ENTITYTYPE1 entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void saveAll(Collection<ENTITYTYPE1> collection) {
        for(Object entity : collection){
            getHibernateTemplate().update(entity);
        }
    }
    
    @Override
    public void updateAll(Collection<ENTITYTYPE1> collection) {
        for(Object entity : collection){
            getHibernateTemplate().save(entity);
        }
    }

    @Override
    public List<ENTITYTYPE1> getAllEntity() {
        List<ENTITYTYPE1> lst;
        lst = getHibernateTemplate().loadAll(getPersistentClass());
        return lst;
    }

    @Override
    public List<ENTITYTYPE1> findEntity(Object... values) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(persistentClass);
        List<ENTITYTYPE1> lst;
        int len = values.length % 3;
        if (0 != len) {
//            try {
//                throw new ExceptionHandlerService("Arguments Must be triplet of [field, expression(e.g. eq,lt,gt...), value]");
//            } catch (ExceptionHandlerService ex) {
//                LOGGER.error("Error in Find Entity", ex);
//            }
        }
        len = values.length / 3;
        for (int i = 0, j = 0; i < len; i++, j += 3) {
            OperationTypeEnum operation = (OperationTypeEnum) values[j + 1];
            switch (operation) {
                case EQ:
                    detachedCriteria.add(Restrictions.eq(values[j].toString(),values[j + 2]));
                    break;
                case GE:
                    detachedCriteria.add(Restrictions.ge(values[j].toString(),values[j + 2]));
                    break;
                case GT:
                    detachedCriteria.add(Restrictions.gt(values[j].toString(),values[j + 2]));
                    break;
                case LE:
                    detachedCriteria.add(Restrictions.le(values[j].toString(),values[j + 2]));
                    break;
                case LT:
                    detachedCriteria.add(Restrictions.lt(values[j].toString(),values[j + 2]));
                    break;
                case NE:
                    detachedCriteria.add(Restrictions.ne(values[j].toString(),values[j + 2]));
                    break;
                case LIKE:
                    detachedCriteria.add(Restrictions.ilike(values[j].toString(),values[j + 2]));
                    break;
                case OR:
                    detachedCriteria.add(Restrictions.or(Restrictions.ilike(values[j].toString(), values[j + 2]),Restrictions.ilike(values[j + 3].toString(),values[j + 5])));
                    j = j + 3;
                    i++;
                    break;
                case IN:
                    detachedCriteria.add(Restrictions.in(values[j].toString(),(Object[]) values[j + 2]));
                    break;
                case ORDERBY:
                    OperationTypeEnum order = (OperationTypeEnum) values[j + 2];
                    if (OperationTypeEnum.ASC == order) {
                        detachedCriteria.addOrder(Order.asc(values[j].toString()));
                    } else if (OperationTypeEnum.DESC == order) {
                        detachedCriteria.addOrder(Order.desc(values[j].toString()));
                    } else {
                        try {
//                            throw new ExceptionHandlerService("Order by can be ASC or DESC only. use Enum for to specify this.");
                        } catch (Exception ex) {
                            LOGGER.error("Error in Find Entity", ex);
                        }
                    }
                    break;
                default:
            }
        }
        lst = (List<ENTITYTYPE1>) hibernateTemplate.findByCriteria(detachedCriteria);
        return lst;
    }

    @Override
    public List<ENTITYTYPE1> findByCountEntity(int firstResult, int maxResult,Object... values) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(persistentClass);
        List<ENTITYTYPE1> lst;
        int len = values.length % 3;
        boolean ordered = false;
        if (0 != len) {
            try {
//                throw new ExceptionHandlerService("Arguments Must be triplet of [field, expression(e.g. eq,lt,gt...), value]");
            } catch (Exception ex) {
                Logger.getLogger(HibernateAbstractClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        len = values.length / 3;
        for (int i = 0, j = 0; i < len; i++, j += 3) {
            OperationTypeEnum operation = (OperationTypeEnum) values[j + 1];
            switch (operation) {
                case EQ:
                    detachedCriteria.add(Restrictions.eq(values[j].toString(),values[j + 2]));
                    break;
                case GE:
                    detachedCriteria.add(Restrictions.ge(values[j].toString(),values[j + 2]));
                    break;
                case GT:
                    detachedCriteria.add(Restrictions.gt(values[j].toString(),values[j + 2]));
                    break;
                case LE:
                    detachedCriteria.add(Restrictions.le(values[j].toString(),values[j + 2]));
                    break;
                case LT:
                    detachedCriteria.add(Restrictions.lt(values[j].toString(),values[j + 2]));
                    break;
                case NE:
                    detachedCriteria.add(Restrictions.ne(values[j].toString(),values[j + 2]));
                    break;
                case LIKE:
                    detachedCriteria.add(Restrictions.ilike(values[j].toString(),values[j + 2]));
                    break;
                case OR:
                    detachedCriteria.add(Restrictions.or(Restrictions.ilike(values[j].toString(), values[j + 2]),Restrictions.ilike(values[j + 3].toString(),values[j + 5])));
                    j = j + 3;
                    i++;
                    break;
                case IN:
                    detachedCriteria.add(Restrictions.in(values[j].toString(),(Object[]) values[j + 2]));
                    break;
                case ORDERBY:
                    ordered = true;
                    OperationTypeEnum order = (OperationTypeEnum) values[j + 2];
                    if (OperationTypeEnum.ASC == order) {
                        detachedCriteria.addOrder(Order.asc(values[j].toString()));
                    } else if (OperationTypeEnum.DESC == order) {
                        detachedCriteria.addOrder(Order.desc(values[j].toString()));
                    } else {
                try {
//                    throw new ExceptionHandlerService("Order by can be ASC or DESC only. use Enum for to specify this.");
                } catch (Exception ex) {
                    Logger.getLogger(HibernateAbstractClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                    break;
                }
            }
        if (!ordered && !persistentClass.getSimpleName().startsWith("Vw")) {
            String firstFieldNameFull = persistentClass.getDeclaredFields()[0].toString();
            int intlastdot = firstFieldNameFull.lastIndexOf('.');
            String firstFieldName = firstFieldNameFull
                    .substring(intlastdot + 1);
            detachedCriteria.addOrder(Order.asc(firstFieldName));
        }
        lst = (List<ENTITYTYPE1>) hibernateTemplate.findByCriteria(detachedCriteria, firstResult,maxResult);
        return lst;
    }

    /*
     * Below is to create Projection Ex. count, rowcount, max, min etc See
     * Projection.Ctrl+Space
     */
    @Override
    public long getEntityCount() {
        long count ;
        session = manager.getSession(sessionFactory);
        Criteria c = session.createCriteria(persistentClass).setProjection(Projections.rowCount());
        count = (Long) c.list().get(0);
        return count;
    }

    @Override
    public List<Object[]> createQuery(String query, Map<String, Object> var) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createQuery(query);
        setQueryMap(q, var);
        return null == q ? null : q.list();
    }

    @Override
    public List<Object[]> createSQLQuery(String query, Map<String, Object> var) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createSQLQuery(query);        
        setQueryMap(q, var);
        return q.list();
    }
    
    /**
     * Creating SQL query containing nvarchar columns
     * @param query Query to be executed where each column should be (c0,c1...)
     * @param var parameters containing values
     * @param ncharsIndex index(s) of columns which are nvarchar
     * @param colcount total columns count in query
     * @return 
     */
    @Override
    public List<Object[]> createSQLQuery(String query, Map<String, Object> var,int[] ncharsIndex,int colcount) {
        SQLQuery q;
        session = manager.getSession(sessionFactory);
        q = session.createSQLQuery(query);
        for (int i=0;i<colcount;i++){
            boolean isNchar = false;
            for (int j : ncharsIndex) {
                if(i==j){
                    isNchar = true;
                    break;
                }
            }
            if(isNchar){
                q.addScalar("c"+i,StringType.INSTANCE);
            }else{
                q.addScalar("c"+i);
            }
        }        
        setQueryMap(q, var);
        return q.list();
    } 

    @Override
    public List<Object[]> createByCountQuery(String query, Map<String, Object> var, int firstResult,int maxResult) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createQuery(query);
        setQueryMap(q, var);    
        q.setFirstResult(firstResult);
        q.setMaxResults(maxResult);
        return  q.list();
    }

    @Override
    public long countForQuery(String from, String countOn, String where, Map<String, Object> var) {
        Query q ;
        StringBuilder query = new StringBuilder();
        query.append("select count(").append(countOn).append(") as count from ").append(from).append(" where ").append(where);
        session = manager.getSession(sessionFactory);
        q = session.createQuery(query.toString());
        setQueryMap(q, var);
        return (Long) q.list().get(0);
    }

    @Override
    public List<Object> singleColQuery(String query, Map<String, Object> var) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createQuery(query);
        setQueryMap(q, var);
        return  q.list();
    }

    @Override
    public int updateDeleteQuery(String query, Map<String, Object> var) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createQuery(query);
        setQueryMap(q, var);
        return  q.executeUpdate();
    }

    @Override
    public int updateDeleteSQLQuery(String query, Map<String, Object> var) {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createSQLQuery(query);
        setQueryMap(q, var);
        return q.executeUpdate();
    }

    @Override
    public List nativeQueryToBean(String query, Class classAlias, Map<String, Object> var) throws  HibernateException,  ClassNotFoundException {
        Query q;
        session = manager.getSession(sessionFactory);
        q = session.createSQLQuery(query).setResultTransformer(Transformers.aliasToBean(classAlias));
        setQueryMap(q, var);
        return q.list();
    }
    
    private void setQueryMap(Query q,Map<String, Object> var){
        if(null!=var){
            Set<String> varnames = var.keySet();
            for(String key : varnames)
            {
                Object val = var.get(key);
                if (val instanceof String) {
                    q.setString(key, val.toString());
                } else if (val instanceof Integer) {
                    q.setInteger(key, (Integer) val);
                } else if (val instanceof Date) {
                    q.setDate(key, (Date) val);
                }else if (val instanceof Long) {
                    q.setLong(key, (Long) val);
                }else if (val instanceof Object[]) {
                    q.setParameterList(key,(Object[]) val);
                }else if (val instanceof Collection) {
                    q.setParameterList(key,(Collection) val);
                }else if (val instanceof Double) {
                    q.setDouble(key, (Double) val);
                }else if (val instanceof BigDecimal) {
                    q.setBigDecimal(key, (BigDecimal) val);
                }
                else if(val instanceof List){
                    q.setParameterList(key,(List)val);
                }
                else if (val instanceof Boolean)
                {
                    q.setBoolean(key, (Boolean)val);
                }
                else if (val instanceof BigInteger)
                {
                    q.setBigInteger(key, (BigInteger)val);
                   
                }
            }
        }
    }
    
    /**
     * 
     * @author branpariya
     * @param sqlQuery
     * @param column
     * @return
     * column.put(ALIAS,Tender.class); or 
     * column.put(ALIAS,"map");
     */
    	public <T> List<T> executeSqlSelect(String query, Map<String, Object> column) {
            List<T> list = null;
            try {
                    Query queryObj = currentSession().createSQLQuery(query);
                    setQueryParameter(queryObj, column);
                    list = queryObj.list();
            } catch (Exception e) {
                LOGGER.error("EXECUTE SELECT ", e);
            }
    	return list;
    	}
    /**
     * 
     * @author branpariya
     * @param sqlQuery
     * @param column
     * @return
     * column.put(ALIAS,Tender.class); or 
     * column.put(ALIAS,"map");
     * 
     */
	public <T> List<T> executeSelect(String query, Map<String, Object> column) {
		List<T> list ;
		Query queryObj = currentSession().createQuery(query);

		setQueryParameter(queryObj, column);

		list = queryObj.list();

		return list;
	}
    	
    /**
     * 
     * @author branpariya
     * @param query
     * @param column
     * @return
     * column.put(ALIAS,Tender.class); or 
     * column.put(ALIAS,"map");
     * 
     */
	public Integer executeUpdate(String query, Map<String, Object> column) {
		Integer result;
		Query queryObj = currentSession().createQuery(query);
                setQueryUpdateParameter(queryObj, column);
                result = queryObj.executeUpdate();
		return result;
	}
    		
    /**
     * 
     * @author branpariya
     * @param query
     * @param column
     * @return
     * column.put(ALIAS,Tender.class); or 
     * column.put(ALIAS,"map");
     *  
     */
	public Integer executeSqlUpdate(String query, Map<String, Object> column) {
		Integer result;
		Query queryObj = currentSession().createSQLQuery(query);
                setQueryUpdateParameter(queryObj, column);
                result = queryObj.executeUpdate();
                return result;
	}

    	/**
    	 * column.put(ALIAS,Tender.class); or 
    	 * column.put(ALIAS,"map");
    	 * if you wish map as return object then pass alias and map, if you want bean as return then pass class name.
    	 * if you want limited results then pass firstIndex and maxResult in this map, both this object must be Integer
    	 * map.put(FIRSTINDEX, 0); map.put(MAXRESULT, 10);
    	 * @author branpariya
    	 * @param query
    	 * @param column
    	 * @return
    	 * column.put(ALIAS,Tender.class); or 
    	 * 
    	 */
            public void setQueryParameter(Query query, Map<String, Object> column) {
    		if (null != column && !column.isEmpty()) {
    			if (column.containsKey(ALIAS)) {
    				if ("map".equals(column.get(ALIAS))) {
                                    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    				} else {
                                    query.setResultTransformer(Transformers.aliasToBean((Class) column.get(ALIAS)));
    				}
                            column.remove(ALIAS);
    			}
                        if(column.containsKey(FIRSTINDEX)){
                            query.setFirstResult((Integer)column.get(FIRSTINDEX));
                            column.remove(FIRSTINDEX);
    			}
                        if(column.containsKey(MAXRESULT)){
                            query.setMaxResults((Integer)column.get(MAXRESULT));
                            column.remove(MAXRESULT);
    			}
                        Set<String> keys = column.keySet();
                        for(String entity : keys) {
                            query.setParameter(entity,column.get(entity));
                        }
                    }
                }
    	/**
    	 * 
    	 * @author branpariya
    	 * @param query
    	 * @param column
    	 * @return
    	 */
    	public void setQueryUpdateParameter(Query query, Map<String, Object> column) {
    		if (null != column && !column.isEmpty()) {
                    Set<String> keys = column.keySet();
                        for(String entity : keys) {
                        query.setParameter(entity,column.get(entity));
                        }
    		}
    	}


	public <T> List<T> getListByRistrictions(Class<T> c, Map<String, Object> map, String[] columnNames, Map<String, Object> others ) {
        Criteria criteria ;
        List<T> list ;
        	criteria = currentSession().createCriteria(c);
                if (null != map) {
                    criteria.add(Restrictions.allEq(map));
                }
            
            if(null != others){
            	if(others.containsKey("page")){
                    criteria.setFirstResult(Integer.parseInt(others.get("page").toString()));
                    criteria.setMaxResults(10);
                }
                
                if(others.containsKey("maxResults")){
                    criteria.setMaxResults(Integer.parseInt(others.get("maxResults").toString()));
                }
                
                if(others.containsKey("orderBy")) {
                    String orderBy = others.get("orderBy").toString();
                        if(orderBy.contains(" desc")){
                            criteria.addOrder(Order.desc(orderBy.replace(" desc", "")));
                        } else if(orderBy.contains(" asc")){
                            criteria.addOrder(Order.asc(orderBy.replace(" asc", "")));
                        }
                    }
                }
            if(null != columnNames && columnNames.length > 0){
            	criteria.setProjection(getProjectionList(columnNames));
            	criteria.setResultTransformer(Transformers.aliasToBean(c));
            }
            list = criteria.list();

        return list;
    }
    
	public ProjectionList getProjectionList(String[] columnNames) {
		ProjectionList projectionList = Projections.projectionList();
    	
		for (String column : columnNames) {
             projectionList.add(Projections.property(column), column);
        }

        return projectionList;
	}

}
class LocalSessionManager1{
 private boolean isNew = false;
 
 public Session getSession(SessionFactory sessionFactory){
  Session session = null;
  try {
   session = sessionFactory.openSession();
   
   
  }catch(Exception e){
   isNew = true;
   session = sessionFactory.openSession();
   Logger.getLogger(HibernateAbstractClass.class.getName()).log(Level.SEVERE, null, e);
  }
  return session;
 }
 
 public void closeSession(Session session){
  if(isNew){
   SessionFactoryUtils.closeSession(session);
  }
 }
}