/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.shenyu.sdk.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shenyu.sdk.core.common.RequestTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * Shenyu request test {@link ShenyuRequest}.
 */
public class ShenyuRequestTest {

    private ShenyuRequest request;

    @Before
    public void setUp() {
        String url = "http://127.0.0.1/";
        List<String> list = Lists.newArrayList("text/html", "image/gif");
        Map<String, Collection<String>> header = Maps.newHashMap();
        header.put("accept", list);
        String body = "{\"data\":\"test\"}";
        String name = "shenyu.open.test";
        RequestTemplate requestTemplate = new RequestTemplate();
        request = new ShenyuRequest(ShenyuRequest.HttpMethod.POST, url, header, body, name, requestTemplate);
    }

    @Test
    public void testCreate() {
        ShenyuRequest newRequest = ShenyuRequest.create("http://127.0.0.2/", request);
        assertNotEquals(newRequest, request);
    }

}
