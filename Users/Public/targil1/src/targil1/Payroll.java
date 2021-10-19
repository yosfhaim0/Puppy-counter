package targil1;

import java.util.ArrayList;

public class Payroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> arr =new ArrayList<Employee>();
		arr.add(0, new HourlyEmployee("hana","zilberstat",123,30,364));
		arr.add(new CommissionEmployee("simon","gabay",456,100000,5));
		arr.add(new BasePlusCommissionEmployee("yron","amrusi",789,200000,5,35));
		for(Employee i:arr) {
			if(i instanceof CommissionEmployee) {
				System.out.println(i.toString()+"\n earnings: "+String.format("%.02f", i.earnings()*1.1));
				}else {
				System.out.println(i.toString()+"\n earnings: "+String.format("%.02f", i.earnings()));
		}
		}

	}
}
