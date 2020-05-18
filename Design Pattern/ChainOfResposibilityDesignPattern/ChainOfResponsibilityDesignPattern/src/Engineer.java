
public class Engineer extends ApprovalLevel{
 
    public Engineer (int level){
          this.level = level;
       }
     
    protected void sendRequest(String message){
        System.out.println("A request was send to the Engineer.");
        System.out.println(message);
         
    }
}
