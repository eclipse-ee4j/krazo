/*
 * Copyright © 2017, 2018 Ivar Grimstad
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

import com.google.common.cache.Cache;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.cache.BaseTagCacheKey;
import com.mitchellbosecke.pebble.extension.escaper.EscapeFilter;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.mitchellbosecke.pebble.template.PebbleTemplateImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.Properties;
import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class PebbleEngineProducerTest {

  Properties properties;
  PebbleEngineProducer pebbleEngineProducer;

  @Before
  public void setup() {
    properties = new Properties();
    pebbleEngineProducer = new PebbleEngineProducer(properties, null);
  }

  @Test
  public void shouldCreateAnInstanceOfPebbleEngine() {
    assertTrue(pebbleEngineProducer.pebbleEngine() instanceof PebbleEngine);
  }

  @Test
  public void shouldIgnoreEmptyValueAndUseDefaultValue() {
    properties.put(PebbleProperty.TAG_CACHE_MAX.key(), "");
    properties.put(PebbleProperty.CACHE_ACTIVE.key(), "true");

    Cache<BaseTagCacheKey, Object> tagCache = pebbleEngineProducer.pebbleEngine().getTagCache();

    IntStream.range(0, 250).forEach(i -> tagCache.put(new BaseTagCacheKey(String.valueOf(i)) {
    }, i));

    assertEquals(200, tagCache.size());
  }

  @Test
  public void shouldUseServletContextLoader() {
    assertTrue(pebbleEngineProducer.pebbleEngine().getLoader() instanceof ServletLoader);
  }

  @Test
  public void shouldSetCorrectLocale() {
    properties.put(PebbleProperty.DEFAULT_LOCALE.key(), "de");

    assertEquals(Locale.GERMAN, pebbleEngineProducer.pebbleEngine().getDefaultLocale());
  }

  @Test
  public void shouldCorrectlySetTagCache() {
    properties.put(PebbleProperty.TAG_CACHE_MAX.key(), "123");
    Cache<BaseTagCacheKey, Object> tagCache = pebbleEngineProducer.pebbleEngine().getTagCache();

    IntStream.range(0, 200).forEach(i -> tagCache.put(new BaseTagCacheKey(String.valueOf(i)) {
    }, i));

    assertEquals(123, tagCache.size());
  }

  @Test
  public void shouldCorrectlySetTemplateCache() {
    properties.put(PebbleProperty.TEMPLATE_CACHE_MAX.key(), "126");
    Cache<Object, PebbleTemplate> templateCache = pebbleEngineProducer.pebbleEngine().getTemplateCache();

    IntStream.range(0, 200).forEach(i -> templateCache.put(i, new PebbleTemplateImpl(null, null, String.valueOf(i))));

    assertEquals(126, templateCache.size());
  }

  @Test
  public void shouldNotSetCachesWhenCachingIsOff() {
    properties.put(PebbleProperty.CACHE_ACTIVE.key(), "false");
    properties.put(PebbleProperty.TAG_CACHE_MAX.key(), "123");
    properties.put(PebbleProperty.TEMPLATE_CACHE_MAX.key(), "126");

    Cache<BaseTagCacheKey, Object> tagCache = pebbleEngineProducer.pebbleEngine().getTagCache();
    IntStream.range(0, 200).forEach(i -> tagCache.put(new BaseTagCacheKey(String.valueOf(i)) {
    }, i));

    Cache<Object, PebbleTemplate> templateCache = pebbleEngineProducer.pebbleEngine().getTemplateCache();
    IntStream.range(0, 200).forEach(i -> templateCache.put(i, new PebbleTemplateImpl(null, null, String.valueOf(i))));

    assertEquals(0, tagCache.size());
    assertEquals(0, templateCache.size());
  }

  @Test
  public void shouldCorrectlySetStrictVariables() {
    properties.put(PebbleProperty.STRICT_VARIABLES.key(), "true");

    assertTrue(pebbleEngineProducer.pebbleEngine().isStrictVariables());

    properties.put(PebbleProperty.STRICT_VARIABLES.key(), "false");

    assertFalse(pebbleEngineProducer.pebbleEngine().isStrictVariables());
  }

  @Test
  public void shouldCorrectlySetExecutorService() {
    properties.put(PebbleProperty.EXECUTOR_SERVICE.key(), CustomExecutorService.class.getCanonicalName());

    assertTrue(pebbleEngineProducer.pebbleEngine().getExecutorService() instanceof CustomExecutorService);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhileSettingExecutorService() {
    properties.put(PebbleProperty.EXECUTOR_SERVICE.key(), "org.dummy.DummyExecutorService");

    pebbleEngineProducer.pebbleEngine();
  }

  @Test
  public void shouldCorrectlySetExtensions() {
    properties.put(PebbleProperty.EXTENSION.key(), String.format("%s,%s", CustomExtensionOne.class.getCanonicalName(), CustomExtensionTwo.class.getCanonicalName()));

    pebbleEngineProducer.pebbleEngine();

    properties.put(PebbleProperty.EXTENSION.key(), String.format("%s , %s", CustomExtensionOne.class.getCanonicalName(), CustomExtensionTwo.class.getCanonicalName()));

    pebbleEngineProducer.pebbleEngine();
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowExceptionWhileSettingExtensions() {
    properties.put(PebbleProperty.EXTENSION.key(), String.format("%s-%s", CustomExtensionOne.class.getCanonicalName(), CustomExtensionTwo.class.getCanonicalName()));

    pebbleEngineProducer.pebbleEngine();
  }

  @Test
  public void shouldCorrectlySetEscapingStrategy() {
    properties.put(PebbleProperty.ESCAPING_STRATEGY.key(), CustomEscapingStrategy.class.getCanonicalName());

    PebbleEngine pebbleEngine = pebbleEngineProducer.pebbleEngine();
    EscapeFilter ef = (EscapeFilter) pebbleEngine.getExtensionRegistry().getFilter("escape");

    assertEquals(ef.getDefaultStrategy(), "userDefinedEscapingStrategy");
  }
}
