package dk.tec.mysqlapi.datasource;

import dk.tec.mysqlapi.models.Person;

import java.util.ArrayList;
import java.util.List;

public class InMemDB {

    private static int nextId = 1000;
    private static List<Person> personList;
    private static InMemDB instance;

    private int getNextId(){
        return nextId++;
    }

    private InMemDB(){
        personList = new ArrayList<>();
        personList.add(new Person(getNextId(), "Anders", "And","and@andeby.dk","Er en Disney figur"));
    }

    public static synchronized InMemDB getInstance(){
        if(instance == null){
            instance = new InMemDB();
        }
        return instance;
    }

    public List<Person> getAllPersons(){
        return personList;
    }

    public Person getPerson(int persId){
        //personList.contains(personList.get(0).getPersId() == persId);
        for(Person p: personList){
            if(p.getPersId() == persId){
                return p;
            }
        }
        return null;
    }

    public int updatePerson(int persId, Person pers){
        for(Person p: personList){
            if(p.getPersId() == persId){
                pers.setPersId(persId);
                personList.set(personList.indexOf(p), pers);
                return 1;
            }
        }
        return 0;
    }
    public int deletePerson(int persId){
        for(Person p: personList){
            if(p.getPersId() == persId){
                personList.remove(p);
                return 1;
            }
        }
        return 0;
    }

    public int addPerson(Person pers){
        pers.setPersId(getNextId());
        personList.add(pers);
        return 1;
    }
}
