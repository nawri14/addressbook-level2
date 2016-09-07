package seedu.addressbook.data.person;

public class Contact {

	
	public String value;
	protected boolean isPrivate;
	
	public Contact(boolean isPrivate){
		this.isPrivate = isPrivate;
	}
	
	public boolean isValid(String value, String regex) {
		return value.matches(regex);
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
	public int hashCode(){
		return value.hashCode();
	}
	
    public boolean isPrivate() {
        return isPrivate;
    }
    
    public void setValue(String value){
    	this.value = value;
    }
    
    
}
