package org.janitha.neochem.recources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.janitha.neochem.model.Item;
import org.janitha.neochem.services.ItemService;

@Path("/code")
public class codeResource {

	ItemService itemService = new ItemService();

	@GET
	@Path("/{codeID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCode(@PathParam("codeID") char code) {
		return itemService.getCode(code);

	}
}
