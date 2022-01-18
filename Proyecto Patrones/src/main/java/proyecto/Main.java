package proyecto;

import org.sonatype.inject.Mediator;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import proyecto.config.DBConnectionManager;
import proyecto.controllers.impl.PlanControllerImpl;
import proyecto.controllers.impl.OrderControllerImpl;
import proyecto.controllers.impl.UsuarioControllerImpl;
import proyecto.integrations.MercadoPagoImpl;
import proyecto.models.MercadoPagoMediator;
import proyecto.repositories.impl.PlanRepoImpl;
import proyecto.repositories.impl.PedidoRepositorioImpl;
import proyecto.repositories.impl.UsuarioRepositorioImpl;

public class Main {

    private final DBConnectionManager manager;
    private final OrderControllerImpl orderController;
    /*private final CustomerControllerImpl customerController;
    private final ProductControllerImpl productController;*/
    private final PlanControllerImpl mercadoPagoController;
    private final UsuarioControllerImpl usuarioController;

    public Main() {
        this.manager = new DBConnectionManager();

        PlanRepoImpl miMPRep = new PlanRepoImpl(this.manager.getDatabase());
        MercadoPagoMediator miMediator = new MercadoPagoMediator(MercadoPagoImpl.getInstance());
        this.mercadoPagoController = new PlanControllerImpl(miMPRep,miMediator);

        PedidoRepositorioImpl pedidoRepImpl = new PedidoRepositorioImpl(this.manager.getDatabase());
        this.orderController = new OrderControllerImpl(pedidoRepImpl);

        UsuarioRepositorioImpl usuarioRepImpl = new UsuarioRepositorioImpl(this.manager.getDatabase());
        this.usuarioController = new UsuarioControllerImpl(usuarioRepImpl);
    }

    public void startup() {
        Info applicationInfo = new Info()
                .version("1.0")
                .description("Demo API");
        OpenApiOptions openApi = new OpenApiOptions(applicationInfo)
                .path("/api")
                .swagger(new SwaggerOptions("/api-ui")); // endpoint for swagger-ui
        Javalin server = Javalin.create(
                config -> {
                    config.registerPlugin(new OpenApiPlugin(openApi));
                }
        ).start(7000);

        server.post("api/order", this.orderController::create);
        server.get("api/order/:id", this.orderController::find);
        server.put("api/order/:id",this.orderController::update);
        server.post("api/order/aprobar",this.orderController::proxAprobador);
        server.get("api/orderbyuser",this.orderController::findOrdersByUser);

        server.post("api/plan", this.mercadoPagoController::create);
        server.post("api/plan/update", this.mercadoPagoController::updateSandboxPoints);
        server.get("api/plan/:id", this.mercadoPagoController::find);

        server.post("api/user", this.usuarioController::create);
        server.get("api/user/:id", this.usuarioController::find);
        server.put("api/user/:id",this.usuarioController::update);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop();
        }));
    }

    public static void main(String[] args) {
        new Main().startup();
    }
}
