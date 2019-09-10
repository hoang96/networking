package vn.topica.itlab4.work.networking.exercises1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Device {
	private String code;
	private String name;
	private String owner;
	private Date inputDate;
	private int warrantyYear;
	SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
	public void setInputDate(String s) throws ParseException {
        this.inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(s);
    }

	public int getWarrantyYear() {
		return warrantyYear;
	}

	public void setWarrantyYear(int warrantyYear) {
		this.warrantyYear = warrantyYear;
	}
	
	public void setWarrantyYear(String s) {
        this.warrantyYear = Integer.parseInt(s);
    }
	
	public Device() {
		
	}
	public Device(String code, String name, String owner, Date inputDate, int warrantyYear) {
		super();
		this.code = code;
		this.name = name;
		this.owner = owner;
		this.inputDate = inputDate;
		this.warrantyYear = warrantyYear;
	}
	
	@Override
	public String toString() {
		return  code + "," + name + "," + owner + "," + dateFormat.format(inputDate)
				+ "," + warrantyYear;
	}
	
	
}
