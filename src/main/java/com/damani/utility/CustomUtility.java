/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 *
 * @author ITMCS
 */
public class CustomUtility {

    public static Object setNewValuesToOld(Object oldObject, Object newObject, Class type) throws Exception {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.setNewValuesToOldObject(oldObject, newObject, type);
    }
    
    public static String convertToJsonString(Object obj){
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        System.out.println("gson:>"+obj);
	return gson.toJson(obj);
    }
}
