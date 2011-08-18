package com.android.test;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import android.util.Log;

public final class InputItemDetail {
    public static java.lang.String  getItemName(java.lang.String name) {
        try {
    	SoapObject _client = new SoapObject("http://project.com", "getItemName");
        _client.addProperty("name", name);
        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;
        AndroidHttpTransport _ht = new AndroidHttpTransport(Configuration.getWsUrl());
        _ht.call("", _envelope);
        SoapPrimitive resp = (SoapPrimitive)_envelope.getResponse();
        return resp.toString();
    } catch(Exception e) {
    	e.printStackTrace();
    	return null;
    }
 }
 

}
