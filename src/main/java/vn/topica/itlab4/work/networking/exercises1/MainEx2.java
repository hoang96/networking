package vn.topica.itlab4.work.networking.exercises1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MainEx2 {
	public static void main(String[] args) {
		ReadFile input=new ReadFile();
		WriteFile output=new WriteFile();
		List<Device> listDevice=input.readInput();
		for(Device d : listDevice) {
			d.setOwner(ReadFile.standardizeWord(d.getOwner()));
		}
		//sort by warrantyYear
		Collections.sort(listDevice, new Comparator<Device>() {
            public int compare(Device p1, Device p2) {
                return p1.getWarrantyYear() > p2.getWarrantyYear() ? -1 : 1;
            }
        });
		//write data to output1.txt
		output.Output(listDevice);


	}

}
