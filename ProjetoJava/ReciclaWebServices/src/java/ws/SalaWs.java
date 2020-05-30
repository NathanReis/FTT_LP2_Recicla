/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import recicla.business.basis.FabricaRepositorio;
import recicla.business.crud.CadastraUsuario;
import recicla.business.crud.Crud;
import recicla.business.validations.IValidation;
import recicla.business.validations.SalaValidation;
import recicla.business.validations.UsuarioValidation;
import recicla.comuns.crud.basis.Entidade;
import recicla.comuns.enums.EntidadesDisponiveis;
import recicla.comuns.vos.Sala;
import recicla.comuns.vos.Usuario;
import recicla.dao.acesso.UsuarioMySQLDAO;
import recicla.dao.repositorio.basis.Repositorio;
import recicla.dao.sala.SalaMySQLDAO;

/**
 * REST Web Service
 *
 * @author vitorlupinetti
 */
@Path("sala")
public class SalaWs {

    @Context
    private UriInfo context;
    SalaMySQLDAO dao;
    IValidation validation;
    /**
     * Creates a new instance of UserWs
     */
    public SalaWs() {
        dao = new SalaMySQLDAO();
        validation = new SalaValidation();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtem-sala-por-id/{salaId}")
    public String getRoomById(@PathParam("salaId") int salaId) throws SQLException {
        
        Sala sala = (Sala) dao.consultar(salaId);
        Gson g = new Gson();
       
        return g.toJson(sala);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtem-sala-por-chave/{chave}")
    public String getRoomByKey(@PathParam("chave") String chave) throws SQLException { 
        Sala sala = (Sala) dao.consultar(chave);
        Gson g = new Gson();
       
        return g.toJson(sala);
    }
    

    /**
     * PUT method for updating or creating an instance of UserWs
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/adciona-sala")
    public String addRoom(String salaJson) throws SQLException {
        Gson g = new Gson();
        Sala sala = g.fromJson(salaJson, Sala.class);
        
        boolean isValid = validation.validate(sala);
        
        if(isValid){
            dao.inserir(sala);
            return g.toJson(sala);
        }
        else
            return null;
               
    }
}