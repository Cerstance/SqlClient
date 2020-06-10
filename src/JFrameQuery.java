import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class JFrameQuery extends Util {
    private static String client_nameQuery;
    private static String client_ageQuery;
    private static String client_sexQuery;
    private static String client_cityQuery;
    private static String client_phoneQuery;

    private JFrame frameQuery;
    private static JTextField textFieldQueryNum;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameQuery window = new JFrameQuery();
                    window.frameQuery.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameQuery() {
        initialize();
    }

    private void initialize() {
        frameQuery = new JFrame();
        frameQuery.setTitle("\u67E5\u8BE2\u8BB0\u5F55");
        frameQuery.setBounds(100, 100, 450, 300);
        frameQuery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameQuery.getContentPane().setLayout(null);

        JLabel labelQueryNum = new JLabel("\u8BF7\u8F93\u5165ID\uFF1A");
        labelQueryNum.setFont(new Font("宋体", Font.PLAIN, 15));
        labelQueryNum.setBounds(72, 90, 156, 15);
        frameQuery.getContentPane().add(labelQueryNum);

        textFieldQueryNum = new JTextField();
        textFieldQueryNum.setBounds(192, 87, 93, 21);
        frameQuery.getContentPane().add(textFieldQueryNum);
        textFieldQueryNum.setColumns(10);

        JButton buttonQuerySubmit = new JButton("\u63D0\u4EA4");
        buttonQuerySubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    executeQuery();
                    new ExecuteSuccessInfo();
                    new ShowQueryInfo();
                }catch(Exception e1) {
                    e1.printStackTrace();
                    new ExecuteFailInfo();
                }
            }
        });
        buttonQuerySubmit.setBounds(140, 175, 93, 23);
        frameQuery.getContentPane().add(buttonQuerySubmit);

        JButton buttonQueryReturn = new JButton("\u8FD4\u56DE\u83DC\u5355");
        buttonQueryReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameQuery.dispose();
                JFrameMenu.main(null);
            }
        });
        buttonQueryReturn.setBounds(324, 219, 93, 23);
        frameQuery.getContentPane().add(buttonQueryReturn);
    }

    public static void executeQuery() {
        String client_numQuery = textFieldQueryNum.getText();

        try {
            Statement st=getConn().createStatement();
            String sql="SELECT* FROM Client WHERE client_num=' " +client_numQuery+  " ' ";
            st.executeQuery(sql);
            ResultSet re=st.executeQuery(sql);
            while(re.next()) {
                client_nameQuery=re.getString("client_name");
                client_ageQuery=re.getString("client_age");
                client_sexQuery=re.getString("client_sex");
                client_cityQuery=re.getString("client_city");
                client_phoneQuery=re.getString("client_phone");

                System.out.println("客户姓名："+client_nameQuery);
                System.out.println("客户年龄："+client_ageQuery);
                System.out.println("客户性别："+client_sexQuery);
                System.out.println("客户所在城市："+client_cityQuery);
                System.out.println("客户电话："+client_phoneQuery);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("serial")
    class ShowQueryInfo extends JFrame{
        JTextArea info=new JTextArea();
        ShowQueryInfo(){
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("客户基本信息");
            this.setSize(250,200);
            this.setVisible(true);
            this.setLocation(200,100);
            this.setResizable(false);
            this.getContentPane().add(info,BorderLayout.CENTER);
            info.setEditable(false);
            info.setText("客户姓名："+client_nameQuery+"\n客户年龄："+client_ageQuery+"\n客户性别："+client_sexQuery+"\n客户电话："+client_phoneQuery+"\n客户城市："+client_cityQuery);
        }
    }
}
