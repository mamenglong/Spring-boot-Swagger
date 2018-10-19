/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/19
  Time: 18:17
  To change this template use File | Settings | File Templates.
*/
package org.mml.demo.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(LogUtil.class);
    /**
     * @param str
     */
    public static void info(String str){
        logger.info("*********=>"+str);
    }

    public static void error(String str){
        logger.error("*********=>"+str);
    }

 public static void warn(String str){
        logger.warn("*********=>"+str);
 }
}
