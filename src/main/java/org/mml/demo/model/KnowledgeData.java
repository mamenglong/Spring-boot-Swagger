/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/19
  Time: 14:42
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo.model;

import org.json.JSONException;
import org.json.JSONObject;

public class KnowledgeData {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String  toString(){
        String result="";
        JSONObject obj=new JSONObject();
        try {
            obj.put("data",getData());
            result=obj.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
