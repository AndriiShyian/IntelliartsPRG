import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	private String info;
	private double USDUAHPLNEURO[] = { 0.038, 0.250, 1.07 };
	private double EUROUSDUAHPLN[] = { 0.95, 0.035, 0.240 };
	private double PLNUSDUAHEURO[] = { 4, 0.142, 5 };
	private double UAHUSDEUROPLN[] = { 27, 30, 7 };
	private List<String> datas = new ArrayList<String>();
	private double numberForReportingAboutProduct = 1;
	private List<Double> listUsedForReporting = new ArrayList<Double>();

	public Customer() {

	}

	public Customer(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String toString() {
		return info;
	}

	public String input(String info, List<String> list, String fileName) throws Exception {
		String pattern = "purchase (((2018|2019)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]))) [0-9]*[.,]?[0-9] (USD|UAH|EURO|PLN) [A-Za-z-]{1,25}";
		String pattern2 = "all";
		String pattern3 = "clear (((2018|2019)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])))";
		String pattern4 = "report (2018|2019) (USD|UAH|EURO|PLN)";
		Pattern p = Pattern.compile(pattern);
		Pattern p2 = Pattern.compile(pattern2);
		Pattern p3 = Pattern.compile(pattern3);
		Pattern p4 = Pattern.compile(pattern4);
		Matcher m = p.matcher(info);
		Matcher m2 = p2.matcher(info);
		Matcher m3 = p3.matcher(info);
		Matcher m4 = p4.matcher(info);
		if (m.matches()) {
			System.out.println("Your information was written to file");
		} else if (m2.matches()) {
			ReadFromFile r = new ReadFromFile();
			r.readFromFile();
		} else if (m3.matches()) {
			PrintWriter writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).contains(info.substring(8))) {
					list.remove(i);
				}
			}
			WriteToFile w = new WriteToFile();
			w.fileWrite(list);
			System.out.println("It was cleared");
		} else if (m4.matches()) {
			String pattern5 = "[0-9]*[.,]?[0-9] (USD|UAH|EURO|PLN)";
			Pattern p5 = Pattern.compile(pattern5);
			String pattern6 = "[0-9]*[.]?[0-9]";
			Pattern p6 = Pattern.compile(pattern6);

			for (int i = 0; i < list.size(); i++) {
				if (info.substring(7, 11).equals(list.get(i).substring(0, 4))) {
					Matcher m5 = p5.matcher(list.get(i));
					while (m5.find()) {
						datas.add(list.get(i).substring(m5.start(), m5.end()));
					}
				}
			}
			for (int j = 0; j < datas.size(); j++) {
				Matcher m6 = p6.matcher(datas.get(j));
				if (m6.find()) {
					String s = datas.get(j).substring(m6.start(), m6.end());
					numberForReportingAboutProduct = Double.parseDouble(s);
				}

				if (info.contains("USD")) {
					if (datas.get(j).contains("UAH")) {
						numberForReportingAboutProduct *= USDUAHPLNEURO[0];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("PLN")) {
						numberForReportingAboutProduct *= USDUAHPLNEURO[1];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("EURO")) {
						numberForReportingAboutProduct *= USDUAHPLNEURO[2];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("USD")) {
						listUsedForReporting.add(numberForReportingAboutProduct);
					}

				}

				if (info.contains("EURO")) {
					if (datas.get(j).contains("USD")) {
						numberForReportingAboutProduct *= EUROUSDUAHPLN[0];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("UAH")) {
						numberForReportingAboutProduct *= EUROUSDUAHPLN[1];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("PLN")) {
						numberForReportingAboutProduct *= EUROUSDUAHPLN[2];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("EURO")) {
						listUsedForReporting.add(numberForReportingAboutProduct);
					}

				}

				if (info.contains("PLN")) {
					if (datas.get(j).contains("USD")) {
						numberForReportingAboutProduct *= PLNUSDUAHEURO[0];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("UAH")) {
						numberForReportingAboutProduct *= PLNUSDUAHEURO[1];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("EURO")) {
						numberForReportingAboutProduct *= PLNUSDUAHEURO[2];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("PLN")) {
						listUsedForReporting.add(numberForReportingAboutProduct);
					}

				}
				if (info.contains("UAH")) {
					if (datas.get(j).contains("USD")) {
						numberForReportingAboutProduct *= UAHUSDEUROPLN[0];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("EURO")) {
						numberForReportingAboutProduct *= UAHUSDEUROPLN[1];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("PLN")) {
						numberForReportingAboutProduct *= UAHUSDEUROPLN[2];
						listUsedForReporting.add(numberForReportingAboutProduct);
					} else if (datas.get(j).contains("UAH")) {
						listUsedForReporting.add(numberForReportingAboutProduct);
					}

				}
			}

			double summing = 0;
			for (int i = 0; i < listUsedForReporting.size(); i++) {
				summing += listUsedForReporting.get(i);
			}
			String formattedDouble = String.format("%.2f", summing);
			System.out.println(formattedDouble);
			summing = 0;
		} else {
			throw new Exception("Bad info input");
		}
		return info;
	}
}
