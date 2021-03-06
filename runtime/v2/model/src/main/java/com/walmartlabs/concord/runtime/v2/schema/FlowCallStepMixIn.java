package com.walmartlabs.concord.runtime.v2.schema;

/*-
 * *****
 * Concord
 * -----
 * Copyright (C) 2017 - 2020 Walmart Inc.
 * -----
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =====
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaInject;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaTitle;
import com.walmartlabs.concord.runtime.v2.model.Step;

import java.util.List;
import java.util.Map;

@JsonTypeName("FlowCallStep")
public interface FlowCallStepMixIn extends NamedStep {

    @JsonSchemaTitle("Flow Call step")
    @JsonProperty(value = "call", required = true)
    String call();

    @JsonProperty("in")
    @JsonSchemaInject(json = "{\"oneOf\": [ {\"type\": \"string\"}, {\"type\": \"object\"} ]}", merge = false)
    Object input();

    @JsonProperty("out")
    @JsonSchemaInject(json = "{\"oneOf\": [ {\"type\": \"array\", \"items\" : {\"type\" : \"string\"}}, {\"type\": \"object\"}, {\"type\": \"string\"} ]}", merge = false)
    Object out();

    @JsonProperty("retry")
    RetryMixIn retry();

    @JsonProperty("error")
    List<Step> error();

    @JsonProperty("withItems")
    WithItemsMixIn withItems();

    @JsonProperty("parallelWithItems")
    WithItemsMixIn parallelWithItems();

    @JsonProperty("meta")
    Map<String, Object> meta();
}
