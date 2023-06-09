package org.metadatacenter.redcap.csv;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 *
 * A REDCap data dictionary is simply a list of REDCap fields.
 */
public record RedcapDataDictionaryCsv(List<RedcapDataDictionaryCsvRecord> fields) {

}
