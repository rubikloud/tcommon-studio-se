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
package org.talend.core.hadoop.api.components;

/**
 * Interface that exposes specific Hive methods.
 *
 */
public interface HiveComponent extends MRComponent {

    /**
     * @return true if the distribution does support the Hive embedded mode.
     */
    public boolean doSupportEmbeddedMode();

    /**
     * @return true if the distribution does support the Hive standalone mode.
     */
    public boolean doSupportStandaloneMode();

    /**
     * @return true if the distribution does support the Hive1 version.
     */
    public boolean doSupportHive1();

    /**
     * @return true if the distribution does support the Hive1 version in Stadalone mode. This method is made for
     * Hortonworks distribution that doesn't support it.
     */
    public boolean doSupportHive1Standalone();

    /**
     * @return true if the distribution does support the Hive2 version.
     */
    public boolean doSupportHive2();

    /**
     * @return true if the distribution supports TEZ for Hive.
     */
    public boolean doSupportTezForHive();

    /**
     * @return true if the distribution does support the Hive HBase storage.
     */
    public boolean doSupportHBaseForHive();

    /**
     * @return true if the distribution does support the SSL.
     */
    public boolean doSupportSSL();

    /**
     * @return true if the distribution does support the ORC file format.
     */
    public boolean doSupportORCFormat();

    /**
     * @return true if the distribution does support the Avro file format.
     */
    public boolean doSupportAvroFormat();

    /**
     * @return true if the distribution does support the Parquet file format.
     */
    public boolean doSupportParquetFormat();

    /**
     * Up to hive 0.12, special input/output/row format classes are required to store data in Parquet format in hive
     * tables, which are found in a parquet-hive-bundle-VERSION.jar. From hive 0.13 on, Parquet is integrated into hive
     * and tables can be created with "STORE AS PARQUET" directly.
     * 
     * @see https://cwiki.apache.org/confluence/display/Hive/Parquet,
     * @return true if the distribution requires the deprecated parquet hive bundles to support Parquet storage.
     */
    public boolean doSupportStoreAsParquet();

}
