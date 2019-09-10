package vn.topica.itlab4.work.networking.exercises1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
	public void Output(List<Device> listDevice) {
		String fileName="src/output1.txt";
		
		try {
			FileWriter writer = new FileWriter(fileName,true);
			BufferedWriter buffer = new BufferedWriter(writer);
			for(Device d: listDevice) {
				buffer.write(d.toString());
				buffer.newLine();
			}
			buffer.write("###");
			buffer.newLine();
			System.out.println("success");
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Output(String str) {
		String fileName="src/output1.txt";

		try {
			FileWriter writer = new FileWriter(fileName,true);
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(str);
			buffer.newLine();
		
			buffer.write("###");
			buffer.newLine();
			System.out.println("success");
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
