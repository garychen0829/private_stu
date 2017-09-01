package com.sftp;


import com.jcraft.jsch.*;
import com.util.ThreeDes;
import org.apache.http.client.utils.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by garychen on 2017/8/29.
 */
public class SFTP_downLoad {

    private static final Logger log = LoggerFactory.getLogger(SFTP_downLoad.class);

    private String host = "172.18.90.37";
    private String port = "22";
    private String username = "chenh";
    private String passwd = "chenh123456";
    private int timeout = 10000;

    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    String curtime = df.format(new Date());

    private Channel channel = null;
    private Session session = null;

    @Test
    public void test_sftp() throws Exception {
        SFTP_downLoad s = new SFTP_downLoad();
        //下载文件
        boolean b = s.downLoad_sftp();
        if (!b) {
            log.debug("文件下载失败:", b);
        }

//        String dst = "E:\\home\\CCF_20170829161311.zip"; // 本地文件名
//
//        InputStream input = new FileInputStream(new File(dst));
//        BufferedInputStream bf = new BufferedInputStream(input);
//        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024 * 2];
//        int line = 0;
//        while ((line = bf.read(buf)) != -1) {
//            swapStream.write(buf, 0, line);
//        }
//
//        //解密文件
//        byte[] key = "379096883262308065431046".getBytes();
//        //文件数据
//        byte[] data = swapStream.toByteArray();
//
//        byte[] retBytes = ThreeDes.trides_decrypt(key, data);
//
//        //InputStream in = new ByteArrayInputStream(retBytes);
//
//        byte2File(retBytes, "E:\\home\\", "psbc.zip");
    }

    public static void byte2File(byte[] buf, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public boolean downLoad_sftp() throws Exception {
        boolean bool = false;
        try {
            //打开 channel
            ChannelSftp chSftp = getChannel();

            String dst = "E:\\home\\CCF_" + curtime + ".zip"; // 本地文件名
            String filename = "/upload/CCF_20170814_1.zip"; // 目标文件名

            SftpATTRS attr = chSftp.stat(filename);
            long fileSize = attr.getSize();
            System.out.println("size:" + fileSize);

            OutputStream out = new FileOutputStream(dst);
            InputStream is = chSftp.get(filename, new FileProgressMonitor(fileSize));
            byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
            int read;
            if (out != null) {
                System.out.println("Start to read input stream");
                do {
                    read = is.read(buff, 0, buff.length);
                    if (read > 0) {
                        out.write(buff, 0, read);
                    }
                    out.flush();
                } while (read >= 0);
                bool = true;
                System.out.println("input stream read done.." + bool);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭 channel
            closeChannel();
        }
        return bool;
    }

    /**
     * connect
     *
     * @return
     * @throws JSchException
     */
    public ChannelSftp getChannel() throws JSchException {
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, host);
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, username);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, passwd);
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, port);

        JSch jSch = new JSch();

        session = jSch.getSession(sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME),
                sftpDetails.get(SFTPConstants.SFTP_REQ_HOST),
                Integer.parseInt(sftpDetails.get(SFTPConstants.SFTP_REQ_PORT)));
        if (sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD) != null) {
            session.setPassword(sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD)); // 设置密码
        }

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接

        channel = session.openChannel("sftp");//打开SFTP通道
        channel.connect(); //建立SFTP通道的连接

        return (ChannelSftp) channel;
    }

    /**
     * close
     *
     * @throws Exception
     */
    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }


    public static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(
                        str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }
    }
}
