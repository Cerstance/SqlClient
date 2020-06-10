import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

public class JFrameAdd extends Util {
    private JFrame frameAdd;
    private static JTextField textFieldAddName;
    private static JTextField textFieldAddNum;
    private static JTextField textFieldAddAge;
    private static JTextField textFieldAddSex;
    private static JTextField textFieldAddPhone;
    private static JTextField textFieldAddCity;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameAdd window = new JFrameAdd();
                    window.frameAdd.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameAdd() {
        initialize();
    }

    private void initialize() {
        frameAdd = new JFrame();
        frameAdd.setTitle("\u6DFB\u52A0\u8BB0\u5F55");
        frameAdd.getContentPane().setFont(new Font("宋体", Font.PLAIN, 12));
        frameAdd.setBounds(100, 100, 325, 442);
        frameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdd.getContentPane().setLayout(null);

        textFieldAddName = new JTextField();
        textFieldAddName.setBounds(104, 102, 100, 23);
        frameAdd.getContentPane().add(textFieldAddName);
        textFieldAddName.setColumns(10);

        JLabel labelName = new JLabel("\u59D3\u540D\uFF1A");
        labelName.setFont(new Font("宋体", Font.PLAIN, 17));
        labelName.setBounds(40, 105, 54, 15);
        frameAdd.getContentPane().add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setFont(new Font("宋体", Font.PLAIN, 17));
        labelID.setBounds(40, 69, 54, 15);
        frameAdd.getContentPane().add(labelID);

        JLabel labelAge = new JLabel("\u5E74\u9F84\uFF1A");
        labelAge.setFont(new Font("宋体", Font.PLAIN, 17));
        labelAge.setBounds(40, 149, 54, 18);
        frameAdd.getContentPane().add(labelAge);

        JLabel labelSex = new JLabel("\u6027\u522B\uFF1A");
        labelSex.setFont(new Font("宋体", Font.PLAIN, 17));
        labelSex.setBounds(40, 190, 54, 18);
        frameAdd.getContentPane().add(labelSex);

        JLabel labelPhone = new JLabel("\u7535\u8BDD\uFF1A");
        labelPhone.setFont(new Font("宋体", Font.PLAIN, 17));
        labelPhone.setBounds(40, 230, 54, 18);
        frameAdd.getContentPane().add(labelPhone);

        JLabel labelCity = new JLabel("\u57CE\u5E02\uFF1A");
        labelCity.setFont(new Font("宋体", Font.PLAIN, 17));
        labelCity.setBounds(40, 271, 54, 18);
        frameAdd.getContentPane().add(labelCity);

        textFieldAddNum = new JTextField();
        textFieldAddNum.setColumns(10);
        textFieldAddNum.setBounds(104, 66, 100, 23);
        frameAdd.getContentPane().add(textFieldAddNum);

        textFieldAddAge = new JTextField();
        textFieldAddAge.setColumns(10);
        textFieldAddAge.setBounds(104, 149, 100, 23);
        frameAdd.getContentPane().add(textFieldAddAge);

        textFieldAddSex = new JTextField();
        textFieldAddSex.setColumns(10);
        textFieldAddSex.setBounds(104, 190, 100, 23);
        frameAdd.getContentPane().add(textFieldAddSex);

        textFieldAddPhone = new JTextField();
        textFieldAddPhone.setColumns(10);
        textFieldAddPhone.setBounds(104, 230, 100, 23);
        frameAdd.getContentPane().add(textFieldAddPhone);

        textFieldAddCity = new JTextField();
        textFieldAddCity.setColumns(10);
        textFieldAddCity.setBounds(104, 271, 100, 23);
        frameAdd.getContentPane().add(textFieldAddCity);

        JButton buttonMenuSub = new JButton("\u63D0\u4EA4");
        buttonMenuSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    executeAdd();
                    new ExecuteSuccessInfo();
                }catch(Exception e1) {
                    e1.printStackTrace();
                    new ExecuteFailInfo();
                }
            }
        });

        buttonMenuSub.setBounds(86, 322, 75, 23);
        frameAdd.getContentPane().add(buttonMenuSub);

        JButton buttonAddReturn = new JButton("\u8FD4\u56DE\u83DC\u5355");
        buttonAddReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrameMenu.main(null);
                frameAdd.dispose();
            }
        });
        buttonAddReturn.setBounds(182, 365, 93, 23);
        frameAdd.getContentPane().add(buttonAddReturn);
    }

    public static void executeAdd() {
        String client_num = textFieldAddNum.getText();
        String client_name = textFieldAddName.getText();
        String client_age = textFieldAddAge.getText();
        String client_sex = textFieldAddSex.getText();
        String client_phone = textFieldAddPhone.getText();
        String client_city = textFieldAddCity.getText();
        try {
            Statement st = getConn().createStatement();
            String sql = "insert into Client\r\n" +
                    " values(' "+client_num+" ', ' "+client_name+" ', ' "
                    +client_age+" ', ' "+client_sex+" ', ' "+client_phone
                    +" ', ' "+client_city+" ') ";
            st.executeUpdate(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
