// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.ui.export;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

import org.eclipse.core.runtime.CoreException;
import org.apache.tools.tar.TarOutputStream;
import org.apache.tools.tar.TarEntry;

/**
 * Exports resources to a .tar.gz file.
 * 
 * @since 3.1
 */
public class TarFileExporterFullPath implements IFileExporterFullPath {

    private TarOutputStream outputStream;

    private GZIPOutputStream gzipOutputStream;

    /**
     * Create an instance of this class.
     * 
     * @param filename java.lang.String
     * @param compress boolean
     * @exception java.io.IOException
     */
    public TarFileExporterFullPath(String filename, boolean compress) throws IOException {
        if (compress) {
            gzipOutputStream = new GZIPOutputStream(new FileOutputStream(filename));
            outputStream = new TarOutputStream(new BufferedOutputStream(gzipOutputStream));
        } else {
            outputStream = new TarOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        }
    }

    /**
     * Do all required cleanup now that we're finished with the currently-open .tar.gz
     * 
     * @exception java.io.IOException
     */
    public void finished() throws IOException {
        outputStream.close();
        if (gzipOutputStream != null) {
            gzipOutputStream.close();
        }
    }

    /**
     * Write the contents of the file to the tar archive.
     * 
     * @param entry
     * @param contents
     * @exception java.io.IOException
     * @exception org.eclipse.core.runtime.CoreException
     */
    private void write(TarEntry entry, String contents) throws IOException, CoreException {

        java.io.File localFile = new File(contents);

        if (!localFile.exists()) {
            throw new FileNotFoundException(contents);
        }

        entry.setSize(localFile.length());

        outputStream.putNextEntry(entry);
        InputStream contentStream = new FileInputStream(contents);
        try {
            int n;
            byte[] readBuffer = new byte[4096];
            while ((n = contentStream.read(readBuffer)) > 0) {
                outputStream.write(readBuffer, 0, n);
            }
        } finally {
            if (contentStream != null) {
                contentStream.close();
            }
        }

        outputStream.closeEntry();
    }

    /**
     * Write the passed resource to the current archive.
     * 
     * @param resource org.eclipse.core.resources.IFile
     * @param destinationPath java.lang.String
     * @exception java.io.IOException
     * @exception org.eclipse.core.runtime.CoreException
     */
    public void write(String resource, String destinationPath) throws IOException, CoreException {

        TarEntry newEntry = new TarEntry(destinationPath);
        write(newEntry, resource);
    }
}
