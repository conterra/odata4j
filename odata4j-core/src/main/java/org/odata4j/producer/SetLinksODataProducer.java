/*
 * Copyright 2016 mre.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.odata4j.producer;

import java.util.List;
import org.odata4j.core.OEntityId;

/**
 * Interface to mark an ODataProducer as able to handle a list of links.
 */
public interface SetLinksODataProducer {
    /**
   * Sets the link on source entity.
   *
   * @param sourceEntity  an entity with at least one navigation property
   * @param targetNavProp  the navigation property
   * @param targetEntities  the link target entities     
   */
  void createLinks(OEntityId sourceEntity, String targetNavProp, List<OEntityId> targetEntities);
}
