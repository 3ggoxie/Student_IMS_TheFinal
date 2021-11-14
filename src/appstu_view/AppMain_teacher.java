package appstu_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain_teacher {
    JMenuBar jmb;
    JMenu jm_gradeInfo,jm_sysMange;
    JMenuItem jmi_gradeinsert,jmi_userMaintain,jmi_sysOut;
    ImageIcon icon = new ImageIcon("src/images/main.jpg.");
    JLabel desk;

    public AppMain_teacher() {
        JFrame jfMain=new JFrame("学生成绩管理系统-教师端");
        jfMain.setSize(600, 600);
        jfMain.setLocationRelativeTo(null);
        jfMain.setLocationRelativeTo(null);
        Container c=jfMain.getContentPane();
        c.setLayout(null);

        jmb = new JMenuBar();
        jm_gradeInfo = new JMenu("成绩信息");
        jm_sysMange = new JMenu("系统管理");



        jmi_gradeinsert=new JMenuItem("成绩插入");
        jmi_userMaintain=new JMenuItem("密码重置");
        jmi_sysOut=new JMenuItem("退出登录");


        desk = new JLabel(icon);
        desk.setBounds(0,25,jfMain.getWidth(),jfMain.getHeight());


        jfMain.setJMenuBar(jmb);

        jmb.add(jm_gradeInfo);
        jmb.add(jm_sysMange);


        jm_gradeInfo.add(jmi_gradeinsert);

        jm_sysMange.add(jmi_userMaintain);
        jm_sysMange.addSeparator();
        jm_sysMange.add(jmi_sysOut);

//添加监听
        jmi_sysOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent exit) {
//                JOptionPane.showMessageDialog(null,"确定退出系统？");
                new JF_login();
            }
        });

        jmi_userMaintain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JF__repass();
            }
        });


        jmi_gradeinsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JF_GradeInfoInsert();
            }
        });

        jfMain.getLayeredPane().add(desk);
        jfMain.setVisible(true);
        jfMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfMain.setResizable(false);

    }

    public static void main(String[] args) {
        new AppMain_teacher();
    }
}
