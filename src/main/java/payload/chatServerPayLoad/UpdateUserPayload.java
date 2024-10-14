package payload.chatServerPayLoad;

public class UpdateUserPayload {

    public static String getUpdateUserPayLoad()
    {
        return "{\n" +
                "\"username\": \"user_0005\", \n" +
                "\"password\": \"dvwSie1WEXNs\", \n" +
                "\"email\": \"user_0005@example.org\", \n" +
                "\"name\": \"John\",\n" +
                " \"surname\": \"Doe\", \n" +
                "\"chat_nickname\": \"JohnD_0005\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}\n";
    }

    public static String getUserPayLoad(String username,String password,String name,String surname,String email,String nickName)
    {
        return "{\n" +
                "\"username\": \""+username+"\", \n" +
                "\"password\": \""+password+"\", \n" +
                "\"email\": \""+email+"\", \n" +
                "\"name\": \""+name+"\",\n" +
                " \"surname\": \""+surname+"\", \n" +
                "\"chat_nickname\": \""+nickName+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}\n";
    }
}
