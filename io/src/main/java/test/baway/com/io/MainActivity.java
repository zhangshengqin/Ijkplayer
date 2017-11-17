package test.baway.com.io;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;

    private String content="老百姓今个";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        File file =new File("/mnt/sdcard/cxy.txt");
        switch (view.getId()) {
            case R.id.btn1:
                try {
                    file.createNewFile();
                    //实例化一个输出流
                    FileOutputStream out=new FileOutputStream(file);
                    //FileOutputStream out=new FileOutputStream("/mnt/sdcard/cxy.txt");
                    //把文字转化为字节数组
                    byte[] bytes = content.getBytes();
                    //写入字节数组到文件
                    out.write(bytes);
                    //关闭输入流
                    out.close();
                    Toast.makeText(MainActivity.this, "写入成功", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn2:
                try {
                    String text=null;
                    //实例化一个输入流
                    FileInputStream input=new FileInputStream(file);
                    //把文件中的所有内容转换为byte字节数组
                    byte[] bytes = new byte[input.available()];
                    //读取内容
                    input.read(bytes);
                    //关闭输入流
                    input.close();
                    //把bytes字节数组转化为文字
                    text=new String(bytes);
                    Toast.makeText(MainActivity.this,text, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }


    }
}
