import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteToFile {
	public void fileWrite(List<String> list) {
		String fileName = "db.txt";
		String pattern2 = "([A-Za-z0-9]+)(\\.txt)";
		Pattern p2 = Pattern.compile(pattern2);
		Matcher m2 = p2.matcher(fileName);
		String data = " ";
		try {
			if (m2.find()) {
				System.out.print("");
			} else {
				throw new Exception("Your file is named incorrectly");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < list.size(); i++) {
				data = list.get(i).substring(0, 10) + "\r\n" + list.get(i).substring(11) + "\r\n";

				bw.write(data);
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
