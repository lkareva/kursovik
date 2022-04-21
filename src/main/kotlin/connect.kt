import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

val client = KMongo
    .createClient("mongodb://root:jCmyLsRVQ60v@172.20.10.3:27017")
val mongoDatabase: MongoDatabase = client.getDatabase("kursovik")

