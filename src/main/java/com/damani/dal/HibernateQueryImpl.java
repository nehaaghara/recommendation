package com.damani.dal;


import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateQueryImpl extends HibernateAbstractClass<Object> implements HibernateQueryDao {
    @Autowired   
    SessionFactory sessionFactory;
    
    @Autowired
    @Qualifier("sessionFactory")
    public void init(SessionFactory factory) {
        System.out.println("in init..");
    	 setSessionFactory(sessionFactory);
         System.out.println("connected");
    }
    
    @Override
    public List<Object[]> createNewQuery(String query, Map<String, Object> var) {
        return super.createQuery(query, var);
    }

    @Override
    public List<Object[]> createByCountNewQuery(String query, Map<String,Object> var,int firstResult, int maxResult) {
        return super.createByCountQuery(query, var,firstResult, maxResult);
    }

    @Override
    public long countForNewQuery(String from,String countOn, String where,Map<String,Object> var) throws Exception {
        return super.countForQuery(from,countOn,where,var);
    }

    @Override
    public List<Object> getSingleColQuery(String query,Map<String,Object> var) {
        return super.singleColQuery(query,var);
    }

    @Override
    public int updateDeleteNewQuery(String query,Map<String,Object> var) {
        return super.updateDeleteQuery(query,var);
    }

    @Override
    public int updateDeleteSQLNewQuery(String query,Map<String,Object> var) {
        return super.updateDeleteSQLQuery(query,var);
    }
  
    @Override
    public List<Object[]> nativeSQLQuery(String query, Map<String, Object> var) {
        return super.createSQLQuery(query,var);
    }  
    
    @Override
    public List nativeNewQueryToBean(String query, Class classAlias, Map<String, Object> var) throws  HibernateException,  ClassNotFoundException{
        return super.nativeQueryToBean(query, classAlias, var);
    }  
}
