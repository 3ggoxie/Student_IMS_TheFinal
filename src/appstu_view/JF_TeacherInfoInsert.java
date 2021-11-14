package appstu_view;

import dao.teacherDao;
import entity.TbTeacherinfo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF_TeacherInfoInsert {
    JLabel teaid =new JLabel("教师编号");
    JLabel classID =new JLabel("课程编号");
    JLabel teaname =new JLabel("教师名称");
    JLabel teasex =new JLabel("性别");
    JLabel jj1=new JLabel(" ");
    JLabel jj2=new JLabel(" ");
    JLabel jj3=new JLabel(" ");
    JLabel jj4=new JLabel(" ");

    JTextField jt1=new JTextField();
    JTextField jt2=new JTextField();
    JTextField jt3=new JTextField();

    JButton ok=new JButton("确定");
    JButton refresh=new JButton("刷新");
    JButton reset=new JButton("重置");

    JComboBox<String> teachersex =new JComboBox<String>();

    public JF_TeacherInfoInsert() {

        JFrame jf=new JFrame("教师信息插入");
        Container c=jf.getContentPane();
        c.setLayout(new BorderLayout());
        JScrollPane jp1=new JScrollPane();
        jp1.setBounds(100, 100, 200, 200);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());
        JTable jt=new JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);
        c.add(jp1,BorderLayout.NORTH);

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"教师编号","课程编号","教师名称","性别"});

        jt.setModel(infoModel);
        jt.setEnabled(true);

        jp1.setViewportView(jt);
        jp1.add(jsb);
        c.add(jp1);

        JPanel adddate =new JPanel();
        adddate.setLayout(new GridLayout(5,3));
        c.add(adddate,BorderLayout.SOUTH);

        teachersex.addItem("");
        teachersex.addItem("男");
        teachersex.addItem("女");


        adddate.add(teaid);adddate.add(jj1);adddate.add(jt1);
        adddate.add(classID); adddate.add(jj2);adddate.add(jt2);
        adddate.add(teaname);adddate.add(jj3);adddate.add(jt3);
        adddate.add(teasex);adddate.add(jj4);adddate.add(teachersex);
        adddate.add(refresh);adddate.add(reset);adddate.add(ok);
        //添加监听

        teacherDao teacherDao=new teacherDao();

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                model.setRowCount(0);
                String teaid = jt1.getText();
                TbTeacherinfo select = teacherDao.select(teaid);
                if (select != null) {
                    Object[] item = new Object[]{select.getTeaid(), select.getCode(), select.getTeaname(), select.getSex()};
                    model.addRow(item);

                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                teachersex.setSelectedItem("");
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teaId=jt1.getText();
                String classid=jt2.getText();
                String teaName = jt3.getText();
                String teaSex=(String) teachersex.getSelectedItem();



                int taeIns=teacherDao.insert(teaId, classid, teaName, teaSex);
            }
        });

        jf.setResizable(false);
        jf.setSize(650, 600);
        jf.setVisible(true);
    }
    public static void main(String[] args) {

        new JF_TeacherInfoInsert();
    }
}
