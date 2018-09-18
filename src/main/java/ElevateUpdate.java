import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "elevate")
public class ElevateUpdate {

    @XmlAttribute
    public String rebuild;

    @XmlAttribute
    public String region;

    @XmlElement(name = "query")
    public Query query;

}

class Query {
    @XmlAttribute
    public String text;

    @XmlElements(@XmlElement())
    public Doc[] doc;
}
class Doc {
    public String id;
}
