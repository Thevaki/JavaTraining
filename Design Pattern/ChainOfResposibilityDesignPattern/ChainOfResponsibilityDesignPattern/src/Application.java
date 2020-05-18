
public class Application {
	public static void main(String[] args) {
		ApprovalLevel firstApprovalLevel = new Engineer(2);
		ApprovalLevel secondApprovalLevel = new ProjectManager(1);
		ApprovalLevel thirdApprovalLevel = new Director(0);

		firstApprovalLevel.setNextApprovalLevel(secondApprovalLevel);
		secondApprovalLevel.setNextApprovalLevel(thirdApprovalLevel);

		firstApprovalLevel.tryToSendRequest(0, "This is a HIGH priority request."+'\n');

		firstApprovalLevel.tryToSendRequest(1, "This is a MEDIUM priority request."+'\n');

		thirdApprovalLevel.tryToSendRequest(0, "This is a HIGH priority request."+'\n');
	}
}
