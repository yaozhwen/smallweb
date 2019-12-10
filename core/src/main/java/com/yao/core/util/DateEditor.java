package com.yao.core.util;

import com.yao.core.common.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by yaozwsq on 2019/12/5.
 */
public class DateEditor extends PropertyEditorSupport{
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private boolean emptyAsNull;

    private String dateFormat = DEFAULT_DATE_FORMAT;

    public DateEditor(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
    }

    public DateEditor(boolean emptyAsNull, String dateFormat) {
        this.emptyAsNull = emptyAsNull;
        this.dateFormat = dateFormat;
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return value != null ? DateFormatUtils.format(value, dateFormat) : StringUtils.EMPTY;
    }

    @Override
    public void setAsText(String text) {
        if (text != null) {
            String value = text.trim();
            if (emptyAsNull && StringUtils.isEmpty(text)) {
                setValue(null);
            } else {
                try {
                    setValue(DateUtils.parseDate(value, Constants.DATE_PATTERNS));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        } else {
            setValue(null);
        }
    }
}
