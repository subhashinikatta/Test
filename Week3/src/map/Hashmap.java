
package map;


public class Hashmap 
{
	public static void main(String[] args) 
	{
		MyMap map=new MyMap();
		Employee e=new Employee();
		e.setSapid(51645622);
		e.setName("Subhashini");
		e.setSalary(25000);
		map.put(0, e);
		//map.remove(0);
		System.out.println("SapId:" +e.getSapid());
		System.out.println("Salary:" +e.getSalary());
		System.out.println("Name:" +e.getName());
			
	}

}

