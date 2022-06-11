import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.kevintam.entity.Student;
import com.kevintam.utils.EasyExcelListener;
import org.apache.commons.codec.Resources;

/**
 * @author kevintam
 * @version 1.0
 * @title
 * @description
 * @createDate 2022/6/11
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        String excelPath= "/Users/kevintam/project/SpringBoot-Timer/src/main/resources/student.xls";
        ExcelReaderBuilder read = EasyExcel.read(excelPath, Student.class, new EasyExcelListener());
        read.excelType(ExcelTypeEnum.XLS);
        read.sheet("学生信息").doRead();
    }
}
