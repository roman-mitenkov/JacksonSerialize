import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import dto.Elevate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.List;

public class MarshalJackson {
    public static void main(String[] args) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(Elevate.class.getPackage().getName());
            final Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            marshaller.marshal(getElevate(), System.out);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        JaxbAnnotationModule module = new JaxbAnnotationModule();

        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(module);
        Elevate elevateUpdate = getElevate();

        try {
            String xml = mapper.writeValueAsString(elevateUpdate);
            System.out.println("xml = " + xml);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static ElevateUpdate getElevateUpdate() {
        ElevateUpdate elevateUpdate = new ElevateUpdate();
        elevateUpdate.rebuild = "true";
        elevateUpdate.region = "OOUS";
        elevateUpdate.query = new Query();
        elevateUpdate.query.text = "cat";
        final Doc doc1 = new Doc();
        doc1.id = "id1";
        final Doc doc2 = new Doc();
        doc2.id = "id2";
        elevateUpdate.query.doc = new Doc[]{doc1, doc2};
        return elevateUpdate;
    }

    private static Elevate getElevate() {
        Elevate el = new Elevate();
        el.setRegion("OOUS");
        el.setRebuild("true");
        final List<Elevate.Query> query = el.getQuery();
        final Elevate.Query query1 = new Elevate.Query();
        query1.setText("cat");
        final List<Elevate.Query.Doc> doc = query1.getDoc();
        final Elevate.Query.Doc doc1 = new Elevate.Query.Doc();
        doc1.setId("id1");
        final Elevate.Query.Doc doc2 = new Elevate.Query.Doc();
        doc2.setId("id2");
        doc.add(doc1);
        doc.add(doc2);
        query.add(query1);

        return el;
    }
}
