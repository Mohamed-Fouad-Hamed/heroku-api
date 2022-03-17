package alf.api.archives;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class DataDocXml implements IDataXml {

	private DataXml data = null;
	private String dataPath = null;

	public DataDocXml(String dataPath) {
		super();
		this.dataPath = dataPath;
	}

	public void setData(DataXml data) {
		this.data = data;
	}

	@Override
	public void Write() {
		try {

			File file = new File(dataPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(DataXml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(data, file);
			jaxbMarshaller.marshal(data, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	@Override
	public DataXml Read() {
		try {

			File file = new File(dataPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(DataXml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			data = (DataXml) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return data;
	}

}
