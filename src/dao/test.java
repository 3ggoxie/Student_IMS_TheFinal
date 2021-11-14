package dao;

import entity.TbStudentinfo;

import java.util.List;

public class test {
    public static void main(String[] args) {
        studentDao studentDao = new studentDao();
        List<TbStudentinfo> tbStudentinfos = studentDao.selectAllinClass("1901");
        for (TbStudentinfo t :
                tbStudentinfos) {
            System.out.println(t);
        }
    }
}
