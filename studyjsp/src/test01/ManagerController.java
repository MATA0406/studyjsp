package test01;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerController implements Initializable {

    //FXML UI
    @FXML
    TextField name;
    @FXML
    TextField jumin1;
    @FXML
    TextField jumin2;
    @FXML
    TextField tel2;
    @FXML
    TextField tel3;
    @FXML
    Button reg;
    @FXML
    Button ana;
    @FXML
    Button modify;
    @FXML
    Button delete;
    @FXML
    Button input;
    @FXML
    ListView<Client> clientList;
    ObservableList<Client> clients = FXCollections.observableArrayList();
    @FXML
    TextArea dataArea;
    @FXML
    ChoiceBox cb = new ChoiceBox();
    ObservableList<String> tel1 = FXCollections.observableArrayList();

    @FXML
    RadioButton men;
    @FXML
    RadioButton women;

    ToggleGroup gender;

    @FXML
    CheckBox hobby1;
    @FXML
    CheckBox hobby2;
    @FXML
    CheckBox hobby3;
    @FXML
    CheckBox hobby4;
    @FXML
    CheckBox hobby5;
    @FXML
    Label helplb;
    @FXML
    Label juminlb;


    //踰꾪듉 �긽�깭 愿�由�
    boolean state = false;
    //�엯�젰愿�由�
    boolean state1 = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataArea.setEditable(false);
        setButton(state);
        //choiceBox
        cb.setItems(FXCollections.observableArrayList("010", "02", "031"));
        cb.getSelectionModel().selectFirst();
        //gender
        gender = new ToggleGroup();
        men.setToggleGroup(gender);
        men.setUserData("�궓�옄");
        men.setSelected(true);
        women.setToggleGroup(gender);
        women.setUserData("�뿬�옄");

        //listView
        getListView();


        //pattern
        tel2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                String s = "";
                for (char c : newValue.toCharArray()) {
                    if (((int) c >= 48 && (int) c <= 57 || (int) c == 46)) {
                        if (s.length() < 4) {
                            s += c;
                        }
                    }
                }
                tel2.setText(s);
                if (s.length() == 4) {
                    tel3.requestFocus();
                }
            }
        });
        tel3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                String s = "";
                for (char c : newValue.toCharArray()) {
                    if (((int) c >= 48 && (int) c <= 57 || (int) c == 46)) {
                        if (s.length() < 4) {
                            s += c;
                        }
                    }
                }
                tel3.setText(s);
            }
        });
        jumin1.textProperty().addListener((observable, oldValue, newValue) -> {
            String s = "";
            for (char c : newValue.toCharArray()) {
                if (((int) c >= 48 && (int) c <= 57 || (int) c == 46)) {
                    if (s.length() < 6) {
                        s += c;
                    }
                }
            }
            jumin1.setText(s);
            if (s.length() == 6) {
                jumin2.requestFocus();
            }
        });
        jumin2.textProperty().addListener((observable, oldValue, newValue) -> {
            String s = "";
            for (char c : newValue.toCharArray()) {
                if (((int) c >= 48 && (int) c <= 57 || (int) c == 46)) {
                    if (s.length() < 7) {
                        s += c;
                    }
                }
            }
            jumin2.setText(s);
            if (s.length() == 7) {
                cb.requestFocus();
            }
        });

        //alert
        name.setOnKeyPressed(event -> helplb.setText(""));
        jumin1.setOnKeyPressed(event -> juminlb.setText(""));
    }

    //二쇰�쇰쾲�샇泥댄겕
    public int checkNum(String num) { // num �� �뱾�뼱�삤�뒗 二쇰�쇰쾲�샇
        StringBuilder sb = new StringBuilder(num);
        int x = 0;
        float hap = 0.f;
        float temp = 0.f;
        float total1 = 0.f;
        float cre = 2.f;

        for (int i = 0; i < sb.length() - 1; i++) {
            if (cre == 10.f) cre = 2.f;
            hap += (sb.codePointAt(i) - 48) * cre;
            cre++;
        }
        temp = 11.f * (int) (hap / 11.f) + 11.f - hap;
        total1 = temp - 10.f * (int) (temp / 10.f);

        if (total1 != sb.codePointAt(sb.length() - 1) - 48) { //二쇰�쇰쾲�샇 13踰덉㎏ �옄由ъ� 媛숈�吏�.?
            return x;
        }
        x = 1;
        return x;
    }
    //踰꾪듉 �긽�깭愿�由� state 媛� false �씪�븣 �벑濡앸쭔 �솢�꽦
    public void setButton(boolean state) {
        reg.setDisable(state);
        delete.setDisable(!state);
        ana.setDisable(!state);
        modify.setDisable(!state);
        input.setDisable(!state);
    }
    //�벑濡�
    public void register() {
        System.out.println(checkNull());
        if (checkNull()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("�엯 �젰 �젙 蹂� 遺� 議�");
            alert.setContentText("鍮좎쭚�뾾�씠 �엯�젰�빐二쇱꽭�슂 !");
            alert.showAndWait();
            return;
        }

        String nameVal = name.getText().trim(); //�씠由�
        //�씠由� �솗�씤
        String pattern = "^[媛�-�옡]*$";
        boolean i = Pattern.matches(pattern, nameVal);
        if (i) {
            helplb.setText("");
        } else {
            helplb.setText("�옒紐삳맂 �삎�떇�쓽 �엯�젰�엯�땲�떎.");
            name.requestFocus();
            return;
        }
        String juminVal = jumin1.getText().trim() + jumin2.getText().trim(); //二쇰�쇰쾲�샇
        //二쇰�쇰쾲�샇 �솗�씤
        int r = checkNum(juminVal);
        System.out.println(r);
        if (r != 1) {
            juminlb.setText("�옒紐삳맂 二쇰�쇰쾲�샇 �엯�땲�떎.");
            jumin1.requestFocus();
            return;
        }
        StringBuffer telStr = new StringBuffer();
        String tel1Val = cb.getSelectionModel().getSelectedItem().toString();
        telStr.append(tel1Val + "-" + tel2.getText().trim() + "-" + tel3.getText().trim());//�쟾�솕踰덊샇
        String genderVal = gender.getSelectedToggle().getUserData().toString();//�꽦蹂�
        //hobby
        StringBuffer hobbyVal = new StringBuffer();
        if (hobby1.isSelected()) {
            hobbyVal.append(hobby1.getText() + ",");
        }
        if (hobby2.isSelected()) {
            hobbyVal.append(hobby2.getText() + ",");
        }
        if (hobby3.isSelected()) {
            hobbyVal.append(hobby3.getText() + ",");
        }
        if (hobby4.isSelected()) {
            hobbyVal.append(hobby4.getText() + ",");
        }
        if (hobby5.isSelected()) {
            hobbyVal.append(hobby5.getText() + ",");
        }
        if (hobbyVal.length() == 0) {
            hobbyVal.append("0");
        }

        ConnUtil connUtil = ConnUtil.getInstatnce();
        int x = connUtil.InsertData(nameVal, juminVal, telStr, genderVal, hobbyVal);
        if (x == 1) {
            System.out.println("�벑濡앹꽦怨�");
            alertData("�벑 濡� �셿 猷� ");
        }else if(x == -1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("以� 蹂� �맂 �엯 �젰");
            alert.setContentText("�씠誘� 議댁옱�븯�뒗 �쉶�썝�젙蹂댁엯�땲�떎 !");
            alert.showAndWait();
            alertData("�벑 濡� �떎 �뙣 ");
            return;
        }
        getListView();
        setButton(true);
        clear(state1);

        //System.out.println(nameVal+","+juminVal+","+tel1Val.toString());


    }
    //ListView
    public void getListView() {
        ConnUtil conn = ConnUtil.getInstatnce();
        clients = conn.getList();
        clientList.setItems(clients);
    }
    //clear �궡�슜
    public void clear(boolean state) {
        juminlb.setText("");
        helplb.setText("");
        name.clear();
        name.setDisable(state);
        jumin1.clear();
        jumin1.setDisable(state);
        jumin2.clear();
        jumin2.setDisable(state);

        men.setDisable(state);
        women.setDisable(state);

        tel2.clear();
        tel2.setDisable(state);
        tel3.clear();
        tel3.setDisable(state);

        hobby1.setSelected(false);
        hobby2.setSelected(false);
        hobby3.setSelected(false);
        hobby4.setSelected(false);
        hobby5.setSelected(false);

        hobby1.setDisable(state);
        hobby2.setDisable(state);
        hobby3.setDisable(state);
        hobby4.setDisable(state);
        hobby5.setDisable(state);

        cb.setDisable(state);
    }
    //�궡�슜 媛��졇�삤湲�
    public void getClientData() {
        if(clients.isEmpty()){
            return;
        }
        clear(true);
        setButton(true);
        Client c = clientList.getSelectionModel().getSelectedItem();
        name.setText(c.getName());

        StringBuffer sbr = new StringBuffer(c.getJuminNum());
        jumin1.setText(sbr.substring(0, 6));
        jumin2.setText(sbr.substring(6, sbr.length()));

        String telAll = c.getTel();
        StringTokenizer strtoken = new StringTokenizer(telAll, "-");
        int count = strtoken.countTokens();
        String tel1Val = "";
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                tel1Val = strtoken.nextToken();
            }
            if (i == 1) {
                tel2.setText(strtoken.nextToken());
            }
            if (i == 2) {
                tel3.setText(strtoken.nextToken());
            }
        }
        tel1.clear();
        tel1.add(tel1Val);
        //cb.setItems(tel1);
        cb.setValue(tel1Val);

        String genderDB = c.getGender();
        if (genderDB.equals("�궓�옄")) {
            men.setSelected(true);
        } else {
            women.setSelected(true);
        }

        //hobby
        StringTokenizer strToken2 = new StringTokenizer(c.getHobby(), ",");
        int count2 = strToken2.countTokens();
        String ho = "";
        for (int j = 0; j < count2; j++) {
            ho = strToken2.nextToken();
            if (ho.equals("�슫�룞")) {
                hobby1.setSelected(true);
            }
            if (ho.equals("�룆�꽌")) {
                hobby2.setSelected(true);
            }
            if (ho.equals("�쁺�솕")) {
                hobby3.setSelected(true);
            }
            if (ho.equals("�쓬�븙")) {
                hobby4.setSelected(true);
            }
            if (ho.equals("�뙆�떚")) {
                hobby5.setSelected(true);
            }
        }

    }
    //�벑濡� Mapping
    @FXML
    public void regBtnOnClick(ActionEvent event) {
        register();
    }
    //�엯�젰 Mapping
    @FXML
    public void inputBtnOnClick(ActionEvent event) {
        clear(false);
        setButton(false);
    }
    //紐⑸줉�쓽 �씠由� �겢由��떆
    @FXML
    public void selectedName(ActionEvent event) {
        getClientData();
    }
    //�닔�젙
    @FXML
    public void modifyData(ActionEvent event) {
        //1. �쟾�솕踰덊샇 , 痍⑤�� �뿴湲�
        cb.setDisable(false);
        tel2.setDisable(false);
        tel3.setDisable(false);
        hobby1.setDisable(false);
        hobby2.setDisable(false);
        hobby3.setDisable(false);
        hobby4.setDisable(false);
        hobby5.setDisable(false);


        //2.寃쎄퀬李� �쓣�슦湲�
        if (modify.getText().equals("�닔�젙�셿猷�")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("�쉶 �썝 �젙 蹂� �닔 �젙 ");
            alert.setContentText("�젙留먮줈 蹂�寃쏀븯�떆寃좎뒿�땲源� ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                String juminVal = jumin1.getText().trim() + jumin2.getText().trim(); //二쇰�쇰쾲�샇
                StringBuffer hobbyVal = new StringBuffer();
                if (hobby1.isSelected()) {
                    hobbyVal.append(hobby1.getText() + ",");
                }
                if (hobby2.isSelected()) {
                    hobbyVal.append(hobby2.getText() + ",");
                }
                if (hobby3.isSelected()) {
                    hobbyVal.append(hobby3.getText() + ",");
                }
                if (hobby4.isSelected()) {
                    hobbyVal.append(hobby4.getText() + ",");
                }
                if (hobby5.isSelected()) {
                    hobbyVal.append(hobby5.getText() + ",");
                }
                if (hobbyVal.length() == 0) {
                    hobbyVal.append("0");
                }
                StringBuffer telStr = new StringBuffer();
                String tel1Val = cb.getSelectionModel().getSelectedItem().toString();
                telStr.append(tel1Val + "-" + tel2.getText().trim() + "-" + tel3.getText().trim());//�쟾�솕踰덊샇
                ConnUtil c = ConnUtil.getInstatnce();
                int x = c.ModifyData(telStr, hobbyVal, juminVal);

                if (x == 1) {

                    System.out.println("�뾽�뜲�씠�듃 泥섎━�셿猷�");
                }

            } else {
                // ... user chose CANCEL or closed the dialog
                alert.close();
            }
        }


        //3. �닔�젙�뀓�뒪�듃 諛붽씀湲�
        if (modify.getText().equals("�닔�젙")) {
            modify.setText("�닔�젙�셿猷�");
        } else {
            modify.setText("�닔�젙");
        }


    }
    //�궘�젣
    @FXML
    public void deleteData(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("�쉶 �썝 �젙 蹂� �궘 �젣 ");
        alert.setContentText("�젙留먮줈 �궘�젣�븯�떆寃좎뒿�땲源� ?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            ConnUtil c = ConnUtil.getInstatnce();
            String juminVal = jumin1.getText().trim() + jumin2.getText().trim(); //二쇰�쇰쾲�샇
            c.deleteData(juminVal);
            clients = c.getList();
            clientList.setItems(clients);
            clear(false);
        } else {
            alert.close();
        }

    }
    //null �솗�씤
    public boolean checkNull() {
        String checkName = "";
        checkName = name.getText();
        String checkJumin1 = "";
        checkJumin1 = jumin1.getText();
        String checkJumin2 = jumin2.getText();
        String telCheck2 = tel2.getText();
        String telCheck3 = tel3.getText();
        String telCheck1 = "";
        if(!cb.getSelectionModel().isEmpty()) {
            telCheck1 = cb.getSelectionModel().getSelectedItem().toString();
        }

        if (checkName == null || checkJumin1 == null || checkJumin2 == null ||
                telCheck2 == null || telCheck2 == null || telCheck3 == null ||
                telCheck1 == null ||
                checkName == "" || checkJumin1 == "" || checkJumin2 == "" ||
                telCheck2 == "" || telCheck2 == "" || telCheck3 == "" ||
                telCheck1 == "") {
            return true;
        }
        return false;

    }
    //textArea 湲� 異붽��븯湲�
    public void alertData(String text){
        dataArea.appendText("\n");
        dataArea.appendText("\t"+text+"\n");
    }
    //�젙蹂대텇�꽍
    public void analaysisData(String jumin){
        StringBuilder sb = new StringBuilder(13);
        sb.append(jumin);

        int year = 1900;
        switch(sb.codePointAt(6)-48){
            case 9 :
            case 0 : year = 1800; break;
            case 3 :
            case 4 : year = 2000; break;
            default : year = 1900; break;
        }
        year = year + (sb.codePointAt(0)-48)*10 + (sb.codePointAt(1)-48);
        int month = (sb.codePointAt(2)-48)*10 + (sb.codePointAt(3)-48);
        int day = (sb.codePointAt(4)-48)*10 + (sb.codePointAt(5)-48);
        dataArea.appendText("----------------------------------------------------------------");
        dataArea.appendText("\n\n"+"\t 遺� �꽍 寃� 怨� ");

        dataArea.appendText("\n\n\t�깮�뀈�썡�씪 : " + year + "�뀈 " + month + "�썡 " + day + "�씪�깮");
        dataArea.appendText("\n\n\t�굹    �씠 : " + (2017-year+1) + "�꽭");
        dataArea.appendText("\n\n\t�꽦    蹂� : " + ((sb.codePointAt(6)-48)%2==0 ? "�뿬�꽦" : "�궓�꽦"));

        switch(sb.codePointAt(7)-48){
            case 0 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : �꽌�슱"); break;
            case 1 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 寃쎄린"); break;
            case 2 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 媛뺤썝"); break;
            case 3 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 異⑸턿"); break;
            case 4 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 異⑸궓"); break;
            case 5 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : �쟾遺�"); break;
            case 6 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : �쟾�궓"); break;
            case 7 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 寃쎈턿"); break;
            case 8 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : 寃쎈궓"); break;
            case 9 : dataArea.appendText("\n\n\t異쒖깮吏��뿭 : �젣二�"); break;
        }

        dataArea.appendText("\n\n----------------------------------------------------------------");
    }
    //[遺꾩꽍] click �떆
    @FXML
    public void anaBtnOnclick(){
        String juminVal = jumin1.getText().trim() + jumin2.getText().trim(); //二쇰�쇰쾲�샇
        analaysisData(juminVal);
    }
}
