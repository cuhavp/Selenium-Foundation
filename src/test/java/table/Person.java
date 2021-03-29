package table;

public class Person {
    String firsName;
    String lastName;
    String email;
    float due;
    String website;


    public Person(String firsName, String lastName, String email, float due, String website) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getFullName(){
        return String.format("%s %s",firsName,lastName);
    }
}
