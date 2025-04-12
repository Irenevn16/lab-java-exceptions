import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
   
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        Person p1 = new Person(1, "Gema Pérez", 28, "Abogada");
        Person p2 = new Person (2, "Pedro Gómez", 68, "Jubilado");
        //añadir a la lista
        personList.addPerson(p1);
        personList.addPerson(p2);





    }
   


}