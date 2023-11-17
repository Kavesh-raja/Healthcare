import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

interface application_form {
    String Basic_details(String name, int age, String num, String mail, String address);

    String Consul_Doc();

    String Consultation_Fee();

}

class SMS {
    public void sent_sms(String mobno) {

        try {
            // Construct data
            String apiKey = "apikey=" + "NTI0MjQ2NGY2MjQyNmE2MjY4NzQ3MjUwNjE0YzRhMzU=";
            String message = "&message=" + "Hi there, thank you for sending your first test message from Textlocal. See how you can send effective SMS campaigns here: https://tx.gl/r/2nGVj/";
            String sender = "&sender=" + "600010";
            String numbers = "&numbers=" + mobno;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println(stringBuffer.toString());
            rd.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Doc_info {
    public String Doc_Name(String Consult_condition) {
        String nam = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kavesh\\Desktop\\untitled\\src\\doc.json"));
            Gson gson = new Gson();
            JsonObject countryObj = gson.fromJson(br, JsonObject.class);
            String Doc_name = countryObj.get(Consult_condition).toString();

            nam = Doc_name;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return nam;
    }

    public String Doc_Roomno(String roomno) {
        String rno = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kavesh\\Desktop\\untitled\\src\\doc.json"));
            Gson gson = new Gson();
            JsonObject countryObj = gson.fromJson(br, JsonObject.class);
            String Doc_name = countryObj.get(roomno).toString();

            rno = Doc_name;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rno;
    }

    public String Doc_Fee(String fee) {
        String doc_fee = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kavesh\\Desktop\\untitled\\src\\doc.json"));
            Gson gson = new Gson();
            JsonObject countryObj = gson.fromJson(br, JsonObject.class);
            String Doc_name = countryObj.get(fee).toString();

            doc_fee = Doc_name;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc_fee;
    }

}

class Neuro implements application_form {

    public String Basic_details(String name, int age, String num, String mail, String address) {

        String info = "Patient Details" + '\n' + "Patient Name: " + name + '\n' + "Patient Age: " + age + '\n' + "Patient mobile number: " + num + '\n' +
                "Patient email id:" + mail + '\n' + "Patient Residential address: " + address;
        return info;
    }

    public String Consul_Doc() {
        Doc_info obj1 = new Doc_info();
        String Doc_name1 = obj1.Doc_Name("Neuro normal");
        String Roomno1 = obj1.Doc_Roomno("Neuro normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name1 + ", Neuro Specialist" + '\n' + "Room no:" + Roomno1 + '\n' + "Condition: Normal";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj1 = new Doc_info();
        String FEE1 = obj1.Doc_Roomno("Neuro normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + FEE1;
        return Con_fee;
    }
}

class Emergency_Nuro extends Neuro {
    public String Consul_Doc() {
        Doc_info obj2 = new Doc_info();
        String Doc_name2 = obj2.Doc_Name("Neuro emergency");
        String Room2 = obj2.Doc_Name("Neuro emergency roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name2 + ", Neuro Specialist" + '\n' + "Room no:" + Room2 + '\n' + "Condition: Emergency";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj2 = new Doc_info();
        String FEE2 = obj2.Doc_Name("Neuro emergency fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + FEE2;
        return Con_fee;
    }

}

class Cardio implements application_form {

    public String Basic_details(String name, int age, String num, String mail, String address) {

        String info = "Patient Details" + '\n' + "Patient Name: " + name + '\n' + "Patient Age: " + age + '\n' + "Patient mobile number: " + num + '\n' +
                "Patient email id:" + mail + '\n' + "Patient Residential address: " + address;
        return info;
    }

    public String Consul_Doc() {
        Doc_info obj3 = new Doc_info();
        String Doc_name3 = obj3.Doc_Name("Cardio normal");
        String Room3 = obj3.Doc_Name("Cardio normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name3 + ", Cardio Specialist" + '\n' + "Room no:" + Room3 + '\n' + "Condition: Normal";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj3 = new Doc_info();
        String FEE3 = obj3.Doc_Name("Cardio normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + FEE3;
        return Con_fee;
    }
}

class Emergency_Cardio extends Neuro {
    public String Consul_Doc() {
        Doc_info obj4 = new Doc_info();
        String Doc_name4 = obj4.Doc_Name("Cardio emergency");
        String Room4 = obj4.Doc_Name("Cardio emergency roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name4 + ", Cardio Specialist " + '\n' + "Room no: " + Room4 + '\n' + "Condition: Emergency";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj4 = new Doc_info();
        String Fee4 = obj4.Doc_Name("Cardio emergency fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + Fee4;
        return Con_fee;
    }

}

class Gyneco implements application_form {

    public String Basic_details(String name, int age, String num, String mail, String address) {

        String info = "Patient Details" + '\n' + "Patient Name: " + name + '\n' + "Patient Age: " + age + '\n' + "Patient mobile number: " + num + '\n' +
                "Patient email id:" + mail + '\n' + "Patient Residential address: " + address;
        return info;
    }

    public String Consul_Doc() {
        Doc_info obj5 = new Doc_info();
        String Doc_name5 = obj5.Doc_Name("Gyneco normal");
        String Room5 = obj5.Doc_Name("Gyneco normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name5 + ", Sex doctor" + '\n' + "Room no:" + Room5 + '\n' + "Condition: Normal";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj5 = new Doc_info();
        String Fee5 = obj5.Doc_Name("Gyneco normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + Fee5;
        return Con_fee;
    }
}

class Emergency_Gyneco extends Neuro {
    public String Consul_Doc() {
        Doc_info obj6 = new Doc_info();
        String Doc_name6 = obj6.Doc_Name("Neuro normal");
        String Room6 = obj6.Doc_Name("Neuro normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name6 + ",Gynecology specialist " + '\n' + "Room no: " + Room6 + '\n' + "Condition: Emergency";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj6 = new Doc_info();
        String Fee6 = obj6.Doc_Name("Neuro normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + Fee6;
        return Con_fee;
    }

}

class Pyscho implements application_form {

    public String Basic_details(String name, int age, String num, String mail, String address) {

        String info = "Patient Details" + '\n' + "Patient Name: " + name + '\n' + "Patient Age: " + age + '\n' + "Patient mobile number: " + num + '\n' +
                "Patient email id:" + mail + '\n' + "Patient Residential address: " + address;
        return info;
    }

    public String Consul_Doc() {
        Doc_info obj7 = new Doc_info();
        String Doc_name7 = obj7.Doc_Name("Neuro normal");
        String Room7 = obj7.Doc_Name("Neuro normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name7 + ", psychiatrist" + '\n' + "Room no: " + Room7 + '\n' + "Condition: Normal";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj7 = new Doc_info();
        String Fee7 = obj7.Doc_Name("Neuro normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + Fee7;
        return Con_fee;
    }
}

class Emergency_Pyscho extends Neuro {
    public String Consul_Doc() {
        Doc_info obj8 = new Doc_info();
        String Doc_name8 = obj8.Doc_Name("Neuro normal");
        String Room8 = obj8.Doc_Name("Neuro normal roomno");
        String Doc = "Doctor Details" + '\n' + "Consulting Doctor:" + Doc_name8 + ", psychiatrist " + '\n' + "Room no: " + Room8 + '\n' + "Condition: Emergency";
        return Doc;
    }

    public String Consultation_Fee() {
        Doc_info obj8 = new Doc_info();
        String Fee8 = obj8.Doc_Name("Neuro normal fee");
        String Con_fee = "Fee Details" + '\n' + "Rs" + Fee8;
        return Con_fee;
    }

}

public class healthcare {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Your Name:");
        String p_name = inp.nextLine();
        System.out.println("Enter your Age:");
        int p_age = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter your Mobile number:");
        String p_num = inp.nextLine();
        System.out.println("Enter your mail id:");
        String p_mail = inp.nextLine();
        System.out.println("Enter your Address:");
        String p_add = inp.nextLine();
        System.out.println("Specify your Consultation(Neuro/Cardio/Gyneco/Pyscho):");
        String p_problem = inp.nextLine();
        System.out.println("Is it emergency/normal:");
        String p_condition = inp.nextLine();
        SMS obj = new SMS();

        if (p_problem.equals("Neuro") && p_condition.equals("normal")) {
            application_form app1 = new Neuro();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);

        } else if (p_problem.equals("Neuro") && p_condition.equals("emergency")) {
            application_form app1 = new Emergency_Nuro();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else if (p_problem.equals("Cardio") && p_condition.equals("normal")) {
            application_form app1 = new Cardio();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else if (p_problem.equals("Cardio") && p_condition.equals("emergency")) {
            application_form app1 = new Emergency_Cardio();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else if (p_problem.equals("Gyneco") && p_condition.equals("normal")) {
            application_form app1 = new Gyneco();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);

        } else if (p_problem.equals("Gyneco") && p_condition.equals("emergency")) {
            application_form app1 = new Emergency_Gyneco();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else if (p_problem.equals("Pyscho") && p_condition.equals("normal")) {
            application_form app1 = new Pyscho();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else if (p_problem.equals("Pyscho") && p_condition.equals("emergency")) {
            application_form app1 = new Emergency_Pyscho();
            String fina = app1.Basic_details(p_name, p_age, p_num, p_mail, p_add) + '\n' + app1.Consul_Doc() + '\n' + app1.Consultation_Fee();
            System.out.println(fina);
            obj.sent_sms(p_num);
        } else {
            System.out.println("Invalid input...");
        }


    }
}
