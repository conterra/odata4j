package org.odata4j.producer.resources;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Providers;

import org.odata4j.producer.ODataProducer;

final class ODataProducerLookup {

    /**
     * Not all the jax-rs engines can not directly inject ContextResolvers (not
     * defined by JSR-311) classes into resources, however they support Context
     * injection, from which ContextResolvers can be queried
     */
    static ODataProducer getODataProducer(Providers providers) {
        ContextResolver<ODataProducer> producerResolver = providers.getContextResolver(ODataProducer.class, MediaType.WILDCARD_TYPE);
        return producerResolver.getContext(ODataProducer.class);
    }
}
