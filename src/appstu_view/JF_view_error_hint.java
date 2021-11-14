package appstu_view;

import javax.swing.*;
import java.awt.*;

public class JF_view_error_hint {
    JLabel error=new JLabel("输入的信息错误");

    JButton ok =new JButton("确定");

    public JF_view_error_hint() {

        JFrame jf=new JFrame();
        Container c=jf.getContentPane();
        JPanel jp=new JPanel();
        jp.setLayout(null);

        error.setBounds(95, 0, 300, 100);
        jp.add(error);

        ok.setBounds(100, 100, 80, 30);
        jp.add(ok);

        c.add(jp);
        jf.setResizable(false);
        jf.setSize(300,200);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new JF_view_error_hint();
    }
}
