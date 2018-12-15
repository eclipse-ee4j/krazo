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
package org.eclipse.krazo.binding;

import javax.enterprise.inject.Vetoed;
import javax.mvc.binding.BindingError;
import javax.mvc.binding.BindingResult;
import javax.mvc.binding.ParamError;
import javax.mvc.binding.ValidationError;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation for {@link javax.mvc.binding.BindingResult} interface.
 *
 * @author Santiago Pericas-Geertsen
 * @author Christian Kaltepoth
 */
@Vetoed // produced by BindingResultManager
public class BindingResultImpl implements BindingResult {

    private final Set<BindingError> bindingErrors = new LinkedHashSet<>();

    private final Set<ValidationError> validationErrors = new LinkedHashSet<>();

    private boolean consumed;

    @Override
    public boolean isFailed() {
        this.consumed = true;
        return validationErrors.size() > 0 || bindingErrors.size() > 0;
    }

    @Override
    public List<String> getAllMessages() {
        this.consumed = true;
        return Stream.concat(bindingErrors.stream(), validationErrors.stream())
                .map(ParamError::getMessage)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public Set<ParamError> getAllErrors() {
        this.consumed = true;
        return Stream.concat(bindingErrors.stream(), validationErrors.stream())
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    @Override
    public Set<ParamError> getErrors(String param) {
        Objects.requireNonNull(param, "Parameter name is required");
        this.consumed = true;
        return Stream.concat(bindingErrors.stream(), validationErrors.stream())
                .filter(paramError -> Objects.equals(paramError.getParamName(), param))
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public void addValidationErrors(Set<ValidationError> validationErrors) {
        this.validationErrors.addAll(validationErrors);
    }

    public void addBindingError(BindingError bindingError) {
        this.bindingErrors.add(bindingError);
    }

    public boolean hasUnconsumedErrors() {
        return !consumed && (!bindingErrors.isEmpty() || !validationErrors.isEmpty());
    }

}
