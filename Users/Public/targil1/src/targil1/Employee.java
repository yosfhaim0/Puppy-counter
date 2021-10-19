package targil1;


public abstract class Employee {
protected String firstName;
protected String lastName;
protected int id;
/**
 * 
 * @param fn the private name
 * @param ln the family name
 * @param id is id number
 */
Employee(String f,String l,int i){
	try {
	this.setFirstName(f);
	this.setLastName(l);
	this.setId(i);
	}catch(RuntimeException a){
		this.setFirstName("plony");
		this.setLastName("almony");
		this.setId(0);
	}
}
Employee(){
	this.setFirstName("plony");
	this.setLastName("almony");
	this.setId(0);
}
public String getFirstName() {return this.firstName;}
public String getLastName() {return this.lastName;}
public int getId() {return this.id;}
public void setFirstName(String f) {this.firstName=f;}
public void setLastName(String l) {this.lastName=l;}
public void setId(int i) {
	if(i<0||i>999999999)
		throw new RuntimeException("badInput");
	this.id=i;
	}
@Override
public String toString() {
	return "firstName: "+firstName+" lastName: "+lastName+" id: "+id;
}
 public abstract float earnings();
}

