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
import proyecto.models.ItemService;

import proyecto.repositories.ItemRepositorio;

public class ItemRepoImpl implements ItemRepositorio{
    private static final String COLLECTION_NAME = "items";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);

    private final MongoCollection<ItemService> items;

    public ItemRepoImpl(MongoDatabase database) {
        this.items = database.getCollection(COLLECTION_NAME, ItemService.class);
    }
    
    @Override
    public void create(ItemService item){
        item.setId((new ObjectId()).toString());
        items.insertOne(item);
    };

    @Override
    public ItemService find(String id){
        return items.find(eq("_id", id)).first();
    };

    @Override
    public List<ItemService> findAll(){
        List<ItemService> result = new LinkedList<>();

        for (ItemService item : items.find()) {
            result.add(item);
        }

        return result;
    };

    @Override
    public ItemService update(ItemService post, String id){
        return items.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    };

    @Override
    public void delete(String id){
        items.deleteOne(new Document("_id", id));
    };
}
