package book_action;
import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookAction  extends ActionSupport{
	int ISBN;
	private Book Book = new Book();
	public Book getBook() {
		return Book;
	}

	public void setBook(Book Book) {
		Book = Book;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	@SuppressWarnings("resource")
	public  String authorBook() throws Exception{
		List<Book> Booklist=new ArrayList<Book>();
		String name=ServletActionContext.getRequest().getParameter("name");
		String sql="select * from Author where Name="+"'"+name+"'";
		String Ai ="";
       	HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
            	Author Author=new Author();
            	Ai=rs.getString("AuthorID");
            	Author.setAge(rs.getInt("Age"));
            	Author.setAuthorID(rs.getInt("AuthorID"));
            	Author.setCountry(rs.getString("Country"));
            	Author.setName(rs.getString("Name"));
  
	            session.setAttribute("Author", Author);
            }
            
            else{
            	return "fail";
            }
            try{
	            ps=con.prepareStatement("select * from Book where AuthorID="+"'"+Ai+"'");
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
	                Booklist.add(Book);
	            }
	            session.setAttribute("Booklist", Booklist); 
	            return "success";
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close(); 
            if(con!=null)con.close();
        }
        return "error";
	}
	@SuppressWarnings("resource")
	public  String showBook() throws Exception{
		
		String sql="select * from Book where ISBN="+"'"+ISBN+"'";
		String Ai ="";
       	HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Book> Booklist=new ArrayList<Book>();
        try{
            con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	Ai=rs.getString("AuthorID");
	            	Book Book=new Book();
	                Book.setISBN(rs.getInt("ISBN"));
	                Book.setTitle(rs.getString("Title"));
	                Book.setAuthorID(rs.getInt("AuthorID"));
	                Book.setPublisher(rs.getString("Publisher"));
	                Book.setPublishDate(rs.getString("PublishDate"));
	                Book.setPrice(rs.getFloat("Price"));
	                Booklist.add(Book);
	            }
	            session.setAttribute("Booklist", Booklist); 
	            System.out.println("AuthorID: "+Ai);
	            try{
	            ps=con.prepareStatement("select * from Author where AuthorID="+"'"+Ai+"'");
	            rs=ps.executeQuery();
	            while(rs.next()){
	            	Author Author=new Author();
	            	Author.setAge(rs.getInt("Age"));
	            	Author.setAuthorID(rs.getInt("AuthorID"));
	            	Author.setCountry(rs.getString("Country"));
	            	Author.setName(rs.getString("Name"));
		            session.setAttribute("Author", Author);
	            }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        finally{
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(con!=null)con.close();
        }
        return "success";
	}

	public String delBook() throws SQLException
{
		 Connection con=null;
	     Statement ps=null;
	     ResultSet rs=null;
		try
    	{
			con=DBConeection.getConnection();
			ps=con.createStatement();
			System.out.println("ISBN: " + ISBN);
    		ps.executeUpdate("delete from Book where ISBN ="+ISBN);
    		
    	}
		catch(Exception e)
        {
            e.printStackTrace();
        }
    	finally
    	{
    		 if(rs!=null) rs.close();
             if(ps!=null) ps.close();	
    	}
		return SUCCESS;
	}
	
	public String queryBook() throws SQLException{
		HttpSession session = ServletActionContext.getRequest().getSession();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Book> Booklist=new ArrayList<Book>();
        String sql = "select * from Book where ISBN="+"'"+ISBN+"'";
        try{
            con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
	            while(rs.next())
	            {
	            	 //Book Book=new Book();
	                Book.setISBN(rs.getInt("ISBN"));
	                Book.setTitle(rs.getString("Title"));
	                Book.setAuthorID(rs.getInt("AuthorID"));
	                Book.setPublisher(rs.getString("Publisher"));
	                Book.setPublishDate(rs.getString("PublishDate"));
	                Book.setPrice(rs.getFloat("Price"));
	                Booklist.add(Book);
	            }
	            //session.setAttribute("Booklist", Booklist); 
	            
        	} catch (Exception e){
        		e.printStackTrace();
        	}
		finally{
			if (rs!=null) rs.close();
			if(ps!=null)  ps.close();
            if(con!=null) con.close();
		}
        return "success";
	}
	public String upbook() throws SQLException{
		System.out.println("in upbook......");
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Book> Booklist=new ArrayList<Book>();
        String sql = "update Book set Title = ?,AuthorID = ?,Publisher = ?,PublishDate = ?,Price = ? where ISBN = ?";
        try {
        	con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, Book.getTitle());
            ps.setInt(2, Book.getAuthorID());
            ps.setString(3, Book.getPublisher());
            ps.setString(4, Book.getPublishDate());
            ps.setFloat(5, Book.getPrice());
            ps.setInt(6, Book.getISBN());
            ps.executeUpdate();
            System.out.println("Done!.....");
        } catch (Exception e){
        	e.printStackTrace();
        }
        finally{
			if (rs!=null) rs.close();
			if(ps!=null)  ps.close();
            if(con!=null) con.close();
		}
        return "success";
	}

	public String addbook() throws SQLException{
		System.out.println("in upbook......");
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Book> Booklist=new ArrayList<Book>();
        String sql = "insert into Book values(?, ?, ?, ?, ?, ?)";
        try {
        	con=DBConeection.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, Book.getISBN());
            ps.setString(2, Book.getTitle());
            ps.setInt(3, Book.getAuthorID());
            ps.setString(4, Book.getPublisher());
            ps.setString(5, Book.getPublishDate());
            ps.setFloat(6, Book.getPrice());
            
            ps.executeUpdate();
            System.out.println("Done!.....");
        } catch (Exception e){
        	e.printStackTrace();
        }
        finally{
			if (rs!=null) rs.close();
			if(ps!=null)  ps.close();
            if(con!=null) con.close();
		}
        return "success";
	}


}



