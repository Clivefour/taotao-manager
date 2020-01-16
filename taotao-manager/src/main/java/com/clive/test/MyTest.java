package com.clive.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class MyTest {
	@Test
	public void show() throws Exception{
		/**
		 *  通过java代码 吧图片上传到图片服务器
		 *  注意 
		 *  	你们现在用的是 我给你们的免费的 ftp图片服务器
		 *  	我们要用ftp的代码来上传图片到 图片服务器
		 *  	以后你们用阿里云的 收费的图片服务器 
		 *  	你们就要用阿里云的代码来上传图片 到阿里云的图片服务器上
		 *  	你们去了日本
		 *  	你们就要用日本的 收费的图片服务器了
		 *  	你们要用日本的代码 吧图片上传的 日本的收费的图片服务器上
		 *  聊天软件的协议叫做 xmpp协议 腾讯自己研发了一个协议出来 自己封装的socket协议
		 */
		//创建ftp客户端对象 他用来通过ftp协议 来连接我们的图片服务器 ftp图片服务器
		FTPClient ftpClient = new FTPClient();
		//你要连接哪个服务器 你要告诉我 ip地址
		ftpClient.connect("192.168.175.128");
		//输入账号密码
		ftpClient.login("ftpuser", "ftpuser");
		//解决图片上传的时候 上传的图片 0kb的情况
		ftpClient.enterLocalPassiveMode();
		
		//指定图片的上传类型 固定写法
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		
		InputStream inputStream = new FileInputStream(new File("E:\\教学资料\\java\\图片资源\\1.jpg"));
		
		/**
		 * 1.吧图片上传到哪个位置上面去
		 * /home/ftpuser/www/images 固定写法
		 * 123.jpg 你的图片名称叫做
		 * 2.你要上传那张图片 你要把图片变成input输入流才行
		 */
		ftpClient.storeFile("/home/ftpuser/www/images/123.jpg", inputStream);
		//关闭乱流
		inputStream.close();
		//关闭ftp的流
		ftpClient.logout();
		System.out.println("上传成功了 哈哈哈");

		
	}
}
