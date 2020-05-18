
public class Director extends ApprovalLevel{
 
    public Director (int level){
          this.level = level;
       }
     
    protected void sendRequest(String message){
        System.out.println("A request was send to the DIRECTOR.");
        System.out.println(message);
         
    }
}
