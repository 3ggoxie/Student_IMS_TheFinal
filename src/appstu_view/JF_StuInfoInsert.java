package appstu_view;

import dao.studentDao;
import entity.TbStudentinfo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF_StuInfoInsert {
    JLabel stuid =new JLabel("学生编号");
    JLabel stuname =new JLabel("学生姓名");
    JLabel stusex =new JLabel("性别");
    JLabel stuclass =new JLabel("班级名称");
    JLabel stuage =new JLabel("年龄");
    JLabel jj1=new JLabel(" ");
    JLabel jj2=new JLabel(" ");
    JLabel jj3=new JLabel(" ");
    JLabel jj4=new JLabel(" ");
    JLabel jj5=new JLabel(" ");


    JTextField jt1=new JTextField();
    JTextField jt2=new JTextField();
    JTextField jt3=new JTextField();
    JTextField jt4=new JTextField();

    JComboBox<String> studentsex=new JComboBox<String>();

    JButton fresh=new JButton("刷新");
    JButton restart=new JButton("重置");
    JButton ok =new JButton("确定");

    public JF_StuInfoInsert() {
        JFrame jf=new JFrame("学生信息插入");
        Container c=jf.getContentPane();
        c.setLayout(new BorderLayout());
        JScrollPane jp1=new JScrollPane();
        jp1.setBounds(100, 100, 200, 200);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());
        JTable jt=new JTable(50,7);
        c.add(jp1,BorderLayout.NORTH);

        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);

        studentsex.addItem("");
        studentsex.addItem("男");
        studentsex.addItem("女");

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"学生编号","班级编号","学生姓名","性别","年龄"});

        jt.setModel(infoModel);
        jt.setValueAt("",0, 0);
        jt.setEnabled(false);

        jp1.setViewportView(jt);
        jp1.add(jsb);
        c.add(jp1);

        JPanel adddate =new JPanel();
        adddate.setLayout(new GridLayout(6,3));
        c.add(adddate,BorderLayout.SOUTH);

        adddate.add(stuid);adddate.add(jj1);adddate.add(jt1);
        adddate.add(stuname); adddate.add(jj2);adddate.add(jt2);
        adddate.add(stusex);adddate.add(jj3);adddate.add(studentsex);
        adddate.add(stuclass);adddate.add(jj4);adddate.add(jt3);
        adddate.add(stuage);adddate.add(jj5);adddate.add(jt4);
        adddate.add(fresh);adddate.add(restart);adddate.add(ok);
        //添加监听


        fresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                studentDao studentDao=new studentDao();

                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                model.setRowCount(0);
                String stuid1= jt1.getText();
                TbStudentinfo select = studentDao.select(stuid1);
                if (select != null) {
                    Object[] item = new Object[]{select.getStuid(), select.getclassID(), select.getSex(),select.getStuname(), select.getAge()};
                    model.addRow(item);

                }
            }
        });


        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
                studentsex.setSelectedItem("");
                jt3.setText("");
                jt4.setText("");
            }
        });



        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String stuId=jt1.getText();
                String stuName=jt2.getText();
                String stuSex = (String) studentsex.getSelectedItem();
                String stuClass=jt3.getText();
                int stuAge=Integer.parseInt(jt4.getText());

                studentDao studentDao = new studentDao();

                int tbStudent_insetinfos=studentDao.insert(stuId,stuClass,stuName,stuSex,stuAge);
                JOptionPane.showMessageDialog(null,"数据插入成功");
            }
        });


        stuid.setBounds(20, 500, 20, 20);

        jf.setResizable(false);
        jf.setSize(650, 600);
        jf.setVisible(true);

    }
    public static void main(String[] args) {
        new JF_StuInfoInsert();
    }
}
