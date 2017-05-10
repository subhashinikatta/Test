package data;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="address")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    
    @XmlElement(required=true) 
    protected int number;

    @XmlElement(required=true)  
    protected String street;
    
    @XmlElement(required=true)  
    protected String city;
    
    @XmlElement(required=true) 
    protected String state;
    
    @XmlElement(required=true)  
    protected String zip;
    
    @XmlElement(required=true)
    protected String country;
    
    public Address() { }

	public String getNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStreet() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getZip() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNumber(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setStreet(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setCity(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setState(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setZip(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setCountry(String string) {
		// TODO Auto-generated method stub
		
	}

	


    // Getter and setter methods
    // ...
}