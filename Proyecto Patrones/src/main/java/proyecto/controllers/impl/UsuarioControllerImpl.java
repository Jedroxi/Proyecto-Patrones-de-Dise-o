package proyecto.controllers.impl;

import proyecto.controllers.UsuarioController;
import proyecto.models.Usuario;
import proyecto.repositories.UsuarioRepositorio;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;

public class UsuarioControllerImpl implements UsuarioController{
    private static final String ID = "id";

    private UsuarioRepositorio repo;

    public UsuarioControllerImpl(UsuarioRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public void create(Context context) {
        Usuario usuario = context.bodyAsClass(Usuario.class);
        /*String sbBasic = "https://sandbox.mercadopago.com.pe/checkout/v1/redirect?pref_id=388838619-7bc0e5fd-ce0b-4e20-a453-8d114605a5d7";
        Plan planBasico = new Plan("BASICO",120.0,sbBasic);*/
        repo.create(usuario);
        context.json(usuario);
    }

    @Override
    public void delete(Context context) {
        repo.delete(context.pathParam(ID));

    }

    @Override
    public void find(Context context) {
        String id = context.pathParam(ID);
        
        Usuario usuario = repo.find(id);

        if (usuario == null) {
            throw new NotFoundResponse(String.format("A customer with id '%s' is not found", id));
        }

        context.json(usuario);

    }

    @Override
    public void findAll(Context context) {
        context.json(repo.findAll());
    }

    @Override
    public void update(Context context) {
        Usuario usuario = context.bodyAsClass(Usuario.class);
        String id = context.pathParam(ID);

        if (usuario.getId() != null && !usuario.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        repo.update(usuario, id);

    }

    
    public void updateSandboxPoints(Context context) {
        
    }

    @Override
    public void login(Context context) {
        Usuario usuario = repo.login(context.formParam("id"),context.formParam("pass"));
        if(usuario==null){
            throw new NotFoundResponse("No se encontró al usuario");
        }else{
            context.json(usuario);
        }
        
    }

}
