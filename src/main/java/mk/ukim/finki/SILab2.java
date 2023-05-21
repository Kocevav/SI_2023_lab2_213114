package mk.ukim.finki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {
    public static void main(String[] args) {
        List<User> allUsers=new ArrayList<>();
        User user= new User("Veronika","Koceva123*","kocevav@yahoo.com");
        User user1=new User("Veronika","Koceva3*","kocevav@yahoo.com");
        allUsers.add(user);
        allUsers.add(user1);
        function(user,allUsers);
    }
    public static boolean function (User user, List<User> allUsers) {//1

        if (user==null || user.getPassword()==null || user.getEmail()==null){ //2
            throw new RuntimeException("Mandatory information missing!");//3
        }//4

        if (user.getUsername()==null){//5
            user.setUsername(user.getEmail()); //6
        }

        int same = 1; //7
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //8
            same = 0; //9            //10.1
            for (int i=0;i<allUsers.size();i++) { //10
                User existingUser = allUsers.get(i); //11
                if (existingUser.getEmail() == user.getEmail()) { //12
                    same += 1; //13
                }
                if (existingUser.getUsername() == user.getUsername()) { //14
                    same +=  1; //15
                }
                //i++  10.2
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //16
        String password = user.getPassword(); //16
        String passwordLower = password.toLowerCase(); //16

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //17
            return false; //18
        }
        else { //19
            if (!passwordLower.contains(" ")) { //20
                for (int i = 0; i < specialCharacters.length(); i++) { //21
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //22
                        return same == 0; //23
                    }
                    //i++ 21.2
                }
            }
        }
        return false; //24
    }

}