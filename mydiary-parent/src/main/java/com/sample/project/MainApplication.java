package com.sample.project;

/**
 * MainApplication
 *
 */
public class MainApplication 
{
	private String name = "";
	
	public void doSomething() {
        int i = 5; // Unused
    }
	
    public static void main( final String[] args )
    {
    	SimpleDateFormat sdf = null;
    	try {
    	    sdf = new SimpleDateFormat("yyyy-MM-dd");
    	} catch (Throwable th) {  //Should not catch throwable
    	    th.printStackTrace();
    	}
    	
    }
}
