package nl.hsleiden.persistence;

import nl.hsleiden.model.Bedrijf;
import nl.hsleiden.model.Contact;
import nl.hsleiden.model.Plaats;

import javax.inject.Singleton;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ContactDAO {
    private Database database = new Database();
    private List<Contact> contactPersonen;
    private Contact contact;
    private Plaats adress;

    public ContactDAO() {
//        loadInitialValues();
//        Plaats adress = new Plaats("straat", "postcode", "Woon", "land");
//        Contact contact = new Contact(0, "voornaam", "achter",
//                "Comp", adress, "relatiedd", "web");
//        contactPersonen.add(contact);
    }

    public List<Contact> getAll() {
//        return contactPersonen;
        ResultSet resultSet = null;
        contactPersonen = new ArrayList<>();
//        contactPersonen = contactenModel.getContacts();
//
        int i = 0; //Index variable for contacts.get()

        try {
            database.connectFromConfig();
            resultSet = database.query("SELECT * FROM contactpersoon ORDER BY contact_id ASC;");

            while (resultSet.next()) {

//                contact = contactPersonen.get(i);
//                adress = contact.getPlaats();

                contact = new Contact();
                adress = new Plaats();

                contact.setContactId(resultSet.getInt(1));
                contact.setAchternaam(resultSet.getString(2));
                contact.setVoornaam(resultSet.getString(3));
                contact.setCompany(resultSet.getString(4));

                adress.setStreetName(resultSet.getString(5));
                adress.setPostCode(resultSet.getString(6));
                adress.setWoonPlaats(resultSet.getString(7));
                adress.setCountry(resultSet.getString(8));

                contact.setPlaats(adress);

                contact.setRelatie(resultSet.getString(9));
                contact.setWebsite(resultSet.getString(10));

//                contactPersonen.set(i, contact);
                contactPersonen.add(contact);
                i++;


            }

            return contactPersonen;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return null;
    }

    public List getBedrijven() {
        ResultSet resultSet = null;
        int i = 0; //Index variable for contacts.get()
        List bedrijven = new ArrayList();

        try {
            database.connectFromConfig();
            resultSet = database.query("SELECT contact_id, contact_bedrijf FROM contactpersoon;");

            while (resultSet.next()) {

                Bedrijf bedrijf = new Bedrijf();

                bedrijf.setId(resultSet.getInt(1));
                bedrijf.setNaam(resultSet.getString(2));

                bedrijven.add(bedrijf);
                i++;
            }
            return bedrijven;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return null;

    }

    public Contact get(int id){
        ResultSet resultSet = null;
        Contact contactPersoon = new Contact();

        try {
            database.connectFromConfig();
            resultSet = database.query(String.format("SELECT * FROM contactpersoon WHERE contact_id = %d;", id));

            while (resultSet.next()) {
                Integer contactId = resultSet.getInt(1);
                String achternaam = resultSet.getString(2);
                String voornaam = resultSet.getString(3);
                String company = resultSet.getString(4);
                String streetName = resultSet.getString(5);
                String postCode = resultSet.getString(6);
                String woonPlaats = resultSet.getString(7);
                String country = resultSet.getString(8);
                String relatie = resultSet.getString(9);
                String website = resultSet.getString(10);

                Plaats plaats = new Plaats(streetName, postCode, woonPlaats, country);
                contactPersoon = new Contact(contactId, voornaam, achternaam, company, plaats, relatie, website);
//                contactPersonen.add(contactPersoon);
            }
        return contactPersoon;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return null;
    }

    public void update(Contact persoon) {
        try {
            database.connectFromConfig();
            String s = String.format("UPDATE contactpersoon " +
                            "SET contact_achternaam = '%s', contact_voornaam = '%s', contact_bedrijf = '%s', contact_straatnaam = '%s', " +
                            "contact_postcode = '%s', contact_plaats = '%s', contact_land = '%s', contact_relatie = '%s', contact_website = '%s' " +
                            "WHERE contact_id = %d;",
                    persoon.getAchternaam(), persoon.getVoornaam(), persoon.getCompany(),
                    persoon.getPlaats().getStreetName(), persoon.getPlaats().getPostCode(),
                    persoon.getPlaats().getWoonPlaats(), persoon.getPlaats().getCountry(),
                    persoon.getRelatie(), persoon.getWebsite(), persoon.getContactId());
            database.query(s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            database.disconnect();
        }
    }


    public void delete(int id) {
        try {
            database.connectFromConfig();
            String s = String.format("DELETE FROM contactpersoon WHERE contact_id = %d;", id);
            database.query(s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            database.disconnect();
        }
    }

    public void insert(Contact persoon) {
        try {
            database.connectFromConfig();
            String s = String.format("INSERT INTO contactpersoon " +
                            "VALUES (DEFAULT, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                    persoon.getAchternaam(), persoon.getVoornaam(),
                    persoon.getCompany(), persoon.getPlaats().getStreetName(),
                    persoon.getPlaats().getPostCode(), persoon.getPlaats().getWoonPlaats(),
                    persoon.getPlaats().getCountry(), persoon.getRelatie(), persoon.getWebsite());
            database.query(s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            database.disconnect();
        }
    }

}
