package medesata.employee;

import medesata.message.Message;

public abstract class BaseEmployee implements Employee {
    private String firstName;
    private String secondName;
    private String lastName;
    private String gender;
    private int age;

    public BaseEmployee(String firstName,String secondName,String lastName,String gender,int age){
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setAge(age);
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName==null || firstName.trim().isEmpty()){
            throw  new NullPointerException(Message.NULL_NAME);
        }
        this.firstName = firstName;
    }


    @Override
    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName==null ||secondName.trim().isEmpty()){
            throw new NullPointerException(Message.NULL_NAME);
        }
        this.secondName = secondName;
    }


    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName==null || lastName.trim().isEmpty()){
            throw new NullPointerException(Message.NULL_NAME);
        }
        this.lastName = lastName;
    }

    @Override
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender==null || gender.trim().isEmpty()){
            throw new NullPointerException(Message.INVALID_TEXT);
        }
        this.gender = gender;
    }


    @Override
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException(Message.INVALID_AGE);
        }
        this.age = age;
    }


}
