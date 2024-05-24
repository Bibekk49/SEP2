package sem2.sep2.client.view.reserveView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sem2.sep2.client.core.ViewHandler;
import sem2.sep2.client.core.ViewModelFactory;
import sem2.sep2.client.view.ViewController;
import sem2.sep2.shared.util.room.Room;

import java.awt.*;
import java.net.URI;
import java.time.LocalDate;

public class ReserveViewController implements ViewController {
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private TableView<Room> tableView;
    @FXML
    private TableColumn<Room, Integer> roomNumberColumn;
    @FXML
    private TableColumn<Room, Double> pricePerDayColumn;
    @FXML
    private ChoiceBox roomType;
    @FXML
    private Text errorText;


    private ViewHandler viewHandler;
    private ReserveViewModel reserveViewModel;
    private Region root;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory, Region root) {
        this.viewHandler = viewHandler;
        this.reserveViewModel = viewModelFactory.getReserveViewModel();
        this.root = root;
        bindProperties();
    }

    private void bindProperties() {
        startDatePicker.valueProperty().bindBidirectional(reserveViewModel.getCheckInDatePicker());
        endDatePicker.valueProperty().bindBidirectional(reserveViewModel.getCheckOutDatePicker());
        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(LocalDate.now().plusDays(1));
        tableView.setItems(reserveViewModel.getAvailableRooms());
        roomNumberColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        pricePerDayColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        roomType.setItems(reserveViewModel.getRoomTypes());
        roomType.valueProperty().bindBidirectional(reserveViewModel.getRoomType());
        errorText.textProperty().bind(reserveViewModel.getErrorText());
    }

    @Override
    public void reset() {

    }

    public void searchButtonPressed() {
        boolean success = reserveViewModel.searchAvailableRooms();
        if (!success) {
            errorText.setFill(Color.RED);
        }
    }

    public void contactUsPressed(ActionEvent event) throws Exception {
        viewHandler.openContactView();
    }

    public void aboutPressed(ActionEvent event) throws Exception {
        String url = "http://royalhotel2.durablesites.com";
        try {
            URI uri = new URI(url);
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeProfilePressed(ActionEvent actionEvent) {
        viewHandler.openProfileView();
    }

    public void bookingHistoryPressed(ActionEvent actionEvent) {
        viewHandler.openHistoryView();
    }

    public void reserve(ActionEvent actionEvent) {
        reserveViewModel.Reserve(viewHandler.getGuest());
    }
}
