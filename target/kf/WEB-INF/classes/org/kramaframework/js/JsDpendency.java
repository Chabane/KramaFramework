package org.kramaframework.js;

/**
 * Defined a javascript dependency
 * 
 * @author chabane
 * @version 1.0
 */
public class JsDpendency {

	// Name of javascript dependency
	private String name;
	// Name file of javascript library
	private String file;
	// Version of javascript library
	private String version;
	
	/**
	 * Constructor
	 * @param name
	 * @param file
	 * @param version
	 */
	public JsDpendency(String name, String file, String version) {
		this.name = name;
		this.file = file;
		this.version = version;
	}

	/*
	 * Getters
	 */
	public String getName() {
		return name;
	}

	public String getFile() {
		return file;
	}

	public String getVersion() {
		return version;
	}
}
