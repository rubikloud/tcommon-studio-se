// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.metadata.managment.hive;

import org.talend.core.classloader.ClassLoaderFactory;
import org.talend.core.database.conn.ConnParameterKeys;
import org.talend.core.model.metadata.IMetadataConnection;
import org.talend.core.model.metadata.connection.hive.HiveConnUtils;
import org.talend.metadata.managment.connection.manager.DatabaseConnConstants;

/**
 * <pre>
 * This factory is used to get the class loaders for hive by the different index.
 * </pre>
 * 
 * <pre>
 * <li>For hive server one, the index format should be like this: <B>HIVE:HORTONWORKS:HDP_1_0:EMBEDDED</B>. 
 * <li>For hive server two, the index format should be like this: <B>HIVE2:HORTONWORKS:HDP_1_0:EMBEDDED</B>.
 * </pre>
 * 
 * Created by Marvin Wang on Mar 12, 2013.
 */
public class HiveClassLoaderFactory {

    private static HiveClassLoaderFactory instance = null;

    private HiveClassLoaderFactory() {
    }

    /**
     * Gets an instance of <code>HiveClassLoaderFactory</code>, which is synchronized. Added by Marvin Wang on Mar 12,
     * 2013.
     * 
     * @return
     */
    public static synchronized HiveClassLoaderFactory getInstance() {
        if (instance == null) {
            instance = new HiveClassLoaderFactory();
        }
        return instance;
    }

    /**
     * Gets an instance of <code>ClassLoader</code> by the given argument, it invokes {
     * {@link #getHive1ClassLoader(IMetadataConnection)} and {@link #getHive2ClassLoader(IMetadataConnection)}. Added by
     * Marvin Wang on Mar 13, 2013.
     * 
     * @param metadataConn
     * @return
     */
    public ClassLoader getClassLoader(IMetadataConnection metadataConn) {
        ClassLoader classloader = null;
        String url = metadataConn.getUrl();

        // url = "jdbc:hive2://";
        if (url != null) {
            if (url.startsWith(DatabaseConnConstants.HIVE_2_URL_FORMAT)) {
                classloader = getHive2ClassLoader(metadataConn);
            } else if (url.startsWith(DatabaseConnConstants.HIVE_1_URL_FORMAT)) {
                classloader = getHive1ClassLoader(metadataConn);
            } else {
                // do nothing
            }
        }
        return classloader;
    }

    /**
     * Gets the class loader for different version by the given parameters for hive1 server. Added by Marvin Wang on Mar
     * 12, 2013.
     * 
     * @param metadataConn
     * @return
     */
    protected ClassLoader getHive1ClassLoader(IMetadataConnection metadataConn) {
        ClassLoader loader = null;
        // For hive embedded model, all parameters below should not be null, if null, then need to check.
        String distroKey = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_DISTRIBUTION);
        String distroVersion = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_VERSION);
        String hiveModel = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_MODE);
        if (HiveConnUtils.isCustomDistro(distroKey)) {
            String jarsStr = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HADOOP_CUSTOM_JARS);
            String index = "HadoopCustomVersion:Hive:" + metadataConn.getId(); //$NON-NLS-1$
            loader = ClassLoaderFactory.getCustomClassLoader(index, jarsStr);
        } else {
            String index = "HIVE" + ":" + distroKey + ":" + distroVersion + ":" + hiveModel; //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$ //$NON-NLS-4$ 
            loader = ClassLoaderFactory.getClassLoader(index);
            // If there is no class loader gotten by index, then use the current classloader.
            if (loader == null) {
                loader = HiveClassLoaderFactory.class.getClassLoader();
            }
        }

        return loader;
    }

    /**
     * 
     * Added by Marvin Wang on Mar 27, 2013.
     * 
     * @param metadataConn
     * @return
     */
    protected ClassLoader getHive2ClassLoader(IMetadataConnection metadataConn) {
        ClassLoader loader = null;
        // For hive embedded model, all parameters below should not be null, if null, then need to check.
        String distroKey = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_DISTRIBUTION);
        String distroVersion = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_VERSION);
        String hiveModel = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HIVE_MODE);

        if (HiveConnUtils.isCustomDistro(distroKey)) {
            String jarsStr = (String) metadataConn.getParameter(ConnParameterKeys.CONN_PARA_KEY_HADOOP_CUSTOM_JARS);
            String index = "HadoopCustomVersion:Hive2:" + metadataConn.getId(); //$NON-NLS-1$
            loader = ClassLoaderFactory.getCustomClassLoader(index, jarsStr);
        } else {
            String index = "HIVE2" + ":" + distroKey + ":" + distroVersion + ":" + hiveModel; //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$ //$NON-NLS-4$ 
            loader = ClassLoaderFactory.getClassLoader(index);
            // If there is no class loader gotten by index, then use the current classloader.
            if (loader == null) {
                loader = HiveClassLoaderFactory.class.getClassLoader();
            }
        }

        return loader;
    }
}