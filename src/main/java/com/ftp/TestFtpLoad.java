package com.ftp;

import org.junit.Test;

/**
 * Created by garychen on 2017/10/12.
 */
public class TestFtpLoad {

    @Test
    public void test01_ftp_download(){

        FTPDownLoad ftpDownLoad = new FTPDownLoad();

        ftpDownLoad.downloadFile("20171013");
    }
}
