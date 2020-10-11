package Handlers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * tato trida stahne zip z Url
 */
public class UrlDownloader {
    public void downloadZip() {
        try {
        URL url = new URL( "https://vdp.cuzk.cz/vymenny_format/soucasna/20200930_OB_573060_UZSZ.xml.zip");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            FileOutputStream out = new FileOutputStream("Trixi.zip");
            copy(in,out,1024);
            out.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void copy(InputStream in, FileOutputStream out,int size){
    byte[]  buffer = new byte[size];
    int n = 0;
        try {
            n = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(n>=0){
            try {
            out.write(buffer, 0,n);
            n = in.read(buffer);
            out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
