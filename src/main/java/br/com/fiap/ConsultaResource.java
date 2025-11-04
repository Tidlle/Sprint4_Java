package br.com.fiap;

import br.com.fiap.beans.Consulta;
import br.com.fiap.bo.ConsultaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider
@Path("/consulta")
public class ConsultaResource {

    private ConsultaBO consultaBO = new ConsultaBO();

    // Selecionar todas
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Consulta> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Consulta>) consultaBO.selecionarBo();
    }

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Consulta consulta, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        consultaBO.inserirBo(consulta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consulta.getId()));
        return Response.created(builder.build()).build();
    }

    // Atualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Consulta consulta, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        consultaBO.atualizarBo(consulta);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        consultaBO.deletarBo(id);
        return Response.ok().build();
    }
}
