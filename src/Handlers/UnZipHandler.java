package Handlers;

import Interfacies.IUnZipping;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * trida zpracauje zip
 */
public class UnZipHandler implements IUnZipping {
    private String pathToFile;
    private File destDir;

    UnZipHandler(String pathToFile,File destDir){
        this.pathToFile =pathToFile;
        this.destDir =destDir;
    }
    @Override
    public void unzip() {
    byte[] buffer = new byte[1024];
        try{
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathToFile));
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            File nFile = newFile(destDir, zipEntry);
            FileOutputStream fos = new FileOutputStream(nFile);
            int length;
            while ((length = zipInputStream.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
        } catch(
        FileNotFoundException e)
        {
        e.printStackTrace();
        } catch(IOException e) {
        e.printStackTrace();
        }
    }
    private  File newFile(File destDir, ZipEntry zipEntry) {
        File destFile = new File(destDir,zipEntry.getName());
        try {
            String destDirPath = destDir.getCanonicalPath();
            String destFilePath = destFile.getCanonicalPath();
            if(!destFilePath.startsWith(destDirPath + File.separator)){
                throw new IOException("Entry is outside of the target dir: "+ zipEntry.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destFile;
    }
}
