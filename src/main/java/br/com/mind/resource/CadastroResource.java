package br.com.mind.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.mind.bo.CadastroBO;
import br.com.mind.to.CadastroTo;

@Path("/cadastro")
public class CadastroResource {
	
	private CadastroBO cadastroBO = new CadastroBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CadastroTo> buscar() throws Exception {
		return cadastroBO.listar();
	}
	
	@GET
	@Path("/usuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CadastroTo> buscarUsers() throws Exception {
		return cadastroBO.listarUsuarios();
	}
	
	@GET
	@Path("/psicologos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CadastroTo> buscarPsicologos() throws Exception {
		return cadastroBO.listarPsicologos();
	}
	
	@GET
	@Path("/estagiarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CadastroTo> buscarEstagiarios() throws Exception {
		return cadastroBO.listarEstagiarios();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CadastroTo cadastro , @Context UriInfo uriInfo) throws Exception {
		cadastroBO.cadastrar(cadastro);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(cadastro.getId()));
		return Response.created(builder.build()).build();
	}
	
}
