import java.awt.EventQueue;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameDelete extends Util {
    private JFrame frameDel;
    private static JTextField textFieldDelNum;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameDelete window = new JFrameDelete();
                    window.frameDel.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameDelete() {
        initialize();
    }

    private void initialize() {
        frameDel = new JFrame();
        frameDel.setTitle("\u5220\u9664\u8BB0\u5F55");
        frameDel.setBounds(100, 100, 450, 300);
        frameDel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDel.getContentPane().setLayout(null);

        JLabel labelDelId = new JLabel("\u8BF7\u8F93\u5165\u56DB\u4F4DID\uFF1A");
        labelDelId.setFont(new Font("宋体", Font.PLAIN, 15));
        labelDelId.setBounds(89, 95, 128, 22);
        frameDel.getContentPane().add(labelDelId);

        textFieldDelNum = new JTextField();
        textFieldDelNum.setBounds(208, 96, 97, 21);
        frameDel.getContentPane().add(textFieldDelNum);
        textFieldDelNum.setColumns(10);

        JButton buttonDelSubmit = new JButton("\u63D0\u4EA4");
        buttonDelSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    executeDelete();
                    new ExecuteSuccessInfo();
                }catch(Exception e1) {
                    e1.printStackTrace();
                    new ExecuteFailInfo();
                }
            }
        });
        buttonDelSubmit.setBounds(157, 154, 93, 23);
        frameDel.getContentPane().add(buttonDelSubmit);

        JButton buttonDelReturn = new JButton("\u8FD4\u56DE\u83DC\u5355");
        buttonDelReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameDel.dispose();
                JFrameMenu.main(null);
            }
        });
        buttonDelReturn.setBounds(304, 206, 93, 23);
        frameDel.getContentPane().add(buttonDelReturn);
    }

    public static void executeDelete() {
        String client_numDelete = textFieldDelNum.getText();
        try {
            String sql="DELETE FROM Client WHERE client_num=' " +client_numDelete+  " ' ";
            Statement st=getConn().createStatement();
            st.executeUpdate(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}

