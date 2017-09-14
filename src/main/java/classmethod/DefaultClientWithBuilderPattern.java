package classmethod;

import org.apache.http.impl.client.HttpClients;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class DefaultClientWithBuilderPattern {


    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
        /* 4.3.1以下ではエラー */
        /* 4.4.1ではエラー */
        new ConnectionChecker().execute(()->HttpClients.createDefault());
    }
}
