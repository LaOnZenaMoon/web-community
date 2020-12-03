package me.lozm.docs;

import org.springframework.restdocs.snippet.Attributes;

import static org.springframework.restdocs.snippet.Attributes.key;

public interface DocumentFormatGenerator {

    static Attributes.Attribute getDateFormat() {
        return key("format").value("yyyy-MM-dd");
    }

    static Attributes.Attribute getDateTimeFormat() {
        return key("format").value("yyyy-MM-dd'T'HH:mm:ss");
    }

    static Attributes.Attribute getYnFormat() {
        return key("format").value("사용: Y, 미사용: N");
    }

    static Attributes.Attribute getDuplicationCheckFormat() {
        return key("format").value("한 주: ONE_WEEK, 한 달: ONE_MONTH");
    }

    static Attributes.Attribute getCustomerGender() {
        return key("format").value("남성: MAN, 여성: WOMAN");
    }

}