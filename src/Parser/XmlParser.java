package Parser;

import Entity.CastObce;
import Entity.Obec;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * XMl Parser StAX.
 */
public  class XmlParser {

    /**
     * @return CastObce set pro ukladani do database
     */
   public Set<CastObce> getSetCastObce(){
    Set<Obec> set = obceParse("CastObce","vf","coi");
    Set<CastObce> castObceSet = new LinkedHashSet<>();
        for (Obec e:
            set ) {
            castObceSet.add(new CastObce(e.getKod(),e.getNazev()));
        }
    return castObceSet;
    }

    /**
     * @return Obec Set
     */
    public Set<Obec> getSetObce(){
    return obceParse("Obec","vf","obi");
    }


    private Set<Obec> obceParse(String start, String prefixStart, String prefixCharacter) {
        boolean kodObce = false;
        boolean nazevObce = false;
        Set<Obec> obceRet = new LinkedHashSet<>();
        Obec o = new Obec();
        String name="";
        int kod=0;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("20200930_OB_573060_UZSZ.xml"));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(start)
                                && startElement.getName().getPrefix().equalsIgnoreCase(prefixStart)
                        ) {
                            Iterator<Attribute> attributes = startElement.getAttributes();

                        } else if (qName.equalsIgnoreCase("Kod") &&
                                startElement.getName().getPrefix().equalsIgnoreCase(prefixCharacter)) {
                            kodObce = true;
                        } else if (qName.equalsIgnoreCase("Nazev") &&
                                startElement.getName().getPrefix().equalsIgnoreCase(prefixCharacter)) {
                            nazevObce = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (kodObce) {

                            kod = Integer.parseInt(characters.getData());
                            kodObce = false;
                        }
                        if (nazevObce) {
                            name = characters.getData();
                            nazevObce = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase(start)
                                && endElement.getName().getPrefix().equalsIgnoreCase(prefixStart)
                        ) {
                            obceRet.add(new Obec(kod,name));
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return obceRet;
    }



}
