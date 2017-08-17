package json;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Person {

    @SerializedName("name")
    @Expose(serialize = true, deserialize = true)
    private String firstName;
    @SerializedName("surname")
    @Expose(serialize = true, deserialize = true)
    private String secondName;
    @Expose(serialize = true, deserialize = true)
    private String[] phones;
    @Expose(serialize = true, deserialize = true)
    private String[] sites;
    @Expose(serialize = true, deserialize = true)
    private Address address;
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void serialize(final String path){
        try (FileWriter fw = new FileWriter(path)){
            new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                             .create()
                             .toJson(this, fw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Person deserialize(final String path) {
        Person person=null;
        try {
            person = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                                      .create()
                                      .fromJson(new FileReader(path),Person.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return person;
    }
    @Override
    public String toString() {
        return this.getClass() + ":\n" +
                "name: " + firstName + "\n" +
                "surname: " + secondName + "\n" +
                "phones: " + Arrays.toString(phones) + "\n" +
                "sites: " + Arrays.toString(sites) + "\n" +
                "address: " + address + "\n" +
                "salary: " + salary;
    }
}