import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteFileAsStream {
	private static void writeUsingOutputStream(String data) {
        OutputStream outputStream = null;
        try {
        	outputStream = new FileOutputStream(new File("FILE PATH"));
        	outputStream.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
            	outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static void main(String[] args) {
        String data = "Hi..Welcome to java file writing";

        writeUsingOutputStream(data);
        System.out.println("Finished Writing data to File");
    }
}
