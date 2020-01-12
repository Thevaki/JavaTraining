import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteFile {

	public static void main(String[] args) {

		try {
			FileWriter fileWriter = new FileWriter("FILE PATH");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Hello..Welcome to java file writing");
			bufferedWriter.close();
			fileWriter.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("File writing process completed");
	}

}
