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

    Alpha_Num_ID("alpha_id"), //(), // (ABC123)
    AlphaNum_with_Optional_Dash("alpha-dash"), // (AB1-2)
    AMEL_Record_ID("amel_id"),
    Custom_ID("custom_id"), // (STAN-P001)
    Dash_Id("dash-id"), // (12-456) numbers only
    Date_DMY("date_dmy"), // (D-M-Y)
    Date_MDY("date_mdy"), // (M-D-Y)
    Date_MY("date_my"), // (M-Y)
    Date_YMD("date_ymd"), // (Y-M-D)
    Date_YM("date_ym"), // (Y-M)
    Datetime_DMY_HM("datetime_dmy"), // (D-M-Y H:M)
    Datetime_MDY_HM("datetime_mdy"), // (M-D-Y H:M)
    Datetime_YMD_HM("datetime_ymd"), // (Y-M-D H:M)
    Datetime_Seconds_DMY("datetime_seconds_dmy"), // (D-M-Y H:M:S)
    Datetime_Seconds_MDY("datetime_seconds_mdy"), // (M-D-Y H:M:S)
    Datetime_Seconds_YMD("datetime_seconds_ymd"), // (Y-M-D H:M:S)
    DirectNet_ID("directnet_id"),
    Email("email"),
    Integer("integer"),
    IP_Address("ip_address"), // (xxx.xxX.xxX.xxx)
    Lab_Value("lab_value"),
    Letters_only("alpha_only"),
    MAC_Address("mac_address"), // (xx:xx:XX:XX:XX:XX)
    MAC_Addresses("mac_address_list"), // (csV)
    MAPX_ID("mapx_id"), // (MIMCXX-X)
    MRN("mrn_78d"), // (7-8 digits)
    MTAX_Study_ID("mtax_id"), // (SS_Tyy_zzz)
    Number("number"),
    Number_1DP("number_1dp"), // (1 decimal place)
    Number_2DP("number_2dp"), // (2 decimal places)
    Number_3DP("number_3dp"), // (3 decimal places)
    Number_4DP("number_4dp"), // (4 decimal places)
    Phone("phone"), // (North America)
    REDCap_API_Token("api_token"), // (32char)
    SUNet_ID("sunet_id"),
    Time_HH_MM_SS("time_hh_mm_ss"), // (HH:MM:SS)
    Time_HH_MM("time"), // (HH:MM)
    Time_HHMM("time_shorthand"), // (HHMM)
    TPC_Record_ID("tpc_id"),
    TPF_Record_ID("tpf_id"),
    Zipcode("zipcode"); // (U.S.)


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
