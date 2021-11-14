package appstu_view;

import dao.teacherDao;
import entity.TbTeacherinfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JF_TeacherInfoSelect {
    JButton bt1=new JButton("删除");
    JButton bt3=new JButton("复位");
    JButton bt4=new JButton("刷新");

    JLabel teaid=new JLabel("教师编号");
    JLabel selectdate=new JLabel("已找到 条数据");

    JTextField teaidtext =new JTextField(10);

    public JF_TeacherInfoSelect() {
        JFrame jf =new JFrame("教师信息查询");
        Container c1=jf.getContentPane();
        c1.setLayout(new BorderLayout());
        JPanel jp1=new JPanel();
        jp1.setLayout(new FlowLayout());
        c1.add(jp1,BorderLayout.NORTH);

        jp1.add(teaid);
        jp1.add(teaidtext);
        jp1.add(bt1);
        jp1.add(bt3);
        jp1.add(bt4);

        JScrollPane jsc=new JScrollPane();
        jsc.setBounds(100, 100, 400, 300);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());

        JTable jt=new JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }};


        /**
         * 设置单行可选中
         */
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        c1.add(jsc,BorderLayout.CENTER);

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"老师编号","班级编号","老师姓名","性别"});

        jt.setModel(infoModel);

        jsc.setViewportView(jt);
        jsc.add(jsb);

        c1.add(selectdate, BorderLayout.SOUTH);

//添加监听

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                teacherDao teachertDao = new teacherDao();
                if (jt.getSelectedRow()==-1){
                }else{
                    String valueAt=(String) jt.getValueAt(jt.getSelectedRow(),0);
                    int delete=teachertDao.delete(valueAt);
                    if(delete>0){
                        JOptionPane.showMessageDialog(null,"此条信息已被删除");
                    }


                }

            }
        });

        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                teaidtext.setText("");
                selectdate.setText("已找到 条数据");
            }
        });

        bt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model=(DefaultTableModel) jt.getModel();
                model.setRowCount(0);
                teacherDao teacherDao = new teacherDao();
                if ((teaidtext.getText().equals(""))){
                    List<TbTeacherinfo> selAll=teacherDao.selectAll();
                    for (TbTeacherinfo sa:selAll){
                        if (sa!=null){
                            Object[] item=new Object[]{sa.getTeaid(),sa.getCode(),sa.getTeaname(),sa.getSex()};
                            model.addRow(item);
                        }
                    }selectdate.setText("已找到"+selAll.size()+"条数据");
                }
                else {
                    String teaid = teaidtext.getText();
                    TbTeacherinfo tbTeacherinfos = teacherDao.select(teaid);
                    if (tbTeacherinfos != null) {
                        Object[] item = new Object[]{tbTeacherinfos.getTeaid(), tbTeacherinfos.getCode(), tbTeacherinfos.getTeaname(), tbTeacherinfos.getSex()};
                        model.addRow(item);
                        selectdate.setText("已找到1条数据");
                    }
                }
        }});



        jf.setResizable(false);
        jf.setSize(650, 600);
        jf.setVisible(true);
    }
    public static void main(String[] args) {

        new JF_TeacherInfoSelect();
    }
}
