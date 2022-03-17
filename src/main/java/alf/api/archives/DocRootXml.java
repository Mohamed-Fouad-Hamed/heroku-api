package alf.api.archives;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;

public class DocRootXml implements IDocRootXml {

	final static Logger logger = Logger.getLogger(DocRootXml.class);

	private rootXml root = null;
	private String rootPath = null;

	public DocRootXml(String filePath) {
		rootPath = filePath;
	}

	public void setRoot(rootXml root) {
		this.root = root;
	}

	@Override
	public void Write() {
		try {

			File file = new File(rootPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(rootXml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(root, file);
			jaxbMarshaller.marshal(root, System.out);

		} catch (JAXBException e) {
			logger.error(" Write object to xml file : ", e);
		}

	}

	@Override
	public rootXml Read() {
		try {

			File file = new File(rootPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(rootXml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			root = (rootXml) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			logger.error(" Read object from xml file :  ", e);
		}
		return root;
	}
}
