/*
 * Copyright (c) 2014-2015 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, 2019 Eclipse Krazo committers and contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.eclipse.krazo.ext.pebble;

import com.mitchellbosecke.pebble.attributes.AttributeResolver;
import com.mitchellbosecke.pebble.extension.*;
import com.mitchellbosecke.pebble.operator.BinaryOperator;
import com.mitchellbosecke.pebble.operator.UnaryOperator;
import com.mitchellbosecke.pebble.tokenParser.TokenParser;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomExtensionOne implements Extension {

    @Override
    public Map<String, Filter> getFilters() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public Map<String, Test> getTests() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public Map<String, Function> getFunctions() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public List<TokenParser> getTokenParsers() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<BinaryOperator> getBinaryOperators() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<UnaryOperator> getUnaryOperators() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Map<String, Object> getGlobalVariables() {
        return Collections.EMPTY_MAP;
    }

    @Override
    public List<NodeVisitorFactory> getNodeVisitors() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<AttributeResolver> getAttributeResolver() {
        return Collections.EMPTY_LIST;
    }

}
