/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.slc.sli.modeling.uml;

import java.util.List;

/**
 * A UML TagDefinition defines a the type of a TaggedValue.
 */
public class TagDefinition extends NamespaceOwnedElement implements HasMultiplicity {
    
    private final Multiplicity multiplicity;
    
    public TagDefinition(final Identifier id, final List<TaggedValue> taggedValues, final String name,
            final Multiplicity multiplicity) {
        super(id, name, taggedValues);
        if (multiplicity == null) {
            throw new IllegalArgumentException("multiplicity");
        }
        this.multiplicity = multiplicity;
    }
    
    public TagDefinition(final Identifier id, final String name, final Multiplicity multiplicity) {
        this(id, EMPTY_TAGGED_VALUES, name, multiplicity);
    }
    
    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
    
    @Override
    public Multiplicity getMultiplicity() {
        return multiplicity;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id: " + getId()).append(", ");
        sb.append("name: " + getName()).append(", ");
        sb.append("multiplicity: " + multiplicity);
        if (!getTaggedValues().isEmpty()) {
            sb.append(", ");
            sb.append("taggedValues: " + getTaggedValues());
        }
        sb.append("}");
        return sb.toString();
    }
}
