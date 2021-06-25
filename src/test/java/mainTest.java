import Domain.Project;
import Domain.Role;
import Domain.Sprint;
import Domain.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class mainTest {

    @Test
    void createUser(){
        User bob = new User();
        bob.setAge(25);
        bob.setEmail("Bob@hotmail.com");
        bob.setName("Bob");


        System.out.println(bob.toString());

        assertEquals(bob.toString(), "User{Name='Bob', role=null, age=25, email='Bob@hotmail.com', notification='null'}");
    }

    @Test
    void createBacklogItems(){
        Project project = new Project();
//        Sprint sprint = new Sprint()




    }
}
