package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import com.day.cq.search.Query;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import com.day.cq.search.result.Hit;

@Component
(
    service = Servlet.class,
    property = {    
        "sling.servlet.paths=/bin/querybuilder/pqb",
    }
)
public class PractiseQueryBuilder2 extends SlingAllMethodsServlet {

    @Reference
    private QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException , ServletException {
        ResourceResolver resourceResolver = request.getResourceResolver();

            Map<String, String> predicateMap = new HashMap<>();
            predicateMap.put("path", "/content/we-retail/us/en");
            predicateMap.put("type", "cq:Page");
            predicateMap.put("p.limit", "10");  
            predicateMap.put("orderby", "@jcr:created");
            predicateMap.put("orderby.sort", "desc");
           
            Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), resourceResolver.adaptTo(Session.class));
            SearchResult result = query.getResult();
             for (Hit hit : result.getHits() ) {
                try {
                    response.getWriter().write("Path: " + hit.getPath() + ", Title: " + hit.getTitle() + "\n");
                } 
                catch (RepositoryException e) {
                   response.getWriter().write("Repository error for a hit: " + e.getMessage() + "\n");
                }
            }
        }
    }
