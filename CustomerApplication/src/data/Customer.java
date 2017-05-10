package data;
//import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    
    @XmlAttribute(required=true) 
    protected int id;
    
    @XmlElement(required=true) 
    protected String firstname;
    
    @XmlElement(required=true) 
    protected String lastname;
    
    @XmlElement(required=true)
    protected Address address;
    
    @XmlElement(required=true)
    protected String email;
 
    @XmlElement (required=true)
    protected String phone;

    
    public Customer() { }


	public String getFirstname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getLastname() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}


	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}


	public Address getAddress() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}


	public void setAddress(Address address2) {
		// TODO Auto-generated method stub
		
	}


	public void setFirstname(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setLastname(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setEmail(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setPhone(String string) {
		// TODO Auto-generated method stub
		
	}


    // Getter and setter methods
    // ...
}