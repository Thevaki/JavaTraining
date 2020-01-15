package FileReading;

public class TestEmployee {
	public static void main(String[] args) {  
	    
	    Employee acc=new Employee();  
	    
	    acc.setAcc_no(7560504000L);  
	    acc.setName("ABC");  
	    acc.setEmail("abc@gmail.com");  
	    acc.setAmount(5000);  
	    
	    System.out.println(acc.getAcc_no()+" "+acc.getName()+" "+acc.getEmail()+" "+acc.getAmount());  
	}  
}
