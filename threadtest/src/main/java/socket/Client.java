package socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>类名注释</br>类的用途</p>
 *
 * @author WanChuanLai Email:wanchuanlai@co-mall.com
 * @version 3.1.1
 * @company 北京科码先锋软件技术有限公司@版权所有
 * @since 2018年03月07日 16:01.
 */
public class Client {
    /**
     * 处理服务端发回的对象，可实现该接口。
     */
    public static interface ObjectAction {
        void doAction(Object obj, Client client);
    }

    public static final class DefaultObjectAction implements ObjectAction {
        public void doAction(Object obj, Client client) {
            System.out.println("处理：\t" + obj.toString());
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        String serverIp = "127.0.0.1";
        int port = 7890;
        Client client = new Client(serverIp, port);
        client.start();
    }

    private String serverIp;
    private int port;
    private Socket socket;
    private boolean running = false;
    private long lastSendTime;
    private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class, ObjectAction>();

    public Client(String serverIp, int port) {
        this.serverIp = serverIp;
        this.port = port;
    }

    public void start() throws UnknownHostException, IOException {
        if (running) return;
        socket = new Socket(serverIp, port);
        System.out.println("本地端口：" + socket.getLocalPort());
        lastSendTime = System.currentTimeMillis();
        running = true;
        // new Thread(new KeepAliveWatchDog()).start();
        new Thread(new ReceiveWatchDog()).start();
    }

    public void stop() {
        if (running) running = false;
    }

    /**
     * 添加接收对象的处理对象。
     *
     * @param cls    待处理的对象，其所属的类。
     * @param action 处理过程对象。
     */
    public void addActionMap(Class<Object> cls, ObjectAction action) {
        actionMapping.put(cls, action);
    }

    public void sendObject(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        System.out.println("发送：\t" + obj);
        oos.flush();
    }

    class KeepAliveWatchDog implements Runnable {
        long checkDelay = 10;
        long keepAliveDelay = 30000;

        public void run() {
            while (running) {
                if (System.currentTimeMillis() - lastSendTime > keepAliveDelay) {
                    try {
                        Client.this.sendObject("我来了");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Client.this.stop();
                    }
                    lastSendTime = System.currentTimeMillis();
                } else {
                    try {
                        Thread.sleep(checkDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Client.this.stop();
                    }
                }
            }
        }
    }

    class ReceiveWatchDog implements Runnable {
        public void run() {
            while (running) {
                try {
                    InputStream in = socket.getInputStream();
                    if (in.available() > 0) {
                        ObjectInputStream ois = new ObjectInputStream(in);
                        Object obj = ois.readObject();
                        System.out.println("接收：\t" + obj);
                        if (obj.equals("HEART_BEAT_COMMAND_HEADER")) {
                            sendObject("HEART_BEAT_COMMAND_HEADER");
                        }
//                        ObjectAction oa = actionMapping.get(obj.getClass());
//                        oa = oa == null ? new DefaultObjectAction() : oa;
//                        oa.doAction(obj, Client.this);
                    } else {
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Client.this.stop();
                }
            }
        }
    }

    class KeepAlive implements Serializable {
        private static final long serialVersionUID = -2813120366138988480L;

        /* 覆盖该方法，仅用于测试使用。
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t维持连接包";
        }
    }

}
