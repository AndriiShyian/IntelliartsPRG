import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws MyException {
		List<String> list = new LinkedList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Customer cos;
		String fileName = "db.txt";
		while (true) {
			try {
				String s = reader.readLine();
				cos = new Customer(s);
				cos.input(cos.getInfo(), list, fileName);
				if (cos.getInfo().length() > 18) {
					list.add(cos.getInfo().substring(9));
					Main m = new Main();
					m.writtingToFile(list);
					WriteToFile w = new WriteToFile();
					w.fileWrite(list);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("wrong");
			}
		}

	}

	public List<String> writtingToFile(List<String> list) throws ParseException {
		String g = "";
		ArrayList<Date> date = new ArrayList<>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i++) {
			Date date1 = format.parse(list.get(i).substring(0, 10));
			date.add(date1);
		}

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).substring(0, 10).equals(list.get(j).substring(0, 10))) {
					g = list.get(i) + "\r\n" + (list.get(j).substring(11));
					list.set(i, g);
					list.remove(list.size() - 1);
				}
				if (date.get(i).compareTo(date.get(j)) == 1) {
					Collections.swap(list, j, i);
				}
			}
		}
		return list;
	}
}
