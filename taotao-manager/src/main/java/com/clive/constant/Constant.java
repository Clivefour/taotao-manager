package com.clive.constant;

public interface Constant {
	//上传图片的服务器地址
	String FTP_ADDRESS="192.168.175.129";
	//上传图片的服务器端口号
	Integer FTP_PORT=21;
	//上传图片的服务器账号
	String FTP_USERNAME="ftpuser";
	//上传图片的服务器密码
	String FTP_PASSWORD="ftpuser";
	//上传图片的服务器图片存放路径
	String FILI_UPLOAD_PATH="/home/ftpuser/www/images";
	////上传图片的服务器外界访问图片的根路径
	String IMAGE_BASE_URL="http://192.168.175.129/images";
}
