package com.stefanini.resources;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.dao.UsuarioDAO;
import com.stefanini.entity.UsuarioEntity;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResourse {
	@Inject UsuarioDAO usuarioDao;
	
	@POST
	public Response SalvarUsuario(@Valid UsuarioEntity usuario) {
		usuarioDao.save(usuario);
		return Response.ok().status(Response.Status.CREATED).build();
	}
	
	@GET
	public Response ListarUsuarios() {
		return Response.ok(usuarioDao.listAll()).status(Response.Status.OK).build();
	}
	
	@Path("/{idUsuario}")
	@GET
	public Response ListarUsuarioPorID(@PathParam("idUsuario") Long idUsuario) {
		return Response.ok(usuarioDao.findById(idUsuario)).status(Response.Status.OK).build();
	}
	
	@PUT
	public Response AtualizarUsuario(@Valid UsuarioEntity usuario) {
		return Response.ok(usuarioDao.update(usuario)).status(Response.Status.ACCEPTED).build();
	}
	
	@Path("/{idUsuario}")
	@DELETE
	public Response DeletarUsuario(@PathParam("idUsuario") Long idUsuario) {
		usuarioDao.delete(idUsuario);
		return Response.ok().status(Response.Status.OK).build();
	}
}
