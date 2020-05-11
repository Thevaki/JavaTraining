package com.Test.SingletonExample_2;


public class PrintSpooler {
	private static volatile PrintSpooler printSpooler; //=new PrintSpooler();
	
	
	private PrintSpooler() {
		if(printSpooler != null) {
		   throw new RuntimeException("Please use getPrintSpooler method");	
		}
		
	}

	public static PrintSpooler getPrintSpooler() {
		if(printSpooler == null) {
			synchronized(PrintSpooler.class){
				if(printSpooler == null) {
					printSpooler = new PrintSpooler();
				}
			}
		}
		
		return printSpooler;
	}

}
