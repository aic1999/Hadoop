package com.bigdata.yunpan;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *	һ�����׵�ʾ��demo1��ʵ�ִ���Ŀ¼���ǵø���xml�����ļ���
 */
public class YunPanDemo {
		public static void main(String[] args) {
			Configuration conf=new Configuration();  //�����ȡ��Ӧ������������ļ���Ϣ
			try {
				FileSystem fs=FileSystem.get(conf);  //�ļ�ϵͳ�Ĺ�����
				Path path=new Path("/yunpan");   
				fs.mkdirs(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}