package br.com.mind.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.mind.bo.ElogioBO;
import br.com.mind.to.ElogioTO;

@Path("/elogio")
public class ElogioResource {
	
	private ElogioBO elogioBO = new ElogioBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ElogioTO> buscar() throws Exception {
		return elogioBO.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response elogiar(ElogioTO elogio , @Context UriInfo uriInfo) throws Exception {
		elogioBO.cadastrar(elogio);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(elogio.getId()));
		return Response.created(builder.build()).build();
	}
}
