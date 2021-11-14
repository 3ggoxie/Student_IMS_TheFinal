package appstu_view;

import dao.subjectGradeDao;
import entity.TbGradeinfoSub;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JF_GradeSelect {
    JButton bt1=new JButton("删除");
    JButton bt2=new JButton("存盘");
    JButton bt3=new JButton("复位");
    JButton bt4=new JButton("刷新");

    JLabel jb8=new JLabel("所属年级:");
    JLabel jb9=new JLabel("所属班级:");
    JLabel jb11=new JLabel("已找到 条数据");
    JLabel number=new JLabel("学号:");

    JTextField jt5=new JTextField(9);
    JTextField jt6=new JTextField(5);

    JComboBox<String> jc1=new JComboBox<String>();


    public JF_GradeSelect() {
        JFrame jff=new JFrame("成绩信息查询");
        Container c1=jff.getContentPane();
        c1.setLayout(new BorderLayout());
        JPanel jjp=new JPanel();
        jjp.setLayout(new FlowLayout());
        c1.add(jjp,BorderLayout.NORTH);

        jjp.add(jb8);



        jjp.add(jc1);jc1.addItem("");jc1.addItem("大一");
        jc1.addItem("大二");jc1.addItem("大三");
        jc1.addItem("大四");jjp.add(jb9);jjp.add(jt6);jjp.add(bt1);


        jjp.add(number);jjp.add(jt5);

        jjp.add(bt1); jjp.add(bt2); jjp.add(bt3);jjp.add(bt4);

        JScrollPane jsc=new JScrollPane();
        jsc.setBounds(100, 100, 400, 300);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());
        JTable jt=new JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){

                    if (colIndex==5)
                return true;
                return false;
            }};

        c1.add(jsc,BorderLayout.CENTER);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();

        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);

        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        c1.add(jsc,BorderLayout.CENTER);

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"班级名称","年级名称","学生编号","学生姓名","课程编号","成绩","课程名称"});

        jt.setModel(infoModel);

        jsc.setViewportView(jt);
        jsc.add(jsb);

        c1.add(jb11, BorderLayout.SOUTH);

        //添加监听

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjectGradeDao stusubGrade = new subjectGradeDao();
                if (jt.getSelectedRow()==-1){
                }
                else{
                    String valueAt=(String) jt.getValueAt(jt.getSelectedRow(),2);
                    String valueAt2=(String) jt.getValueAt(jt.getSelectedRow(),4);

                    int delete= stusubGrade.delete(valueAt,valueAt2);
//                    System.out.println(delete);
                    if(delete>0){
                        JOptionPane.showMessageDialog(null,"此条信息已被删除");
                    }


                }
            }
        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jc1.setSelectedItem("");
                jt5.setText("");
                jt6.setText("");
                jb11.setText("已找到 条数据");
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subjectGradeDao stusubGrade = new subjectGradeDao();
                if (jt.getSelectedRow()==-1){
                }
                else{

                    String valueAt2=(String) jt.getValueAt(jt.getSelectedRow(),2);
                    String valueAt4=(String) jt.getValueAt(jt.getSelectedRow(),4);
                    float valueAt5= Float.parseFloat ((String) jt.getValueAt(jt.getSelectedRow(),5));

                    System.out.println(valueAt2);
                    System.out.println(valueAt4);
                    System.out.println(valueAt5);
//                    int delete= stusubGrade.delete(valueAt,valueAt2);
                    int update=stusubGrade.update(valueAt5,valueAt2,valueAt4);
//                    System.out.println(delete);
                    if(update>0){
                        JOptionPane.showMessageDialog(null,"修改成功");
                    }
                }
            }
        });

        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * 清表刷新界面
                 */
                DefaultTableModel model=(DefaultTableModel) jt.getModel();
                model.setRowCount(0);

                String stuid=jt5.getText();
                String gradeID = (String) jc1.getSelectedItem();
                String classid = jt6.getText();

                subjectGradeDao subjectGradeDao = new subjectGradeDao();

                if (((String)jc1.getSelectedItem()).equals("")&&jt5.getText().equals("")&&jt6.getText().equals("")){
                    java.util.List<TbGradeinfoSub> tbSgrade = subjectGradeDao.selectAll();
                    for (TbGradeinfoSub t :
                            tbSgrade) {
                        if (t!=null){
                            Object[] item=new Object[]{t.getClassID(),t.getGradeID(),t.getStuid(),t.getStuname(),t.getCode(),t.getGrade(),t.getSubject()};
                            model.addRow(item);
                        }
                    }jb11.setText("已找到"+tbSgrade.size()+"条数据");
                }

                else if (jt5.getText().equals("")&&jt6.getText().equals("")){
                    List<TbGradeinfoSub> selectGrade=subjectGradeDao.selectAllinGrade(gradeID);
                    for (TbGradeinfoSub t :
                                selectGrade) {
                            if (t!=null){
                                Object[] item=new Object[]{t.getClassID(),t.getGradeID(),t.getStuid(),t.getStuname(),t.getCode(),t.getGrade(),t.getSubject()};
                                model.addRow(item);
                            }
                        }jb11.setText("已找到"+selectGrade.size()+"条数据");
                    }else if (((String)jc1.getSelectedItem()).equals("")&&jt5.getText().equals("")){
                    List<TbGradeinfoSub> tbGradeinfoSubListinfos = subjectGradeDao.selectAllinClass(classid);
                    for (TbGradeinfoSub t : tbGradeinfoSubListinfos) {
                        if (t!=null){
                            Object[] item=new Object[]{t.getClassID(),t.getGradeID(),t.getStuid(),t.getStuname(),t.getCode(),t.getGrade(),t.getSubject()};
                            model.addRow(item);
                        }
                    }jb11.setText("已找到"+tbGradeinfoSubListinfos.size()+"条数据");
                }


                else if (((String)jc1.getSelectedItem()).equals("")&&jt6.getText().equals("")){
                    List <TbGradeinfoSub> select = subjectGradeDao.selectinstuid(stuid);
                    if (select!=null){
                        for (TbGradeinfoSub stu:select){
                        Object[] item=new Object[]{stu.getClassID(),stu.getGradeID(),stu.getStuid(),stu.getStuname(),stu.getCode(),stu.getGrade(),stu.getSubject()};
                        model.addRow(item);
                    }jb11.setText("已找到"+select.size()+"条数据");}

                }
            }
        });

        jff.setResizable(false);
        jff.setSize(650, 600);
        jff.setVisible(true);
    }
    public static void main(String[] args) {

        new JF_GradeSelect();

    }
}
