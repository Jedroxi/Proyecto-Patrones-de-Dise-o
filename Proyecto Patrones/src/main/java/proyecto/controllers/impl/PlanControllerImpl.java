package proyecto.controllers.impl;

import proyecto.repositories.impl.PlanRepoImpl;
import io.javalin.http.Context;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.NotFoundResponse;
import proyecto.controllers.PlanController;
import proyecto.models.Plan;
import proyecto.models.interfaces.IMediatorCheckOut;

public class PlanControllerImpl implements PlanController{
    private static final String ID = "id";

    private PlanRepoImpl MP_REP;
    private IMediatorCheckOut miMediator;

    public PlanControllerImpl(PlanRepoImpl MP_REP, IMediatorCheckOut miMediator) {
        this.MP_REP = MP_REP;
        this.miMediator = miMediator;
    }

    @Override
    public void create(Context context) {
        Plan plan = context.bodyAsClass(Plan.class);
        MP_REP.create(plan);
    }

    @Override
    public void delete(Context context) {
        MP_REP.delete(context.pathParam(ID));

    }

    @Override
    public void find(Context context) {
        String id = context.pathParam(ID);
        
        Plan plan = MP_REP.find(id);

        if (plan == null) {
            throw new NotFoundResponse(String.format("A customer with id '%s' is not found", id));
        }

        context.json(plan);

    }

    @Override
    public void findAll(Context context) {
        context.json(MP_REP.findAll());
    }

    @Override
    public void update(Context context) {
        Plan plan = context.bodyAsClass(Plan.class);
        String id = context.pathParam(ID);

        if (plan.getId() != null && !plan.getId().toString().equals(id)) {
            throw new BadRequestResponse("Id update is not allowed");
        }

        MP_REP.update(plan, id);

    }

    
    public void updateSandboxPoints(Context context) {
        
    }

}
