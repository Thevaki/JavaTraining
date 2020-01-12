import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("FILE PATH");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i;
			
			while((i=bufferedReader.read())!= -1) {
				System.out.print((char)i);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
