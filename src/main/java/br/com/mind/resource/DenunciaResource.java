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

import br.com.mind.bo.DenunciaBO;
import br.com.mind.to.DenunciaTO;


@Path("/denuncia")
public class DenunciaResource {
	
	private DenunciaBO denunciaBO = new DenunciaBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DenunciaTO> buscar() throws Exception {
		return denunciaBO.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response denunciar(DenunciaTO denuncia , @Context UriInfo uriInfo) throws Exception {
		denunciaBO.cadastrar(denuncia);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(denuncia.getId()));
		return Response.created(builder.build()).build();
	}

}
