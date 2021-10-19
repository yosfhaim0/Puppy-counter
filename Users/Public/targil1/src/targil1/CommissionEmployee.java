package targil1;
public class CommissionEmployee extends Employee {
public float grossSales;
public int commision;
/**
 * 
 * @param fn the private name
 * @param ln the family name
 * @param id is id number
 * @param grossSales profits
 * @param commision Commission in percentages that the employee receives from his sales
 */
public CommissionEmployee(String fn,String ln,int id,float grossSales,int commision){
	super(fn,ln,id);
	try {
	this.setGrossSales(grossSales);
	this.setCommision(commision);
	}
	catch(Exception a)
	{
		this.setGrossSales(0);
		this.setCommision(0);
	}
}
CommissionEmployee(){
	super();
	this.commision=0;
	this.grossSales=0;
}
public float getGrossSales() {return this.grossSales;}
public int getCommision() {return this.commision;}
public void setGrossSales(float gs) {
	if(gs<0)
		throw new RuntimeException("badInput grossSales");
	this.grossSales=gs;
	}
public void setCommision(int c) {
	if(c<0)
		throw new RuntimeException("badInput commision");
	this.commision=c;}
/**
 * over ride func cheak if this equals to other object
 */
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    CommissionEmployee that = (CommissionEmployee) o;
    return Float.compare(that.grossSales, grossSales) == 0 && commision == that.commision;
}
@Override
public String toString() {
	return super.toString()+" grossSales: "+String.format("%.02f",grossSales)+" commision: "+commision;
}
public float earnings() {
	return (((float)commision/100)*grossSales);
} 
}

