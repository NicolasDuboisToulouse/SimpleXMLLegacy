package extra.javax.xml.stream;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

import extra.javax.xml.stream.events.*;

import java.util.Iterator;
/**
 * This interface defines a utility class for creating instances of
 * XMLEvents
 * @version 1.0
 * @author Copyright (c) 2003 by BEA Systems. All Rights Reserved.
 * @see extra.javax.xml.stream.events.StartElement
 * @see extra.javax.xml.stream.events.EndElement
 * @see extra.javax.xml.stream.events.ProcessingInstruction
 * @see extra.javax.xml.stream.events.Comment
 * @see extra.javax.xml.stream.events.Characters
 * @see extra.javax.xml.stream.events.StartDocument
 * @see extra.javax.xml.stream.events.EndDocument
 * @see extra.javax.xml.stream.events.DTD
 */
public abstract class XMLEventFactory {
  protected XMLEventFactory(){}

  /**
   * Create a new instance of the factory 
   * @throws FactoryConfigurationError if an instance of this factory cannot be loaded
   */
  public static XMLEventFactory newInstance() 
    throws FactoryConfigurationError
  {
    return (XMLEventFactory) FactoryFinder.find(
      "javax.xml.stream.XMLEventFactory",
      "com.bea.xml.stream.EventFactory");
  }

  /**
   * Create a new instance of the factory 
   *
   * @param factoryId             Name of the factory to find, same as
   *                              a property name
   * @param classLoader           classLoader to use
   * @return the factory implementation
   * @throws FactoryConfigurationError if an instance of this factory cannot be loaded
   */
  public static XMLEventFactory newInstance(String factoryId,
                                            ClassLoader classLoader)
    throws FactoryConfigurationError
  {
    return (XMLEventFactory) FactoryFinder.find(
      factoryId,
      "com.bea.xml.stream.EventFactory",
      classLoader);
  }

 /**
   * This method allows setting of the Location on each event that
   * is created by this factory.  The values are copied by value into
   * the events created by this factory.  To reset the location 
   * information set the location to null.
   * @param location the location to set on each event created
   */
  public abstract void setLocation(Location location);

  /**
   * Create a new Attribute
   * @param prefix the prefix of this attribute, may not be null
   * @param namespaceURI the attribute value is set to this value, may not be null
   * @param localName the local name of the XML name of the attribute, localName cannot be null
   * @param value the attribute value to set, may not be null
   * @return the Attribute with specified values
   */
  public abstract Attribute createAttribute(String prefix, String namespaceURI, String localName, String value);

  /**
   * Create a new Attribute
   * @param localName the local name of the XML name of the attribute, localName cannot be null
   * @param value the attribute value to set, may not be null
   * @return the Attribute with specified values
   */
  public abstract Attribute createAttribute(String localName, String value);

  /**
   * Create a new Attribute
   * @param name the qualified name of the attribute, may not be null
   * @param value the attribute value to set, may not be null
   * @return the Attribute with specified values
   */
  public abstract Attribute createAttribute(QName name, String value);

  /**
   * Create a new default Namespace
   * @param namespaceURI the default namespace uri
   * @return the Namespace with the specified value
   */
  public abstract Namespace createNamespace(String namespaceURI);

  /**
   * Create a new Namespace
   * @param prefix the prefix of this namespace, may not be null
   * @param namespaceUri the attribute value is set to this value, may not be null
   * @return the Namespace with the specified values
   */
  public abstract Namespace createNamespace(String prefix, String namespaceUri);

  /**
   * Create a new StartElement.  Namespaces can be added to this StartElement
   * by passing in an Iterator that walks over a set of Namespace interfaces.
   * Attributes can be added to this StartElement by passing an iterator 
   * that walks over a set of Attribute interfaces.
   *
   * @param name the qualified name of the attribute, may not be null
   * @param attributes an optional unordered set of objects that 
   * implement Attribute to add to the new StartElement, may be null
   * @param namespaces an optional unordered set of objects that 
   * implement Namespace to add to the new StartElement, may be null
   * @return an instance of the requested StartElement
   */
  public abstract StartElement createStartElement(QName name,
                                                  Iterator attributes,
                                                  Iterator namespaces);

