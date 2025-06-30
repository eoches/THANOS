package com.adobe.aem.guides.demo.core.servlets;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.*;

import org.apache.sling.api.resource.ResourceResolver;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

@Component(service = Servlet.class,
           property = {
                   "sling.servlet.paths=/bin/qb",
           })
public class PractiseQueryBuilderServlet extends SlingAllMethodsServlet {

    @Reference
    QueryBuilder queryBuilder;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws IOException , ServletException {
       
        ResourceResolver resourceResolver = request.getResourceResolver();

        // Build predicate map
        Map<String, String> predicateMap = new HashMap<>();
        predicateMap.put("path", "/content/we-retail/us/en");
        predicateMap.put("type", "cq:Page");
        predicateMap.put("p.limit", "10");

        Query query = queryBuilder.createQuery(PredicateGroup.create(predicateMap), resourceResolver.adaptTo(Session.class));
        SearchResult result = query.getResult();

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for (Hit hit : result.getHits()) {
            try {
                JsonObjectBuilder pageJson = Json.createObjectBuilder();
                pageJson.add("path", hit.getPath());
                pageJson.add("title", hit.getTitle());
                jsonArrayBuilder.add(pageJson);
            } catch (RepositoryException e) {
                response.getWriter().write("Error retrieving page info. " + e.getMessage());
            }
        }

        response.getWriter().write(jsonArrayBuilder.build().toString());
    }
}



