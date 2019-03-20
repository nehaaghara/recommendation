/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.dal;

import static com.damani.dal.CommonDAO.MSGDELETEFAILED;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BigGoal
 */
@Repository
public class CommonDAO extends HibernateTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDAO.class);
    static final String ALIAS = "alias";
    static final String FIRSTINDEX = "firstIndex";
    static final String MAXRESULTS = "maxResults";
    static final String MAXRESULT = "maxResult";
    static final String MSGDELETEFAILED = "delete failed";
    @Autowired
    SessionFactory sessionFactory;
    // @Autowired
//	ExceptionHandlerService exceptionHandlerService; 

    @Autowired
    public CommonDAO(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);

    }

    public Serializable save(Object object) {

        Session session = null;
        Transaction transaction = null;
        Serializable serializable = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();
            serializable = session.save(object);

            session.flush();
            transaction.commit();

        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
//			exceptionHandlerService.writeLog(re);
            LOGGER.error("save failed", re);
            re.printStackTrace();
        } finally {
            manager.closeSession(session);
        }

        return serializable;
    }

    public void update(Object object) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();

            session.update(object);
            session.flush();

            transaction.commit();

        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
//			exceptionHandlerService.writeLog(re);
            LOGGER.error("update failed", re);
        } finally {
            manager.closeSession(session);
        }
    }

    public void saveOrUpdate(Object object) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();

            session.saveOrUpdate(object);
            session.flush();

            transaction.commit();

        } catch (Exception re) {
            re.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
//			exceptionHandlerService.writeLog(re);
            LOGGER.error("save or update failed", re);

        } finally {
            manager.closeSession(session);
        }
    }

    public <T> void saveOrUpdateAll(Collection<T> objects) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();

            for (Object bean : objects) {
                session.saveOrUpdate(bean);
            }

            session.flush();

            transaction.commit();

        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
            re.printStackTrace();
//			exceptionHandlerService.writeLog(re);
            LOGGER.error("save or update all failed", re);

        } finally {
            manager.closeSession(session);
        }
    }

    public void delete(Object object) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();

            session.delete(object);
            session.flush();

            transaction.commit();

        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
//			exceptionHandlerService.writeLog(re);
            LOGGER.error(MSGDELETEFAILED, re);

        } finally {
            manager.closeSession(session);
        }
    }

    public <T> void deleteALL(Collection<T> objects) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            transaction = session.beginTransaction();

            for (Object bean : objects) {
                session.delete(bean);
            }

            session.flush();

            transaction.commit();

        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
