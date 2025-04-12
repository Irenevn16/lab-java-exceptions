import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person (int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("La edad no puede ser 0 o menor");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean equals (Person other) {
        if (other == null) return false;
        return this.name.equals(other.name) &&
                this.age == other.age &&
                this.occupation.equals(other.occupation);
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Occupation: " + occupation;
    }

}
