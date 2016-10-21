package book_action;
import java.sql.* ;

public class DBConeection {  
	      public  static Connection conn;
    static{	
    	try {
    	      Class.forName("com.mysql.jdbc.Driver");     
    	   
         }catch(Exception e)
         {
             e.printStackTrace();
         }
    }
     public static Connection getConnection()
     {
         try{
        	 conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_zhaojunqin","ok3zylwjl0","2j3il14xi540l41k4l2x3hz421k0ylhzkwhj4i2y"
        			  );
        	 
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         return conn;
     }
   public static void closeCon(Connection conn)
   {
       try{
           
           if(conn!=null)
           {
               conn.close();
           }
       }catch(Exception e)
       {
    	      e.printStackTrace();
           
       }
   }
   public static void closeCon(PreparedStatement ps)
   {
       try{
           
           if(ps!=null)
           {
               ps.close();
           }
       }catch(Exception e)
       {
           e.printStackTrace();
           
       }
   } public static void closeRs(ResultSet rs)
   {
       try{
           
           if(rs!=null)
           {
               rs.close();
           }
       }catch(Exception e)
       {
           e.printStackTrace();   
       }
   }
 
 
}
