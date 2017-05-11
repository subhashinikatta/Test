package student;
class Students
{
public String name;
public int age; 
public static int numberofobjects=0;

Students (String name, int age)
{
    this.name= name;
    this.age= age;
    numberofobjects++;
}
}