  /**
   * Create a new StartElement.  This defaults the NamespaceContext to
   * an empty NamespaceContext.  Querying this event for its namespaces or
   * attributes will result in an empty iterator being returned.
   *
   * @param namespaceUri the uri of the QName of the new StartElement
   * @param localName the local name of the QName of the new StartElement
   * @param prefix the prefix of the QName of the new StartElement
   * @return an instance of the requested StartElement
   */
  public abstract StartElement createStartElement(String prefix,
                                                  String namespaceUri,
                                                  String localName);
  /**
   * Create a new StartElement.  Namespaces can be added to this StartElement
   * by passing in an Iterator that walks over a set of Namespace interfaces.
   * Attributes can be added to this StartElement by passing an iterator 
   * that walks over a set of Attribute interfaces.
   *
   * @param namespaceUri the uri of the QName of the new StartElement
   * @param localName the local name of the QName of the new StartElement
   * @param prefix the prefix of the QName of the new StartElement
   * @param attributes an unordered set of objects that implement 
   * Attribute to add to the new StartElement
   * @param namespaces an unordered set of objects that implement 
   * Namespace to add to the new StartElement
   * @return an instance of the requested StartElement
   */
  public abstract StartElement createStartElement(String prefix,
                                                  String namespaceUri,
                                                  String localName,
                                                  Iterator attributes,
                                                  Iterator namespaces
                                                  );
  /**
   * Create a new StartElement.  Namespaces can be added to this StartElement
   * by passing in an Iterator that walks over a set of Namespace interfaces.
   * Attributes can be added to this StartElement by passing an iterator 
   * that walks over a set of Attribute interfaces.
   *
   * @param namespaceUri the uri of the QName of the new StartElement
   * @param localName the local name of the QName of the new StartElement
   * @param prefix the prefix of the QName of the new StartElement
   * @param attributes an unordered set of objects that implement 
   * Attribute to add to the new StartElement, may be null
   * @param namespaces an unordered set of objects that implement 
   * Namespace to add to the new StartElement, may be null
   * @param context the namespace context of this element
   * @return an instance of the requested StartElement
   */
  public abstract StartElement createStartElement(String prefix,
                                                  String namespaceUri,
                                                  String localName,
                                                  Iterator attributes,
                                                  Iterator namespaces,
                                                  NamespaceContext context
                                                  );

  /**
   * Create a new EndElement
   * @param name the qualified name of the EndElement
   * @param namespaces an optional unordered set of objects that 
   * implement Namespace that have gone out of scope, may be null
   * @return an instance of the requested EndElement
   */
  public abstract EndElement createEndElement(QName name, 
                                              Iterator namespaces);

  /**
   * Create a new EndElement
   * @param namespaceUri the uri of the QName of the new StartElement
   * @param localName the local name of the QName of the new StartElement
   * @param prefix the prefix of the QName of the new StartElement
   * @return an instance of the requested EndElement
   */
  public abstract EndElement createEndElement(String prefix, 
                                              String namespaceUri,
                                              String localName);
  /**
   * Create a new EndElement
   * @param namespaceUri the uri of the QName of the new StartElement
   * @param localName the local name of the QName of the new StartElement
   * @param prefix the prefix of the QName of the new StartElement
   * @param namespaces an unordered set of objects that implement 
   * Namespace that have gone out of scope, may be null
   * @return an instance of the requested EndElement
   */
  public abstract EndElement createEndElement(String prefix, 
                                              String namespaceUri,
                                              String localName,
                                              Iterator namespaces);

  /**
   * Create a Characters event, this method does not check if the content
   * is all whitespace.  To create a space event use #createSpace(String)
   * @param content the string to create
   * @return a Characters event
   */
  public abstract Characters createCharacters(String content);

  /**
   * Create a Characters event with the CData flag set to true
   * @param content the string to create
   * @return a Characters event
   */
  public abstract Characters createCData(String content);

  /**
   * Create a Characters event with the isSpace flag set to true
   * @param content the content of the space to create
   * @return a Characters event
   */
  public abstract Characters createSpace(String content);
  /**
   * Create an ignorable space
   * @param content the space to create
   * @return a Characters event
   */
  public abstract Characters createIgnorableSpace(String content);

  /** 
   * Creates a new instance of a StartDocument event
   * @return a StartDocument event
   */
  public abstract StartDocument createStartDocument();

  /** 
   * Creates a new instance of a StartDocument event
   *
   * @param encoding the encoding style
   * @param version the XML version
   * @param standalone the status of standalone may be set to "true" or "false"
   * @return a StartDocument event
   */
  public abstract StartDocument createStartDocument(String encoding,
                                                  String version,
                                                  boolean standalone);

  /** 
   * Creates a new instance of a StartDocument event
   *
   * @param encoding the encoding style
   * @param version the XML version
   * @return a StartDocument event
   */
  public abstract StartDocument createStartDocument(String encoding,
                                                  String version);

  /** 
   * Creates a new instance of a StartDocument event
   *
   * @param encoding the encoding style
   * @return a StartDocument event
   */
  public abstract StartDocument createStartDocument(String encoding);

  /**
   * Creates a new instance of an EndDocument event
   * @return an EndDocument event
   */
  public abstract EndDocument createEndDocument();

  /** Creates a new instance of a EntityReference event
   *
   * @param name The name of the reference
   * @param declaration the declaration for the event
   * @return an EntityReference event
   */
  public abstract EntityReference createEntityReference(String name,
                                                        EntityDeclaration declaration);
  /**
   * Create a comment
   * @param text The text of the comment
   * a Comment event
   */
  public abstract Comment createComment(String text);

  /**
   * Create a processing instruction
   * @param target The target of the processing instruction
   * @param data The text of the processing instruction
   * @return a ProcessingInstruction event
   */
  public abstract ProcessingInstruction createProcessingInstruction(String target,
                                                                   String data);

  /**
   * Create a document type definition event
   * This string contains the entire document type declaration that matches
   * the doctypedecl in the XML 1.0 specification
   * @param dtd the text of the document type definition
   * @return a DTD event
   */
  public abstract DTD createDTD(String dtd);
}




