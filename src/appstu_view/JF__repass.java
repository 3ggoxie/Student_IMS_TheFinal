package appstu_view;

import dao.userDao;
import entity.TbUserinfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF__repass extends JFrame {

    JLabel oldpass,newpass,confirm;
    JPasswordField pf_newpass,pf_confirm,pf_oldpass;
    JButton ok,cancel;
    JFrame jf;
    JF__repass(){

        jf=new JFrame("重置密码");
        Container c=jf.getContentPane();
        c.setLayout(null);

        oldpass =new JLabel("原密码:",JLabel.CENTER);
        newpass=new JLabel("新密码:",JLabel.CENTER);
        confirm=new JLabel("确认新密码",JLabel.CENTER);
        oldpass.setBounds(50,20,100,100);
        newpass.setBounds(46,60,100,100);
        confirm.setBounds(46,100,100,100);

        pf_oldpass=new JPasswordField();
        pf_newpass=new JPasswordField();
        pf_confirm=new JPasswordField();
        pf_oldpass.setBounds(140,60,220,26);
        pf_newpass.setBounds(140,100,220,26);
        pf_confirm.setBounds(140,140,220,26);

        ok=new JButton("确定");
        cancel=new JButton("取消");
        ok.setBounds(160,180,70,26);
        cancel.setBounds(270,180,70,26);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String opass=new String(pf_oldpass.getPassword());
                String conpass=new String(pf_confirm.getPassword());
                String newpass=new String(pf_newpass.getPassword());

                userDao userDao=new userDao();
                TbUserinfo select = userDao.selectinPass(opass);
                if (select!=null){
                    if(opass.equals(select.getPass())){
                        if(conpass.equals(newpass)){// TODO: 2021-9-22 0022 连接数据库后更改验证方式
                        JOptionPane.showMessageDialog(null, "密码修改成功！");
                        new JF_login();
                    }
                        else{
                            JOptionPane.showMessageDialog(null, "两次密码不相同，请重试");
                            pf_oldpass.setText("");
                            pf_newpass.setText("");
                            pf_confirm.setText("");}
                    }else{
                        JOptionPane.showMessageDialog(null, "原密码输入错误，请重试");
                            pf_oldpass.setText("");
                            pf_newpass.setText("");
                            pf_confirm.setText("");}
                }
                else
                    JOptionPane.showMessageDialog(null, "旧密码输入错误，请重试");


            }
        });



        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();

            }
        });

        c.add(oldpass);c.add(newpass);
        c.add(confirm);c.add(pf_oldpass);c.add(pf_newpass);
        c.add(pf_confirm);c.add(ok);c.add(cancel);

        jf.setSize(440,280);
        jf.setLocationRelativeTo(null);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setResizable(false);
    }

    public static void main(String[] args) {
        new JF__repass();
    }
}
