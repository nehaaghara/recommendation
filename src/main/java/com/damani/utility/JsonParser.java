/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.springframework.stereotype.Service;

/**
 *
 * @author ITMCS
 */
@Service
public class JsonParser<T> {
     public Object setNewValuesToOldObject(Object oldObject , Object newObject , Class type)throws Exception{
        Field[] fields = type.getDeclaredFields();
        Method[] method = type.getMethods();
        for(int i = 0 ; i < fields.length ; i++){
            for(int j = 0 ; j < method.length ; j++){
                if(method[j].getName().contains("set") && method[j].getName().toLowerCase().equalsIgnoreCase("set"+fields[i].getName().toLowerCase())){
                    Object value = getValues(newObject,fields[i].getName(),type);
                    if(value!=null){
                        System.out.println("fields[i].getName()==="+fields[i].getName());
                        System.out.println("VALUE===="+value);
                        method[j].invoke(oldObject,value);
                    }
                }
            }
        }
        return oldObject;
    }
   
      public Object getValues(Object object,String feildName, Class type)throws Exception{
        Field[] fields = type.getDeclaredFields();
        Method[] method = type.getMethods();
        for(int j = 0 ; j < method.length ; j++){
            if(method[j].getName().contains("get") && method[j].getName().toLowerCase().equalsIgnoreCase("get"+feildName.toLowerCase())){
                Object value = method[j].invoke(object);
                return value;
            }
        }
        return null;
    }
}
