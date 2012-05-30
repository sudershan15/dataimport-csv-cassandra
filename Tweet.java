package com.examples.cassandra;

import java.io.Serializable;
import java.util.UUID;

	public class Tweet implements Serializable {
	    public UUID getKey() {
			return key;
		}

	

		public String getA() {
			return a;
		}

		public String getB() {
			return b;
		}

		public String getC() {
			return c;
		}

		public String getD() {
			return d;
		}



		private final UUID key;
	    private final String a;
	    private final String b;
	    private final String c;
	    private final String d;

	    public Tweet(UUID key, String uname, String body, String c, String d) {
	        this.key = key;
	        this.a = (String) uname;
	        this.b = (String)body;
	        this.c = (String)c;
	        this.d = (String)d;
	        
	    }

		
	    // Eliminated get/set for clarity
	}