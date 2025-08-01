/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.cdc.connectors.fluss.sink.v2.metrics;

import org.apache.flink.metrics.Meter;

/* This file is based on source code of Apache Fluss Project (https://fluss.apache.org/), licensed by the Apache
 * Software Foundation (ASF) under the Apache License, Version 2.0. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership. */

/** An implementation of Flink's {@link Meter} which wraps Fluss's Meter. */
public class WrapperFlussMeter implements Meter {

    private final com.alibaba.fluss.metrics.Meter flussMeter;

    public WrapperFlussMeter(com.alibaba.fluss.metrics.Meter flussMeter) {
        this.flussMeter = flussMeter;
    }

    @Override
    public void markEvent() {
        flussMeter.markEvent();
    }

    @Override
    public void markEvent(long n) {
        flussMeter.markEvent(n);
    }

    @Override
    public double getRate() {
        return flussMeter.getRate();
    }

    @Override
    public long getCount() {
        return flussMeter.getCount();
    }
}
