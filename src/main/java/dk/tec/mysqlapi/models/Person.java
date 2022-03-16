package dk.tec.mysqlapi.models;

public class Person {
    private int persId;
    private String firstname;
    private String lastname;
    private String email;
    private String note;

    public Person() {}

    public Person(int persId, String firstname, String lastname, String email, String note) {
        this.persId = persId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.note = note;
    }

    public int getPersId() {
        return persId;
    }

    public void setPersId(int persId) {
        this.persId = persId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
