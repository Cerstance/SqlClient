import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Util {
    private static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Client";
    private static String userName = "sa";
    private static String userPwd = "root";

    public static void getLoad() throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("驱动加载成功！");
        }catch(Exception e1) {
            System.err.println("驱动加载失败！");
            e1.printStackTrace();
        }
    }
    public static Connection getConn() throws SQLException{
        try {
            Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("数据库连接成功！");
            return dbConn;
        }catch(SQLException e) {
            System.err.println("数据库连接失败！");
            return null;
        }
    }
    public static void check() throws Exception{
        try {
            getLoad();
            getConn();
        }catch(Exception e1) {
            e1.printStackTrace();
        }
    }
    @SuppressWarnings("serial")
    class CheckSuccessInfo extends JFrame {
        JTextArea info=new JTextArea();
        CheckSuccessInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("驱动加载成功！\n数据库连接成功！");
        }
    }
    @SuppressWarnings("serial")
    class CheckFailInfo extends JFrame {
        JTextArea info=new JTextArea();
        CheckFailInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("驱动加载失败！\n数据库连接失败！");
        }
    }
    @SuppressWarnings("serial")
    class ExecuteSuccessInfo extends JFrame {
        JTextArea info=new JTextArea();
        ExecuteSuccessInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("执行SQL成功！");
        }
    }
    @SuppressWarnings("serial")
    class ExecuteFailInfo extends JFrame {
        JTextArea info=new JTextArea();
        ExecuteFailInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("执行SQL失败！");
        }
    }
    @SuppressWarnings("serial")
    class LoadSuccessInfo extends JFrame {
        JTextArea info=new JTextArea();
        LoadSuccessInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("驱动加载成功！");
        }
    }
    @SuppressWarnings("serial")
    class LoadFailInfo extends JFrame {
        JTextArea info=new JTextArea();
        LoadFailInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("驱动加载失败！");
        }
    }
}
