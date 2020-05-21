
public class DocWriterClient {
	public static void main(String[] args) {
		DocWritereCareTaker caretaker = new DocWritereCareTaker();

		DocWriter DocWriter = new DocWriter("data.txt");
		DocWriter.write("First Set of Data\n");
		System.out.println(DocWriter);

		caretaker.save(DocWriter);
		DocWriter.write("Second Set of Data\n");

		System.out.println(DocWriter);

		caretaker.undo(DocWriter);

		System.out.println(DocWriter);
	}
}
