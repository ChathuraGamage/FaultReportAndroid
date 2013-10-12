package com.faultreport.web;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class ServiceClient {

	private static final String NAMESPACE = "http://service.faultreport.com";
	private static String URL = "http://192.168.179.1:8080/ReporterService/services/ReportingService";
	private static final String METHOD_NAME = "report";
	private static final String SOAP_ACTION = "http://service.faultreport.com/report";
	private static final int REQUEST_TIMEOUT = 15000;

	public boolean sendReport(String content) throws IOException, XmlPullParserException {
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		PropertyInfo propInfo = new PropertyInfo();
		propInfo.name = "arg0";
		propInfo.type = PropertyInfo.STRING_CLASS;
		propInfo.setValue(content);
		request.addProperty(propInfo);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL, REQUEST_TIMEOUT);
		
		androidHttpTransport.call(SOAP_ACTION, envelope);

		SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
				.getResponse();

		return Boolean.valueOf(resultsRequestSOAP.toString());
	}
}