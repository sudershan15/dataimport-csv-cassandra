package com.examples.cassandra;

/**
 * Disclaimer:
 * This file is an example on how to use the Cassandra SSTableSimpleUnsortedWriter class to create
 * sstables from a csv input file.
 * While this has been tested to work, this program is provided "as is" with no guarantee. Moreover,
 * it's primary aim is toward simplicity rather than completness. In partical, don't use this as an
 * example to parse csv files at home.
 */
import java.nio.ByteBuffer;
import java.io.*;
import java.util.UUID;

import javax.swing.table.TableModel;


import me.prettyprint.cassandra.service.CassandraHostConfigurator;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.Mutator;

import org.apache.cassandra.db.marshal.*;
//import org.apache.cassandra.io.sstable.SSTableSimpleUnsortedWriter;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.Column;
import org.apache.cassandra.thrift.ColumnParent;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.TBinaryProtocol;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import me.prettyprint.cassandra.serializers.StringSerializer;

import static org.apache.cassandra.utils.ByteBufferUtil.bytes;
import static org.apache.cassandra.utils.UUIDGen.decompose;


public class DataImportExample
{
	final static Cluster cluster = HFactory.createCluster("TestCluster", new CassandraHostConfigurator("localhost:9160"));
	final static Keyspace keyspace = HFactory.createKeyspace("ProjDB", cluster);
	
	//private static final String TWEETS = null;
	static String filename;
	private static StringSerializer ss = StringSerializer.get();

	
	public void insert(Tweet tweet){
		  Mutator<String> m1 = HFactory.createMutator(keyspace, ss);
	        m1.addInsertion(tweet.getKey().toString(),
	                              "events",
	                              HFactory.createStringColumn("Day", tweet.getA()))
	          .addInsertion(tweet.getKey().toString(),
	                            "events",
	                            HFactory.createStringColumn("Time", tweet.getB()))
	          .addInsertion(tweet.getKey().toString(),
	                            "events",
	                            HFactory.createStringColumn("Place", tweet.getC()))
	          .addInsertion(tweet.getKey().toString(),
	                            "events",
	                            HFactory.createStringColumn("Description", tweet.getD()));
	        m1.execute();
    }
    
    public static void main(String[] args) throws IOException, InvalidRequestException, FileNotFoundException, TException{
    	
  	 DataImportExample sample = new DataImportExample();
     TableModel t = CSVParser.parse(new File("C:/Users/Sudershan/Desktop/csvoneclmn.csv"));

      // Print all the columns of the table, followed by a new line.
      /*for (int x = 0; x < t.getColumnCount(); x++) {
    	  System.out.println(t.getColumnName(x) + " ");
      }*/
      System.out.println();
      int v=t.getRowCount();
      int u=t.getColumnCount();
      System.out.println(u+ "    "+v);
      int y=0;
      // Print all the data from the table.
      //for (int x = 0; x < v+1; x++) {
    	  //for (int y = 0; y < t.getColumnCount(); y++)
    	  //while (y!=u)
    	  {
    		  //System.out.print(t.getValueAt(x,y ) + " "+t.getValueAt(x, y+1)+" "+t.getValueAt(x, y+2)+"  "+t.getValueAt(x, y+3)+"\n");
    		  Tweet tweet = new Tweet(UUID.randomUUID(),"","", "","");
    		  sample.insert(tweet);
    		  y=u;
    	  }
    	  System.out.println();
    	//  y=0;
      //}



    
    }

	private void saveTweet(Tweet tweet) {
		// TODO Auto-generated method stub
		
	}
}
