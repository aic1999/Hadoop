package com.bigdata.yunpan;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *	一个简易的示例demo1，实现创建目录。记得更改xml配置文件！
 */
public class YunPanDemo {
		public static void main(String[] args) {
			Configuration conf=new Configuration();  //负责获取相应虚拟机的配置文件信息
			try {
				FileSystem fs=FileSystem.get(conf);  //文件系统的管理类
				Path path=new Path("/yunpan");   
				fs.mkdirs(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}