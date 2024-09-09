import java.net.InetAddress;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.NamingException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class DNSLookup {
        public static void main(String[] args) {
                Map<String, String> dnsRecord = new HashMap<>();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the name of the website: ");
                String website = scanner.nextLine();
                scanner.close();
                try {
                        InetAddress[] aRecords = InetAddress.getAllByName(website);
                        for (int i = 0; i < aRecords.length; i++) {
                                dnsRecord.put("A_Record_IP_" + (i + 1), aRecords[i].getHostAddress());
                        }
                } catch (UnknownHostException e) {
                        System.out.println("Error fetching A record: " + e.getMessage());
                }
                try {
                        DirContext ictx = new InitialDirContext();
                        Attributes attributes = ictx.getAttributes("dns:/" + website, new String[]{"MX"});
                        Attribute mxAttr = attributes.get("MX");

                        if (mxAttr != null) {
                                for (int i = 0; i < mxAttr.size(); i++) {
                                        String mxRecord = (String) mxAttr.get(i);
                                        dnsRecord.put("MX_Record_" + (i + 1), mxRecord);
                                }
                        } else {
                                System.out.println("No MX records found.");
                        }
                } catch (NamingException e) {
                        System.out.println("Error fetching MX records: " + e.getMessage());
                }

                for (Map.Entry<String, String> entry : dnsRecord.entrySet()) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());
                }
        }
}
