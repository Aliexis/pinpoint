/*
 * Copyright 2017 NAVER Corp.
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
 */

package com.navercorp.pinpoint.profiler.context.provider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.navercorp.pinpoint.bootstrap.plugin.jdbc.JdbcConnectionStringParser;
import com.navercorp.pinpoint.profiler.context.DefaultJdbcConnectionStringParserContext;
import com.navercorp.pinpoint.profiler.plugin.PluginContextLoadResult;

import java.util.List;

/**
 * @author Taejin Koo
 */
public class JdbcUrlParserContextProvider implements Provider<DefaultJdbcConnectionStringParserContext> {

    private final Provider<PluginContextLoadResult> pluginContextLoadResultProvider;

    @Inject
    public JdbcUrlParserContextProvider(Provider<PluginContextLoadResult> pluginContextLoadResultProvider) {
        if (pluginContextLoadResultProvider == null) {
            throw new NullPointerException("pluginContextLoadResult must not be null");
        }
        this.pluginContextLoadResultProvider = pluginContextLoadResultProvider;
    }

    @Override
    public DefaultJdbcConnectionStringParserContext get() {
        PluginContextLoadResult pluginContextLoadResult = this.pluginContextLoadResultProvider.get();
        List<JdbcConnectionStringParser> jdbcConnectionStringParserList = pluginContextLoadResult.getJdbcConnectionStringParserList();

        return new DefaultJdbcConnectionStringParserContext(jdbcConnectionStringParserList);
    }

}
