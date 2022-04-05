package ui.controllers;

import domain.modelo.Coche;
import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import ui.common.Constantes;
import ui.viewmodel.PrincipalViewModel;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


    private final String modeloDefecto = Constantes.NO_DATA;

    private PrincipalViewModel viewModel;

    @FXML
    private MFXTextField modeloTextField;
    @FXML
    private MFXTextField anioTextField;
    @FXML
    private MFXDatePicker fechaTextField;

    @FXML
    private MFXTableView<Coche> tablaCoches;
    @FXML
    private MFXTableColumn<Coche> columnModelo;
    @FXML
    private MFXTableColumn<Coche> columnAnio;
    @FXML
    private MFXTableColumn<Coche> columnFecha;

    public PrincipalController() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        viewModel = new PrincipalViewModel();

        tablaCoches.getFilters().addAll(
                new StringFilter<>(Constantes.MODELO, Coche::getModelo),
                new IntegerFilter<>(Constantes.ANOS, Coche::getAnio)
        );

        columnModelo.setRowCellFactory(person -> new MFXTableRowCell<>(Coche::getModelo));
        columnAnio.setRowCellFactory(person -> new MFXTableRowCell<>(Coche::getAnio));
        columnFecha.setRowCellFactory(person -> new MFXTableRowCell<>(Coche::getFechaAdquisicion));

        tablaCoches.getSelectionModel().setAllowsMultipleSelection(false);
        tablaCoches.setItems(viewModel.getCoches());

        tablaCoches.getSelectionModel().selectionProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                newValue.values().stream().findFirst().ifPresent(coche -> {
                    modeloTextField.setText(coche.getModelo());
                    anioTextField.setText(coche.getAnio().toString());
                    fechaTextField.setValue(coche.getFechaAdquisicion());
                });
            }
        });
    }

    @FXML
    private void addCoche() {

        String nombreMostrar = !modeloTextField.getText().isBlank()
                ? modeloTextField.getText() : modeloDefecto;
        int anioMostrar = anioTextField.getText().isBlank() ? 0 : Integer.parseInt(anioTextField.getText());

        if (!nombreMostrar.equals(modeloDefecto)
                && anioMostrar != 0
                && fechaTextField.getValue() != null) {
            Coche coche = new Coche(nombreMostrar, anioMostrar, fechaTextField.getValue());
            if (viewModel.addCoche(coche)) {
                playSound(Constantes.CORRECTO_MP_3);
                String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.HA_SIDO_ANADIDO;
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText(text);
                a.showAndWait();
            } else {
                playSound(Constantes.INCORRECTO_MP_3);
                String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.YA_EXISTE_UTILIZA_LA_FUNCION_ACTUALIZAR;
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(text);
                a.showAndWait();
            }
        } else {
            playSound(Constantes.INCORRECTO_MP_3);
            String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.NO_HA_SIDO_ANADIDO;
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(text);
            a.showAndWait();
        }
    }

    @FXML
    private void updateCoche(ActionEvent actionEvent) {

        String nombreMostrar = !modeloTextField.getText().isBlank()
                ? modeloTextField.getText() : modeloDefecto;
        int anioMostrar = anioTextField.getText().isBlank() ? 0 : Integer.parseInt(anioTextField.getText());

        if (!nombreMostrar.equals(modeloDefecto)
                && anioMostrar != 0
                && fechaTextField.getValue() != null) {
            Coche coche = new Coche(nombreMostrar, anioMostrar, fechaTextField.getValue());
            if (viewModel.updateCoche(coche)) {
                playSound(Constantes.CORRECTO_MP_3);
                String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.HA_SIDO_ACTUALIZADO;
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText(text);
                a.showAndWait();
            } else {
                playSound(Constantes.INCORRECTO_MP_3);
                String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.ANADE_EL_COCHE_A_LA_BASE_DE_DATOS;
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(text);
                a.showAndWait();
            }
        } else {
            playSound(Constantes.INCORRECTO_MP_3);
            String text = Constantes.ESPACIO_MODELO + nombreMostrar + Constantes.NO_SE_HAN_ESPECIFICADO_TODOS_LOS_DATOS;
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(text);
            a.showAndWait();
        }
    }

    @FXML
    private void deleteCoche(ActionEvent actionEvent) {
        Optional<Coche> coche = tablaCoches.getSelectionModel().getSelection().values()
                .stream().findFirst();
        if (coche.isPresent()) {
            if (viewModel.removeCoche(coche.get())) {
                playSound(Constantes.CORRECTO_MP_3);
                String text = "Modelo " + coche.get().getModelo() + Constantes.HA_SIDO_ELIMINADO;
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(text);
                a.showAndWait();
            } else {
                playSound(Constantes.INCORRECTO_MP_3);
                String text = "Modelo " + coche.get().getModelo() + Constantes.NO_HA_SIDO_ELIMINADO;
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(text);
                a.showAndWait();
            }
        } else {
            playSound(Constantes.INCORRECTO_MP_3);
            String text = Constantes.SELECCIONA_UN_MODELO_PARA_PODER_BORRARLO;
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(text);
            a.showAndWait();
        }
    }

    private void playSound(String path) {
        Media sound = new Media(getClass().getClassLoader().getResource(path).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
