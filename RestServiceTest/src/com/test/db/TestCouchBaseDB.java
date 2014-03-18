package com.test.db;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import com.couchbase.client.CouchbaseClient;

public class TestCouchBaseDB {
	public static void main(String[] args) throws Exception {
		 
	    // (Subset) of nodes in the cluster to establish a connection
	    List<URI> hosts = Arrays.asList(
	      new URI("http://127.0.0.1:8091/pools")
	    );
	 
	    // Name of the Bucket to connect to
	    String bucket = "test";
	 
	    // Password of the bucket (empty) string if none
	    String password = "";
	 
	    // Connect to the Cluster
	    CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);
	 
	    // Store a Document
	    client.set("my-first-document", "Hello Couchbase!").get();
	 
	    // Retreive the Document and print it
	    System.out.println(client.get("my-first-document"));
	 
	    // Shutting down properly
	    client.shutdown();
	  }
}
