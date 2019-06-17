/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.samza.system.elasticsearch;

import org.apache.samza.system.SystemAdmin;
import org.apache.samza.system.SystemStreamMetadata;
import org.apache.samza.system.SystemStreamPartition;
import org.apache.samza.util.SinglePartitionWithoutOffsetsSystemAdmin;

import java.util.Map;
import java.util.Set;

/**
 * Elasticsearch as an output system does not have a notion of offsets, and partitions are not of use.
 *
 * Instead of creating an implementation which responds with NotImplementedException however, use the util
 * SinglePartitionWithoutOffsetsSystemAdmin. This allows Elasticsearch to work in a stand alone job.
 */
public class ElasticsearchSystemAdmin {
  private static final SystemAdmin singleton = new SinglePartitionWithoutOffsetsSystemAdmin();

  private ElasticsearchSystemAdmin() {
    // Ensure this can not be constructed.
  }

  public static SystemAdmin getInstance() {
    return singleton;
  }
}
