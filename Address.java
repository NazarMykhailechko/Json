package json;

import com.google.gson.annotations.Expose;

public class Address {
    @Expose(serialize = true, deserialize = true)
    private String country;
    @Expose(serialize = true, deserialize = true)
    private String city;
    @Expose(serialize = true, deserialize = true)
    private String street;

    @Override
    public String toString() {
        return this.getClass() + "\n" +
                "country: " + country + "\n" +
                "city: " + city + "\n" +
                "street: " + street;
    }
}