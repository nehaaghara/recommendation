/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.dal;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;


/**
 *
 * @author BigGoal
 */
@Repository
public interface GenericDao<T> {
    void addEntity(T entity);

    void deleteEntity(T entity);

    void deleteAll(Collection<T> collection);

    void updateEntity(T entity);
    
    void updateEntityBySession(T entity);

    void saveOrUpdateEntity(T entity);

    void saveAll(Collection<T> collection);
    
    void updateAll(Collection<T> collection);

    List<T> getAllEntity();

    List<T> findEntity(Object... values);

    List<T> findByCountEntity(int firstResult, int maxResult, Object... values);

    long getEntityCount();    
    
    List<Object[]> createQuery(String query,Map<String,Object> var);
    
    List<Object[]> createSQLQuery(String query,Map<String,Object> var);
    
    public List<Object[]> createSQLQuery(String query, Map<String, Object> var,int[] ncharsIndex,int colcount);

    List<Object[]> createByCountQuery(String query, Map<String,Object> var,int firstResult, int maxResult);

    long countForQuery(String from,String countOn, String where,Map<String,Object> var) ;

    List<Object> singleColQuery(String query,Map<String,Object> var);

    int updateDeleteQuery(String query,Map<String,Object> var);

    int updateDeleteSQLQuery(String query,Map<String,Object> var);
    
    public List nativeQueryToBean(String query, Class classAlias, Map<String, Object> var) throws  HibernateException,  ClassNotFoundException;
}
