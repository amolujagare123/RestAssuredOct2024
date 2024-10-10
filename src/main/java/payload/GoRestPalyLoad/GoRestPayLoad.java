package payload.GoRestPalyLoad;

public class GoRestPayLoad {

    public static String getUpdatePayLoad(String name,String email,String gender,String status)
    {
        return "{\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"email\": \""+email+"\",\n" +
                "        \"gender\": \""+gender+"\",\n" +
                "        \"status\": \""+status+"\"\n" +
                "    }" ;
    }
}
