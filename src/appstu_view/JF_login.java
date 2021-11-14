package appstu_view;


import dao.userDao;
import entity.TbUserinfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF_login extends JFrame {
    //声明组件
    JLabel lab_username,lab_userpass,lab_bg;
    JTextField tf_user;
    JPasswordField pf_password;
    JButton ok,cancel;
    //定义组件
    public JF_login() {
        JFrame jf=new JFrame("系统用户登录");
        Container c=jf.getContentPane();
        c.setLayout(null);

        lab_bg=new JLabel();
        lab_bg.setIcon(new ImageIcon("src/images/login.jpg."));
        lab_bg.setSize(440,95);

        lab_username =new JLabel("用户名:",JLabel.CENTER);
        lab_userpass=new JLabel("密  码:",JLabel.CENTER);
        lab_username.setBounds(50,61,100,100);
        lab_userpass.setBounds(46,101,100,100);

        tf_user=new JTextField();
        pf_password=new JPasswordField();
        tf_user.setBounds(140,100,220,26);
        pf_password.setBounds(140,140,220,26);

        ok=new JButton("确定");
        cancel=new JButton("取消");
        ok.setBounds(160,180,70,26);
        cancel.setBounds(270,180,70,26);
        //添加组件
        c.add(lab_username);c.add(tf_user);
        c.add(lab_userpass);c.add(pf_password);
        c.add(ok);c.add(cancel);
        //按钮添加监听

        ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e_judge_basic_info) {
                String thisuser=tf_user.getText().trim();
                String thispass=new String(pf_password.getPassword()).trim();

                userDao userDao=new userDao();

                TbUserinfo select = userDao.select(thisuser);
                if (select!=null){
                    if (thispass.equals(select.getPass())){
                        if (thisuser.equals("谢俊浩")){
                        new AppMain_admin();}else if(thisuser.equals("孙安超")){
                            new AppMain_teacher();}else{
                                new AppMain_stu(thisuser);}}
                    else{
                        JOptionPane.showMessageDialog(null, "密码输入不正确");
                        tf_user.setText("");
                        pf_password.setText("");}
                }
                else{
                    JOptionPane.showMessageDialog(null, "未找到该用户");
                    tf_user.setText("");
                    pf_password.setText("");}



            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e_cancel) {
                dispose();
                System.exit(0);
            }
        });

        jf.setSize(440,280);
        jf.setLocationRelativeTo(null);
        jf.setLocationRelativeTo(null);
        jf.getLayeredPane().add(lab_bg);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(false);

    }


    public static void main(String[] args) {
        new JF_login();
    }

}


