package mongodb;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

import data.WeatherData;


public class MongoHelper{
	/*static Mongo m; 
	static DB db;
	static Morphia mp;
	static DBCollection collection;
	public MongoHelper() throws UnknownHostException,MongoException {
		m= new Mongo();
		db=m.getDB( "Climspace" );
		collection = db.getCollection("Climspace");
	}
*/
	/*static{
		try {
			m= new Mongo();
			db=m.getDB( "Climspace" );
			mp = new Morphia();
			collection = db.getCollection("Climspace");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}*/
		
	public static void persist(WeatherData oNewWeatherData){
		Mongo m =null; 
		DB db=null;
		Morphia mp=null;
		DBCollection collection=null;
		Datastore datastore=null;
		 /*"{'stationName':'YOBC1','currTime':'20120201/1856'}";
		String json= jsonString.replace('"', '\'');
		DBObject dbObject = (DBObject)JSON.parse(json);
		collection.insert(dbObject);*/
		try {
			m= new Mongo();
			db=m.getDB( "WeatherData" );
			mp = new Morphia();
			datastore = new Morphia().createDatastore(m, "WeatherData");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBObject weatherDataObj = mp.toDBObject(oNewWeatherData);
		datastore.save(weatherDataObj);
	}
}
