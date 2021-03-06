/*
 * Copyright 2011-2017 Amazon Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.eclipse.core.validator;

import java.io.File;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

/**
 * File exists and valid validator.
 */
public class FilePathValidator implements IValidator {
    private final String propertyName;

    public FilePathValidator(String propertyName) {
        this.propertyName = propertyName;
    }

    /* (non-Javadoc)
     * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
     */
    @Override
    public IStatus validate(Object value) {
        String filePath = (String) value;
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return ValidationStatus.error("Property " + propertyName + " does not contain a valid file!");
        }
        return ValidationStatus.ok();
    }
}
