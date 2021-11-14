package appstu_view;

import dao.studentDao;
import entity.TbStudentinfo;

import javax.swing.*;
import java.awt.*;

public class JF_personal extends JFrame {
    static String username;
    public JF_personal(String username) {


        JFrame jf = new JFrame("个人信息");
        Container c = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        JLabel jLabel1 = new JLabel("姓名:");
        jLabel1.setBounds(0, 20, 60, 40);

        JLabel jT1 = new JLabel();
        jT1.setBounds(60, 20, 180, 40);

        JLabel jLabel2 = new JLabel("班级:");
        jLabel2.setBounds(260, 20, 60, 40);

        JLabel jT2 = new JLabel();
        jT2.setBounds(320, 20, 180, 40);

        JLabel jLabel3 = new JLabel("学号:");
        jLabel3.setBounds(0, 60, 60, 40);

        JLabel jT3 = new JLabel();
        jT3.setBounds(60, 60, 180, 40);

        JLabel jLabel4 = new JLabel("性别:");
        jLabel4.setBounds(260, 60, 60, 40);

        JLabel jT4 = new JLabel();
        jT4.setBounds(320, 60, 180, 40);

        JLabel jLabel5 = new JLabel("年龄:");
        jLabel5.setBounds(0, 100, 60, 40);

        JLabel jT5 = new JLabel();
        jT5.setBounds(60, 100, 180, 40);

        JLabel thenull = new JLabel(" ");
        thenull.setBounds(320, 100, 40, 40);


        p1.add(jLabel1);
        p1.add(jT1);
        p1.add(jLabel2);
        p1.add(jT2);
        p1.add(jLabel3);
        p1.add(jT3);
        p1.add(jLabel4);
        p1.add(jT4);
        p1.add(jLabel5);
        p1.add(jT5);
        c.add(p1);

        studentDao studentDao=new studentDao();
        TbStudentinfo selectthisInfo=studentDao.selectinName(username);
        jT1.setText(selectthisInfo.getStuname());
        jT2.setText(selectthisInfo.getclassID());
        jT3.setText(selectthisInfo.getStuid());
        jT4.setText(selectthisInfo.getSex());
        jT5.setText((selectthisInfo.getAge()).toString());



        jf.setResizable(false);
        jf.setBounds(200, 200, 500, 200);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new JF_personal(username);
    }
    }




