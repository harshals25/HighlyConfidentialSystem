import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class LoginServer extends UnicastRemoteObject implements LoginInterface
{
    LoginServer()throws RemoteException{}
    
    public boolean checkLogin(String userName, String password) throws RemoteException
    {
        try 
        {
            System.out.println("hello");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement st = con.prepareStatement("select * from table where userid=? and password=?");
            st.setString(2, password);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
           // System.out.println(true);
            if(rs.next())
            { 
                System.out.println(rs);
                return true;
            }
            else
                return false;
          
        }
        catch(Exception ex){}
        return false;
   }
  /*/  public static void main(String[] args) {
        LoginServer obj = new LoginServer();
        obj.checkLogin("abcd","1234");
    }*/
}
