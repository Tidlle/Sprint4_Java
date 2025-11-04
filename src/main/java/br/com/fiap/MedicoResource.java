package br.com.fiap;

import br.com.fiap.beans.Medico;
import br.com.fiap.bo.MedicoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/medico")
public class MedicoResource {

    private MedicoBO medicoBO = new MedicoBO();

    // Selecionar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Medico> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Medico>) medicoBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Medico medico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        medicoBO.inserirBo(medico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(medico.getId()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Medico medico, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        medicoBO.atualizarBo(medico);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        medicoBO.deletarBo(id);
        return Response.ok().build();
    }
}
