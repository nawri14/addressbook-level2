package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Block;
import seedu.addressbook.data.person.Street;
import seedu.addressbook.data.person.Unit;
import seedu.addressbook.data.person.Postal;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    
    public final String[] addressArr;
    //public final String value;
    private boolean isPrivate;
    
    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        addressArr = address.split(",");
        block = new Block(addressArr[0]);
        street = new Street(addressArr[1]);
        unit = new Unit(addressArr[2]);
        postal = new Postal(addressArr[3]);
        
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + "," + street.getStreet() + "," + unit.getUnit() + "," + postal.getPostal();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block))
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postal.equals(((Address)other).postal); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}