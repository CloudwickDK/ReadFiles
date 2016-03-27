package readXml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXml {
	
	List <Employee> employees;

	public List<Employee> read(File inputFile) {

		Document doc = null;
		employees = new ArrayList<Employee>();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList list = doc.getElementsByTagName("Employee");// the xml file
																// consists
																// of
																// Employee'
																// info

		for (int num_of_element = 0; num_of_element < list.getLength(); num_of_element++) {
			Node nNode = list.item(num_of_element);
			// if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			long ID = Long.parseLong(eElement.getAttribute("ID"), 10);
			System.out.println(ID);
			String FirstName = eElement.getElementsByTagName("Firstname").item(0).getTextContent();
			String LastName = eElement.getElementsByTagName("Lastname").item(0).getTextContent();
			int age = Integer.parseInt(eElement.getElementsByTagName("Age").item(0).getTextContent());
			int salary = Integer.parseInt(eElement.getElementsByTagName("Salary").item(0).getTextContent());
			Employee current_employee = new Employee(ID, FirstName, LastName, age, salary);
			employees.add(current_employee);
			System.out.println("curent_employee: " + current_employee);
			// }
		}
		return employees;

	}

	public Document create_elements(Document doc) {

		// root element
		Element rootElement = doc.createElement("Employees");
		doc.appendChild(rootElement);
		
		for (Employee employee : employees){
			// Employee element
			Element employee_element = doc.createElement("Employee");
			rootElement.appendChild(employee_element);
			
			// setting attribute to element
			Attr attr = doc.createAttribute("ID");
			attr.setValue(String.valueOf(employee.getID()));
			employee_element.setAttributeNode(attr);
			// carname element
			Element FirstName = doc.createElement("Firstname");
			// Attr attrType = doc.createAttribute("type");
			// attrType.setValue("formula one");
			// FirstName.setAttributeNode(attrType);
			FirstName.appendChild(doc.createTextNode(employee.getLastName()));
			employee_element.appendChild(FirstName);
			
			Element LastName = doc.createElement("Lastname");
			LastName.appendChild(doc.createTextNode(employee.getLastName()));
			employee_element.appendChild(LastName);
			
			Element age = doc.createElement("Age");
			age.appendChild(doc.createTextNode(String.valueOf(employee.getAge())));
			employee_element.appendChild(age);
			
			Element salary = doc.createElement("Slary");
			salary.appendChild(doc.createTextNode(employee.getLastName()));
			employee_element.appendChild(salary);
		}

		return doc;
	}

	public int write(String FileName) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// call creare_elements to initialise xml elements
			doc = create_elements(doc);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(FileName));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
