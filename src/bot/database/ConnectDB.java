package bot.database;

import java.sql.*;

public class ConnectDB {
  private final String url = "jdbc:postgresql://localhost:5432/";
  private final String user = "postgres";
  private final String password = "1234";
  private Connection conn = null;
  private PreparedStatement pdsmt = null;
  private ResultSet rs = null;
  public String getUrl() {
    return url;
  }
  public String getUser() {
    return user;
  }
  public Connection getConn(){
    return conn;
  }
  public String getPassword() {
    return password;
  }
  public PreparedStatement getPdsmt() {
    return pdsmt;
  }
  public ResultSet getRs() {
    return rs;
  }
  public void connect(){
    try{
      Class.forName("org.postgresql.Driver");
      this.conn = DriverManager.getConnection(this.url, this.user, this.password);
      System.out.println("Connecção feita com sucesso!");
    }catch(SQLException | ClassNotFoundException e){
      e.printStackTrace();
    }
  }
  public void insert(){
    try{
      pdsmt = conn.prepareStatement("");
    }catch(SQLException e) {
      e.printStackTrace();
    }
  }
  public void disconnect(){
    try{
      if(!(this.conn == null) && !this.conn.isClosed()){
        this.conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
