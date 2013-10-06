package com.faultreport.web;

import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.webkit.WebView.FindListener;
import android.widget.TextView;

public class ServiceClient {
	//192.168.56.1
	 private static final String NAMESPACE = "http://service.ibm.com";
	 private static String URL = "http://192.168.179.1:8080/ReporterService/services/ReportingService"; 
	 private static final String METHOD_NAME = "report";
	 private static final String SOAP_ACTION =  "http://service.ibm.com/report";
	 
	 
	public boolean sendReport(String content) {
		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			PropertyInfo propInfo = new PropertyInfo();
			propInfo.name = "arg0";
			propInfo.type = PropertyInfo.STRING_CLASS;
			request.addProperty(propInfo, content);

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

			androidHttpTransport.call(SOAP_ACTION, envelope);

			SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope
					.getResponse();

			return Boolean.valueOf(resultsRequestSOAP.toString());
		}catch (Exception e) {
			return false;
		}				
	}
}