package me.dngynq.creative;

import java.io.File;

public class delete {

    public static void usage(final File dir) {
        if (dir.isDirectory()) {
            final String[] children = dir.list();
            for (int i = 0; i < children.length; ++i) {
                final File f = new File(dir, children[i]);
                usage(f);
            }
            dir.delete();
        }
        else {
            dir.delete();
        }
    }
	
}
