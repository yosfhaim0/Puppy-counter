package targil1;
/**
 * To represent an employee who receives a fixed 
 * salary plus a percentage of the profits he earned.
 * @author yosefHaim
 *
 */

public class BasePlusCommissionEmployee extends CommissionEmployee   {
protected float baseSalary;
/**
 * 
 * @param fn the private name
 * @param ln the family name
 * @param id is id number
 * @param grossSales profits
 * @param commision Commission in percentages that the employee receives from his sales
 * @param baseSalary The employee's base salary
 */
BasePlusCommissionEmployee(String fn,String ln,int id,float grossSales,int commision,float baseSalary){
super(fn,ln,id,grossSales,commision);
	try {
	this.setBaseSalary(baseSalary);
	}catch(Exception a){
		this.setBaseSalary(0);
	}
}
BasePlusCommissionEmployee(){
	super();
	baseSalary=0;
}
public float getBaseSalary() {return this.baseSalary;}
public void setBaseSalary(float bs) {
	if(bs<0||bs>900000000)
		throw new RuntimeException("badInput baseSalary");
	this.baseSalary=bs;
}
/**
 * over ride func cheak if this equals to other object
 */
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) o;
    return Float.compare(that.baseSalary, baseSalary) == 0;
}

@Override
public String toString() {
	return super.toString()+" baseSalary: "+String.format("%.02f",baseSalary);
}
public float earnings() {
	
	return baseSalary+super.earnings();
} 

}
