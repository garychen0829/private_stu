package com.stu.callback.junit;

import com.stu.callback.Client;
import com.stu.callback.Server;
import org.junit.Test;

/**
 * Created by garychen on 2017/5/9.
 */
public class CallbackTest {


    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("hello");
    }
}
