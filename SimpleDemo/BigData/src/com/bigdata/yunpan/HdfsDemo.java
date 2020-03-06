package com.bigdata.yunpan;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *	һ�����׵�ʾ��demo2���ǵø���xml�����ļ���
 */
public class HdfsDemo {
    public static void main(String[] args) {
    	createList("/yunpan");
    	//createFolder("/yunpan");
      //uploadFile("/yunpan/upload.doc ","e://upload.doc");
	  //downloadFile("/yunpan/download.doc","e:// download.doc");
      //listFile(new Path("/"));
    }
    
    /**
     * �г������ļ�������
     * @param path ����ѯ·��
     */
    public static void listFile(Path path) {
    	Configuration conf = new Configuration();
	    try {
	    FileSystem fs = FileSystem.get(conf);
	    //����·������ʾ��ĳ��·���µ��ļ����б������ʾ
	    //������·�������е��ļ�Ԫ���ݷŵ�һ��FileStatus�������С�
	    //FileStatus�����װ���ļ��ĺ�Ŀ¼��Ԫ���ݣ������ļ����ȡ����С��Ȩ�޵���Ϣ
	    	    FileStatus[] fileStatusArray = fs.listStatus(path);
	    	    for (int i = 0; i < fileStatusArray.length; i++) {
	    	         FileStatus fileStatus = fileStatusArray[i];
	    	       //���ȼ�⵱ǰ����Ƿ����ļ��У�������ǡ�����еݹ� 
	    		    if (fileStatus.isDirectory()) {
	    		        System.out.println("��ǰ·���ǣ�" + fileStatus.getPath());
	    			   listFile(fileStatus.getPath());
	    		    } else {
	    		        System.out.println("��ǰ·���ǣ�"  + fileStatus.getPath());
	    		    }
	    	    }
	    } catch (IOException e) {
	    e.printStackTrace();
	    }
    }
    
    /**
     * ��·���´���һ���ļ���
     * @param p ·��
     */
    public static void createFolder(String p) {
    	// ����һ�����ö���
    	Configuration conf = new Configuration();
    	try {
    		// ͨ��������Ϣ�õ��ļ�ϵͳ�Ķ���
    		FileSystem fs = FileSystem.get(conf);
    		//��ָ����·���´����ļ���
    		Path path = new Path(p);
    		fs.mkdirs(path);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

   /**
    * �ϴ��ļ�
    * @param webPath  Ҫ������web�ϵ�·��
    * @param localPath ���ϴ��ļ���·��
    */
    public static void uploadFile(String webPath,String localPath) {
    	Configuration conf = new Configuration();
    	try {
    		FileSystem fs = FileSystem.get(conf);
    		//�����ļ���·�����ϴ���·��
    		Path src = new Path(localPath);
    		Path dest = new Path(webPath);
    		//�ӱ����ϴ��ļ���������
    		fs.copyFromLocalFile(src, dest);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    /**
     * �����ļ�
     * @param webPath  ��web�ϣ��������ļ���·��
     * @param localPath �����صı���·��
     */
    public static void downloadFile(String webPath,String localPath) {
    	Configuration conf = new Configuration();
    	try {
    		FileSystem fs = FileSystem.get(conf);
    		//���������ļ���·���ͱ�������·��
    		Path src = new Path(webPath);
    		Path dest = new Path(localPath);
    		//�ӷ����������ļ�������
    		fs.copyToLocalFile(src, dest);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    /**
     * ����Ŀ¼
     * @param p  ����Ŀ¼��·��
     */
    public static void createList(String p) {
		Configuration conf=new Configuration();  //�����ȡ��Ӧ������������ļ���Ϣ
		try {
			FileSystem fs=FileSystem.get(conf);  //�ļ�ϵͳ�Ĺ�����
			Path path=new Path(p);   
			fs.mkdirs(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
