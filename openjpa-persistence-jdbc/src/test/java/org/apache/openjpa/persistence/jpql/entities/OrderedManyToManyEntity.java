/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.jpql.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

@Entity
public class OrderedManyToManyEntity implements IOrderedEntity, java.io.Serializable {

    
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @ManyToMany
    @OrderColumn
    private List<INameEntity> entities;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public List<INameEntity> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<INameEntity> entities) {
        this.entities = entities;
    }

    @Override
    public void addEntity(INameEntity entity) {
        if( entities == null) {
            entities = new ArrayList<>();
        }
        entities.add(entity);
    }

    @Override
    public INameEntity removeEntity(int location) {
        INameEntity rtnVal = null;
        if( entities != null) {
            rtnVal = entities.remove(location);
        }
        return rtnVal;
    }

    @Override
    public void insertEntity(int location, INameEntity entity) {
        if( entities == null) {
            entities = new ArrayList<>();
        }
        entities.add(location, entity);
    }

    @Override
    public String toString() {
        return "OrderedManyToManyEntity[" + id + "]=" + entities;
    }
}
