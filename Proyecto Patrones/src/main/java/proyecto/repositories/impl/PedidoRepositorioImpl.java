package proyecto.repositories.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.LinkedList;
import java.util.List;

import proyecto.models.OrderService;
import proyecto.repositories.PedidoRepositorio;

public class PedidoRepositorioImpl implements PedidoRepositorio{
    private static final String COLLECTION_NAME = "pedidos";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<OrderService> pedidos;
    
    public PedidoRepositorioImpl(MongoDatabase database){
        this.pedidos = database.getCollection(COLLECTION_NAME,OrderService.class);
    }
    @Override
    public void create(OrderService pedido){
        pedido.setId((new ObjectId()).toString());
        pedidos.insertOne(pedido);
    };

    @Override
    public OrderService find(String id){
        return pedidos.find(eq("_id", id)).first();
    };

    @Override
    public List<OrderService> findAll(){
        List<OrderService> result = new LinkedList<>();

        for (OrderService plan : pedidos.find()) {
            result.add(plan);
        }

        return result;
    };

    @Override
    public OrderService update(OrderService post, String id){
        return pedidos.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    };

    @Override
    public void delete(String id){
        pedidos.deleteOne(new Document("_id", id));
    };

    @Override
    public List<OrderService> findOrderByUser(String idUser){
        List<OrderService> result = new LinkedList<>();
        pedidos.find(eq("idAprobadores", idUser)).into(result);
        return result;
    }
}
