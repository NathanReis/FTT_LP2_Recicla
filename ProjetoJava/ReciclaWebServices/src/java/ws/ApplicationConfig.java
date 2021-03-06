/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author vitorlupinetti
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
        resources.add(ws.ItensUsuarioWs.class);
        resources.add(ws.ItensWs.class);
        resources.add(ws.JogoWs.class);
        resources.add(ws.PerguntaQuizWs.class);
        resources.add(ws.RecordeWs.class);
        resources.add(ws.RodadaWs.class);
        resources.add(ws.SalaWs.class);
        resources.add(ws.UserWs.class);
    }
    
}
