
public abstract class ApprovalLevel {
	 
    protected int level;
  
    protected ApprovalLevel nextApprovalLevel;

    public void setNextApprovalLevel(ApprovalLevel nextApprovalLevel){
       this.nextApprovalLevel = nextApprovalLevel;
    }

    public void tryToSendRequest(int level, String requestMessage){
        
        if(this.level >= level){
        	sendRequest(requestMessage);
       }
        
       if(nextApprovalLevel !=null){
    	   nextApprovalLevel.tryToSendRequest(level, requestMessage);
       }
    }

    abstract protected void sendRequest(String requestMessage);
}
