<%@ page session="false"%><%@ page contentType="text/plain;charset=UTF-8" language="java" %>
<%@ page import="apollo.datastore.TimeZoneFactoryAdapter" %>
<%@ page import="apollo.datastore.UserFactoryAdapter" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>
<%
String timeZoneEntriesFile = getServletContext().getRealPath("/WEB-INF/time-zone-entries.txt");
String delimiter = ";";
BufferedReader br = null;
String line = null;
try {
    br = new BufferedReader(new FileReader(timeZoneEntriesFile));
    while((line = br.readLine()) != null) {
        String[] timeZoneEntry = line.split(delimiter);
        if(timeZoneEntry.length >= 2) {
            TimeZoneFactoryAdapter.getInstance().tAdd(timeZoneEntry[1], timeZoneEntry[2], Long.parseLong(timeZoneEntry[0]));
            out.print(timeZoneEntry[0] + ";" + timeZoneEntry[1] + ";" + timeZoneEntry[2] + "\n");
        }
    }
    out.print("\n\n");
}
catch(FileNotFoundException e) {
    e.printStackTrace();
}
catch(IOException e) {
    e.printStackTrace();
}
finally {
    if(br != null) {
        try {
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

String userId = "admin", password = "admin", emailAddress = "kerafill1116@gmail.com";
// using actual values because JSP cannot resolve package if class of same name exists
// error to cannot resolve apollo.datastore.user.*
UserFactoryAdapter.getInstance().tAddWithPermissions(userId, password, emailAddress, null,
                                       (long)((1 << 23) - 1), (long)((1 << 4) - 1), (long)((1 << 4) - 1),
                                       (long)((1 << 19) - 1), (long)((1 << 4) - 1), (long)((1 << 4) - 1));
out.print(userId + ";" + password + ";" + emailAddress + "\n");
out.print("admin permissions\n");
out.print("user permissions\n");
%>
