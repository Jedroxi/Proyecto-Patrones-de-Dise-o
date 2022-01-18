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

import proyecto.models.Usuario;
import proyecto.repositories.UsuarioRepositorio;

public class UsuarioRepositorioImpl implements UsuarioRepositorio{
    private static final String COLLECTION_NAME = "usuarios";
    private static final FindOneAndReplaceOptions UPDATE_OPTIONS = new FindOneAndReplaceOptions()
            .returnDocument(ReturnDocument.AFTER);
            
    private final MongoCollection<Usuario> usuarios;
    
    public UsuarioRepositorioImpl(MongoDatabase database){
        this.usuarios = database.getCollection(COLLECTION_NAME,Usuario.class);
    }
    @Override
    public void create(Usuario usuario){
        usuario.setId((new ObjectId()).toString());
        usuarios.insertOne(usuario);
    };

    @Override
    public Usuario find(String id){
        return usuarios.find(eq("_id", id)).first();
    };

    @Override
    public List<Usuario> findAll(){
        List<Usuario> result = new LinkedList<>();

        for (Usuario usuario : usuarios.find()) {
            result.add(usuario);
        }

        return result;
    };

    @Override
    public Usuario update(Usuario post, String id){
        return usuarios.findOneAndReplace(new Document("_id", id), post, UPDATE_OPTIONS);
    };

    @Override
    public void delete(String id){
        usuarios.deleteOne(new Document("_id", id));
    };
}
