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

import proyecto.models.Plan;
import proyecto.repositories.PlanRepositorio;

public class PlanRepoImpl implements PlanRepositorio{
    private static final String COLLECTION_NAME = "planes";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<Plan> planes;

    public PlanRepoImpl(MongoDatabase database) {
        this.planes = database.getCollection(COLLECTION_NAME, Plan.class);
    }
    
    @Override
    public void create(Plan plan){
        plan.setId((new ObjectId()).toString());
        planes.insertOne(plan);
    };

    @Override
    public Plan find(String id){
        return planes.find(eq("_id", id)).first();
    };

    @Override
    public List<Plan> findAll(){
        List<Plan> result = new LinkedList<>();

        for (Plan plan : planes.find()) {
            result.add(plan);
        }

        return result;
    };

    @Override
    public Plan update(Plan post, String id){
        return planes.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    };

    @Override
    public void delete(String id){
        planes.deleteOne(new Document("_id", id));
    };
}
