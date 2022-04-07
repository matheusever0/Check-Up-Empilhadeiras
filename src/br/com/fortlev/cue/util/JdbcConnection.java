package br.com.fortlev.cue.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author matheus.s
 */
public class JdbcConnection {

    private String user;
    private String pwd;
    private String url;
    private String database;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    
   public void setProps(){
    Properties props = new Properties();
 
    props.setProperty("jdbc.user", "root");
    props.setProperty("jdbc.pwd", "f0rtl3v");
    props.setProperty("jdbc.url", "jdbc:mysql://10.71.10.8:3306");
    props.setProperty("jdbc.dataBase","dbcheck");
 
    try {
        FileOutputStream fos = new FileOutputStream("config.xml");
        props.storeToXML(fos, "FILE JDBC PROPERTIES:","ISO-8859-1");
        fos.close();
 
    }catch (IOException e){
        System.out.println(e.getMessage());
    }
 
}
   
   
   public void getProps (){
    Properties props = new Properties();
 
    try {
        //Setamos o arquivo que será lido
        FileInputStream fis = new FileInputStream("config.xml");
        //método load faz a leitura através do objeto fis
        props.loadFromXML(fis);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    //Captura o valor da propriedade, através do nome da propriedade(Key)
    this.setUser(props.getProperty("jdbc.user"));
    this.setPwd(props.getProperty("jdbc.pwd"));
    this.setUrl(props.getProperty("jdbc.url"));
    this.setDatabase(props.getProperty("jdbc.dataBase"));

   }
}


