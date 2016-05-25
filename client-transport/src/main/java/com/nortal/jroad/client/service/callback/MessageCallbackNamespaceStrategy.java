package com.nortal.jroad.client.service.callback;

import java.util.Random;
import java.util.UUID;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public abstract class MessageCallbackNamespaceStrategy {

  private Random random = new Random(System.currentTimeMillis());

  /**
   * Unique identifier for service invocation, consisting of numbers and letters of the Latin alphabet. The identifier
   * is generated by service invoker, who must guarantee that the identifier is globally unique.
   */
  protected String generateUniqueMessageId(XRoadServiceConfiguration serviceConfiguration) {
    return UUID.randomUUID().toString(); // Long.toHexString(System.currentTimeMillis()) +
                                         // serviceConfiguration.getInstitution() + random.nextInt();
  }

  public abstract void addNamespaces(SOAPEnvelope env) throws SOAPException;

  public abstract void addXTeeHeaderElements(SOAPEnvelope env, XRoadServiceConfiguration serviceConfiguration)
      throws SOAPException;

}
