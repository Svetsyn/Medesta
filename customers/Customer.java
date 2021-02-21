package medesata.customers;

import medesata.customers.Customers;
import medesata.message.Message;

public abstract class Customer implements Customers {

    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Customer(String firstName, String secondName, String lastName, String email, String phoneNumber) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
    }


    @Override
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new NullPointerException(Message.NULL_NAME);
        }

        this.firstName = firstName;
    }

    @Override
    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName == null || secondName.trim().isEmpty()) {
            throw new NullPointerException(Message.NULL_NAME);
        }

        this.secondName = secondName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new NullPointerException(Message.NULL_NAME);
        }

        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new NullPointerException(Message.NULL_NAME);
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException(Message.INVALID_FORMAT);
        }

        this.email = email;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new NullPointerException(Message.NULL_PHONE_NUMBER);
        }
    }


    //TODO

}
