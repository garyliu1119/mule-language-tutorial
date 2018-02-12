package com.ggl.esb.exception;

public class WrongStateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongStateException() {
		super("Validation Error");
	}
	
	public WrongStateException(String error) {
		super(error);
	}
	
}
