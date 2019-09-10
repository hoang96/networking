package vn.topica.itlab4.work.networking.exercises1;

import java.util.ArrayList;
import java.util.List;

public class MainEx4 {
	public static List<String> findMostPopular(String str) {
		String temp[] = str.split(" ");
		int count[] = new int[temp.length];
		for(int i=0;i<temp.length;i++) {
			count[i]=0;
			for(int j=0;j<=i;j++) {
				if(temp[j].equals(temp[i])) {
					count[i]++;
				}
			}
		}
		int max=count[0];
		for(int i=0;i<count.length;i++) {
			if(max<count[i]) {
				max=count[i];
			}
		}
		List<String> listStr=new ArrayList<String>();
		for(int i=0;i<count.length;i++) {
			if(count[i]==max) {
				listStr.add(temp[i]);
			}
		}
		return listStr;
	}
	public static void main(String[] args) {
		ReadFile input=new ReadFile();
		WriteFile output=new WriteFile();
		List<Device> listDevice=input.readInput();
		String str="";
		for(Device d : listDevice) {
			d.setOwner(ReadFile.standardizeWord(d.getOwner()));
			str+=d.getOwner()+" ";
		}
		List<String> listStr=findMostPopular(str);
		String strOutput="";
		for(String st : listStr) {
			strOutput+=st+"\n";
		}
		output.Output(strOutput);
	}
}
