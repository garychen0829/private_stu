package com.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by garychen on 2017/10/12.
 */
public class FTPDownLoad {

    @Value("${ftp_host}")
    private String ftp_host = "172.18.90.37";

    @Value("${ftp_port}")
    private Integer ftp_port = 21;

    @Value("${ftp_user}")
    private String ftp_user = "vsftp";

    @Value("${ftp_pwd}")
    private String ftp_pwd = "zcs_ftp_123";

    @Value("${ftp_path}")
    private String ftp_path = "/upload";

    @Value("${local_path}")
    private String local_path = "/home/sh_app/opt/provider-account/lkl/";

    /**
     * 下载文件
     * @param shortTime
     * @return
     */
    public boolean downloadFile(String shortTime) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(ftp_host, ftp_port);
            boolean b = ftpClient.login(ftp_user,ftp_pwd);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                //close
                ftpClient.disconnect();
            }

            //ftpClient 参数设置
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//二进制
            ftpClient.enterLocalPassiveMode();//*necessary*
            ftpClient.changeWorkingDirectory(ftp_path);//切换工作目录

            FTPFile[] fs = ftpClient.listFiles();

            //本地文件存放路径
            String local_file_path = local_path + "/" + shortTime;
            File fl = new File(local_file_path);
            if (!fl.exists()  && !fl.isDirectory()) {
                fl.mkdir();
            }

            FileOutputStream fos = null;
            //批量下载
            for(FTPFile ftpfile : fs){
                fos = new FileOutputStream(local_file_path + "/" + ftpfile.getName());
                ftpClient.retrieveFile(ftpfile.getName(),fos);
                fos.flush();
                fos.close();

                System.out.println(">>>>>>>>文件下载成功:["+ftpfile.getName()+"]");
            }

            ftpClient.disconnect();

            //logger.info(">>>>>>>>文件下载成功.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
