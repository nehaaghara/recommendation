/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damani.utility;

/**
 *
 * @author ITMCS
 */
public class CustomUtility {

    public static Object setNewValuesToOld(Object oldObject, Object newObject, Class type) throws Exception {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.setNewValuesToOldObject(oldObject, newObject, type);
    }
}
