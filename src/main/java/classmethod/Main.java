package classmethod;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class Main {


    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException {

//        System.out.println("legcy");
//        DefaultHttpClientPattern.main(args);
        /* 以下は4.3以降でないとビルドできない */
        System.out.println("default");
        DefaultClientWithBuilderPattern.main(args);
        System.out.println("43");
        ExplicitUseTLSPattern43.main(args);
        System.out.println("44");
        ExplicitUseTLSPattern44.main(args);

    }

}
