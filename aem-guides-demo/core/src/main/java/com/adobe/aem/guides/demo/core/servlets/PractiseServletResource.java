package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Component(
    immediate = true,
    enabled = true,
    service = Servlet.class,
    property = {
        "sling.servlet.resourceTypes=Demo/components/title",
        "sling.servlet.methods=GET",
        "sling.servelt.methods=POST",
        "sling.servelt.extensions=json",
        "sling.servelt.extensions=txt",
        "sling.servlet.selectors=resource",  
    }
)
public class PractiseServletResource  extends SlingAllMethodsServlet{

//     @Override
//     protected void doGet(SlingHttpServletRequest request,
//                          SlingHttpServletResponse response)  throws ServletException,IOException {
        
//         JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
//         jsonBuilder.add("event", "article");
//         jsonBuilder.add("title", "AEM Guides Demo Article");
//         jsonBuilder.add("description", "This is a demo article for AEM Guides.");
//         jsonBuilder.add("author", "AEM Guides Team");
//         jsonBuilder.add("date", "2023-10-01");

//         response.getWriter().write(jsonBuilder.build().toString());

// }

@Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws ServletException, IOException 
    {
        String rootArticlePage="/content/we-retail";
        PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
        Page articlePage = pageManager.getPage(rootArticlePage);
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        Iterator<Page> childPages = articlePage.listChildren();
        while (childPages.hasNext()) {
            Page childPage = childPages.next();
            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("title", childPage.getTitle());
            jsonBuilder.add("path", childPage.getPath());
            jsonArrayBuilder.add(jsonBuilder);
        }
         response.getWriter().write(jsonArrayBuilder.build().toString());

    }
}
