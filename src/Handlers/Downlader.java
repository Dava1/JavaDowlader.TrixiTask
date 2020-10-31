package Handlers;

import Entity.CastAObce;
import Entity.Obec;
import Parser.XmlParser;

import java.io.File;
import java.util.Set;

public class Downlader {
  //pro spracovani dat
  private UrlDownloader urlDownloader;
  private UnZipHandler unZipHandler;
  private XmlParser xmlParser;

private String dirPath = "/home/davinci/Downloads/TrixiDownloader/";
private String path = "/home/davinci/Downloads/TrixiDownloader/Trixi.zip";
    public Downlader(String fileName,String url){
       urlDownloader = new UrlDownloader(fileName);
       urlDownloader.download(url);
       unZipHandler = new UnZipHandler(path,new File(dirPath));
       unZipHandler.unzip();
       xmlParser = new XmlParser();
   }
   public Set<Obec> getObce(){
     return xmlParser.getSetObce();
  }
    public Set<CastAObce> getCastObces(){
      return xmlParser.getSetCastObce();
  }
}
