/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sqlite tutorial
 * http://www.tutorialspoint.com/sqlite/sqlite_java.htm
 */
public class liteDB {
    Statement stmt = null;
    Connection c = null;
    String dbdir = "D:\\SDHC\\PROJECTS\\DBBU\\wb.sqlite";   
    StringBuffer strB = new StringBuffer();
 //CONSTRUCTO
 public liteDB() 
{
/*
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Opened database successfully");
*/
}

 void createTble( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE COMPANY " +
                   "(ID INT PRIMARY KEY     NOT NULL," +
                   " NAME           TEXT    NOT NULL, " + 
                   " AGE            INT     NOT NULL, " + 
                   " ADDRESS        CHAR(50), " + 
                   " SALARY         REAL)"; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }  
    
public void insert()
  {
   Connection c = null;
   Statement stmt = null;

    try {

     Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

  
stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM epdg2 WHERE ID = 4" );
       String sql = "INSERT INTO epdg2 (ID,EPGFEN,NOTES) " +
                   "VALUES (NULL, 'Paul', 'California' );"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO epdg2 (ID,EPGFEN,NOTES) " +
                   "VALUES (NULL, 'eileen', 'California2' );"; 
      stmt.executeUpdate(sql);


      sql = "INSERT INTO epdg2 (ID,EPGFEN,NOTES) " +
                   "VALUES (NULL, 'eileen', 'California3' );"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO epdg2 (ID,EPGFEN,NOTES) " +
                   "VALUES (NULL, 'eileen', 'California4' );"; 
      stmt.executeUpdate(sql);


      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
public String select()
  {
   Connection c = null;
   Statement stmt = null;

    try {

     Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

  
stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM epdg2 WHERE ID = 4" );
 
      strB.setLength(0);
      while ( rs.next() ) {
       //  int ID = rs.getInt("ID");
         strB.append(rs.getString("ID")+';');
         strB.append(rs.getString("EPGFEN")+';');
         strB.append(rs.getString("NOTES")+';');
         strB.append('\n');
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
    return strB.toString();
  }    
 public void update( )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "UPDATE epdg2 set NOTES='UPDATED' where ID=4;";
      stmt.executeUpdate(sql);
      c.commit();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM epdg2;" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  epgfen = rs.getString("EPGFEN");
         String  notes = rs.getString("NOTES");
         System.out.println( "ID = " + id );
         System.out.println( "EPGFEN = " + epgfen );
         System.out.println( "notes = " + notes );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
 
  public void delete()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:"+dbdir);
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "DELETE from epdg2 where ID > 10;";
      stmt.executeUpdate(sql);
      c.commit();

           ResultSet rs = stmt.executeQuery( "SELECT * FROM epdg2;" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String  epgfen = rs.getString("EPGFEN");
         String  notes = rs.getString("NOTES");
         System.out.println( "ID = " + id );
         System.out.println( "EPGFEN = " + epgfen );
         System.out.println( "notes = " + notes );
         System.out.println();
   
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
 
}


