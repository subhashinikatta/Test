package list;
import java.util.*;
public class ListImpl
{
	public static void main(String[] args) 
	{

		List<Employee> list=new ArrayList<Employee>();
		Employee e=new Employee();
		e.setCompany("HCL");
		e.setName("Subhashini");
		e.setId(51645622);
		list.add(e);
		for(Employee e1:list)
		{
			System.out.println("Company is "+e.getCompany());
			System.out.println("Name is "+e.getName());
			System.out.println("SapId is "+e.getId());
		}
	}

}
