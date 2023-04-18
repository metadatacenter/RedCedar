package org.metadatacenter.redcap.api;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-14
 */
public enum TextValidationPattern {

    alpha_id("alpha_id"), //(), // (ABC123)
    alpha_dash("alpha-dash"), // (AB1-2)
    amel_id("amel_id"),
    custom_id("custom_id"), // (STAN-P001)
    dash_id("dash-id"), // (12-456) numbers only
    date_dmy("date_dmy"), // (D-M-Y)
    date_mdy("date_mdy"), // (M-D-Y)
    date_my("date_my"), // (M-Y)
    date_ymd("date_ymd"), // (Y-M-D)
    date_ym("date_ym"), // (Y-M)
    datetime_dmy("datetime_dmy"), // (D-M-Y H:M)
    datetime_mdy("datetime_mdy"), // (M-D-Y H:M)
    datetime_ymd("datetime_ymd"), // (Y-M-D H:M)
    datetime_seconds_dmy("datetime_seconds_dmy"), // (D-M-Y H:M:S)
    datetime_seconds_mdy("datetime_seconds_mdy"), // (M-D-Y H:M:S)
    datetime_seconds_ymd("datetime_seconds_ymd"), // (Y-M-D H:M:S)
    directnet_id("directnet_id"),
    email("email"),
    integer("integer"),
    ip_address("ip_address"), // (xxx.xxX.xxX.xxx)
    lab_value("lab_value"),
    alpha_only("alpha_only"),
    mac_address("mac_address"), // (xx:xx:XX:XX:XX:XX)
    mac_address_list("mac_address_list"), // (csV)
    mapx_id("mapx_id"), // (MIMCXX-X)
    mrn_78d("mrn_78d"), // (7-8 digits)
    mtax_id("mtax_id"), // (SS_Tyy_zzz)
    number("number"),
    number_1dp("number_1dp"), // (1 decimal place)
    number_2dp("number_2dp"), // (2 decimal places)
    number_3dp("number_3dp"), // (3 decimal places)
    number_4dp("number_4dp"), // (4 decimal places)
    phone("phone"), // (North America)
    api_token("api_token"), // (32char)
    sunet_id("sunet_id"),
    time_hh_mm_ss("time_hh_mm_ss"), // (HH:MM:SS)
    time("time"), // (HH:MM)
    time_shorthand("time_shorthand"), // (HHMM)
    tpc_id("tpc_id"),
    tpf_id("tpf_id"),
    zipcode("zipcode"); // (U.S.)


    private final String name;


    TextValidationPattern(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @JsonValue
    public String getName() {
        return name;
    }


    public static Optional<TextValidationPattern> getTextValidationPattern(String name) {
        return Arrays.stream(values())
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}
