package io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import model.XmlStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void generateXmlReq(XmlStructure xmlStructure) {

        try {
            logger.info("XML marshalling started");

            JAXBContext jaxbContext = JAXBContext.newInstance(XmlStructure.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.info("Directory created successfully");
            } catch (IOException ioEx) {
                logger.fine("Directory already created");
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(xmlStructure, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.severe("XML marshalling failed");
            System.out.println(jaxbEx);
            return;
        }

        logger.info("XML marshalling finished successfully");
    }
}
