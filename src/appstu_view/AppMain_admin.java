package appstu_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMain_admin extends JFrame {
    JMenuBar jmb;
    JMenu jm_stuInfo, jm_teaInfo,jm_gradeInfo,jm_sysMange;
    JMenuItem jmi_stuadd, jmi_stuupdate, jmi_teaadd, jmi_teaupdate,jmi_gradeupgrade,jmi_userMaintain,jmi_sysOut;
    ImageIcon icon = new ImageIcon("src/images/main.jpg.");
    JLabel desk;

    public AppMain_admin() {
        JFrame jfMain=new JFrame("学生成绩管理系统-管理员");
        jfMain.setSize(600, 600);
        jfMain.setLocationRelativeTo(null);
        jfMain.setLocationRelativeTo(null);
        Container c=jfMain.getContentPane();
        c.setLayout(null);

        jmb = new JMenuBar();
        jm_stuInfo = new JMenu("学生信息");
        jm_teaInfo = new JMenu("教师信息");
        jm_gradeInfo = new JMenu("成绩信息");
        jm_sysMange = new JMenu("系统管理");

        jmi_stuadd = new JMenuItem("插入学生信息");
        jmi_stuupdate = new JMenuItem("学生信息查询");
        jmi_teaadd = new JMenuItem("插入教师信息");
        jmi_teaupdate = new JMenuItem("教师信息查询");
        jmi_gradeupgrade=new JMenuItem("成绩查询");
        jmi_userMaintain=new JMenuItem("密码重置");
        jmi_sysOut=new JMenuItem("退出登录");


        desk = new JLabel(icon);
        desk.setBounds(0,25,jfMain.getWidth(),jfMain.getHeight());


        jfMain.setJMenuBar(jmb);
        jmb.add(jm_stuInfo);
        jmb.add(jm_teaInfo);
        jmb.add(jm_gradeInfo);
        jmb.add(jm_sysMange);

        jm_stuInfo.add(jmi_stuadd);
        jm_stuInfo.add(jmi_stuupdate);

        jm_teaInfo.add(jmi_teaadd);
        jm_teaInfo.add(jmi_teaupdate);

        jm_gradeInfo.add(jmi_gradeupgrade);

        jm_sysMange.add(jmi_userMaintain);
        jm_sysMange.addSeparator();
        jm_sysMange.add(jmi_sysOut);

//添加监听

        jmi_teaupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent turnto_TeacherInfoSelect) {
                new JF_TeacherInfoSelect();
            }
        });

        jmi_teaadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent turnto_TeacherInfoInsert) {
                new JF_TeacherInfoInsert();
            }
        });

        jmi_gradeupgrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent turnto_GradeSelect) {
                new JF_GradeSelect();
            }
        });

        jmi_stuupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent turnto_StuInforSelect) {
                new JF_StuInforSelect();
            }
        });

        jmi_stuadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent turnto_StuInfoInsert) {
                new JF_StuInfoInsert();
            }
        });

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

        jfMain.getLayeredPane().add(desk);
        jfMain.setVisible(true);
        jfMain.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jfMain.setResizable(false);

    }

    public static void main(String[] args) {
        new AppMain_admin();
    }
}