//			exceptionHandlerService.writeLog(re);
            LOGGER.error(MSGDELETEFAILED, re);
        } finally {
            manager.closeSession(session);
        }
    }

    public <T> List<T> getListByRistrictions(Class<T> c, Map<String, Object> map, String[] columnNames, Map<String, Object> others) {

        Session session = null;
        Criteria criteria = null;
        List<T> list = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            criteria = session.createCriteria(c);

            if (map != null) {
                criteria.add(Restrictions.allEq(map));
            }

            if (others != null) {
                if (others.containsKey("page")) {
                    criteria.setFirstResult(Integer.parseInt(others.get("page").toString()));
                    criteria.setMaxResults(10);
                }

                if (others.containsKey(MAXRESULTS)) {
                    criteria.setMaxResults(Integer.parseInt(others.get(MAXRESULTS).toString()));
                }

                if (others.containsKey("orderBy")) {
                    String orderBy = others.get("orderBy").toString();

                    if (orderBy.contains(" desc")) {
                        criteria.addOrder(Order.desc(orderBy.replace(" desc", "")));

                    } else if (orderBy.contains(" asc")) {
                        criteria.addOrder(Order.asc(orderBy.replace(" asc", "")));
                    }
                }
            }

            if (columnNames != null && columnNames.length > 0) {
                criteria.setProjection(getProjectionList(columnNames));
                criteria.setResultTransformer(Transformers.aliasToBean(c));
            }

            list = criteria.list();

        } catch (Exception e) {
//        	exceptionHandlerService.writeLog(e);
            LOGGER.error("getListByRistrictions", e);
        } finally {
            manager.closeSession(session);
        }

        return list;
    }

    public ProjectionList getProjectionList(String[] columnNames) {
        ProjectionList projectionList = Projections.projectionList();

        for (String column : columnNames) {
            projectionList.add(Projections.property(column), column);
        }

        return projectionList;
    }

    public <T> List<T> executeSqlSelect(String query, Map<String, Object> column) {
        List<T> list = null;
        Session session = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            Query queryObj = session.createSQLQuery(query);

            setQueryParameter(queryObj, column);

            list = queryObj.list();

        } catch (Exception e) {
//			exceptionHandlerService.writeLog(e);
            LOGGER.error("executeSqlSelect", e);
        } finally {
            manager.closeSession(session);
        }

        return list;
    }

    public <T> List<T> executeSelect(String query, Map<String, Object> column) {
        List<T> list = null;
        Session session = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            Query queryObj = session.createQuery(query);

            setQueryParameter(queryObj, column);

            list = queryObj.list();

        } catch (Exception e) {
//			exceptionHandlerService.writeLog(e);
            LOGGER.error("executeSelect", e);
        } finally {
            manager.closeSession(session);
        }

        return list;
    }

    public Integer executeUpdate(String query, Map<String, Object> column) {
        Integer result = null;
        Session session = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            Query queryObj = session.createQuery(query);

            setQueryUpdateParameter(queryObj, column);

            result = queryObj.executeUpdate();

        } catch (Exception e) {
//			exceptionHandlerService.writeLog(e);
            LOGGER.error("executeSelect", e);
        } finally {
            manager.closeSession(session);
        }

        return result;
    }

    public Integer executeSqlUpdate(String query, Map<String, Object> column) {
        Integer result = null;
        Session session = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);

            Query queryObj = session.createSQLQuery(query);

            setQueryUpdateParameter(queryObj, column);

            result = queryObj.executeUpdate();

        } catch (Exception e) {
//			exceptionHandlerService.writeLog(e);
            LOGGER.error("executeSqlUpdate", e);
        } finally {
            manager.closeSession(session);
        }

        return result;
    }

    public void setQueryParameter(Query query, Map<String, Object> column) {
        if (column != null && !column.isEmpty()) {
            if (column.containsKey(ALIAS)) {
                if ("map".equals(column.get(ALIAS))) {
                    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

                } else {
                    query.setResultTransformer(Transformers.aliasToBean((Class) column.get(ALIAS)));
                }

                column.remove(ALIAS);
            }

            if (column.containsKey(FIRSTINDEX)) {
                query.setFirstResult((Integer) column.get(FIRSTINDEX));

                column.remove(FIRSTINDEX);
            }

            if (column.containsKey(MAXRESULT)) {
                query.setMaxResults((Integer) column.get(MAXRESULT));

                column.remove(MAXRESULT);
            }

            for (Map.Entry<String, Object> entity : column.entrySet()) {
                if (entity.getValue() instanceof Collection) {
                    query.setParameterList(entity.getKey(), (Collection) entity.getValue());
                } else {
                    query.setParameter(entity.getKey(), entity.getValue());
                }
            }
        }
    }

    public void setQueryUpdateParameter(Query query, Map<String, Object> column) {
        if (column != null && !column.isEmpty()) {
            for (Map.Entry<String, Object> entity : column.entrySet()) {
                if (entity.getValue() instanceof Collection) {
                    query.setParameterList(entity.getKey(), (Collection) entity.getValue());
                } else {
                    query.setParameter(entity.getKey(), entity.getValue());
                }
            }
        }
    }

    public int executeCommonSP(String spName, String... param) {
        int updatedCount = 0;

        Session session = null;
        LocalSessionManager manager = new LocalSessionManager();

        try {
            session = manager.getSession(sessionFactory);
            StringBuilder queryStr = new StringBuilder("CALL ");
            queryStr.append(spName + " (");
            StringBuilder paramBuilder = new StringBuilder();
            if (param != null) {
                for (String p : param) {
                    if (paramBuilder.length() > 0) {
                        paramBuilder.append(", ");
                    }
                    paramBuilder.append("'" + p + "'");
                }
                queryStr.append(paramBuilder.toString());
                queryStr.append(")");
            }
            SQLQuery query = session.createSQLQuery(queryStr.toString());
            updatedCount = query.executeUpdate();

        } catch (Exception e) {
//            	 exceptionHandlerService.writeLog(e);
            LOGGER.error("executeCommonSP", e);

        } finally {
            manager.closeSession(session);
        }
        return updatedCount;
    }

    public <T> List<T> findEntity(Class classObj, Object... values) {
        //System.out.println("in a find entity...");
        LocalSessionManager manager = new LocalSessionManager();
        Session session = manager.getSession(sessionFactory);
        Criteria criteria;
        List<T> lst;
        criteria = session.createCriteria(classObj);
        int len = values.length % 3;

        if (len != 0) {
            try {
//            throw new ExceptionHandlerService("Arguments Must be triplet of [field, expression(e.g. eq,lt,gt...), value]");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(CommonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        len = values.length / 3;

        for (int i = 0, j = 0; i < len; i++, j += 3) {

            OperationTypeEnum operation = (OperationTypeEnum) values[j + 1];

            switch (operation) {
                case EQ:
                    criteria.add(Restrictions.eq(values[j].toString(),
                            values[j + 2]));
                    break;
                case GE:
                    criteria.add(Restrictions.ge(values[j].toString(),
                            values[j + 2]));
                    break;
                case GT:
                    criteria.add(Restrictions.gt(values[j].toString(),
                            values[j + 2]));
                    break;
                case LE:
                    criteria.add(Restrictions.le(values[j].toString(),
                            values[j + 2]));
                    break;
                case LT:
                    criteria.add(Restrictions.lt(values[j].toString(),
                            values[j + 2]));
                    break;
                case NE:
                    criteria.add(Restrictions.ne(values[j].toString(),
                            values[j + 2]));
                    break;
                case LIKE:
                    criteria.add(Restrictions.ilike(values[j].toString(),
                            values[j + 2]));
                    break;
                case OR:
                    criteria
                            .add(Restrictions.or(Restrictions.ilike(
                                    values[j].toString(), values[j + 2]),
                                    Restrictions.ilike(values[j + 3].toString(),
                                            values[j + 5])));
                    j = j + 3;
                    i++;
                    break;
                case IN:
                    criteria.add(Restrictions.in(values[j].toString(),
                            (Object[]) values[j + 2]));
                    break;
                case ORDERBY:

                    OperationTypeEnum order = (OperationTypeEnum) values[j + 2];
                    if (order == OperationTypeEnum.ASC) {
                        criteria.addOrder(Order.asc(values[j].toString()));
                    } else if (order == OperationTypeEnum.DESC) {
                        criteria.addOrder(Order.desc(values[j].toString()));
                    } else {
                        try {
//                        throw new ExceptionHandlerService("Order by can be ASC or DESC only. use Enum for to specify this.");
                        } catch (Exception ex) {
                            java.util.logging.Logger.getLogger(CommonDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:

            }
        }
        lst = criteria.list();
        return lst;
    }

    public <T> void evictAll(Collection<T> objects) {

        Session session = null;
        Transaction transaction = null;
        LocalSessionManager manager = new LocalSessionManager();
        try {
            session = manager.getSession(sessionFactory);
            transaction = session.beginTransaction();
            for (Object bean : objects) {
                session.evict(bean);
            }
            session.flush();
            transaction.commit();
        } catch (Exception re) {
            if (transaction != null) {
                transaction.rollback();
            }
//		exceptionHandlerService.writeLog(re);
            LOGGER.error(MSGDELETEFAILED, re);
        } finally {
            manager.closeSession(session);
        }
    }

   

}

class LocalSessionManager {

    private boolean isNew = false;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDAO.class);

    public Session getSession(SessionFactory sessionFactory) {
        Session session;
        try {

            session = sessionFactory.openSession();

        } catch (Exception e) {
            isNew = true;
            session = sessionFactory.openSession();
            LOGGER.error(MSGDELETEFAILED, e);

        }
        return session;
    }

    public void closeSession(Session session) {
        if (isNew) {
            SessionFactoryUtils.closeSession(session);
        }
    }

}
