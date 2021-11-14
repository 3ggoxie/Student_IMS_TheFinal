package appstu_view;


import dao.subjectGradeDao;
import entity.TbGradeinfoSub;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class JF_perGradeInfo {
    private static String username;
    public JF_perGradeInfo(String username)  {

        this.username = username;
        JFrame jf=new JFrame("成绩信息");
        Container c=jf.getContentPane();
        JPanel p1=new JPanel();
        p1.setLayout(null);


        JScrollPane jsc=new JScrollPane();
        jsc.setBounds(100, 100, 400, 300);
        JScrollBar jsb=new JScrollBar();
        jsb.setLayout(new FlowLayout());

        JTable jt=new JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){

                if (colIndex==3)
                    return true;
                // TODO: 2021-9-27 0027 记得删
                return false;
            }};


        DefaultTableModel infoModel = (DefaultTableModel) jt.getModel();
        infoModel.setColumnIdentifiers(new Object[] {"考试编号","考试科目","成绩"});

        jt.setModel(infoModel);

        jt.setBounds(0, 100, 500, 500);
        jt.setEnabled(false);

        jsc.setViewportView(jt);
        jsc.add(jsb);

        c.add(p1);c.add(jsc, BorderLayout.CENTER);


        DefaultTableModel model=(DefaultTableModel) jt.getModel();
        model.setRowCount(0);
        subjectGradeDao subjectGradeDao=new subjectGradeDao();
        List<TbGradeinfoSub> selectAllPerGrade=subjectGradeDao.selectAllPerGrade(username);
        for(TbGradeinfoSub t:selectAllPerGrade){
            if (t!=null){
                Object[] item=new Object[]{t.getCode(),t.getSubject(),t.getGrade()};
                model.addRow(item);
        }}




        jf.setResizable(false);
        jf.setSize(650,600);
        jf.setVisible(true);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();

        cr.setHorizontalAlignment(JLabel.CENTER);
        jt.setDefaultRenderer(Object.class,cr);

    }

    public static void main(String[] args) {
        new JF_perGradeInfo(username);
    }
}
