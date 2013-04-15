package org.inmeta.tasksystem.integrations;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 16.02.13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public class GuleSiderProvider extends Provider {

    @Override
    public List<Person> doLookup(final String query) {
        List<Person> list = new ArrayList<Person>();
        try {
            Document doc;
            doc = Jsoup.parse(new URL("http://www.gulesider.no/person/resultat/" + query.replace(' ', '+')), 5000);

            final Elements resultDiv = doc.select(".vcard");
            if (null != resultDiv && CollectionUtils.isNotEmpty(resultDiv)) {
                for (int i = 0; i < resultDiv.size(); i++) {
                    final Element row = resultDiv.get(i);
                    Person person = new Person();
                    final String given = safeSelect(row, ".given-name");
                    final String family = safeSelect(row, ".family-name");
                    final String street = safeSelect(row, ".street-address");
                    final String postalCode = safeSelect(row, ".postal-code");
                    final String postalArea = safeSelect(row, ".locality");

                    System.out.println("Looked up " + query + " at Gule Sider.");
                    person.realFistName = given;
                    person.realLastName = family;
                    person.street = street;
                    person.zipCode = postalCode;
                    person.area = postalArea;

                    list.add(person);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public final static void main(String[] args) {
        GuleSiderProvider p = new GuleSiderProvider();
        final List<Person> vaagan = p.lookup("vaagan");


        System.out.println("Result: " + vaagan.size());
    }
}
