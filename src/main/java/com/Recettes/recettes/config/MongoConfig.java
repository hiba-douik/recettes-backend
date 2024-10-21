package com.Recettes.recettes.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "Recette_Project"; // Change this to your actual database name
    }

    @Override
    public MongoClient mongoClient() {
        // Replace <db_password> with your actual password
        String uri = "mongodb+srv://hibadouik:hibadouik29@cluster0.etryl.mongodb.net/" + getDatabaseName() + "?retryWrites=true&w=majority";
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}