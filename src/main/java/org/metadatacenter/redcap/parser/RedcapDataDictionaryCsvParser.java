package org.metadatacenter.redcap.parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.metadatacenter.redcap.api.RedcapDataDictionaryCsv;
import org.metadatacenter.redcap.api.RedcapFieldRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class RedcapDataDictionaryCsvParser {

    public RedcapDataDictionaryCsvParser() {

    }

    public RedcapDataDictionaryCsv parse(InputStream in) throws IOException {
        var headerSchema = CsvSchema.emptySchema().withHeader();
        var mapper = CsvMapper.builder()
                                    .build();
        MappingIterator<RedcapFieldRecord> it = mapper
                .readerFor(RedcapFieldRecord.class)
                .with(headerSchema)
                .readValues(in);
        var records = it.readAll();
        return new RedcapDataDictionaryCsv(records);
    }
}
