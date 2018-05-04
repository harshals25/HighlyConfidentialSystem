
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


    import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter server name ");
        String server = sc.next();
        sc.nextLine();
        
        System.out.println("enter username and password:");
        String userName = sc.next();
        sc.nextLine();
        
        String password = sc.next();
        Registry registry = LocateRegistry.getRegistry(server,1800);
        LoginInterface li = (LoginInterface)registry.lookup("auth");
        
        boolean finalResult = li.checkLogin(userName,password);
        System.out.println(finalResult);
        
        if(finalResult)
            System.out.println("welcome");
        else
            System.out.println("invalid identity");
    }
}


