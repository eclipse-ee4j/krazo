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
package org.eclipse.krazo.util;

import java.util.Objects;

/**
 * Utility methods for path and URI handling.
 *
 * @author Santiago Pericas-Geertsen
 */
public final class PathUtils {

    /**
     * Drops starting slash from path if present.
     *
     * @param path the path.
     * @return the resulting path without a starting slash.
     */
    public static String noStartingSlash(String path) {
        Objects.requireNonNull(path, "path must not be null");
        return hasStartingSlash(path) ? path.substring(1) : path;
    }

    /**
     * Determines of path starts with a slash.
     *
     * @param path the path to test.
     * @return outcome of test.
     */
    public static boolean hasStartingSlash(String path) {
        Objects.requireNonNull(path, "path must not be null");
        return !"".equals(path) && path.charAt(0) == '/';
    }

    /**
     * Drops a prefix from a path if it exists or returns original path if prefix does
     * not match.
     *
     * @param path the path.
     * @param prefix the prefix to drop.
     * @return new path without prefix or old path if prefix does not exist.
     */
    public static String noPrefix(String path, String prefix) {
        Objects.requireNonNull(path, "path must not be null");
        Objects.requireNonNull(prefix, "prefix must not be null");
        return path.startsWith(prefix) ? path.substring(prefix.length()) : path;
    }

    /**
     * Ensures that a path always starts with a slash.
     *
     * @param path the path.
     * @return path that starts with a slash.
     */
    public static String ensureStartingSlash(String path) {
        Objects.requireNonNull(path, "path must not be null");
        return "".equals(path) || path.charAt(0) != '/' ? ("/" + path) : path;
    }

    /**
     * Ensures that a path always ends with a slash.
     *
     * @param path the path.
     * @return path that starts with a slash.
     */
    public static String ensureEndingSlash(String path) {
        Objects.requireNonNull(path, "path must not be null");
        return "".equals(path) || path.charAt(path.length() - 1) != '/' ? (path + "/") : path;
    }

    /**
     * Ensures that a path does not end with a slash. May return an
     * empty string.
     *
     * @param path the path.
     * @return path not ending with slash or empty string.
     */
    public static String ensureNotEndingSlash(String path) {
        Objects.requireNonNull(path, "path must not be null");
        if ("".equals(path)) {
            return path;
        }
        final int length = path.length();
        return path.charAt(length - 1) == '/' ? path.substring(0, length - 1) : path;
    }

    /**
     * Returns a normalized path. If the path is empty or "/*", then an empty string
     * is returned. Otherwise, the path returned always starts with a "/" but does not
     * end with one.
     *
     * @param path the path to normalize.
     * @return normalized path.
     */
    public static String normalizePath(String path) {
        Objects.requireNonNull(path, "path must not be null");
        return path.isEmpty() || path.equals("/*") ? "" : ensureNotEndingSlash(ensureStartingSlash(path));
    }

}
