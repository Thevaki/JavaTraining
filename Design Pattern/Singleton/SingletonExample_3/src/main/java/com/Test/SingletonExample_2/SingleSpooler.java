package com.Test.SingletonExample_2;

/*There might exist many printers in the system, but there should be only one printer spooler.*/

public class SingleSpooler 
{
    public static void main( String[] args )
    {
    	PrintSpooler printSpooler1, printSpooler2;
		
		// open one spooler--this should always work
		System.out.println("Opening one spooler");
		
		try {
			printSpooler1 =  PrintSpooler.getPrintSpooler();
			System.out.println(printSpooler1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// shouldn't allow to create another spooler
		System.out.println("Opening two spoolers");
		try {
			printSpooler2 = PrintSpooler.getPrintSpooler();
			System.out.println(printSpooler2);
			System.out.println("Only one spooler allowed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
    }
}
