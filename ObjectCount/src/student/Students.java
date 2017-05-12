package student;
class Students
{
public String name;
public int age; 
public static  int numberofobjects=0;

Students (String name, int age)
{
    this.name= name;
    this.age= age;
    numberofobjects++;
   
}
public static void main(String[]args)
{
Students student1= new Students("Subbu", 7);
Students student2= new Students("Vasu", 8);
Students student3= new Students("Ravi", 9);
Students student4= new Students("Vicky", 8);

System.out.println ("There are " + Students.numberofobjects + " objects in this class");

}
}
