package appstu_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain_stu {

    JMenuBar jmb;
    JMenu jm_mine,jm_sysMange;
    JMenuItem jmi_userMaintain,jmi_sysOut,jmi_personinfo,jmi_gradeinfo;
    ImageIcon icon = new ImageIcon("src/images/main.jpg.");
    JLabel desk;
    static String username;

    public AppMain_stu(String username) {
        this.username=username;
        JFrame jfMain=new JFrame("学生成绩管理系统-学生端");
        jfMain.setSize(600, 600);
        jfMain.setLocationRelativeTo(null);
        jfMain.setLocationRelativeTo(null);
        Container c=jfMain.getContentPane();
        c.setLayout(null);

        jmb = new JMenuBar();
        jm_mine = new JMenu("我的");
        jm_sysMange = new JMenu("系统管理");


        jmi_userMaintain=new JMenuItem("密码重置");
        jmi_sysOut=new JMenuItem("退出登录");
        jmi_personinfo=new JMenuItem("个人信息");
        jmi_gradeinfo=new JMenuItem("成绩信息");



        desk = new JLabel(icon);
        desk.setBounds(0,25,jfMain.getWidth(),jfMain.getHeight());


        jfMain.setJMenuBar(jmb);
        jmb.add(jm_mine);
        jmb.add(jm_sysMange);




        jm_mine.add(jmi_personinfo);
        jm_mine.add(jmi_gradeinfo);



        jm_sysMange.add(jmi_userMaintain);
        jm_sysMange.addSeparator();
        jm_sysMange.add(jmi_sysOut);



        jmi_personinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JF_personal(username);
            }
        }) ;

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


        jmi_gradeinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JF_perGradeInfo(username);

            }
        });



        jfMain.getLayeredPane().add(desk);
        jfMain.setVisible(true);
        jfMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfMain.setResizable(false);

    }

    public static void main(String[] args) {
        new AppMain_stu(username);
    }
}
