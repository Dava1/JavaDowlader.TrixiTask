package Handlers;

import Interfacies.IDownlader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * tato trida stahne soubor z urzitoho Urla a ulozit do home direktore s  vasem nazvem
 */
public class UrlDownloader implements IDownlader {
    //"https://vdp.cuzk.cz/vymenny_format/soucasna/20200930_OB_573060_UZSZ.xml.zip"
    private String fileName;
    public UrlDownloader(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void download(String url) {
        try {
        URL urlZip = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)urlZip.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            FileOutputStream out = new FileOutputStream(fileName);
            copy(in,out,1024);
            out.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(InputStream in, FileOutputStream out,int size){
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
