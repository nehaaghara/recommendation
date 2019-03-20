
package com.damani.dal;


import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;


public interface HibernateQueryDao extends GenericDao<Object> {
    List<Object[]> createNewQuery(String query,Map<String,Object> var);
     
     List<Object[]> createByCountNewQuery(String query,Map<String,Object> var,int firstResult,int maxResult);

     public long countForNewQuery(String from,String countOn, String where,Map<String,Object> var) throws Exception;

     List<Object> getSingleColQuery(String query,Map<String,Object> var);

     int updateDeleteNewQuery(String query,Map<String,Object> var);

     int updateDeleteSQLNewQuery(String query,Map<String,Object> var);

     List<Object[]> nativeSQLQuery(String query, Map<String, Object> var);
     
     public List nativeNewQueryToBean(String query, Class classAlias, Map<String, Object> var) throws  HibernateException,  ClassNotFoundException;

}
