package com.zlh.utils;

import java.security.MessageDigest;

/**
 * Encrypt是用于计算区块的hash值的工具类
 * @author ZhouLinHu
 * @createTime 2019年1月5日 下午12:54:59
 * @lastTime 2019年1月5日 下午12:54:59
 * @version 1.0.0
 */
public class Encrypt {
	
	/**
	 * 传入字符串，返回SHA-256加密字符串
	 * @param strText
	 * @return
	 */
	public String getSHA256(final String strText) {
		return SHA(strText, "SHA-256");
	}
	
	/**
	 * 传入字符串，返回SHA-512加密字符串
	 * @param strText
	 * @return
	 */
	public String getSHA512(final String strText) {
		return SHA(strText, "SHA-512");
	}

	/**
	 * 传入字符串，返回MD5加密字符串
	 * @param strText
	 * @return
	 */
	public String getMD5(final String strText){
		return SHA(strText, "MD5");
	}

	/**
	 * 字符串SHA加密
	 * @param strText
	 * @param strType
	 * @return
	 */
	private String SHA(final String strText, final String strType) {
		String strResult=null;//返回值
		//是否是有效字符串
		if(strText != null && strText.length() > 0) {
			try {
				//SHA加密开始
				//创建加密对象
				MessageDigest messageDigest=MessageDigest.getInstance(strType);
				//传入要加秘密的字符串
				messageDigest.update(strText.getBytes());
				//得到byte数组
				byte byteBuffer[]=messageDigest.digest();
				//将byte数组转化尾String类型
				StringBuffer strHexString = new StringBuffer();
				//遍历byte数组
				for(int i=0;i<byteBuffer.length;i++) {
					//转换成16进制存储在字符串中
					String hex=Integer.toHexString(0xff & byteBuffer[i]);
					if(hex.length()==1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				//得到返回结果
				strResult=strHexString.toString();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return strResult;
	}
}
