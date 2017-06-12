package list;

public class ListImpl
{
	public static void main(String[] args) 
	{
		 MyList list = new MyList();
		Employee e=new Employee();
		e.setCompany("HCL");
		e.setName("Subhashini");
		e.setId(51645622);
		list.add(e);
		System.out.println("Company:" +e.getCompany());
		System.out.println("Name:" +e.getName());
		System.out.println("SapId:" +e.getId());
	}

}
