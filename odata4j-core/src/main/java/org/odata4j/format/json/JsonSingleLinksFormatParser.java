package org.odata4j.format.json;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.odata4j.format.FormatParser;
import org.odata4j.format.Settings;
import org.odata4j.format.SingleLinks;
import org.odata4j.format.json.JsonStreamReaderFactory.JsonStreamReader;

public class JsonSingleLinksFormatParser extends JsonFormatParser implements FormatParser<SingleLinks> {

    public JsonSingleLinksFormatParser(Settings settings) {
        super(settings);
    }

    @Override
    public SingleLinks parse(Reader reader) {
        // {"uri": "http://host/service.svc/Orders(1)"}
        JsonStreamReader jsr = JsonStreamReaderFactory.createJsonStreamReader(reader);
        try {
            ensureStartArray(jsr.nextEvent());
            List<String> uris = new ArrayList<String>();
            for (JsonStreamReader.JsonEvent next = jsr.nextEvent(); !next.isEndArray(); next = jsr.nextEvent()) {
                ensureStartObject(next);
                ensureStartProperty(jsr.nextEvent(), "uri");
                String uri = jsr.nextEvent().asEndProperty().getValue();
                uris.add(uri);
                ensureEndObject(jsr.nextEvent());
            }
            return SingleLinks.create(uris);
        } finally {
            jsr.close();
        }
    }

}
