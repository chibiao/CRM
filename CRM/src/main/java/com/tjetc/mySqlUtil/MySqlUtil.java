package com.tjetc.mySqlUtil;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
public class MySqlUtil {
	 public static boolean doBackup(){
	        System.out.println("现在时间是"+new Date());
	        Runtime runtime = Runtime.getRuntime();  //获取Runtime实例
	        String database = "CRM"; // 需要备份的数据库名
	        Date currentDate = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String sdfDate = sdf.format(currentDate);
	        String filepath = "d:\\time_" + sdfDate + ".sql"; // 备份的路径地址
	        //执行命令
	        //mysqldump -h localhost -u root -p123 --databases mldn> d:\time.sql
	        String stmt = "mysqldump -h 152.136.67.194 -u CRM -pliuzheng --databases "+database+">"+filepath;
	        System.out.println(stmt);
	        try {
	            String[] command = { "cmd", "/c", stmt};
	            System.out.println(command.toString()+"------");
	            Process process = runtime.exec(command);
	            InputStream input =  process.getInputStream();
	            System.out.println(IOUtils.toString(input, "UTF-8"));
	            //若有错误信息则输出
	            InputStream errorStream = process.getErrorStream();
	            System.out.println(IOUtils.toString(errorStream, "gbk"));
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    /**
	     * 还原数据库
	     */
	    public static boolean restore(String fileName) {
	        String database = "CRM"; // 需要备份的数据库名
	        System.out.println("现在时间是" + new Date());
	        Runtime runtime = Runtime.getRuntime();
	        try {
	            String filePath =  "D:\\"+fileName; // sql文件路径
	            String stmt = "mysql -h 152.136.67.194 -u CRM -pliuzheng "+database+"<"+filePath;
	            System.out.println(stmt);
	            String[] command = {"cmd", "/c", stmt};
	            Process process = runtime.exec(command);
	            //若有错误信息则输出
	            InputStream errorStream = process.getErrorStream();
	            System.out.println(IOUtils.toString(errorStream, "gbk"));
	            //等待操作
	            int processComplete = process.waitFor();
	            if (processComplete == 0) {
	                System.out.println("还原成功.");
	                return true;
	            } else {    	
	                throw new RuntimeException("还原数据库失败.");	                
	            }
	        } catch (Exception e) {	        	
	            e.printStackTrace();
	            return false;
	        }
	    }
}
