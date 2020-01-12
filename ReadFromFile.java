import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class UpperCaseConverter {
	public void convertToUpperCase(String mixedCaseLine) {
		System.out.println(mixedCaseLine);
	}
}

public class ReadFromFile extends UpperCaseConverter {

	public static void main(String[] args) {

		FileReader fileReader = null;
		StringBuilder stringBuilder = null;
		ReadFromFile readFromFile = new ReadFromFile();

		try {
			stringBuilder = new StringBuilder();
			fileReader = new FileReader("PATH TO FILE");
			BufferedReader buffereddReader = new BufferedReader(fileReader);
			String line;

			while (null != (line = buffereddReader.readLine())) {
				stringBuilder.append(line);
			}

			System.out.println("File data : " + stringBuilder.toString() + "\n");
			String mixedCaseLine = stringBuilder.toString();
			readFromFile.convertToUpperCase(mixedCaseLine);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void convertToUpperCase(String mixedCaseLine) {
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
