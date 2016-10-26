/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testserv_26oct.services.currencyconvertor;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2016-10-26T04:34:55.219Z
 * Generated source version: 2.7.11
 * 
 */
public final class CurrencyConvertorSoap_CurrencyConvertorSoap_Client {

    private static final QName SERVICE_NAME = new QName("http://www.webserviceX.NET/", "CurrencyConvertor");

    private CurrencyConvertorSoap_CurrencyConvertorSoap_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CurrencyConvertor.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CurrencyConvertor ss = new CurrencyConvertor(wsdlURL, SERVICE_NAME);
        CurrencyConvertorSoap port = ss.getCurrencyConvertorSoap();  
        
        {
        System.out.println("Invoking conversionRate...");
        com.testserv_26oct.services.currencyconvertor.ConversionRate _conversionRate_parameters = null;
        com.testserv_26oct.services.currencyconvertor.ConversionRateResponse _conversionRate__return = port.conversionRate(_conversionRate_parameters);
        System.out.println("conversionRate.result=" + _conversionRate__return);


        }

        System.exit(0);
    }

}
