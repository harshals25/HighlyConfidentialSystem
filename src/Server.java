import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server 
{
    public static void main(String[] args) throws Exception
    {
        Registry reg=LocateRegistry.createRegistry(1800);
        System.out.println("server is ready");
        
        LoginServer lsrv =new LoginServer();
        //System.out.println("bind");
        reg.bind("auth", lsrv);
        //System.out.println("bind");
   
    }
    
}