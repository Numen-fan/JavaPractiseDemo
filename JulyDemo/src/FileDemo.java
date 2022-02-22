import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            File inFile = new File("/Users/fanjiajia02/Desktop/baiduhi.txt");
            File outFile = new File("/Users/fanjiajia02/Desktop/a.txt");

            inputStream = new FileInputStream(inFile);
            outputStream = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024*8];//创建搬运工具
            int len = 0;//创建长度
            while((len = inputStream.read(buffer))!=-1)//循环读取数据
            {
                outputStream.write(buffer,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

        }

    }
}
