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
package org.eclipse.krazo.uri;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>Encapsulates an URI-template and query- and matrix parameters.</p>
 *
 * @author Florian Hirsch
 */
public class UriTemplate {

    private final String path;

    private final Set<String> queryParams;

    private final Set<String> matrixParams;

    private UriTemplate(String path, Set<String> queryParams, Set<String> matrixParams) {
        this.path = path;
        this.queryParams = queryParams;
        this.matrixParams = matrixParams;
    }

    static Builder fromTemplate(String template) {
        return new Builder(template);
    }

    public String path() {
        return path;
    }

    Set<String> queryParams() {
        return queryParams;
    }

    Set<String> matrixParams() {
        return matrixParams;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        UriTemplate that = (UriTemplate) other;
        return Objects.equals(path, that.path) &&
            Objects.equals(queryParams, that.queryParams) &&
            Objects.equals(matrixParams, that.matrixParams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, queryParams, matrixParams);
    }

    @Override
    public String toString() {
        return String.format("UriTemplate { path: %s, queryParams: %s, matrixParams: %s }",
            path, queryParams, matrixParams);
    }

    /**
     * <p>Builder for a UriTemplate.</p>
     */
    static class Builder {

        private String path;

        private Set<String> queryParams;

        private Set<String> matrixParams;

        Builder(String path) {
            Objects.requireNonNull(path, "path must not be null");
            this.path = path;
        }

        Builder queryParam(String queryParam) {
            if (queryParams == null) {
                queryParams = new HashSet<>();
            }
            queryParams.add(queryParam);
            return this;
        }

        Builder matrixParam(String matrixParam) {
            if (matrixParams == null) {
                matrixParams = new HashSet<>();
            }
            matrixParams.add(matrixParam);
            return this;
        }

        UriTemplate build() {
            return new UriTemplate(path,
                queryParams == null ? Collections.emptySet() : queryParams,
                matrixParams == null ? Collections.emptySet() : matrixParams);
        }

    }

}
