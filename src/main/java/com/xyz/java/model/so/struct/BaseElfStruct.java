package com.xyz.java.model.so.struct;

import com.xyz.java.model.util.Utils;

import java.io.UnsupportedEncodingException;

public abstract class BaseElfStruct {

    public abstract  int getLength();

    protected byte[] value;

    public BaseElfStruct() {
        value = new byte[this.getLength()];
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public int toIntValue() {
        byte[] value = getValue();
        if(value.length < 4) {
            byte[] newValue = new byte[4];
            int len = value.length;
            for(int i = 0 ; i < len ; i++) {
                newValue[i] = value[i];
            }
            return Utils.bytesToInt(newValue,0);
        }
        return Utils.bytesToInt(value,0);
    }

    public String toStringValue() {
        return new String(getValue());
    }

    public String toStringValue(String charset) {
        try {
            return new String(getValue(),charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
