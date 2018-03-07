package netty.netty1.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio--blocking io-堵塞io
 * @Description: TODO
 * @author: zhangyc
 * @date: 2018年3月7日 下午2:02:28
 */
public class Server {

	final static int PROT = 8765;
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(PROT);
			System.out.println(" server start .. ");
			//进行阻塞
			//处于等待连接的状态，实时监控网络状态。
			Socket socket = server.accept();
			//新建一个线程执行客户端的任务
			//响应客户端套接字的请求，建立一个新的线程，把服务器端套接字的描述发给客户端，一旦客户端确认了此描述，连接就建立好了。
//			而服务器端套接字继续处于监听状态，继续接收其他客户端套接字的连接请求。
			new Thread(new ServerHandler(socket)).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			server = null;
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
