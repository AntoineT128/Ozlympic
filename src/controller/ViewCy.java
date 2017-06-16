package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import model.Message;
import model.SQLHelper;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ViewCy implements Initializable {

    public static ObservableList<Message> getList() {
        ObservableList<Message> list = FXCollections.observableArrayList();
        SQLHelper sp = new SQLHelper();
        try {
            String sql = "select * from participants where Type like 'cyclist' or  Type like 'super';";
            ResultSet rs = sp.query(sql);

            while (rs.next()) {
                list.add(new Message(rs.getString("ID"), rs.getString("Type"), rs.getString("Name"), rs.getInt("Age"),
                        rs.getString("State")));
            }
        } catch (Exception e2) {
            System.err.println(e2);
        }
        return list;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
