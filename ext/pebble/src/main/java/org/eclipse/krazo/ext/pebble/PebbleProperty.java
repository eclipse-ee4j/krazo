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

import java.util.Optional;
import java.util.stream.Stream;

public enum PebbleProperty {

  AUTO_ESCAPING("autoEscaping"),
  CACHE_ACTIVE("cacheActive"),
  ESCAPING_STRATEGY("escapingStrategy"),
  DEFAULT_LOCALE("defaultLocale"),
  NEW_LINE_TRIMMING("newLineTrimming"),
  STRICT_VARIABLES("strictVariables"),
  EXECUTOR_SERVICE("executorService"),
  EXTENSION("extension"),
  TAG_CACHE_MAX("tagCacheMax"),
  TEMPLATE_CACHE_MAX("templateCacheMax"),
  UNKNOWN("unknown");

  private static final String GROUP_PREFIX = "org.eclipse.krazo.ext.pebble.";
  private final String key;

  private PebbleProperty(String key) {
    this.key = key;
  }

  public String key() {
    return GROUP_PREFIX + this.key;
  }

  public static PebbleProperty fromKey(String key) {
    return Stream.of(PebbleProperty.values())
        .filter(property -> property.key().equals(key))
        .findFirst()
        .orElse(UNKNOWN);
  }

  public Optional<String> systemPropertyValue() {
    return Optional.ofNullable(System.getProperty(this.key()));
  }
}
