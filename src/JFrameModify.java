import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class JFrameModify extends Util {

    private JFrame frameModify;
    private static JTextField textFieldModifyNum;
    private static JTextField textFieldModifyName;
    private static JTextField textFieldModifyAge;
    private static JTextField textFieldModifySex;
    private static JTextField textFieldModifyPhone;
    private static JTextField textFieldModifyCity;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameModify window = new JFrameModify();
                    window.frameModify.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameModify() {
        initialize();
    }

    private void initialize() {
        frameModify = new JFrame();
        frameModify.setTitle("\u4FEE\u6539\u8BB0\u5F55");
        frameModify.setBounds(100, 100, 424, 514);
        frameModify.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameModify.getContentPane().setLayout(null);

        textFieldModifyNum = new JTextField();
        textFieldModifyNum.setBounds(213, 27, 99, 21);
        frameModify.getContentPane().add(textFieldModifyNum);
        textFieldModifyNum.setColumns(10);

        JLabel labelModifyId = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u5BA2\u6237ID:");
        labelModifyId.setFont(new Font("宋体", Font.PLAIN, 15));
        labelModifyId.setBounds(22, 28, 181, 18);
        frameModify.getContentPane().add(labelModifyId);

        JLabel label = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D:");
        label.setFont(new Font("宋体", Font.PLAIN, 15));
        label.setBounds(22, 83, 181, 18);
        frameModify.getContentPane().add(label);

        JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5E74\u9F84\uFF1A");
        label_1.setFont(new Font("宋体", Font.PLAIN, 15));
        label_1.setBounds(22, 139, 181, 18);
        frameModify.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u6027\u522B\uFF1A");
        label_2.setFont(new Font("宋体", Font.PLAIN, 15));
        label_2.setBounds(22, 198, 181, 18);
        frameModify.getContentPane().add(label_2);

        JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u7535\u8BDD\uFF1A");
        label_3.setFont(new Font("宋体", Font.PLAIN, 15));
        label_3.setBounds(22, 259, 181, 18);
        frameModify.getContentPane().add(label_3);

        JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u57CE\u5E02\uFF1A");
        label_4.setFont(new Font("宋体", Font.PLAIN, 15));
        label_4.setBounds(22, 318, 181, 18);
        frameModify.getContentPane().add(label_4);

        textFieldModifyName = new JTextField();
        textFieldModifyName.setColumns(10);
        textFieldModifyName.setBounds(213, 82, 99, 21);
        frameModify.getContentPane().add(textFieldModifyName);

        textFieldModifyAge = new JTextField();
        textFieldModifyAge.setColumns(10);
        textFieldModifyAge.setBounds(213, 138, 99, 21);
        frameModify.getContentPane().add(textFieldModifyAge);

        textFieldModifySex = new JTextField();
        textFieldModifySex.setColumns(10);
        textFieldModifySex.setBounds(213, 197, 99, 21);
        frameModify.getContentPane().add(textFieldModifySex);

        textFieldModifyPhone = new JTextField();
        textFieldModifyPhone.setColumns(10);
        textFieldModifyPhone.setBounds(213, 258, 99, 21);
        frameModify.getContentPane().add(textFieldModifyPhone);

        textFieldModifyCity = new JTextField();
        textFieldModifyCity.setColumns(10);
        textFieldModifyCity.setBounds(213, 317, 99, 21);
        frameModify.getContentPane().add(textFieldModifyCity);

        JButton buttonModfyReturn = new JButton("\u8FD4\u56DE\u83DC\u5355");
        buttonModfyReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameModify.dispose();
                JFrameMenu.main(null);
            }
        });
        buttonModfyReturn.setBounds(305, 429, 93, 23);
        frameModify.getContentPane().add(buttonModfyReturn);

        JButton buttonModifySub = new JButton("\u63D0\u4EA4");
        buttonModifySub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    executeModify();
                    new ExecuteSuccessInfo();
                }catch(Exception e1) {
                    e1.printStackTrace();
                    new ExecuteFailInfo();
                }
            }
        });
        buttonModifySub.setBounds(148, 372, 93, 23);
        frameModify.getContentPane().add(buttonModifySub);
    }

    public static void executeModify() {
        String client_numModify = textFieldModifyNum.getText();
        String client_nameModify = textFieldModifyName.getText();
        String client_ageModify = textFieldModifyAge.getText();
        String client_sexModify = textFieldModifySex.getText();
        String client_phoneModify = textFieldModifyPhone.getText();
        String client_cityModify = textFieldModifyCity.getText();
        try {
            Statement st = getConn().createStatement();

            String sqlName=" UPDATE Client SET client_name=' "
                    +client_nameModify+" 'where client_num=' "+client_numModify+" ' ";
            String sqlAge=" UPDATE Client SET client_age=' "
                    +client_ageModify+" 'where client_num=' "+client_numModify+" ' ";
            String sqlSex=" UPDATE Client SET client_sex=' "
                    +client_sexModify+" 'where client_num=' "+client_numModify+" ' ";
            String sqlPhone=" UPDATE Client SET client_phone=' "
                    +client_phoneModify+" 'where client_num=' "+client_numModify+" ' ";
            String sqlCity=" UPDATE Client SET client_city=' "
                    +client_cityModify+" 'where client_num=' "+client_numModify+" ' ";

            st.executeUpdate(sqlName);
            st.executeUpdate(sqlAge);
            st.executeUpdate(sqlSex);
            st.executeUpdate(sqlPhone);
            st.executeUpdate(sqlCity);
        }catch(Exception e1) {
            e1.printStackTrace();
        }
    }
}
