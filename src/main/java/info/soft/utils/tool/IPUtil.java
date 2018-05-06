package info.soft.utils.tool;


import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * IP工具类
 * 
 * @author gy
 *
 */
public class IPUtil {

        /**
         * 获取本机所有的IPv4地址,<br />
         * 若 there is an error creating or accessing a Socket则返回null.
         * 
         * @return IPv4集合
         */
        public static List<String> getIPv4() {
                Enumeration<NetworkInterface> allNetInterfaces = null;
                try {
                        allNetInterfaces = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e) {
                        return null;
                }
                List<String> ips = new LinkedList<String>();
                while (allNetInterfaces.hasMoreElements()) {
                        NetworkInterface netInterface = allNetInterfaces.nextElement();
                        Enumeration<InetAddress> inetAddrs = netInterface.getInetAddresses();
                        while (inetAddrs.hasMoreElements()) {
                                InetAddress inetAddr = inetAddrs.nextElement();
                                if (inetAddr == null || inetAddr.isLoopbackAddress())
                                        continue;
                                if (inetAddr instanceof Inet4Address) {
                                        ips.add(inetAddr.getHostAddress());
                                }
                        }
                }
                return ips;
        }

        /**
         * 获取ipv4地址后两个数
         * 
         * @return
         */
        public static int getServerId() {
                int id = 0;
                try {
                        List<String> ips = IPUtil.getIPv4();
                        if (!CollectionUtils.isEmpty(ips)) {
                              String[] strs = ips.get(0).split("\\.");
                              if (null != strs && strs.length == 4) {
                                      String str = strs[2].trim() + strs[3].trim();
                                      id = Integer.valueOf(str.trim());
                              }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return id;
        }

        /**
         * 获取本机所有的IPv6地址<br />
         * 若 there is an error creating or accessing a Socket则返回null.
         * 
         * @return IPv6集合
         */
        public static List<String> getIPv6() {
                Enumeration<NetworkInterface> allNetInterfaces = null;
                try {
                        allNetInterfaces = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e) {
                        return null;
                }
                List<String> ips = new LinkedList<String>();
                while (allNetInterfaces.hasMoreElements()) {
                        NetworkInterface netInterface = allNetInterfaces.nextElement();
                        Enumeration<InetAddress> inetAddrs = netInterface.getInetAddresses();
                        while (inetAddrs.hasMoreElements()) {
                                InetAddress inetAddr = inetAddrs.nextElement();
                                if (inetAddr == null || inetAddr.isLoopbackAddress())
                                        continue;
                                if (inetAddr instanceof Inet6Address) {
                                        ips.add(inetAddr.getHostAddress());
                                }
                        }
                }
                return ips;
        }
}
