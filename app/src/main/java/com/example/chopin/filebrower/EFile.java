package com.example.chopin.filebrower;

import java.io.File;

/**
 * Created by Chopin on 2017/7/2.
 */

public class EFile {
    private File file=null;

    public EFile(File file){
            this.file=file;
    }

    public File getFile(){
        return file;
    }

    @Override
    public String toString() {
        if (getFile()==null){
            return  "";
        }
        return String.format("[%s]%s",getFile().isDirectory()?"DIR":"FILE",getFile().getName());
    }
}
