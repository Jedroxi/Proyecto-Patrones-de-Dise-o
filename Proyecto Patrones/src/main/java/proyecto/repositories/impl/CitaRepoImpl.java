package proyecto.repositories.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import org.bson.Document;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;

import java.util.LinkedList;
import java.util.List;

import proyecto.models.Cita;
import proyecto.repositories.CitaRepositorio;

public class CitaRepoImpl implements CitaRepositorio{
    private static final String COLLECTION_NAME = "citas";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<Cita> citas;

    public CitaRepoImpl(MongoDatabase database) {
        this.citas = database.getCollection(COLLECTION_NAME, Cita.class);
    }
    
    @Override
    public void create(Cita cita){
        cita.setId((new ObjectId()).toString());
        cita.iniciarEstado();
        citas.insertOne(cita);
    };

    @Override
    public Cita find(String id){
        return citas.find(eq("_id", id)).first();
    };

    @Override
    public List<Cita> findAll(){
        List<Cita> result = new LinkedList<>();

        for (Cita cita : citas.find()) {
            result.add(cita);
        }

        return result;
    };

    @Override
    public Cita update(Cita post, String id){
        return citas.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    };

    @Override
    public void delete(String id){
        citas.deleteOne(new Document("_id", id));
    };
}
