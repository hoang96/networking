package vn.topica.itlab4.work.networking.exercises1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MainEx3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFile input=new ReadFile();
		WriteFile output=new WriteFile();
		List<Device> listDevice=input.readInput();
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		Date start=new Date();
		Date end=new Date();
		try {
			start= dateFormat.parse("31/10/2018");
			end=dateFormat.parse("31/10/2019");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<Device> itr=listDevice.iterator();
		//get all product has code contain "TOPICA"
		while(itr.hasNext()) {
			Device d = itr.next();
			if(!d.getCode().contains("TOPICA")||d.getInputDate().after(end)||d.getInputDate().before(start)) {
				itr.remove();
				
			}
		}
		//process standardize field owner of product
		for(Device d : listDevice) {
			d.setOwner(ReadFile.standardizeWord(d.getOwner()));
		}
		//sort list product by inputDate
		//if two product has same inputDate, sort by warrantyYear
		Collections.sort(listDevice, new Comparator<Device>() {
            public int compare(Device p1, Device p2) {
            	int year1=p1.getWarrantyYear();
            	int year2=p2.getWarrantyYear();
            	Date date1=p1.getInputDate();
            	Date date2=p2.getInputDate();
            	if(date1.equals(date2)) {
            		return year1>year2 ? 1 : -1;
            	}else {
            		return date1.after(date2) ? -1 : 1;
            	}
            }
        });
		//write data to output1.txt
		output.Output(listDevice);

	}
}
