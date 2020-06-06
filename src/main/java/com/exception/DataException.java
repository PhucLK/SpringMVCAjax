package com.exception;

/**
 * @author PhucTV7
 *
 */
public class DataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public DataException (){
		
	}
	
	/**
	 * @param message
	 */
	public DataException (String message){
		super(message);
	}

}
