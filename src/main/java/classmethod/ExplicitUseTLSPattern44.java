package classmethod;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;

public class ExplicitUseTLSPattern44 {


    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
        /* 4.3.1以下ではエラー */
        final SSLContext sslContext = SSLContexts.custom().useSSL().build();

        final SSLConnectionSocketFactory f = new SSLConnectionSocketFactory(
                sslContext,
                new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"},
                null,
                BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        new ConnectionChecker().execute(()-> HttpClients.custom().setSSLSocketFactory(f).build());
    }
}
