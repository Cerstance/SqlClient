import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class JFrameMenu extends Util {

    private JFrame frameMenu;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameMenu window = new JFrameMenu();
                    window.frameMenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrameMenu() {
        initialize();
    }

    private void initialize() {
        frameMenu = new JFrame();
        frameMenu.setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
        frameMenu.setBounds(100, 100, 342, 400);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.getContentPane().setLayout(null);

        JButton ButtonAdd = new JButton("\u6DFB\u52A0\u8BB0\u5F55");
        ButtonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                JFrameAdd.main(null);
            }
        });
        ButtonAdd.setFont(new Font("宋体", Font.PLAIN, 15));
        ButtonAdd.setBounds(93, 48, 124, 33);
        frameMenu.getContentPane().add(ButtonAdd);

        JButton ButtonDel = new JButton("\u5220\u9664\u8BB0\u5F55");
        ButtonDel.setFont(new Font("宋体", Font.PLAIN, 15));
        ButtonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                JFrameDelete.main(null);

            }
        });
        ButtonDel.setBounds(93, 114, 124, 33);
        frameMenu.getContentPane().add(ButtonDel);

        JButton ButtonModify = new JButton("\u4FEE\u6539\u8BB0\u5F55");
        ButtonModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                JFrameModify.main(null);
            }
        });
        ButtonModify.setFont(new Font("宋体", Font.PLAIN, 15));
        ButtonModify.setBounds(93, 181, 124, 33);
        frameMenu.getContentPane().add(ButtonModify);

        JButton ButtonQuery = new JButton("\u67E5\u8BE2\u8BB0\u5F55");
        ButtonQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMenu.dispose();
                JFrameQuery.main(null);
            }
        });
        ButtonQuery.setFont(new Font("宋体", Font.PLAIN, 15));
        ButtonQuery.setBounds(93, 252, 124, 33);
        frameMenu.getContentPane().add(ButtonQuery);

        JButton buttonMenuCheck = new JButton("\u68C0\u67E5");
        buttonMenuCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    check();
                    new CheckSuccessInfo();
                }catch(Exception e1) {
                    e1.printStackTrace();
                    new CheckFailInfo();
                }
            }
        });
        buttonMenuCheck.setBounds(208, 315, 93, 23);
        frameMenu.getContentPane().add(buttonMenuCheck);
    }
}