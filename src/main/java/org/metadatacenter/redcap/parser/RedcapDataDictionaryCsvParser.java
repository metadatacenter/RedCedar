package org.metadatacenter.redcap.parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.metadatacenter.redcap.csv.RedcapDataDictionaryCsv;
import org.metadatacenter.redcap.csv.RedcapDataDictionaryCsvRecord;

import java.io.IOException;
import java.io.InputStream;

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
        MappingIterator<RedcapDataDictionaryCsvRecord> it = mapper
                .readerFor(RedcapDataDictionaryCsvRecord.class)
                .with(headerSchema)
                .readValues(in);
        var records = it.readAll();
        return new RedcapDataDictionaryCsv(records);
    }
}
