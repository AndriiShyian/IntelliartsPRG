import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFile {
	public void readFromFile() {
		String fileName = "db.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}