package book_action;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.struts2.ServletActionContext;
public class DAO{
	public static List<Book> getBook() throws Exception{
		List<Book> list=new ArrayList<Book>();
		String sql="select * from Book";
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next())
            {
            	Book Book=new Book();
            	Book.setISBN(rs.getInt("ISBN"));
                Book.setTitle(rs.getString("Title"));
                Book.setAuthorID(rs.getInt("AuthorID"));
                Book.setPublisher(rs.getString("Publisher"));
                Book.setPublishDate(rs.getString("PublishDate"));
                Book.setPrice(rs.getFloat("Price"));
                list.add(Book);
            }
       }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null)con.close();
        }
       return list;
       }
		
}