package targil1;

public class HourlyEmployee extends Employee {
	/**
	 * hours=sum of the hours the Employee work
	 * wage= price per hour for Employee work
	 */
public int hours;
public float wage;
/**
 * 
 * @param fn the private name
 * @param ln the family name
 * @param id is id number
 * @param hours is the number of employee work
 * @param wage is the selery per hour
 */
HourlyEmployee(String fn,String ln,int id,int hours,float wage){
	super(fn,ln,id);
	this.setHours(hours);
	this.setWage(wage);
}
HourlyEmployee(){
	super();//turn on the defult constractor of the faterh
	this.hours=0;
	this.wage=0;
}
public int getHours() {return this.hours;}
public float getWage() {return this.wage;}
public void setHours(int ho) {
	if(ho<0)
		throw new RuntimeException("badInput hours");
	this.hours=ho;
	}public void setWage(float wa) {
		if(wa<0)
			throw new RuntimeException("badInput wage");
		this.wage=wa;
		}
	/**
	 * over ride func cheak if this equals to other object
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HourlyEmployee that = (HourlyEmployee) o;
        return Float.compare(that.wage, wage) == 0 && hours==that.hours;
    }
	@Override
public String toString() {
	return super.toString()+" hours: "+hours+" wage: "+String.format("%.02f",wage);
}
public float earnings() {
	return hours*wage;
} 
}
