package com.sample.project;

/**
 * Hello world!
 *
 */
public class App 
{
	private String name = "";
	
	public void doSomething() {
        int i = 5; // Unused
    }
	
    public static void main( String[] args )
    {
    	SimpleDateFormat sdf = null;
    	try {
    	    sdf = new SimpleDateFormat("yyyy-MM-dd");
    	} catch (Throwable th) {  //Should not catch throwable
    	    th.printStackTrace();
    	}
    	
    }
}
