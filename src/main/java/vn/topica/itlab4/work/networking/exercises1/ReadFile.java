package vn.topica.itlab4.work.networking.exercises1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadFile {
	public List<Device> readInput() {
		List<Device> listDevice = new ArrayList<Device>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		String fileName = "src/input1.txt";
		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			try {
				// read each line in file input1.txt
				while ((line = bufferedReader.readLine()) != null) {
					String[] content = line.split(",");
					dateFormat.setLenient(false);
					// check date valid
					Date date = null;
					int year = Integer.parseInt(content[4]);
					try {
						date = dateFormat.parse(content[3]);
					} catch (ParseException e) {
						System.out.println("Invalid date");
						continue;
					}
					// add to list Device
					listDevice.add(new Device(content[0], content[1], content[2], date, year));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDevice;
	}

	public static String standardizeWord(String s) {
		StringBuffer sb = new StringBuffer();
		String str = s.replaceAll("\\s+", " ");
		String[] arr = str.toLowerCase().trim().split(" ");
		for (int i = 0; i < arr.length; i++) {
			String strArr = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
			sb.append(strArr + " ");

		}
		String standardizeWord = sb.toString().trim();
		return standardizeWord;

	}
}
