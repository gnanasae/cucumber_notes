package com.amazon.frameworkconstants;

public final class FrameworkConstants { // cannot extends the class
	// no changes made so final, and private so
	
	
	private static final String RESOURCESPATH = System.getProperty("user.dir");
	private static final String CONFIGFILEPATH = RESOURCESPATH
			+ "\\src\\main\\java\\com\\configproperties\\config.properties";
	

	private FrameworkConstants() { // cannot create an object for the class

	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
