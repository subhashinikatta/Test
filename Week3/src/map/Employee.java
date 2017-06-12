
package map;
public class Employee 
{
	private int sapid;
	private int salary;
	private String name;
	
	public Employee(){
		
	}
	
	public Employee(int sapid, int salary, String name)
	{
		super();
		this.sapid = sapid;
		this.salary = salary;
		this.name = name;
	}
	public int getSapid() 
	{
		return sapid;
	}
	public void setSapid(int sapid) 
	{
		this.sapid = sapid;
	}
	public int getSalary() 
	{
		return salary;
	}
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

}
