package com.mziuri;

import com.mziuri.service.StorageReaderService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Application {

    public static void main(String[] args) throws LifecycleException {

        StorageReaderService storageReaderService = StorageReaderService.instance();
        storageReaderService.addProductsFromJsonFile("src/main/resources/storage.json");

        Tomcat tomcat = new Tomcat();
        tomcat.enableNaming();
        tomcat.setPort(8989);
        tomcat.getConnector();

        String ctxPath = "/candy-shop";
        String webappDir = new File("src/main/webapp").getAbsolutePath();
        StandardContext ctx = (StandardContext) tomcat.addWebapp(ctxPath, webappDir);

        File additionWebInfClasses = new File("build/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();

    }

}