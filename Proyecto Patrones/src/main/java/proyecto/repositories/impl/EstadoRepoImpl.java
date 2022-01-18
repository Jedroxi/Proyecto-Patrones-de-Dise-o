package proyecto.repositories.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

import java.util.LinkedList;
import java.util.List;

import proyecto.models.estados.State;
import proyecto.repositories.EstadoRepositorio;

public class EstadoRepoImpl implements EstadoRepositorio{

    private static final String COLLECTION_NAME = "estados";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private static MongoCollection<State> estados;

    public EstadoRepoImpl() {
       
    }

    public static void setDatabase(MongoDatabase database){
        estados = database.getCollection(COLLECTION_NAME, State.class);
    }


    @Override
    public void create(State estado){
        estado.setId((new ObjectId()).toString());
        estados.insertOne(estado);
    }

    @Override
    public State find(String id) {
        return estados.find(eq("_id",id)).first();
    };

    public List<State> findStatesFromCita(String idCita){
        List<State> result = new LinkedList<>();
        estados.find(eq("idCita", idCita)).into(result);
        return result;
    }
    
}
