package appstu_view;

import dao.gradeDao;
import dao.studentDao;
import entity.TbClassinfo;
import entity.TbStudentinfo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class JF_StuInforSelect {

    JLabel jl_grade=new JLabel("所属年级:");
    JLabel jl_class=new JLabel("所属班级:");
    JLabel jl_resultnum=new JLabel("已找到 条数据");
    JLabel jl_sid=new JLabel("学号:");

    static  JTextField tf_id=new JTextField(9);
    static  JTextField tf_classid=new JTextField(5);

    JButton bt_refresh=new JButton("刷新");
    JButton bt_del=new JButton("删除");
    JButton bt_back=new JButton("复位");

    static String[] gradeItem = new String[]{"","大一","大二","大三","大四"};

    static JComboBox<String> jc1= new JComboBox<>(gradeItem);




    public JF_StuInforSelect() {
        JFrame jff=new JFrame("学生信息查询");
        Container c1=jff.getContentPane();
        c1.setLayout(new BorderLayout());
        JPanel jjp=new JPanel();
        jjp.setLayout(new FlowLayout());
        c1.add(jjp,BorderLayout.NORTH);

        jjp.add(jl_grade);
        jjp.add(jc1);
        jjp.add(jl_class);jjp.add(tf_classid);




        jjp.add(jl_sid);jjp.add(tf_id);

        jjp.add(bt_del); jjp.add(bt_back);jjp.add(bt_refresh);



        JScrollPane jsc=new JScrollPane();
        jsc.setBounds(100, 100, 400, 300);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());
        JTable jt=new JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        /**
         * 设置单行可选中
         */
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        c1.add(jsc,BorderLayout.CENTER);

        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"学生编号","班级编号","学生姓名","性别","年龄"});

        jt.setModel(infoModel);
        /**
         * 表格内字体居中
         */
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);


        //添加监听
        bt_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /**
                 * 清表刷新界面
                 */
                DefaultTableModel model=(DefaultTableModel) jt.getModel();
                model.setRowCount(0);

                String stuid=tf_id.getText();
                String gradeID = (String) jc1.getSelectedItem();
                String classid = tf_classid.getText();

                studentDao studentDao = new studentDao();
                gradeDao gradeDao=new gradeDao();

                if (((String)jc1.getSelectedItem()).equals("")&&tf_classid.getText().equals("")&&tf_id.getText().equals("")){
                    List<TbStudentinfo> tbStudentinfos = studentDao.selectAll();
                    int i = 0;
                    for (TbStudentinfo t :
                        tbStudentinfos) {
                        if (t!=null){
                            Object[] item=new Object[]{t.getStuid(),t.getclassID(),t.getStuname(),t.getSex(),t.getAge()};
                            model.addRow(item);
                        }
                    }jl_resultnum.setText("已找到"+tbStudentinfos.size()+"条数据");
                }else if (tf_classid.getText().equals("")&&tf_id.getText().equals("")){
                    List<TbClassinfo> selectGrade=gradeDao.selectAllGrade(gradeID);
//                    System.out.println(selectGrade.size());
                    int sum=0;
                    for(TbClassinfo c:
                        selectGrade){
                            String classid1 = c.getclassID();
                            List<TbStudentinfo> tbStudentinfos = studentDao.selectAllinClass(classid1);
                            sum+=tbStudentinfos.size();
                            for (TbStudentinfo t :
                            tbStudentinfos) {
                                if (t!=null){
                                    Object[] item=new Object[]{t.getStuid(),t.getclassID(),t.getStuname(),t.getSex(),t.getAge()};
                                    model.addRow(item);

                                }
                       }jl_resultnum.setText("已找到"+sum+"条数据");
                }
                }else if (((String)jc1.getSelectedItem()).equals("")&&tf_id.getText().equals("")){
                    List<TbStudentinfo> tbStudentinfos = studentDao.selectAllinClass(classid);
                        for (TbStudentinfo t : tbStudentinfos) {
                            if (t!=null){
                                Object[] item=new Object[]{t.getStuid(),t.getclassID(),t.getStuname(),t.getSex(),t.getAge()};
                                model.addRow(item);
                            }
                        }jl_resultnum.setText("已找到"+tbStudentinfos.size()+"条数据");
                }else if (((String)jc1.getSelectedItem()).equals("")&&tf_classid.getText().equals("")){
                    TbStudentinfo select = studentDao.select(stuid);
                    if (select!=null){
                        Object[] item=new Object[]{select.getStuid(),select.getclassID(),select.getStuname(),select.getSex(),select.getAge()};
                        model.addRow(item);
                    }
                    jl_resultnum.setText("已找到1条数据");
                }
            }
        });


        bt_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentDao studentDao = new studentDao();
                if (jt.getSelectedRow()==-1){
                }else{
                    String valueAt=(String) jt.getValueAt(jt.getSelectedRow(),0);
                    int delete=studentDao.delete(valueAt);
                    if(delete>0){
                        JOptionPane.showMessageDialog(null,"此条信息已被删除");
                    }


                }

            }
        });



        jsc.setViewportView(jt);
        jsc.add(jsb);
        c1.add(jl_resultnum,BorderLayout.SOUTH);




        jl_resultnum.setBounds(50, 450, 200, 20);
        jff.setResizable(false);
        jff.setSize(650, 600);
        jff.setVisible(true);


        bt_back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tf_classid.setText("");
                tf_id.setText("");
                jc1.setSelectedItem("");
                jl_resultnum.setText("已找到 条数据");
            }
        });
    }

    public static void main(String[] args) {
        new JF_StuInforSelect();
    }
}
