package com.bigdata.yunpan;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *	一个简易的示例demo2，记得更改xml配置文件！
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
     * 列出所有文件的名字
     * @param path 待查询路径
     */
    public static void listFile(Path path) {
    	Configuration conf = new Configuration();
	    try {
	    FileSystem fs = FileSystem.get(conf);
	    //传入路径，表示对某个路径下的文件夹列表进行显示
	    //将给定路径下所有的文件元数据放到一个FileStatus的数组中。
	    //FileStatus对象封装了文件的和目录的元数据，包括文件长度、块大小、权限等信息
	    	    FileStatus[] fileStatusArray = fs.listStatus(path);
	    	    for (int i = 0; i < fileStatusArray.length; i++) {
	    	         FileStatus fileStatus = fileStatusArray[i];
	    	       //首先检测当前检测是否是文件夹，如果“是”则进行递归 
	    		    if (fileStatus.isDirectory()) {
	    		        System.out.println("当前路径是：" + fileStatus.getPath());
	    			   listFile(fileStatus.getPath());
	    		    } else {
	    		        System.out.println("当前路径是："  + fileStatus.getPath());
	    		    }
	    	    }
	    } catch (IOException e) {
	    e.printStackTrace();
	    }
    }
    
    /**
     * 在路径下创建一个文件夹
     * @param p 路径
     */
    public static void createFolder(String p) {
    	// 定义一个配置对象
    	Configuration conf = new Configuration();
    	try {
    		// 通过配置信息得到文件系统的对象
    		FileSystem fs = FileSystem.get(conf);
    		//在指定的路径下创建文件夹
    		Path path = new Path(p);
    		fs.mkdirs(path);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

   /**
    * 上传文件
    * @param webPath  要放置在web上的路径
    * @param localPath 待上传文件的路径
    */
    public static void uploadFile(String webPath,String localPath) {
    	Configuration conf = new Configuration();
    	try {
    		FileSystem fs = FileSystem.get(conf);
    		//定义文件的路径和上传的路径
    		Path src = new Path(localPath);
    		Path dest = new Path(webPath);
    		//从本地上传文件到服务器
    		fs.copyFromLocalFile(src, dest);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    /**
     * 下载文件
     * @param webPath  在web上，待下载文件的路径
     * @param localPath 待下载的本地路径
     */
    public static void downloadFile(String webPath,String localPath) {
    	Configuration conf = new Configuration();
    	try {
    		FileSystem fs = FileSystem.get(conf);
    		//定义下载文件的路径和本地下载路径
    		Path src = new Path(webPath);
    		Path dest = new Path(localPath);
    		//从服务器下载文件到本地
    		fs.copyToLocalFile(src, dest);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    /**
     * 创建目录
     * @param p  创建目录的路径
     */
    public static void createList(String p) {
		Configuration conf=new Configuration();  //负责获取相应虚拟机的配置文件信息
		try {
			FileSystem fs=FileSystem.get(conf);  //文件系统的管理类
			Path path=new Path(p);   
			fs.mkdirs(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
