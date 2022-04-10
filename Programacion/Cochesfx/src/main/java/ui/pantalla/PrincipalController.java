package ui.pantalla;

import domain.modelo.Coche;
import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ui.common.Constantes;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class PrincipalController implements Initializable {

    private PrincipalViewModel viewModel;
    private final Stage stage;
    private double xOffset;
    private double yOffset;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private HBox windowHeader;

    @FXML
    private MFXFontIcon closeIcon;
    @FXML
    private MFXFontIcon minimizeIcon;
    @FXML
    private MFXFontIcon alwaysOnTopIcon;

    @FXML
    private Label mainText;

    @FXML
    private MFXTableView<Coche> tablaCoches;
    @FXML
    private MFXTableColumn<Coche> columnModelo;
    @FXML
    private MFXTableColumn<Coche> columnAnio;
    @FXML
    private MFXTableColumn<Coche> columnFecha;

    @FXML
    private Label elegirIdioma;
    @FXML
    private MFXLegacyComboBox<String> langugeSelector;

    @FXML
    private Label modeloObligatorio;
    @FXML
    private MFXTextField modeloTextField;
    @FXML
    private Label anoObligatorio;
    @FXML
    private MFXTextField anioTextField;
    @FXML
    private Label fechaAdquisicionObligatorio;
    @FXML
    private MFXDatePicker fechaTextField;

    @FXML
    private MFXButton addCoche;
    @FXML
    private MFXButton updateCoche;
    @FXML
    private MFXButton deleteCoche;

    public PrincipalController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResourceBundle bundle = getResourceBundle();

        closeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        minimizeIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ((Stage) rootPane.getScene().getWindow()).setIconified(true));
        alwaysOnTopIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            boolean newVal = !stage.isAlwaysOnTop();
            alwaysOnTopIcon.pseudoClassStateChanged(PseudoClass
                    .getPseudoClass(Constantes.ALWAYS_ON_TOP), newVal);
            stage.setAlwaysOnTop(newVal);
        });

        windowHeader.setOnMousePressed(event -> {
            xOffset = stage.getX() - event.getScreenX();
            yOffset = stage.getY() - event.getScreenY();
        });
        windowHeader.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + xOffset);
            stage.setY(event.getScreenY() + yOffset);
        });

        viewModel = new PrincipalViewModel();

        langugeSelector.getItems().addAll(Constantes.ESPANOL, Constantes.INGLES);
        langugeSelector.setValue(Constantes.ESPANOL);

        tablaCoches.getFilters().addAll(
                new StringFilter<>(bundle.getString(Constantes.MODELO), Coche::getModelo),
                new IntegerFilter<>(bundle.getString(Constantes.ANIO), Coche::getAnio)
        );

        columnModelo.setRowCellFactory(coche -> new MFXTableRowCell<>(Coche::getModelo));
        columnAnio.setRowCellFactory(coche -> new MFXTableRowCell<>(Coche::getAnio));
        columnFecha.setRowCellFactory(coche -> new MFXTableRowCell<>(Coche::getFechaAdquisicion));

        columnModelo.setComparator(Comparator.comparing(Coche::getModelo));
        columnAnio.setComparator(Comparator.comparingInt(Coche::getAnio));
        columnFecha.setComparator(Comparator.comparing(Coche::getFechaAdquisicion));

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
        ResourceBundle bundle = getResourceBundle();
        if (camposOk()) {
            String modelo = modeloTextField.getText();
            int anio = Integer.parseInt(anioTextField.getText());
            LocalDate fechaAdquisicion = fechaTextField.getValue();
            Coche coche = new Coche(modelo, anio, fechaAdquisicion);
            if (viewModel.addCoche(coche)) {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + modelo + Constantes.ESPACIO
                        + bundle.getString(Constantes.HA_SIDO_ANADIDO);
                mostrarAlertConfirmation(text);
            } else {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + modelo + Constantes.ESPACIO
                        + bundle.getString(Constantes.UTILIZA_ACTUALIZAR);
                mostrarAlertError(text);
            }
        } else {
            String text = bundle.getString(Constantes.NO_HAY_DATOS);
            mostrarAlertError(text);
        }
        clearTextFields();
    }

    @FXML
    private void updateCoche(ActionEvent actionEvent) {
        ResourceBundle bundle = getResourceBundle();
        if (camposOk()) {
            String modelo = modeloTextField.getText();
            int anio = Integer.parseInt(anioTextField.getText());
            LocalDate fechaAdquisicion = fechaTextField.getValue();
            Coche coche = new Coche(modelo, anio, fechaAdquisicion);
            if (viewModel.updateCoche(coche)) {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + modelo + Constantes.ESPACIO
                        + bundle.getString(Constantes.HA_SIDO_ACTUALIZADO);
                mostrarAlertConfirmation(text);
            } else {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + modelo + Constantes.ESPACIO
                        + bundle.getString(Constantes.ANADE_PRIMERO);
                mostrarAlertError(text);
            }
        } else {
            String text = bundle.getString(Constantes.NO_HAY_DATOS);
            mostrarAlertError(text);
        }
        clearTextFields();
    }

    @FXML
    private void deleteCoche(ActionEvent actionEvent) {
        ResourceBundle bundle = getResourceBundle();
        Optional<Coche> coche = tablaCoches.getSelectionModel().getSelection().values()
                .stream().findFirst();
        if (coche.isPresent()) {
            if (viewModel.removeCoche(coche.get())) {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + coche.get().getModelo() + Constantes.ESPACIO
                        + bundle.getString(Constantes.HA_SIDO_ELIMINADO);
                mostrarAlertConfirmation(text);
            } else {
                String text = bundle.getString(Constantes.MODELO_ESPACIO) + coche.get().getModelo() + Constantes.ESPACIO
                        + bundle.getString(Constantes.NO_HA_SIDO_ELIMINADO);
                mostrarAlertError(text);
            }
        } else {
            String text = bundle.getString(Constantes.NO_HAY_SELECCION);
            mostrarAlertError(text);
        }
        clearTextFields();
    }

    @FXML
    private void selectLanguage() {
        ResourceBundle bundle = getResourceBundle();
        mainText.setText(bundle.getString(Constantes.MAIN_TEXT));
        modeloTextField.setPromptText(bundle.getString(Constantes.MODELO));
        anioTextField.setPromptText(bundle.getString(Constantes.ANIO));
        fechaTextField.setPromptText(bundle.getString(Constantes.FECHA_ADQUISICION));
        addCoche.setText(bundle.getString(Constantes.ANADIR_COCHE));
        deleteCoche.setText(bundle.getString(Constantes.BORRAR_COCHE));
        updateCoche.setText(bundle.getString(Constantes.ACTUALIZAR_DATOS_COCHE));
        elegirIdioma.setText(bundle.getString(Constantes.ELEGIR_IDIOMA_LABEL));
        modeloObligatorio.setText(bundle.getString(Constantes.MODELO_OBLIGATORIO));
        anoObligatorio.setText(bundle.getString(Constantes.ANIO_OBLIGATORIO));
        fechaAdquisicionObligatorio.setText(bundle.getString(Constantes.FECHA_ADQUISICION_OBLIGATORIO));
        columnModelo.setText(bundle.getString(Constantes.MODELO));
        columnAnio.setText(bundle.getString(Constantes.ANIO));
        columnFecha.setText(bundle.getString(Constantes.FECHA_ADQUISICION));
        tablaCoches.getFilters().removeAll(tablaCoches.getFilters());
        tablaCoches.getFilters().addAll(
                new StringFilter<>(bundle.getString(Constantes.MODELO), Coche::getModelo),
                new IntegerFilter<>(bundle.getString(Constantes.ANIO), Coche::getAnio)
        );
    }

    private ResourceBundle getResourceBundle() {
        String idioma = langugeSelector.getSelectionModel().getSelectedItem();
        ResourceBundle bundle;
        if (idioma != null) {
            switch (idioma) {
                case Constantes.ESPANOL:
                    bundle = ResourceBundle.getBundle(Constantes.TEXTOS_UI, Locale.forLanguageTag(Constantes.ES_ES));
                    break;
                case Constantes.INGLES:
                    bundle = ResourceBundle.getBundle(Constantes.TEXTOS_UI, Locale.ENGLISH);
                    break;
                default:
                    bundle = ResourceBundle.getBundle(Constantes.TEXTOS_UI);
                    break;
            }
        } else {
            bundle = ResourceBundle.getBundle(Constantes.TEXTOS_UI);
        }
        return bundle;
    }

    private boolean camposOk() {
        String noData = Constantes.NO_DATA;
        String nombreMostrar = !modeloTextField.getText().isBlank() ? modeloTextField.getText() : noData;
        int anioMostrar = !anioTextField.getText().isBlank() ? Integer.parseInt(anioTextField.getText()) : 0;
        return !nombreMostrar.equals(noData)
                && anioMostrar != 0
                && fechaTextField.getValue() != null;
    }

    private void clearTextFields() {
        modeloTextField.clear();
        anioTextField.clear();
        fechaTextField.clear();
    }

    private void mostrarAlertConfirmation(String text) {
        ResourceBundle bundle = getResourceBundle();
        playSound(Constantes.CORRECTO_MP_3);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(bundle.getString(Constantes.CORRECTO));
        a.setHeaderText(bundle.getString(Constantes.CORRECTO));
        a.setContentText(text);
        a.showAndWait();
    }

    private void mostrarAlertError(String text) {
        ResourceBundle bundle = getResourceBundle();
        playSound(Constantes.INCORRECTO_MP_3);
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(bundle.getString(Constantes.INCORRECTO));
        a.setHeaderText(bundle.getString(Constantes.INCORRECTO));
        a.setContentText(text);
        a.showAndWait();
    }

    private void playSound(String path) {
        Media sound = new Media(Objects.requireNonNull(getClass().getResource(path)).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}
