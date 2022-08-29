package it.bitrock.mongodbstart.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.pojo.PojoCodecProvider;


import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBConfiguration {
    private static final MongoDBConfiguration MONGO_DB_CONFIGURATION = new MongoDBConfiguration();
    private MongoDBConfiguration() {
    }
    public static MongoDBConfiguration getInstance() {
        return MONGO_DB_CONFIGURATION ;
    }
    protected final String URI ="mongodb+srv://root:Ecko7dHTOAOKkulM@cluster0.qnmving.mongodb.net/?retryWrites=true&w=majority";
    private final String DATABASE = "sample_mflix";

    private  MongoClientSettings mongoClientSettings(){
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URI))
                .applicationName("mongo-db-start")
                .build();
    }


    public MongoDatabase mongoDatabase() {
        MongoClient mongoClient = MongoClients.create(mongoClientSettings());
            return mongoClient.getDatabase(DATABASE).withCodecRegistry(fromRegistries(getDefaultCodecRegistry()
                    , fromProviders(PojoCodecProvider.builder().automatic(true).build())));
    }



}
