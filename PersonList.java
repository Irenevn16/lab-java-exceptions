import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


public class PersonList {
    ArrayList<Person> personList = new ArrayList<>();
    public void addPerson(Person person) {
        personList.add(person);
    }
    public Person findByName(String name)throws IllegalArgumentException {
        if (name == null || !name.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+\\s[A-Za-zÁÉÍÓÚáéíóúÑñ]+$")) {
        throw new IllegalArgumentException("El nombre debe estar en el formato 'firstName lastName'");
        }
        for (Person p : personList) {
            return p;
        }
        throw new IllegalArgumentException("No se encontró una persona con ese nombre");
    }
    public Person clone (Person original ,int newId) {
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
    }
    public void writeToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(person.toString());
        } catch (IOException e) {
            System.out.println("Error escribiendo en el archivo: " + e.getMessage());
        }
    }
}
