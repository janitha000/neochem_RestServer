package org.janitha.neochem.recources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.janitha.neochem.model.Item;
import org.janitha.neochem.services.ItemService;

@Path("/items")
public class Itemresource {

	ItemService itemService = new ItemService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems() {
		return itemService.getItems();

	}

	@GET
	@Path("/{itemID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("itemID") long id) {
		return itemService.getItem(id);

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addItem(Item item) {
		return itemService.addItem(item);
		

	}

	@PUT
	@Path("/{itemID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Item updateItem(@PathParam("itemID") long id, Item item) {
		return itemService.updateItem(item);
	}
	
	@DELETE
	@Path("/{itemID}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteItem(@PathParam("itemID") long id){
		itemService.removeItem(id);
		
	}
	

}
