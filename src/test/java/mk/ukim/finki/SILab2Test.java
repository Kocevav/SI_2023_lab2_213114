package mk.ukim.finki;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SILab2Test {

    @Test
    void testFunctionWithNullUser() {
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class,()->SILab2.function(null,null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    }

    @Test
    void testFunctionWithNullPassword() {
        RuntimeException ex;
        User user = new User("Veronika", null, "kocevav@yahoo.com");
        List<User> allUsers = new ArrayList<>();
allUsers.add(user);
        ex=assertThrows(RuntimeException.class,()->SILab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
    @Test
    void testFunctionWithNullEmail() {
        RuntimeException ex;
        User user = new User("Veronika", "Koceva123*", null);
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user);
        ex=assertThrows(RuntimeException.class,()->SILab2.function(user,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }


    @Test
    void testFunctionWithExistingUser() {
        List<User> allUsers = new ArrayList<>();
        User user= new User("Veronika","Koceva123*","kocevav@yahoo.com");
        User user1=new User("Veronika","Koceva3*","kocevav@yahoo.com");
        allUsers.add(user);
        allUsers.add(user1);

        boolean result = SILab2.function(user, allUsers);

        assertEquals(false, result);
    }
    @Test
    void testFunctionWithSameEmailAndUsername() {
        User user = new User("Veronika", "Koceva123*", "kocevav@yahoo.com");
        User existingUser = new User("Veronika", "Doe123*", "kocevav@yahoo.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(existingUser);

        boolean result = SILab2.function(user, allUsers);

        assertEquals(false, result);
    }

    @Test
    void testFunctionWithNonExistingUser() {
        User user = new User("Veronika", "Koceva123*", "kocevav@yahoo.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);

        assertEquals(true, result);
    }

    @Test
    void testFunctionWithValidPassword() {
        User user = new User("Veronika", "Koceva123*", "kocevav@yahoo.com");
        List<User> allUsers = new ArrayList<>();

        boolean result = SILab2.function(user, allUsers);

        assertEquals(true, result);
    }

    @Test
void testFunctionWithInvalidPassword() {
    User user = new User("Veronika", "Koceva", "kocevav@yahoo.com");
    List<User> allUsers = new ArrayList<>();

    boolean result = SILab2.function(user, allUsers);

    assertEquals(false, result);
}
// Multiple Condition
    @Test
    void testFunctionWithAllConditionsTrue() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        User user = new User("Veronika", null, null);
        List<User> allusers = new ArrayList<>();
        allusers.add(user);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, allusers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Veronika", null, null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Veronika", null, null),
                new ArrayList<>()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    }

    @Test
    void testFunctionWithAllConditionsFalse() {
        User user = new User("Veronika", "Koceva123*", "kocevav@yahoo.com");
        List<User> allUsers = new ArrayList<>();
        boolean result = SILab2.function(user, allUsers);
        assertTrue(result);
    }
}
