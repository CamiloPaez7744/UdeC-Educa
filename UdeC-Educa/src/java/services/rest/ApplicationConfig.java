/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kmilo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(services.rest.AuditoriaFacadeREST.class);
        resources.add(services.rest.CategoryFacadeREST.class);
        resources.add(services.rest.CompetitorFacadeREST.class);
        resources.add(services.rest.EventueFacadeREST.class);
        resources.add(services.rest.FeedbackFacadeREST.class);
        resources.add(services.rest.IdentificationTypeFacadeREST.class);
        resources.add(services.rest.InstitutionFacadeREST.class);
        resources.add(services.rest.StatusueFacadeREST.class);
        resources.add(services.rest.SuscriptionFacadeREST.class);
        resources.add(services.rest.UserueFacadeREST.class);
    }
    
}
