package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static ArrayList<String> MailInfoList = new ArrayList<String>();
	
	public void getMailInfo(int num){
		try {
			receive(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	public void receive(int num) throws Exception {
		// 准备连接服务器的会话信息
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "pop3");		// 协议
		props.setProperty("mail.pop3.port", "110");				// 端口
		props.setProperty("mail.pop3.host", "software.nju.edu.cn");	// pop3服务器
		
		// 创建Session实例对象
		Session session = Session.getInstance(props);
		Store store = session.getStore("pop3");
		store.connect("nas14@software.nju.edu.cn", "8623625niansong");
		
		// 获得收件箱
		Folder folder = store.getFolder("INBOX");
		/* Folder.READ_ONLY：只读权限
		 * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
		 */
		folder.open(Folder.READ_WRITE);	//打开收件箱
		
		// 由于POP3协议无法获知邮件的状态,所以getUnreadMessageCount得到的是收件箱的邮件总数
		System.out.println("未读邮件数: " + folder.getUnreadMessageCount());
		
		// 由于POP3协议无法获知邮件的状态,所以下面得到的结果始终都是为0
		System.out.println("删除邮件数: " + folder.getDeletedMessageCount());
		System.out.println("新邮件: " + folder.getNewMessageCount());
		
		// 获得收件箱中的邮件总数
		System.out.println("邮件总数: " + folder.getMessageCount());
		
		// 得到收件箱中的所有邮件,并解析
		Message[] messages = folder.getMessages();
		parseMessage(num,messages);
		
		//释放资源
		folder.close(true);
		store.close();
		
	}
	
	/**
	 * 解析邮件
	 * @param messages 要解析的邮件列表
	 */
	public void parseMessage(int num,Message ...messages) throws MessagingException, IOException {
		if (messages == null || messages.length < 1) 
			throw new MessagingException("未找到要解析的邮件!");
		
		for (int i = 0, count = messages.length; i < count&&i<num; i++) {
			MimeMessage msg = (MimeMessage) messages[i]; 
			StringBuffer content = new StringBuffer(30);
			getMailTextContent(msg, content);
			String result = content.toString();
//			System.out.println("origin text: "+result);
//			result = result.split("<")[0];
//			try{
//			result = result.split("好！")[1];
//			}catch(Exception e){
//			}
			MailInfoList.add(result);
			System.out.println("现在共有："+MailInfoList.size()+" 封邮件！");
		}
	}
	
	public static void getMailTextContent(Part part, StringBuffer content) throws MessagingException, IOException {
		//如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
		boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;	
		if (part.isMimeType("text/*") && !isContainTextAttach) {
			content.append(part.getContent().toString());
		} else if (part.isMimeType("message/rfc822")) {	
			getMailTextContent((Part)part.getContent(),content);
		} else if (part.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) part.getContent();
			int partCount = multipart.getCount();
			for (int i = 0; i < partCount; i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);
				getMailTextContent(bodyPart,content);
			}
		}
	}
	
	public static boolean isSeen(MimeMessage msg) throws MessagingException {
		return msg.getFlags().contains(Flags.Flag.SEEN);
	}
}
