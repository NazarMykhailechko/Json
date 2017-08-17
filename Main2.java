package json;

public class Main2 {
    public static void main(String[] args) {

        /*{"name":"Nazar",
           "surname":"Mykhailechko",
           "phones":["044-777-77-77","098-999-99-99"],
           "sites":["http://site1.com","http://site2.com"],
           "address":{
                     "country":"Ukraine",
                     "city":"Kyiv",
                     "street":"Khreschatyk, 1"
           }
          }*/

        Person person = Person.deserialize("D:\\person.json");
        person.setSalary(3000.00);
        System.out.println(person);
        System.out.println("--------------------------------");
        person.serialize("D:\\newPerson.json");

    }
}
