//package com.tracledger.config;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AppContext {
//
//    private static ApplicationContext ctx;
//    private static Object LOCK_OBJECT = new Object();
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        AppContext.ctx = applicationContext;
//    }
//    public static ApplicationContext getApplicationContext() {
//        if (ctx == null) {
//            synchronized(LOCK_OBJECT) {
//                if (ctx == null) {
////                    ctx = new FileSystemXmlApplicationContext(new String[]{"file:/home/sandeep-vassar/Projects/TLM/tlm/project/config/src/main/resources/application-context.xml"});
//                }
//            }
//        }
//
//        return ctx;
//    }
//
//}
