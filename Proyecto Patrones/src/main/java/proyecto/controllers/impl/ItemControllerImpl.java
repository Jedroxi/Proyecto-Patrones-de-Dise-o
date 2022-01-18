package proyecto.controllers.impl;

import proyecto.repositories.impl.ItemRepoImpl;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import proyecto.controllers.ItemController;
import proyecto.models.ItemService;

import proyecto.models.interfaces.IMediatorCheckOut;

public class ItemControllerImpl implements ItemController{
    private static final String ID = "id";

    private ItemRepoImpl MP_REP;
    private IMediatorCheckOut miMediator;

    public ItemControllerImpl(ItemRepoImpl MP_REP, IMediatorCheckOut miMediator) {
        this.MP_REP = MP_REP;
        this.miMediator = miMediator;
    }

    @Override
    public void create(Context context) {
        ItemService item = context.bodyAsClass(ItemService.class);
        item.setSandboxpoint(miMediator.obtenerUrlPago(item));
        MP_REP.create(item);
    }

    @Override
    public void delete(Context context) {
        MP_REP.delete(context.pathParam(ID));

    }

    @Override
    public void find(Context context) {
        String id = context.pathParam(ID);
        
        ItemService item = MP_REP.find(id);

        if (item == null) {
            throw new NotFoundResponse(String.format("A customer with id '%s' is not found", id));
        }

        context.json(item);

    }

    @Override
    public void findAll(Context context) {
        context.json(MP_REP.findAll());
    }

    @Override
    public void update(Context context) {
        ItemService item = context.bodyAsClass(ItemService.class);
        String id = context.pathParam(ID);

        if (item.getId() != null && !item.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        MP_REP.update(item, id);

    }

    
    public void updateSandboxPoints(Context context) {
        
    }

}
