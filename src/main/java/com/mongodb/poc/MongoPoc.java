package com.mongodb.poc;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.poc.codecs.ExtendedPropertyCodec;
import com.mongodb.poc.models.Pojo;
import com.mongodb.poc.models.Transaction;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromCodecs;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.function.Consumer;

public class MongoPoc {
    public static void main(String[] args) {
//        ObjectId oid = new ObjectId();
//
//        DBObject o = new BasicDBObject();

//        Object o2 = o.get("hello");

//        MongoClient c = new MongoClient();
//        c.getDatabase("test").getCollection("bar").insertOne(null);
//        c.getDB("test").getCollection("bar").insert((DBObject)o2);

//        System.out.println(o2.toString());

//        Document doc = new Document("applicability", Arrays.asList("test", new Document("mtc", "test2"), null));
//
//        for(Object d: (List<Object>) doc.get("applicability")) {
//            System.out.println("Testing value for Document: " + (d instanceof Document));
//            System.out.println("Testing value for String: " + (d instanceof String));
//        }

//        Bson query = or(eq("a", 3), eq("b", 10), lte("c", new Date()));
//        c.getDatabase("test").getCollection("foo").find(query);
//        System.out.println(query.toBsonDocument(Document.class, c.getDatabase("test").getCodecRegistry()).toString());
//        System.out.println(c
//                .getDatabase("test")
//                .getCollection("foo")
//                .find(query)
//                .modifiers(new Document("$explain", true)).first().toJson());
//
//
//        MongoCollection<Document> collectionNewDialo = c.getDatabase("renault").getCollection("new_dialo");
//
//        collectionNewDialo.aggregate(Arrays.asList(
//                Aggregates.project(Projections.fields(Arrays.asList(Projections.exclude())))
//        ));

//        List<String> mtcLinesDocuments = Arrays.asList("X89");
//
//        List<Bson> pipeline = Arrays.asList(
//                Aggregates.match(and(in("type", "SIE_MR", "SIE_MD", "SIE_BT", "SIE_TM", "CATALOG_PLATE"),
//                        eq("status", "VALID"),
//                        or(in("computedData.applicability", mtcLinesDocuments),
//                                in("computedData.applicability.mtc", mtcLinesDocuments)),
//                        exists("computedData.nodes"))),
//                Aggregates.project(Projections.fields(Projections.include("type"),
//                        // Projections.computed("ObjectCode",
//                        // "$computedData.objectOriginCode"),
//                        Projections.computed("applicability",
//                                new Document("$filter",
//                                        new Document().append("input", "$computedData.applicability")
//                                                .append("as", "applicability")
//                                                .append("cond", new Document("$or", Arrays.asList(
//                                                        new Document("$in", Arrays.asList("$$applicability", mtcLinesDocuments)),
//                                                        new Document("$in", Arrays.asList("$$applicability.mtc", mtcLinesDocuments))))))))));
//
//        AggregateIterable<Document> doc = collectionNewDialo.aggregate(pipeline);
//
//
//        System.out.println(pipeline.toString());
//
//        for(Document d: doc) {
//            System.out.println(d.toString());
//        }

//        BasicDBList l = new BasicDBList();
//        BasicDBObject o = new BasicDBObject("foo", l);
//        l.add(new BasicDBObject("bar", "baz"));
//        l.add(new BasicDBObject("qux", "yup"));
//
//        List<BasicDBObject> l2 = (List<BasicDBObject>) o.get("foo");
//
//        Iterator i = l.iterator();
//
//        while(i.hasNext()) {
//            DBObject d = (DBObject) i.next();
//            System.out.println((String) d.get("foo"));
//            System.out.println(d.toString());
//        }
//
//        for(DBObject d: l2) {
//            System.out.println(d.toString());
//        }


//        boolean b = boolean.class.cast("false");
//        System.out.println("Boolean: " + b);

        CodecRegistry pojoCodecRegistry = fromRegistries(
                fromCodecs(new ExtendedPropertyCodec()),
                fromProviders(PojoCodecProvider.builder().register(Pojo.class, Transaction.class).build()),
                MongoClient.getDefaultCodecRegistry());
        final MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://localhost:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry)));

//
//        final Morphia morphia = new Morphia();
//        morphia.mapPackage("com.mongodb.poc.models");
//
//        final Datastore ds = morphia.createDatastore(mongo, "morphia_example");
//        Iterator<Transaction> tx = ds.createAggregation(Pojo.class)
//                .unwind("transactions")
//                .project(
//                        Projection.projection("label", "transactions.label"),
//                        Projection.projection("value", "transactions.value")
//                )
//                .aggregate(Transaction.class);
//
//        while(tx.hasNext()) {
//            Transaction cur = tx.next();
//
//            System.out.println(cur.getClass());
//            System.out.println(cur.toString());
//        }
//

        final MongoDatabase db = mongo.getDatabase("morphia_example");
//        final MongoCollection<Pojo> collection = db.getCollection("transaction_buckets").withDocumentClass(Pojo.class);
////
////        AggregateIterable<Transaction> res = collection.aggregate(Arrays.asList(
////                Aggregates.unwind("$transactions"),
////                Aggregates.replaceRoot("$transactions")
////        ));
////
////        res.forEach((Consumer<Transaction>) current -> {
////            System.out.println(current.getClass());
////            System.out.println(current.toString());
////        });
////
//        FindIterable<Pojo> pojos = collection.find(Pojo.class);
//
//        pojos.forEach((Consumer<Pojo>) pojo -> {
//            System.out.println(pojo.getClass());
//            System.out.println(pojo.toString());
//        });


    }
}
