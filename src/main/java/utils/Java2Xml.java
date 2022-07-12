package utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.logging.Logger;

public class Java2Xml {
    private static final Logger logger = Logger.getLogger(Java2Xml.class.getName());

    public static void marshallingObject(File file, Object o) {

        try {
            logger.info("Xml marshalling started");
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(o, file);
        } catch (JAXBException e) {
            logger.severe("Xml marshalling failed" + e);
        }
    }
}
