package appstu_view;

import dao.subjectGradeDao;
import entity.TbGradeinfoSub;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JF_GradeInfoInsert {
    JLabel jb1=new JLabel("班级名称");
    JLabel jb2=new JLabel("年级名称");
    JLabel jb3=new JLabel("学生编号");
    JLabel jb4=new JLabel("学生姓名");
    JLabel jb5=new JLabel("课程编号");
    JLabel jb6=new JLabel("成绩");
    JLabel jb10=new JLabel("课程名称");
    JLabel jb11=new JLabel("");JLabel jb12=new JLabel("");JLabel jb13=new JLabel("");
    JLabel jb14=new JLabel("");JLabel jb15=new JLabel("");JLabel jb16=new JLabel("");
    JLabel jb17=new JLabel("");






    JTextField jt1=new JTextField();
    JTextField jt2=new JTextField();
    JTextField jt3=new JTextField();
    JTextField jt4=new JTextField();
    JTextField jt5=new JTextField();
    JTextField jt6=new JTextField();
    JTextField jt7=new JTextField();

    JButton ok=new JButton("确定");
    JButton refresh=new JButton("刷新");
    JButton reset=new JButton("重置");
    public JF_GradeInfoInsert() {
        JFrame jf=new JFrame("成绩信息插入");
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

        /**
         * 表格内字体居中
         */
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);


        c.add(jp1,BorderLayout.NORTH);

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"班级名称","年级名称","学生编号","学生姓名","课程编号","成绩","课程名称"});

        jt.setModel(infoModel);


        jp1.setViewportView(jt);
        jp1.add(jsb);
        c.add(jp1);

        JPanel adddate =new JPanel();
        adddate.setLayout(new GridLayout(8,3));
        c.add(adddate,BorderLayout.SOUTH);

        adddate.add(jb1);adddate.add(jb11);adddate.add(jt1);
        adddate.add(jb2);adddate.add(jb12);adddate.add(jt2);
        adddate.add(jb3);adddate.add(jb13);adddate.add(jt3);
        adddate.add(jb4);adddate.add(jb14);adddate.add(jt4);
        adddate.add(jb5);adddate.add(jb15);adddate.add(jt5);
        adddate.add(jb6);adddate.add(jb16);adddate.add(jt6);
        adddate.add(jb10);adddate.add(jb17);adddate.add(jt7);
        adddate.add(reset);adddate.add(refresh);adddate.add(ok);

        //添加监听
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String classId=jt1.getText();
                String gradeID=jt2.getText();
                String stuId = jt3.getText();
                String stuName=jt4.getText();
                String code=jt5.getText();
                float grade= Float.parseFloat(jt6.getText());
                String classname=jt7.getText();

                subjectGradeDao subjectGradeDao = new subjectGradeDao();

                int insert=subjectGradeDao.insert(classId,gradeID,stuId,stuName,code,grade,classname);
                JOptionPane.showMessageDialog(null,"数据插入成功");
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjectGradeDao subjectGradeDao=new subjectGradeDao();

                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                model.setRowCount(0);
                String stuid1= jt3.getText();
                TbGradeinfoSub select = subjectGradeDao.selectone(stuid1);
                if (select != null) {
                    Object[] item = new Object[]{select.getClassID(),select.getGradeID(),select.getStuid(),select.getStuname(),select.getCode(),select.getGrade(),select.getSubject()};
                    model.addRow(item);

                }}
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
                jt7.setText("");


            }
        });

        jf.setResizable(false);
        jf.setSize(650, 600);
        jf.setVisible(true);
    }
    public static void main(String[] args) {

        new JF_GradeInfoInsert();
    }
}
