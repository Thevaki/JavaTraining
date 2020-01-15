import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileAsStream{

	public static void main(String[] args) throws IOException {
		String fileName = "FILE PATH";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

}
