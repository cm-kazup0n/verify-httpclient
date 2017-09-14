package classmethod;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ConnectionChecker {


    private final List<String> uris = Arrays.asList(
    );

    public void execute(Supplier<HttpClient> clientBuilder){
        uris.forEach(uri ->{
            try{
                final HttpUriRequest request = new HttpGet(new URI(uri));
                clientBuilder.get().execute(request);
                System.out.println("Requesting to " + uri + " succeed");
            }catch(IOException | URISyntaxException e){
                System.out.println("Error on " + uri);
                System.out.println(e.getMessage());
                System.out.println(formatStacktrace(e));
            }
        });
    }

    public String formatStacktrace(Throwable e){
        // エラーのスタックトレースを表示
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

}
