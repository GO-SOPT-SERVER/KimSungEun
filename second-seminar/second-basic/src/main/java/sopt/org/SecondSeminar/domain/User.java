package sopt.org.SecondSeminar.domain;

import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String gender;
    private String name;
    private String contact;
    private int age;

    public User(String gender, String name, String contact, int age) {
        this.gender = gender;
        this.name = name;
        this.contact = contact;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n"+
                "gender: " + this.gender + "\n" +
                "name: " + this.name + "\n" +
                "contact: " + this.contact + "\n" +
                "age: " + this.age;
    }
}
