/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.compat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Uni_1To1_JT {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne
    @JoinTable(
        name="Uni11JT_C",
        joinColumns=
          @JoinColumn(name="U_ID", referencedColumnName="ID"),
        inverseJoinColumns=
          @JoinColumn(name="C_ID", referencedColumnName="ID")
    )
    private EntityC_U11JT entityC;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityC_U11JT getEntityC() {
        return entityC;
    }

    public void setEntityC(EntityC_U11JT entityC) {
        this.entityC = entityC;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + (int)id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Uni_1To1_JT)) return false;
        Uni_1To1_JT u = (Uni_1To1_JT)o;
        if (!u.name.equals(name)) return false;
        if (u.id != id) return false;
        if (u.entityC == null && entityC == null) return true;
        if (u.entityC.getId() != entityC.getId()) return false;
        return true;
    }
}
