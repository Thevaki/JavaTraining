
public class ProjectManager extends ApprovalLevel{
 
    public ProjectManager (int level){
          this.level = level;
       }
     
    protected void sendRequest(String message){
        System.out.println("A request was send to the PROJECT MANAGER.");
        System.out.println(message);
         
    }
}
