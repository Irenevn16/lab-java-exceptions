import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person person;
    private PersonList personList;

    @BeforeEach
    void setUp() {
        person = new Person(1, "Ana López", 25, "Ingeniera");
        personList = new PersonList();
        personList.addPerson(person);
    }

    @Test
    @DisplayName("setAge lanza excepción si la edad es menor que 0")
    void setAgeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));
    }

    @Test
    @DisplayName("findByName retorna el objeto correcto si el nombre está bien formateado")
    void findByNameReturnsCorrectPerson() {
        Person found = personList.findByName("Ana López");
        assertEquals(person.getName(), found.getName());
        assertEquals(person.getAge(), found.getAge());
    }

    @Test
    @DisplayName("findByName lanza excepción si el nombre está mal formateado")
    void findByNameThrowsExceptionOnBadFormat() {
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("Ana"));
        assertThrows(IllegalArgumentException.class, () -> personList.findByName("AnaLópez"));
    }

    @Test
    @DisplayName("clone crea una nueva persona con el mismo contenido y diferente id")
    void cloneCreatesNewPerson() {
        Person cloned = personList.clone(person, 2);
        assertNotEquals(person.getId(), cloned.getId());
        assertEquals(person.getName(), cloned.getName());
        assertEquals(person.getAge(), cloned.getAge());
        assertEquals(person.getOccupation(), cloned.getOccupation());
    }

    @Test
    @DisplayName("equals compara correctamente dos personas ignorando el id")
    void equalsComparesCorrectly() {
        Person another = new Person(99, "Ana López", 25, "Ingeniera");
        assertTrue(person.equals(another));
    }

    @Test
    @DisplayName("equals devuelve false si las propiedades no coinciden")
    void equalsReturnsFalseIfDifferent() {
        Person different = new Person(99, "Ana López", 30, "Abogada");
        assertFalse(person.equals(different));
    }

}
