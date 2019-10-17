package cn.gov.csrc.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oracletest {

    private static final String driverUrl = "oracle.jdbc.driver.OracleDriver";

    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
    //一段测试连接Oracle数据库的程序
    //url中使用本地的ip地址需要将修改listeer.org文件。不过使用无线局域网的地址却可以连接
    //在使用tomcat时一直卡住还以为是tomcat的问题，结果是oracle的问题
    //可以使用其他的
    //

    private static final String username = "zcaqgl_biz_test";

    private static final String password = "123456";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driverUrl);
            connection = DriverManager.getConnection(url, username, password);
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 测试Oracle连接是否成功
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("连接吧");
        Connection connection = oracletest.getConnection();
        System.out.println("连接成功："+connection);
        String address = InetAddress.getLocalHost().getHostAddress().toString();
        System.out.println(address);//获取本地ip地址
    }

}