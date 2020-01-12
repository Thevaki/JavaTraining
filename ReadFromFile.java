import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class UpperClassConverter {
	public void convertToUpperClass(String mixedCaseLine) {
		System.out.println(mixedCaseLine);
	}
}

public class ReadFromFile extends UpperClassConverter {

	public static void main(String[] args) {

		FileReader fileReader = null;
		StringBuilder stringBuilder = null;
		ReadFromFile readFromFile = new ReadFromFile();

		try {
			stringBuilder = new StringBuilder();
			fileReader = new FileReader("E://User/Study/Java Code/Test.txt");
			BufferedReader buffereddReader = new BufferedReader(fileReader);
			String line;

			while (null != (line = buffereddReader.readLine())) {
				stringBuilder.append(line);
			}

			System.out.println("File data : " + stringBuilder.toString() + "\n");
			String mixedCaseLine = stringBuilder.toString();
			readFromFile.convertToUpperClass(mixedCaseLine);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void convertToUpperClass(String mixedCaseLine) {
		String upperCaseLine = "";

		char character;
		for (int i = 0; i < mixedCaseLine.length(); i++) {
			if ('a' <= mixedCaseLine.charAt(i) && mixedCaseLine.charAt(i) <= 'z') {
				character = (char) (mixedCaseLine.charAt(i) - 32);
			} else {
				character = mixedCaseLine.charAt(i);
			}
			upperCaseLine += character;
		}
		System.out.println(upperCaseLine);

	}
}
