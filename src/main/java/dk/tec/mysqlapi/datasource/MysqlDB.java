package dk.tec.mysqlapi.datasource;

import dk.tec.mysqlapi.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDB {

    private String dbConnect = "jdbc:mysql://localhost/persondb";
    private String user = "roleUser";
    private String password = "user42";
    Connection connect;

    public MysqlDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
    private void setConnect(){
        try {
            connect = DriverManager.getConnection(dbConnect, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        if(connect != null){
            System.out.println("Connected1");
        }
    }
    private void disConnect(){
        if(connect != null) {
            try {
                connect.close();
                System.out.println("Disconnected");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Person> getAllPersons(){
        setConnect();
        List<Person> personList = new ArrayList<>();

        String query = "SELECT * FROM person";

        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    Person p = new Person();
                    p.setPersId(rs.getInt("id"));
                    p.setFirstname(rs.getString("firstname"));
                    p.setLastname(rs.getString("lastname"));
                    p.setEmail(rs.getString("email"));
                    p.setNote(rs.getString("note"));
                    personList.add(p);
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disConnect();

        return personList;
    }
    public Person getSinglePerson(int persId){

        Person p = new Person();
        setConnect();

        String query = "SELECT * FROM person WHERE id = ?";

        try {
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, persId);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){

                p.setPersId(rs.getInt("id"));
                p.setFirstname(rs.getString("firstname"));
                p.setLastname(rs.getString("lastname"));
                p.setEmail(rs.getString("email"));
                p.setNote(rs.getString("note"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        disConnect();
        System.out.println("Success");

        return p;
    }

    public int addPerson(Person p){
        if(p == null) return 0;

        setConnect();

        String query = "INSERT INTO person (firstname, lastname, email, note) values (?,?,?,?)";

        try {
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, p.getFirstname());
            stmt.setString(2, p.getLastname());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getNote());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disConnect();

        return 1;

    }

    public int updatePerson(int persId, Person p){

        setConnect();

        int result = 0;

        String query = "UPDATE person SET firstname = ?, lastname = ?, email = ?, note = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, p.getFirstname());
            stmt.setString(2, p.getLastname());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getNote());
            stmt.setInt(5, persId);

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disConnect();

        return result;
    }

    public int deletePerson(int persId){

        setConnect();

        int result = 0;

        String query = "DELETE FROM person WHERE id = ?";

        try {
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setInt(1, persId);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        disConnect();

        return result;
    }
}
