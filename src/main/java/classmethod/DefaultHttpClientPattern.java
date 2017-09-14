package classmethod;

import org.apache.http.impl.client.DefaultHttpClient;

public class DefaultHttpClientPattern {


    public static void main(String[] args) {
        /* 4.5.3以前ではエラー */
        new ConnectionChecker().execute(()->new DefaultHttpClient());

    }
}
