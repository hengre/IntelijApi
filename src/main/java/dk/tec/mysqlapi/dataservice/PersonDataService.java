package dk.tec.mysqlapi.dataservice;

import dk.tec.mysqlapi.datasource.InMemDB;
import dk.tec.mysqlapi.datasource.MysqlDB;
import dk.tec.mysqlapi.models.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PersonDataService {

    public PersonDataService(){

    }

    public List<Person> getAllPersons(){
        MysqlDB dbh = new MysqlDB();
        return dbh.getAllPersons();
        //return InMemDB.getInstance().getAllPersons();
    }

    public Person getSinglePerson(int persId){
        MysqlDB dbh = new MysqlDB();
        return dbh.getSinglePerson(persId);
        //return InMemDB.getInstance().getPerson(persId);
    }

    public int addPerson(Person pers){
        MysqlDB dbh = new MysqlDB();
        return dbh.addPerson(pers);
        //return InMemDB.getInstance().addPerson(pers);
    }

    public int updatePerson(int persId, Person pers){
        MysqlDB dbh = new MysqlDB();
        return dbh.updatePerson(persId, pers);
        //return InMemDB.getInstance().updatePerson(persId, pers);
    }

    public int deletePerson(int persId){
        MysqlDB dbh = new MysqlDB();
        return dbh.deletePerson(persId);
        //return InMemDB.getInstance().deletePerson(persId);
    }

}
