/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.flinkx.connector.mysql.sink;

import com.dtstack.flinkx.conf.SyncConf;
import com.dtstack.flinkx.connector.jdbc.outputformat.JdbcOutputFormatBuilder;
import com.dtstack.flinkx.connector.jdbc.sink.JdbcDataSink;
import com.dtstack.flinkx.connector.mysql.MySQLDialect;
import com.dtstack.flinkx.connector.mysql.MysqlLogicalTypeFactory;
import com.dtstack.flinkx.connector.mysql.outputFormat.MysqlOutputFormat;

/**
 * Date: 2021/04/13
 * Company: www.dtstack.com
 *
 * @author tudou
 */
public class MysqlSink extends JdbcDataSink {

    public MysqlSink(SyncConf syncConf) {
        super(syncConf);
        super.jdbcDialect = new MySQLDialect();
        jdbcLogicalTypeFactory = new MysqlLogicalTypeFactory(jdbcConf, jdbcDialect);
    }

    @Override
    protected JdbcOutputFormatBuilder getBuilder() {
        return new JdbcOutputFormatBuilder(new MysqlOutputFormat());
    }
}