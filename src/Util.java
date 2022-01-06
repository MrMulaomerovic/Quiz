import java.sql.*;
import java.util.ArrayList;

public class Util {

    static Connection con;


    static Odgovor[] o = new Odgovor[100];
    static ArrayList<Pitanja> p = new ArrayList<>();
    static ArrayList<TacanOdgovor> to  = new ArrayList<>();



    public static void konektujSe(){

        //provera za drajver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver je uredu");
        } catch (ClassNotFoundException e) {
            System.out.println("driver nije uredu");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/quiz";
        String user = "root";
        String password = "root";

        try {
            con = DriverManager.getConnection(url,user,password);
            if (con!= null){
                System.out.println("konekcija uspesna");
            }else {
                System.out.println("konekcija bezuspesna");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Pitanja> pitaj(){
        String upit = "select * from pitanja";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(upit);
            ResultSet resultSet = preparedStatement.executeQuery(upit);

            for (int i = 0;resultSet.next() ; i++) {

                int id = resultSet.getInt("id_pitanja");
                String pitanje = resultSet.getString("pitanje");

                p.add(new Pitanja(id,pitanje));
            }

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    public static ArrayList<TacanOdgovor> tacno(){
        String upit = "select * from tacan_odgovor";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(upit);
            ResultSet resultSet = preparedStatement.executeQuery(upit);

            for (int i = 0; resultSet.next(); i++) {
             //   int id = resultSet.getInt("id_tacan_odgovor");
                char odgovor = resultSet.getString("tacan_odgovor").charAt(0);
                to.add(new TacanOdgovor(odgovor));
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return to;
    }

    public  static Odgovor[] odgovori() {
        String upit = "select * from ponudjeni_odgovori";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(upit);
            ResultSet resultSet = preparedStatement.executeQuery();

            for (int i = 0;resultSet.next(); i++) {
                int id = resultSet.getInt("id_ponudjeni_odgovori");
                String odgovorA = resultSet.getString("poljeA");
                String odgovorB = resultSet.getString("poljeB");
                String odgovorC = resultSet.getString("poljeC");
                String odgovorD = resultSet.getString("poljeD");

                o[i] =new Odgovor(odgovorA,odgovorB,odgovorC,odgovorD);
            }

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
