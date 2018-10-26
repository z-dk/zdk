package mongodb;

import com.alibaba.fastjson.JSON;
import com.mongodb.*;

/**
 * Created by z_dk on 2018/10/24.
 */
public class Testmongodb {
    public static void main(String[] args) {
        mongo();
    }
    public static void mongo(){
        MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
        DB db = mongoClient.getDB("mongo");
        DBCollection dbCollection = db.getCollection("user");
        DBCursor dbCursor = dbCollection.find();
        for (DBObject dbObject:dbCursor) {
            System.out.println(JSON.toJSONString(dbObject));
        }

    }
}
