package com.flowerfat.utiltool.Utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bigflower on 2015/11/6.
 */
public class FileUtil {

    /**
     * delete file or delete folder and it's children
     *
     * @param file file or folder
     * @return success or fail
     * @throws IOException
     */
    public static boolean del(File file) throws IOException {
        if (file == null || !file.exists()) {
            return true;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File childFile : files) {
                boolean isOk = del(childFile);
                if (!isOk) {
                    //删除一个出错则本次删除任务失败
                    return false;
                }
            }
        }
        return file.delete();
    }

}
