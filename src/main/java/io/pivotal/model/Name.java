/*
 * Copyright (C) 2018-Present Pivotal Software, Inc. All rights reserved.
 * This program and the accompanying materials are made available under
 * the terms of the under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.model;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@Region("Name")
public class Name implements PdxSerializable {
    @Id
    String name;

    public Name(String name) {
        this.name = name;
    }

    /**
     * Needed for {@link PdxSerializable}
     */
    public Name() {
    }

    public String getName() {
        return name;
    }

    @Override
    public void toData(PdxWriter writer) {
        writer.writeString("name", this.name);
    }

    @Override
    public void fromData(PdxReader reader) {
        this.name = reader.readString("name");
    }
}